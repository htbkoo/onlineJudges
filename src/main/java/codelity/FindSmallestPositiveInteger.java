package codelity;

public class FindSmallestPositiveInteger {
    public static class Solution {
        public int solution(int[] A) {
            // write your code in Java SE 8
            final int max = 1000001;
            final boolean[] bucket = new boolean[max];
            for (int i : A) {
                if (i>0){
                    bucket[i]=true;
                }
            }
            for (int i=1;i<max;++i){
                if (!bucket[i]){
                    return i;
                }
            }
            return 0;
        }
    }
}
