public class PartialSum {
  public static void main(String[] args) {
    System.out.println(groupSum(0, [2, 4, 8], 10));
    System.out.println(groupSum(0, [2, 4, 8], 14));
    System.out.println(groupSum(0, [2, 4, 8], 9));
  }

  public boolean groupSum(int start, int[] nums, int target) {
    if (start > nums.length-1 || target == 0) {
      return true;
    } else {
      target = target - nums[start];
      return groupSum(start+1,nums,target);
    }
  }

}
