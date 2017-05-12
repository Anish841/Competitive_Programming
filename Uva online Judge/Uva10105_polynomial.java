import java.io.*;
import java.math.*;
 
 class Main {
 
 	public static long calfactorial(long n){
       long ans = 1;
       for (int i = 1; i <= n; i++) {
           ans = ans * i;
       }
       return ans;	
 	} 
    public static void main (String [] args) throws  IOException
    {	
    	BufferedReader bis = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            String input=bis.readLine();
            if(input==null){
            	break;
            }
            long ans=1;
            String temp[]=input.split("\\s+");
            int n  = Integer.parseInt(temp[0]);
            int k = Integer.parseInt(temp[1]);
            int ansArr[]=new int[k];
            input = bis.readLine();
            temp=input.split("\\s+");
            for(int i=0;i<k;i++){
            	ansArr[i]=Integer.parseInt(temp[i]);
            }
            for(int i=0;i<k;i++){
            	ans = ans*calfactorial(ansArr[i]); 
            }
            ans = calfactorial(n)/ans;
            System.out.println(ans);
        }
    }
}