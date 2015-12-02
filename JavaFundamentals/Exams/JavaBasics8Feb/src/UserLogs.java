import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;

public class UserLogs {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String input = scan.nextLine();
		TreeMap<String, LinkedHashMap<String, Integer>> map = new TreeMap<>();
		int count  = 0;
		while(!input.equals("end")) {
			
			String[] line = input.split(" ");
			String user = line[2];
			user = new String(user.replace("user=", ""));
			String ip = line[0];
			ip = new String(ip.replace("IP=", ""));
			String msg = line[1];
			msg = new String(msg.replace("message='", ""));
			if(map.containsKey(user)) {
				LinkedHashMap<String, Integer> lhm1 = map.get(user);
				if(lhm1.containsKey(ip)) {
					count = lhm1.get(ip) + 1;
					lhm1.put(ip, count);
				} else {
					lhm1.put(ip, 1);
				}
				map.put(user, lhm1);
				
			} else {
				LinkedHashMap<String, Integer> lhm2 = new LinkedHashMap<>();
				lhm2.put(ip, 1);
				map.put(user, lhm2);
			}
			
			input = scan.nextLine();
		}
		 
		List<Entry<String, Integer>> list = new ArrayList<>();
		
		for(Entry<String, LinkedHashMap<String, Integer>> entry1 : map.entrySet()) {
			LinkedHashMap<String, Integer> lhm3 = entry1.getValue();
			System.out.println(entry1.getKey()+":");
			for(Entry<String, Integer> entry2 : lhm3.entrySet()) {
				list.add(entry2);
				//System.out.printf("%s => %d.\n",entry2.getKey(),entry2.getValue());
			}
			for(int i = 0; i<list.size(); i++) {
				if(i != list.size() -1) {
					System.out.printf("%s => %d,\n",list.get(i).getKey(), list.get(i).getValue());
				} else {
					System.out.printf("%s => %d.\n",list.get(i).getKey(), list.get(i).getValue());
				}
			}
			list = new ArrayList<>();
		}

	}

}
