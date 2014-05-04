package leetCode.restoreIPAddresses;

import java.util.ArrayList;

public class Solution {
	public static void main(String[] args) {
		String s = "010010";
		System.out.println(new Solution().restoreIpAddresses(s));
	}
	public ArrayList<String> restoreIpAddresses(String s) {
		ArrayList<String> ipAddrs = new ArrayList<String>();
		int len = s.length();
		if(len < 4 || len >12)
			return ipAddrs;
		String sub1,sub2,sub3,sub4;
		for(int i = 1;i < 4;i++){
			sub1 = s.substring(0,i);
			int num1 = tran2Num(sub1);
			int remainlen1 = len - sub1.length();
			if(num1 > 255 || remainlen1>9 || remainlen1 < 3)
				continue;
			for(int j = i+1;j < i+4 && j<= len;j++){
				sub2 = s.substring(i,j);
				int num2 = tran2Num(sub2);
				int remainlen2 = remainlen1 - sub2.length();
				if(num2 > 255 || remainlen2>6 || remainlen2 < 2)
					continue;
				
				for(int k = j+1;k < j+4 && k<= len;k++){
					sub3 = s.substring(j,k);
					int num3 = tran2Num(sub3);
					int remainlen3 = remainlen2 - sub3.length();
					if(num3 > 255 || remainlen3>3 || remainlen3 < 1)
						continue;
					sub4 = s.substring(k);
					int num4 = tran2Num(sub4);
					if(num4 <=255)
						ipAddrs.add(sub1+"."+sub2+"."+sub3+"."+sub4);
				}
			}
		}
		return ipAddrs;
	}
	private int tran2Num(String sub) {
		if(sub.startsWith("0") && sub.length()>1)
			return 256;
		int num = 0;
		for(int i = 0;i< sub.length();i++){
			char c = sub.charAt(i);
			num = num * 10 +(c-'0');
		}
		return num;
	}
}
