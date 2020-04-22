package pl.coderslab.library.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import pl.coderslab.library.entity.User;
import pl.coderslab.library.repository.UserRepository;

@Controller
@SessionAttributes("user")
public class LoginController {
    @Autowired
    private User user;

    @Autowired
    private UserRepository userRepository;

    @RequestMapping("/login")
    public String login(Model model){
        user.setLogin(null);
        user.setPassword(null);
        model.addAttribute("user", user);
        return "login";
    }

    @PostMapping("/login")
    public String doLogin(Model model, @ModelAttribute("user") User userToLogin){
        User u = userRepository.login(userToLogin.getLogin(), userToLogin.getPassword());
        if(u == null){
            model.addAttribute("errorMessage", "Invalid Credentials");
            return "login";
        }

        user.setId(u.getId());
        user.setLogin(u.getLogin());
        user.setPassword(u.getPassword());
        user.setCustomer(u.getCustomer());
        user.setEmployee(u.getEmployee());

        return "redirect:/";
    }
}