import com.sun.org.apache.bcel.internal.classfile.ClassFormatException;

import java.lang.reflect.Method;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * Created by iwano on 6/23/2016.
 */
public class PizzaTime {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Map<Integer, ArrayList<String>> map = Pizza.procceed(scan.nextLine().split("\\s+"));
        for (Map.Entry<Integer, ArrayList<String>> entry : map.entrySet()) {
            System.out.printf("%d - %s\n", entry.getKey(), String.join(", ",entry.getValue()));
        }

        Class<?> pizzaClass = Pizza.class;
        Method[] methods = pizzaClass.getDeclaredMethods();
        List<Method> checkedMethods = Arrays.stream(methods)
                .filter(m -> m.getReturnType().getName().contains("Map"))
                .collect(Collectors.toList());

        if (checkedMethods.size() < 1) {
            throw new ClassFormatException();
        }

    }
}

class Pizza {
    private int group;
    private String name;

    public Pizza(int group, String name) {
        this.group = group;
        this.name = name;
    }

    public int getGroup() {
        return group;
    }

    public String getName() {
        return name;
    }

    public static TreeMap<Integer, ArrayList<String>> procceed(String[] args) {
        Pattern pat = Pattern.compile("(\\d+)(\\w+)");
        TreeMap<Integer, ArrayList<String>> map = new TreeMap<>();

        for(String s : args) {
            Matcher match = pat.matcher(s);
            match.find();
            int group = Integer.parseInt(match.group(1));
            String name = match.group(2);
            if (!map.containsKey(group)) {
                map.put(group, new ArrayList<>());
            }
            map.get(group).add(name);
        }

        return map;
    }
}