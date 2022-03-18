<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		<h1>도서 정보 관리 - 도서 정보</h1>
	<table border="1">
		<tr>
			<td rowspan="5"><img
				src="<c:url value='/image/${bookDto.savedfile }'/>" width="180"></td>
			<td>book isbn</td>
			<td>${bookDto.isbn}</td>
		</tr>
		<tr>
			<td>도서명</td>
			<td>${bookDto.bookname }</td>

		</tr>
		<tr>
			<td>저자</td>
			<td>${bookDto.writer }</td>
		</tr>
		<tr>
			<td>출판사</td>
			<td>${bookDto.pub }</td>

		</tr>
		<tr>
			<td>도서가격</td>
			<td>${bookDto.price }</td>

		</tr>
		<tr>
			<td>책소개</td>
			<td colspan="2">${bookDto.info }</td>
		</tr>
	</table>
	<input type="button" value="도서정보 목록"
			onclick="location.href='<c:url value="/list"/>'">


</body>
</html>