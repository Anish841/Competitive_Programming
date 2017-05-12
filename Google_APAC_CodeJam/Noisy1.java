import java.util.*;
import java.io.*;
public class Noisy1{
	
	public static void main(String args[]) throws Exception{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.parseInt(bf.readLine());
		for(int y=1;y<=t;y++){
			StringTokenizer st=new StringTokenizer(bf.readLine());
			long R=Long.parseLong(st.nextToken());
			long C=Long.parseLong(st.nextToken());
			long N=Long.parseLong(st.nextToken());
			long ans=0;
			if(N==(R*C)){
					ans=(R-1)+(C-1)*(2*R)-(C-1);
				System.out.println("Case #"+y+": "+ans);
			}else{
				long tempC=(long)(Math.ceil((double)C/2));
				long tempR=(long)Math.ceil((double)R/2);
				long temp=tempC*tempR;
				if(N<=temp){
					System.out.println("Case #"+y+": "+ans);
				}else{
					N=N-temp;
					long temp1=(C-tempC);
					if(N<=temp1){
						ans=ans+2*(N);
						N=N-(temp1);
					}else if(N<=(2*temp1)){
						ans=ans+(C-1);
						N=N-temp1;
						ans=ans+2*(N);
						N=N-(temp1);
					}else{
						ans=ans+2*(C-1);
						N=N-2*(temp1);
					}
					if(N>0){
						long temp2=(R-tempR);
						if(N<=temp2){
							ans=ans+2*(N);
							N=N-(temp2);
						}else if(N<=(2*temp2)){
							ans=ans+4*(N);
							N=N-2*(temp2);	
						}else{
							ans=ans+2*(R-1);
							N=N-2*(temp2);
						}
					}
					System.out.println("Case #"+y+": "+ans);
				}
			}
		}
	}
}