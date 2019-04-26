
$(document).ready(function(){
	
	$('.nbtn, .table .ebtn').click(function(event){
		
		event.preventDefault();
		var href=$(this).attr('href');
		var text=$(this).text();
		if(text=='Edit'){
		$.get(href,function(category,status){
			$('.myForm #id').val(category.categoryId);
			$('.myForm #name').val(category.name);
			$('.myForm #description').val(category.description);
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