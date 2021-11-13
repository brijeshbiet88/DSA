package com.leetcode.string.medium;

public class ValidateIPAddress {
    public static void main(String[] args) {
        System.out.println("-----------------Test Case 1---------------------");
        String IP = "172.16.254.1";
        System.out.println("IP Address Type = "+validIPAddress(IP));
        System.out.println();

        System.out.println("-----------------Test Case 2---------------------");
        IP = "2001:0db8:85a3:0:0:8A2E:0370:7334";
        System.out.println("IP Address Type = "+validIPAddress(IP));
        System.out.println();

        System.out.println("-----------------Test Case 3---------------------");
        IP = "256.256.256.256";
        System.out.println("IP Address Type = "+validIPAddress(IP));
        System.out.println();

        System.out.println("-----------------Test Case 4---------------------");
        IP = "2001:0db8:85a3:0:0:8A2E:0370:7334:";
        System.out.println("IP Address Type = "+validIPAddress(IP));
        System.out.println();

    }

    public static String validIPAddress(String IP) {
        if (IP.contains(":") && IP.contains(".") || IP.contains("::")) return "Neither";
        if (IP.contains(":")) {
            String[] tokens = IP.split(":",-1);
            if (tokens.length != 8 || tokens[0].charAt(0) == '0') return "Neither";
            String hexDigits = "0123456789abcdefABCDEF";
            for (String token : tokens) {
                if (token.length() == 0 || token.length() > 4) return "Neither";
                for (Character ch : token.toCharArray())
                    if (hexDigits.indexOf(ch) == -1) return "Neither";
            }
            return "IPv6";
        }

        else if (IP.contains(".")) {
            String[] tokens = IP.split("\\.");
            if (tokens.length != 4) return "Neither";
            for (String token : tokens) {
                if (token.length() == 0 || token.length() > 3) return "Neither";

                for (char ch : token.toCharArray())
                    if (!Character.isDigit(ch)) return "Neither";

                if (token.charAt(0) == '0' && token.length() > 1) return "Neither";
                if (Integer.parseInt(token) < 0 || Integer.parseInt(token) > 255) return "Neither";
            }
            return "IPv4";
        }
        return "Neither";
    }
}
