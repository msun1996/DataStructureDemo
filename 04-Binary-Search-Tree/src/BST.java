import java.util.LinkedList;
import java.util.Stack;

/**
 * 二分搜索树
 * author: mSun
 * date: 2018/11/24
 */
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

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    // 向二分搜索树添加新的元素e
//    public void add(E e) {
//        if (root == null) {
//            root = new Node(e);
//            size ++;
//        } else {
//            add(root, e);
//        }
//    }

    // 向以node为根的二分搜索树中插入元素E，递归算法
//    private void add(Node node, E e) {
//
//        // 判断递归结束条件
//        if (e.equals(node.e)) {
//            return;
//        } else if (e.compareTo(node.e) < 0 && node.left == null) {
//            node.left = new Node(e);
//            size ++;
//            return;
//        } else if(e.compareTo(node.e) > 0 && node.right == null) {
//            node.right = new Node(e);
//            size ++;
//            return;
//        }
//
//        if (e.compareTo(node.e)<0) {
//            add(node.left,e);
//        } else {
//            add(node.right,e);
//        }
//    }

    // 向二分搜索树添加新的元素e(简化)
    public void add(E e) {
        root = add(root, e);
    }

    // 向以node为根的二分搜索树中插入元素E，递归算法
    // 返回插入新节点后二分搜索树的根
    private Node add(Node node, E e) {

        // 判断递归结束条件
        if (node == null) {
            size ++;
            return new Node(e);
        }

        if (e.compareTo(node.e)<0) {
            node.left = add(node.left, e);
        } else if (e.compareTo(node.e)>0){
            node.right = add(node.right, e);
        }
        return node;
    }

    // 查看二分搜索树是否宝行元素e
    public boolean contains(E e) {
        return contains(root, e);
    }

    // 查看以node为根的二分搜索数是否包含元素e,递归
    private boolean contains(Node node, E e) {

        // 判断递归结束条件
        if (node == null) {
            return false;
        }

        if (e.compareTo(node.e)==0) {
            return true;
        } else if (e.compareTo(node.e) < 0 ) {
            return contains(node.left, e);
        } else {
            return contains(node.right, e);
        }
    }

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

    // 前序遍历非递归（栈辅助）
    public void preOrderNR() {
        preOrderNR(root);
    }

    private void preOrderNR(Node node) {
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node cur = stack.pop();
            System.out.println(cur.e);
            if (cur.right != null) {
                stack.push(cur.right);
            }
            if (cur.left != null) {
                stack.push(cur.left);
            }
        }
    }

    // 中序遍历
    public void inOrder() {
        inOrder(root);
    }

    private void inOrder(Node node) {
        if (node==null) {
            return;
        }
        inOrder(node.left);
        System.out.println(node.e);
        inOrder(node.right);
    }

    // 后序遍历
    public void postOrder() {
        postOrder(root);
    }

    private void postOrder(Node node) {
        if (node==null) {
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.e);
    }

    // 层序遍历(队列)
    public void levelOrder() {
        levelOrder(root);
    }

    private void levelOrder(Node node) {
        LinkedList<Node> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            Node cur = queue.remove();
            System.out.println(cur.e);

            if (cur.left != null) {
                queue.add(cur.left);
            }
            if (cur.right != null) {
                queue.add(cur.right);
            }
        }
    }

    // 返回以node为根的二分搜索的最小值所在节点
    public E minimum() {
        if (size == 0) {
            throw new IllegalArgumentException("BST is empty");
        }
        return minimum(root).e;
    }

    private Node minimum(Node node) {
        if (node.left == null) {
            return node;
        }
        return minimum(node.right);
    }

    // 返回以node为根的二分搜索的最大值所在节点
    public E maximum () {
        if (size == 0) {
            throw new IllegalArgumentException("BST is empty");
        }
        return maximum(root).e;
    }

    private Node maximum(Node node) {
        if (node.right == null) {
            return node;
        }
        return maximum(node.right);
    }

    // 删除最小值,并返回(递归实现)
    public E removeMin() {
        E ret = minimum();
        root = removeMin(root);
        return ret;
    }

    // 删除以node为根的二分搜索树的最小节点
    // 返回删除节点新的二分搜索树的根
    private Node removeMin(Node node) {
        // 递归终止条件
        if (node.left == null) {
            Node rightNode = node.right;
            node.right = null;
            size --;
            return rightNode;
        }
        node.left = removeMin(node.left);
        return node;
    }

    // 删除最大值节点并返回
    public E removeMax() {
        E res = maximum();
        root = removeMax(root);
        return res;
    }

    private Node removeMax(Node node) {
        if (node.right == null) {
            Node nodeLeft = node.left;
            node.left = null;
            size --;
            return nodeLeft;
        }
        node.right = removeMax(node.right);
        return node;
    }

    public void  remove(E e) {
        root = remove(root, e);
    }

    private Node remove(Node node, E e) {

        if (node == null) {
            return null;
        }

        if (e.compareTo(node.e) < 0) {
            node.left = remove(node.left, e);
            return node;
        } else if (e.compareTo(node.e) > 0) {
            node.right = remove(node.right, e);
            return node;
        } else {
            // 待删除节点左子树为空
            if (node.left == null) {
                Node rightNode = node.right;
                node.right = null;
                size --;
                return rightNode;
            }
            // 待删除节点右子树为空
            if (node.right == null) {
                Node leftNode = node.left;
                node.left = null;
                size --;
                return leftNode;
            }
            // 待删除节点左右子树均不为空
            // 找到比待删除节点大的最小节点，及待删除节点右子树最小值
            // 用此节点顶替待删除元素
            Node successor = minimum(node.right);
            successor.right = removeMin(node.right);
            successor.left = node.left;

            node.left = node.right = null;
            return successor;  // 顶替上层的Node(即要删除元素)

        }

    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        generateBSTString(root, 0, res);
        return res.toString();
    }

    // 生成以node为根节点,深度为depth的二叉树字符串
    private void generateBSTString(Node node, int depth, StringBuilder res) {
        if ( node == null) {
            res.append(generateDepthString(depth) + "null\n");
            return;
        }

        res.append(generateDepthString(depth) + node.e +"\n");
        generateBSTString(node.left, depth+1, res);
        generateBSTString(node.right, depth+1, res);
    }

    // 深度"--"字符串打印
    private String generateDepthString(int depth) {
        StringBuilder res = new StringBuilder();
        for (int i=0; i < depth; i++) {
            res.append("--");
        }
        return res.toString();
    }

    public static void main(String[] args) {
        BST<Integer> bst = new BST<>();
        int[] nums = {5,3,7,6,8,4,2};
        for (int num: nums) {
            bst.add(num);
        }
        bst.preOrder();
        System.out.println(bst);
    }

}
