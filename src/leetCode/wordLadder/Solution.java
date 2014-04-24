package leetCode.wordLadder;

import java.util.HashMap;
import java.util.HashSet;

public class Solution {

	// 地杰斯特拉算法。
	// 一个邻接矩阵
	// 一个、visited数组，表示哪些节点已经访问过了。可以用map，初始化为false
	// 一个distance 数组，表示每一个节点离开始节点的距离，初始化为无穷大。
	// 一个path数组，用来表示路径。即每一个节点的前面的路径。

	public int ladderLength(String start, String end, HashSet<String> dict) {
		dict.add(start);
		dict.add(end);
		int length = dict.size();
		int startIndex  = -1;
		
		char gMatrix[][] = new char[length][length];// 邻接表
		String v[] = dict.toArray(new String[0]);// 顶点集合
		int distance[] = new int[length];// 每个定点到源节点的距离
		HashMap<Integer,Boolean> visitedMap = new HashMap<Integer,Boolean>();//每个节点是否被访问。
		int path[] = new int[length];// 每个节点最短路劲的前一个节点的下标，
		//初始化
		for (int i = 0; i < length; i++){
			for (int j = i+1; j < length; j++)
				if(canGo(v[i],v[j]))
					gMatrix[i][j] = '1';// 表示每个节点可达。
				else
					gMatrix[i][j] = '-';// 表示每个节点不可达。
			if(v[i].equals(start)){
				distance[i] = 0;//距离为0。
				path[i] = i;
				startIndex = i;
				visitedMap.put(i, true);
			}else{
				distance[i] = length + 1;//距离很远。
			}
		}
		//遍历
		for(int i = 0 ;i < length;i++){
			if(gMatrix[startIndex][i]=='1' && startIndex != i){
				
			}
			
			
		}
		return 0;
	}

	private boolean canGo(String s1, String s2) {
		if(s1.equals(s2) )
			return true;
		int length = s1.length();
		char[] c1 = s1.toCharArray();
		char[] c2 = s2.toCharArray();
		boolean flag = true;
		for(int i = 0 ;i < length;i++)		
			if(c1[i] != c2[i])
				if(flag)
					flag = false;
				else
					return false;
		
		return true;
	}

}
