import java.util.*;
import java.io.*;
public class UnixFile{
	public static void main(String args[]) throws Exception{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.parseInt(bf.readLine());
		for(int p=1;p<=t;p++){
			StringTokenizer st=new StringTokenizer(bf.readLine());
			int n=Integer.parseInt(st.nextToken());
			int m=Integer.parseInt(st.nextToken());
			HashMap<String,String> dic=new HashMap<String,String>();
			for(int i=0;i<n;i++){
				String str=bf.readLine();
				String s[]=str.split("/");
				String temp="/";
				for(int j=1;j<s.length;j++){
					temp=temp+s[j];
					dic.put(temp,"");	
					temp=temp+"/";
				}
			}
			long ans=0;
			for(int i=0;i<m;i++){
				String str=bf.readLine();
				String s[]=str.split("/");
				
				String temp="/";
				int j=1;
				temp=temp+s[j];
				while(dic.containsKey(temp) && j<s.length){
					j++;
					if(j<s.length){
						temp=temp+"/";temp=temp+s[j];
					}
				}
				while(j<s.length){
					//System.out.println(j+" "+temp);
					dic.put(temp,"");j++;ans++;
					if(j>=s.length)
						break;
					temp=temp+"/"+s[j];
				}				
			}
			System.out.println("Case #"+p+": "+ans);
		}
	}
}