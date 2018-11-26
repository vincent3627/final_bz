<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page isELIgnored="false" %>
<div id="tabs1" class="easyui-tabs" data-options="fit:true,narrow:true,pill:true">
    <div title="主页" data-options="iconCls:'icon-neighbourhood',"  style="background-image:url(image/shouye.jpg);background-repeat: no-repeat;background-size:100% 100%;"></div>
</div>
<script type="text/javascript">
    $(function(){
        $("#tabs1").tabs({
            fit: true
        });
    });
</script>