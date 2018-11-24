package solution;

/**
 * author: mSun
 * date: 2018/11/23
 */
class Solution {
    /*
    public ListNode removeElements(ListNode head, int val) {
        while (head != null &&  head.val == val) {
            ListNode delNode = head;
            head = delNode.next;
            delNode.next = null;
        }

        if (head == null) {
            return null;
        }

        ListNode prev = head;
        while (prev.next != null) {
            if (prev.next.val == val) {
                ListNode delNode = prev.next;
                prev.next = delNode.next;
                delNode.next = null;
            } else {
                prev = prev.next;
            }
        }
        return head;
    }
    */
    /*
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;

        ListNode prev = dummyHead;

        while (prev.next != null) {
            if (prev.next.val == val) {
                prev.next = prev.next.next;
            } else {
                prev = prev.next;
            }
        }
        return dummyHead.next;
    }
    */
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
//        ListNode res = removeElements(head.next,val);
//        if (head.val == val) {
//            return res;
//        } else {
//            head.next = res;
//            return head;
//        }
        head.next = removeElements(head.next, val, depth+1);
        System.out.print(depthString);
        System.out.println("After remove(head.next) " + val +": "  + head.next);
        System.out.print(depthString);
        System.out.println("Return: " + (head.val == val ? head.next : head));
        return head.val == val ? head.next : head;

    }

    private String generateDepthString(int depth) {
        StringBuilder res = new StringBuilder();
        for (int i=0; i<depth; i++) {
            res.append("--");
        }
        return res.toString();
    }

    public static void main(String[] args) {

        int [] nums = {4,5,6,7,6};
        ListNode head = new ListNode(nums);
        System.out.println(head);
        System.out.println(new Solution().removeElements(head,6,0));

    }
}
