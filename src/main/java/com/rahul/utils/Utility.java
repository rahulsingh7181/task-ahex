package com.rahul.utils;

public class Utility {
    public static boolean toCheckGivenIdIsPrimeOrNot(Long num) {
        int count = 0;
        for(int i = 2; i <= num-1; i++) {
            if(num % i == 0) {
                count++;
            }
        }
        if(count == 0) {
            System.out.println("Prime Number");
            return true;
        }else {
            System.out.println("Not Prime Number");
            return false;
        }
    }
}
