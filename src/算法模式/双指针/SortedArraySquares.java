package 算法模式.双指针;

public class SortedArraySquares {

    public static int[] makeSquares(int[] arr){

        if(arr==null || arr.length==0) return null;

        int[] squares = new int[arr.length];

        int left = 0,right = arr.length-1;

        int highIndex = squares.length-1;

        while (left<=right){
            int leftSquare = arr[left]*arr[left];
            int rightSquare = arr[right]*arr[right];

            if(leftSquare>rightSquare){
                squares[highIndex--] = leftSquare;
                left++;
            }else {
                squares[highIndex--] = rightSquare;
                right--;
            }
        }

        return squares;
    }
}
