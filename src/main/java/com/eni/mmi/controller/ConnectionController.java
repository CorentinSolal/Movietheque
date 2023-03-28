package com.eni.mmi.controller;

import com.eni.bo.Member;
import com.eni.service.ConnectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class ConnectionController {
	// Injection du service
	private ConnectionService connectionService;

	@Autowired
	public ConnectionController(ConnectionService connectionService) {
		this.connectionService = connectionService;
	}

	@GetMapping("/login")
	public String login() {
		return "login";
	}

	@PostMapping("/login")
	public String login(@RequestParam(required = true) String email, @RequestParam(required = true) String password,
			Model model, HttpSession session) {
		Member user = connectionService.login(email, password);
		if (user != null) {
			session.setAttribute("userSession", user);
			return "redirect:/movies";//appel du contrôleur MovieController
		} else {
			model.addAttribute("error", "Le login et le password ne sont pas corrects");
			return "login";
		}
	}

	@GetMapping("/logout")
	public String invalidateSession(HttpSession session) {
		session.invalidate();
		// redirection
		return "redirect:/";
	}
}
