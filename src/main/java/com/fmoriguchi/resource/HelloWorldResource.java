/**
 * 
 */
package com.fmoriguchi.resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author fmoriguchi
 *
 */
@RestController
@RequestMapping("/helloworld")
public class HelloWorldResource {

	@GetMapping
	public String defaultMessage() {
		return "Hello World!";
	}
	
	@GetMapping("/{message}")
	public String echo(@PathVariable("message") String message) {
		
		return message;
	}
}
