package com.revature.Controllers;

import com.revature.Models.Role;
import com.revature.Models.User;
import com.revature.Services.UserServices;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("users")

public class UserController {

    private final UserServices userServices;

    @Autowired
    public UserController(UserServices userServices) {
        this.userServices = userServices;
    }

    @GetMapping
    public List<User> getAllUsersHandler(HttpSession session){
        return userServices.getAllUsers();
    }

    @PostMapping("/login")
    public ResponseEntity<User> userLoginHandler(@RequestBody User user, HttpSession session){
        User actualUser = userServices.loginUser(user.getUsername(), user.getUserPassword());
        if(actualUser == null){
            return ResponseEntity.badRequest().build();
        }
        session.setAttribute("userName", actualUser.getUsername());
        session.setAttribute("userId", actualUser.getUserID());
        session.setAttribute("role", actualUser.getRole());

        return ResponseEntity.ok(actualUser);
    }

    @PostMapping("/logout")
    public ResponseEntity<?> userLogoutHandler(HttpSession session){
        session.invalidate();
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/createAccount")
    public ResponseEntity<User> createUserHandler(@RequestBody User user){
        User tempUser = user;
        if(tempUser.getRole() == null){
            tempUser.setRole(Role.USER);
        }
        return  ResponseEntity.status(200).body(userServices.createUser(tempUser));
    }



}
