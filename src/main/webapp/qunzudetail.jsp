<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="com.util.db"/>

<script type="text/javascript" src="js/My97DatePicker/WdatePicker.js" charset="utf-8"></script>
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
<script language=javascript src='js/popup.js'></script>
<script language=javascript> 
function hsgpinglun(nbiao,nid){ 
popheight=450;
pop('hsgpinglun.jsp?biao='+nbiao+'&id='+nid,'在线评论',550,250) ;
}
</script> 
<%
	String id=request.getParameter("id");
	
     %>
<body>
<jsp:include page="qttop.jsp"></jsp:include>
    <section id="introduce">
        <div class="container">
			<div class="head text-center">
                    <h3>群组</h3>
            </div>
          
		
   <table width="100%" border="0" align="center" cellpadding="3" cellspacing="1" bordercolor="#00FFFF" style="border-collapse:collapse"  class="newsline">  
      <tr>
          <td width='11%' height=44>编号：</td>
          <td width='39%'>${qunzu.bianhao}</td>
          <td  rowspan=6 align=center>
                  <img src=${qunzu.fengmian}  width=228 height=215 border=0></a>
          </td>
      </tr>
       <tr>
         <td width='11%' height=44>创始人：</td>
           <td width='39%'>${qunzu.chuangshiren}</td>
       </tr>
       <tr>
         <td width='11%' height=44>名称：</td>
           <td width='39%'>${qunzu.mingcheng}</td>
       </tr>
       <tr>
         <td width='11%' height=44>类型：</td>
           <td width='39%'>${qunzu.leixing}</td>
       </tr>
       <tr><td width='11%' height=44>创建日期：</td>
           <td width='39%'>${qunzu.chuangjianriqi}</td>
       </tr>
       <tr>
           <td wdth='11%' height=44>人数：</td>
           <td width='39%'>${qunzu.renshu}</td>
       </tr>
       <tr>
           <td width='11%' height=100  >简介：</td>
           <td width='39%' colspan=2 height=100 >${qunzu.jianjie}</td>
       </tr>
       <tr>
           <td colspan=3 align=center>
               <input type=button name=Submit5 value=返回 onClick="javascript:history.back()" />
               <input type=button name=Submit53 value=申请 onClick="javascript:location.href='shenqing_add.jsp?id=<%=request.getParameter("id")%>';"/> <!--jixaaxnnxiu-->
               <input type=button name=Submit52 value=收藏 onClick="javascript:location.href='jrsc.jsp?id=<%=id%>&biaoj=qz&biao=qunzu&ziduan=mingcheng';" />
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

