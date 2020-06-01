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
	<title>申请</title>

	<link href="qtimages/lib/bootstrap/css/bootstrap.css" rel="stylesheet">
	<link rel="stylesheet" href="qtimages/css/index.css">
</head>
<%
	if(request.getSession().getAttribute("username")==null)
	{
		out.print("<script>alert('对不起,请您先登陆!');location.href='index.do';</script>");
		return;
	}
	String id="";
%>



<script language="javascript">
    function checkform()
    {

    }
    function gow()
    {
        document.location.href="shenqingadd.jsp?id=<%=id%>";
    }
</script>


<body>
<jsp:include page="qttop.jsp"></jsp:include>
<jsp:include page="bht.jsp"></jsp:include>
<section id="introduce">
	<div class="container">
		<div class="head text-center">
			<h3>申请</h3>
		</div>

		<link rel="stylesheet" href="images/hsgcommon/divqt.css" type="text/css">
		<link rel="stylesheet" href="images/hsgcommon/commonqt.css" type="text/css">
		<script src="images/hsgcommon/common.js"></script>
		<script src="images/hsgcommon/bootbox.js"></script>
		<table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="#CCCCCC" style="border-collapse:collapse" class="newsline">
			<form action="addShenqing.do" name="form1" method="post">
				<tr >
					<td width="200">编号：</td>
					<td>
						<input name='bianhao' type='text' id='bianhao' value='' onblur='' class="form-control"  readonly='readonly' />
					</td>
				</tr>
				<script language="javascript">
					document.form1.bianhao.value='<%=connDbBean.readzd("qunzu","bianhao","id",request.getParameter("id"))%>';
					document.form1.bianhao.setAttribute("readOnly",'true');
				</script>
				<tr >
					<td width="200">创始人：</td>
					<td>
						<input name='chuangshiren' type='text' id='chuangshiren' value='' onblur='' class="form-control"  readonly='readonly' />
					</td>
				</tr>
				<script language="javascript">
					document.form1.chuangshiren.value='<%=connDbBean.readzd("qunzu","chuangshiren","id",request.getParameter("id"))%>';
					document.form1.chuangshiren.setAttribute("readOnly",'true');
				</script>
				<tr >
					<td width="200">名称：</td>
					<td>
						<input name='mingcheng' type='text' id='mingcheng' value='' onblur='' class="form-control"  readonly='readonly' />
					</td>
				</tr>
				<script language="javascript">
					document.form1.mingcheng.value='<%=connDbBean.readzd("qunzu","mingcheng","id",request.getParameter("id"))%>';
					document.form1.mingcheng.setAttribute("readOnly",'true');</script>
				<tr >
					<td width="200">类别：</td>
					<td>
						<input name='leibie' type='text' id='leibie' value='' onblur='' class="form-control"  readonly='readonly' />
					</td>
				</tr>
				<script language="javascript">
					document.form1.leibie.value='<%=connDbBean.readzd("qunzu","leixing","id",request.getParameter("id"))%>';
					document.form1.leibie.setAttribute("readOnly",'true');
				</script>
				<tr >
					<td width="200">申请人：</td>
					<td>
						<input name='shenqingren' type='text' id='shenqingren' value='<%=(String)request.getSession().getAttribute("username")%>' readonly="readonly"  onblur='' class="form-control" />
					</td>
				</tr>
				<tr >
					<td width="200">备注：</td>
					<td>
						<textarea name='beizhu' cols='50' rows='5' id='beizhu' onblur='' class="form-control" style="width:600px; height:80px;" >

						</textarea>
					</td>
				</tr>
				<tr align='center'   height="22">
					<td width="25%"  align="right">&nbsp;
					</td>
					<td width="75%"  align="left">
						<input type="submit" name="querenzhuce" id="querenzhuce" value="提交" onClick="return checkform();"/>
						<input type="reset" value="重置"/>&nbsp;
					</td>
				</tr>
			</form>
		</table>

		<script language="javascript">popheight = 450;</script>

	</div>
</section>
<jsp:include page="qtdown.jsp"></jsp:include>
<jsp:include page="qtuserlog.jsp"></jsp:include>
<script src="qtimages/lib/jquery/jquery.min.js"></script>
<script src="qtimages/lib/bootstrap/js/bootstrap.min.js"></script>
<script src="qtimages/js/index.js"></script>

</body>
</html>
