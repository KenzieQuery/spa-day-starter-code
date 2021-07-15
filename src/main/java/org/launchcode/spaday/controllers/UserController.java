package org.launchcode.spaday.controllers;
import org.launchcode.spaday.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
// located at /user
@RequestMapping("user")
public class UserController {

    @GetMapping("/add")
    public String displayAddUserForm(){
        return "/user/add";
    }

    @PostMapping
    //@RequestParam would normally be added to String verifiedPassword, not required here due to th:action"@{/user}"
    public String processAddUserForm(Model model, @ModelAttribute User user, String verifiedPassword) {
        // add form submission handling code here
        if(verifiedPassword.equals(user.getPassword())){
            model.addAttribute("username", user.getUsername());
            return "/user/index";
        }
        else{
            model.addAttribute("email", user.getEmail())
            model.addAttribute("error", "Passwords did not match, please re-enter.");
            return "/user/add";
        }
    }

}
