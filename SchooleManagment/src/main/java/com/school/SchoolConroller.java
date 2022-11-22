package com.school;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SchoolConroller {
	
	@RequestMapping("/index")
    public String home(){
        return "index";
    }

}
