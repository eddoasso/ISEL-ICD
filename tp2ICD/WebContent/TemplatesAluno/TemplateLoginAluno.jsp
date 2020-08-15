<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="pt">
<jsp:include page="../JSPIncludes/standardHead.jsp" />
<body>
	<div class="limiter">
		<div class="container-login100"
			style="background-image: url('../images/bg-01.jpg');">

			<div class="wrap-login100">
				<form action="handleAlunoLogin" class="login100-form validate-form"
					method="POST" onSubmit="return validateStudentInfo()">
					<span class="login100-form-logo"> <i
						class="zmdi zmdi-graduation-cap"></i>
					</span> <span class="login100-form-title p-b-34 p-t-27"> Student
						information </span>

					<div class="wrap-input100 validate-input"
						data-validate="Enter name">
						<input id="firstname" name="firstname" class="input100"
							type="text" placeholder="Enter first name" /> <span
							class="focus-input100" data-placeholder="&#xf207;"></span>
					</div>

					<div class="wrap-input100 validate-input"
						data-validate="Enter name">
						<input id="lastname" name="lastname" class="input100" type="text"
							placeholder="Enter last name" /> <span class="focus-input100"
							data-placeholder="&#xf206;"></span>
					</div>

					<div class="wrap-input100 validate-input"
						data-validate="Enter number">
						<input id="number" name="number" class="input100" type="text"
							placeholder="Enter student number" /> <span
							class="focus-input100" data-placeholder="&#xf158;"></span>
					</div>

					<div class="wrap-input100 validate-input"
						data-validate="Enter birthday">
						<input id="birthday" name="birthday" class="input100" type="text"
							placeholder="Enter birthday" /> <span class="focus-input100"
							data-placeholder="&#xf122;"></span>
					</div>

					<div class="container-login100-form-btn">
						<div class="wrap-login100-form-btn">
							<div class="login100-form-bgbtn"></div>
							<button class="login100-form-btn" type="submit" value="Entrar">
								Submit</button>
						</div>
					</div>
				</form>
				<p id="invalid" class="invalid"
					style="font-size: 16px; color: #e5e5e5; padding-top: 15px; padding-bottom: 15px;" />
				<%
					if (session.getAttribute("errorSession") != null) {
				%>
				<h3 style="color: #cccccc;">The session has been destroyed
					please go back and enter key again</h3>
				<div class="text-center p-t-90">
					<form class="login100-form validate-form" action="handleLogout"
						method="POST">
						<button type="submit" class="txt1">Click here to reenter
							on the room</button>
					</form>
				</div>
				<%
					} else if (session.getAttribute("existingNumber") != null) {
				%>
				<h3 style="color: #cccccc;">The inputed number already exists,
					try a new one</h3>
				<%
					} else if (session.getAttribute("errorData") != null) {
				%>
				<h3 style="color: #cccccc;">The inputed data is not correct</h3>
				<%
					}
				%>

			</div>
		</div>
	</div>
	<div id="dropDownSelect1"></div>
</body>
</html>