package org.qianrenxi.cms.web.home;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DefaultHomeController {

	@RequestMapping(value={"", "/"})
	public String index(){
		
		return "home/index";
	}
}
