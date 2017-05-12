package Useful_stuff;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class EasyComparator {

    public static void main(final String[] args)throws Exception {
//        final int[][] data = new int[][] {
//                new int[] { 0,2},
//                new int[] { 0,3 },new int[]{1,4}};
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
    	String str=bf.readLine();
		int data[][]=new int[256][2];
		for(int i=0;i<256;i++){
			data[i][0]=i;
		}
		for(int i=0;i<str.length();i++){
			data[(int)str.charAt(i)][1]++;
		}
//        Arrays.sort(data, new Comparator<int[]>() {
//            public int compare(int[] entry1, int[] entry2) {
//                int time1 = entry1[1];
//                int time2 = entry2[1];
//                return time2-time1;
//            }
//        });
		Arrays.sort(data,new Comparator<int[]>(){
			public int compare(int[] a,int [] b){
				int t1=a[1];
				int t2=b[1];
				return t2-t1;
			}
		});

        for (final int[] s : data) {
        	if(s[1]==0)
        		break;
            System.out.println((char)s[0] + " " + s[1]);
        }
    }

}