import java.util.Arrays;

public class Number implements Comparable {
    public static int GetSumm(int[] numb){
        return Arrays.stream(numb).sum();
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
