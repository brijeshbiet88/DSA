package com.leetcode.miscellaneous;

public class CompareVersionNumbers {
    public static void main(String[] args) {
        System.out.println("-----------------Test Case 1--------------------");
        String version1 = "1.0.1";
        String version2 = "1";
        System.out.println("Result = "+compareVersion(version1 , version2));
        System.out.println();

        System.out.println("-----------------Test Case 2--------------------");
        version1 = "1.01";
        version2 = "1.001";
        System.out.println("Result = "+compareVersion(version1 , version2));
        System.out.println();

        System.out.println("-----------------Test Case 3--------------------");
        version1 = "1.0";
        version2 = "1.0.0";
        System.out.println("Result = "+compareVersion(version1 , version2));
        System.out.println();

        System.out.println("-----------------Test Case 4--------------------");
        version1 = "1.0.1";
        version2 = "1";
        System.out.println("Result = "+compareVersion(version1 , version2));
        System.out.println();

        System.out.println("-----------------Test Case 5--------------------");
        version1 = "7.5.2.4";
        version2 = "7.5.3";
        System.out.println("Result = "+compareVersion(version1 , version2));
        System.out.println();

    }

    public static int compareVersion(String version1, String version2) {
        if(version1.equals(version2)) return 0;

        String [] v1 = version1.split("\\.");
        String [] v2 = version2.split("\\.");

        int i = 0;
        while(i < v1.length || i < v2.length) {
            int sv1 = i < v1.length ? Integer.parseInt(v1[i]) : 0;
            int sv2 = i < v2.length ? Integer.parseInt(v2[i]) : 0;
            if(sv1 < sv2)
                return -1;
            else if (sv1 > sv2)
                return 1;
            i++;
        }
        return 0;

    }
}
