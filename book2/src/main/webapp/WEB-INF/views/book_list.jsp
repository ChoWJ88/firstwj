<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>도서관리</title>
</head>
<body>
	<h1>도서 정보 관리 - 도서 리스트</h1>
	<form:form commandName="searchCommand" action="search" method="get">
		<form:select path="searchType">
			<form:option value="bookname">책이름</form:option>
			<form:option value="writer">저자</form:option>
			<form:option value="pub">출판사</form:option>
		</form:select>
		<form:input path="searchValue" placeholder="책이름 or 저자or 출판사" />
		<input type="submit" value="검색">
		<form:errors path="searchValue" />
	</form:form>
	<table border="1">
		<tr>
			<th>등록 번호</th>
			<th>도서 표지</th>
			<th>도서 ISBN</th>
			<th>도서 제목</th>
			<th>저자</th>
			<th>출판사</th>
			<th>가격</th>
		</tr>
		<c:if test="${!empty book }">
			<c:forEach var="book" items="${book }">
				<tr>
					<td>${ book.num}</td>
					<td><img src="<c:url value="/image/${book.savedfile }"/>"
						width="160"></td>
					<td>${book.isbn }</td>
					<td><a href="<c:url value="/read/${book.num }"/>">${book.bookname }</a></td>
					<td>${ book.writer}</td>
					<td>${book.pub }</td>
					<td>${book.price }원</td>
				</tr>
			</c:forEach>
		</c:if>

		<!--
		<c:if test="${!empty sbook}">
			<c:forEach var="sbook" items="${sbook }">
				<tr>
					<td>${ sbook.num}</td>
					<td><img src="<c:url value="/image/${sbook.savedfile }"/>"
						width="160"></td>
					<td>${sbook.isbn }</td>
					<td><a href="<c:url value="/read/${sbook.num }"/>">${sbook.bookname }</a></td>
					<td>${ sbook.writer}</td>
					<td>${sbook.pub }</td>
					<td>${sbook.price }원</td>
				</tr>
			</c:forEach>

		</c:if>-->
		<c:if test="${empty book}">
			<tr><td colspan="7">정보없음</td></tr>
		</c:if>
	</table>
	<input type="button" value="도서정보 추가"
		onclick="location.href='<c:url value="/add"/>'">
	<input type="button" value="도서정보 목록"
		onclick="location.href='<c:url value="/list"/>'">

</body>
</html>