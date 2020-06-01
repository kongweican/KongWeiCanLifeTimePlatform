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
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"></head>
<%--获取传递的参数--%>
<% String bk=request.getParameter("bk"); %>
<body>
<jsp:include page="qttop.jsp"></jsp:include>
<section id="introduce">
    <div class="container">
        <div class="head text-center">
            <h3>在线论坛</h3>
        </div>

        <table width="100%" border="0" align="center" cellpadding="3" cellspacing="1" bordercolor="#00FFFF" class="newsline" style="border-collapse:collapse">
            <tr>
                <td height="104" valign="top">
                    <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="#00FFFF" style="border-collapse:collapse">
                        <tr>
                            <td width="30" bgcolor="#EBE2FE">序号</td>
                            <td width="352" bgcolor='#EBE2FE'>标题</td>
                            <td width="48" bgcolor='#EBE2FE'>类型</td>
                            <td width="60" bgcolor='#EBE2FE'>发帖人</td>
                            <td width="130" align="center" bgcolor="#EBE2FE">发布时间</td>
                            <td width="65" align="center" bgcolor="#EBE2FE">已有回帖</td>
                        </tr>
                        <%


                            String sqlbbs =  "select * from tiezi where 1=1";
                            if(bk!=null)
                            {
                                sqlbbs=sqlbbs+" and bankuai='"+bk+"'";

                            }
                            if(request.getParameter("bt")!=null)
                            {
                                sqlbbs=sqlbbs+" and biaoti like '%"+request.getParameter("bt")+"%'";

                            }
                            sqlbbs=sqlbbs+" and fid='0' order by issh desc, id desc";
                            int bbsi=0;
                            ResultSet RS_resultbbs=connDbBean.executeQuery(sqlbbs);
                            while(RS_resultbbs.next()){
                                bbsi++;

                        %>
                        <tr>
                            <td width="30"><%=bbsi%></td>
                            <td>
                                <a href="tiezidetail.jsp?id=<%=RS_resultbbs.getString("id") %>">
                                    <%
                                if(RS_resultbbs.getString("issh").equals("是"))
                                {
                                    %>
                                    <%
                                }
                                    %>
                                    <%=RS_resultbbs.getString("biaoti") %>
                            </td>
                            <td>
                                <img src="bbs/<%=RS_resultbbs.getString("leixing") %>.gif" width="18" height="18">
                            </td>
                            <td>
                                <%=RS_resultbbs.getString("faburen") %>
                            </td>
                            <td width="130" align="center">
                                <%=RS_resultbbs.getString("addtime") %>
                            </td>
                            <td width="65" align="center">
                                <%=connDbBean.gettzs((String)RS_resultbbs.getString("id")) %>
                            </td>
                        </tr>
                        <%
                            }
                        %>
                    </table>
                </td>
            </tr>
            <tr>
                <td align="right">
                    <a href="tieziadd.jsp?bk=<%=bk%>">我要发帖</a>
                    <a href="bbs.jsp" onClick="javascript:history.back();">返回</a>
                </td>
            </tr>
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