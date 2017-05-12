package Assignment4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Queue;
class Graph{
	public enum NodeColor{unVisited,Visited,black,white;}
	int n;
	List<Integer> l[];		
	HashMap<Integer, Boolean> hm=new HashMap<Integer, Boolean>();
	Queue<Integer> que=new LinkedList<Integer>();
	int mindegV=Integer.MAX_VALUE;
	Graph(int n){
		this.n=n;
		l=new LinkedList[n];
	}
	public void intialize(){
		for(int i=0;i<n;i++){
			l[i]=new LinkedList<Integer>();
		}
	}
	public void addEdge(int u,int v){
			l[u].add(v);
			l[v].add(u);
	}
	public int findOptimialColor(){
		NodeColor stat[]=new NodeColor[n];int ans;
		//findfing min deg vertex
		int temp,nodei=0;
		for(int i=0;i<n;i++){
			stat[i]=NodeColor.unVisited;
			temp=l[i].size();
			if(mindegV>temp){
				mindegV=temp;nodei=i;
			}
		}
//		System.out.println("mindegV==>"+mindegV);
//		System.out.println("nodei==>"+nodei);
		que.add(nodei);ans=1;stat[nodei]=NodeColor.black;
		ListIterator<Integer> litr=null;NodeColor c;
		hm.put(nodei, true);
		while(!que.isEmpty()){
			int curr_v=que.remove();
			c=stat[curr_v];
			litr=l[curr_v].listIterator();
			while(litr.hasNext()){
				temp=litr.next();
				if(c==NodeColor.white && (stat[temp]==NodeColor.white || stat[temp]==NodeColor.black))continue;
				if(c==NodeColor.white){
					stat[temp]=NodeColor.black;ans++;
					hm.put(temp, true);
					que.add(temp);continue;
				}
				if(c==NodeColor.black && stat[temp]==NodeColor.white)continue;
				if(c==NodeColor.black && stat[temp]==NodeColor.black){
					stat[temp]=NodeColor.white;ans--;
					hm.remove(temp);
					que.add(temp);continue;
				}
				if(c==NodeColor.black){
					stat[temp]=NodeColor.white;que.add(temp);
				}
			}
		}
		return ans;
	}
}
public class Assignment2 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		int tc=Integer.parseInt(bf.readLine());
		for(int i=0;i<tc;i++){
			String str=bf.readLine();
			String str1[]=str.split("\\s+");
			int n,k;
			n=Integer.parseInt(str1[0]);
			k=Integer.parseInt(str1[1]);
			Graph g=new Graph(n);
			g.intialize();
			for(int j=0;j<k;j++){
				str=bf.readLine();
				str1=str.split("\\s+");
				g.addEdge(Integer.parseInt(str1[0])-1, Integer.parseInt(str1[1])-1);
			}
			System.out.println(g.findOptimialColor());
			HashMap<Integer, Boolean> hp=g.hm;
			Iterator it=hp.entrySet().iterator();
			boolean flag=true;
			while(it.hasNext()){
				Map.Entry<Integer,Boolean> pairs=(Map.Entry<Integer, Boolean>)it.next();
				if(flag){
					flag=false;System.out.print((pairs.getKey()+1));
				}else{
					System.out.print(" "+(pairs.getKey()+1));
				}
				it.remove();
			}
			System.out.println();
			
		}
	}

}
