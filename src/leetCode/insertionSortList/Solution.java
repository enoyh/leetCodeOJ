package leetCode.insertionSortList;

import java.util.Random;



public class Solution {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random random = new Random();
		ListNode head = new ListNode(random.nextInt(20));
		ListNode p = head;
		for(int i = 1;i < 20;i++){
			p.next = new ListNode(random.nextInt(20));
			p = p.next;
		}
		p = head;
		while(p != null){
			System.out.print(p.val+"  ");
			p = p.next;
		}
		p =new Solution().insertionSortList(head);
		System.out.println("");
		while(p != null){
			System.out.print(p.val+"  ");
			p = p.next;
		}
	}

	public ListNode insertionSortList(ListNode head) {
		if(head == null || head.next == null)
			return head;
		ListNode p,q;
		p = head;
		while(p!= null  && p.next != null){
			q = p.next;
			int val = q.val;
			ListNode t = head;
			ListNode prev = null;
			boolean exchange = false;
			while(!t.equals(q)){
				if(t.val > val){
					p.next = p.next.next;
					if(prev == null)
						head = q;
					else
						prev.next = q;
					q.next = t;
					exchange = true;
					break;
				}
				prev = t;
				t = t.next;
			}
			if(!exchange)
				p = p.next;
		}
		
		return head;
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