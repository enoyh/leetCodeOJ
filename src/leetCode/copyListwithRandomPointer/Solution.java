package leetCode.copyListwithRandomPointer;

import java.util.Random;

import leetCode.Util.ListNode;

public class Solution {

	public static void main(String[] args) {
		Random random = new Random();
		RandomListNode head = new RandomListNode(random.nextInt(100));
		RandomListNode p = head;
		for(int i = 1;i < 10;i++){
			p.next = new RandomListNode(random.nextInt(100));
			p = p.next;
		}
		for(p = head;p != null;p = p.next){
			System.out.print(p.label+" ");
		}
		System.out.println();
//		p.next = head;
		RandomListNode head2 = new Solution().copyRandomList(head);
		for(p = head;p != null;p = p.next){
			System.out.print(p.label+" ");
		}
		System.out.println();
		p = head;
		for(p = head2;p != null;p = p.next){
			System.out.print(p.label+" ");
		}
	}
	
	
	public RandomListNode copyRandomList(RandomListNode head) {
		if(head == null )
			return head;
		//copy and linked.
		RandomListNode prev;
		RandomListNode head2;
		for(prev  = head;prev != null;prev = prev.next.next){
			//copy a node
			RandomListNode t = new RandomListNode(prev.label);
			t.next = prev.next;
			//linked after prev;
			prev.next = t;
		}
		prev = head;
		while(prev != null && prev.next != null){
			RandomListNode t  = prev.next;
			if(prev.random != null)
				t.random = prev.random.next;
			else 
				t.random = null;
			prev = t.next;
		}
//		for(prev = head;prev!= null;prev = prev.next){
//			System.out.print(prev.label+" ");
//		}
//		System.out.println();
		//chaifen linkedlist;
		prev = head;
		head2 = prev.next;
		while(prev != null && prev.next != null){
			RandomListNode t  = prev.next;
			prev.next = t.next;
			prev = prev.next;
			if(t.next != null)
				t.next = t.next.next;
		}
        return head2;
    }
}
class RandomListNode {
	int label;
	RandomListNode next, random;

	RandomListNode(int x) {
		this.label = x;
	}
};