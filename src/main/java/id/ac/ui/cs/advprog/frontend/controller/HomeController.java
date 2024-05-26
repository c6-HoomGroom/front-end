package id.ac.ui.cs.advprog.frontend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("")
public class HomeController {
    @GetMapping("/")
    public String goToHomePage(Model model){
        return "homePage";
    }

    @GetMapping("/test")
    public String goToTestPage(Model model){
        return "testPage";
    }

}

