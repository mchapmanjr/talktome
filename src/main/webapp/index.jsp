
<head>
<script src="https://code.jquery.com/jquery-1.11.1.min.js"
	type="text/javascript">
	
</script>
</head>



<body>

<div id="postp" style="cursor:pointer">Click to post portfolio recommendation.</div>

	<script type="text/javascript">
		$(document).ready(function() {
			
			$("#postp").click(function() {
				console.log('postingp');
				$.ajax({
					type : "POST",
					url : "action/portfolio/recommend",
					data : JSON.stringify({
						user : {user_id: "jamesdean", profile : {given_name : "john", display_name : "john doe"}, access_token: "1231233"},
						device : {
							    location: {
							      coordinates: {
							        latitude: 123.456,
							        longitude: -123.456
							      },
							      formatted_address: "1234 Random Road, Anytown, CA 12345, United States",
							      city: "Anytown",
							      zip_code: "12345"
							    }
							  }
					    
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

