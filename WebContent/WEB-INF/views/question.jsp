<%@ taglib uri="http://java.sun.com/jsp/jstl/core" 
prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" 
prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" 
prefix="form" %>
<%@ page session="false" %>
<html>
<head>
	<title>Question Page</title>
	<link href="${pageContext.request.contextPath}/WEB-INF/styles/mystyle.css" rel="stylesheet" />
	<style>
.error {
	color: red;
	font-style: italic;
	font-weight: bold;
}
body{
  background-color: #d5d8ca;
}
td{
font-family: Arial, Helvetica, sans-serif;
font-weight: bold;}
table {
  border: 3px solid black;
   width: 100%;
}
th {
  height: 50px;
}
input[type=text], select {
  width: 100%;
  padding: 12px 30px;
  margin: 8px 0;
  display: inline-block;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;
}
input[type=submit]:hover {
 width: 100%;
 }
 div {
  border-radius: 25px;
  background-color: #f2f2f2;
  padding: 20px;
}

</style>
</head>
<body>
<h1>
	Add a Question
</h1>
<c:url var="addAction" value="question/add"  ></c:url>
<form:form action="${addAction}"  modelAttribute="ques" >

<table border="1">
	<%-- <c:if test="${!empty ques.questions.question}"> --%>
	<tr>
		<td>
			<form:label path="question_id">
				<spring:message text="Question ID"/>
			</form:label>
		</td>
		<td>
			<form:input path="question_id" readonly="true" 
			size="8"  disabled="true" />
			<form:hidden path="question_id" />
		</td> 
	</tr>
	<%-- <form:input path="${questionSet.questionset_id}"/>
	
		<tr>
				<td>
			<div class="dropdown generate-file">
			Topic:<form:select  id ="ans2" path="${questionSet.Topic}" >
		<option value="java">java</option>
		<option value="html">html</option>
		<option value="sql">sql</option>
		
		</div>
		<form:errors path="${questionSet.Topic}" cssClass="errors"></form:errors>
			</form:select>
		</td> 	</tr>
	
	<tr>
				<td>
			<div class="dropdown generate-file">
			Level:<form:select  id ="ans2" path="${questionSet.level}" >
		<option value="1">1</option>
		<option value="2">2</option>
		<option value="3">3</option>
		
		</div>
		<form:errors path="${questionSet.level}" cssClass="errors"></form:errors>
			</form:select>
		</td> 	</tr>
	 --%>
	
	<%-- </c:if> --%>
	
	<%-- <spring:bind path="question.question">
   <input type="text" name="${question.expression}" value="${question.value}"><br />
        </spring:bind> --%>
	
	<%-- <spring:bind path="${question.question}"> --%>
	<form:input path="questionset_id"/>
	<tr>
	<td>
			<div class="dropdown generate-file">
			Topic:<form:select path="topic" >
		<option value="jav1">java</option>
		<option value="htmll">html</option>
		<option value="sqll">sql</option>
		
		</div>
		<form:errors path="topic" cssClass="errors"></form:errors>
			</form:select>
			<%-- <input type="submit"
					value="<spring:message 
					text="AddTopic"/>" /> --%>
		</td> 	</tr>
	
	<tr>
				<td>
			<div class="dropdown generate-file">
			Level:<form:select  path="lev" >
		<option value="1">1</option>
		<option value="2">2</option>
		<option value="3">3</option>
		
		</div>
		<form:errors path="lev" cssClass="errors"></form:errors>
			</form:select>
			
		</td> 	</tr>
	
	
	<td>
			<form:label path="question">
				<spring:message text="Question"/>
			</form:label>
		</td>
		<td>
			<form:input path="question" />
			<form:errors path="question" cssClass="errors"></form:errors>
		</td> 
	<tr>
	<form:label path="option1">
				<%-- <spring:message text="Answer"/> --%>
			</form:label>
			<td>
			<form:input path="option1" />
			<form:errors path="option1" cssClass="errors"></form:errors>
		</td> 
		</tr>
		<tr>
				<form:label path="option2">
			<%-- 	<spring:message text="Answer"/> --%>
			</form:label>
			<td>
			<form:input path="option2" />
			
			<form:errors path="option2" cssClass="errors"></form:errors>
		</td> 	</tr>
		
		<tr>
				<form:label path="option3">
		<%-- 		<spring:message text="Answer"/> --%>
			</form:label>
			<td>
			<form:input path="option3" />
			
			<form:errors path="option3" cssClass="errors"></form:errors>
		</td> 	</tr>
		<tr>
				<form:label path="option4">
				<%-- <spring:message text="Answer"/> --%>
			</form:label>
			<td>
			<form:input path="option4" />
			
			<form:errors path="option4" cssClass="errors"></form:errors>
		</td> 	</tr>
		
		<tr>
				<form:label path="rightanswer">
				<%-- <spring:message text="Answer"/> --%>
			</form:label>
			<td>
			<div class="dropdown generate-file">
			Rightanswer:<form:select   path="rightanswer" >
		<option value="1">option1</option>
		<option value="2">option2</option>
		<option value="3">option3</option>
		<option value="4">option4</option>
		</div>
			
			
			<form:errors path="rightanswer" cssClass="errors"></form:errors>
			</form:select>
		</td> 	</tr>
		
			<tr>
				<td>
			<%-- <div class="dropdown generate-file">
			Rightanswer1:<form:select   path="rightanswer1" >
		<option value="0">option0</option>
		<option value="1">option1</option>
		<option value="2">option2</option>
		<option value="3">option3</option>
		<option value="4">option4</option>
		</div>
		<form:errors path="rightanswer1" cssClass="errors"></form:errors>
			</form:select> --%>
		</td> 	</tr>
	<tr>
		<td colspan="2">
		 <c:if test="${!empty question.question}">
				<input type="submit"
					value="<spring:message 
					text="List Question"/>" />
					</c:if>
			<c:if test="${empty question}">
				<input type="submit"
					value="<spring:message 
					text="Add Question"/>" />
			</c:if>

		</td>
	</tr>
		</table>	
	</form:form> 
<br>
<h3>Questions List</h3>
<c:if test="${!empty listQuestions}">
	<table class="tg" border="1">
	<tr>
	<th width="80">Topic</th>
	<th width="80">Level</th>
		<th width="80">Question ID</th>
		<th width="120">Question</th>
		<th width="120">Option1</th>
	<th width="120">Option2</th>
	<th width="120">Option3</th>
	<th width="120">Option4</th>
	<th width="120">Right Answer</th>
	<th width="120">Right Answer1</th>
	<%-- 	<th width="60">Edit</th>--%>
		<th width="60">Delete</th>
	</tr>
	<c:forEach items="${listQuestions}" var="question">
		<tr>
		<td>${question.topic}</td>
		<td>${question.lev}</td>
			<td>${question.question_id}</td>
			<td>${question.question}</td>
			<td>${question.option1}</td>
			<td>${question.option2}</td>
			<td>${question.option3}</td>
			<td>${question.option4}</td>
			<td>${question.rightanswer}</td>
			
		
	<%--	<td><a href="
			<c:url value='/edit/${question.question_id}' />" >Edit</a></td> --%>	
			<td><a href="
			<c:url value='/delete/${question.question_id}' />" >Delete</a>
			</td>
		</tr>
	</c:forEach>
	</table>
</c:if>
</body>
</html>
