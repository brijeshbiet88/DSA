package com.leetcode.string.medium;

import java.util.HashMap;
import java.util.Map;

public class IsomorphicStrings {
    public static void main(String[] args) {
        System.out.println("-------------Test Case 1-----------------");
        String s = "egg";
        String t = "odd";
        System.out.println("Are Strings s = "+s+" and t = "+t+" Ismorphic ? "+isIsomorphic(s,t));
        System.out.println();

        System.out.println("-------------Test Case 2-----------------");
        s = "paper";
        t = "title";
        System.out.println("Are Strings s = "+s+" and t = "+t+" Ismorphic ? "+isIsomorphic(s,t));
        System.out.println();

        System.out.println("-------------Test Case 3-----------------");
        s = "card";
        t = "desk";
        System.out.println("Are Strings s = "+s+" and t = "+t+" Ismorphic ? "+isIsomorphic(s,t));
        System.out.println();

        System.out.println("-------------Test Case 4-----------------");
        s = "chord";
        t = "dense";
        System.out.println("Are Strings s = "+s+" and t = "+t+" Ismorphic ? "+isIsomorphic(s,t));
        System.out.println();

        System.out.println("-------------Test Case 5-----------------");
        s = "tea";
        t = "pre";
        System.out.println("Are Strings s = "+s+" and t = "+t+" Ismorphic ? "+isIsomorphic(s,t));
        System.out.println();
    }

    public static boolean isIsomorphic(String s, String t) {
        if(s.length() != t.length()) return false;
        Map<Character,Character> map1 = new HashMap<Character,Character>();
        Map<Character,Boolean> map2 = new HashMap<Character,Boolean>();

        char [] charS = s.toCharArray();
        char [] charT = t.toCharArray();
        int n = charS.length ;

        for(int i = 0 ; i <n ; i++ ){

            if(map1.containsKey(charS[i])){

                if(map1.get(charS[i]) != charT[i]){
                    return false;
                }

                if(map2.get(charT[i]) == false){
                    return false;
                }
            }else{
                map1.put(charS[i],charT[i]);
                if(map2.containsKey(charT[i])){
                    return false;
                }
                map2.put(charT[i] , true);
            }
        }
        return true;
    }
}
