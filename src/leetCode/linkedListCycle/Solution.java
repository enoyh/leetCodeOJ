package leetCode.linkedListCycle;

import java.util.Random;



public class Solution {
	
	public static void main(String[] args) {
		Random random = new Random();
		ListNode head = new ListNode(random.nextInt(100));
		ListNode p = head;
		for(int i = 1;i < 2;i++){
			p.next = new ListNode(random.nextInt(100));
			p = p.next;
		}
//		p.next = head;
		System.out.println(new Solution().hasCycle(head));
	}
	public boolean hasCycle(ListNode head) {
		if(head == null)
			return false;
		ListNode fast = head;
        ListNode slow = head;
		while(fast != null && fast.next != null){
			slow = slow.next;
        	fast = fast.next.next;
        	if(slow.equals(fast))
        		return true;
		}
		return false;
	}
}

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
		next = null;
	}
}