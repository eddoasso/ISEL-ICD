function validateLogin() {
	let username = document.getElementById("username");
	let password = document.getElementById("password");
	let invalid = document.getElementById("invalid");

	if (username.value === null || username.value === "") {
		username.focus();
		invalid.innerHTML = "Username can't be blank";
		return false;
	} else if (username.value.length < 4) {
		username.focus();
		invalid.innerHTML = "Username can't be have less than 4 characters";
		return false;
	} else if (username.value.length > 25) {
		username.focus();
		invalid.innerHTML = "Username can't have more than 25 characters";
		return false;
	} else if (!alphanumeric(username.value)) {
		username.focus();
		invalid.innerHTML = "Username can only contain numbers and letters";
		return false;
	} else if (password.value.length < 6 || password.value === "" || password.value === null) {
		password.focus();
		invalid.innerHTML = "Password must be at least 6 characters long";
		return false;
	} else if (password.value.length > 50) {
		password.focus();
		invalid.innerHTML = "Password can't have more than 50 characters";
		return false;
	} else if (!alphanumeric(password.value)) {
		password.focus();
		invalid.innerHTML = "Password can only contain numbers and letters";
		return false;
	}
	return true;
}

function validateKeyRoom() {
	let key = document.getElementById("key");
	let invalid = document.getElementById("invalid");

	if (key.value === null || key.value === "") {
		key.focus();
		invalid.innerHTML = "Key can't be blank";
		return false;
	} else if (key.value.length < 4) {
		key.focus();
		invalid.innerHTML = "Key can't be have less than 4 characters";
		return false;
	} else if (key.value.length > 25) {
		key.focus();
		invalid.innerHTML = "Key can't have more than 25 characters";
		return false;
	} else if (!alphanumeric(key.value)) {
		key.focus();
		invalid.innerHTML = "Key can only contain numbers and letters";
		return false;
	}

	return true;
}

function validateStudentInfo() {
	let firstName = document.getElementById("firstname");
	let lastName = document.getElementById("lastname");
	let number = document.getElementById("number");
	let birthday = document.getElementById("birthday");
	let invalid = document.getElementById("invalid");

	if (firstName.value === null || firstName.value === "") {
		firstName.focus();
		invalid.innerHTML = "First name can't be blank";
		return false;
	} else if (firstName.value.length < 2) {
		firstName.focus();
		invalid.innerHTML = "First name must have at least 3 characters";
		return false;
	} else if (firstName.value.length > 50) {
		firstName.focus();
		invalid.innerHTML = "First name can't have more than 50 characters";
		return false;
	} else if (!isLetter(firstName.value)) {
		firstName.focus();
		invalid.innerHTML = "First name can only contain letters";
		return false;
	}



	else if (lastName.value === null || lastName.value === "") {
		lastName.focus();
		invalid.innerHTML = "Last name can't be blank";
		return false;
	} else if (lastName.value.length < 2) {
		lastName.focus();
		invalid.innerHTML = "Last name must have at least 2 characters";
		return false;
	} else if (lastName.value.length > 50) {
		lastName.focus();
		invalid.innerHTML = "Last name can't have more than 50 characters";
		return false;
	} else if (!isLetter(lastName.value)) {
		lastName.focus();
		invalid.innerHTML = "Last name can only contain letters";
		return false;
	}



	else if (number.value === null || number.value === "") {
		number.focus();
		invalid.innerHTML = "Number can't be blank";
		return false;
	} else if (!isNumber(number.value)) {
		number.focus();
		invalid.innerHTML = "Student number must contain only numbers";
		return false;
	} else if (parseInt(number.value) < 1) {
		number.focus();
		invalid.innerHTML = "Number must be higher than 0";
		return false;
	} else if (parseInt(number.value) > 80000) {
		number.focus();
		invalid.innerHTML = "Number must be less than 80000";
		return false;
	}

	else if (birthday.value === null || birthday.value === "") {
		birthday.focus();
		invalid.innerHTML = "Birthday can't be blank";
		return false;
	} else if (!isDateFormat(birthday.value)) {
		birthday.focus();
		invalid.innerHTML = "Birthday is not on correct form, example: 02/06/1997";
		return false;
	}

	return true;
}


//validação submissão das perguntas
function validateQuestions() {
	let childCount = document.getElementById("teste").childElementCount;
	let question = document.getElementById("cb1-input");
	let questionCount = document.getElementById("cb1-listbox").childElementCount;
	let timer = document.getElementById("question-time");
	let invalid = document.getElementById("invalid");

	let choosedTheme = false;
	for (let i = 1; i < childCount + 1; i++) {
		let elemento = document.getElementById("d" + i);
		if (elemento.classList.contains("same-as-selected")) {
			document.getElementById("district-name2").value = elemento.textContent;
			choosedTheme = true;
			break;
		}
	}
	if (choosedTheme === false) {
		document.getElementById("district-name2").focus();
		invalid.innerHTML = "You must choose a theme";
		return false;
	}


	let choosedQuestion = false;
	let elemList = document.getElementsByName("q-name");
	for (let i = 0; i < elemList.length; i++) {
		if (question.value === elemList[0].textContent) {
			choosedQuestion = true;
			break;
		}

	}

	if (choosedQuestion === false) {
		question.focus();
		invalid.innerHTML = "You must have to introduce the whole question and the question must match with one of the opcions";
		return false;
	}



	if (!isNumber(timer.value) || timer.value === "" || timer.value == null) {
		timer.focus();
		invalid.innerHTML = "The time must be only numbers and it will be on seconds";
		return false;
	} else if (parseInt(timer.value) > 300) {
		timer.focus();
		invalid.innerHTML = "The time must be less than 300 seconds";
		return false;
	} else if (parseInt(timer.value) < 20) {
		timer.focus();
		invalid.innerHTML = "The time must be more than 20 seconds";
		return false;
	}


	let twoQuestsError = false;
	let wroteSeparated = false;
	let errorSeparated = false;
	let indexesWrite = [];
	for (let i = 1; i < 7; i++) {
		let elemento = document.getElementById("op" + i);
		if ((i === 1 || i === 2) && (elemento.value === "" || elemento.value == null)) {
			twoQuestsError = true;
			break;
		}
		else if (elemento.value === "" || elemento.value == null) {
			wroteSeparated = true;
		}
		else if (wroteSeparated && (elemento.value !== "" || elemento.value != null)) {
			errorSeparated = true;
			break;
		} else if (elemento.value !== "" && elemento.value != null) {
			indexesWrite.push(i);
			elemento.setAttribute("value", elemento.value);
		}
	}

	if (twoQuestsError === true) {
		document.getElementById("op1").focus();
		invalid.innerHTML = "You must have to write at least two questions on A and B";
		return false;
	}

	if (errorSeparated === true) {
		document.getElementById("op1").focus();
		invalid.innerHTML = "You can't write questions with blank align, like write on A,B and D it must be C";
		return false;
	}

	let oneChecked = false;
	for (let i = 0; i < indexesWrite.length; i++) {
		switch (i + 1) {
			case 1:
				if (document.getElementById('op-a').checked) {
					oneChecked = true;
				}
				break;
			case 2:
				if (document.getElementById('op-b').checked) {
					oneChecked = true;

				}
				break;
			case 3:
				if (document.getElementById('op-c').checked) {
					oneChecked = true;
				}
				break;
			case 4:
				if (document.getElementById('op-d').checked) {
					oneChecked = true;
				}
				break;
			case 5:
				if (document.getElementById('op-e').checked) {
					oneChecked = true;
				}
				break;
			case 6:
				if (document.getElementById('op-f').checked) {
					oneChecked = true;
				}
				break;
		}
	}

	if (oneChecked === false) {
		document.getElementById('op-a').focus();
		invalid.innerHTML = "You must have at least one question selected as correct";
		return false;
	}

	for (let i = 1; i < 7; i++) {
		document.getElementById("op" + i).disabled = false;
	}
	document.getElementById("op-a").disabled = false;
	document.getElementById("op-b").disabled = false;
	document.getElementById("op-c").disabled = false;
	document.getElementById("op-d").disabled = false;
	document.getElementById("op-e").disabled = false;
	document.getElementById("op-f").disabled = false;


	if (document.getElementById("all-students").style.backgroundColor == "rgb(125, 116, 108)") {
		ocument.getElementById("all-students").value = "picked";
		document.getElementById("all-students").type = "text";
	} else {
		document.getElementById("random-student").value = "picked";
		document.getElementById("random-student").type = "text";
	}

	return true;
}

function validateEmail(email) {
	const re = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
	return re.test(String(email).toLowerCase());
}

function alphanumeric(inputtxt) {
	let letterNumber = /^[a-z0-9]+$/i; // /^[0-9a-zA-Z]+$/
	return inputtxt.match(letterNumber);
}

function isAlphanumericOrSpace(inputtxt){
	let re = /^[a-z0-9 ]+$/i;
	return inputtxt.match(re);

}

function letterSpace(inputtxt) {
	let letterNumber = /[^\u0000-\u00ff]/;/*/^[A-Za-z ]+$/;*/
	return !inputtxt.match(letterNumber);
}

function validatorISO(str) {
	return !/[^\u0000-\u00ff]/g.test(str);
}

function isLetter(inputtxt) {
	let letterNumber = /^[a-zA-Z]+$/;
	return inputtxt.match(letterNumber);
}

function isNumber(inputtxt) {
	let letterNumber = /^\d+$/;
	return inputtxt.match(letterNumber);
}

function isDateFormat(inputtxt) {
	let letterNumber = /^(0?[1-9]|[12][0-9]|3[01])[\/\-](0?[1-9]|1[012])[\/\-]\d{4}$/;
	return inputtxt.match(letterNumber);
}


function checkIfUserNameIsValid() {
	let invalid = document.getElementById("invalid");
	let input = document.getElementById('username').value;

	if (!isAlphanumericOrSpace(input) || !(input.length > 4 && input.length < 64)) {
		invalid.innerHTML = "Nome apenas pode conter letras e numeros e tem de ter no minimo 4 letras";
	} else {
		invalid.innerHTML = "";
	}
}

function checkIfPasswordIsValid() {
	let reg = /^[A-Za-z]\w{7,15}$/;
	let invalid = document.getElementById("invalid");
	let input = document.getElementById('password').value;
	if (input === "" || input === null) {
		invalid.innerHTML = "Password cannot be empty";
	}
	else if (!input.match(reg)) {
		invalid.innerHTML =
			"Password must be between 7 to 16 characters and can only" +
			" contain characters, numeric digits, underscores" +
			" and the first character must be a letter.";
	} else {
		invalid.innerHTML = "";
	}
}



function checkIfPassWordMatch() {
	let p1 = document.getElementById('password').value;
	let p2 = document.getElementById('verify_password').value;
	let invalid = document.getElementById("invalid");

	if (p1 !== p2) {
		invalid.innerHTML = "Passwords do not match";
	} else {
		invalid.innerHTML = "";
	}
}


function validateNewProf() {
	return checkIfUserNameIsValid() && checkIfPasswordIsValid() && checkIfPassWordMatch();
}

/*function validateRegister() {
    if (validateLogin() === true) {
        let invalid = document.getElementById("invalid");
        let email = document.getElementById("email");
        if (validateEmail(email.value) === false) {
            email.focus();
            invalid.innerHTML = "You didn't introduce a valid email";
            return false;
        } else
            return true;
    } else
        return false;
}

function validateMessage() {
    let subject = document.getElementById("subject");
    let message = document.getElementById("message");
    let invalid = document.getElementById("invalid");

    if (subject.value.length < 3) {
        subject.focus();
        invalid.innerHTML = "Subject must have at least 3 characters";
        return false;
    } else if (message.value.length < 20) {
        message.focus();
        invalid.innerHTML = "Message must have more than 20 characters.";
        return false;
    } else if (subject.value.length > 40) {
        subject.focus();
        invalid.innerHTML = "Subject must have less than 40 characters.It has " + subject.value.length + " characters.";
        return false;
    } else if (message.value.length > 400) {
        message.focus();
        invalid.innerHTML = "Message can't have more than 400. It has " + message.value.length + " characters.";
        return false;
    }
}

function validateContent() {
    let image = document.getElementById("image");
    let district = document.getElementById("district-name2");
    let name = document.getElementById("monument-name");
    let content = document.getElementById("content");
    let invalid = document.getElementById("invalid");

    if (image.files.length === 0) {
        image.focus();
        invalid.innerHTML = "There's no image or video selected. Please select one type of content and submit again.";
        return false;
    } else if (image.files.length > 1) {//porque depois ficariam duas coisas com a mesma descrição
        image.focus();
        invalid.innerHTML = "It's only possible to submit one type of content at once.";
        return false;
    } else if (district.value === "Select district:") {
        district.focus();
        invalid.innerHTML = "You must select a district of the monument.";
        return false;
    } else if (name.value.length < 2) {
        district.focus();
        invalid.innerHTML = "The Monument name must have at least 2 characters.";
        return false;
    } else if (name.value.length > 40) {
        district.focus();
        invalid.innerHTML = "The Monument can only have 40 characters";
        return false;
    } else if (!letterSpace(name.value)) {
        district.focus();
        invalid.innerHTML = "The Monument name can only contains letters and spaces";
        return false;
    } else if (content.value.length < 10) {
        content.focus();
        invalid.innerHTML = "The description of the content must have more than 10 characters";
        return false;
    } else if (content.value.length > 1000) {
        content.focus();
        invalid.innerHTML = "The content must me less than 1000 characters.";
        return false;
    }
    return true;
}

function validateNewPassword() {
    let pass1 = document.getElementById("pass1");
    let pass2 = document.getElementById("pass2");
    let pass3 = document.getElementById("pass3");
    let invalid = document.getElementById("invalid");

    if (pass1.value.length < 6) {
        pass1.focus();
        invalid.innerHTML = "Your previous password must have at least 6 characters";
        return false;
    } else if (pass1.value.length > 50) {//porque depois ficariam duas coisas com a mesma descrição
        pass1.focus();
        invalid.innerHTML = "The password you had can only have in maximum 50 characters, it has" + pass1.value.length;
        return false;
    } else if (pass2.value.length < 6) {
        pass2.focus();
        invalid.innerHTML = "New password must have at least 6 characters";
        return false;
    } else if (pass2.value.length > 50) {
        pass2.focus();
        invalid.innerHTML = "The new password can only have in maximum 50 characters, it has" + pass2.value.length;
        return false;
    } else if (pass3.value.length < 6) {
        pass3.focus();
        invalid.innerHTML = "The confirmation password must have at least 6 characters";
        return false;
    } else if (pass3.value.length > 50) {
        pass3.focus();
        invalid.innerHTML = "The confirmation password can only have in maximum 50 characters, it has" + pass2.value.length;
        return false;
    } else if (pass3.value !== pass2.value) {
        pass3.focus();
        invalid.innerHTML = "The passwords dont match with each other";
        return false;
    }
    return true;
}
function validateContentUser() {
    let invalid = document.getElementById("invalid2");

    let selected = false;
    for(let a = 1;a < document.getElementById("teste").childElementCount+1;a++){
        if(document.getElementById("d"+a).className === "same-as-selected"){
            selected = true;
        }
    }
    if(!selected){
        document.getElementById("teste").focus();
        invalid.innerHTML = "You must have to selecte a content";
        return false;
    }
    return true;
}


function validateEditUser() {
    let email = document.getElementById("email");
    let pass = document.getElementById("pass");
    let newVal = document.getElementById("new");
    let invalid = document.getElementById("invalid");


    let selected = false;
    for(let a = 1;a < document.getElementById("teste").childElementCount+1;a++){
        if(document.getElementById("d"+a).className === "same-as-selected"){
            selected = true;
        }
    }
    if(!selected){
        document.getElementById("teste").focus();
        invalid.innerHTML = "You must have to selecte a user";
        return false;
    }

    if (email.checked) {
        if (!validateEmail(newVal.value)) {
            email.focus();
            invalid.innerHTML = "The new email is not valid, please enter a new email";
            return false;
        }
    } else if (pass.checked) {
        if (!alphanumeric(newVal.value)) {
            pass.focus();
            invalid.innerHTML = "The password must only english characters and numbers";
            return false;
        }
        else if(newVal.value.length < 6){
            pass.focus();
            invalid.innerHTML = "The password must have at least 6 characters";
            return false;
        }
        else if(newVal.value.length > 50){
            pass.focus();
            invalid.innerHTML = "The new password can only have in maximum 50 characters, it has" + pass.value.length;
            return false;
        }
    }
    return true;
}



function validateEditPriority() {
    let invalid = document.getElementById("invalid2");

    let selected = false;
    for(let a = 1;a < document.getElementById("teste2").childElementCount+1;a++){
        if(document.getElementById("e"+a).className === "same-as-selected"){
            selected = true;
        }
    }
    if(!selected){
        document.getElementById("teste").focus();
        invalid.innerHTML = "You must have to selecte a user";
        return false;
    }
}

function validateEditContentAdmin() {
    let invalid = document.getElementById("invalid3");

    let selected = false;
    for(let a = 1;a < document.getElementById("teste3").childElementCount+1;a++){
        if(document.getElementById("f"+a).className === "same-as-selected"){
            selected = true;
        }
    }
    if(!selected){
        document.getElementById("teste").focus();
        invalid.innerHTML = "You must have to selecte a content";
        return false;
    }
}*/