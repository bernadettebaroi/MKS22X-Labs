public class PartialSum {
  public static void main(String[] args) {
    int[] list = {2,4,8};
    System.out.println(groupSum(0, list, 10));
    System.out.println(groupSum(0, list, 14));
    System.out.println(groupSum(0, list, 9));
  }

  public static boolean groupSum(int start, int[] nums, int target) {
    if (target == 0) {
      return true;
    } else if(start >= nums.length) {
      return false;
    } else {
      return (groupSum(start+1,nums,target) || groupSum(start+1, nums, target-nums[start]));
    }
  }

  public boolean groupSum6(int start, int[] nums, int target) {
    if (target == 0) {
      return true;
    } else if(start >= nums.length) {
      return false;
    } else if (nums[start] == 6){
      return (groupSum6(start+1, nums, target-nums[start]));
    } else {
      return (groupSum6(start+1,nums,target) || groupSum6(start+1, nums, target-nums[start]));
    }
  }


}
