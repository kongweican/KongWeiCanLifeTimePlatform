<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!--顶部通栏-->
    <header class="wjs_topBar">
        <div class="container">
            <div class="row">
                    <div class="col-md-3 hidden-xs topBar-brand">
                        <span class="name">生活时光分享平台</span>
                    </div>
                <div class="input-group col-md-6 col-xs-6">
                    <form action="bbslist.jsp" method="post">
                        <table>
                            <tr>
                                <input type="text" id="bt" name="bt" class="form-control" placeholder="Search for..." style="width: 100px;">
                                <td></td>
                                <td>
                                    <span class="input-group-btn">
                                        <button class="btn btn-default" type="submit">搜索</button>
                                    </span>
                                </td>
                            </tr>
                        </table>


                    </form>
                </div>
                <div class="col-md-3 col-xs-6">
				 <%
    if((String)request.getSession().getAttribute("username")==null || (String)request.getSession().getAttribute("username")==""){
     %>
                    <button class="btn btn-primary" data-toggle="modal" data-target="#myLoginModal">登录</button>
                    <a href="userreg.jsp" class="btn btn-danger">注册</a>
                    <%}else{ %>
                    <%=request.getSession().getAttribute("username")%>,[<%=request.getSession().getAttribute("cx")%>]&nbsp;
                    <a href="logout.jsp" onclick="return confirm('确定要退出？')" class="btn btn-primary">退出</a>&nbsp;
                    <a href="main.jsp" class="btn btn-danger">后台</a>
                    <%} %>
                </div>
            </div>
        </div>
    </header>

    <!--导航栏-->
    <nav class="navbar wjs_nav" data-spy="affix" data-offset-top="200">
        <div class="container">
            <div class="navbar-header">
                <!--设置导航栏的样式，当你缩小页面导航栏被隐藏为三条横线-->
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
                    data-target="#bs-example-navbar-collapse-1">
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
            </div>
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class='nav navbar-nav ml'>
	                <li class=''><a href='index.do'>首页</a></li>
                    <li><a href='qzListtp.do'>群组</a></li>
                    <li><a href='bankuai_list0.jsp'>板块</a></li>
                    <li><a href='bbs.jsp'>交流论坛</a></li>
                    <li class='show'><a >系统概要</a>
                        <div class='pa'>
                            <a href='dx_detail.jsp?lb=系统简介'>系统简介</a>
                            <a href='dx_detail.jsp?lb=关于我们'>关于我们</a>
                            <a href='dx_detail.jsp?lb=联系方式'>联系方式</a>
                        </div>
                    </li>
                    <li class='show'><a >在线留言</a>
                        <div class='pa'>
                            <a href='lyb.jsp'>在线留言</a>
                            <a href='lybList.do'>查看留言</a>
                        </div>
                    </li>
                </ul>
            </div>
        </div>
    </nav>