package com.number.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.number.services.DenominationService;
import com.number.services.PalindromeService;
import com.number.services.PrimePalindromeService;

@Controller
public class NumberController {
 
    @PostMapping("/checkCircularPrime")
    @ResponseBody
    public String checkCircularPrime(@RequestParam("number") int number) {
        if (isCircularPrime(number)) {
            return number + " is a circular prime number.";
        } else {
            return number + " is not a circular prime number.";
        }
    }
 
    // Method to check if a number is prime
    private boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
 
    // Method to check if a number is circular prime
    private boolean isCircularPrime(int num) {
        String numStr = String.valueOf(num);
        for (int i = 0; i < numStr.length(); i++) {
            String rotatedNumStr = numStr.substring(i) + numStr.substring(0, i);
            int rotatedNum = Integer.parseInt(rotatedNumStr);
            if (!isPrime(rotatedNum)) {
                return false;
            }
        }
        return true;
    }
    
    @PostMapping("/checkPronic")
    @ResponseBody
    public String checkPronic(@RequestParam("number") int number) {
        if (isPronic(number)) {
            return number + " is a pronic number.";
        } else {
            return number + " is not a pronic number.";
        }
    }
 
    // Method to check if a number is prime
    private boolean isPronic(int num) {
        if (num < 0) {
            return false;
        }
        for (int i = 0; i <= num; i++) {
            if (i*(i+1) == num) {
                return true;
            }
        }
        return false;
    }
    
    @PostMapping("/checkDisarium")
    @ResponseBody
    public String checkDisarium(@RequestParam("number") int number) {
        if (isDisarium(number)) {
            return number + " is a Disarium number.";
        } else {
            return number + " is not a Disarium number.";
        }
    }
 
    private boolean isDisarium(int num) {
        return calculateSumOfDigits(num) == num;
    }
    
    private int calculateSumOfDigits(int number) {
    	int sum=0;
    	String numStr=String.valueOf(number);
    	for(int i = 0;i< numStr.length();i++) {
    		int digit = Character.getNumericValue(numStr.charAt(i));
    		sum+=Math.pow(digit, i+1);
    	}
    	return sum;
    }
    
    @PostMapping("/generateFibo")
    @ResponseBody
    public String generateFibonacciSeries(@RequestParam("limit") int limit) {
        StringBuilder result = new StringBuilder();
        int num1 = 0, num2 = 1;
 
        result.append("Fibonacci Series up to ").append(limit).append(": ");
        result.append(num1).append(", ").append(num2);
 
        int nextTerm = num1 + num2;
        while (nextTerm <= limit) {
            result.append(", ").append(nextTerm);
            num1 = num2;
            num2 = nextTerm;
            nextTerm = num1 + num2;
        }
 
        return result.toString();
    }
    @PostMapping("/calculateDenomination")
    public String calculateDenomination(@RequestParam("amount") int amount, Model model) {
        DenominationService service = new DenominationService();
        String result = service.getDenominationBreakdown(amount);
        String words = service.convertDigitsToWords(amount);
        model.addAttribute("result", result);
        model.addAttribute("words", words);
        return "result";
    }
    @PostMapping("/checkPalindrome")
    public String checkPalindrome(@RequestParam("number") int number, Model model) {
        PalindromeService service = new PalindromeService();
        boolean isPalindrome = service.isPalindrome(number);
        model.addAttribute("number", number);
        model.addAttribute("isPalindrome", isPalindrome);
        return "result2";
    }
    
    @PostMapping("/primePalindrome")
    public String primePalindrome(@RequestParam("start") int start, @RequestParam("end") int end, Model model) {
        PrimePalindromeService service = new PrimePalindromeService();
        List<Integer> primePalindromeList = service.getPrimePalindromes(start, end);
        model.addAttribute("start", start);
        model.addAttribute("end", end);
        model.addAttribute("primePalindromes", primePalindromeList);
        return "result3";
    }
    
    @PostMapping("/generateMatrix")
    public String generateMatrix(@RequestParam ("size") int size, @RequestParam("matrix") int[][] matrix, Model model) {
    	model.addAttribute("matrix",matrix);
    	return "matrixDisplay";
    }
    
}
