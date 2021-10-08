package com.leetcode.miscellaneous;

public class SingleNumber3 {
    public static void main(String[] args) {
        System.out.println("----------------Test Case 1---------------------");
        int [] nums = {1 , 2 , 1 , 3 , 2 , 5};
        int [] res = singleNumber(nums);
        System.out.println("Single Numbers are "+res[0]+" and "+res[1]);
        System.out.println();

        System.out.println("----------------Test Case 2---------------------");
        int [] nums2 = {0,1};
        int [] res2 = singleNumber(nums2);
        System.out.println("Single Numbers are "+res2[0]+" and "+res2[1]);
        System.out.println();

        System.out.println("----------------Test Case 3---------------------");
        int [] nums3 = {0 , -1};
        int [] res3 = singleNumber(nums3);
        System.out.println("Single Numbers are "+res3[0]+" and "+res3[1]);
        System.out.println();

        System.out.println("----------------Test Case 4---------------------");
        int [] nums4 = {1 , 2 , 1 , 6};
        int [] res4 = singleNumber(nums4);
        System.out.println("Single Numbers are "+res4[0]+" and "+res4[1]);
        System.out.println();

        System.out.println("----------------Test Case 4---------------------");
        int [] nums5 = {3 , 4 , 8 , 3};
        int [] res5 = singleNumber(nums5);
        System.out.println("Single Numbers are "+res5[0]+" and "+res5[1]);
        System.out.println();
    }

    public static int[] singleNumber(int[] nums) {
        int xor = 0;
        for(int num: nums){
            xor ^= num;
        }
        int lowestBit = xor & (-xor); // doing negative gives 2's compliment which helps in finding lowest Set Bit

        int[] result = new int[2];
        for(int num: nums){
            if((lowestBit & num) == 0){
                result[0] ^= num;
            }
            else{
                result[1] ^= num;
            }
        }
        return result;
    }
}
