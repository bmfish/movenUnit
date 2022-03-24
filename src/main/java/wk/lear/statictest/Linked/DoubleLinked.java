/*
 * FileName: DoubleLinked.java
 * Author:   bm
 * Date:     2021-04-04 21:13:40
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述 需求来源
 * <2021-04-04 21:13:40> <version> <desc> <source>
 *
 */

package wk.lear.statictest.Linked;

import java.util.Stack;

public class DoubleLinked {


    public static void main(String[] args) {
        Node nodes = init();
        pirnt(nodes);

        Node newNode=recoverByStack(nodes);
        pirnt(newNode);
    }
    public static Node recoverByStack(Node oldNodes){
        Stack<Node> nodeStack=new Stack<Node>();
        Node temp=null;
        while(oldNodes!=null){
            temp=oldNodes;
            oldNodes=oldNodes.next;
            temp.prve=null;
            temp.next=null;
           nodeStack.push(temp);
        }
        Node newOldNodes =null ;
        while(!nodeStack.empty()){
            if(newOldNodes==null){
                newOldNodes=temp=nodeStack.pop();

            }else{
                Node node =nodeStack.pop();
                temp.next=node;
                node.prve=temp;
                temp=node;
            }
        }
        return newOldNodes;
    }

    public static Node recover(Node oldNodes) {
        Node newNodes = null;
        Node temp = null;
        while (oldNodes != null) {
            temp = oldNodes;
            oldNodes=oldNodes.next;
            if(oldNodes!=null) {
                oldNodes.prve = null;
            }
            temp.next=newNodes;
            if(newNodes!=null){
                newNodes.prve=temp;
            }
            newNodes=temp;

        }
        return newNodes;
    }

    public static Node init() {
        Node head = null;
        Node tail = null;
        for (int i = 1; i <= 10; i++) {
            if (i == 1) {
                head = tail = new Node(i);
            } else {
                tail.next = new Node(i);
                tail.next.prve = tail;
                tail = tail.next;
            }
        }
        return head;
    }

    static void pirnt(Node node) {
        String mess = "";
        String messpre = "";
        while (node != null) {
            mess = mess + "-->" + node.value + "";
            messpre = messpre + "--<" + node.value;
            node = node.next;
        }
        System.out.println(mess);
        System.out.println(messpre);
    }

    static class Node {
        int value;
        Node prve;
        Node next;

        Node(int i) {
            this.value = i;
        }

    }
}
