package nguyenhoangthinh.quanlysachCSDLlap3.controller;

import jakarta.validation.Valid;
import nguyenhoangthinh.quanlysachCSDLlap3.entity.User;
import nguyenhoangthinh.quanlysachCSDLlap3.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping ("/login")
    public String login (){return "user/login";}
    @GetMapping ("/register")
    public String register (Model model){
        model.addAttribute("user", new User());
        return "user/register";
    }
    @PostMapping("/register")
    public  String register (@Valid @ModelAttribute("user") User user , BindingResult  blindingResult, Model model){
        if(blindingResult.hasErrors()){
            blindingResult.getFieldErrors().forEach(error -> model.addAttribute(error.getField()+"_error", error.getDefaultMessage()));
            return "user/register";
        }
        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        userService.save(user);
        return "redirect:/login";
    }

}
