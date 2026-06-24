class Solution {
    public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int pivot = -1;


        while(start <= end){
            int mid = start + (end - start) / 2;

            if(mid < end && nums[mid + 1] < nums[mid]){
                pivot = mid;
                break;
            }
            else if(mid > start && nums[mid - 1] > nums[mid]){
                pivot = mid - 1;
                break;
            }
            else if(nums[mid] <= nums[start]){
                end = mid - 1;
            }
            else{
                start = mid + 1;
            }
        }

        if(pivot == -1){
            // array is alreay sorted (not rotated)
            return binarySearch(nums , 0 , nums.length - 1 , target);
        }else{
            int index1 = binarySearch(nums , 0 , pivot , target);
            int index2 = binarySearch(nums , pivot + 1 , nums.length - 1 , target);

            return Math.max(index1 , index2);
        }
    }

    public int binarySearch(int[] nums , int start , int end , int target){
        while(start <= end){
            int mid = start + (end - start) / 2;

            if(nums[mid] == target){
                return mid;
            }
            else if(nums[mid] > target){
                end = mid - 1;
            }
            else if(nums[mid] < target){
                start = mid + 1;
            }

        }

        return -1;
    }
}
