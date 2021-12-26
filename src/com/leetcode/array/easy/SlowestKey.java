package com.leetcode.array.easy;

public class SlowestKey {
    public static void main(String[] args) {
        SlowestKey slowestKey = new SlowestKey();
        System.out.println("-----------------Test Case 1-------------------");
        int [] releaseTimes1 = {23,34,43,59,62,80,83,92,97};
        String keyPressed = "qgkzzihfc";
        System.out.println("Slowest Key = "+slowestKey.slowestKey(releaseTimes1 , keyPressed));
        System.out.println();
    }

    public char slowestKey(int[] releaseTimes, String keysPressed) {
        int [] keys = new int [26];
        keys[keysPressed.charAt(0)-'a'] = releaseTimes[0];
        for(int i = 1 ; i < releaseTimes.length ; i++){
            int releaseTime = releaseTimes[i] - releaseTimes[i-1];
            if(keys[keysPressed.charAt(i)-'a'] < releaseTime)
                keys[keysPressed.charAt(i)-'a'] =  releaseTime;
        }

        int max = keys[0];
        char maxKey = 'a';
        for(int i = 1 ; i < 26 ; i++){
            if(keys[i] > max){
                max = keys[i];
                maxKey = (char)('a' + i);
            }
            else if(keys[i] == max){
                char newMaxKey = (char)Math.max(maxKey , 'a'+i);
                maxKey = newMaxKey;
            }
        }

        return maxKey;
    }
}
