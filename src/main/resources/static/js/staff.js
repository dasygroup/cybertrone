
$(document).ready(function(){
	
	$('.nbtn, .table .ebtn').click(function(event){
		
		event.preventDefault();
		var href=$(this).attr('href');
		var text=$(this).text();
		if(text=='Edit'){
		$.get(href,function(staff,status){
			$('.forms #id').val(staff.staffId);
			$('.forms #firstname').val(staff.firstName);
			$('.forms #lastname').val(staff.lastName);
			$('.forms #gender').val(staff.gender);
			$('.forms #dob').val(staff.dob);
			$('.forms #title').val(staff.jobTitle);
		});
		//$('.myForm #exampleModal').modal('show');
		
		}else{
			$('.myForm #id').val('');
			$('.myForm #firstname').val('');
			$('.myForm #lastname').val('');
			$('.myForm #exampleModal').modal('show');
		}
	});
	
	$('.table .delbtn').on('click',function(event){
		event.preventDefault();
		var href=$(this).attr('href');
		
		$('#myModal #delRef').attr('href',href);
		$('#myModal').modal();
	});
});