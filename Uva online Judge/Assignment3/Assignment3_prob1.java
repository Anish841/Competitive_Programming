package Assignment3;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

class Segment implements Comparable<Segment>{
	int l,r;

	public int getL() {
		return l;
	}

	public void setL(int l) {
		this.l = l;
	}

	public int getR() {
		return r;
	}

	public void setR(int r) {
		this.r = r;
	}

	public int compareTo(Segment o) {
		int temp=(int)o.getR();
		return temp-this.r;
	}
	
	public static Comparator<Segment> SegmentNameComparator = new Comparator<Segment>() {
		public int compare(Segment s1,Segment s2) {
			return s2.r-s1.r;
		//to call this Arrays.sort(arrname,ClassName.comparatorName);
		
		}

	};
	
}

public class Assignment3_prob1 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.parseInt(bf.readLine());
		int s,M,inSize,outSize;
		for(int j=0;j<t;j++){
			Segment in[]=new Segment[100005];
			Segment out[]=new Segment[100005];
			inSize=0;outSize=0;s=0;
			bf.readLine();
			M=Integer.parseInt(bf.readLine());
			String line=bf.readLine();
			String arr[]=line.split(" ");
			do{
				String linet=bf.readLine();
				String arrt[]=linet.split(" ");
				if(arrt[0].equals("0") && arrt[1].equals("0")){
					break;
				}else{
					in[inSize]=new Segment();
					in[inSize].l=Integer.parseInt(arrt[0]);
					in[inSize].r=Integer.parseInt(arrt[1]);
				}
				inSize++;
			}while(true);																																																																																																																																																																																																							
			
			Arrays.sort(in, 0, inSize,Segment.SegmentNameComparator);
//			Arrays.sort(in,new Comparator<Segment>(){
//				public int compare(Segment s1,Segment s2){
//					return s2.r-s1.r;
//				}
//			});
			
			while (s<M) {
				int i;
			    for (i = 0; i < inSize; i ++) {
				if (in[i].l <= s && in[i].r > s) {
				    s = in[i].r; out[outSize++] = in[i];break;
				}
			    }																																									
			    if (i == inSize) break;
			}
			if (s<M) {
				System.out.println("0");
			}
			else {
			    System.out.println(outSize);
			    for (int i = 0; i < outSize; i ++)
				System.out.println(out[i].l+" "+ out[i].r);
			}
			if(t >=0) System.out.println();
		    }
			
		}
	}


