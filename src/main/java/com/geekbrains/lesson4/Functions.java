package com.geekbrains.lesson4;

public class Functions {
    public static boolean isPalindrome(String word) {
        if (word.length() < 2) {
            return true;
        }
        if (word.charAt(0) != word.charAt(word.length() -1)) {
            return false;
        }

        return isPalindrome(word.substring(1,word.length() -1));
    }



}
