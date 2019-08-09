package com.lti.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

//for normal controller just@Controller is ok.
//But for RESTfull controller we need this annotation
@RestController
@CrossOrigin
public class HelloRESTController {
	
	@GetMapping("/hello.lti")
	//@RequestMapping(path="/hello.lti", method=RequestMethod.GET)
	public @ResponseBody String hello() {
		return "{\"message\":\"Welcome to Spring REST\"}";		//JSON Format
	}

}
