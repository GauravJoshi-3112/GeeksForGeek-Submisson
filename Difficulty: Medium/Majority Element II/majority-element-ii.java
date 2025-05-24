class Solution {
    // Function to find the majority elements in the array
    public List<Integer> findMajority(int[] nums) {
        // Your code goes here.
        List<Integer> list = new ArrayList<>();
        int cnt1 = 0, cnt2 = 0, elm1 = Integer.MIN_VALUE, elm2 = Integer.MIN_VALUE;
        for(int i=0; i<nums.length; i++) {
            if (elm1 == nums[i]) cnt1++;
            else if (elm2 == nums[i]) cnt2++;
            else if (cnt1 == 0 && elm2 != nums[i]) {
                cnt1 = 1;
                elm1 = nums[i];
            } else if (cnt2 == 0 && elm1 != nums[i]) {
                cnt2 = 1;
                elm2 = nums[i];
            } else {
                cnt1--;
                cnt2--;
            }
        }
        
        int tmpCnt1 = 0, tmpCnt2 = 0;
        for(int i=0; i<nums.length; i++) {
            if (nums[i] == elm1) tmpCnt1++;
            else if (nums[i] == elm2) tmpCnt2++;
        }
        
        if (tmpCnt1 > nums.length/3) list.add(elm1);
        if (tmpCnt2 > nums.length/3) list.add(elm2);
        
        Collections.sort(list);
        
        return list;
    }
}
