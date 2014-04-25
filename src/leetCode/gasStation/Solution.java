package leetCode.gasStation;

public class Solution {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int canCompleteCircuit(int[] gas, int[] cost) {
		int i = 0,len = gas.length;
		if(gas == null || cost == null || len < 0)
			return -1;
		for(i = 0; i< len; i++){
			int k = i;
			int myGas = 0;
			int j = 0;
			for(;j < len;j++)
			{
				//from i to i;
				myGas += gas[k];
				if(myGas < cost[k])
					break;
				myGas -= cost[k];
				k++;
				if(k >= len)
					k -= len;
			}
			if(j >= len)
				return i;
			else
				i += j;
		}
		
		return -1;

	}
}
