package leetCode.LRUCache2;

import java.util.HashMap;
import java.util.Random;

public class LRUCache {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LRUCache cache = new LRUCache(3);
		Random random = new Random();
		for (int i = 0; i < 10; i++) {
			int x = random.nextInt(5);
			int y = random.nextInt(5);
			cache.set(x, y);
			System.out.println(x + "-" +y+":" + cache);
		}
		System.out.println("peek");
		for (int i = 0; i < 10; i++) {
			int x = random.nextInt(5);
			cache.get(x);
			System.out.println(x + ":" + cache);
		}
	}

	private int capacity;
	private HashMap<Integer, DoubleNode> map = new HashMap<Integer, DoubleNode>();
	private DoubleNode head = null;
	private DoubleNode tail = null;

	public LRUCache(int capacity) {
		this.capacity = capacity;
	}

	public int get(int key) {
		if (map.containsKey(key)) {
			DoubleNode node = map.get(key);
			detach(node);
			attach(node);
			return node.value;
		}
		return -1;
	}

	public void set(int key, int value) {
		DoubleNode node = new DoubleNode(value);
		if(map.containsKey(key)){
			node = map.get(key);
			node.value = value;
			detach(node);
			//在链表中删除节点。并重新加入头部。
		}else if(map.size() >= capacity){
			DoubleNode temp  =deleTail();
			map.remove(key);
//			删除尾节点，
		}
//		节点加入头部。
		node = attach(node);
		map.put(key, node);
	}

	private DoubleNode attach(DoubleNode node) {
		if(head == null){
			head = tail = node;
			return node;
		}
		else{
			node.prev = null;
			node.next = head;
			head.prev = node;
			head = node;
			return node;
		}
	}

	private void detach(DoubleNode node) {
		if(node == null )
			return ;
		if(node.equals( head)){
			head = head.next;
			if(head != null)
				head.prev = null;
			node.next = null;
			return ;
		}
		if(node.equals(tail)){
			deleTail();
			return ;
		}
		node.prev.next = node.next;
		node.next.prev = node.prev;
	}

	private DoubleNode deleTail() {
		if(tail == null)
			return null;
		if(tail.prev == null){
			DoubleNode node = tail;
			head = tail = null;
			return node;
		}
		tail.prev.next = null;
		DoubleNode node = tail;
		tail = tail.prev;
		node.prev = null;
		return node;
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("queue:");
		DoubleNode p = head;
		while(p != null)
		{
			sb.append(p.value+"  ");
			p = p.next;
		}
		sb.append("map:");
		for(Integer i : map.keySet())
		{
			sb.append(i+"  ");
		}
		
		return sb.toString();
	}
	
	
}

class DoubleNode {
	int value;
	DoubleNode prev;
	DoubleNode next;

	public DoubleNode(int value) {
		this.value = value;
		prev = next = null;
	}
}