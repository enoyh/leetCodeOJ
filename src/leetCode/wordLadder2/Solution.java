package leetCode.wordLadder2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;


//BFS:TLE
public class Solution {
	public static void main(String[] args) {
		String arr[] = {"dose","ends","dine","jars","prow","soap","guns","hops","cray","hove","ella","hour","lens","jive","wiry","earl","mara","part","flue","putt","rory","bull","york","ruts","lily","vamp","bask","peer","boat","dens","lyre","jets","wide","rile","boos","down","path","onyx","mows","toke","soto","dork","nape","mans","loin","jots","male","sits","minn","sale","pets","hugo","woke","suds","rugs","vole","warp","mite","pews","lips","pals","nigh","sulk","vice","clod","iowa","gibe","shad","carl","huns","coot","sera","mils","rose","orly","ford","void","time","eloy","risk","veep","reps","dolt","hens","tray","melt","rung","rich","saga","lust","yews","rode","many","cods","rape","last","tile","nosy","take","nope","toni","bank","jock","jody","diss","nips","bake","lima","wore","kins","cult","hart","wuss","tale","sing","lake","bogy","wigs","kari","magi","bass","pent","tost","fops","bags","duns","will","tart","drug","gale","mold","disk","spay","hows","naps","puss","gina","kara","zorn","boll","cams","boas","rave","sets","lego","hays","judy","chap","live","bahs","ohio","nibs","cuts","pups","data","kate","rump","hews","mary","stow","fang","bolt","rues","mesh","mice","rise","rant","dune","jell","laws","jove","bode","sung","nils","vila","mode","hued","cell","fies","swat","wags","nate","wist","honk","goth","told","oise","wail","tels","sore","hunk","mate","luke","tore","bond","bast","vows","ripe","fond","benz","firs","zeds","wary","baas","wins","pair","tags","cost","woes","buns","lend","bops","code","eddy","siva","oops","toed","bale","hutu","jolt","rife","darn","tape","bold","cope","cake","wisp","vats","wave","hems","bill","cord","pert","type","kroc","ucla","albs","yoko","silt","pock","drub","puny","fads","mull","pray","mole","talc","east","slay","jamb","mill","dung","jack","lynx","nome","leos","lade","sana","tike","cali","toge","pled","mile","mass","leon","sloe","lube","kans","cory","burs","race","toss","mild","tops","maze","city","sadr","bays","poet","volt","laze","gold","zuni","shea","gags","fist","ping","pope","cora","yaks","cosy","foci","plan","colo","hume","yowl","craw","pied","toga","lobs","love","lode","duds","bled","juts","gabs","fink","rock","pant","wipe","pele","suez","nina","ring","okra","warm","lyle","gape","bead","lead","jane","oink","ware","zibo","inns","mope","hang","made","fobs","gamy","fort","peak","gill","dino","dina","tier" };
		HashSet<String> dict = new HashSet<String>();
		dict.addAll(Arrays.asList(arr));
		String start = "nape";
		String end = "mild";
		long startTime = System.currentTimeMillis();
		
		ArrayList<ArrayList<String>> resultList = new Solution().findLadders(start, end, dict);
		for(ArrayList<String> list:resultList){
			for(String s:list){
				System.out.print(s+"->");
			}
			System.out.println();
		}
		
		long endTime = System.currentTimeMillis();
		System.out.println("times:"+(endTime- startTime));
	}
    public ArrayList<ArrayList<String>> findLadders(String start, String end,
			HashSet<String> dict) {
		dict.remove(start);
		dict.add(end);
		int result = -1;
		int level = 1;
		int countOfCuurentLevel = 1;
		int countOfNextLevel = 0;
		ArrayList<ArrayList<String>> resultList = new ArrayList<ArrayList<String>>();
		
		HashSet<String> unVissitedSet = new HashSet<String>();
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		unVissitedSet.addAll(dict);
		TreeNode root = new TreeNode(start, null);
		queue.offer(root);
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
				for (char t = 'a'; t <= 'z'; t++) {
					c[i] = t;
					String s = new String(c);
					if (unVissitedSet.contains(s)) {
						if (s.equals(end)){
							//
							result = level + 1;
							putReslut(resultList,node,s);
						}
						else {
							tobeReMove.add(s);
							TreeNode newNode = new TreeNode(s, node);
							children.add(newNode);
							queue.offer(newNode );
							m++;
						}
					}

				}
			}
			node.children = children;
			countOfNextLevel += m;

			if (countOfCuurentLevel == 0) {
				level++;
				if(result == level)//
					return resultList;
				//
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
		Stack<String> stack = new Stack<String>();
		
		while(node != null){
			stack.push(node.val);
			node = node.parent;
		}
		
		while(!stack.isEmpty()){
			list.add(stack.pop());
		}
		list.add(s);
		resultList.add(list);
	}
	
	
	class TreeNode{
		String val;
		TreeNode parent;
		HashSet<TreeNode> children;
		public TreeNode(String val, TreeNode parent) {
			this.val = val;
			this.parent = parent;
		}
		
	}
}
