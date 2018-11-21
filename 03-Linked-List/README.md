## 链表
*   动态线性数据结构
## 实现核心代码
```java
// Node 节点
private class Node {
    public E e;
    public Node next;

    public Node(E e, Node next) {
        this.e = e;
        this.next = next;
    }
}

// 声明个假头
private Node dummyHead;
// 链表大小
private int size;

// 添加
public void add(int index, E e) {
    Node prev = dummyHead;
    for (int i=0; i < index; i++) {
        prev = prev.next;
    }
//    Node node = new Node(e);
//    node.next = prev.next;
//    prev.next = node;
    prev.next = new Node(e, prev.next);
    size ++;
}
```
### 时间复杂度简单分析
>增删改查链表尾元素为O(n)  
增删改查所有复杂度为O(n/2)=O(n)  
增删改查链表头元素复杂度为O(1)  
