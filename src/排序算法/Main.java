package 排序算法;

import java.util.*;
import java.io.*;
public class Main{
    public static int[][] getRes(int[] arr){
        ArrayDeque<List<Integer>> stack = new ArrayDeque<>();
        int[][] res = new int[arr.length][2];
        for(int i=0;i<arr.length;i++){
            while(!stack.isEmpty() && arr[i]<arr[stack.peek().get(0)]){
                List<Integer> topList = stack.pop();
                int leftLessIndex = stack.isEmpty()? -1:stack.peek().get(stack.peek().size()-1);

                for(Integer n:topList){
                    res[n][0] = leftLessIndex;
                    res[n][1] = i;
                }
            }

            if(!stack.isEmpty() && arr[i]==arr[stack.peek().get(0)]){
                stack.peek().add(i);
            }else{
                List<Integer> list = new ArrayList<>();
                list.add(i);
                stack.push(list);
            }
        }

        while(!stack.isEmpty()){
            List<Integer> topList = stack.pop();
            int leftLessIndex = stack.isEmpty()? -1:stack.peek().get(stack.peek().size()-1);
            for(Integer n:topList){
                res[n][0] = leftLessIndex;
                res[n][1] = -1;
            }
        }
        return res;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr= new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }

        int[][] res = getRes(arr);
        for(int i=0;i<n;i++){
            System.out.println(res[i][0] + " "+res[i][1]);
        }
    }


}