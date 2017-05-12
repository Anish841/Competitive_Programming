import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem3 {

	public static void main(String[] args) throws NumberFormatException,
			IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(bf.readLine());
		for (int i = 0; i < tc; i++) {
			String str = bf.readLine();
			String str1[] = str.split("\\s+");
			long n = Long.parseLong(str1[0]);
			long s = Long.parseLong(str1[1]);
			if (n == s) {
				System.out.println(n - 1);
				continue;
			}
			long temp1 = (n * (n + 1)) / 2;
			if (temp1 == s) {
				System.out.println(0);
				continue;
			}
//			long sum[] = new long[100001];
//			for (int j = 1; j <=100000; j++) {
//				sum[j] = (j * (j + 1)) / 2;
//			}
				double temp = (Math.sqrt((1 + (8 * s))) - 1) / 2;
				//int tempn = (int) Math.ceil(temp - 1);
				long tempn=(long)Math.floor(temp);
				long exsum;
				while (true) {
					exsum = (tempn*(tempn+1))/2;
					if ((s - exsum) >= (n - tempn)) {
						break;
					} else
						tempn--;
				}
				System.out.println(n - tempn);
			}
		}

}
