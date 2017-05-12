package MidSem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Queue;

class Graph{
	int n;
	List<Integer> l[];
	int bal[];
	Graph(int n){
		this.n=n;
		l=new LinkedList[n];
		bal=new int[n];
	}
	public void intialize(){
		for(int i=0;i<n;i++){
			l[i]=new LinkedList<Integer>();
		}
	}
	public void addEdge(int u,int v){
			l[u].add(v);
	}
	public int calculateBalance(int v){
		//System.out.println("leave==>"+v);
		if(l[v].size()==0){
			bal[v]=0;
			return 0;
		}
		
	    for(int i = 0; i<l[v].size(); ++i){
	    	int	tempbal=calculateBalance(l[v].get(i))+1;
	       bal[v]=(tempbal>bal[v])?tempbal:bal[v];
	    }
	    return 0;
	}
	
}
public class Program2 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.parseInt(bf.readLine());
		for(int i=0;i<t;i++){
			int n=Integer.parseInt(bf.readLine());
			Graph g=new Graph(n);
			g.intialize();
			String str;
			String st[];
			for(int j=0;j<n-1;j++){
				str=bf.readLine();
				st=str.split("\\s+");
				g.addEdge(Integer.parseInt(st[0])-1, Integer.parseInt(st[1])-1);
			}
		//	System.out.println("111");
			for(int j=0;j<n;j++){
				g.calculateBalance(j);
			}
			//System.out.println("11122221");
			int minbal=0;
			int node=0;
			for(int j=0;j<n;j++){
				if(g.bal[j]<minbal){
					minbal=g.bal[j];
					node++;
				}
			}
			for(int j=0;j<n;j++){
				System.out.println("Case "+(j+1)+": ");
				System.out.println(minbal+" "+node);
				//System.out.println(n-(g.bal[j]+1));	
			}
			
			
		}
		

	}

}
