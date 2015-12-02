import java.io.StringBufferInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import sun.reflect.generics.tree.Tree;

public class LogsAggregator {
	
	static public class Person {
		public String name;
		public long duration;
		public ArrayList<String> ipSet;
		
		public Person () {
			
		}
		
		public Person (String aName, long aDuration, ArrayList<String> aipSet) {
			this.name = aName;
			this.duration = aDuration;
			this.ipSet = aipSet;
		}
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = Integer.parseInt(scan.nextLine());
		String[] input = new String[n];
		TreeSet<String> names = new TreeSet<>();
		TreeSet<String> ipSet = new TreeSet<>();
		int duration = 0;
		for (int i = 0; i < input.length; i++) {
			input[i] = scan.nextLine();
		}
		for(int i = 0; i<input.length; i++) {
			String[] line = input[i].split(" ");
			names.add(line[1]);
		}
		System.out.println();
		for(String s : names) {
			for(int i = 0; i<input.length; i++) {
				String[] line = input[i].split(" ");
				if(line[1].equals(s)) {
					duration += Integer.parseInt(line[2]);
					ipSet.add(line[0]);
				}
			}
			System.out.printf("%s: %d %s\n",s,duration,ipSet);
			duration = 0;
			ipSet.clear();
		}
		
	}
}
