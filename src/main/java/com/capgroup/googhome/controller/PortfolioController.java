package com.capgroup.googhome.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.capgroup.googhome.JSONResponse;
import com.capgroup.googhome.domain.PortfolioRecommendation;

@Controller
@RequestMapping(value = "/portfolio")
public class PortfolioController {

	
	@RequestMapping(value = "/recommend", method = RequestMethod.POST)
	public @ResponseBody JSONResponse getPortfolioRecommendation(@RequestBody PortfolioRecommendation portfolioR) {
		return new JSONResponse("OK", portfolioR.getAge());
		
	}

}
