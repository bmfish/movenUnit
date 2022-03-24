/*
 * FileName: Linked.java
 * Author:   bm
 * Date:     2021-04-03 21:13:33
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述 需求来源
 * <2021-04-03 21:13:33> <version> <desc> <source>
 *
 */

package wk.lear.statictest.Linked;


public class Linked {

    public static void main(String[] args) {
        Node node = addNodeTail();
        pirnt(node);

        Node newNodes = reverseList(node);

        pirnt(newNodes);

    }

    private static Node reverseList(Node node) {
        Node newNodes = null;
        Node temp;
        while (node != null) {
            temp= node;
            node = node.next;
            temp.next = newNodes;
            newNodes = temp;
        }
        return newNodes;
    }
    private static Node addNodeTail() {
        Node tail = null;
        Node head = null;
        for (int i = 1; i <= 10; i++) {
            Node node = new Node(i);
            if (head == null) {
                head = tail = node;
            } else {
                tail.next = node;
                tail = tail.next;
            }
        }
        return head;
    }


    static class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return super.toString() + " value:" + value;
        }
    }

    static void pirnt(Node node) {
        String mess = "";
        while (node != null) {
            mess = mess + "-->" + node.value + "";
            node = node.next;
        }
        System.out.println(mess);
    }
}
