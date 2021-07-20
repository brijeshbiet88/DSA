package com.leetcode.dp.hard;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class FrogJump {

	public static void main(String[] args) {
		System.out.println("--------------Test Case 1------------------");
		int [] stones = {0,1,3,5,6,8,12,17};
		System.out.println("can Cross ? "+ canCross(stones) );
		System.out.println();
		
		System.out.println("--------------Test Case 2------------------");
		int [] stones2 = {0,1,3,5,6,8,12,17};
		System.out.println("can Cross ? "+ canCrossDfs(stones2) );
		System.out.println();
	}

	public static boolean canCross(int[] stones) {
		Set<Integer> set = new HashSet<Integer>();
		for (int stone : stones)
			set.add(stone);
		Queue<Pair> queue = new LinkedList<Pair>();
		Pair pair = new Pair(0, 0);
		queue.add(pair);

		while (!queue.isEmpty()) {

			Pair p = queue.poll();
			int jump = p.jump;
			int pos = p.pos;
			
			if (p.pos == stones[stones.length - 1]) {
				return true;
			}
			
			for (int i = jump - 1; i <= jump + 1; i++) {
				if (i <= 0) {
					continue;
				}
				int currentPos = pos + i;
				if(set.contains(currentPos)) {
					Pair newPair = new Pair(i, currentPos);
					queue.add(newPair);
				}
			}

		}

		return false;

	}
	
	
	
	public static boolean canCrossDfs(int[] stones) {
		Set<Integer> set = new HashSet<Integer>();
		for (int stone : stones)
			set.add(stone);
		Stack<Pair> stack = new Stack<Pair>();
		Pair pair = new Pair(0, 0);
		stack.add(pair);

		while (!stack.isEmpty()) {

			Pair p = stack.pop();
			int jump = p.jump;
			int pos = p.pos;

			if (p.pos == stones[stones.length - 1]) {
				return true;
			}

			for (int i = jump - 1; i <= jump + 1; i++) {
				if (i <= 0) {
					continue;
				}
				int currentPos = pos + i;
				if (set.contains(currentPos)) {
					Pair newPair = new Pair(i, currentPos);
					stack.push(newPair);
				}
			}

		}

		return false;

	}

}

class Pair{
	
	int jump;
	int pos;
	public Pair(int jump, int pos) {
		super();
		this.jump = jump;
		this.pos = pos;
	}
	public int getJump() {
		return jump;
	}
	public void setJump(int jump) {
		this.jump = jump;
	}
	public int getPos() {
		return pos;
	}
	public void setPos(int pos) {
		this.pos = pos;
	}
	
	
}
