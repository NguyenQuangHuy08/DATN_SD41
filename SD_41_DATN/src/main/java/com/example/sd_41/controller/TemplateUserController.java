package com.example.sd_41.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "showTestUser")
public class TemplateUserController {


    @GetMapping("list")
    public String index(Model model){

        return "/templates/Users/index";

    }

}
