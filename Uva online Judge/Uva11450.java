package Assignment1_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Uva11450 {
	  static int c,m;
	    static int [][] arr = new int[201][21];
	    static List<Integer> price[]=new ArrayList[20];

	public static void main(String[] args) throws NumberFormatException, IOException {
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        StringBuilder out = new StringBuilder();
	        int t = Integer.parseInt(br.readLine());
	        String [] sp;
	        int res;
	        for (int i = 0; i < t; i++) {
	            sp = br.readLine().split("\\s+");
	            m = Integer.parseInt(sp[0]);
	            c = Integer.parseInt(sp[1]);
	            
	            for (int j = 0; j < c; j++) {
	                sp = br.readLine().split("\\s+");
	  
	                price[j]=new ArrayList<Integer>(Integer.parseInt(sp[0]));
	                price[j].clear();
	                for (int k = 1; k < sp.length; k++) {
	                    price[j].add(Integer.parseInt(sp[k]));
	                }
	            }
	            for(int j=0;j<=m;j++){
	            	for(int k=0;k<=c;k++){
	            		arr[j][k]=-1;
	            	}
	            }
	            for(int j=0;j<=m;j++){
	            	arr[j][0]=0;
	            	for(int k=1;k<=c;k++){
	            		for(int l=0;l<price[k-1].size();l++){
	            			int ci=price[k-1].get(l);
	            			if(j>=ci && arr[j-ci][k-1]!=-1){
	            				arr[j][k]=(arr[j][k]<=arr[j-ci][k-1]+ci)?(arr[j-ci][k-1]+ci):arr[j][k];
	            			}
	            		}
	            	}
	            }
	            if(arr[m][c]==-1)
	            	System.out.println("no solution");
	            else
	            	System.out.println(arr[m][c]);

	}

}}
