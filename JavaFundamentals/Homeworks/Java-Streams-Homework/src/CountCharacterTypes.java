import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class CountCharacterTypes {

	public static void main(String[] args) {
		String line;
		char[] vowArr = new char[]{'a','e','i','o','u'};
		char[] punctArr = new char[]{'.',',','!','?'};
		char[] consArr = new char[]{'b','c','d','f','g','h','j','k','l','m','n','p','q','r','s','t','v','w','x','y','z'};
		int vowels = 0, cons = 0, punct = 0;
		try (BufferedReader br = new BufferedReader(new FileReader("res/Words.txt"))) {
			while ((line = br.readLine()) != null) {
				for (int i = 0; i < line.length(); i++) {
					for(char c : vowArr) {
						if(Character.toLowerCase(line.charAt(i)) == c)
						{
							vowels++;
							break;
						}
					}
					for (char c : punctArr) {
						if(Character.toLowerCase(line.charAt(i)) == c) {
							punct++;
							break;
						}
					}
					for(char c : consArr) {
						if(Character.toLowerCase(line.charAt(i)) == c) {
							cons++;
							break;
						}
					}
				}
			}
		} catch (IOException io) {
			System.out.println("IO Error");
		}
		
		try (PrintWriter pw = new PrintWriter(new FileWriter("res/Count-chars.txt"))) {
			pw.write("Vowels: " + vowels + "\n");
			pw.write("Consonants: " + cons + "\n");
			pw.write("Punctuation: " + punct + "\n");

		} catch (IOException e) {
			System.out.println("File error 2");
		}
	}

}
