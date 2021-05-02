package tn.esprit.spring.control;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import tn.esprit.spring.entity.User;
import tn.esprit.spring.service.IUserService;
@RestController
@RequestMapping("/auth")
@AllArgsConstructor
public class AuthController {
	
		private final IUserService userService;
	
		@GetMapping("/login")
		//@CrossOrigin(origins = "http://localhost:8081")
		public User auth(Principal principal) {  
			return userService.getUserByUsername(principal.getName());
		}
		
		@RequestMapping(value="/logout", method = RequestMethod.GET)
	    public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
	        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	        if (auth != null){    
	            new SecurityContextLogoutHandler().logout(request, response, auth);
	        }
	        return "user is logout";
	    }
	}

