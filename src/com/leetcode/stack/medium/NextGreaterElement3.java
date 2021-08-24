package com.leetcode.stack.medium;

public class NextGreaterElement3 {
    public static void main(String[] args) {
        System.out.println("---------------Test Case 1-------------------");
        int n = 12;
        System.out.println("Next Greater Element of "+n+" = "+nextGreaterElement(n));
        System.out.println();

        System.out.println("---------------Test Case 2-------------------");
        n = 21;
        System.out.println("Next Greater Element of "+n+" = "+nextGreaterElement(n));
        System.out.println();

        System.out.println("---------------Test Case 3-------------------");
        n = 230241;
        System.out.println("Next Greater Element of "+n+" = "+nextGreaterElement(n));
        System.out.println();

        System.out.println("---------------Test Case 4-------------------");
        n = 2343210;
        System.out.println("Next Greater Element of "+n+" = "+nextGreaterElement(n));
        System.out.println();


    }

    public static int nextGreaterElement(int n) {
        char[] ch = String.valueOf(n).toCharArray();
        int i = ch.length - 2;
        while (i >= 0 && ch[i] >= ch[i + 1])
        i--;

        if (i == -1)
            return -1;

        int j = ch.length - 1;
        while (j >= i && ch[j] <= ch[i])
            j--;

        swap(ch, i, j);
        reverse(ch, i + 1);

        try {
            return Integer.parseInt(new String(ch));
        } catch (Exception e) {
            return -1;
        }
    }

    private static void reverse(char[] ch, int start) {
        int l = start, r = ch.length - 1;
        while (l < r) {
            swap(ch, l, r);
            l++;
            r--;
        }
    }

    private  static void swap(char[] ch, int i, int j) {
        char temp = ch[i];
        ch[i] = ch[j];
        ch[j] = temp;
    }
}
