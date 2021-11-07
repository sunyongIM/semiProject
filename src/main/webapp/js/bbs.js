/**
 * 
 */
$(document).ready(function(){
	$("#checkId").click(function(){
		var id = $("#id").val();
		
		$.ajax({
			data:{checkId:id},
			type:"post",
			dataType:"text",
			url:"http://localhost:9090/BBS/CmdController?cmd=checkId",
			async:false,
			success:function(data,textStatus){
				alert(data);
			},
			error:function(data,textStatus){
				$("#message").text("error");
			},
			complete:function(data,textStatus){
				
			}
		});
		
		
	})
	
})

