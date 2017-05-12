package ModuleTest1;

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
	int wages[],n;
	Graph(int n){
		this.n=n;
		l=new LinkedList[n+1];
		wages=new int[n+1];
		for(int i=1;i<=n;i++){
			l[i]=new LinkedList<Integer>();
		}
	}
	public void addEdge(int u,int v,int wage){
		l[u].add(v);
		wages[v]=wage;
	}
	public void addAllEdge(int u,int v){
		l[u].add(v);
	}
	public void BFS(int A,int X){
		boolean visited[]=new boolean[n+1];
	    for(int i = 1; i <= n; i++)
	        visited[i] = false;
	 
	    Queue<Integer> queue=new LinkedList<Integer>();
	 
	    visited[A] = true;
	    queue.add(A);
	 
	    int s;
	    while(!queue.isEmpty())
	    {
	        s = queue.remove();
	        ListIterator<Integer> litr=l[s].listIterator();
	        while(litr.hasNext()){
	        	s=litr.next();
	        	if(!visited[s]){
	        		visited[s]=true;
	        		wages[s]+=X;
	        		queue.add(s);
	        	}
	        	
	        }
	     }
	}
	
}
public class SPOJ_Place {

	public static void main(String[] args) {
		InputReader in=new InputReader(System.in);
		int n=in.nextInt();
		int m=in.nextInt();
		int i,tempWage,tempNode;
		Graph g=new Graph(n);
		for(i=1;i<=n;i++){
			if(i==1){
				tempWage=in.nextInt();
				g.wages[1]=tempWage;
			}else{
				tempWage=in.nextInt();
				tempNode=in.nextInt();
				g.addEdge(tempNode,i,tempWage);
			}
		}
		for(i=2;i<=n;i++){
			g.addAllEdge(1, i);
		}
		int A,X;
		for(i=0;i<m;i++){
			String str=in.next();
			if("p".equalsIgnoreCase(str)){
				A=in.nextInt();
				X=in.nextInt();
				g.BFS(A,X);
			}else{
				A=in.nextInt();
				System.out.println(g.wages[A]);
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

