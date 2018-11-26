<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<form id="guruForm" method="post" enctype="multipart/form-data">
    上师姓名:<input id="guruname" name="name"></input><br/>
    上师法号:<input id="guruDharma" name="dharmaName"></input><br/>
    上师手机:<input id="guruPhone" name="phoneNum"></input><br/>
    是否展示:<select id="gurustatus" name="status" style="width:200px">
                <option value="Y">展示</option>
                <option value="N">不展示</option>
            </select><br/>
    上传图片:<input id="uploadPhoto" name="uploadPhoto" type="text" style="width:200px"><br/>
    <a id="guru-submitBtn">提交</a>
    <a id="guru-resetBtn">重置</a>
</form>
<script type="text/javascript">
    $(function(){
        //初始化name输入框
        $("#guruname").textbox({
            required: true
        });

        //初始化法号输入框
        $("#guruDharma").textbox({
           required: true
        });
        //初始化上师手机号
        $("#guruPhone").textbox({
            required: true
        })

        //初始化status输入框
        $("#gurustatus").combobox({
            editable:false

        });
        //初始化上传图片
        $("#uploadPhoto").filebox({
            buttonText: '选择文件',
            buttonAlign: 'right'
        });
        //初始化提交按钮
        $("#guru-submitBtn").linkbutton({
            iconCls: "icon-bell_add",
            onClick: function () {
                $("#guruForm").form("submit",{
                    url: "${pageContext.request.contextPath}/guru/upload.do",
                    onSubmit: function () {
                        $("#guruForm").form("validate");
                    },
                    success: function () {
                        //提交成功后-清空表单-关闭对话框
                        $("#guruForm").form("clear");
                        $("#addGuruDialog").dialog("close");
                        //右下角系统提示
                        $.messager.show({
                            title: "系统提示",
                            msg: "恭喜您,提交成功!"
                        });
                        //数据表格重新加载
                        $("#guruTable").datagrid("load");
                    }
                });
            }
        });
        //初始化重置按钮
        $("#guru-resetBtn").linkbutton({
            iconCls: "icon-bell_delete",
            onClick: function () {
                $("#guruForm").form("reset");
            }

        });
    });
</script>