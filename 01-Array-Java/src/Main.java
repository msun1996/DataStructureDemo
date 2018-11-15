
/**
 * 数组运行类
 * author: mSun
 * date: 2018/11/4
 */
public class Main {

    public static void main(String[] args) {

        // Java基础代码

//        int[] arr = new int[10];
//        for (int i=0; i<arr.length; i++) {
//            arr[i] = i;
//        }
//
//        int[] scores = new int[] {100,99,98};
//        for (int i=0; i<scores.length; i++) {
//            System.out.println(scores[i]);
//        }
//        for (int score:scores) {
//            System.out.println(score);
//        }

        // 自建数组运行

        Array<Integer> array = new Array<>();
        for (int i=0; i<10; i++) {
            array.addLast(i);
        }
        System.out.println(array);

        array.add(1, 20);
        System.out.println(array);

        array.addFirst(-1);
        System.out.println(array);

        array.remove(2);
        System.out.println(array);

        array.removeElement(4);
        System.out.println(array);
    }

}
