package com.accenture.demo;

import java.net.URI;

import javax.ws.rs.core.MediaType;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

@SpringBootApplication
@Controller
public class SpringbootMicroserviceClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootMicroserviceClientApplication.class, args);
	}
	
	@GetMapping("/")
	public String home() {
		return "home";
	}
	
	@GetMapping("/gettext")
	public String getText(Model model){
		URI uri = URI.create("http://localhost:2018/getRandomText");
		
		Client client = new Client();
		WebResource wr = client.resource(uri);
		String result = wr.type(MediaType.APPLICATION_JSON).get(String.class);
		
		model.addAttribute("message",result);
		
		return "home";
	}

}
