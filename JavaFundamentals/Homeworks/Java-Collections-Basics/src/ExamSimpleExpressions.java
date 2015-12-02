
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class ExamSimpleExpressions {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String input = scan.nextLine();
		Pattern pat = Pattern.compile("(\\d*[.])?\\d+|[+|-]");
		Matcher match = pat.matcher(input);
		BigDecimal res = new BigDecimal(0);
		BigDecimal d = new BigDecimal(0);
		String sign = "v";
		List<String> list = new ArrayList<>();
		while (match.find()) {
			list.add(match.group());
		}
		res = res.add(new BigDecimal(list.get(0)));
		for (int i = 1; i < list.size(); i++) {
			String s = list.get(i);
			if (!s.equals(new String("+")) && !s.equals(new String("-"))) {
				d = new BigDecimal(Double.parseDouble(s));
				if (sign.equals(new String("-"))) {
					res = res.subtract(d);
				} else if (sign.equals(new String("+"))) {
					res = res.add(d);
				} else {
					continue;
				}
			} else if (s.equals(new String("+"))) {
				sign = s;
				continue;
			} else if (s.equals(new String("-"))) {
				sign = s;
				continue;
			}
		}
		System.out.printf("%.7f",res);
	}
}
