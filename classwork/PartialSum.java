public class PartialSum {
  public static void main(String[] args) {
    int[] list = {2,4,8};
    System.out.println(groupSum(0, list, 10));
    System.out.println(groupSum(0, list, 14));
    System.out.println(groupSum(0, list, 9));
  }

  public static boolean groupSum(int start, int[] nums, int target) {
    if (start > nums.length-1 && target != 0) {
      return false;
    } else if(target == 0) {
      return true;
    } else {
      return (groupSum(start+1,nums,target) || groupSum(start+1, nums, target-nums[start]));
    }
  }

}
