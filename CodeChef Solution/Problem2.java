import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem2 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		int tc=Integer.parseInt(bf.readLine());
		for(int i=0;i<tc;i++){
			int N=Integer.parseInt(bf.readLine());
			int a[]=new int[100001];
			String str=bf.readLine();
			String str1[]=str.split("\\s+");
			int max=0;
			for(int j=0;j<N;j++){
				a[Integer.parseInt(str1[j])]++;
				if(a[Integer.parseInt(str1[j])]>=max)
					max=a[Integer.parseInt(str1[j])];
			}
			System.out.println(N-max);
		}
	}

}
