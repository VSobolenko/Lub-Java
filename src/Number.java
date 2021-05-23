import java.util.Arrays;

public class Number {
    public static int GetSumm(int[] numb){
        return Arrays.stream(numb).sum();
    }
}
