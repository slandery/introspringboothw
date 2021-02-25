package com.tts.formhw.form;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class FormController {

	@Autowired
	private FormRepository formRepository;

	@GetMapping(value = "/")

	public String index(Form form) {
		// Where we want to go when our application is started
		return "form/index";
	}

	private Form form;

	@PostMapping(value = "/")
	public String addNewSubscriber(Form form, Model model) {
		formRepository.save(new Form(form.getFirstName(), form.getLastName(), form.getSignedUp()));
		model.addAttribute("firstName", form.getFirstName());
		model.addAttribute("lastName", form.getLastName());

		return "form/result";
	}

}
