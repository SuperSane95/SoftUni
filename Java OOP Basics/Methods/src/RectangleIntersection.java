import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by iwano on 6/23/2016.
 */
public class RectangleIntersection {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] nm = scan.nextLine().split("\\s+");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);

        HashMap<String, Rectangle> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String data[] = scan.nextLine().split("\\s+");
            Rectangle rec = new Rectangle(
                    data[0], Integer.parseInt(data[1]),
                    Integer.parseInt(data[2]),
                    Integer.parseInt(data[3]),
                    Integer.parseInt(data[4])
            );
            map.put(data[0], rec);
        }

        for (int i = 0; i < m; i++) {
            String data[] = scan.nextLine().split("\\s+");
            Rectangle r1 = map.get(data[0]);
            Rectangle r2 = map.get(data[1]);
            if (r1.overlaps(r2)) {
                System.out.println(true);
            } else {
                System.out.println(false);
            }
        }
    }
}

class Rectangle {
    private String name;
    private int width;
    private int height;
    private int x;
    private int y;

    public Rectangle(String name, int width, int height, int x, int y) {
        this.name = name;
        this.width = width;
        this.height = height;
        this.x = x;
        this.y = y;
    }

    public boolean overlaps (Rectangle r) {
//        return x < r.x + r.width && x + width > r.x && y < r.y + r.height && y + height > r.y;
        if(this.x + this.width < r.x || r.x + r.width < this.x || this.y + this.height < r.y || r.y + r.height < this.y) {
            return false;
        } else {
            return true;
        }
    }
}
