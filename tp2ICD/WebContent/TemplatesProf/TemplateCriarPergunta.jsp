<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<jsp:include page="../JSPIncludes/standardHead.jsp" />
<body>
	<div class="limiter">
		<div class="container-login100" style="background-image: url('../images/bg-01.jpg');">
			<div class="wrap-login100" style="width: 70%;">
				<form class="login100-form validate-form" action="${pageContext.request.contextPath}/submitNewQuestion" method="POST" onSubmit="return validateNewQuestion()">

					<span class="login100-form-title p-b-34 p-t-27" style="padding-top: 0px; font-size: 45px;">Create new question</span>

					<div class="custom-select" style="border-radius: 10px; margin-bottom: 60px;">
						<select id="district-name">
							<option value="0" selected="selected">Select theme:</option>
							<%
								pageContext.getOut().write("" + (session.getAttribute("themesOpc")));
							%>
						</select> <input class="select-selected" name="district-name2" id="district-name2" value="Select theme:" style="background-color: #ececec; border-radius: 10px;" readonly>
						<div class="select-items select-hide" id="teste">
							<%
								pageContext.getOut().write("" + (session.getAttribute("themesDiv")));
							%>
						</div>

						<div class="combobox combobox-list" style="position: relative;">
							<label for="cb1-input" style="font-family: Poppins-Medium; color: #fff; font-size: 24px;">Question</label>
							<div class="group">
								<input id="cb1-input" name="cb1-input" class="cb_edit" type="text" role="combobox" aria-autocomplete="list" aria-expanded="false" aria-controls="cb1-listbox"
									style="border-radius: 10px; padding: 10px; height: 45px; width: 310px; font-size: 17px; background-color: #E0E0E0; color: #383838"
								>
								<button id="cb1-button" tabindex="-1" aria-label="Open" type="button" class="btn-drop"
									style="border-radius: 10px; position: absolute; top: 0; left: 409px; border: 0px solid transparent; background-color: #E0E0E0; font-size: 20px; width: 40px; height: 45px;"
								>V</button>
							</div>

							<ul id="cb1-listbox" role="listbox" aria-label="States" style="position: absolute; top: 50px; left: 113px; border-radius: 10px; width: 330px; background-color: #E0E0E0;">
								<%
									pageContext.getOut().write("" + (session.getAttribute("questions")));
								%>
							</ul>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>

</body>
</html>