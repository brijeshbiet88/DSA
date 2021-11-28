package com.leetcode.string.medium;

public class DecodeString {
    static int i = 0;
    public static void main(String[] args) {
        System.out.println("--------------Test case 1-----------------");
        String s = "3[a]2[bc]";
        System.out.println("String s = "+s+" after decoding = "+decodeString(s));
        System.out.println();

        System.out.println("--------------Test case 2-----------------");
        i =0;
        s = "3[a2[c]]";
        System.out.println("String s = "+s+" after decoding = "+decodeString(s));
        System.out.println();

        System.out.println("--------------Test case 3-----------------");
        i =0;
        s = "2[abc]3[cd]ef";
        System.out.println("String s = "+s+" after decoding = "+decodeString(s));
        System.out.println();

        System.out.println("--------------Test case 4-----------------");
        i =0;
        s = "abc3[cd]xyz";
        System.out.println("String s = "+s+" after decoding = "+decodeString(s));
        System.out.println();

    }

    public static String decodeString(String s) {
        StringBuilder sb = new StringBuilder();
        while(i < s.length() && s.charAt(i) != ']'){
            if(Character.isDigit(s.charAt(i))){
                int k = 0;
                while(i < s.length() && Character.isDigit(s.charAt(i)))
                    k = k*10 + s.charAt(i++) - '0';
                i++;
                String r = decodeString(s);
                while(k-- > 0)
                    sb.append(r);
                i++;
            } else
                sb.append(s.charAt(i++));
        }
        return sb.toString();
    }
}
