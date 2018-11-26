<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<form id="bannerForm" method="post" enctype="multipart/form-data">
    图片名称:<input id="title-input" name="title"></input><br/>
    图片描述:<input id="description-input" name="description" style="height:80px"></input><br/>
    是否展示:<select id="status-input" name="status" style="width:200px">
                <option value="Y">展示</option>
                <option value="N">不展示</option>
            </select><br/>
    上传图片:<input id="uploadImg" name="uploadImg" type="text" style="width:200px"><br/>
    <a id="banner-submitBtn">提交</a>
    <a id="banner-resetBtn">重置</a>
</form>
<script type="text/javascript">
    $(function(){
        //初始化title输入框
        $("#title-input").textbox({
            required: true
        });

        //初始化description输入框
        $("#description-input").textbox({
           required: true,
           multiline: true
        });

        //初始化status输入框
        $("#status-input").combobox({
            editable:false

        });
        //初始化上传图片
        $("#uploadImg").filebox({
            buttonText: '选择文件',
            buttonAlign: 'right'
        });
        //初始化提交按钮
        $("#banner-submitBtn").linkbutton({
            iconCls: "icon-bell_add",
            onClick: function () {
                $("#bannerForm").form("submit",{
                    url: "${pageContext.request.contextPath}/banner/uploadBanner.do",
                    onSubmit: function () {
                        $("#bannerForm").form("validate");
                    },
                    success: function () {
                        //提交成功后-清空表单-关闭对话框
                        $("#bannerForm").form("clear");
                        $("#addBannerDialog").dialog("close");
                        //右下角系统提示
                        $.messager.show({
                            title: "系统提示",
                            msg: "恭喜您,提交成功!"
                        });
                        //数据表格重新加载
                        $("#bannerTable").datagrid("load");
                    }
                });
            }
        });
        //初始化重置按钮
        $("#banner-resetBtn").linkbutton({
            iconCls: "icon-bell_delete",
            onClick: function () {
                $("#bannerForm").form("reset");
            }

        });
    });
</script>