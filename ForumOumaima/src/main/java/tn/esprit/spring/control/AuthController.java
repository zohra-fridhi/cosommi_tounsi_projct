package tn.esprit.spring.control;

import java.security.Principal;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/auth")
	public class AuthController {

		@GetMapping("/login")
		public Principal auth(Principal principal) {
			return principal;
		}
		
	}

