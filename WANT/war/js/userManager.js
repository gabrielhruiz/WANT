
var UserManager = {
		userName: null,
		mail: null,
		files: {},	

		getUserName: function(){
			return UserManager.userName;
		},
		getFiles: function(){
			return UserManager.files;
		},
		getMail: function(){
			return UserManager.mail;
		},
		setUsername: function(uName){
			UserManager.userName=uName;
		},
		setFiles: function(uFiles){
			UserManager.files=uFiles;
		},
		setMail: function(uMail){
			UserManager.mail=uMail;
		},
		updateCurrentUser: function(json){
			UserManager.userName=json.userName;
			UserManager.files=json.files;
			UserManager.mail=json.mail;
		}
}
