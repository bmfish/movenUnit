/*
 * FileName: LinkedDemo.java
 * Author:   bm
 * Date:     2021-03-17 23:14:24
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述 需求来源
 * <2021-03-17 23:14:24> <version> <desc> <source>
 *
 */

package wkfive.test.statictest.LinkedDemo;

public class LinkedDemo {
    public static void main(String[] args) {
        Node lindList = addend(10);
        nsout(lindList);

        Node headList = createHead(10);
        nsout(headList);
       nsout(recover(headList));
    }

    public static Node recover(Node nodeList){
        Node newNodeList = null;
        Node temp;
        while(nodeList.nextVal!=null){
            temp=nodeList.nextVal;
            nodeList.nextVal=newNodeList;
            newNodeList=nodeList;
            nodeList=temp;
        }
        if(nodeList!=null){
            nodeList.nextVal=newNodeList;
            newNodeList=nodeList;
        }
       return newNodeList;

    }
    public static Node createHead(int length){
        Node  head=null;

        for (int i = 0; i <length ; i++) {
            if(head==null){
                head=new Node(i);
            }
            else{
                Node currentNode=new Node(i);
                currentNode.nextVal=head;
                head=currentNode;
            }
        }
        return head;

    }
    public static Node addend(int length) {

        Node head = null;
        Node temp = null;
        for (int i = 0; i < length; i++) {
            Node current = new Node(i);
            if (head == null) {
                head = temp = current;
            } else {
                temp.nextVal = current;
                temp = current;
            }
        }
        return head;
    }

    public static void nsout(Node nodeList) {
        System.out.println();
        while (nodeList.nextVal != null) {
            System.out.print(nodeList.key + "->");
            nodeList = nodeList.nextVal;
        }
        System.out.print(nodeList.key);
        System.out.println();
    }
}
