package com.project.payment.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/test")
public class testController {

    @GetMapping("t")
    public ModelAndView getTest() {
        ModelAndView mav = new ModelAndView("test.html");
        return mav;
    }
}