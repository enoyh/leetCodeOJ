package leetCode.cloneGraph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
//		queue keep the need visited node.
//		map keep the has visited node in the new graph
		Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode >();
		HashMap<Integer,UndirectedGraphNode > visitedMap = new HashMap<Integer,UndirectedGraphNode >();
		HashMap<Integer,UndirectedGraphNode > cloneMap = new HashMap<Integer,UndirectedGraphNode >();
		if(node == null)
			return null;
		queue.add(node);
		UndirectedGraphNode  newNode = null;
		
//		visitedMap.put(node.label, node);
		
		while(!queue.isEmpty()){
			UndirectedGraphNode tempNode = queue.poll();
			if(visitedMap.get(tempNode.label) != null)
				continue;
			visitedMap.put(tempNode.label, tempNode);
//			clone a node
			UndirectedGraphNode pNode ;
			if(cloneMap.get(tempNode.label) == null){
				pNode = new UndirectedGraphNode (tempNode.label);
				cloneMap.put(pNode.label, pNode);
			}else
				pNode = cloneMap.get(tempNode.label);
			if(newNode == null)
				newNode = pNode;
			
//			clone neighbors;
			ArrayList<UndirectedGraphNode > neighbors = tempNode.neighbors;
			ArrayList<UndirectedGraphNode > newNodeNeighbors = pNode.neighbors;
			
			for(UndirectedGraphNode t:neighbors){
				if(cloneMap.get(t.label) != null){
					newNodeNeighbors.add(cloneMap.get(t.label));
				}
				else{ 
					//clone a neighbor
					UndirectedGraphNode cloneNeightbor = new UndirectedGraphNode(t.label);
					newNodeNeighbors.add(cloneNeightbor);
					
					cloneMap.put(cloneNeightbor.label, cloneNeightbor);
				}
				
				if(visitedMap.get(t.label) == null){
					queue.add(t);
				}
					
			}
			
		}
		
		return newNode;
	}

	class UndirectedGraphNode {
		int label;
		ArrayList<UndirectedGraphNode> neighbors;

		UndirectedGraphNode(int x) {
			label = x;
			neighbors = new ArrayList<UndirectedGraphNode>();
		}
	};
}
