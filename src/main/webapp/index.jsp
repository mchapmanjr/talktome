
<head>
<script src="https://code.jquery.com/jquery-1.11.1.min.js"
	type="text/javascript">
	
</script>
</head>



<body>

<div id="postp" style="cursor:pointer">Click to post portfolio recommendation.</div>
<div id="postn" style="cursor:pointer">Click to post get news.</div>

	<script type="text/javascript">
		$(document).ready(function() {

			$("#postp").click(function() {
				console.log('postingp');
				$.ajax({
					type : "POST",
					url : "https://talktome.jimmysheadache.us/googhome/action/webHook",
					data : JSON.stringify({
						  "id": "4be29de3-87c4-402f-a2e2-098c3704cd8c",
						  "timestamp": "2017-05-10T18:15:41.397Z",
						  "lang": "en",
						  "result": {
						    "source": "agent",
						    "resolvedQuery": "high",
						    "action": "portfolio",
						    "actionIncomplete": false,
						    "parameters": {
						      "RiskTolerance": "High"
						    },
						    "contexts": [
						      {
						        "name": "establishclientage-followup",
						        "parameters": {
						          "YearstoRetirement.original": "years",
						          "RiskTolerance.original": "high",
						          "RiskTolerance": "High",
						          "YearstoRetirement": "30",
						          "age.original": "40 years old",
						          "age": [
						            "10"
						          ]
						        },
						        "lifespan": 5
						      },
						      {
						        "name": "establishclientage-custom-followup",
						        "parameters": {
						          "YearstoRetirement.original": "years",
						          "RiskTolerance.original": "high",
						          "RiskTolerance": "High",
						          "YearstoRetirement": "30",
						          "age.original": "40 years old",
						          "age": [
						            "10"
						          ]
						        },
						        "lifespan": 4
						      },
						      {
						        "name": "years-to-retirement-custom-followup",
						        "parameters": {
						          "RiskTolerance.original": "high",
						          "RiskTolerance": "High"
						        },
						        "lifespan": 5
						      }
						    ],
						    "metadata": {
						      "intentId": "6f13bc6c-0c9b-4d45-a84c-d46186ba7106",
						      "webhookUsed": "true",
						      "webhookForSlotFillingUsed": "false",
						      "webhookResponseTime": 139,
						      "intentName": "Establish Client's Risk Tolerance"
						    },
						    "fulfillment": {
						      "speech": "Your client is null years old, null years till retirement with null risk tolerance",
						      "source": "",
						      "messages": [
						        {
						          "type": 0,
						          "speech": "Your client is null years old, null years till retirement with null risk tolerance"
						        }
						      ]
						    },
						    "score": 0.66
						  },
						  "status": {
						    "code": 200,
						    "errorType": "success"
						  },
						  "sessionId": "bc5935f7-8641-49f0-acf8-f3665445b149"
						}),
					contentType : 'application/json',
					success : function(data) {
						console.log(data);
					}
				});
			});
			
			$("#postn").click(function() {
				console.log('postingn');
				$.ajax({
					type : "POST",
					url : "action/webHook",
					data : JSON.stringify({
						  "id": "4be29de3-87c4-402f-a2e2-098c3704cd8c",
						  "timestamp": "2017-05-10T18:15:41.397Z",
						  "lang": "en",
						  "result": {
						    "source": "agent",
						    "resolvedQuery": "high",
						    "action": "news",
						    "actionIncomplete": false,
						    "parameters": {
						      "RiskTolerance": "High"
						    },
						    "contexts": [],				
						    "metadata": {
						      "intentId": "6f13bc6c-0c9b-4d45-a84c-d46186ba7106",
						      "webhookUsed": "true",
						      "webhookForSlotFillingUsed": "false",
						      "webhookResponseTime": 139,
						      "intentName": "Establish Client's Risk Tolerance"
						    },
						    "fulfillment": {
						      "speech": "Your client is null years old, null years till retirement with null risk tolerance",
						      "source": "",
						      "messages": [
						        {
						          "type": 0,
						          "speech": "Your client is null years old, null years till retirement with null risk tolerance"
						        }
						      ]
						    },
						    "score": 0.66
						  },
						  "status": {
						    "code": 200,
						    "errorType": "success"
						  },
						  "sessionId": "bc5935f7-8641-49f0-acf8-f3665445b149"
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

