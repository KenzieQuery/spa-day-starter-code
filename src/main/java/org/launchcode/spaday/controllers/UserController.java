package org.launchcode.spaday.controllers;

import org.launchcode.spaday.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("user")
public class UserController {

    @GetMapping("/add")
    public String displayAddUserForm(Model model) {
        model.addAttribute(new User());
        return "user/add";
    }

    @PostMapping
    public String processAddUserForm(Model model, @ModelAttribute User user, String verify) {
//        model.addAttribute("user", user);
//        model.addAttribute("verify", verify);
//        model.addAttribute("username", user.getUsername());
//        model.addAttribute("email", user.getEmail());
//        if (user.getPassword().equals(verify)) {
//           return "user/index";
//        }
//        else {
//            model.addAttribute("error", "Passwords do not match");
//            return "user/add";
//        }

        //errors.hasErrors() returns true if the user is not valid
        //if errors.hasErrors() returns true, re-render the form
        //else if passwords do not match, re-render the form
        //else render index.html
        if(errors.hasErrors()){
            return "/user/add";
        }
        else if(!user.getPassword().equals(verify)){
            model.addAttribute("error", "Passwords do not match.")
            return "/user/add";
        }
        else{
            return "/user/index";
        }
    }


}
