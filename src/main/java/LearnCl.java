import java.lang.reflect.Array;

public class LearnCl {

    public static void main(String[] args){

        System.out.println("test");

//        int[] nums;

        int[] nums = new int[7];

        nums[0] = 5;
        nums[1] = 3;
        nums[2] = 565;
        nums[3] = 757;
        nums[4] = 88;
        nums[5] = 222;
        nums[6] = 563;

        System.out.println(nums);

        for (int num : nums) {
            System.out.print(num + "_\t");
        }

    }
}
