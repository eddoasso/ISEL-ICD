
function showAllAnswersAjax(){
	setInterval(function() {
		$.get("servletAjax", function(responseText) {   // Execute Ajax GET request on URL of "someservlet" and execute the following function with Ajax response text...
		document.getElementById("w3review").value = responseText;
    	});
	}, 3000);
}


function showAllStudentsTime(){
	setInterval(function() {
		$.get("servletAjaxStudentsCon", function(responseText) {
			let mainElem = document.getElementById("stn");
			let childElem = document.getElementById("stnx");
			let docNodes = document.createRange().createContextualFragment(responseText);
			mainElem.replaceChild(docNodes, childElem);
    	});
	}, 3000);
}


function showCountAnswers(){
	setInterval(function() {
		$.get("servletAjaxCountAnswers", function(responseText) {
			let mainElem = document.getElementById("counter");
			mainElem.innerHTML = responseText;
			
    	});
	}, 3000);
}

function showOnProf(){
	setInterval(function() {
		$.get("servletShowOnProf", function(responseText) {
			let mainElem = document.getElementById("prof-sel");
			let childElem = document.getElementById("prof-connect");
			let docNodes = document.createRange().createContextualFragment(responseText);
			mainElem.replaceChild(docNodes, childElem);
			
    	});
	}, 3000);
}

function showPendentQuest(){
	setInterval(function() {
		$.get("servletPendentQuest", function(responseText) {
			let mainElem = document.getElementById("counter");
			mainElem.innerHTML = responseText;
			
    	});
	}, 3000);
}

