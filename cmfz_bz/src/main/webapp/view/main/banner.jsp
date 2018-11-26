<%@ page language="java"  pageEncoding="utf-8" %>

<table id="bannerTable">
    <thead>
        <tr>
            <th data-options="field:'cbox',checkbox:true"></th>
            <th data-options="field:'id',hidden:true">id</th>
            <th data-options="field:'title',width:1,align:'center' ">图片名</th>
            <th data-options="field:'status',width:1,align:'center',editor:{type:'validatebox',options:{required:true}}">展示状态(Y/N)</th>
            <th data-options="field:'uploadDate',width:1,align:'center'">上传日期</th>

        </tr>
    </thead>
</table>

<div id="bannerTb">
    <a id="bannerLoadBtn">刷新</a>
    <a id="addBannerBtn">添加</a>
    <a id="saveBannerBtn">保存</a>
    <a id="delBannerBtn">删除</a>
</div>

<div id="addBannerDialog">轮播图添加</div>

<script type="text/javascript">
    $(function(){
        //初始化数据表格
        $("#bannerTable").edatagrid({
            title: "轮播图管理",
            url: "${pageContext.request.contextPath}/banner/showByPage.do",
            saveUrl: "${pageContext.request.contextPath}/banner/uploadBanner.do",
            updateUrl: "${pageContext.request.contextPath}/banner/editBanner.do",
            destroyUrl:"${pageContext.request.contextPath}/banner/removeBanner.do",
            fit: true,
            fitColumns: true,
            autoSave: true,
            editable: true,
            toolbar:"#bannerTb",
            pagination: true,
            pageSize: 3,
            pageList: [3,5,10,15],
            checkOnSelect: false,
            view: detailview,
            detailFormatter: function(rowIndex, rowData){
                return '<table><tr>' +
                    '<td rowspan=2 style="border:0"><img src="${pageContext.request.contextPath}/' + rowData.imgPath + '" style="height:50px;"></td>' +
                    '<td style="border:0">' +
                    '<p>图片描述: ' + rowData.description + '</p>' +
                    '</td>' +
                    '</tr></table>';
            }
        });

        //初始化添加按钮
        $("#addBannerBtn").linkbutton({
            iconCls: "icon-bell_add",
            onClick: function () {
                $("#addBannerDialog").dialog("open");
            }
        });
        //初始化刷新按钮
         $("#bannerLoadBtn").linkbutton({
             iconCls: "icon-bell",
             onClick: function () {
                 $("#bannerTable").datagrid("load");
             }
         });
         //初始化保存按钮
        $("#saveBannerBtn").linkbutton({
            iconCls: "icon-bell",
            onClick:function(){
                $("#bannerTable").edatagrid("saveRow");
            }
        })
         //初始化批量删除按钮
         $("#delBannerBtn").linkbutton({
             iconCls: "icon-bell_delete",
             onClick: function () {
                 var selrows=$('#bannerTable').datagrid("getSelections");
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
                                 url:"${pageContext.request.contextPath}/banner/removeBanner.do",
                                 data: "ids="+ids,
                                 success:function(result){
                                     $.messager.show({
                                         title: "系统提示",
                                         msg:"删除成功"
                                     });

                                     $("#bannerTable").datagrid("reload");
                                 }

                             });

                         }
                     });
             }
         });

         //初始化对话框
         $("#addBannerDialog").dialog({
             title: "添加用户",
             width:400,
             height:300,
             modal:true,
             closed:true,
             href: "${pageContext.request.contextPath }/view/main/bannerForm.jsp"
         })

    });
    //加载结束



</script>


