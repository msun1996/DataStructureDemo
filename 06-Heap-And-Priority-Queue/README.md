## 堆和优先队列

### 优先队列
*   普通队列：先进先出；后进后出
*   优先队列：出队顺序和入队顺序无关；和优先级相关(排序算法有关)

#### 时间复杂度
|     | 入队 | 出队 |
|-----|------|------|
|普通线性结构|O(1)|O(n)|
|顺序线性结构|O(n)|O(1)|
| 堆 |O(log n)|O(log n)| 
(堆因为使用完全二叉树，所以不存在退化成链表的可能)

### 二叉堆
*   完全二叉树
    *   把元素顺序排列成树（只可能右下角空）
    *   父亲大于等于叶子(最大堆)
    *   用数组表示
```
节点的父节点： parent(i) = (i-1) / 2
节点的左节点： left child(i) = 2 * i + 1
节点的有节点： right child(i) = 2 * i + 2
```

#### 二叉树核心实现代码
```java
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
}
```

