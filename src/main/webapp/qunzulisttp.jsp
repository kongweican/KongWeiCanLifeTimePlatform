<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="com.util.db"/>

<script type="text/javascript" src="js/My97DatePicker/WdatePicker.js" charset="gb2312"></script>
<script type="text/javascript" src="js/popup.js"></script>
<script type="text/javascript" src="js/jquery-1.11.0.min.js"></script>
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=0">
    <title>群组</title>

    <link href="qtimages/lib/bootstrap/css/bootstrap.css" rel="stylesheet">
    <link rel="stylesheet" href="qtimages/css/index.css">
</head>

<%

%>

<body>
<jsp:include page="qttop.jsp"></jsp:include>
<jsp:include page="bht.jsp"></jsp:include>
<section id="introduce">
    <div class="container">
        <div class="head text-center">
            <h3>群组</h3>
        </div>

        <link rel="stylesheet" href="images/hsgcommon/divqt.css" type="text/css">
        <form action="qzListtp.do" name="myform" method="post" style="width:100%">
            查询   编号：<input name="bianhao" type="text" id="bianhao" class="form-control2" />  名称：<input name="mingcheng" type="text" id="mingcheng" class="form-control2" />  类型：<input name="leixing" type="text" id="leixing" class="form-control2" />
            <input type="submit" value="查询" /> <input type="button" name="Submit2" value="切换视图"  onClick="javascript:location.href='qzList.do';" />
        </form>
        <br />

        <table width="100%" height="12%" border="0" align="center" cellpadding="0" cellspacing="0">
            <tr>
                <%
                    int i=0;
                %>
                <c:forEach items="${list}" var="u">
                    <%
                        i++;
                    %>
                    <td height="316" align="center"><table width="225" height="285" border="0" cellpadding="0" cellspacing="0">
                        <tr>
                            <td height="250" align="center"><a href="qzDetail.do?id=${u.id}"><img src="${u.fengmian}" width="210" height="250" border="0" /></a></td>
                        </tr>
                        <tr>
                            <td height="26" align="center">${u.mingcheng}</td>
                        </tr>
                    </table></td>
                    <%
                        if (i==4)
                        {
                            i=0;
                            out.print("</tr><tr>");
                        }


                    %>
                </c:forEach>


            </tr>
        </table><br>

        <p align="center"> <c:if test="${sessionScope.p==1}">
            <c:if test="${page.page>1}">
                <a href="qzListtp.do?page=1" >首页</a>
                <a href="qzListtp.do?page=${page.page-1}"> 上一页</a>             </c:if>
            <c:if test="${page.page<page.totalPage}">
                <a href="qzListtp.do?page=${page.page+1}">下一页</a>
                <a href="qzListtp.do?page=${page.totalPage}">末页</a>		    </c:if>
        </c:if>
        </p>

    </div>
</section>
<jsp:include page="qtdown.jsp"></jsp:include>
<jsp:include page="qtuserlog.jsp"></jsp:include>
<script src="qtimages/lib/jquery/jquery.min.js"></script>
<script src="qtimages/lib/bootstrap/js/bootstrap.min.js"></script>
<script src="qtimages/js/index.js"></script>

</body>
</html>
