package Assignment4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Assignment1 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		int tc=Integer.parseInt(bf.readLine());
		for(int i=0;i<tc;i++){
			bf.readLine();
			int n=Integer.parseInt(bf.readLine());
			float details[][]=new float[n][4];		//time,fine and ratio=fine/time;
			for(int j=0;j<n;j++){
				String str=bf.readLine();
				String str1[]=str.split("\\s+");
				details[j][0]=j+1;
				details[j][1]=Float.parseFloat(str1[0]);
				details[j][2]=Float.parseFloat(str1[1]);
				details[j][3]=details[j][2]/details[j][1];
			}
			Arrays.sort(details,new Comparator<float[]>() {
				public int compare(float[] o1, float[] o2) {
					Float temp1=o1[3];
					Float temp2=o2[3];
					return temp2.compareTo(temp1);
				}
			});
			boolean flag=false;
			for(float[] det:details){
				if(!flag){
					flag=true;
					System.out.print((int)det[0]);
				}else
				System.out.print(" "+(int)det[0]);
			}
			if(i==tc-1) System.out.println();
			else System.out.println("\n");
			
		}
			
	}

}
