package lv.venta.controller;

import java.io.File;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lv.venta.service.impl.EmailSendingServiceImpl;

@Controller
public class EmailTestController {
	
	@Autowired
	private EmailSendingServiceImpl emailService = new EmailSendingServiceImpl();
	
	@GetMapping("/send-email")
	public String getEmailSend(Model model) {
		try {
		emailService.sendSimpleMsg("s24zapamart@venta.lv", "martazapacka17@gmail.com", "Sveiciens no ProgInz II kursa", 
				"Sveiki!\n Te Marta!", new File("C:\\Users\\Marta\\Documents\\GitHub\\ProgInzDemo_Sem2\\src\\main\\resources\\static\\pup.jpg"));
		model.addAttribute("package", "Epasts uz zapamart@venta.lv ir nosūtīts!");
		return "data-page";
	} catch (Exception e){
		model.addAttribute("package", e.getMessage());
		return "show-error-page";
	}
	}

}
