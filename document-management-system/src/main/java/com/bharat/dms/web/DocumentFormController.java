package com.bharat.dms.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/")
public class DocumentFormController {

	@RequestMapping(value ="/p", method = RequestMethod.GET)
	public ModelAndView prepareDocumentPostForm(){
		
		ModelAndView mav = new ModelAndView();
		
		return mav;
	}
	
	@RequestMapping(value ="/p", method = RequestMethod.GET)
	public ModelAndView processDocumentPostForm(){
		
		ModelAndView mav = new ModelAndView();
		
		return mav;
	}
}
