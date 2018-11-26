<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page isELIgnored="false" %>

<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
        <title>持名法州主页</title>

        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/themes/default/easyui.css">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/themes/IconExtension.css">
        <script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery.min.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery.easyui.min.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery.edatagrid.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath }/js/easyui-lang-zh_CN.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath }/js/datagrid-detailview.js"></script>
    </head>


    <body class="easyui-layout">
        <div data-options="region:'north',split:true,href:'${pageContext.request.contextPath }/view/main/top.jsp'" style="height:100px;background-color:  #5C160C">
        </div>

        <div data-options="region:'south',split:true" style="height: 40px;background: #5C160C">
            <div style="text-align: center;font-size:15px; color: #FAF7F7;font-family: 楷体" >&copy;百知教育 htf@zparkhr.com.cn</div>
        </div>

        <div data-options="region:'west',title:'导航菜单',split:true,href:'${pageContext.request.contextPath }/view/main/left.jsp'" style="width:220px;">

        </div>
        <div data-options="region:'center',href:'${pageContext.request.contextPath }/view/main/center.jsp'">

        </div>
    </body>


</html>
