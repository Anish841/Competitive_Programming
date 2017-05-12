import java.util.*;
import java.io.*;
public class M2{
	
	public static void main(String args[])throws Exception{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		int tc=Integer.parseInt(bf.readLine());
		while(tc-->0){
			String str=bf.readLine();
			char sd[]=str.toCharArray();
			int hash[][]=new int[26][2];
			int max=Integer.MIN_VALUE,total=str.length();
			for(int i=0;i<str.length();i++){
				hash[sd[i]-97][0]++;
				hash[sd[i]-97][1]=sd[i]-97;
				if(hash[sd[i]-97][0]>max)
					max=hash[sd[i]-97][0];
			}
			if(max>(total-max)+1){
				System.out.println("-1");
				continue;
			}
			Arrays.sort(hash,new Comparator<int[]>(){
				public int compare(final int[] a1,final int[] a2){
					int e1=a1[0];
					int e2=a2[0];
					return e2-e1;
				}
			});
			int ans[]=new int[str.length()];
			int acount=0;boolean t1=false;
			for(int i=0;i<26;i++){
				while(hash[i][0]>0){
					boolean flag=false;
					for(int j=i+1;j<26;j++){
						if(hash[j][0]>0){
							ans[acount++]=hash[i][1];
							hash[i][0]--;
							ans[acount++]=hash[j][1];
							hash[j][0]--;
							flag=true;
						}	
						if(hash[i][0]<=0){
							break;
						}
					}
					if(!flag){
						while(hash[i][0]>0){
							ans[acount++]=hash[i][1];
							hash[i][0]--;
						}
						break;
					}
				}				
			}
			int index=0;
			for(int i=0;i<str.length()-1;i++){
				if(ans[i]==ans[i+1]){
					index=findIndex(ans,i+1);
					int temp=ans[i+1];
					ans[i+1]=ans[index];
					ans[index]=temp;
					index=index+2;
				}
			}
			for(int i=0;i<str.length();i++){
				System.out.print((char)(ans[i]+97));
			}System.out.println();
		}
	}
	
	
}