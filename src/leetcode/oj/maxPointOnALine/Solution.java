package leetcode.oj.maxPointOnALine;

// http://oj.leetcode.com/problems/max-points-on-a-line/

public class Solution {

	
	public int maxPoints(Point[] points) {
		if (points == null || points.length == 0) {
			return 0;
		} else if (points.length == 1) {
			return 1;
		} else {
			int max = 1;

			for (int x = 0; x < points.length; x++) {
				int count = 1;
				for (int y = x + 1; y < points.length; y++) {
					if (points[y].x == points[x].x
							|| points[y].y == points[x].y) {
						count++;
					} else if ((points[x].x - points[y].x) == 0) {
						for (int z = y + 1; z < points.length; z++) {
							if ((points[x].x - points[y].x) == 0)
								count++;
						}
					} else {
						float k = (float) ((points[x].y - points[y].y) / (points[x].y - points[y].x));
						for (int z = y + 1; z < points.length; z++) {
							try {
								float l = (float) ((points[x].y - points[z].y) / (points[x].y - points[z].x));
								if (z == l)
									count++;
							} catch (ArithmeticException ex) {

							}
						}
					}
				}

				if (count > max)
					max = count;
			}

			return max;
		}
	}
}

class Point {
	int x;
	int y;

	Point() {
		x = 0;
		y = 0;
	}

	Point(int a, int b) {
		x = a;
		y = b;
	}
}
