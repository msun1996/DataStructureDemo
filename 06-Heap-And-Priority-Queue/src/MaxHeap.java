import java.util.Arrays;
import java.util.Random;

/**
 * 最大堆
 * @author: mSun
 * @date: 2019/1/4
 */
public class MaxHeap<E extends Comparable<E>> {

    // 基于动态数组实现
    private Array<E> data;

    public MaxHeap(int capacity) {
        data = new Array<>(capacity);
    }

    public MaxHeap() {
        data = new Array<>();
    }

    // 将数组整理成堆(O(n)复杂度)
    public MaxHeap(E[] arr) {
       data = new Array<>(arr);
       for (int i=parent(arr.length-1); i>=0; i--) {
           siftDown(i);
       }
    }

    // 返回堆元素个数
    public int size() {
        return data.getSize();
    }

    // 返回一个布尔值，堆是否为空
    public boolean isEmpty() {
        return data.isEmpty();
    }

    // 返回完全二叉树的数组表示中，一个索引所表示的元素的父亲节点的索引
    private int parent(int index) {
        if (index == 0) {
            throw new IllegalArgumentException("index-0 doesn't have parent.");
        }
        return (index - 1) /2;
    }

    // 返回完全二叉树的数组表示中，一个索引所表示的元素的左孩子节点的索引
    private int leftChild(int index) {
        return index * 2 + 1;
    }

    // 返回完全二叉树的数组表示中，一个索引所表示的元素的右孩子节点的索引
    private int rightChild(int index) {
        return index * 2 + 2;
    }

    // 添加元素
    public void add(E e) {
        data.addLast(e);
        siftUp(data.getSize()-1);
    }

    private void siftUp(int i) {
        while ( i > 0 && data.get(i).compareTo(data.get(parent(i))) > 0) {
            data.swap(i, parent(i));
        }
    }

    // 看堆中最大元素
    public E findMax() {
        if (data.isEmpty()) {
            throw new IllegalArgumentException("Can not findMax when heap is empty");
        }
        return data.get(0);
    }

    // 取出最大元素
    public E extractMax() {
        E ret = findMax();
        // 最大元素与最后一个元素交换
        data.swap(0, data.getSize() -1);
        data.removeLast();
        siftDown(0);
        return ret;
    }

    private void siftDown(int i) {
        // 节点的左孩子小于数组大小，终止
        while(leftChild(i) < data.getSize()) {
            // j索引表示左右孩子中大的那一个
            int j = leftChild(i);
            // 如果有右孩子且右孩子大于左孩子
            if (j+1 <data.getSize() && data.get(j+1).compareTo(data.get(j)) > 0) {
                j = rightChild(i);
            }
            // 符合完全二叉树原则，则break
            if (data.get(i).compareTo(data.get(j)) >= 0) {
                break;
            }
            data.swap(i, j);
        }
    }

    // 取出最大元素并新放入一个元素
    // 方法1:使用extractMax后，再add，相当于有两次O(log(n)操作)
    // 方法2:新元素替换最大元素并SiftDown，O(log(n)操作)
    public E replace(E e) {
        E ret = findMax();
        data.set(0, e);
        siftDown(0);
        return ret;
    }

    public static void main(String[] args) {
        int n = 100;

        MaxHeap<Integer> maxHeap = new MaxHeap<>();
        Random random = new Random();
        for (int i=0; i<n; i++) {
            maxHeap.add(random.nextInt(Integer.MAX_VALUE));
        }
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = maxHeap.extractMax();
        }
        System.out.println(Arrays.toString(arr));
    }
}
