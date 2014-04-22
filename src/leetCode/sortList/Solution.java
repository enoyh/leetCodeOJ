package leetCode.sortList;

import java.util.Random;

public class Solution {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Random random = new Random();
		ListNode head = new ListNode(random.nextInt(20));
		ListNode p = head;
		for(int i = 1;i < 100;i++){
			p.next = new ListNode(random.nextInt(20));
			p = p.next;
		}
		p = head;
		while(p != null){
			System.out.print(p.val+"  ");
			p = p.next;
		}
		p =new Solution().sortList(head);
		System.out.println("reslut：");
		while(p != null){
			System.out.print(p.val+"  ");
			p = p.next;
		}
			
		
	}

	public ListNode sortList(ListNode head) {
		
		if(head == null || head.next == null)
			return head;//只有一个节点，
		ListNode mid ;
		ListNode first,slow;
		first = slow = head;
		while(first.next!= null && first.next.next!=null){
			first = first.next.next;
			slow = slow.next;
		}
		mid = slow;
		
		ListNode midNext = mid.next;
		mid.next = null;//断开。
		ListNode left = sortList(head);
		ListNode right = sortList(midNext);
		return mergeList(left, right);
		
	}
	
	private ListNode mergeList(ListNode head, ListNode midNext) {
		
		ListNode t = new ListNode(-1);
		ListNode result = t;
		ListNode p = head;
		ListNode q = midNext;
		while(p != null && q != null){
			if(p.val <= q.val){
				t.next = p;
				p = p.next;
			}
			else{
				t.next = q;
				q = q.next;
			}
			t = t.next;
			
		}
		t.next = (p == null )  ? q:p;
		return result.next;
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