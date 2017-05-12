package MarchChallenge;
import java.util.*;
import java.io.*;
public class Problem1 {

	public static void main(String[] args)  throws Exception{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.parseInt(bf.readLine().trim());
		for(int j=0;j<t;j++){
			String str=bf.readLine();
			String s[]=str.split("\\s+");
			int X=Integer.parseInt(s[0]);
			int Y=Integer.parseInt(s[1]);
			int K=Integer.parseInt(s[2]);
			int N=Integer.parseInt(s[3]);
			int p=0,c=0,pageLeft=X-Y,i=0;
			boolean flag=false;
			for(i=0;i<N;i++){
				str=bf.readLine();
				s=str.split("\\s+");
				p=Integer.parseInt(s[0]);
				c=Integer.parseInt(s[1]);
				if(K>=c && p>=pageLeft){
					flag=true;break;
				}
			}
			
			if(flag){
				int temp=N-(i+1);
				while(temp>0){
					temp--;bf.readLine();
				}
				System.out.println("LuckyChef");
			}else{
				System.out.println("UnluckyChef");
			}
		}

	}

}
