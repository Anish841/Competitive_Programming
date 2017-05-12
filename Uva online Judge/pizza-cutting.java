import java.io.*;
import java.util.*;
class Main {
	public static void main(String[] args)  throws IOException{
		Scanner sc = new Scanner(System.in);
		long input=0;
		while(true){
			input = sc.nextLong();
			if(input<0){
				break;
			}
			Long ans = (long)(input*(input+1)/2)+1;
			System.out.println(ans);	
		}
	}

}