<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<script type="text/javascript">

    $(function () {
        var toolbar = [{
            iconCls: 'icon-bell',
            text: "专辑详情",
            handler: function () {
                var row = $("#album_tt").treegrid("getSelected");
                if (row != null) {
                    if (row.author != null) {
                        $("#album_dd").dialog("open");
                        $("#corverImgshow").prop("src","${pageContext.request.contextPath}" + row.corverImg);

                        $('#album_ff').form('load', row);
                    } else {
                        alert("请选中专辑");
                    }
                } else {
                    alert("请选中专辑");
                }


            }
        }, '-', {
            text: "添加章节",
            iconCls: 'icon-bell_add',
            handler: function () {
                var rowSelected = $("#album_tt").treegrid("getSelected")

                if(rowSelected==null){
                    alert("请选中专辑");
                }else{
                    if(rowSelected.author==null){
                        alert("请选中专辑");
                    }else{
                        $('#chapter_dd').dialog('open');

                        $('#chapter_fb').filebox({
                            buttonText: '选择文件',
                            buttonAlign: 'left'
                        });
                        $('#chapter_ff').form({
                            queryParams:{
                                "albumId": rowSelected.id
                            },
                            url: '${pageContext.request.contextPath}/chapter/uploadChapter?albumId='+rowSelected.id,
                            onSubmit: function(){
                                return true;
                            },
                            success:function(){
                                $('#chapter_ff').form('clear');
                                $('#chapter_dd').dialog('close');
                                $('#album_tt').treegrid('reload');
                            }
                        });
                    }
                }
            }
        }, '-', {
            text: "添加专辑",
            iconCls: 'icon-bell_add',
            handler: function () {
                $("#album_dd").dialog("open");
            }
        }, '-', {
            text: "下载章节",
            iconCls: 'icon-bell_link',
            handler: function () {
                var row = $("#album_tt").treegrid("getSelected");
                if (row != null) {
                    if (row.author == null) {
                        location.href = "${pageContext.request.contextPath}/chapter/download.do?audioPath=" + row.audioPath + "&title=" + row.title;
                    } else {
                        alert("请选中章节");
                    }
                } else {
                    alert("请选中章节");
                }

            }
        }]

        $('#album_tt').treegrid({
            url: '${pageContext.request.contextPath}/album/showByPage.do',
            method: "post",
            idField: 'id',
            treeField: 'title',
            checkbox: true,
            onlyLeafCheck: true,
            animate: true,
            lines: true,
            columns: [[
                {field: 'title', title: '名称', width: 60},
                {field: 'size', title: '大小', width: 60},
                {field: 'audioPath', title: '路径', width: 80},
                {field: 'duration', title: '时长', width: 80}
            ]],
            fit: true,
            fitColumns: true,
            pagination: true,
            pageSize: 5,
            pageList: [5, 10, 15, 20],
            toolbar: toolbar,

            onDblClickRow: function (row) {
                $("#audio_dd").dialog("open");
                console.log(row);
                $("#audio").prop("src", "${pageContext.request.contextPath}" +  row.audioPath)
            },
            onLoadSuccess: function(){
                $('#album_tt').treegrid("collapseAll");
            }
        });
        //初始化album表单提交按钮
        $("#album_submitbtn").linkbutton({
            iconCls: "icon-bell_add",
            onClick: function () {
                $("#album_ff").form("submit",{
                    url: "${pageContext.request.contextPath}/album/uploadAlbum.do",
                    onSubmit: function () {
                        $("#album_ff").form("validate");
                    },
                    success: function () {
                        $("#album_ff").form("clear");
                        $("#album_dd").dialog("close");
                        $('#album_tt').treegrid("reload");
                        $.messager.show({
                            title: "系统提示",
                            msg: "恭喜您,保存成功!"
                        });
                    }
                });
            }
        });
        //初始化album表单重置按钮
        $("#album_resetbtn").linkbutton({
           iconCls: "icon-bell",
           onClick: function () {
               $("#album_ff").form("reset");
           }
        });

        //初始化chapter表单提交按钮
        $("#chapter_submitbtn").linkbutton({
            iconCls: "icon-bell_add",
            onClick: function () {
                $("#chapter_ff").form("submit",{
                    url: "${pageContext.request.contextPath}/chapter/uploadChapter.do",
                    onSubmit: function () {
                        $("#chapter_ff").form("validate");
                    },
                    success: function () {
                        $("#chapter_ff").form("clear");
                        $("#chapter_dd").dialog("close");
                        $('#album_tt').treegrid("reload");
                        $.messager.show({
                            title: "系统提示",
                            msg: "恭喜您,保存成功!"
                        });
                    }
                });
            }
        });

        //初始化chapter表单重置按钮
        $("#chapter_resetbtn").linkbutton({
            iconCls: "icon-bell",
            onClick: function () {
                $("#chapter_ff").form("reset");
            }
        });


    });


</script>
<%--
    <table id="chapter_dg"></table>
--%>

<%-- 专辑树 --%>
<table id="album_tt" ></table>
<%-- 添加专辑对话框 --%>
<div id="album_dd" class="easyui-dialog" title="专辑信息" style="width:400px;height:300px;" data-options="iconCls:'icon-bell_go',resizable:true,modal:true,closed:true" >

    <%--    上传专辑表单-开始   --%>
    <form id="album_ff" method="post" enctype="multipart/form-data">
        <div>
            <label for="title">专辑名称:</label>
            <input class="easyui-validatebox" type="text" id="title" name="title" data-options=""/>
        </div>
        <div>
            <label for="score">专辑评分:</label>
            <input class="easyui-validatebox" type="text" id="score" name="score" data-options=""/>
        </div>
        <div>
            <label for="author">专辑作者:</label>
            <input class="easyui-validatebox" type="text" id="author" name="author" data-options=""/>
        </div>
        <div>
            <label for="broadCast">专辑主播:</label>
            <input class="easyui-validatebox" type="text" id="broadCast" name="broadCast" data-options=""/>
        </div>
        <div>
            <label for="status">是否上架:</label>
            <select id="status" name="status"  data-options="">
                <option value="Y" selected="selected">展示</option>
                <option value="N">不展示</option>
            </select><br/>
        </div>
        <div>
            <label for="brife">专辑简介:</label>
            <input class="easyui-box" type="text" id="brife" name="brife" data-options="multiline:true"/>
        </div>
        <div>
            <label for="publicDate">发行日期:</label>
            <input class="easyui-datebox" id="publicDate" name="publicDate" data-options="editable:false,required:true"/>
        </div>
        <div align="left">
            <label for="corverImg">专辑封面:</label>
            <input class="easyui-filebox"  id="corverImg" name="uploadCorverImg" data-options="buttonText:'选择文件'"/>
        </div>
        <div align="left">
            <label for="corverImgshow"/>
            <img id="corverImgshow"  name="coverImg"/>
        </div>
        <div>
            <a id="album_submitbtn" >保存</a>
            <a id="album_resetbtn" >重置</a>
        </div>
    </form>

    <div id="audio_dd" class="easyui-dialog" title="音频播放" style="width:400px;height:200px;"
         data-options="iconCls:'icon-bell_go',resizable:true,modal:true,closed:true">
        <audio src="" id="audio" controls="controls" autoplay="autoplay">

        </audio>
    </div>
</div>
<%--    上传专辑表单-结束   --%>

<%--    章节上传-开始     --%>
<div id="chapter_dd" class="easyui-dialog" title="章节上传" style="width:400px;height:200px;"
     data-options="iconCls:'icon-bell_add',resizable:true,modal:true,closed:true," >
    <form id="chapter_ff" method="post" enctype="multipart/form-data" >
        <div>
            <label for="title">章节名:</label>
            <input class="easyui-validatebox" type="text" name="title" data-options=""/>
        </div>
        <div>
            <input id="chapter_fb" type="easyui-filebox" name = "uploadAudio" style="width:200px">
        </div>

        <div>
            <a id="chapter_submitbtn" >保存</a>
            <a id="chapter_resetbtn" >重置</a>
        </div>
    </form>
</div>
