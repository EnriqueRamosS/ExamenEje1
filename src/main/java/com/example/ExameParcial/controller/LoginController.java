
package com.example.ExameParcial.controller;


import com.example.ExameParcial.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {
    @GetMapping("/login")
    public String showForm(Model model){
        model.addAttribute("user",new User());
        return "login";
    }
    @PostMapping("/login")
    public String processLogin(@ModelAttribute User user, Model model) {
        if ("admin".equals(user.getUsername()) && "admin".equals(user.getPassword())) {
            model.addAttribute("username", user.getUsername());
            return "success";
        } else {
           // model.addAttribute("error", "Credenciales incorrectas. Intenta nuevamente.");
            return "error";
        }
    }

}
