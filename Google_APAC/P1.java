package ICPC_Chennai_2015;
import java.util.*;
import java.io.*;

public class P1{
	
	public static void main(String args[]) throws Exception{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
			int tc=Integer.parseInt(bf.readLine());
			while(tc-->0){
				String str=bf.readLine();
				String s[]=str.split("\\s+");
				int N=Integer.parseInt(s[0]);
				int K=Integer.parseInt(s[1]);
				str=bf.readLine();
				String sd[]=str.split("\\s+");
				long ans=0;
				for(int i=0;i<N;i++){
					if((Integer.parseInt(sd[i])+K)%7==0)
						ans++;
				}
				System.out.println(ans);
			}
		}
	}