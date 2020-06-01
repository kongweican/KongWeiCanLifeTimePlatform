<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%request.setCharacterEncoding("utf-8");%>


<html>
<head>
  <title>生活时光分享平台</title>
  <link href="images/style.css" type=text/css rel=stylesheet>
  <style type="text/css">
    <!--
    body,td,th {
      font-size: 12px;
    }
    -->
  </style>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8"></head>
<body leftMargin=5 topMargin=5 rightMargin=5>
<table width="100%" height="210" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="#D9E9FF" style="border-collapse:collapse">
  <tbody>
  <tr align=middle bgColor=#ffffff>
    <td colspan="4" bgColor=#CADCEA><strong>系统基本信息</strong></td>
  </tr>
  <tr   align=middle bgColor=#ffffff>
    <td width="14%" align="left" valign="bottom" >当前用户：</td>
    <td width="37%"  align="left" valign="bottom" ><font class="t4">${sessionScope.username}</font></td>
    <td width="9%"  align="left" valign="bottom" >您的权限：</td>
    <td width="40%"  align="left" valign="bottom" ><font class="t4">${sessionScope.cx}</font></td>
  </tr>
  <tr   align=middle
        bgColor=#ffffff>
    <td height="38" align="left" valign="bottom"  >当前日期：</td>
    <td  align="left" valign="bottom" ><%java.util.Date date = new java.util.Date();
      java.text.SimpleDateFormat format = new java.text.SimpleDateFormat("yyyy-MM-dd", java.util.Locale.CHINA);

      String result = format.format(date);
      out.print(result);%></td>
  </tr>
  </tbody>
</table>

<table width="100%" height="193" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="#D9E9FF" style="border-collapse:collapse">
  <tbody>
  <tr align=middle bgColor=#ffffff>
    <td colspan="2" bgColor=#CADCEA><strong>生活时光分享平台</strong></td>
  </tr>
  <tr align=middle bgColor=#ffffff>
    <td width="10%" align="left" >系统作者：</td>
    <td width="41%"  align="left" ><font class="t4">孔</font></td>
  </tr>
  <tr align=middle bgColor=#ffffff>
    <td align="left"  >指导老师：</td>
    <td  align="left" >柳老师</td>
  </tr>
  <tr align=middle bgColor=#ffffff>
    <td align="left"  >联系方式：</td>
    <td  align="left" ><font class="t41">151****8422</font></td>
  </tr>
  </tbody>
</table>
<p>&nbsp;</p>
<P align=right>&nbsp;</P>
</body>
</html>

