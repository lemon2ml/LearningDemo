package com.lei.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Solution {
	public int maxPoints(Point[] points) {
		int n = points.length;
		if(n<2) return n;
		int ret = 0;
		for(int i=0;i<n;i++) {
			Point a = points[i];
			int dup = 1, vtl = 0;
			Map<Float, Integer> map = new HashMap<>();
			for(int j=0;j<n;j++) {
				if(i == j) continue;
				Point b = points[j];
				if(b.x == a.x) {
					if(a.y == b.y) dup++;
					else vtl++;
				}else {
					float k = (float)(b.y - a.y)/(b.x - a.x);
					if(map.get(k)==null) map.put(k, 1);
					else map.put(k, map.get(k)+1);
				}
				
			}
			int max = vtl;
			for(float k: map.keySet()) {
				max = Math.max(max, map.get(k));
			}
			ret = Math.max(ret, max+dup);
		}

		
		return ret;
	}
}

class Point{
	int x, y;
	Point(){
		x = 0;
		y =0;
	}
	Point(int a, int b){
		x = a;
		x = b;
	}
}
