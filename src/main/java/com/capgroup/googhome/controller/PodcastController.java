package com.capgroup.googhome.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgroup.googhome.domain.HookResponse;



@RestController
public class PodcastController {

	
	@GetMapping("/podcast")
	public HookResponse handle(){
		
		HookResponse response = new HookResponse();
		response.speech="<speak>The podcast is starting, please wait. <audio src='https://secure-hwcdn.libsyn.com/p/f/4/f/f4f8b750f4a81be6/Capital_Ideas_Podcast_5_-_Mark_Casey.mp3?c_id=14990770&expiration=1494454175&hwt=6eb9063baa85550693c8bccf3dcf2f23'>Unable to play podcast file</audio></speak>";
		response.text="This is a podcast, it will only play on Google Home.";
		response.data.google.expect_user_response = true;
		response.data.google.is_ssml=true;
		return response;
		
	}
	
}
