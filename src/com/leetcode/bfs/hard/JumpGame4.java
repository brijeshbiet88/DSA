package com.leetcode.bfs.hard;

import java.util.*;

public class JumpGame4 {

    public static void main(String[] args) {
        JumpGame4 o = new JumpGame4();
        System.out.println("---------------Test Case 1---------------");
        int [] arr1 = {100,-23,-23,404,100,23,23,23,3,404};
        System.out.println("Min Jumps To Reach End = "+o.minJumps(arr1));
        System.out.println();
    }

    public int minJumps(int[] arr) {
        if(arr.length == 1) return 0;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0;i < arr.length ; i++){
            List<Integer> indices = map.getOrDefault(arr[i], new ArrayList<>());
            indices.add(i);
            map.put(arr[i], indices);
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);

        boolean[] visited= new boolean[arr.length];
        int level = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            while(size-->0){
                Integer head = queue.poll();


                if(head == arr.length -1){
                    return level;
                }

                if(head < 0 || head >= arr.length || visited[head]){
                    continue;
                }

                if(head - 1 > 0 && !visited[head - 1]) {
                    queue.offer(head-1);
                }

                if(head + 1 < arr.length && !visited[head + 1]) {
                    queue.offer(head+1);
                }

                if(map.containsKey(arr[head])){
                    for(int index : map.get(arr[head])){
                        if(index>=0 && index < arr.length && !visited[index]){
                            queue.offer(index);
                        }
                    }
                    map.remove(arr[head]);
                }
                visited[head] = true;
            }
            level++;

        }
        return -1;

    }
}
