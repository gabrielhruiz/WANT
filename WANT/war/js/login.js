function loginProcess(){
	var user = document.getElementById("userInput");
	var password = document.getElementById("psswdInput");
	
	if(user.value==""){
		alert("Please fill user space");
	}else{
		var url = window.location.protocol+"//"+window.location.host+"/users"+"?"+user.value;
		var xmlhttp;
		if (window.XMLHttpRequest) {
			xmlhttp=new XMLHttpRequest();
		}else{
			xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
		}
		xmlhttp.open("GET",url,false);
		xmlhttp.send();
		var response = xmlhttp.responseText;
		var user = eval ("(" + response + ")");
		UserManager.updateCurrentUser(user);
		if(password.value==user.password){
			alert("loginOk");
		}else{
			alert("loginFail");
		}
		
	}
}