<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" 
prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" 
prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" 
prefix="form" %>
<%@ page session="false" %>
    
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Sign Up </title>

    <!-- Font Icon -->
    <link rel="stylesheet" href="${pageContext.request.contextPath }/webjars/fonts1/material-icon/css/material-design-iconic-font.min.css">

    <!-- Main css -->
    <link rel="stylesheet" href="${pageContext.request.contextPath }/webjars/css/style.css">
</head>
<body>

    <div class="main">
        <div class="container">
            <div class="signup-content">
            
            <div class="col-md-2">
           
                <div class="signup-img"  >
            
                    <img src="${pageContext.request.contextPath }/webjars/imagessignup/login.jpg" alt="" width="550" height="550">
                </div>
                
                
                </div>
                
                
                   <div class="col-md-5">
                <div class="signup-form">
                    <form:form  action="add" method="POST"  modelAttribute="register1" class="register-form"  id="register-form">
                        <h2>student registration form</h2>
                        
                      
			   <c:if test="${!empty register1.userName}"><br/>
		<form:label path="userId">
				<spring:message text="User ID"/>
			</form:label>
		<form:input path="userId" readonly="true" 
			size="10"  disabled="true" />
			<form:hidden path="userId" />
	 </c:if> 
                        
                        <div class="form-row">
                            <div class="form-group">
                                <label for="name">FullName :</label>
                                <input type="text" name="userName" id="name" required/>
                            </div>
                            
                        </div>
                        <div class="form-group">
                            <label for="email">Email ID :</label>
                            <input type="email" name="userEmail" id="email" />
                        </div>
                        <div class="form-group">
                            <label for="password">Password :</label>
                            <input type="password" name="password" id="password" />
                        </div>
                        <div class="form-group">
                            <label for="mobileNumber">Mobile Number :</label>
                            <input type="number" name="phoneNo" id="mobileNumber" />
                        </div>
                       
                        <div class="form-row">
                            <div class="form-group">
                                <label for="state">State :</label>
                                <div class="form-select">
                                    <select  name="State" id="state">
                                        <option value=""></option>
                                        <option value="India">Maharashtra</option>
                                        <option value="India">Delhi</option>
                                        <option value="India">Kerala</option>
                                        <option value="India">Rajasthan</option>
                                        <option value="India">Uttar pradesh</option>
                                        <option value="India">Himachal</option>
                                    </select>
                                    <span class="select-icon"><i class="zmdi zmdi-chevron-down"></i></span>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="city">City :</label>
                                <div class="form-select">
                                    <select  name="city" id="city">
                                        <option value=""></option>
                                        <option value="Mumbai">Mumbai</option>
                                        <option value="Navi Mumbai">Navi Mumbai</option>
                                    </select >
                                    <span class="select-icon"><i class="zmdi zmdi-chevron-down"></i></span>
                                </div>
                            </div>
                        </div>
                        
                        <div class="form-group">
                            <label for="course">Qualification :</label>
                            <div class="form-select">
                                <select name="qualification" id="course">
                                    <option value=""></option>
                                    <option value="engineering">BE</option>
                                    <option value="engineering">ME</option>
                                    <option value="engineering">MCA</option>
                                </select>
                                <span class="select-icon"><i class="zmdi zmdi-chevron-down"></i></span>
                            </div>
                      
                       
                        <div class="form-submit">
                            <input type="submit" value="Reset All" class="submit" name="reset" id="reset" />
                            <input type="submit" value="Submit Form" class="submit" name="submit" id="submit" />
                        </div>
                    </form:form>
                </div>
                 </div>
            </div>
        </div>

    </div>

    <!-- JS -->
    <script src="${pageContext.request.contextPath }/webjars/vendorsignup/jquery/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath }/webjars/js/main1.js"></script>
</body>
</html>