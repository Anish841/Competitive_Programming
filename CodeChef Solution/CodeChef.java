package Directi;
import java.util.*;
import java.io.*;
public class CodeChef{
	public static int checkUnique(char A[],char B[],int N){
		HashMap<Character,Integer> hm=new HashMap<Character,Integer>();
		//System.out.println(new String(A)+" "+new String(B));
		int auniCount=0;
		for(int i=0;i<N;i++){
			hm.put(A[i], 1);
		}
		int bunicount=0;
		HashMap<Character,Integer> hmb=new HashMap<Character,Integer>();

		for(int i=0;i<N;i++){
			hmb.put(B[i], 1);
		}
		auniCount=hm.size();
		bunicount=hmb.size();
		
		return Math.max(auniCount, bunicount);

	}

	public static int check(char A[],char B[],int N){
		int powerSetSize=(int) Math.pow(2,N);
		int ans=Integer.MAX_VALUE;
		for(int counter=0;counter<powerSetSize;counter++){
			for(int j=0;j<N;j++){
				if((counter & (1<<j))>=1){
					char temp=A[j];
					A[j]=B[j];
					B[j]=temp;
				}
			}
			int result=checkUnique(A,B,N);
			for(int j=0;j<N;j++){
				if((counter & (1<<j))>=1){
					char temp=A[j];
					A[j]=B[j];
					B[j]=temp;
				}
			}
			ans=Math.min(ans, result);
		}
		return ans;
	}
	public static void main(String args[]) throws Exception{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.parseInt(bf.readLine());
		while(t-->0){
			int N=Integer.parseInt(bf.readLine());
			char A[]=new char[N];
			char B[]=new char[N];
			String str=bf.readLine();
			for(int i=0;i<N;i++){
				A[i]=str.charAt(i);
			}
			str=bf.readLine();
			for(int i=0;i<N;i++){
				B[i]=str.charAt(i);
			}
			int ans=check(A,B,N);
			System.out.println(ans);
		}
	}

}