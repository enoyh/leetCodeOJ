package leetCode.wordLadder;

import java.util.HashMap;
import java.util.HashSet;

public class Solution {

	// �ؽ�˹�����㷨��
	// һ���ڽӾ���
	// һ����visited���飬��ʾ��Щ�ڵ��Ѿ����ʹ��ˡ�������map����ʼ��Ϊfalse
	// һ��distance ���飬��ʾÿһ���ڵ��뿪ʼ�ڵ�ľ��룬��ʼ��Ϊ�����
	// һ��path���飬������ʾ·������ÿһ���ڵ��ǰ���·����

	public int ladderLength(String start, String end, HashSet<String> dict) {
		dict.add(start);
		dict.add(end);
		int length = dict.size();
		int startIndex  = -1;
		
		char gMatrix[][] = new char[length][length];// �ڽӱ�
		String v[] = dict.toArray(new String[0]);// ���㼯��
		int distance[] = new int[length];// ÿ�����㵽Դ�ڵ�ľ���
		HashMap<Integer,Boolean> visitedMap = new HashMap<Integer,Boolean>();//ÿ���ڵ��Ƿ񱻷��ʡ�
		int path[] = new int[length];// ÿ���ڵ����·����ǰһ���ڵ���±꣬
		//��ʼ��
		for (int i = 0; i < length; i++){
			for (int j = i+1; j < length; j++)
				if(canGo(v[i],v[j]))
					gMatrix[i][j] = '1';// ��ʾÿ���ڵ�ɴ
				else
					gMatrix[i][j] = '-';// ��ʾÿ���ڵ㲻�ɴ
			if(v[i].equals(start)){
				distance[i] = 0;//����Ϊ0��
				path[i] = i;
				startIndex = i;
				visitedMap.put(i, true);
			}else{
				distance[i] = length + 1;//�����Զ��
			}
		}
		//����
		for(int i = 0 ;i < length;i++){
			if(gMatrix[startIndex][i]=='1' && startIndex != i){
				
			}
			
			
		}
		return 0;
	}

	private boolean canGo(String s1, String s2) {
		if(s1.equals(s2) )
			return true;
		int length = s1.length();
		char[] c1 = s1.toCharArray();
		char[] c2 = s2.toCharArray();
		boolean flag = true;
		for(int i = 0 ;i < length;i++)		
			if(c1[i] != c2[i])
				if(flag)
					flag = false;
				else
					return false;
		
		return true;
	}

}
