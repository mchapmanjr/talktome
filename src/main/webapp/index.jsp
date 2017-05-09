<html>
<head>
<script src="https://code.jquery.com/jquery-1.11.1.min.js"
	type="text/javascript">
	
</script>
</head>



<body>

<div id="postp">Click to post portoflio recommendation</div>

	<script type="text/javascript">
		$(document).ready(function() {
			
			$("#postp").click(function() {
				console.log('postingp');
				$.ajax({
					type : "POST",
					url : "action/portfolio/recommend",
					data : JSON.stringify({
						age : "50",

					}),
					contentType : 'application/json',
					success : function(data) {
						console.log(data);
					}
				});
			});
		
		});
	</script>

</body>
</html>

