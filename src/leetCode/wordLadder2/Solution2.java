package leetCode.wordLadder2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

//bi-BFS双向广度优先搜索
public class Solution2 {
	public static void main(String[] args) {
		String arr[] = { "dose", "ends", "dine", "jars", "prow", "soap",
				"guns", "hops", "cray", "hove", "ella", "hour", "lens", "jive",
				"wiry", "earl", "mara", "part", "flue", "putt", "rory", "bull",
				"york", "ruts", "lily", "vamp", "bask", "peer", "boat", "dens",
				"lyre", "jets", "wide", "rile", "boos", "down", "path", "onyx",
				"mows", "toke", "soto", "dork", "nape", "mans", "loin", "jots",
				"male", "sits", "minn", "sale", "pets", "hugo", "woke", "suds",
				"rugs", "vole", "warp", "mite", "pews", "lips", "pals", "nigh",
				"sulk", "vice", "clod", "iowa", "gibe", "shad", "carl", "huns",
				"coot", "sera", "mils", "rose", "orly", "ford", "void", "time",
				"eloy", "risk", "veep", "reps", "dolt", "hens", "tray", "melt",
				"rung", "rich", "saga", "lust", "yews", "rode", "many", "cods",
				"rape", "last", "tile", "nosy", "take", "nope", "toni", "bank",
				"jock", "jody", "diss", "nips", "bake", "lima", "wore", "kins",
				"cult", "hart", "wuss", "tale", "sing", "lake", "bogy", "wigs",
				"kari", "magi", "bass", "pent", "tost", "fops", "bags", "duns",
				"will", "tart", "drug", "gale", "mold", "disk", "spay", "hows",
				"naps", "puss", "gina", "kara", "zorn", "boll", "cams", "boas",
				"rave", "sets", "lego", "hays", "judy", "chap", "live", "bahs",
				"ohio", "nibs", "cuts", "pups", "data", "kate", "rump", "hews",
				"mary", "stow", "fang", "bolt", "rues", "mesh", "mice", "rise",
				"rant", "dune", "jell", "laws", "jove", "bode", "sung", "nils",
				"vila", "mode", "hued", "cell", "fies", "swat", "wags", "nate",
				"wist", "honk", "goth", "told", "oise", "wail", "tels", "sore",
				"hunk", "mate", "luke", "tore", "bond", "bast", "vows", "ripe",
				"fond", "benz", "firs", "zeds", "wary", "baas", "wins", "pair",
				"tags", "cost", "woes", "buns", "lend", "bops", "code", "eddy",
				"siva", "oops", "toed", "bale", "hutu", "jolt", "rife", "darn",
				"tape", "bold", "cope", "cake", "wisp", "vats", "wave", "hems",
				"bill", "cord", "pert", "type", "kroc", "ucla", "albs", "yoko",
				"silt", "pock", "drub", "puny", "fads", "mull", "pray", "mole",
				"talc", "east", "slay", "jamb", "mill", "dung", "jack", "lynx",
				"nome", "leos", "lade", "sana", "tike", "cali", "toge", "pled",
				"mile", "mass", "leon", "sloe", "lube", "kans", "cory", "burs",
				"race", "toss", "mild", "tops", "maze", "city", "sadr", "bays",
				"poet", "volt", "laze", "gold", "zuni", "shea", "gags", "fist",
				"ping", "pope", "cora", "yaks", "cosy", "foci", "plan", "colo",
				"hume", "yowl", "craw", "pied", "toga", "lobs", "love", "lode",
				"duds", "bled", "juts", "gabs", "fink", "rock", "pant", "wipe",
				"pele", "suez", "nina", "ring", "okra", "warm", "lyle", "gape",
				"bead", "lead", "jane", "oink", "ware", "zibo", "inns", "mope",
				"hang", "made", "fobs", "gamy", "fort", "peak", "gill", "dino",
				"dina", "tier" };
		HashSet<String> dict = new HashSet<String>();
		dict.addAll(Arrays.asList(arr));
		String start = "nape";
		String end = "mild";
		long startTime = System.currentTimeMillis();

		ArrayList<ArrayList<String>> resultList = new Solution2().findLadders(
				start, end, dict);
		for (ArrayList<String> list : resultList) {
			for (String s : list) {
				System.out.print(s + "->");
			}
			System.out.println();
		}

		long endTime = System.currentTimeMillis();
		System.out.println("times:" + (endTime - startTime));
	}

	public ArrayList<ArrayList<String>> findLadders(String start, String end,
			HashSet<String> dict) {
		ArrayList<ArrayList<String>> resultList = new ArrayList<ArrayList<String>>();

		HashSet<String> unVissitedSet = new HashSet<String>();
		unVissitedSet.addAll(dict);
		unVissitedSet.remove(start);
		unVissitedSet.remove(end);

		Queue<TreeNode> leftQueue = new LinkedList<TreeNode>();
		Queue<TreeNode> rightQueue = new LinkedList<TreeNode>();
		TreeNode leftRoot = new TreeNode(start, null);
		TreeNode rightRoot = new TreeNode(end, null);
		leftQueue.offer(leftRoot);
		rightQueue.offer(rightRoot);
		boolean isEnd = false;

		while (isEnd == false) {
			if (leftQueue.size() <= rightQueue.size())
				isEnd = BFS(leftQueue, rightQueue, leftRoot, unVissitedSet,
						resultList);
			else
				isEnd = BFS(rightQueue, leftQueue, leftRoot, unVissitedSet,
						resultList);
		}
		// printTree(leftRoot);
		//
		// System.out.println("+++++++++++++++++++++++++++++++++++");
		// printTree(rightRoot);
		return resultList;

	}

	private boolean BFS(Queue<TreeNode> leftQueue, Queue<TreeNode> rightQueue,
			TreeNode leftRoot, HashSet<String> unVissitedSet,
			ArrayList<ArrayList<String>> resultList) {
		// 从左边的队列遍历，
		int size = leftQueue.size();
		TreeNode node;
		boolean isEnd = false;
		HashSet<String> tobeRemove = new HashSet<String>();

		for (int i = 0; i < size; i++) {
			node = leftQueue.poll();
			String string = node.val;

			HashSet<TreeNode> children = new HashSet<TreeNode>();
			for (int j = 0; j < string.length(); j++) {
				char c[] = string.toCharArray();
				for (char t = 'a'; t <= 'z'; t++) {
					c[j] = t;
					String s = new String(c);
					TreeNode newNode = new TreeNode(s, node);
					if (unVissitedSet.contains(s)) {
						tobeRemove.add(s);
						leftQueue.add(newNode);
						children.add(newNode);
					} else if (rightQueue.contains(newNode)) {
						// 找到了。
						isEnd = true;
						putResultList(node, newNode, leftRoot, leftQueue,
								rightQueue, resultList);
					}
				}
			}
			node.children = children;

		}
		unVissitedSet.removeAll(tobeRemove);
		tobeRemove.clear();
		if (leftQueue.isEmpty() && isEnd == false)
			return true;
		return isEnd;
	}

	private void putResultList(TreeNode node, TreeNode newNode,
			TreeNode leftRoot, Queue<TreeNode> leftQueue,
			Queue<TreeNode> rightQueue, ArrayList<ArrayList<String>> resultList) {

		for (TreeNode tNode : rightQueue) {
			if (newNode.equals(tNode)) {
				ArrayList<String> newList = new ArrayList<String>();
				Deque<String> dequeLeft = new LinkedList<String>();
				Deque<String> dequeRight = new LinkedList<String>();
				TreeNode lNode = node;
				while (lNode != null) {
					dequeLeft.push(lNode.val);
					lNode = lNode.parent;
				}
				while (tNode != null) {
					dequeRight.push(tNode.val);
					tNode = tNode.parent;
				}
				if (leftRoot.val.equals(dequeLeft.peek())) {
					while (!dequeLeft.isEmpty()) {
						newList.add(dequeLeft.pollFirst());
					}
					while (!dequeRight.isEmpty()) {
						newList.add(dequeRight.pollLast());
					}
				} else {
					while (!dequeRight.isEmpty()) {
						newList.add(dequeRight.pollFirst());
					}
					while (!dequeLeft.isEmpty()) {
						newList.add(dequeLeft.pollLast());
					}
				}
				resultList.add(newList);
			}
		}
	}

	class TreeNode {
		String val;
		TreeNode parent;
		HashSet<TreeNode> children;

		public TreeNode(String val, TreeNode parent) {
			this.val = val;
			this.parent = parent;
		}

		@Override
		public boolean equals(Object obj) {
			TreeNode node = (TreeNode) obj;
			return this.val.equals(node.val);
		}

		@Override
		public int hashCode() {
			return val.hashCode();
		}

	}

	private void printTree(TreeNode leftRoot) {
		System.out.println("Tree========================");
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(leftRoot);
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				TreeNode node = queue.poll();
				System.out.print(node.val + "--");
				if (node.children != null)
					queue.addAll(node.children);
			}
			System.out.println();
		}

	}
}
