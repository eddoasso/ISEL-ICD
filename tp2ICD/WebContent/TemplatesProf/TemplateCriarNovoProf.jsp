<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<jsp:include page="../JSPIncludes/standardHead.jsp" />
<body>
	<div class="limiter">
		<div class="container-login100" style="background-image: url('../images/bg-01.jpg');">
			<div class="wrap-login100">
				<form action="handleNewProf" class="login100-form validate-form" method="POST" onSubmit="return validateNewProf()">

					<span class="login100-form-logo"> <i class="zmdi zmdi-accounts-alt"></i>
					</span> <span class="login100-form-title p-b-34 p-t-27"> New Teacher </span>

					<div class="wrap-input100 validate-input" data-validate="Enter username">
						<input id="username" name="username" class="input100" type="text" placeholder="New Username" onkeyup="checkIfUserNameIsValid()" /> <span class="focus-input100" data-placeholder="&#xf207;"></span>
					</div>

					<div class="wrap-input100 validate-input" data-validate="Enter password">
						<input id="password" name="password" class="input100" type="password" placeholder="Password" onkeyup="checkIfPasswordIsValid()" /> <span class="focus-input100" data-placeholder="&#xf191;"></span>
					</div>

					<div class="wrap-input100 validate-input" data-validate="Verify password">
						<input id="verify_password" name="verify_password" class="input100" type="password" placeholder="Confirm password" onkeyup="checkIfPassWordMatch()" /> <span class="focus-input100"
							data-placeholder="&#xf191;"
						></span>
					</div>

					<div class="container-login100-form-btn">
						<div class="wrap-login100-form-btn">
							<div class="login100-form-bgbtn"></div>
							<button class="login100-form-btn" type="submit" value="Registar">Register</button>
						</div>
					</div>

					<p id="invalid" class="invalid" style="font-size: 16px; color: #e5e5e5; padding-top: 15px" />

				</form>
			</div>
		</div>
	</div>
</body>
</html>