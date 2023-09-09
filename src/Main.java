import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        LinkedList nums = new LinkedList();

//        nums.addLast(15);
//        nums.addLast(22);

        System.out.println(Arrays.toString(nums.toArray()));
        nums.reverse();
        System.out.println(Arrays.toString(nums.toArray()));
    }
}