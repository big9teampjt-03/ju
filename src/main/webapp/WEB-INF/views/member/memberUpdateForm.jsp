<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../includes/header.jsp"%>


<div class="container">
	<h3>JOIN</h3>
	<div class="form-group">
		<label for="email">이메일:</label> <input type="email"
			class="form-control" id="email" placeholder="이메일을 입력하세요." readonly="readonly"
			name="email">
	</div>
	<input type="button" class="btn btn-secondary" onclick="btnEmail" value="중복확인"/>
	<div class="form-group">
		<label for="password">비밀번호:</label> <input type="password"
			class="form-control" id="password" placeholder="비밀번호를 입력하세요."
			name="password">
	</div>
	<div class="form-group">
			<label for="pass_check">비밀번호 확인:</label> <input type="password"
				class="form-control" id="pass_check" placeholder="비밀번호를 입력하세요."
				name="pass_check">
		</div>

	<div class="form-group">
		<label for="nick">닉네임:</label> <input type="text"
			class="form-control" id="nick" placeholder="닉네임을 입력하세요."
			name="nick">
	</div>
	<div class="form-group">
		<label for="tel">휴대폰번호:</label> <input type="text"
			class="form-control" id="tel" placeholder="전화번호를 입력하세요."
			name="tel">
	</div>
	<button class="btn btn-secondary" id="btnUpdate">회원가입</button>


</div>