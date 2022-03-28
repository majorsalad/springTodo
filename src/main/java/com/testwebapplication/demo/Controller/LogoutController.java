package com.testwebapplication.demo.Controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@SessionAttributes("name")
public class LogoutController {

    @GetMapping("/logout")
    public String showLogoutPage(HttpServletRequest req, HttpServletResponse res){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(authentication!=null){
            new SecurityContextLogoutHandler().logout(req, res, authentication);
        }
        return "redirect:/";
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
