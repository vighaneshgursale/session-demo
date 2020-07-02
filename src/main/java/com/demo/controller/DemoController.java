package com.demo.controller;

import com.demo.dto.UserDto;
import com.demo.exception.UserAlreadyExistsException;
import com.demo.model.User;
import com.demo.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class DemoController {

    private final UserService userService;

    public DemoController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ModelAndView register(@ModelAttribute("user")UserDto userDto) {
        try {
            User user = userService.registerUser(userDto);
            String message;
            if(user != null) {
                message = "User registered successfully";
            }
            else {
                message = "Something went wrong";
            }
            ModelAndView modelAndView = new ModelAndView("signup");
            modelAndView.addObject("status", true);
            modelAndView.addObject("message", message);
            return modelAndView;
        }
        catch (UserAlreadyExistsException e) {
            ModelAndView modelAndView = new ModelAndView("signup");
            modelAndView.addObject("status", false);
            modelAndView.addObject("message", e.getLocalizedMessage());
            return modelAndView;
        }
    }

    @GetMapping("/dummy")
    public String handleDummyPage() {
        return "dummy";
    }

    @GetMapping("/signup")
    public String signUp() {
        return "signup";
    }

    @GetMapping("/")
    public String index(){
        return "index";
    }
}
