import java.util.*;
import java.io.*;
public class J2{
	public static int checkBinary(int no){
		int n=(int)(Math.floor(((Math.log10(no)/Math.log10(2))+1)));
		int b[]=new int[n];
		int index=n-1;
		while(no!=0){
			b[index--]=no%2;
			no=no/2;
		}
		int ans=0;
		for(int i=0;i<n-2;i++){
			if(b[i]==1){
				if(b[i+1]==0 && b[i+2]==1){
					ans++;
				}
			}
		}
		return ans;
	}
	public static void main(String args[]) throws Exception{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		int tc=Integer.parseInt(bf.readLine());
		while(tc-->0){
			String str=bf.readLine();
			String s[]=str.split("\\s+");
			int r=Integer.parseInt(s[0]);
			int k=Integer.parseInt(s[1]);
			int np=(int)(Math.floor(Math.log10(r)/Math.log10(2)));
			ArrayList<Integer> sm=new ArrayList<Integer>();
			sm.add(5);
			int ans=0;
			if(r>=5 && 1>=k){
				ans++;
			}
			ArrayList<Integer> temparr=new ArrayList<Integer>();
			boolean flag=false;
			/*for(int i=3;i<=np;i++){
				int temp=(int)Math.pow(2,i);
				temparr.clear();
				for(int j=0;j<sm.size();j++){
					if((temp+sm.get(j))<=r){
						int p=checkBinary(temp+sm.get(j));
						temparr.add(temp+sm.get(j));
						if(p>=k){
							ans++;
						}
					}
				}
				for(int j=0;j<temparr.size();j++){
					sm.add(temparr.get(j));
				}
			}*/
			for(int i=6;i<=r;i++){
				int p=checkBinary(i);
				if(p>=k){
					ans++;
				}
			}
			System.out.println(ans);
		}
	}
}