<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="com.util.db"/>
<html>
  <head>
    <title>群组详细</title>
<link rel="stylesheet" href="images/hsgcommon/common.css" type="text/css">
	<link rel="stylesheet" href="images/hsgcommon/div.css" type="text/css">   

  </head>

  <body >

  群组详细:
  <br><br>
  
   <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="#CBD8AC" style="border-collapse:collapse">  
   <tr>
     <td width='11%' height=44>编号：</td><td width='39%'>${qunzu.bianhao}</td><td  rowspan=6 align=center><a href=${qunzu.fengmian} target=_blank><img src=${qunzu.fengmian} width=228 height=215 border=0></a></td></tr><tr><td width='11%' height=44>创始人：</td><td width='39%'>${qunzu.chuangshiren}</td></tr><tr><td width='11%' height=44>名称：</td><td width='39%'>${qunzu.mingcheng}</td></tr><tr><td width='11%' height=44>类型：</td><td width='39%'>${qunzu.leixing}</td></tr><tr><td width='11%' height=44>创建日期：</td><td width='39%'>${qunzu.chuangjianriqi}</td></tr><tr><td width='11%' height=44>人数：</td><td width='39%'>${qunzu.renshu}</td></tr><tr><td width='11%' height=100  >简介：</td><td width='39%' colspan=2 height=100 >${qunzu.jianjie}</td></tr><tr><td colspan=3 align=center><input type=button name=Submit5 value=返回 onClick="javascript:history.back()" />&nbsp;<input type=button name=Submit5 value=打印 onClick="javascript:window.print()" /></td></tr>
    
  </table>

  </body>
</html>

