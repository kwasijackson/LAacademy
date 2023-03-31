<%@page import="java.util.ArrayList"%>
<%@page import="entities.LATeachersDao"%>
<%@page import="entities.LATeachers"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>All Teachers</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
	crossorigin="anonymous"></script>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<div class="container-fluid">
			<a class="navbar-brand" href="#">LA</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>

			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav me-auto mb-2 mb-lg-0">
					<li class="nav-item"><a class="nav-link"
						 href="index.html">Home</a></li>
					<li class="nav-item"><a class="nav-link" href="addClass.jsp">Add Class</a>
					</li>
					<li class="nav-item"><a class="nav-link" href="addStudent.jsp">Add Student</a>
					</li>
					<li class="nav-item"><a class="nav-link" href="addTeacher.jsp">Add Teacher</a>
					</li>
					<li class="nav-item"><a class="nav-link" href="addSubject.jsp">Add Subject</a>
					</li>
				</ul>
			</div>
		</div>
	</nav>

<%
			ArrayList<LATeachers> teacherlist= new ArrayList<LATeachers>();
            teacherlist=(ArrayList<LATeachers>) LATeachersDao.showAllteachers();
		%>
<div class="container">
<h1 align="center">List of Teachers</h1>
	<table class="table">
		<tr>
			<th>No.</th>
			<th>Class Name</th>
			
		</tr>
		<%
				int i=1;
				for(LATeachers teacher:teacherlist){
					out.print("<tr><td>" + i + "</td>");
					out.print("<td>" + teacher.getTeacherName() + "</td></tr>");
					i++;
				}
			%>

	</table>
	</div>

</body>
</html>