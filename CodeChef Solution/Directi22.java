package Directi2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Queue;
import java.util.StringTokenizer;

class Graph{
	List<Integer> l[];
	long values[];
	int n;
	Graph(int n){
		this.n=n;
		l=new LinkedList[n+1];
		values=new long[n+1];
		for(int i=1;i<=n;i++){
			l[i]=new LinkedList<Integer>();
		}
	}
	public void addEdge(int u,int v,long value){
		l[u].add(v);
		values[v]=value;
	}
	
	public long BFS(int A){
		boolean visited[]=new boolean[n+1];
	    for(int i = 1; i <= n; i++)
	        visited[i] = false;
	 
	    Queue<Integer> queue=new LinkedList<Integer>();
	 
	    visited[A] = true;
	    queue.add(A);
	 
	    int s;
	    long sum=values[A];
	    while(!queue.isEmpty())
	    {
	        s = queue.remove();
	        ListIterator<Integer> litr=l[s].listIterator();
	        while(litr.hasNext()){
	        	s=litr.next();
	        	if(!visited[s]){
	        		visited[s]=true;
	        		sum+=values[s];
	        		queue.add(s);
	        	}
	        }
	     }
	    return sum;
	}
	
}

public class Directi22 {

	public static void main(String[] args) {
		InputReader in=new InputReader(System.in);
		int t=in.nextInt();
		for(int i=0;i<t;i++){
			int N=in.nextInt();
			int M=in.nextInt();
			int Q=in.nextInt();
			int parent[]=new int[N+1];
			Graph g=new Graph(N);
			parent[1]=in.nextInt();
			for(int j=2;j<=N;j++){
				parent[j]=in.nextInt();
				g.addEdge(parent[j], j, 0);
			}
			for(int j=1;j<=M;j++){
				String str=in.next();
				if("ADD".equalsIgnoreCase(str)){
					int X=in.nextInt();
					int Y=in.nextInt();
					g.values[X]+=Y;
					
				}else if("ADDUP".equalsIgnoreCase(str)){
					int X=in.nextInt();
					int Y=in.nextInt();
					g.values[X]+=Y;
					int temp=X;
					while(parent[temp]!=0){
						g.values[parent[temp]]+=Y;
						temp=parent[temp];
					}
				}
			}
			long ans;
			for(int j=1;j<=Q;j++){
				String str=in.next();
				if("VAL".equalsIgnoreCase(str)){
					int node=in.nextInt();
					ans=g.values[node];
					System.out.println((ans%1000000007));
				}else if("VALTREE".equalsIgnoreCase(str)){
					int node=in.nextInt();
					
					ans=g.BFS(node);
					System.out.println((ans%1000000007));
				}
			}
			
		}
	}

}


class InputReader {
    private BufferedReader reader;
    private StringTokenizer tokenizer;

    public InputReader(InputStream stream) {
        reader = new BufferedReader(new InputStreamReader(stream));
        tokenizer = null;
    }

    public String next() {
        while (tokenizer == null || !tokenizer.hasMoreTokens()) {
            try {
                tokenizer = new StringTokenizer(reader.readLine());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return tokenizer.nextToken();
    }

    public int nextInt() {
        return Integer.parseInt(next());
    }
}


