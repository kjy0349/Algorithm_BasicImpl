import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        int length = 1000;
        int[] a = new int [length];
        for (int i = 0; i < length; i++) a[i] = (int) (Math.random() * 500);
        System.out.println(Arrays.toString(a));
    }
}
