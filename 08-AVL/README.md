## 平衡二叉树
*   左右子树差小于1

### 核心代码
```java
// 普通二分搜索树多了深度的概念。
private class Node {
    public K key;
    public V value;
    public Node left, right;
    public int height;
    
    public Node(K key, V value) {
        this.key = key;
        this.value = value;
        left = null;
        right = null;
        height = 1;
    }
}
// 获得节点node的高度
private int getHeight(Node node) {
    if (node == null)
        return 0;
    return node.height;
}
// 获得节点node的平衡因子
private int getBalanceFactor(Node node) {
    if (node == null)
        return 0;
    return getHeight(node.left) - getHeight(node.right);
}
// 右旋转
//        y                              x
//       / \                           /   \
//      x   T4     向右旋转 (y)        z     y
//     / \       - - - - - - - ->    / \   / \
//    z   T3                       T1  T2 T3 T4
//   / \
// T1   T2
private Node rightRotate(Node y) {
    Node x = y.left;
    Node T3 = x.right;
    // 向右旋转
    x.right = y;
    y.left = T3;
    // 更新height(x,y)
    y.height = Math.max(getHeight(y.left), getHeight(y.right)) +1;
    x.height = Math.max(getHeight(x.left), getHeight(x.right)) +1;
    return x;
}
// 左旋转
//    y                             x
//  /  \                          /   \
// T1   x      向左旋转 (y)       y     z
//     / \   - - - - - - - ->   / \   / \
//   T2  z                     T1 T2 T3 T4
//      / \
//     T3 T4
private Node leftRotate(Node y) {
    Node x = y.right;
    Node T2 = x.left;
    // 向左旋转
    x.left = y;
    y.right = T2;
    // 更新height(x,y)
    y.height = Math.max(getHeight(y.left), getHeight(y.right)) + 1;
    x.height = Math.max(getHeight(x.left), getHeight(x.right)) + 1;
    return x;
}
// 向平衡二叉树中添加新的元素(key, value)
public void add(K key, V value) {
    root = add(root, key, value);
}
// 向以node为根的平衡二叉树中插入元素(key, value)，递归算法
// 返回插入新节点后平衡二叉树的根
private Node add(Node node, K key, V value) {
    if (node == null) {
        size++;
        return new Node(key, value);
    }
    if (key.compareTo(node.key) < 0)
        node.left = add(node.left, key, value);
    else if (key.compareTo(node.key) > 0)
        node.right = add(node.right, key, value);
    else // key.compareTo(node.key) == 0
        node.value = value;
    // 更新height
    node.height = 1 + Math.max(getHeight(node.left), getHeight(node.right));
    // 计算平衡因子
    int balanceFactor = getBalanceFactor(node);
//        if (Math.abs(balanceFactor) > 1)
//            System.out.println("unbalanced : " + balanceFactor);
    // 平衡维护
    // LL
    if (balanceFactor > 1 && getBalanceFactor(node.left)>=0) {
        return rightRotate(node);
    }
    // RR
    if (balanceFactor < -1 && getBalanceFactor(node.right) <=0) {
        return leftRotate(node);
    }
    // LR
    if (balanceFactor > 1 && getBalanceFactor(node.left) < 0) {
        node.left = leftRotate(node.left);
        return rightRotate(node);
    }
    // RL
    if (balanceFactor < -1 && getBalanceFactor(node.right) >0) {
        node.right = rightRotate(node.right);
        return leftRotate(node);
    }
    return node;
}
// 返回以node为根节点的平衡二叉树中，key所在的节点
private Node getNode(Node node, K key) {
    if (node == null)
        return null;
    if (key.equals(node.key))
        return node;
    else if (key.compareTo(node.key) < 0)
        return getNode(node.left, key);
    else // if(key.compareTo(node.key) > 0)
        return getNode(node.right, key);
}

// 判断二叉树是否为一颗二分搜索树(中序排序顺序性)
public boolean isBST() {
    ArrayList<K> keys = new ArrayList<>();
    inOrder(root, keys);
    for (int i=1; i<keys.size(); i++) {
        if (keys.get(i-1).compareTo(keys.get(i))>0) {
            return false;
        }
    }
    return true;
}
private void inOrder(Node node, ArrayList<K> keys) {
    if (node == null) {
        return;
    }
    inOrder(node.left, keys);
    keys.add(node.key);
    inOrder(node.right, keys);
}
// 判断二叉树是否为一个平衡二叉树
public boolean isBalanced() {
    return isBalanced(root);
}
private boolean isBalanced(Node node) {
    if (node == null){
        return true;
    }
    int balanceFactor = getBalanceFactor(node);
    if (Math.abs(balanceFactor)>1) {
        return false;
    }
    return isBalanced(node.left) && isBalanced(node.right);
}
```
