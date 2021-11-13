package com.leetcode.string.medium;

public class ValidUTF {
    public static void main(String[] args) {
        System.out.println("---------------Test case 1----------------");
        int [] data1 = {197,130,1};
        System.out.println("Is Valid UTF ? "+validUtf8(data1));
        System.out.println();

        System.out.println("---------------Test case 2----------------");
        int [] data2 = {235,140,4};
        System.out.println("Is Valid UTF ? "+validUtf8(data2));
        System.out.println();

        System.out.println("---------------Test case 3----------------");
        int [] data3 = {25, 10, 4};
        System.out.println("Is Valid UTF ? "+validUtf8(data3));
        System.out.println();
    }

    public static boolean validUtf8(int[] data) {
        int count = 0;
        for (int i = 0; i < data.length; i ++) {
            if (count == 0) {
                if (data[i]>>>5 == 0b110) {
                    count = 1;
                }
                else if (data[i]>>>4 == 0b1110) {
                    count = 2;
                }
                else if (data[i]>>>3 == 0b11110) {
                    count = 3;
                }
                else if (data[i]>>>7 == 1) {
                    return false;
                }
            }
            else {
                if (data[i]>>>6 != 2) {
                    return false;
                }
                count --;
            }
        }
        return count == 0;
    }
}
