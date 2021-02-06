package Searches;

import java.util.ArrayList;
import java.util.List;

public class LinearSearch {

    public static int solution(int[] x, int[] y) {
        // Your code here

        List<Integer> x1 = new ArrayList<>();
        List<Integer> y1 = new ArrayList<>();
        for(int num: x){
            x1.add(num);
        }
        for(int num: y){
            y1.add(num);
        }
        boolean flag = true;
        int ans = 0;

        for(Integer xNum: x1){
            flag = y1.contains(xNum);
            if(!flag){
                ans =  xNum;
            }
        }

        for(Integer yNum: y1){
            flag = x1.contains(yNum);
            if(!flag){
                ans =  yNum;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] x = {14, 27, 1, -7, 4, 2, 50, 3, 1};
        int[] y = {2, 4, 3, 1, 1, 14, 27, 50};
        System.out.println(solution(x,y));
    }
}
