<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/includes/header.jsp" %>
<div class ="container" align="center">
<button type="button" class="btn btn-secondary" onclick="location.href='/memberJoin' ">일반회원가입</button>
</div></br>
<div class ="container" align="center">
<button type="button" class="btn btn-secondary" onclick="location.href='/doctorJoin' ">의사회원가입</button>
</div></br>
<div class ="container" align="center">
<button type="button" class="btn btn-secondary" onclick="location.href='/adminJoin' ">관리자회원가입</button>
</div></br>
<%@ include file="/WEB-INF/views/includes/footer.jsp" %>