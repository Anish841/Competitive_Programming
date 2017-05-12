import java.io.*;
import java.math.*;
 
 class Main {
	static long [] maleBee = new long[1000];
 	static long [] femaleBee = new long[1000];
 	public static void preProcessBee(){
 		maleBee[0]=0;maleBee[1]=1;femaleBee[0]=1;
        for (int i=2;i<1000;i++){
           maleBee[i]=(maleBee[i-1]+maleBee[i-2])+1; 
        }
        for (int i=1;i<1000;i++){
            femaleBee[i]=maleBee[i-1]+1;
        }   
 	}
    public static void main (String [] args) throws  IOException
    {	preProcessBee();
    	BufferedReader bis = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            int input=Integer.parseInt(bis.readLine());
            if(input==-1)
                break;
            System.out.println(maleBee[input]+" "+(femaleBee[input]+maleBee[input]));
        }
    }
}