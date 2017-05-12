package Assignment4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;
class GraphN{
	int n,ans=-1;
	List<Integer> l[];	
	BitSet colored;
	final boolean BLACK=true;
	final boolean WHITE=false;
	boolean color[];
	boolean alreadyColored[];
	List<Integer> li;
	@SuppressWarnings("unchecked")
	GraphN(int n){
		this.n=n;
		l=new LinkedList[n];
	}
	public void intialize(){
		for(int i=0;i<n;i++){
			l[i]=new LinkedList<Integer>();
		}
		li=new LinkedList<Integer>();
	color=new boolean[n];
	alreadyColored=new boolean[n];
	}
	public void addEdge(int u,int v){
			l[u].add(v);
			l[v].add(u);
	}
	public void findoptimal(int u){
		if(u==n){
			int b=0,w=0;
			for(int i=0;i<n;i++){
				if(color[i]==BLACK)b++;
				else w++;
			}
			if(b>ans){
				ans=b;
				li.clear();
				for(int i=0;i<n;i++){
					if(color[i]==BLACK){
						li.add(i);
					}
				}
			}
			return;
		}
		boolean blackFlag=true;
		for(int i=0;i<l[u].size();i++){
			int v=l[u].get(i);
			if(alreadyColored[v] && color[v]==BLACK){
				blackFlag=false;break;
			}
		}
		alreadyColored[u]=true;
		if(blackFlag){
			color[u]=BLACK;
			findoptimal(u+1);
		}
		color[u]=WHITE;
		findoptimal(u+1);
		alreadyColored[u]=false;
	}
}
public class Assignment2V2 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		InputReader in=new InputReader(System.in);
		int tc=in.nextInt();
		for(int i=0;i<tc;i++){
			int n,k;
			n=in.nextInt();
			k=in.nextInt();
			GraphN g=new GraphN(n);
			g.intialize();
			for(int j=0;j<k;j++){
				g.addEdge(in.nextInt()-1, in.nextInt()-1);
			}
			g.findoptimal(0);
			System.out.println(g.ans);
			boolean flag=true;
			ListIterator<Integer> litr=g.li.listIterator();
			while(litr.hasNext()){
				if(flag){
					flag=false;System.out.print((litr.next()+1));
				}else{
					System.out.print(" "+(litr.next()+1));
				}
			}
			System.out.println();
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

