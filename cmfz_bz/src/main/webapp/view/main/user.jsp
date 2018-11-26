<%@ page language="java"  pageEncoding="utf-8" %>

<table id="userTable">
    <thead>
        <tr>
            <th data-options="field:'cbox',checkbox:true"></th>
            <th data-options="field:'id',hidden:true">id</th>
            <th data-options="field:'name',width:1,align:'center' ">姓名</th>
            <th data-options="field:'dharmaName',width:1,align:'center' ">法号</th>
            <th data-options="field:'sex',width:1,align:'center' ">性别</th>
            <th data-options="field:'province',width:1,align:'center' ">省</th>
            <th data-options="field:'city',width:1,align:'center' ">城市</th>
            <th data-options="field:'sign',width:1,align:'center' ">签名</th>

            <th data-options="field:'status',width:1,align:'center',editor:{type:'validatebox',options:{required:true}}">激活状态(Y/N)</th>

        </tr>
    </thead>
</table>

<div id="userTb">
    <a id="userLoadBtn">刷新</a>
    <a id="saveUserBtn">保存</a>

</div>


<script type="text/javascript">
    $(function(){
        //初始化数据表格
        $("#userTable").edatagrid({
            title: "用户信息",
            url: "${pageContext.request.contextPath}/user/showByPage.do",
            updateUrl: "${pageContext.request.contextPath}/user/edit.do",
            fit: true,
            fitColumns: true,
            autoSave: true,
            editable: true,
            toolbar:"#userTb",
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


        //初始化刷新按钮
         $("#userLoadBtn").linkbutton({
             iconCls: "icon-bell",
             onClick: function () {
                 $("#userTable").edatagrid("load");
             }
         });

         //初始化保存按钮
        $("#saveUserBtn").linkbutton({
            iconCls: "icon-bell_add",
            onClick: function () {
                $("#userTable").edatagrid("saveRow");
            }
        })

    });
    //加载结束



</script>


