<%-- <%@ taglib uri="http://java.sun.com/jsp/jstl/core" 
prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" 
prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" 
prefix="form" %>
<%@ page session="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Topics</title>
</head>
<body>
<form:form action="questions"  modelAttribute="tl" >
	<form:label path="questionset_id">
				<spring:message text="Question ID"/>
			</form:label>
<form:input path="questionset_id"/>


	<form:label path="noofQuestions">
			</form:label>
			<td>
			<form:input path="noofQuestions" />
			<form:errors path="noofQuestions" cssClass="errors"></form:errors>
		</td> 
		<tr>
				<td>
			<div class="dropdown generate-file">
			Topic:<form:select path="Topic" >
		<option value="java">java</option>
		<option value="html">html</option>
		<option value="sql">sql</option>
		
		</div>
		<form:errors path="Topic" cssClass="errors"></form:errors>
			</form:select>
		</td> 	</tr>
	
	<tr>
				<td>
			<div class="dropdown generate-file">
			Level:<form:select  path="level" >
		<option value="1">1</option>
		<option value="2">2</option>
		<option value="3">3</option>
		
		</div>
		<form:errors path="level" cssClass="errors"></form:errors>
			</form:select>
			<input type="submit"
					value="<spring:message 
					text="AddTopic"/>" />
		</td> 	</tr>
		</form:form>
</body>
</html> --%>