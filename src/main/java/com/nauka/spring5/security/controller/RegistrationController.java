package com.nauka.spring5.security.controller;


import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nauka.spring5.security.domain.CrmUser;

@Controller
@RequestMapping("/register")
public class RegistrationController {

	@Autowired
	private UserDetailsManager userDetailsManager;

	PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

	@InitBinder
	public void initBinder(WebDataBinder webDataBinder) {
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		webDataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}

	@GetMapping("/showRegistrationForm")
	public String showRegistrationForm(Model model) {
		model.addAttribute("crmUser", new CrmUser());
		return "registration-form";
	}

	@PostMapping("/processRegistrationForm")
	public String processRegistrationForm(@Valid @ModelAttribute("crmUser") CrmUser crmUser, 
			BindingResult bindingResult, Model model){

		if (bindingResult.hasErrors()) {
			model.addAttribute("crmUser", new CrmUser());
			model.addAttribute("registrationError", "User name/password can not be empty");
			return "registration-form";
		} else if (userDetailsManager.userExists(crmUser.getUserName())){
			model.addAttribute("crmUser", new CrmUser());
			model.addAttribute("registrationError", "User already exists");
			return "registration-form";
		}
		
		String encodedPassword = passwordEncoder.encode(crmUser.getPassword());
		encodedPassword = "{bcrypt}" + encodedPassword;
		
		List<GrantedAuthority> authorities = AuthorityUtils.createAuthorityList("ROLE_EMPLOYEE");
		
		User user = new User(crmUser.getUserName(), encodedPassword, authorities);
		
		userDetailsManager.createUser(user);
		
		return "registration-confirmation";
	}
}