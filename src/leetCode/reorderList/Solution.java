package leetCode.reorderList;

import java.util.Random;
import java.util.Stack;

public class Solution {

	
	public static void main(String[] args) {
		Random random = new Random();
		ListNode head = new ListNode(random.nextInt(100));
		ListNode p = head;
		for(int i = 1;i < 9;i++){
			p.next = new ListNode(random.nextInt(100));
			p = p.next;
		}
		p = head;
		while(p != null){
			System.out.print(p.val +"  ");
			p = p.next;
		}
		System.out.println();
		new Solution().reorderList(head);
		p = head;
		while(p != null){
			System.out.print(p.val +"  ");
			p = p.next;
		}
	}
	
	public void reorderList(ListNode head) {
        if(head == null || head.next == null)
        	return;
        Stack<ListNode> stack = new Stack<ListNode>();
        ListNode fast = head;
        ListNode slow = head;
        ListNode p,temp;
        while(fast != null && fast.next != null){
        	slow = slow.next;
        	fast = fast.next.next;
        }
        p = slow.next;
        slow.next = null;
		//in stack;
		while(p != null){
			stack.push(p);
			p = p.next;
		}
		p = head;
		//out stack and in link
		while(p != null && stack.size() > 0){
			temp = stack.pop();
			temp.next = p.next;
			p.next = temp;
			p = temp.next;
		}
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