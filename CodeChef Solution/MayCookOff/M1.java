import java.util.*;
import java.io.*;
public class M1{
	public static void main(String args[])throws Exception{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		int tc=Integer.parseInt(bf.readLine());
		while(tc-->0){
			int n=Integer.parseInt(bf.readLine());
			String str=bf.readLine();
			String arr[]=str.split("\\s+");
			boolean day[]=new boolean[101];
			int ans=0;
			for(int i=0;i<n;i++){
				int t=Integer.parseInt(arr[i]);
				if(!day[t]){
					day[t]=true;
					ans++;
				}
			}
			System.out.println(ans);
		}
	}
	
	
}