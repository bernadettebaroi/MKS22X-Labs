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

  public static boolean groupSum6(int start, int[] nums, int target) {
    if (start >= nums.length) {
      if ( target == 0) {
        return true;
      } else {
        return false;
      }
    } else if (nums[start] == 6){
      return (groupSum6(start+1, nums, target-nums[start]));
    } else {
      return (groupSum6(start+1,nums,target) || groupSum6(start+1, nums, target-nums[start]));
    }
  }

  public boolean groupSum5(int start, int[] nums, int target) {
    if (start >= nums.length) {
      if ( target == 0) {
        return true;
      } else {
        return false;
      }
    } else if (nums[start] % 5 == 0){
      if (start < nums.length - 1 && nums[start+1] != 1) {
        return (groupSum5(start+1, nums, target-nums[start]));
      } else {
        return (groupSum5(start+2, nums, target-nums[start]));
      }
    } else {
      return (groupSum5(start+1,nums,target) || groupSum5(start+1, nums, target-nums[start]));
    }
  }

}
