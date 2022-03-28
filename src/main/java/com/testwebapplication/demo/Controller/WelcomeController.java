package com.testwebapplication.demo.Controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class WelcomeController {

    @GetMapping("/")
    public String showWelcomePage(Model model){
        model.addAttribute("name", getLoggedInUsername());
        return "welcome";
    }

    private String getLoggedInUsername(){
        //Get entered in userid from spring security. This is known as the Principal (the person logged in)
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if(principal instanceof UserDetails){ //check if principal is instanceof Userdetails (class that's used to store user details)
            return ((UserDetails)principal).getUsername();
        }
        return principal.toString();
    }
}
