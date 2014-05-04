package leetCode.Util;


public class ListNode {
	public int val;
	public ListNode next;

	public ListNode(int x) {
		val = x;
		next = null;
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		ListNode p = this;
		sb.append(val);
		while(p.next != null){
			sb.append("->");
			p = p.next;
			sb.append(p.val);
		}
		return sb.toString();
	}
	
	
}