import java.util.Arrays;

public class Question4 {
    static void minimumCoin(int[] denominations, int totalAmount){
        Arrays.sort(denominations);
        int len = denominations.length;
        int[] countArr = new int[len];
        int totalCount = 0;

        countArr[len-1] = totalAmount/denominations[len-1];
        totalAmount %= denominations[len-1];

        for(int i=len-2; i>=0; i--){
            if(totalAmount == 0) break;
            if(denominations[i]>totalAmount){
                if(countArr[i+1] > 1){
                    totalAmount = (countArr[i]*denominations[i]) + denominations[i+1];
                    countArr[i+1]--;
                } else{
                    i = len-2;

                }
            } countArr[i] = totalAmount/denominations[i];
                totalAmount %= denominations[i];
        }

        totalCount = Arrays.stream(countArr).sum();
        System.out.println(totalCount);
        System.out.println(Arrays.toString(countArr));
    }

    public static void main(String[] args) {
        minimumCoin(new int[]{1,2,5,10,20}, 269);
        minimumCoin(new int[]{1,2,5,10,20}, 15);
        minimumCoin(new int[]{5,7,2,6,9,4,3}, 148);
    }
}
