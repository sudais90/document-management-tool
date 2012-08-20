package com.bharat.dms.web;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bharat.dms.utils.Constants;

@Controller
@RequestMapping("/user")
public class UserAddEditFormController {

	@RequestMapping(value="/reg", method = RequestMethod.GET)
	public ModelAndView prepareUserRegForm(){
		ModelAndView mav = new ModelAndView();
		
		Map<String, String> roleMap = new HashMap<String, String>();
		roleMap.put("user", Constants.ROLE_USER);
		roleMap.put("admin", Constants.ROLE_ADMIN);
		roleMap.put("superAdmin", Constants.ROLE_SUPER_ADMIN);
		mav.addObject("roles", roleMap);
		mav.setViewName("userAddEditForm");
		return mav;
	}
}
