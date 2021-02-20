package pe.edu.galaxy.java.api.spring.boot.talleres.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.validation.BindingResult;

public class GenericController {
	
	protected String formatMapMessage(BindingResult result) {
		List<Map<String, String>> errors = 
				result.getFieldErrors().stream().map(err -> 
					{
						Map<String, String> error = new HashMap<>();
						error.put(err.getField(), err.getDefaultMessage());
						return error;
		}
		
	).collect(Collectors.toList());
		return errors.toString();
	}
}
