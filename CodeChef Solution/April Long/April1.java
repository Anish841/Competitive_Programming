import java.util.*;
import java.io.*;
public class April1{
	public static void main(String args[]) throws Exception{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.parseInt(bf.readLine());
		while(t-->0){
			int n=Integer.parseInt(bf.readLine());
			String str=bf.readLine();
			String s1[]=str.split("\\s+");
			long ans=0;boolean flag=false;
			for(int i=0;i<s1.length-1;i++){
				flag=false;
				while(i<s1.length-1 && Integer.parseInt(s1[i])!=Integer.parseInt(s1[i+1])){
					ans++;i++;flag=true;
				}
				if(flag)
					ans++;
			}
			System.out.println(ans);
		}
	}
}