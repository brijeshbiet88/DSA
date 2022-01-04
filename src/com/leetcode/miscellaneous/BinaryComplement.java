package com.leetcode.miscellaneous;

public class BinaryComplement {
    public static void main(String[] args) {
     BinaryComplement bc = new BinaryComplement();
        System.out.println(bc.bitwiseComplement(5));
        System.out.println(bc.bitwiseComplement(15));
        System.out.println(bc.bitwiseComplement(16));
        System.out.println(bc.bitwiseComplement(0));
    }

    public int bitwiseComplement(int n) {
        int x = 1;
        while(n > x){
            x = x * 2 +1;
        }
        return x - n;
    }
}
