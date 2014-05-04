package leetCode.reverseLinkedList2;

import leetCode.Util.ListNode;

public class Solution2 {
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
		
		ListNode head = new Solution2().reverseBetween(node1, 2, 5);
		System.out.println(head);
	}
	public ListNode reverseBetween(ListNode head, int m, int n) {
		if(head == null || m == n)
			return head;
		ListNode prev = new ListNode(-1);
		ListNode pHead = prev;
		prev.next = head;
		ListNode p = head;
		int count = 1;
		while(count++ < m){
			prev = p;
			p = p.next;
		}
		//从p开始依次插入到prev的后面。
		ListNode q = p;
		p = p.next;
		while(count++ <= n){
			ListNode next = p.next;
			p.next = prev.next;
			prev.next = p;
			q.next = next;
			p = next;
		}
		
		return pHead.next;
	}
}
