package io.aiven.spring.mysql.demo.controller;

import io.aiven.spring.mysql.demo.model.User;
import io.aiven.spring.mysql.demo.sevice.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/demo")
public class UserController {

    private UserService service;

    // constructor injection
    public UserController(UserService service) {
        this.service = service;
    }


    @PostMapping("/add")
    public @ResponseBody User addNewProduct(@RequestParam String name, @RequestParam String email) {
        return service.addNewProduct(name, email);
    }


    @GetMapping("/all")
    public @ResponseBody Iterable<User> getAllUser() {
        return service.getAllUser();
    }

    @DeleteMapping("/user/{id}")
    public @ResponseBody String deleteUser(@PathVariable int id) {
        User user = service.getUserById(id);

        if (user!=null) {
            service.deleteUser(id);
            return "user deleted successfully!";
        } else {
            return "user not found!";
        }
    }

}
