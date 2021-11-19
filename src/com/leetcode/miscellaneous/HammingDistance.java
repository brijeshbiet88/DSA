package com.leetcode.miscellaneous;

public class HammingDistance {
    public static void main(String[] args) {
        System.out.println("-----------------Test case 1--------------------");
        int x = 1 ;
        int y = 4;
        System.out.println("Hamming Distance Between x = "+x+" and y = "+y+" = "+hammingDistance(x,y));
        System.out.println();

        System.out.println("-----------------Test case 2--------------------");
        x = 1 ;
        y = 3;
        System.out.println("Hamming Distance Between x = "+x+" and y = "+y+" = "+hammingDistance(x,y));
        System.out.println();

        System.out.println("-----------------Test case 3--------------------");
        x = 11 ;
        y = 6;
        System.out.println("Hamming Distance Between x = "+x+" and y = "+y+" = "+hammingDistance(x,y));
        System.out.println();

        System.out.println("-----------------Test case 4--------------------");
        x = 0 ;
        y = 15;
        System.out.println("Hamming Distance Between x = "+x+" and y = "+y+" = "+hammingDistance(x,y));
        System.out.println();

        System.out.println("-----------------Test case 5--------------------");
        x = 32 ;
        y = 8;
        System.out.println("Hamming Distance Between x = "+x+" and y = "+y+" = "+hammingDistance(x,y));
        System.out.println();
    }

    public static int hammingDistance(int x, int y) {
        int hammingDistance = 0;
        int xor = x^y;

        while(xor != 0){
            if((xor&1) == 1){
                hammingDistance++;
            }
            xor = xor >> 1;

        }

        return hammingDistance;
    }
}
