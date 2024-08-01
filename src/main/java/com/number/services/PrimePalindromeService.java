package com.number.services;

import java.util.ArrayList;
import java.util.List;

public class PrimePalindromeService {

	public List<Integer> getPrimePalindromes(int start, int end) {
		
		List<Integer> primePalindromeList= new ArrayList<>();
		for(int i = start;i <=end;i++) {
			if(isPrime(i) && isPalindrome(i)) {
				primePalindromeList.add(i);
			}
		}
        return primePalindromeList;
    }

	private boolean isPalindrome(int num) {
		String numStr = String.valueOf(num);
		String rev=new StringBuilder(numStr).reverse().toString();
		return numStr.equals(rev);
	}

	private boolean isPrime(int num) {
		if(num<=1) {
		return false;
		}
		for(int i =2; i<=Math.sqrt(i);i++) {
			if(num%i == 0) {
				return false;
			}
		}
		return true;
		
	}
	
	
}
