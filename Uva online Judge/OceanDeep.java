import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class OceanDeep {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String sb = new String();
        String m = "";
        while (true) {
			m=br.readLine();
			if(m==null)
				break;
            while (!m.endsWith("#")) {
                    m += br.readLine();
            }
            int mod=0;
            for (int i = 0; i < m.length()-1; i++) {
                    Character temp = m.charAt(i);
                    mod = (mod*2 + Integer.parseInt(temp.toString())) % 131071;
            }
            
            if (mod==0) {
				sb=sb+"YES\n";
                //sb.append("YES").append("\n");
            } else {
				sb=sb+"NO\n";
               // sb.append("NO").append("\n");
            } 
        }
        System.out.print(sb);
    }
}