//Creating a new XMLHttpRequest object
var xmlhttp;

if (window.XMLHttpRequest) {
	xmlhttp = new XMLHttpRequest(); //for IE7+, Firefox, Chrome, Opera, Safari
} else {
	xmlhttp = new ActiveXObject("Microsoft.XMLHTTP"); //for IE6, IE5
}

//xmlhttp.open("GET", "handleAsyncAnswers", true);
xmlhttp.open("GET", contextPath + "/handleAsyncAnswers", true);


console.log(contextPath);
console.log(contextPath + "/handleAsyncAnswers");
console.log($("html").data("contextPath") + "/handleAsyncAnswers");

//Tell the server that this call is made for ajax purposes.
xmlhttp.setRequestHeader('X-Requested-With', 'XMLHttpRequest');
xmlhttp.setRequestHeader('X-Test', 'some-value');

xmlhttp.send(null); //HTTP GET

//xmlhttp.send( '{"id":"23423"}' ); //HTTP POST

xmlhttp.onreadystatechange = function() {
	if (xmlhttp.readyState == 4) {
		if (xmlhttp.status == 200) {
			console.log("sucess");
			//request succeed
		} else {
			console.log("insucesso");
			//request failed
		}
	}
};

setInterval(function() {
	console.log("ajax");

}, 3000);
