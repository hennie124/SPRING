<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Mybatis 주소록 조건검색 리스트</title>
</head>
<body>

<h1>Mybatis 주소록 조건검색 </h1>

<form action="listQuery" method="post">
	검색선택:
	<select name="query">
		<option value="ADDRESS">주소</option>
		<option value="RELATION">관계</option>
	</select> &nbsp;&nbsp;&nbsp;
	
	<input type="text" name="content" size="30">
	<input type="submit" value="검색">
</form>
<br><br>

<table width="500" cellpadding="0" cellspacing="0" border="1">
	<tr>
		<td>번호</td>
		<td>작성자</td>
		<td>전화번호</td>
		<td>주소</td>
		<td>전자우편</td>
		<td>관계</td>
	<tr>
	<c:set var="cnt" value="0"/>
	<c:forEach items="${list}" var="contentDto">
	<tr>
		<td><a href = "content_view?seqno=${contentDto.seqno}">${contentDto.seqno}</a></td>
		<td>${contentDto.name}</td>
		<td>${contentDto.telno}</td>
		<td>${contentDto.address }</td>
		<td>${contentDto.email }</td>
		<td>${contentDto.relation }</td>
	<tr>
	<c:set var="cnt" value="${cnt=cnt+1 }"/>
	</c:forEach>
</table>
<p>검색결과는 <b>${cnt}</b>명 입니다.</p>

<p><a href="writeForm">주소록 등록</a></p>
</body>
</html>