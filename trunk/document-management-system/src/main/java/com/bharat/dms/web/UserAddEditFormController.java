package com.bharat.dms.web;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bharat.dms.utils.Constants;
import com.bharat.dms.web.formBean.UserRegFormBean;

@Controller
@RequestMapping("/user")
public class UserAddEditFormController {

	private final Logger log = Logger.getLogger(this.getClass());


	@RequestMapping(value="/reg", method = RequestMethod.GET)
	public ModelAndView prepareUserRegForm(){
		ModelAndView mav = new ModelAndView();
		
		UserRegFormBean formBean = new UserRegFormBean();
		formBean.setRoles(new String[]{Constants.ROLE_USER});
		mav.addObject("formBean", formBean);
		
		mav.setViewName("userAddEditForm");
		return mav;
	}
	
	@RequestMapping(value="/reg", method = RequestMethod.POST)
	public ModelAndView processUserRegForm(@Valid UserRegFormBean formBean,
			BindingResult bindingResult){
		ModelAndView mav = new ModelAndView();
		log.info(formBean);
		
		if(bindingResult.hasErrors()){
			log.info("************* form has errors : "+ bindingResult.getErrorCount());
			
			for(ObjectError e : bindingResult.getAllErrors()){
				log.info(e.getCode()+" :::: "+ e.getDefaultMessage());
			}
			
			log.info(bindingResult.getAllErrors().toString());
			mav.addObject("formBean", formBean);
			mav.setViewName("userAddEditForm");
			return mav;
		}
		
		//formBean.setRoles(new String[]{Constants.ROLE_USER});
		mav.addObject("formBean", formBean);
		
		mav.setViewName("home");
		return mav;
	}
}
