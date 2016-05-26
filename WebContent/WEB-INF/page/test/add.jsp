<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>

 <form action="/test/saveAndStart.do">
		 <p><label>订单编号：</label><input type="text" name="orderNo"> </p>
		 <p><label>订单类型：</label><input type="text" name="orderType"> </p>
		 <p><label>订单日期：</label><input type="text" name="orderDate"> </p>
		 <p><label>产品名称：</label><input type="text" name="orderProduct"> </p>
		 <button>提交</button>
</form>
	 
	 
</body>
</html>