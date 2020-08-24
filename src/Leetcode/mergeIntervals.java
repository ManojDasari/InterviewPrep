package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * Given a collection of intervals, merge all overlapping intervals.

Example 1:

Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
Example 2:

Input: intervals = [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considered overlapping.
NOTE: input types have been changed on April 15, 2019. Please reset to default code definition to get new method signature.

 

Constraints:

intervals[i][0] <= intervals[i][1]
 */
public class mergeIntervals {
	public int[][] merge(int[][] intervals) {
		if (intervals.length == 0) {
			return new int[0][0];
		}

		Arrays.sort(intervals, (i1, i2) -> i1[0] - i2[0]);
		List<int[]> list = new ArrayList<>();
		list.add(new int[] { intervals[0][0], intervals[0][1] });
		for (int i = 1; i < intervals.length; i++) {
			int[] lastItem = list.get(list.size() - 1);

			if (intervals[i][0] > lastItem[1]) {
				list.add(new int[] { intervals[i][0], intervals[i][1] });
			} else if (intervals[i][1] > lastItem[1]) {
				list.remove(list.size() - 1);
				list.add(new int[] { lastItem[0], intervals[i][1] });
			}
		}

		int ans[][] = new int[list.size()][2];

		for (int i = 0; i < list.size(); i++) {

			int arr[] = list.get(i);
			ans[i][0] = arr[0];
			ans[i][1] = arr[1];

		}
		return ans;
	}

}
