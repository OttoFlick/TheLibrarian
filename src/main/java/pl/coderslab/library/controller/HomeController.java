package pl.coderslab.library.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.library.entity.User;

@Controller
public class HomeController {
    @Autowired
    private User user;

    @RequestMapping("/")
    public String home(){
        return "home";
    }
}
