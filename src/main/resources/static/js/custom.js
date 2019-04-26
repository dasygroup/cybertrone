
$(document).ready(function(){
	
	$('.nbtn, .table .ebtn').click(function(event){
		
		event.preventDefault();
		var href=$(this).attr('href');
		var text=$(this).text();
		if(text=='Edit'){
		$.get(href,function(department,status){
			$('.myForm #id').val(department.deptId);
			$('.myForm #name').val(department.name);
			$('.myForm #description').val(department.description);
		});
		$('.myForm #exampleModal').modal('show');
		
		}else{
			$('.myForm #id').val('');
			$('.myForm #name').val('');
			$('.myForm #capital').val('');
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