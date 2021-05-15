package com.leetcode.array;

import java.util.HashSet;
import java.util.Set;

public class PathCrossing {

	public static void main(String[] args) {
		String path = "NESWW";
		System.out.println("Is Path Crossing: " + isPathCrossing(path));

	}

	public static boolean isPathCrossing(String path) {
		Set<String> set = new HashSet<String>();
		set.add("0,0");
		int x = 0, y = 0;
		for (int i = 0; i < path.length(); i++) {
			char ch = path.charAt(i);

			if (ch == 'E')
				y++;
			else if (ch == 'W')
				y--;
			else if (ch == 'N')
				x--;
			else if (ch == 'S')
				x++;

			if (set.contains(x + "," + y)) {
				return true;
			}else{
                set.add(x + "," + y);
            }

		}

		return false;
	}

}
