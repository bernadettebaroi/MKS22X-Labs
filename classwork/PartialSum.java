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


  public boolean splitArray(int[] nums) {
    return splitArrayHelper(0,0,0,nums);
  }
  public boolean splitArrayHelper(int start, int group1, int group2, int[]nums) {
    if (start > nums.length-1) {
      if (group1 == group2) {
        return true;
      } else {
        return false;
      }
    } else {
      return (splitArrayHelper(start+1, group1+nums[start], group2, nums) || splitArrayHelper(start+1, group1, group2+nums[start], nums) );
    }
  }


  public boolean groupNoAdj(int start, int[] nums, int target) {
    if (start > nums.length-1) {
      if (target == 0) {
        return true;
      } else {
        return false;
      }
    } else {
      return (groupNoAdj(start+2, nums, target-nums[start]) || groupNoAdj(start+1, nums, target));
    }
  }


  public boolean splitOdd10(int[] nums) {
    return (helperSplitOdd10(0,0,0, nums));
  }
  public boolean helperSplitOdd10(int start, int group1, int group2, int[] nums) {
    if (start > nums.length -1) {
      if (group1 % 10 == 0 && group2 % 2 == 1) {
        return true;
      } else {
        return false;
      }
    } else {
      return (helperSplitOdd10(start+1, group1+nums[start], group2, nums) || helperSplitOdd10(start+1, group1, group2 + nums[start], nums));
    }
  }


  public boolean split53(int[] nums) {
    return helperSplit53(0,0,0,nums);
  }
  public boolean helperSplit53(int start, int group1, int group2, int[] nums) {
    if (start > nums.length -1) {
      if (group1 == group2) {
        return true;
      } else {
        return false;
      }
    } else {
      if (nums[start] % 5 != 0 && nums[start] % 3 == 0) {
        return (helperSplit53(start+1, group1+nums[start], group2, nums));
      } else if (nums[start] % 5 == 0) {
        return (helperSplit53(start+1, group1, group2+nums[start], nums));
      } else {
        return (helperSplit53(start+1, group1+nums[start], group2, nums) || helperSplit53(start+1, group1, group2+nums[start], nums));
      }
    }
  }

}
