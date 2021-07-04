<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<body>
<table border="1">
		<form action="update" method="post">
			<tr>
				<td > 번호 </td>
				<td> <input type="text" name="seqno" value="${content_view.seqno}" readonly="readonly"> </td>
			</tr>
			<tr>
				<td > 이름 </td>
				<td> <input type="text" name="name" size = "20" value="${content_view.name}"> </td>
			</tr>
			<tr>
				<td> 전화번호 </td>
				<td> <input type="text" name="telno" size = "20" value="${content_view.telno}" > </td>
			</tr>
			<tr>
				<td> 주소 </td>
				<td> <input type="text" name="address" size = "20" value="${content_view.address }"> </td>
			</tr>
			<tr>
				<td> 전자우편 </td>
				<td> <input type="text" name="email" size = "20" value="${content_view.email }"> </td>
			</tr>
			<tr>
				<td> 관계 </td>
				<td> <input type="text" name="relation" size = "20" value="${content_view.relation }" > </td>
			</tr>
			<tr>
				<td colspan="2"> <input type="submit" value="입력">&nbsp;&nbsp;<a href="list">주소록 보기</a>&nbsp;&nbsp;<a href="delete?seqno=${content_view.seqno}">삭제</a></td>
			</tr>
		</form>
</table>
</body>
</html>