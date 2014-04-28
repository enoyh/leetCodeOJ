package leetCode.ConvertSortedList2BST;

import leetCode.Util.ListNode;
import leetCode.Util.TreeNode;

public class Solution {
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		
		ListNode p = head;
		for(int i = 2;i < 6;i++){
			p.next = new ListNode(i);
			p = p.next;
		}
		TreeNode root = new Solution().sortedListToBST(head);
		System.out.println(root);
	}
	
	public TreeNode sortedListToBST(ListNode head) {
		if(head == null)
			return null;
		TreeNode root = null;
		ListNode midNode = findMidNode(head);
		if(midNode == null )
			return null;
		
		root = new TreeNode(midNode.val);
		root.left = (midNode == head?null: sortedListToBST(head));
		root.right = sortedListToBST(midNode.next);
		
		return root;
	}
	
	private ListNode findMidNode(ListNode head){
		if(head == null || head.next == null)
			return head;
		ListNode prev,mid,prevM = null;
		prev = mid = head;
		
		while(prev != null && prev.next != null){
			prev = prev.next.next;
			prevM = mid;
			mid = mid.next;
		}
		if(prevM != null)
			prevM.next = null;
		return mid;
	} 
}
