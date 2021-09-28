package com.rahul.utils;

public class Utility {
    public static boolean toCheckGivenIdIsPrimeOrNot(Long num) {
        int count = 0;
        for(int i = 2; i <= num-1; i++) {
            if(num % i == 0) {
                count++;
            }
        }
        return count == 0;
    }
}
