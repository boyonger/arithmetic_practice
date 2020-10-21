package leetcode.numberSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Three {
    public List<List<Integer>> sumZero(int[] nums) {
        heapSort(nums);

        List<List<Integer>> result = new ArrayList<>();
        if (nums.length < 3) {
            return result;
        }
        for (int i = 0; i < nums.length - 2; i++) {
            if (i != 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int tempSum = nums[i] + nums[left] + nums[right];
                if (tempSum == 0) {
                    List<Integer> combines = new ArrayList<>(Arrays.asList(nums[i], nums[left], nums[right]));
                    result.add(combines);
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    left++;
                    right--;
                } else if (tempSum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        // 2, -3, 0, -2, -5, -5, -4, 1, 2, -2, 2, 0, 2, -4

        new Three().heapSort(new int[]{2, -3, 0, -2, -5, -5, -4, 1, 2, -2, 2, 0, 2, -4});
    }
    

    public void heapSort(int[] nums){
        int[] heapArray = new int[nums.length +1];
        for(int i = 0; i < nums.length; i++){
            heapArray[i+1] = nums[i];
        }
        int size = heapArray.length;
        int lastParent = size/2;

        for(int i = 0; i < nums.length; i++){
            for(;lastParent >=0; lastParent--){
                int position = lastParent;
                boolean isHeap = false;
                int parentVal = heapArray[lastParent];
                while(!isHeap && 2 * position < size){
                    int minChild = position * 2;
                    if(minChild < heapArray.length-1 && heapArray[minChild] > heapArray[minChild+1]  ){
                        minChild = minChild+1;
                    }
                    if(heapArray[minChild] >= heapArray[parentVal]){
                        isHeap = true;
                    }
                    else{
                        heapArray[lastParent] = heapArray[minChild];
                        position = minChild;
                    }
                }
                heapArray[position] = parentVal;
            }
            nums[i] = heapArray[i+1];
            heapArray[i+1] = heapArray[size-1];
            size--;
        }
    }
}
