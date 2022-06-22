package com.example.demo2;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@GetMapping("/")
	public String index() {
        RenderHTML r = new RenderHTML();
        r.render();
		return "Greetings from Spring Boot!";
	}

}
