<%@ page language="java"  pageEncoding="utf-8" %>

<table id="guruTable">
    <thead>
        <tr>
            <th data-options="field:'cbox',checkbox:true"></th>
            <th data-options="field:'id',hidden:true">id</th>
            <th data-options="field:'name',width:1,align:'center' ">姓名</th>
            <th data-options="field:'dharmaName',width:1,align:'center' ">法号</th>
            <th data-options="field:'phoneNum',width:1,align:'center' ">手机号</th>
            <th data-options="field:'status',width:1,align:'center',editor:{type:'validatebox',options:{required:true}}">展示状态(Y/N)</th>

        </tr>
    </thead>
</table>

<div id="guruTb">
    <a id="guruLoadBtn">刷新</a>
    <a id="addGuruBtn">添加</a>
    <a id="saveGuruBtn">保存</a>
    <a id="delGuruBtn">删除</a>
</div>

<div id="addGuruDialog">大师添加</div>

<script type="text/javascript">
    $(function(){
        //初始化数据表格
        $("#guruTable").edatagrid({
            title: "大师",
            url: "${pageContext.request.contextPath}/guru/showByPage.do",
            saveUrl: "${pageContext.request.contextPath}/guru/upload.do",
            updateUrl: "${pageContext.request.contextPath}/guru/edit.do",
            fit: true,
            fitColumns: true,
            autoSave: true,
            editable: true,
            toolbar:"#guruTb",
            pagination: true,
            pageSize: 3,
            pageList: [3,5,10,15],
            checkOnSelect: false,
            view: detailview,
            detailFormatter: function(rowIndex, rowData){
                return '<table><tr>' +
                    '<td rowspan=2 style="border:0"><img src="${pageContext.request.contextPath}' + rowData.photoImg + '" style="height:50px;"></td>' +
                    '</tr></table>';
            }
        });

        //初始化添加按钮
        $("#addGuruBtn").linkbutton({
            iconCls: "icon-bell_add",
            onClick: function () {
                $("#addGuruDialog").dialog("open");
            }
        });
        //初始化刷新按钮
         $("#guruLoadBtn").linkbutton({
             iconCls: "icon-bell",
             onClick: function () {
                 $("#guruTable").datagrid("load");
             }
         });
         //初始化保存按钮
        $("#saveGuruBtn").linkbutton({
            iconCls: "icon-bell",
            onClick:function(){
                $("#guruTable").edatagrid("saveRow");
            }
        })
         //初始化批量删除按钮
        $("#delGuruBtn").linkbutton({
             iconCls: "icon-bell_delete",
             onClick: function () {
                 var selrows=$('#guruTable').datagrid("getSelections");
                 if(selrows.length==0){
                     alert("请至少选择一行数据");
                     return false;
                 }
                 $.messager.confirm("确认","您确认想要删除记录吗？",
                     function(r){
                         if (r){
                             var ids=[];
                             for(var i=0;i<selrows.length;i++){
                                 var id=selrows[i].id;
                                 ids.push(id);
                             }
                             $.ajax({
                                 type:"get",
                                 url:"${pageContext.request.contextPath}/guru/remove.do",
                                 data: "ids="+ids,
                                 success:function(result){
                                     $.messager.show({
                                         title: "系统提示",
                                         msg:"删除成功"
                                     });

                                     $("#guruTable").datagrid("reload");
                                 }

                             });

                         }
                     });
             }
         });

         //初始化对话框
         $("#addGuruDialog").dialog({
             title: "添加用户",
             width:400,
             height:300,
             modal:true,
             closed:true,
             href: "${pageContext.request.contextPath }/view/main/guruForm.jsp"
         })

    });
    //加载结束



</script>


