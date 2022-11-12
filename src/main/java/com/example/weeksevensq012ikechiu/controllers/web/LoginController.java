package com.example.weeksevensq012ikechiu.controllers.web;

import com.example.weeksevensq012ikechiu.model.request.Login;
import com.example.weeksevensq012ikechiu.service.UserService;
import com.example.weeksevensq012ikechiu.service.impl.PostServiceImpl;
import com.example.weeksevensq012ikechiu.service.impl.UserServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@AllArgsConstructor
public class LoginController {

    private UserServiceImpl userService;

    @GetMapping("/login")
    public String index(Model model) {
        Login login = new Login();
        model.addAttribute("loginObj", login);
        return "login";
    }

    @PostMapping("/login")
    public String loginForm(@ModelAttribute("loginObj") Login login) {

        var apiResponse = userService.login(login.getContact(), login.getPassword());
        if (apiResponse.isSuccess()) {
            var userRest = apiResponse.getData();
            return "redirect:/homepage/" + userRest.getUserId();
        } else {
            return "login";
        }
    }

}
