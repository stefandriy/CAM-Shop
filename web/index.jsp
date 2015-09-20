<%@ page import="com.cam.shop.entity.Category" %>
<%@ page import="com.cam.shop.dao.CategoryDAO" %>
<%@ page import="java.util.List" %>
<%@ page import="com.cam.shop.dao.CityDAO" %>
<%@ page import="com.cam.shop.entity.City" %>
<%@ page import="com.cam.shop.dao.UserDAO" %>
<%@ page import="com.cam.shop.entity.User" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp" %>
	<div id="container">
		<div id="content">
			<h1 class="title">Top rated</h1>
			<a href="" ><div class="content_entry">
				<img src="./img/Air_black.jpg" alt="MacBook Air">
				<div class="entry_name">Apple MacBook Air</div>
				<div class="entry_price">600$</div>
			</div></a>
			<a href=""><div class="content_entry">
				<img src="./img/hp-transformer.jpg" alt="HP Transformer">
				<div class="entry_name">HP Transformer</div>
				<div class="entry_price">600$</div>			
			</div></a>
			<a href="" ><div class="content_entry">
				<img src="./img/Laptop-Asus-UL30A.jpg" alt="ASUS Laptop">
				<div class="entry_name">ASUS Laptop UL30A (white)</div>
				<div class="entry_price">600$</div>			
			</div></a>
			<a href="" ><div class="content_entry">
				<img src="./img/pink-hp.png" alt="HP Pink">
				<div class="entry_name">HP Pink</div>
				<div class="entry_price">600$</div>
			</div></a>
			<a href="" ><div class="content_entry">
				<img src="./img/Apple-iPhone-6-Plus.jpg" alt="Apple iPhone 6">
				<div class="entry_name">Apple iPhone 6</div>	
				<div class="entry_price">600$</div>		
			</div></a>
			<a href="" ><div class="content_entry">
				<img src="./img/transformer_t300e.png" alt="ASUS Transformer">
				<div class="entry_name">HP Transformer</div>
				<div class="entry_price">600$</div>			
			</div></a>
		</div>	
<%@include file="sidebar.jsp" %>

	</div>
<%@include file="footer.jsp" %>
