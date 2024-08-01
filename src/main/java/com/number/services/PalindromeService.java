package com.number.services;

public class PalindromeService {
	 
    public boolean isPalindrome(int number) {
        String numStr = String.valueOf(number);
        String reversedNumStr = new StringBuilder(numStr).reverse().toString();
        return numStr.equals(reversedNumStr);
    }
}
