package com.capgroup.googhome.controller;

import java.io.IOException;
import java.io.Writer;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class PortfolioController {

	@PostMapping("portfolio/recommend")
	public void handle(@RequestBody String body, Writer writer) throws IOException {
		System.out.print(body);
		writer.write(body);
	}
	
	/**
	@RequestMapping(value = "/recommend", method = RequestMethod.POST)
	public @ResponseBody RootResponse getPortfolioRecommendation(@RequestBody RootRequest rootRequest) {
		
		
		
		List<Inputs> inputs = rootRequest.inputs;
		
		
		RootResponse response = ResponseBuilder.tellResponse("I received your question " + rootRequest.user.profile.display_name);
		
	
		return response;
		
	}
	**/
	
}
