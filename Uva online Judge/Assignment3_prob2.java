package Assignment3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;
class SubsetSum{
	int t,n,set[];
	HashMap<Stack, Boolean> hm=new HashMap<Stack, Boolean>();
	Stack<Integer> al=new Stack<Integer>();
	public void findSubset(int m,int p, int sum) {
		if(sum==t){
			if(hm.containsKey(al)) return;
			String ans="";
			for(int i=0;i<p;i++){
				ans=(i==0)? al.elementAt(i).toString():(ans+"+"+al.elementAt(i));
			}
			hm.put(al, true);
			System.out.println(ans);
			return;
		}
		if(sum>t || m==n){
			return;
		}
		for(int i=m;i<n;i++){
			al.push(set[i]);
			findSubset(i+1, p+1, sum+set[i]);
			al.pop();
		}
	}
}
class Assignment3_prob2 {
	public static void main(String[] args) throws IOException {
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		while(true){
			String input=bf.readLine();
			String in[]=input.split(" ");
			int t=Integer.parseInt(in[0]);
			int n=Integer.parseInt(in[1]);
			if(n==0 && t==0){
				break;
			}
			SubsetSum ss=new SubsetSum();
			ss.n=n;ss.t=t;
			ss.set=new int[n];
			for(int i=0;i<n;i++){
				ss.set[i]=Integer.parseInt(in[i+2]);
			}
			int sum=0,m=0,p=0;
			System.out.println("Sums of "+t+":");
			ss.findSubset(m,p, sum);
			HashMap<Stack,Boolean> h1=ss.hm;
			if(h1.isEmpty()){
				System.out.println("NONE");
			}
		}
		
	}	

}
