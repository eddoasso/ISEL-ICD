<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html lang="pt">
<jsp:include page="../JSPIncludes/standardHead.jsp" />

<body>
	<div class="limiter">
		<div class="container-login100"
			style="background-image: url('images/bg-01.jpg');">
			<div class="wrap-login100">
				<form class="login100-form validate-form" action="handleAccessRoom"
					method="POST" onSubmit="return validateKeyRoom()">
					<span class="login100-form-logo"> <i
						class="zmdi zmdi-graduation-cap"></i>
					</span> <span class="login100-form-title p-b-34 p-t-27"> Enter on
						room </span>

					<div class="wrap-input100 validate-input"
						data-validate="Enter password">
						<input id="key" name="key" class="input100" type="password"
							name="senha" placeholder="Key Password" /> <span
							class="focus-input100" data-placeholder="&#xf191;"></span>
					</div>

					<div class="contact100-form-checkbox">
						<input class="input-checkbox100" id="ckb1" type="checkbox"
							name="remember-me" /> <label class="label-checkbox100"
							for="ckb1"> Remember me </label>
					</div>

					<div class="container-login100-form-btn">
						<div class="wrap-login100-form-btn">
							<div class="login100-form-bgbtn"></div>
							<button class="login100-form-btn">Submit</button>
						</div>
					</div>
					<p id="invalid" class="invalid"
						style="font-size: 16px; color: #e5e5e5; padding-top: 15px" />
					<%
						if (session.getAttribute("errorKey") != null) {
					%>
					<h3 style="color: #cccccc; margin-top: 15px;">
						The key
						<%=session.getAttribute("errorKey")%>
						is not correct
					</h3>
					<%
						}
					%>
				</form>
			</div>
		</div>
	</div>

	<div id="dropDownSelect1"></div>
</body>
</html>