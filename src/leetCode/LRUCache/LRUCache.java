package leetCode.LRUCache;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class LRUCache {
	private int  capacity;
	private Queue<Integer> queue = new LinkedList<Integer>();
	private HashMap<Integer,Integer> map  = new HashMap<Integer,Integer>();
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LRUCache cache = new LRUCache(3);
		Random random = new Random();
		for(int i = 0;i < 10;i++){
			int x = random.nextInt(5);
			cache.set(x, random.nextInt(5));
			System.out.println(x+":"+cache);
		}
		System.out.println("peek");
		for(int i = 0;i < 10;i++){
			int x = random.nextInt(5);
			cache.get(x);
			System.out.println(x+":"+cache);
		}
	}

	public LRUCache(int capacity) {
		this.capacity = capacity;
	}

	public int get(int key) {
		if(map.containsKey(key)){
			queue.remove(key);
			queue.add(key);
			return map.get(key);
		}
		return -1;
	}

	public void set(int key, int value) {
		if(map.containsKey(key)){
			queue.remove(new Integer(key));
		}else if(queue.size() >= capacity){
			map.remove(queue.peek());
			queue.poll();
		}
		map.put(key, value);
		queue.add(key);
		
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer("queue is :");
		for(Integer i:queue){
			sb.append(i+"  ");
		}
		sb.append("==key is:");
		for(Integer s:map.keySet()){
			sb.append(s+"  ");
		}
		return sb.toString();
	}
	
	
}
