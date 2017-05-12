import java.util.*;
import java.io.*;

public class APACDemo{
	static ArrayList<Long> temp=new ArrayList<Long>();
	static ArrayList<Long> arr=new ArrayList<Long>();
	public static void subArraySum(){
		for(int i=0;i<arr.size();i++){
			for(int j=i;j<arr.size();j++){
				long sum=0;
				for(int k=i;k<=j;k++){
					sum+=arr.get(k);
				}
				//System.out.println(sum);
				temp.add(sum);
			}
		}
	}
	public static void main(String args[]) throws Exception{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
			int tc=Integer.parseInt(bf.readLine());
			int c=1;
			while(tc-->0){
				String str=bf.readLine();
				String s[]=str.split("\\s+");
				int N=Integer.parseInt(s[0]);
				int Q=Integer.parseInt(s[1]);
				str=bf.readLine();
				temp.clear();arr.clear();
				String sarr[]=str.split("\\s+");
				for(int i=0;i<N;i++){
					arr.add(Long.parseLong(sarr[i]));
				} 
				subArraySum();
				Collections.sort(temp);
				//System.out.println(temp);
				long farr[]=new long[temp.size()+1];
				farr[0]=0;
				for(int i=0;i<temp.size();i++){
					farr[i+1]=temp.get(i);
				}
				for(int i=1;i<=temp.size();i++){
					farr[i]+=farr[i-1];
				}
				int Li,Ri;
				ArrayList<Long> ans=new ArrayList<Long>();
				
				for(int i=0;i<Q;i++){
					String sd=bf.readLine();
					String sa[]=sd.split("\\s+");
					Li=Integer.parseInt(sa[0]);
					Ri=Integer.parseInt(sa[1]);
					ans.add(farr[Ri]-farr[Li-1]);
				}
				System.out.println("Case #"+c+":");
				for(int i=0;i<ans.size();i++){
					System.out.println(ans.get(i));
				}
				c++;
			}
		}
	}
