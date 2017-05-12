import java.util.*;
import java.io.*;
import java.math.*;
public class MinScalar{
	public static void main(String args[]) throws Exception{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.parseInt(bf.readLine());int index=1;
		while(t-->0){
			int n=Integer.parseInt(bf.readLine());
			int vector1[]=new int[n];
			int vectortemp[]=new int[n];
			int vector2[]=new int[n];
			String str=bf.readLine();
			String s[]=str.split("\\s+");
			for(int i=0;i<s.length;i++){
				vector1[i]=Integer.parseInt(s[i]);
			}
			str=bf.readLine();
			String s1[]=str.split("\\s+");
			for(int i=0;i<s1.length;i++){
				vectortemp[i]=Integer.parseInt(s1[i]);
			}
			Arrays.sort(vector1);
			Arrays.sort(vectortemp);int j=0;
			for(int i=s1.length-1;i>=0;i--){
				vector2[j]=vectortemp[i];j++;
			}
			//long ans=0;
			BigInteger ans=new BigInteger("0");
			for(int i=0;i<s.length;i++){
				ans=ans.add(new BigInteger(""+vector1[i]).multiply(new BigInteger(""+vector2[i])));
				//ans=ans+(vector1[i]*vector2[i]);
			}
			System.out.println("Case #"+index+": "+ans);index++;
		}
	}

}