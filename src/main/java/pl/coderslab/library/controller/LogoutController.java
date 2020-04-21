package pl.coderslab.library.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.context.request.WebRequest;
import pl.coderslab.library.entity.User;

@Controller
@SessionAttributes("user")
public class LogoutController {

    @Autowired
    private User user;

    @RequestMapping("/logout")
    public String logout(WebRequest request, SessionStatus status){
        status.setComplete();
        request.removeAttribute("user", WebRequest.SCOPE_SESSION);
        user.setId(null);
        return "redirect:/";
    }

}
