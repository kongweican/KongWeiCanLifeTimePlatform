<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="com.util.db"/>
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=0">
    <title>在线论坛</title>
    <link href="qtimages/lib/bootstrap/css/bootstrap.css" rel="stylesheet">
    <link rel="stylesheet" href="qtimages/css/index.css">
</head>

<body>
<jsp:include page="qttop.jsp"></jsp:include>
<section id="introduce">
    <div class="container">
        <div class="head text-center">
            <h3>在线论坛</h3>
        </div>

        <table border="0" cellpadding="0" bgcolor="#35A2AE" cellspacing="1" style="border-collapse: collapse" bordercolor="#FFFFFF" width="98%" align="center" class="newsline">
            <%
            int bbsi=0;
            String sqlbbs =  "select * from bankuai  order by id desc";
            ResultSet RS_resultbbs=connDbBean.executeQuery(sqlbbs);
            while(RS_resultbbs.next()){
            bbsi++;
            %>
            <tr bgcolor="#E1F3F4" height="60" valign="middle">
                <td width="37%" align="center" bgcolor="#FFFFFF">
                    <%--超链接，点击跳转并且会传递参数  参数为板块的名称--%>
                    <a href="bbslist.jsp?bk=<%=RS_resultbbs.getString("mingcheng") %>">
                        <%=RS_resultbbs.getString("mingcheng") %></a>
                </td>
                <td width="27%" align="left" bgcolor="#FFFFFF">
                    共有
                    <%=connDbBean.getwzs(RS_resultbbs.getString("mingcheng"))%>
                    篇文章
                </td>
                <td width="23%" bgcolor="#FFFFFF">
                    版主：
                    <%=RS_resultbbs.getString("banzhu") %>
                </td>
            </tr>
            <%
                }
            %>
        </table>

    </div>
</section>
<jsp:include page="qtdown.jsp"></jsp:include>
<jsp:include page="qtuserlog.jsp"></jsp:include>
<script src="qtimages/lib/jquery/jquery.min.js"></script>
<script src="qtimages/lib/bootstrap/js/bootstrap.min.js"></script>
<script src="qtimages/js/index.js"></script>
</body>
</html>