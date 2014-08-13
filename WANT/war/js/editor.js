		$(function(){

			$("#tabs").tabs();
	
			$("#info").hide();
			
			$("#generalHelp").click(function(){
				$("#info").show("blind", 500);
				$("#text").show();
			});
			
			$(".exit").click(function(){
				$("#info").hide();
			});
			
			$("#addNode").click(function(){
				createFile();
			});
			$("#deleteNode").click(function(){
				
			});
			$("#saveFiles").click(function(){
				
			});
			$("#addLine").click(function(){
				var line =  $("#line").clone();
				var partner=$("#fileEditor");
				partner.append(line);
			});
		});