import java.io.*;
import java.math.*;
 
 class Main {
 	static BigInteger [] temp1 = new BigInteger[801];
 	public static void preProcessFib(){
 		temp1[0]=BigInteger.ONE;
        temp1[1]=BigInteger.ZERO;
        for (int i=2;i<801;i++){
        	BigInteger temp = new BigInteger((i-1)+"");
            temp1[i]=(temp1[i-1].add(temp1[i-2])).multiply(temp);
        } 
 	}
    public static void main (String [] args) throws  IOException{
		preProcessFib();
    	BufferedReader bis = new BufferedReader(new InputStreamReader(System.in));
		int input=0;
        while(true){
			input=Integer.parseInt(bis.readLine());
            if(input==-1)
                break;
            System.out.println(temp1[input]);
        }
    }
}