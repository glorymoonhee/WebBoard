<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원가입페이지</title>
</head>
<body>
<!-- 
================
POST /WebBoard/board/doJoin HTTP/1.1
Host: localhost:8080
Connection: keep-alive
Content-Length: 22
Pragma: no-cache
Cache-Control: no-cache
Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8
Origin: http://localhost:8080
Upgrade-Insecure-Requests: 1
User-Agent: Mozilla/5.0 (Windows NT 6.3; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/44.0.2403.130 Safari/537.36
Content-Type: application/x-www-form-urlencoded
Referer: http://localhost:8080/WebBoard/board/join
Accept-Encoding: gzip, deflate
Accept-Language: ko-KR,ko;q=0.8,en-US;q=0.6,en;q=0.4
Cookie: JSESSIONID=FBE6FBC3DC6FF28AFFF986834E56DB25

userid=james&pass=1111

jquery!!!!!!!! 필수 
javascript     필수

====================
 -->
<form method="post" action="/WebBoard/board/doJoin">
	<div><span>아이디:</span><span><input name="userid" type="text"/></span> </div>
	<div><span>이메일:</span><span><input name="email" type="text"/></span> </div>
	<div><span>password</span><span><input name="pass" type="password"/></span></div>
	<input type="submit" value="가입하기">
</form>
</body>
</html>