import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
class Graph{
	HashMap<String,LinkedList<String>> hm;
	HashMap<String,Integer> color;
	Graph(){
		hm=new HashMap<String,LinkedList<String>>();
		color=new HashMap<String,Integer>();
	}
	public void addEdge(String s1,String s2){
		LinkedList<String> li=(!hm.containsKey(s1))?(new LinkedList<String>()):hm.get(s1);
		li.add(s2);
		hm.put(s1, li);
		
		LinkedList<String> gi=(!hm.containsKey(s2))?(new LinkedList<String>()):hm.get(s2);
		gi.add(s1);
		hm.put(s2, gi);
	}
	public boolean checkSplit(String src){
		color.put(src, 1);
		Queue<String> q=new LinkedList<String>();
		q.add(src);
		while(!q.isEmpty()){
			String s=q.remove();
			LinkedList<String> li=hm.get(s);
			ListIterator<String> lh=li.listIterator();
			while(lh.hasNext()){
				String v=lh.next();
				if(color.get(v)==-1){
					color.put(v, 1-color.get(s));
					q.add(v);
				}else if(color.get(s)==color.get(v)){
					return false;
				}
						
			}
		}
		return true;
	}
}
public class Practice1 {

	public static void main(String[] args) throws Exception{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		int tc=Integer.parseInt(bf.readLine());
		int p=1;
		while(tc-->0){
			int M=Integer.parseInt(bf.readLine());
			Graph g=new Graph();
			for(int i=0;i<M;i++){
				String str=bf.readLine();
				String s[]=str.split("\\s+");
				g.addEdge(s[0], s[1]);
			}
			boolean flag=true;
			for(String key:g.hm.keySet()){
				g.color.put(key, -1);
			}
			for(String key:g.hm.keySet()){
				if(g.color.get(key)==-1){
					if(!g.checkSplit(key)){
						flag=false;break;
					}
				}
			}
			String ans;
			if(flag)
				ans="Yes";
			else
				ans="No";
			
			System.out.println("Case #"+p+": "+ans);	p++;
//			for(Map.Entry<String, LinkedList<String>> me:g.hm.entrySet()){
//				System.out.println(me.getKey()+" "+me.getValue());
//			}
		}
	}

}
