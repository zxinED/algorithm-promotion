import java.util.ArrayList;

public class ListNode{

    private ListNode next;
    private int value;

    public ListNode(int value){
        this.value = value;
    }
    public ListNode getNext() {
        return next;
    }
    public void setNext(ListNode next) {
        this.next = next;
    }
    public int getValue() {
        return value;
    }
    public void setValue(int value) {
        this.value = value;
    }

    //遍历链表
    public ArrayList<ListNode> getListNodes(ListNode head){
        ArrayList<ListNode> lists = new ArrayList<>();
        ListNode node = head;
        while (node!=null){
            lists.add(node);
            node = head.next;
        }
        return lists;
    }

    //获取链表长度
    public int getListLength(ListNode head){
        int length = 0;
        ListNode node = head;
        while (node!=null){
            length++;
            node = head.next;
        }
        return length;
    }


    /**
     * 链表插入
     * @param head       链表头节点
     * @param nodeInsert 待插入节点
     * @param position   待插入位置，从1开始
     * @return 插入后得到的链表头节点
     */
    public  ListNode insertNode(ListNode head, ListNode nodeInsert, int position) {
        if (head == null) {
            //这里可以认为待插入的结点就是链表的头结点，也可以抛出不能插入的异常
            return nodeInsert;
        }
        //已经存放的元素个数
        int size = getListLength(head);
        if (position > size+1  || position < 1) {
            System.out.println("位置参数越界");
            return head;
        }

        //表头插入
        if (position == 1) {
            nodeInsert.next = head;
            // 这里可以直接 return nodeInsert;还可以这么写：
            head = nodeInsert;
            return head;
        }

        ListNode pNode = head;
        int count = 1;
        //这里position被上面的size被限制住了，不用考虑pNode=null
        while (count < position - 1) {
            pNode = pNode.next;
            count++;
        }
        nodeInsert.next = pNode.next;
        pNode.next = nodeInsert;

        return head;
    }
}