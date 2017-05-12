import java.io.*;
import java.math.*;
class Main
{
	public static long fibNo[]=new long[51];
	public static void PreProcessFib(){
		fibNo[0]=1;
		fibNo[1]=1;
    	for(int i=2;i<=50;i++){
    		fibNo[i]=fibNo[i-1]+fibNo[i-2];
    		} 
	}
	public static void main(String args[]) throws IOException{
		BufferedReader bis= new BufferedReader(new InputStreamReader(System.in));
		PreProcessFib();
		int input=0;
		while(true){
			input=Integer.parseInt(bis.readLine());
			if(input==0){
				break;
			}
			System.out.println(fibNo[input]);	
		}
	}
}