package leetCode.wordLadder2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;


public class Solution {
	
	public static void main(String[] args) {
		String arr[] = { "ted","tex","red","tax","tad","den","rex","pee" };
		HashSet<String> dict = new HashSet<String>();
		dict.addAll(Arrays.asList(arr));
		String start = "red";
		String end = "tax";
		long startTime = System.currentTimeMillis();
		ArrayList<ArrayList<String>> resultList = new Solution().findLadders(start, end, dict);
		for(ArrayList<String> list:resultList){
			for(String s:list)
				System.out.print(s+"->");
			System.out.println();
		}
		long endTime = System.currentTimeMillis();
		System.out.println("times:"+(endTime- startTime));
	}
	public ArrayList<ArrayList<String>> findLadders(String start, String end,
			HashSet<String> dict) {
		// dict.add(start);
		dict.add(end);
		int result = -1;
		int level = 1;
		int countOfCuurentLevel = 1;
		int countOfNextLevel = 0;
		ArrayList<ArrayList<String>> resultList = new ArrayList<ArrayList<String>>();
		
		HashSet<String> unVissitedSet = new HashSet<String>();
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		unVissitedSet.addAll(dict);
		queue.offer(new TreeNode(start, null));
		HashSet<String> tobeReMove = new HashSet<String>();
		while (!queue.isEmpty()) {
			//
			TreeNode node = queue.poll();
			String string = node.val;
			
			countOfCuurentLevel--;
			int m = 0;

			HashSet<TreeNode> children = new HashSet<TreeNode>();
			for (int i = 0; i < string.length(); i++) {
				char c[] = string.toCharArray();
				for (char t = 'a'; t < 'z'; t++) {
					c[i] = t;
					String s = new String(c);
					if (unVissitedSet.contains(s)) {
						if (s.equals(end)){
							//找到了。
							result = level + 1;
							putReslut(resultList,node,s);
						}
						else {
							tobeReMove.add(s);
							TreeNode newNode = new TreeNode(s, node);
							children.add(newNode);
							queue.add(newNode );
							m++;
						}
					}

				}
			}
			
			node.children = children;
			countOfNextLevel += m;

			if (countOfCuurentLevel == 0) {
				level++;
				if(result == level)//说明在这层找到了
					return resultList;
				//进入下一层
				unVissitedSet.removeAll(tobeReMove);
				tobeReMove.clear();
				countOfCuurentLevel = countOfNextLevel;
				countOfNextLevel = 0;
			}
		}

		return resultList;
	}

	private void putReslut(ArrayList<ArrayList<String>> resultList,
			TreeNode node, String s) {
		ArrayList<String> list = new ArrayList<String>();
		list.add(s);
		while(node != null){
			list.add(node.val);
			node = node.parent;
		}
		Collections.reverse(list);
		resultList.add(list);
	}
	
	
}
class TreeNode{
	String val;
	TreeNode parent;
	HashSet<TreeNode> children;
	
	public TreeNode(String val, TreeNode parent) {
		this.val = val;
		this.parent = parent;
		this.children = new HashSet<TreeNode>();
	}
	
}
