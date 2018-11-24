package recursive;

/**
 * author: mSun
 * date: 2018/11/24
 */
public class Sum {

    public static int sum(int[] arr) {
        return sum(arr, 0);
    }

    // 计算arr[l...n]区间数字和,递归实现
    private static int sum(int[] arr, int l) {
        // 递归结束条件
        if (l==arr.length) {
            return 0;
        }
        return arr[l] + sum(arr, l+1);
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        System.out.println(sum(arr));
    }
}
