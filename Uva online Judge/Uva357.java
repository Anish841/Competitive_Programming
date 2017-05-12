package Practice_murali_sir;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Uva357 {

	public static void main(String[] args) throws IOException {
		long numways[]=new long[30001];
		numways[0]=1;
		int coinD[]={1,5,10,25,50};
		for(int i=0;i<5;i++){
			for(int j=coinD[i];j<30001;j++){
				numways[j]+=numways[j-coinD[i]];
			}
		}
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		String str;int num;
		while(true){
			str=bf.readLine();
			if(str==null)break;
			num=Integer.parseInt(str);
			if(numways[num]==1)
				System.out.println("There is only "+numways[num]+" way to produce "+num+" cents change.");
			else
				System.out.println("There are "+numways[num]+" ways to produce "+num+" cents change.");
			
		}
	}

}
