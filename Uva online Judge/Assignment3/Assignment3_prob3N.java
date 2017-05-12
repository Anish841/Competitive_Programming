package Assignment3;

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
	Queue<Integer> q_id=new LinkedList<Integer>();
	Queue<Integer> q_len=new LinkedList<Integer>();
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
		if(u!=v){
			l[u].add(v);
		}
	}
	public int findMinimumSpeech(int k){
		int c_id=0,c_len=1,p_len;
		q_id.add(c_id);q_len.add(c_len);
		ListIterator<Integer> litr=null;
		//HashMap<String, Boolean> hm=new HashMap<String, Boolean>();
		String str="";int tempn;
		while(!q_id.isEmpty()){
			c_id=q_id.remove();
			c_len=q_len.remove();
			if(c_len>=k && c_id==n-1){
				break;
			}
			p_len=c_len+1;
			litr=l[c_id].listIterator();
			while(litr.hasNext()){
				tempn=litr.next();
				if(p_len<=20){
						q_id.add(tempn);
						q_len.add(p_len);
				}
			}
		}
		return c_len;
	}
}
public class Assignment3_prob3N {

	public static void main(String[] args) throws IOException {
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));	
		while(true){
			String line=bf.readLine();
			String line1[]=line.split("\\s+");
			int n=Integer.parseInt(line1[0]);
			int m=Integer.parseInt(line1[1]);
			int k=Integer.parseInt(line1[2]);
			if(n==0 && m==0 && k==0){
				break;
			}
			Graph g=new Graph(n);
			g.intialize();
			for(int i=0;i<m;i++){
				line=bf.readLine();
				String line2[]=line.split("\\s+");
				g.addEdge(Integer.parseInt(line2[0]), Integer.parseInt(line2[1]));
			}
			int ans=g.findMinimumSpeech(k);
			if(ans<k || ans>20){
				System.out.println("LOSER");
			}else{
				System.out.println(ans);
			}
		}
	}

}