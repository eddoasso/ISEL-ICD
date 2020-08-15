<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<jsp:include page="../JSPIncludes/standardHead.jsp" />
<body>

	<jsp:include page="../JSPIncludes/headerWithUser.jsp"></jsp:include>

	<div class="limiter">
		<div class="container-login100"
			style="background-image: url('../images/bg-01.jpg');">
			<div class="wrap-login100" style="width: 70%;">
				<form class="login100-form validate-form"
					action="handleSendQuestion" method="POST"
					onSubmit="return validateQuestions()">
					
					
					<span class="login100-form-title p-b-34 p-t-27"
						style="padding-top: 0px; font-size: 45px;">Send Questions</span>
						<% if (session.getAttribute("submitQuest") != null) {  %>
							<% if (session.getAttribute("submitQuest").equals("success")) {  %>
								<span class="login100-form-title p-b-34 p-t-27" style="font-size: 32px;color: #89cff0">Question submited with success</span>
							<% }else if(session.getAttribute("submitQuest").equals("failure")){%>
								<span class="login100-form-title p-b-34 p-t-27" style="font-size: 32px;color: #ff6666">Question not submited with success</span>
							<% }%>
						<% }%>
						<span class="login100-form-title p-b-34 p-t-27" style="font-size: 25px;">Choose Theme</span>

					<div class="custom-select"
						style="border-radius: 10px; margin-bottom: 60px;">
						<select id="district-name">
							<option value="0" selected="selected">Select theme:</option>
							<% pageContext.getOut().write("" +(session.getAttribute("themesOpc")));%>
						</select> <input class="select-selected" name="district-name2" id="district-name2"
							value="Select theme:"
							style="background-color: #ececec; border-radius: 10px;" readonly>
						<div class="select-items select-hide" id="teste">
							<% pageContext.getOut().write("" +(session.getAttribute("themesDiv")));%>
						</div>
					</div>


					<div class="combobox combobox-list" style="position: relative;">
						<label for="cb1-input"
							style="font-family: Poppins-Medium; color: #fff; font-size: 24px;">Question</label>
						<div class="group">
							<input id="cb1-input" name="cb1-input" class="cb_edit"
								type="text" role="combobox" aria-autocomplete="list"
								aria-expanded="false" aria-controls="cb1-listbox"
								style="border-radius: 10px; padding: 10px; height: 45px; width: 310px; font-size: 17px; background-color: #E0E0E0; color: #383838">
							<button id="cb1-button" tabindex="-1" aria-label="Open"
								type="button" class="btn-drop"
								style="border-radius: 10px; position: absolute; top: 0; left: 409px; border: 0px solid transparent; background-color: #E0E0E0; font-size: 20px; width: 40px; height: 45px;">V</button>
						</div>

						<ul id="cb1-listbox" role="listbox" aria-label="States"
							style="position: absolute; top: 50px; left: 113px; border-radius: 10px; width: 330px; background-color: #E0E0E0;">
							<%
								pageContext.getOut().write("" + (session.getAttribute("questions")));
							%>
						</ul>
					</div>


					<div class="wrap-input100 validate-input"
						data-validate="Enter username"
						style="margin-top: 40px; width: 21%">
						<input id="question-time" name="question-time" class="input100"
							type="text" placeholder="Question time in seconds" /> <span
							class="focus-input100" data-placeholder="&#xf179;"></span>
					</div>




					<!-- Opções de resposta -->
					<section style="padding: 40px 0;">


						<div>
							<label for="lab1"
								style="font-family: Poppins-Medium; color: #fff; font-size: 24px;">Opcions</label>
							<label for="check1"
								style="font-family: Poppins-Medium; color: #fff; font-size: 24px; margin-left: 81%">Answers</label>
						</div>



						<div style="display: flex; align-items: center" id="lab1">
							<label for="op1"
								style="font-family: Poppins-Medium; color: #fff; font-size: 24px; padding-right: 20px;">A:</label>
							<div class="wrap-input100 validate-input"
								data-validate="Enter password" style="width: 80%;">
								<input id="op1" name="op1" class="input100" type="text"
									placeholder="Opcion 1" style="padding: 0px; margin-top: 20px;"
									disabled />
							</div>
							<input type="checkbox" id="op-a" name="op-a" value="a"
								style="margin-left: 10%;" disabled>
						</div>

						<div style="display: flex; align-items: center">
							<label for="op2"
								style="font-family: Poppins-Medium; color: #fff; font-size: 24px; padding-right: 20px;">B:</label>
							<div class="wrap-input100 validate-input"
								data-validate="Enter password" style="width: 80%;">
								<input id="op2" name="op2" class="input100" type="text"
									placeholder="Opcion 2" style="padding: 0px; margin-top: 20px;"
									disabled />
							</div>
							<input type="checkbox" id="op-b" name="op-b" value="a"
								style="margin-left: 10%;" disabled>
						</div>



						<div style="display: flex; align-items: center">
							<label for="op3"
								style="font-family: Poppins-Medium; color: #fff; font-size: 24px; padding-right: 20px;">C:</label>
							<div class="wrap-input100 validate-input"
								data-validate="Enter password" style="width: 80%;">
								<input id="op3" name="op3" class="input100" type="text"
									placeholder="Opcion 3" style="padding: 0px; margin-top: 20px;"
									disabled />
							</div>
							<input type="checkbox" id="op-c" name="op-c" value="a"
								style="margin-left: 10%;" disabled>
						</div>

						<div style="display: flex; align-items: center">
							<label for="op4"
								style="font-family: Poppins-Medium; color: #fff; font-size: 24px; padding-right: 20px;">D:</label>
							<div class="wrap-input100 validate-input"
								data-validate="Enter password" style="width: 80%;">
								<input id="op4" name="op4" class="input100" type="text"
									placeholder="Opcion 4" style="padding: 0px; margin-top: 20px;"
									disabled />
							</div>
							<input type="checkbox" id="op-d" name="op-d" value="a"
								style="margin-left: 10%;" disabled>
						</div>

						<div style="display: flex; align-items: center">
							<label for="op5"
								style="font-family: Poppins-Medium; color: #fff; font-size: 24px; padding-right: 20px;">E:</label>
							<div class="wrap-input100 validate-input"
								data-validate="Enter password" style="width: 80%;">
								<input id="op5" name="op5" class="input100" type="text"
									placeholder="Opcion 5" style="padding: 0px; margin-top: 20px;"
									disabled />
							</div>
							<input type="checkbox" id="op-e" name="op-e" value="a"
								style="margin-left: 10%;" disabled>
						</div>

						<div style="display: flex; align-items: center">
							<label for="op6"
								style="font-family: Poppins-Medium; color: #fff; font-size: 24px; padding-right: 20px;">F:</label>
							<div class="wrap-input100 validate-input"
								data-validate="Enter password" style="width: 80%;">
								<input id="op6" name="op6" class="input100" type="text"
									placeholder="Opcion 6" style="padding: 0px; margin-top: 20px;"
									disabled />
							</div>
							<input type="checkbox" id="op-f" name="op-f" value="a"
								style="margin-left: 10%;" disabled>
						</div>
					</section>


					<div style="margin-bottom: 40px;">
						<input id="all-students" name="all-students" type="button"
							value="All students" class="btn btn-secondary"
							style="margin-left: 5%; width: 40%; background-color: #7D746C; height: 40px; font-size: 19px;">
						<input id="random-student" name="random-student" type="button"
							value="Random students" class="btn btn-secondary"
							style="margin-left: 10%; width: 40%; background-color: #f7fbfe; color: #111; height: 40px; font-size: 19px;">
					</div>

					<div class="contact100-form-checkbox">
						<input class="input-checkbox100" id="ckb1" type="checkbox"
							name="remember-me" /> <label class="label-checkbox100"
							for="ckb1">Edit question</label>
					</div>

					<div style="margin-bottom: 40px;">
						<button id="reset-all" type="button" value="picked"
							class="btn btn-secondary"
							style="background-color: #6ab4da; font-size: 19px; border-radius: 10px;">Reset</button>
					</div>

					<div class="container-login100-form-btn">
						<div class="wrap-login100-form-btn">
							<div class="login100-form-bgbtn"></div>
							<button class="login100-form-btn" type="submit" value="Entrar">
								Submit</button>
						</div>
					</div>
					<p id="invalid" class="invalid"
						style="font-size: 16px; color: #e5e5e5; padding-top: 15px" />
					<div class="text-center p-t-90" style="padding-top: 30px;">
						<a class="txt1" href="TemplateCriarPergunta.jsp"
							style="font-size: 16px;"> Add question to server </a>
					</div>
				</form>
			</div>
		</div>
	</div>

	<!-- ======= Footer ======= -->
	<footer id="footer" style="background-color: #bbb">
		<div class="container d-md-flex footerReset"
			style="padding-bottom: 0.6rem !important; padding-top: 0.75rem !important;">
			<div class="mr-md-auto text-center text-md-left"
				style="line-height: 35px; text-align: center;">
				<div class="copyright">&copy; Copyright. All Rights Reserved</div>
			</div>
		</div>
	</footer>

	<a href="#" class="back-to-top"><i class="icofont-simple-up"></i></a>
	<script src="../scripts/comboBox2/comboBox2.js"></script>
	<script src="../scripts/editChoose.js"></script>

	<script>
		selectorDistrict();
		document.addEventListener("click", closeAllSelect);
		resetAll();
	</script>
	<%
		pageContext.getOut().write("" + (session.getAttribute("infoQuest")));
	%>

</body>

</html>