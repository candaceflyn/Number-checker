package com.number.services;

public class DenominationService {
	 
    private static final int[] denominations = {1000, 500, 100, 50, 20, 10, 5, 2, 1};
 
    public String getDenominationBreakdown(int amount) {
        StringBuilder breakdown = new StringBuilder();
        for (int denomination : denominations) {
            int count = amount / denomination;
            if (count > 0) {
                breakdown.append(denomination).append(" * ").append(count).append(" = ").append(denomination * count).append("<br>");
                amount %= denomination;
            }
        }
        return breakdown.toString();
    }
 
    public String convertDigitsToWords(int amount) {
        String[] words = {"ZERO", "ONE", "TWO", "THREE", "FOUR", "FIVE", "SIX", "SEVEN", "EIGHT", "NINE"};
        StringBuilder wordString = new StringBuilder();
        while (amount > 0) {
            int digit = amount % 10;
            wordString.insert(0, words[digit] + " ");
            amount /= 10;
        }
        return wordString.toString().trim();
    }
}