<%@page import="com.newlecture.web.dao.mybatis.MyBatisNoticeDao"%>
<%@page import="com.newlecture.web.vo.Notice"%>
<%@page import="java.util.List"%>
<%@page import="com.newlecture.web.dao.NoticeDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
	<!--코드블럭 -->
<%
	NoticeDao noticeDao = new MyBatisNoticeDao();
	String code=request.getParameter("c");
	Notice n=noticeDao.getNotice(code);
	request.setAttribute("n", n);
	

%>
<!------------------------------------------------------------------------->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CUSTOMER</title>
</head>
<body>
	<header id="header">
		<h1><img src="../images/logo.png" alt="뉴렉처"/></h1>
		
		<section>
			<h1>머릿말</h1>
	
			<nav>
				<h1>메인메뉴</h1>
				<ul>
					<li><a href="">학습가이드</a></li>
					<li><a href="">뉴렉과정</a></li>
					<li><a href="">강좌선택</a></li>
				</ul>
			</nav>
	
			<section>
				<h1>과정검색 폼</h1>
				<form>
					<fieldset>
						<legend>검색정보</legend>
							<label>과정검색</label>
							<input type="text"/>
						<input type="submit" value="검색"/>
					</fieldset>
				</form>
			</section>
						
			<nav>
				<h1>회원메뉴</h1>
				<ul>
					<li><a href="">HOME</a></li>
					<li><a href="">로그인</a></li>
					<li><a href="">회원가입</a></li>
				</ul>
			</nav>
			
			<nav>
				<h1>고객메뉴</h1>
				<ul>
					<li><a href="">마이페이지</a></li>
					<li><a href="">고객센터</a></li>
				</ul>
			</nav>
						
		</section>
	</header>
	

	<aside>
		<h1>고객센터</h1>
		
		<nav>
			<h1>고객센터 메뉴</h1>
			<ul>
				<li><a href="">공지사항</a></li>
				<li><a href="">1:1고객문의</a></li>
				<li><a href="">학습안내</a></li>
			</ul>
		</nav>
		
		<nav>
			<h1>추천사이트</h1>
			<ul>
				<li><a href="">
					<img src="../images/answeris.png" alt="answeris"/>
					</a></li>
				<li><a href="">
					<img src="../images/tune-a.png" alt="tune-a"/>
					</a></li>
			</ul>
		</nav>
		
	</aside>

	<main>
		<section>
		<h1>공지사항 내용</h1>
		
		<section>
			<h1>경로</h1>
			<ul>
				<li>Home</li>
				<li>고객센터</li>
				<li>공지사항</li>
			</ul>
		</section>
		
		<article>
		<h1>공지 내용${header["host"]}</h1>
			<dl>
				<dt>제목</dt>
				<dd>${requestScope.n["title"]}</dd>
				<dt>작성일</dt>
				<dd><f:formatDate value="${n.regDate}" pattern="yyyy-MM-dd"/></dd>
				<dt>작성자</dt>
				<dd>${n.writer}</dd>
				<dt>조회수</dt>
				<dd>${n.hit}</dd>
				<dt>첨부파일</dt>
				<dd></dd>
				<dt>내용</dt>
				<dd>${n.content}
				</dd>
			</dl>
		</article>
		
		<nav>
		<h1>버튼 목록</h1>
		<div>
		<a href="notice.jsp">목록</a>
		</div>
		</nav>
		
		
	</section>
	</main>

	<aside></aside>
	<footer>
		<section>
			<h1>뉴렉처</h1>
			
			<section>
			<h1>관리자 정보</h1>
				<dl>
					<dt>주소 :</dt>
					<dd>서울특별시 동대문구 장안1동 423-4번지 윤진빌딩 4층</dd>
					<dt>관리자메일 :</dt>
					<dd>admin@newlecture.com</dd>
					<dt>전화 :</dt>
					<dd>02-478-4084</dd>
					<dt>사업자 등록번호 :</dt>
					<dd>132-18-46763</dd>
					<dt>통신 판매업 신고제 :</dt>
					<dd>2013-서울강동-0969호</dd>
					<dt>상호 : </dt>
					<dd>뉴렉처</dd>
				</dl>
			</section>
			
			<section>				
			<h1>저작권 정보</h1>
				<p>Copyright ⓒ newlecture.com 2012-2014 All Right Reserved.
					Contact admin@newlecture.com for more information</p>
			</section>
		</section>
	</footer>

</body>
</html>