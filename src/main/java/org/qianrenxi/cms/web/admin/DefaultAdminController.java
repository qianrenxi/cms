package org.qianrenxi.cms.web.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("admin")
public class DefaultAdminController {

	@RequestMapping(value={"", "/"})
	public String index(){
		
		return "admin/index";
	}
}
