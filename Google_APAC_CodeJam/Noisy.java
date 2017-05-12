import java.util.*;
import java.io.*;
public class Noisy{
	public static void find1(boolean arr[][],long R,long C,long N,long ui,long di,long li,long ri){
		arr[0][0]=true;arr[r-1][0]=true;arr[r-1][c-1]=true;arr[0][c-1]=true;
		int ri=0,ci=0;
		while(true){
			find1();
			ci=(0+r-1)/2;
		}
	}
	public static void main(String args[]) throws Exception{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.parseInt(bf.readLine());
		for(int y=1;y<=t;y++){
			StringTokenizer st=new StringTokenizer(bf.readLine());
			long R=Long.parseLong(st.nextToken());
			long C=Long.parseLong(st.nextToken());
			long N=Long.parseLong(st.nextToken());
			boolean arr[][]=new boolean[R][C];
			long ans=0;
			if(N==(R*C)){
					ans=(R-1)+(C-1)*(2*R)-(C-1);
				System.out.println("Case #"+y+": "+ans);
			}else if(N==1){
				System.out.println("Case #"+y+": "+ans);
			}else if(R>=3 && C>=3){
				if(N<=4){
					System.out.println("Case #"+y+": "+ans);
				}else{
					N=N-4;
					int nCtemp=Math.floor((C/2)-1);
					int nRtemp=Math.floor((R/2)-1);
					while(true){
						if(N==0)
							break;
						
					}
				}
			}
		}
	}
}