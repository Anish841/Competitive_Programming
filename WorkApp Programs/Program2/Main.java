/**
 * Main.java --- program to find and print shortest distance from one city to closest festive city
 * @author    Anish Ratnawat
 */
import java.util.*;
import java.io.*;

@SuppressWarnings("unchecked")
/*
*  Create an undirected adjacency list graph 
*/
class Graph{																				
	int v;
	LinkedList<Integer> adjList[];
	int distances[];
	Graph(int v){
		this.v=v;
		distances=new int[v];
		adjList=new LinkedList[v];
		for(int i=0;i<v;i++){
			adjList[i]=new LinkedList<Integer>();
		}
		for(int i=0;i<v;i++){
			distances[i]=-1;
		}
	}

	//This Method add a bidirectional edge between two nodes
	public void addEdge(int u,int v){										
		adjList[u].add(v);
		adjList[v].add(u);
	}

	//This method update distance array which contains shortest distance from one node to closest festive node.
	public void conveyFestiveInformation(int curr,int parent){
		Iterator itr=adjList[curr].listIterator();
		while(itr.hasNext()){
			int next=(int)itr.next();
			if(next==parent)
				continue;
			if(distances[next]==-1 || distances[next]>distances[curr]+1){
				distances[next]=distances[curr]+1;
				conveyFestiveInformation(next,curr);
			}
		}
	}
}

public class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		String firstLine=bf.readLine();
		String tempArr[]=firstLine.split("\\s+");
		String temp="";
		int n=Integer.parseInt(tempArr[0]);
		int m=Integer.parseInt(tempArr[1]);
		Graph undirGraph=new Graph(n);
		for(int i=1;i<n;i++){
			temp=bf.readLine();
			tempArr=temp.split("\\s+");
			undirGraph.addEdge(Integer.parseInt(tempArr[0])-1,Integer.parseInt(tempArr[1])-1);
		}
		undirGraph.distances[0]=0;
		undirGraph.conveyFestiveInformation(0,-1);
		for(int i=0;i<m;i++){
			temp=bf.readLine();
			tempArr=temp.split("\\s+");
			int qType=Integer.parseInt(tempArr[0]);
			int qNode=Integer.parseInt(tempArr[1]);
			if(qType==1){													// If query Type is 1 , then update distance array 
				undirGraph.distances[qNode-1]=0;
				undirGraph.conveyFestiveInformation(qNode-1,-1);
			}else if(qType==2){												// If query Type is 2 , then print correponding shortest node distance in distance array.
				System.out.println(undirGraph.distances[qNode-1]);
			}
		}
	}
}