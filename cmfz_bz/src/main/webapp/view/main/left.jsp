<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>

<div id="menu" class="easyui-accordion" data-options="fit:true">

</div>

<script type="text/javascript">
    //菜单管理
    $(function () {
        $.ajax({
            url: "${pageContext.request.contextPath}/menu/showMenu.do",
            type: "post",
            dataType: "JSON",
            success: function (data) {

                $.each(data, function (index, first) {
                    var c = "";

                    $.each(first.children, function (index1, second) {
                        c += "<p style='text-align: center'><a href='#' data-options=\"iconCls:'icon-bell_go'\" class='easyui-linkbutton' onclick=\"addTabs('" + second.iconCls + "','" + second.title + "','" + second.href
                            + "')\">" + second.title + "</a></p>";
                    })

                    $("#menu").accordion('add', {
                        title: first.title,
                        content: c,
                        iconCls: first.iconCls,
                        selected: false
                    });
                })
            }
        })
    });

    function addTabs(iconCls, title, href) {
        /*创建选项卡*/
        var flag = $("#tabs1").tabs("exists",title)
        if (flag){
            $("#tabs1").tabs("select",title)
            console.log(href)
        }else {
            $('#tabs1').tabs('add', {
                title: title,
                selected: true,
                closable: true,
                href:"${pageContext.request.contextPath}"+href
            });
        }

    }
</script>
