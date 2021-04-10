package tn.esprit.spring.control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entities.User;
import tn.esprit.spring.service.IUserService;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired(required=true)
	IUserService userService;
	
	@PostMapping("/add")
	public User addUser (@RequestBody User user) {
		return userService.addUser(user);
	}
	@GetMapping("/get")
	public List<User> getAllUsers(){
		return userService.getUsers();
	}
@GetMapping("/adminLogin")
public String adminValidation() {
	return "Admin successfully logged in!!!!";
}
}

