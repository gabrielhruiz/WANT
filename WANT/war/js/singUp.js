var options = {};

var callback = {
		
}

function singUp(){
	
	var xmlhttp;
	if (window.XMLHttpRequest) {
		// code for IE7+, Firefox, Chrome, Opera, Safari
		xmlhttp=new XMLHttpRequest();
	}else{
		// code for IE6, IE5
		xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
	}
	
	var username = document.getElementById("usernameInput");
	var password = document.getElementById("pssdInput");
	var repassword = document.getElementById("repssdInput");
	var name = document.getElementById("nameInput"); 
	var surname = document.getElementById("surnameInput");
	var app = document.getElementById("appInput");
	var mail = document.getElementById("mailInput");
	var phone = document.getElementById("phoneInput");
	var zipcode = document.getElementById("zipcodeInput");
	
	if((password.value == repassword.value)&&(!repassword.value=="")){
		var url = window.location.protocol+"//"+window.location.host+"/users"+
		"?name="+name.value+"&surname="+surname.value+"&userName="+username.value+"&password="+password.value+
		"&mail="+mail.value+"&phone="+phone.value+"&zipcode="+zipcode.value;
		
		xmlhttp.open("POST",url,false);
		xmlhttp.send();
		
		
		$("#singUpOK").show("blind",500);
	}else{
		if(username.value==""||password.value==""||repassword.value==""||name.value==""||
				surname.value==""||app.value==""||mail.value==""||phone.value==""||zipcode.value==""){
			alert("Please, you must fill all personal dates.");
		}else{
			alert("Ups, review password");
		}	
	}
	
	
	
}