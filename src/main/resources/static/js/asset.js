
$(document).ready(function(){
	
	$('.nbtn, .table .ebtn').click(function(event){
		
		event.preventDefault();
		var href=$(this).attr('href');
		var text=$(this).text();
		if(text=='Edit'){
		$.get(href,function(as,status){
			$('.forms #id').val(as.assetId);
			$('.forms #type').val(as.assetType);
			$('.forms #brand').val(as.brand);
			$('.forms #description').val(as.description);
			$('.forms #status').val(as.status);
			
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