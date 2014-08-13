var getUser = function(userName){
	
	if(userName=="undefined"){
		sessionOut();
	}
	
	var url = window.location.protocol+"//"+window.location.host+"/user"+"?"+userName;
	var xmlhttp;
	if (window.XMLHttpRequest) {
		xmlhttp=new XMLHttpRequest();
	}else{
		xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
	}
	xmlhttp.open("GET",url,false);
	xmlhttp.send();
}

var sessionOut = function(){
	window.location.href='index.html';
}