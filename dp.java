//best time to buy and sell stock with at most two transactions....

class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int buy1=Integer.MIN_VALUE;
        int sell1=0;
        int buy2=Integer.MIN_VALUE;
        int sell2=0;
        for(int i=0;i<n;i++){
            buy1=Math.max(buy1,-prices[i]);
            sell1=Math.max(sell1,buy1+prices[i]);
            buy2=Math.max(buy2,sell1-prices[i]);
            sell2=Math.max(sell2,buy2+prices[i]);
        }
        return sell2;
    }
}

// best time to buy and sell stock IV

class Solution {
    public int maxProfit(int k, int[] prices) {
        int n=prices.length;
        int profit=0;
        if(k>=n/2){
            for(int i=1;i<n;i++){
                if(prices[i]>prices[i-1]){
                    profit+=prices[i]-prices[i-1];
                }
            }
            return profit;
        }
        int[] buy=new int[k+1];
        int[] sell=new int[k+1];
        for(int i=0;i<=k;i++){
            buy[i]=Integer.MIN_VALUE;
        }
        for(int i=0;i<n;i++){
            for(int j=1;j<=k;j++){
                buy[j]=Math.max(buy[j],sell[j-1]-prices[i]);
                sell[j]=Math.max(sell[j],buy[j]+prices[i]);
            }
        }
        return sell[k];
    }
}
