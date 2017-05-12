import java.util.*;
import java.io.*;
public class problem1{

	public static void main(String args[]) throws Exception{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.parseInt(bf.readLine());
		while(t-->0){
			int N=Integer.parseInt(bf.readLine());
			String txt=bf.readLine();
			String ans=null,temp="";
			for(int i=0;i<N;i++){
				for(int j=i+1;j<N;j++){
					if(txt.charAt(i)>txt.charAt(j)){
						temp="";
						temp=(0!=i)?txt.substring(0,i):String.valueOf(txt.charAt(i));
						temp+=((i+1)!=j)?txt.substring(i+1,j+1):String.valueOf(txt.charAt(j));
						temp+=String.valueOf(txt.charAt(i));
						temp+=((j+1)!=N)?txt.substring(j+1,N):"";
						if(ans==null)
							ans=temp;
						System.out.println(i+" "+j+" "+temp);
						if(temp.compareTo(ans)<0){
							ans=temp;
						}
					}
				}
			}
			System.out.println(ans);
		}

	}

}