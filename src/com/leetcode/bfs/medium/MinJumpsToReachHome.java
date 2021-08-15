package com.leetcode.bfs.medium;

import java.util.*;

public class MinJumpsToReachHome {

    public static void main(String[] args) {
        System.out.println("----------------Test Case 1-----------------");
        int [] forbidden3 = {14,4,18,1,15};
        int a = 3;
        int b = 15;
        int x = 9;
        System.out.println("Min Jumps To Reach Home "+minimumJumps(forbidden3 , a ,b , x));

        System.out.println("----------------Test Case 2-----------------");
        int [] forbidden2 = {8,3,16,6,12,20};
        a = 15;
        b = 13;
        x = 11;
        System.out.println("Min Jumps To Reach Home "+minimumJumps(forbidden2 , a ,b , x));

        System.out.println();
        System.out.println("----------------Test Case 3-----------------");

        int [] forbidden = {1,6,2,14,5,17,4};
        a = 16;
        b = 9;
        x = 7;
        System.out.println("Min Jumps To Reach Home "+minimumJumps(forbidden , a ,b , x));
        System.out.println();

        System.out.println("----------------Test Case 4-----------------");

        int [] forbidden4 = {162,118,178,152,167,100,40,74,199,186,26,73,200,127,30,124,193,84,184,36,103,149,153,9,54,154,133,95,45,198,79,157,64,122,59,71,48,177,82,35,14,176,16,108,111,6,168,31,134,164,136,72,98};
        a = 29;
        b = 98;
        x = 80;
        System.out.println("Min Jumps To Reach Home "+minimumJumps(forbidden4 , a ,b , x));

    }

    public static int minimumJumps(int[] forbidden, int a, int b, int x) {
        HashSet<List<Integer>> visited = new HashSet<List<Integer>>();
        int minJumps = 0;
        for(int num : forbidden) {
            visited.add(Arrays.asList(num , 0));
            visited.add(Arrays.asList(num , 1));
        }
        Queue<Node> q = new LinkedList<Node>();
        q.add(new Node(0 , 0 , 1));
        while (!q.isEmpty()){

            Node temp = q.poll();
            if(temp.pos == x){
                return temp.step;
            }
            if((temp.pos + a ) > 0 && !visited.contains(Arrays.asList(temp.pos  , 1)) && temp.pos <= 6000) {
                Node fwd = new Node(temp.pos + a, temp.step + 1 , 1);
                q.add(fwd);
                visited.add(Arrays.asList(temp.pos , 1));
            }

            if(temp.direction != 0 && (temp.pos - b )> 0 && !visited.contains(Arrays.asList(temp.pos   , 0)) && temp.pos  <= 6000){
                Node back = new Node(temp.pos -b , temp.step + 1 , 0);
                q.add(back);
                visited.add(Arrays.asList(temp.pos , 0));
            }

             if(q.size() == 0){
                return - 1;
            }

        }

        return -1;
    }

    static class Node{
        public int pos ;
        public int step;
        public int direction ;

        public Node(int pos , int step , int direction){
            this.pos = pos;
            this.step = step;
            this.direction = direction;
        }

    }
}
