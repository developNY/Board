<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>

	<table width="500" cellpadding="0" cellspacing="0" border="1">
		<tr>
			<td>��ȣ</td>
			<td>�̸�</td>
			<td>����</td>
		</tr>	
		<c:forEach items="${list}" var="dto">
		<tr>
			<td>${dto.bId}</td>
			<td>${dto.name}</td>
			<td><a href="content_view.do?bId=${dto.bId}">${dto.bTitle}</a></td>
		</tr>
		</c:forEach>
		<tr>
			<td colspan="5"> <a href="write_view.do">�� �ۼ�</a></td>
			</tr>
	</table>

</body>
</html>