package com.example.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RefactoringAndOptimizationCode {

	//Before Optimization Code
	
	  public List<Integer> filterEvenNumbers(List<Integer> numbers) {
	        List<Integer> evenNumbers = new ArrayList<>();
	        for (Integer number : numbers) {
	            if (number % 2 == 0) {
	                evenNumbers.add(number);
	            }
	        }
	        return evenNumbers;
	    }
	
	  //Before Optimization Code
	    
	  public List<Integer> filterEvenNumber(List<Integer> numbers) {
	        return numbers.stream()
	                      .filter(number -> number % 2 == 0)
	                      .collect(Collectors.toList());
	    }


      
}
