<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>RegForm</title>
<script type="text/javascript">
	function setTumbnail() {
		let fileInfo = document.getElementById("imgFile").files[0];
		let reader = new FileReader();

		reader.onload = function() {
			document.getElementById("thumbnailImg").src = reader.result;
		}
		if (fileInfo) {
			reader.readAsDataURL(fileInfo);
		}
	}
</script>

</head>
<body>
	<h1>도서 정보 관리 - 도서 정보추가</h1>

	<form:form action="add" commandName="regForm" method="post"
		enctype="multipart/form-data">
		<table border="1">
			<tr>
				<td colspan="3" ><font color="red">*</font>표시는 필수입니다.</td>
			</tr>

			<tr>
				<td rowspan="6"><img src="" id="thumbnailImg" width="180"></td>
				<td><font color="red">*</font>BOOK ISBN</td>
				<td><form:input path="isbn" pattern="[0-9]+"
						placeholder="숫자만 입력" />
						<form:errors path="isbn" /></td>
			</tr>
			<tr>
				<td><font color="red">*</font>도서명</td>
				<td><form:input path="bookname" /><form:errors path="bookname" /></td>

			</tr>
			<tr>
				<td><font color="red">*</font>저자</td>
				<td><form:input path="writer" /><form:errors path="writer" /></td>
			</tr>
			<tr>
				<td><font color="red">*</font>출판사</td>
				<td><form:input path="pub" /><form:errors path="pub" /></td>

			</tr>
			<tr>
				<td><font color="red">*</font>도서가격</td>
				<td><form:input path="price" pattern="[0-9]+"
						placeholder="숫자만 입력" /><form:errors path="price" /></td>

			</tr>
			<tr>
				<td><font color="red">*</font>도서 이미지</td>
				<td><input type="file" id="imgFile" name="imgFile"
					value="${regForm.imgFile }" onChange="setTumbnail()"><form:errors path="imgFile" />
			<tr>
				<td><font color="red">*</font>책소개</td>
				<td colspan="2"><textarea name="info" rows="10" cols="45">${regForm.info}</textarea>
				<form:errors path="info" />
				</td>
			</tr>
		</table>
		
		<input type="submit" value="도서정보 추가">&nbsp;&nbsp;&nbsp;
		<input type="button" value="도서정보 목록"
			onclick="location.href='<c:url value="/list"/>'">

	</form:form>

</body>
</html>