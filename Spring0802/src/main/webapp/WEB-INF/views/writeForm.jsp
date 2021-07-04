<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table cellpadding="0" cellspacing="0" border="1">
		<form action="write" method="post">
			<tr>
				<td > 번호 </td>
				<td> <input type="text" name="seqno" size = "20" readonly="readonly"> </td>
			</tr>
			<tr>
				<td > 이름 </td>
				<td> <input type="text" name="name" size = "20"> </td>
			</tr>
			<tr>
				<td> 전화번호 </td>
				<td> <input type="text" name="telno" size = "20" > </td>
			</tr>
			<tr>
				<td> 주소 </td>
				<td> <input type="text" name="address" size = "20" > </td>
			</tr>
			<tr>
				<td> 전자우편 </td>
				<td> <input type="text" name="email" size = "20" > </td>
			</tr>
			<tr>
				<td> 관계 </td>
				<td> <input type="text" name="relation" size = "20" > </td>
			</tr>
			<tr >
				<td colspan="2"> <input type="submit" value="입력"> &nbsp;&nbsp; <a href="list">주소록 보기</a></td>
			</tr>
		</form>
</table>
</body>
</html>