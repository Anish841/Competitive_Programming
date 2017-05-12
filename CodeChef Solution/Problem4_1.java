import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
 
 
public class Problem4_1 {
	static long factArr[];
	public static void main(String[] args) throws IOException {
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		String str=bf.readLine();
		String st[]=str.split("\\s+");
		int n=Integer.parseInt(st[0]);
		int m=Integer.parseInt(st[1]);
		factArr=new long[10000001];
		factArr[0]=1;
		for(int i=1;i<=10000000;i++){
			factArr[i]=((i%m)*factArr[i-1])%m;
		}
		long p[]=new long[n+1];
		str=bf.readLine();
		st=str.split("\\s+");
		BigInteger sum=new BigInteger("0");
		BigInteger mbi=new BigInteger(""+m+"");
		for(int i=1;i<=n;i++){
			p[i]=Long.parseLong(st[i-1]);
			sum=sum.add(fact(p[i],mbi)).mod(mbi);
		//	sum=(sum+fact(p[i],m))%m;
		}
		System.out.println(sum.mod(mbi));
	}
	public static BigInteger fact(long x,BigInteger m){
//		long sum=0;
//    		for(int i=1;i<=x;i++){
//    			if(i>=m){
//    				sum=(sum+((i%m)*(x%m))%m)%m;
//    			}else
//    			sum=(sum+((i%m)*(factArr[i]+x)%m)%m)%m;
//    		}
		long temp;
		if(x>10000000)
			temp=-1;
		else 
			temp=factArr[(int)x+1]-1;
		
		BigInteger fb=new BigInteger(""+temp+"");
		BigInteger b=new BigInteger(""+x+"");
		BigInteger b1=b.multiply(b);
		BigInteger b2=b1.multiply(b);
		b=b1.add(b2);
		b1=b.divide(new BigInteger("2"));
		return fb.add(b1).mod(m);
	}
} 