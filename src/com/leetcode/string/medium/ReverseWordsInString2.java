package com.leetcode.string.medium;

public class ReverseWordsInString2 {
    public static void main(String[] args) {
        System.out.println("---------------Test Case 1----------------");
        String s = "the sky is blue";
        char [] arr = s.toCharArray();
        reverseWords(arr);
        System.out.println("Reversed Word = "+String.valueOf(arr));
        System.out.println();

        System.out.println("---------------Test Case 2----------------");
        s = "india is great country";
        char [] arr2 = s.toCharArray();
        reverseWords(arr2);
        System.out.println("Reversed Word = "+String.valueOf(arr2));
        System.out.println();
    }

    public static void reverseWords(char[] s) {
        int i=0;
        for(int j=0; j<s.length; j++){
            if(s[j]==' '){
                reverse(s, i, j-1);
                i=j+1;
            }
        }

        reverse(s, i, s.length-1);

        reverse(s, 0, s.length-1);
    }

    public static void reverse(char[] s, int i, int j){
        while(i<j){
            char temp = s[i];
            s[i]=s[j];
            s[j]=temp;
            i++;
            j--;
        }
    }
}
