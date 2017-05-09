package com.capgroup.googhome.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.capgroup.googhome.JSONResponse;
import com.capgroup.googhome.domain.PortfolioRecommendation;
import com.frogermcs.gactions.ResponseBuilder;
import com.frogermcs.gactions.api.request.Inputs;
import com.frogermcs.gactions.api.request.RootRequest;
import com.frogermcs.gactions.api.response.RootResponse;

@Controller
@RequestMapping(value = "/portfolio")
public class PortfolioController {

	
	
	@RequestMapping(value = "/recommend", method = RequestMethod.POST)
	public @ResponseBody RootResponse getPortfolioRecommendation(@RequestBody RootRequest rootRequest) {
		
		
		
		List<Inputs> inputs = rootRequest.inputs;
		
		
		RootResponse response = ResponseBuilder.tellResponse("I received your question " + rootRequest.user.profile.display_name);
		
	
		return response;
		
	}
	
}
