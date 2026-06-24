class Solution {
    public int findMin(int[] nums) {
        int start = 0;
        int end  = nums.length - 1;
        int pivot = nums.length;

        while(start <= end){
            int mid = start + (end - start) / 2;

            if(mid < end && nums[mid] > nums[mid + 1]){
                // mid is the pivot
                pivot = mid;
                break;
            }
            else if(mid > start && nums[mid - 1] > nums[mid]){
                // mid - 1 is the pivot
                pivot = mid - 1;
                break;
            }
            else if(nums[mid] <= nums[start]){
                // pivot is on left side
                end = mid - 1;
            }
            else{
                // pivot is on right side
                start = mid + 1;
            }
            
        }

        if(pivot == nums.length){
            return nums[0];
        }else{
            return nums[pivot + 1];
        }

    }
}
