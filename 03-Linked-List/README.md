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

## 递归

### 数组递归实现核心代码

```java
public class Sum {
    // 删除链表中指定的元素，打印出递归逻辑
    public ListNode removeElements(ListNode head, int val, int depth) {
        String depthString = generateDepthString(depth);
        System.out.print(depthString);
        System.out.println("Call:remove " + val + " in " + head);
        // 递归结束条件
        if (head == null) {
            System.out.print(depthString);
            System.out.println("Return" + head);
            return null;
        }
        head.next = removeElements(head.next, val, depth+1);
        System.out.print(depthString);
        System.out.println("After remove(head.next) " + val +": "  + head.next);
        System.out.print(depthString);
        System.out.println("Return: " + (head.val == val ? head.next : head));
        return head.val == val ? head.next : head;
    }
    // 打印递归深度
    private String generateDepthString(int depth) {
        StringBuilder res = new StringBuilder();
        for (int i=0; i<depth; i++) {
            res.append("--");
        }
        return res.toString();
    }
}
```

### 链表递归核心代码
```java
class Solution {
    // 移除链表中指定元素值
    public ListNode removeElements(ListNode head, int val) {
        // 递归结束条件
        if (head == null) {
            return null;
        }
        head.next = removeElements(head.next, val);
        return head.val == val ? head.next : head;
    }
}
```

> 代价：函数调用+系统栈空间（递归主要用在非线性结构，线性循环就可以）
