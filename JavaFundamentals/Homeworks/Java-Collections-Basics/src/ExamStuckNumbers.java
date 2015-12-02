
import java.util.Scanner;


public class ExamStuckNumbers {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n;
		n = Integer.parseInt(scan.nextLine());
		String[] z = scan.nextLine().split(" ");
		boolean bool = false;
		for (int i = 0; i < z.length; i++) {
			for (int j = 0; j < z.length; j++) {
				for (int k = 0; k < z.length; k++) {
					for (int l = 0; l < z.length; l++) {
						if (areDistinct(z[i], z[j], z[k], z[l])) {
							if((z[i] + z[j]).equals(z[k]+z[l])) {
								System.out.printf("%s|%s==%s|%s\n",z[i],z[j],z[k],z[l]);
								bool = true;
							}
						}
					}
				}
			}
		}
		if(bool == false) {
			System.out.println("No");
		}
	}

	public static boolean areDistinct(String i, String j, String k, String l) {
		if (!i.equals(j) && !i.equals(k) && !i.equals(l)) {
			if (!j.equals(k) && !j.equals(l)) {
				if (!k.equals(l)) {
					return true;
				} else
					return false;
			} else
				return false;
		} else
			return false;
	}

}
