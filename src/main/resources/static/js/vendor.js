
$(document).ready(function(){
	
	$('.nbtn, .table .ebtn').click(function(event){
		
		event.preventDefault();
		var href=$(this).attr('href');
		var text=$(this).text();
		if(text=='Edit'){
		$.get(href,function(vendor,status){
			$('.myForm #id').val(vendor.vendorId);
			$('.myForm #firstname').val(vendor.firstName);
			$('.myForm #lastname').val(vendor.lastName);
			$('.myForm #email').val(vendor.email);
			$('.myForm #phone').val(vendor.phone);
		});
		$('.myForm #exampleModal').modal('show');
		
		}else{
			$('.myForm #id').val('');
			$('.myForm #firstname').val('');
			$('.myForm #lastname').val('');
			$('.myForm #email').val('');
			$('.myForm #phone').val('');
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