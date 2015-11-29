
package org.learn.Question;

import java.util.Arrays;

import org.learn.PrepareTree.Node;

public class SumInRoot2LeafPath {
	private static int[] arr;
	
	public static void maxSumPath(Node root, int[] path,int sum)  {
		boolean sumExist = maxSumPathRoot2Leaf(root, path,0,sum);
		if(sumExist) {
			System.out.println("Sum exist in Path: " + Arrays.toString(arr));
		} else {
			System.out.println("Sum does not exist in any Path");
		}
	}
	private static boolean maxSumPathRoot2Leaf(Node root, int[] path,int index,int sum) {
		if(null == root) {
			return false;
		}
		path[index++] = root.data;
		sum = sum - root.data;
		if(root.left == null && root.right == null) {
			if(sum == 0) {	
				arr  = Arrays.copyOf(path, index);	
				return true;
			}
			return false;
		}
		return maxSumPathRoot2Leaf(root.left,path,index,sum ) ||
					maxSumPathRoot2Leaf(root.right,path,index,sum );		
	}	
}
