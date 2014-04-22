package leetCode.linkedListCycle2;

import java.util.Random;

import leetCode.Util.ListNode;

public class Solution {
	public static void main(String[] args) {
		Random random = new Random();
		ListNode head = new ListNode(random.nextInt(100));
		ListNode p = head;
		for(int i = 1;i < 2;i++){
			int x = random.nextInt(100);
			p.next = new ListNode(x);
			p = p.next;
			System.out.print(x+" ");
		}
		System.out.println();
		//p.next = head.next.next.next;
		ListNode node = new Solution().detectCycle(head);
		if(node != null)
			System.out.println(node.val);
		else 
			System.out.println("null");
	}
	
	public ListNode detectCycle(ListNode head) {
		if(head == null || head.next == null)
			return null;
		ListNode fast = head;
        ListNode slow = head;
		while(fast != null && fast.next != null){
			slow = slow.next;
        	fast = fast.next.next;
        	if(slow.equals(fast))
        		break;
		}
		if(!slow.equals(fast))
			return null;
		//find the begin node;
		ListNode p,temp,prev;
		p  = head;
		prev = slow;
		//find the prev node of q;
		while(true){
			temp = findPrevNodeInCycle(prev);
			p = findPrevNodeInLink(head,prev);
			if(temp.equals(p) ){
				prev = p;
				if(prev.equals(head))
					return head;
			}
			
			else
				return prev;
		}
    }

	private ListNode findPrevNodeInLink(ListNode head, ListNode prev) {
		ListNode p = head;
		while(!p.next.equals(prev))
			p = p.next;
		return p;
	}

	private ListNode findPrevNodeInCycle(ListNode prev) {
		ListNode p = prev;
		while(!p.next.equals(prev))
			p = p.next;
		return p;
	}
}
