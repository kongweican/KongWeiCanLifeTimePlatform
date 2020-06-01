<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="com.util.db"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="com.util.db"/>

<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=0">
    <title>生活时光分享平台</title>
    <link href="qtimages/lib/bootstrap/css/bootstrap.css" rel="stylesheet">
    <link rel="stylesheet" href="qtimages/css/index.css">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"></head>

<body>
<jsp:include page="qttop.jsp"></jsp:include>
<jsp:include page="bht.jsp"></jsp:include>
   <section id='introduce'>
        <div class='container'>
			<div class='head text-center'><h3>群组推荐</h3></div>
            <div class='row'>
			<c:forEach items="${syqunzu}" var="a">
                <div class='col-xs-12 col-sm-6 col-md-4 col-lg-3 works'>
                    <a href="qzDetail.do?id=${a.id}">
                        <div class='bg'>
                            ${a.mingcheng}
                        </div>
                        <div class='tab-content item' data-brief=''>
                        <img src="${a.fengmian}" alt=''>
                        </div>
                    </a>
                </div>
			 </c:forEach>
            </div>
        </div>
   </section>
   <section id='introduce'>
        <div class='container'>
			<div class='head text-center'><h3>会员风彩</h3></div>
            <div class='row'>
			 <c:forEach items="${syyonghuzhuce1}" var="b">
                <div class='col-xs-12 col-sm-6 col-md-4 col-lg-3 works'><a href="#"><div class='bg'>${b.xingming}</div><div class='tab-content item' data-brief=''><img src="${b.touxiang}" alt=''></div></a></div>
			</c:forEach>
            </div>
        </div>
    </section>

    <section class="wjs_news" id="wjs_news">
        <div class="container">
                <div class="head text-center">
                    <h3>关于我们</h3>
                    <p>以下介绍下文字，请您登陆管理员后台自行修改。</p>
                </div>
            <div class="col-md-5 imgs">
                <ul class="nav nav-tabs">
                    <li class="col-md-6"><img src="qtimages/slide_01_640x340.jpg" class="col-md-12"></li>
                    <li class="col-md-6"><img src="qtimages/slide_02_640x340.jpg" class="col-md-12"></li>
                    <li class="col-md-6"><img src="qtimages/slide_03_640x340.jpg" class="col-md-12"></li>
                    <li class="col-md-6"><img src="qtimages/slide_04_640x340.jpg" class="col-md-12"></li>
                </ul>
            </div>
            <div class="col-md-7">
                <div class="tab-content">
                    <div class="tab-pane active" id="home">
                       <%=connDbBean.ensubStr(connDbBean.readzd("dx","content","leibie","关于我们"),185)%> 
                    </div>
                </div>
            </div>
        </div>
    </section>
	<jsp:include page="qtdown.jsp"></jsp:include>
	<jsp:include page="qtuserlog.jsp"></jsp:include>
    <script src="qtimages/lib/jquery/jquery.min.js"></script>
    <script src="qtimages/lib/bootstrap/js/bootstrap.min.js"></script>
    <script src="qtimages/js/index.js"></script>
</body>
</html>