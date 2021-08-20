package com.leetcode.string.medium;

public class StringCompression {
    public static void main(String[] args) {
        char [] chars = {'a', 'a' , 'b' , 'b' , 'c' , 'c' , 'd' , 'e' , 'e' , 'f'};
        System.out.println("Length of Compressed String "+compress(chars));
    }

    public static int compress(char[] chars) {
        int i = 0;
        int indexTracker = 0;
        while (i < chars.length ){
            int j = i + 1;
            while(j < chars.length && chars[i] == chars[j]){
                    j++;
            }
            if(j - i == 1){
                chars[indexTracker++] = chars[i];
            }else{
                chars[indexTracker++] = chars[i];
                indexTracker = compressUtil(chars , j-i , indexTracker);
            }
            i = j ;

        }
        return indexTracker;
    }

    private static int compressUtil(char[] chars, int count, int indexTracker) {
        String countStr = String.valueOf(count);
        for(char c : countStr.toCharArray()){
            chars[indexTracker++] = c;
        }
        return indexTracker;
    }
}
