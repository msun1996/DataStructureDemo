## 线段树
便于区间查询
*   平衡二叉树(最大最小深度不大于1)


### 时间复杂度
||使用数组实现|使用线段树|
|---|---|---|
|更新|O(n)|O(log n)|
|查询|O(n)|O(log n)|

### 空间复杂度
4n

### 核心代码
```java
public class SegmentTree<E> {
    private E[] tree;
    private E[] data;
    // 接口，线段集处理函数(eg:和)
    private Merger<E> merger;
    public SegmentTree(E[] arr, Merger<E> merger) {
        this.merger = merger;
        data = (E []) new Object[arr.length];
        for (int i = 0; i < arr.length; i++) {
            data[i] = arr[i];
        }
        tree = (E[]) new Object[4 * arr.length];
        buildSegmentTree(0, 0, data.length-1);
    }
    private void buildSegmentTree(int treeIndex, int l,int r) {
        if (l == r) {
            tree[treeIndex] = data[l];
            return;
        }
        int leftTreeIndex = leftChild(treeIndex);
        int rightTreeIndex = rightChild(treeIndex);
        int mid = l + (r - l)/ 2;
        buildSegmentTree(leftTreeIndex, l, mid);
        buildSegmentTree(rightTreeIndex, mid+1, r);
        tree[treeIndex] =  merger.merge(tree[leftTreeIndex], tree[rightTreeIndex]);
    }
    private int leftChild(int index) {
        return 2 * index + 1;
    }
    private int rightChild(int index) {
        return 2 * index + 2;
    }
```


