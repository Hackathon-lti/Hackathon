<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.*"  isELIgnored="false"%>
    <%@page import="com.lti.model.Question" %><%@ taglib uri="http://java.sun.com/jsp/jstl/core" 
prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" 
prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" 
prefix="form" %>
<%@ page session="true" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form:form action="fetchjavaques"  method="post">
<h3>Questions List</h3>
<%List <Question>list1 =  (List<Question>)session.getAttribute("list"); %> 

	<table class="tg" border="1">
	<tr>
		<th width="120">Question</th>
		<th width="120">Option1</th>
	<th width="120">Option2</th>
	<th width="120">Option3</th>
	<th width="120">Option4</th>
	
	</tr>
	<c:forEach items="${list}" var="question">
		<tr>
		<th>
			<td>${question.question}</td></th>
			<td><input  type="radio" name="option1" value="1">${question.option1}</td>
			<td><input  type="radio" name="option2" value="2">${question.option2}</td>
			<td><input  type="radio" name="option3" value="3">${question.option3}</td>
			<td><input  type="radio" name="option4" value="4">${question.option4}</td>
  </tr>
</c:forEach>
		</table><br>

	
		</center>
	</form:form>
<%-- 
			<tbody>
			<table style="width:100%">						
  <tr>
<th><%List <Question>list1 =  (List<Question>)session.getAttribute("list"); 
for(int i=0;i<list1.size(); i++){%><tr><% 
List <Question>newlist =  (List<Question>)session.getAttribute("list"); 
 for(Question q:newlist){
 out.println(q.getQuestion());}%></th>
  </tr>
  <tr>
    <td><input  type="radio" name="gender" value="1"><%
List <Question>newlist1 =  (List<Question>)session.getAttribute("list"); 
 for(Question q:newlist1){
 
 out.println(q.getOption1());}%><br>  </td><br>
    <td><input  type="radio" name="gender" value="2"><%
List <Question>newlist2 =  (List<Question>)session.getAttribute("list"); 
 for(Question q:newlist2){
 
 out.println(q.getOption2());}%><br>  </td><br>
    <td><input   type="radio" name="gender" value="3" ><%
List <Question>newlist3 =  (List<Question>)session.getAttribute("list"); 
 for(Question q:newlist3){
 
 out.println(q.getOption3());}%><br>  </td><br>
    <td><input  type="radio" name="gender" value="4" ><%
List <Question>newlist4 =  (List<Question>)session.getAttribute("list"); 
 for(Question q:newlist4){
 out.println(q.getOption4());}%><br>  </td>   <tr>
 
 <%} %>
  </tr>
  
   
</table>
	<!-- <button type="submit" value="Next">Next</button> -->
</table> --%>
			


</body>
</html>