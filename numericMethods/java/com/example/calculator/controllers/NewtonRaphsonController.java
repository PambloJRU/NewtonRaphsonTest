package com.example.calculator.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.MetodosNumericos.calculator.methods.NewtonRaphsonMethod;

@Controller
public class NewtonRaphsonController {
	
	@GetMapping("/")
    public String showNewtonForm() {
        return "newton";
    }
	
	@PostMapping("/newton")
	public String calculateNewton(
	            @RequestParam String function,
	            @RequestParam double startPoint,
	            Model model) {
	        
	        try {
	        	
	        	NewtonRaphsonMethod method = new NewtonRaphsonMethod();
		        double result;
	            result = method.newthonRpMethod(function, startPoint);
	            model.addAttribute("result", result);
		        model.addAttribute("function", function);
		        model.addAttribute("startPoint", startPoint);
	        } catch (Exception e) {
	            model.addAttribute("error", "Hubo un error al calcular: " + e.getMessage());
	            
	        }

	       
	        return "newton";
	    }
	  
	  @GetMapping("/hello")
	  @ResponseBody
		public String index() {
			return "Hello from Newton Raphson";
		}
	
}
