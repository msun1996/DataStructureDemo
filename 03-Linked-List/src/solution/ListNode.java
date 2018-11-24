package solution;

/**
 * author: mSun
 * date: 2018/11/23
 */
public class ListNode {
    int val;
    ListNode next;
    public ListNode(int x) {
        val = x;
    }

    public ListNode(int[] arr) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("arr can not be empty");
        }

        // this就是链表创建的头节点
        this.val = arr[0];
        ListNode cur = this;
        for (int i = 1; i< arr.length; i++ ) {
            cur.next = new ListNode(arr[i]);
            cur = cur.next;
        }
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        ListNode cur = this;
        while (cur != null) {
            res.append(cur.val + "->");
            cur = cur.next;
        }
        res.append("Null");
        return res.toString();
    }
}
