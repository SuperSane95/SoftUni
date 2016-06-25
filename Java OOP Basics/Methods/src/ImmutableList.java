
import com.sun.org.apache.bcel.internal.classfile.ClassFormatException;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by iwano on 6/23/2016.
 */
public class ImmutableList {
    private ArrayList<Integer> list = new ArrayList<>();

    public ImmutableList immutableList() {
        ArrayList<Integer> newList = new ArrayList<>();
        newList.addAll(list);
        return new ImmutableList(newList);
    }

    public ImmutableList(ArrayList<Integer> list) {
        this.list = list;
    }



    public static void main(String[] args) {
        Class listClass = ImmutableList.class;
        Field[] fields = listClass.getDeclaredFields();
        if (fields.length < 1) {
            throw new ClassFormatException();
        }

        Method method = listClass.getDeclaredMethods()[1];
        System.out.println(method.getReturnType().getSimpleName());


    }
}
