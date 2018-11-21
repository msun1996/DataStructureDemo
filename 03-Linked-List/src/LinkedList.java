/**
 * 链表
 * author: mSun
 * date: 2018/11/21
 */
public class LinkedList<E> {

    // Node 节点
    private class Node {
        public E e;
        public Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this(e, null);
        }

        public Node() {
            this(null,null);
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }

    // 链表头节点(一般从头插入元素)
//    private Node head;
    // 声明个假头
    private Node dummyHead;
    // 链表大小
    private int size;

    // 声明链表
    public LinkedList() {
//        head = null;
        dummyHead = new Node();
        size = 0;
    }

    // 获取链表个数
    public int getSize() {
        return size;
    }

    // 获取链表是否为空
    public Boolean isEmpty() {
        return size == 0;
    }

//    // 链表头添加元素
//    public void addFirst(E e) {
////        Node node = new Node(e);
////        node.next = head;
////        head = node;
//        head = new Node(e, head);
//        size ++;
//    }

    // 链表指定位置添加元素(0-based)
    public void add(int index, E e) {

        // 序号不合法抛错
        if (index<0 || index > size) {
            throw new IllegalArgumentException("Add failed.");
        }

//        if (index == 0) {
//            addFirst(e);
//        } else {
        Node prev = dummyHead;
        for (int i=0; i < index; i++) {
            prev = prev.next;
        }
//            Node node = new Node(e);
//            node.next = prev.next;
//            prev.next = node;

        prev.next = new Node(e, prev.next);
        size ++;
//        }
    }

//    // 链尾添加元素
//    public void addLast(E e) {
//        add(size, e);
//    }
    // 链头添加元素e
    public void addFirst(E e) {
        add(0,e);
    }

    // 链尾添加元素
    public void addLast(E e) {
        add(size,e);
    }

    // 获得链表第n位置元素
    public E get(int index) {
        // 序号不合法抛错
        if (index<0 || index > size) {
            throw new IllegalArgumentException("Add failed.");
        }

        Node cur = dummyHead.next;
        for (int i=0; i<index; i++) {
            cur = cur.next;
        }
        return cur.e;
    }

    // 获得第一个元素
    public E getFirst() {
        return get(0);
    }

    // 获得最后一个元素
    public E getLast() {
        return get(size-1);
    }

    // 修改链表指定位置元素
    public void set(int index, E e) {
        // 序号不合法抛错
        if (index<0 || index > size) {
            throw new IllegalArgumentException("Add failed.");
        }

        // 首元素
        Node cur = dummyHead.next;
        for (int i=0; i<index; i++) {
            cur = cur.next;
        }
        cur.e = e;
    }

    // 查找链表是否包含元素
    public boolean contains(E e) {
        Node cur = dummyHead.next;
        while (cur != null) {
            if (cur.e.equals(e)) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    // 链表删除元素
    public E remove(int index) {
        // 序号不合法抛错
        if (index<0 || index > size) {
            throw new IllegalArgumentException("Add failed.");
        }

        Node prev = dummyHead;
        for (int i=0; i<index; i++) {
            prev = prev.next;
        }

        Node retNote = prev.next;
        prev.next = retNote.next;
        retNote.next = null;
        size --;
        return retNote.e;
    }

    public E removeFirst() {
        return remove(0);
    }

    public E removeLast() {
        return remove(size-1);
    }

    // 链表删除指定元素
    public void removeElement(E e) {
        Node prev = dummyHead;
        while (prev.next!= null) {
            if (prev.next.e.equals(e)) {
                break;
            }
            prev = prev.next;
        }

        if(prev.next != null) {
            Node delNode = prev.next;
            prev.next = delNode.next;
            delNode.next = null;
            size -- ;
        }

    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
//        Node cur = dummyHead.next;
//        while (cur!=null) {
//            res.append(cur+"->");
//            cur = cur.next;
//        }
        for (Node cur = dummyHead.next; cur != null; cur=cur.next) {
            res.append(cur + "->");
        }
        res.append("Null");
        return res.toString();
    }

    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        for(int i = 0 ; i < 5 ; i ++){
            linkedList.addFirst(i);
            System.out.println(linkedList);
        }

        linkedList.add(2, 666);
        System.out.println(linkedList);

        linkedList.remove(2);
        System.out.println(linkedList);

        linkedList.removeFirst();
        System.out.println(linkedList);

        linkedList.removeLast();
        System.out.println(linkedList);
    }

}
