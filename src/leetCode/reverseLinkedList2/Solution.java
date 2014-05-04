package leetCode.reverseLinkedList2;

import java.util.Stack;

import leetCode.Util.ListNode;
public class Solution {
	public static void main(String[] args) {
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		ListNode node5 = new ListNode(5);
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		
		ListNode head = new Solution().reverseBetween(node1, 1, 5);
		System.out.println(head);
	}
	public ListNode reverseBetween(ListNode head, int m, int n) {
		if(head == null || m == n)
			return head;
		Stack<Integer> stack = new Stack<Integer>();
		ListNode prev = null;
		ListNode p = head;
		int count = 0;
		while(true){
			count ++ ;
			if(count == m)
				prev = p;
			if(count  >= m && count <= n)
				stack.push(p.val);
			if(count >= n)
				break;
			p = p.next;
		}
		p = prev;
		while(!stack.isEmpty()){
			p.val = stack.pop();
			p = p.next;
		}
		return head;
	}
}
