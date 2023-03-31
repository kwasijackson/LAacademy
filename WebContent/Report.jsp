<%@page import="entities.LAStudents"%>
<%@page import="entities.LASubjects"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="entities.LAClasses"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Class Report</title>
</head>
<body>
<% LAClasses clazz=(LAClasses)request.getAttribute("clazz");
List<LASubjects> subjects =(ArrayList<LASubjects>) request.getAttribute("subjectslist");
List<LAStudents> students =(ArrayList<LAStudents>) request.getAttribute("studentlist");
%>
<h1><%=clazz.getClassName() %></h1>
<h2>Subjects</h2>
<div class="container">
<h1 align="center">List of Subjects</h1>
	<table class="table">
		<tr>
			<th>No.</th>
			<th>Subject Name</th>
			<th>Teacher Name</th>
                      
			
		</tr>
		<%
				int i=1;
				for(LASubjects subject:subjects){
					out.print("<tr><td>" + i + "</td>");
					out.print("<td>" + subject.getSubjectName() + "</td>");
					out.print("<td>" + subject.getTeacher().getTeacherName() + "</td></tr>");
					
					
					i++;
				}
			%>

	</table>
	<br>
	<h1 align="center">List of Students</h1>
	<table class="table">
		<tr>
			<th>No.</th>
			<th>Student Name</th>
			
			
		</tr>
		<%
				int j=1;
				for(LAStudents stu:students){
					out.print("<tr><td>" + j + "</td>");
					out.print("<td>" + stu.getStudentName() + "</td></tr>");
					
					j++;
				}
			%>

	</table>
	</div>

</body>
</html>