package com.school;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SchoolConroller {
	
	@GetMapping("/index")
    public String home(){
        return "index";
    }

}
