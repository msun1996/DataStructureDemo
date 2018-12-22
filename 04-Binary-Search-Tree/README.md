## 二分搜索树

### 二叉树
*   动态数据结构
*   二叉树具有唯一的根节点
*   二叉树每个节点最多有两个子节点(孩子)
*   每个节点只有一个父节点
*   二叉树就有天然的递归结构
   *   每个子节点的左右子树也是二叉树
*   二叉树不一定是“满”二叉树

### 二分搜索树
*   二分搜索树是二叉树
*   二分搜搜数的每个节点的值满足:
   *   大于其左子树的所有节点值
   *   小于其右子树的所有节点值
*   每一个子树也是二分搜索树
*   存储的元素必须有可比较性

### 二分搜索树核心代码
```java
public class BST<E extends Comparable<E>> {
    public class Node {
        public E e;
        public Node left, right;
        public Node(E e) {
            this.e = e;
            left = null;
            right = null;
        }
    }
    private Node root;
    private int size;
    public BST() {
        root = null;
        size = 0;
    }
}
```

### 遍历
> 所有节点数据访问一遍
*   深度优先遍历
    *  前序遍历(中左右)
    *  中序遍历(左中右)
        * 排序
    *  后序遍历(左右中)
        * 释放内存
*   广度优先遍历
    *   层序遍历


```java
// 前序遍历
public void preOrder() {
    preOrder(root);
}

// 前序遍历以node为根的二分搜索树，递归算法
private void preOrder(Node node) {
    // 判断递归结束条件
    if (node == null) {
        return;
    }
    System.out.println(node.e);
    preOrder(node.left);
    preOrder(node.right);

}
```


