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

    }

    public static int nextGreaterElement(int n) {
        char[] ch = String.valueOf(n).toCharArray();
        int index = ch.length - 2;
        while (index >= 0 && ch[index] >= ch[index + 1])
        index--;

        if (index == -1)
            return -1;

        int j = ch.length - 1;
        while (j >= index && ch[j] <= ch[index])
            j--;

        swap(ch, index, j);
        reverse(ch, index + 1);

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
