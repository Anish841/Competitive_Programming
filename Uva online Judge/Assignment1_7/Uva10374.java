package Assignment1_7;

import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.HashMap;

public class Uva10374 {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);

		int tc = in.nextInt();

		boolean ind = false;
		for (int i = 0; i < tc; i++) {
			in.nextLine();
			if (ind)
				System.out.println();
			ind = true;
			{
				HashMap<String, String> canToParty = new HashMap<String, String>();
				HashMap<String, Integer> canToVotes = new HashMap<String, Integer>();
				int p = in.nextInt();
				in.nextLine();

				for (int i1 = 0; i1 < p; i1++) {
					String canToPartyt = in.nextLine();
					String part = in.nextLine();
					canToParty.put(canToPartyt, part);
				}

				int votes = in.nextInt();
				in.nextLine();
				for (int i1 = 0; i1 < votes; i1++) {
					String canToParty1 = in.nextLine();

					if (!canToVotes.containsKey(canToParty1))
						canToVotes.put(canToParty1, (Integer) 1);
					else {
						int tmp = 1 + canToVotes.get(canToParty1);
						canToVotes.put(canToParty1, tmp);
					}
				}
				boolean flag = false;
				String winner = null;
				int max = 0;
				Iterator<Entry<String, Integer>> it = canToVotes.entrySet()
						.iterator();
				while (it.hasNext()) {
					Entry<String, Integer> entry = it.next();
					String key = entry.getKey();
					Integer value = entry.getValue();
					if (max < value) {
						max = value;
						winner = key;
						flag = false;
					} else if (max == value) {
						flag = true;
					}
				}
				if (flag)
					System.out.println("tie");
				else
					System.out.println(canToParty.get(winner));
			}
		}
	}

}
