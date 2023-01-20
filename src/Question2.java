public class Question2 {
    static void equalSumSubArrays(int[] nums){
        int start=0, end=nums.length-1;
        int sum1=nums[start], sum2=nums[end];

        while(start<end){
            if(sum1 < sum2){
                if(start+1 < end) sum1 += nums[++start];
                else break;
            } else if(sum1 > sum2){
                if(end-1 > start) sum2 += nums[--end];
                else break;
            } else{
                if(start+1 < end && end-1 > start) {
                    sum2 += nums[--end];
                    sum1 += nums[++start];
                } else{
                    break;
                }
            }
        }

        if(sum1 == sum2){
            for(int i=0; i<=start; i++){
                System.out.print(nums[i]+" ");
            }

            System.out.println();

            for(int j=end; j<nums.length; j++){
                System.out.print(nums[j]+" ");
            }
        } else{
            System.out.println(-1);
        }
    }

    public static void main(String[] args) {
        equalSumSubArrays(new int[]{1,2,3,1,5});
    }
}
