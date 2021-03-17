/*
 * FileName: ListInversion.java
 * Author:   bm
 * Date:     2021-03-14 21:45:10
 * Description: //链表反转
 * History: //修改记录 修改人姓名 修改时间 版本号 描述 需求来源
 * <2021-03-14 21:45:10> <version> <desc> <source>
 *
 */

package wk.algorithm;

public class ListInversion {

    static class Node{
        int value;
        Node nextVal;
        public Node(int value){
            this.value=value;
        }
        public Node(){
            super();
        }
        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public Node getNextVal() {
            return nextVal;
        }

        public void setNextVal(Node nextVal) {
            this.nextVal = nextVal;
        }


    }

  public static void addNode(Node nodeList, Node newNode){
        if(nodeList.nextVal==null){
            nodeList.nextVal=newNode;
            return;
        }
        Node temp=nodeList;
        while(temp.nextVal!=null){
            temp=temp.nextVal;
        }
        temp.nextVal=newNode;
      System.out.println("插入成功");
  }

  public static void addHead(Node nodeList,Node newNode){

        if(nodeList==null){
            nodeList=newNode;
        }else{
            newNode.nextVal=nodeList.nextVal;
            nodeList.nextVal=newNode;
        }
  }

    public static void main(String[] args) {
        Node oldnode=new Node(1);
        for(int  i=2;i<=10;i++){
            addNode(oldnode,new Node(i));
        }
        Node newNodeList = null;
       // pangaddHead(oldnode, newNodeList);
        Node next = null;
        while (oldnode.nextVal!=null) {
            next = oldnode.nextVal;
            oldnode.nextVal=newNodeList;
            newNodeList = oldnode;
            oldnode=next;

        }
        System.out.println(newNodeList);
    }

    private static void pangaddHead(Node oldnode, Node newNodeList) {
        Node temp=oldnode;
        int j=0;
        while (temp.nextVal!=null){
              Node node =new Node();
              node.setValue(temp.value);
             addHead(newNodeList,node);
             temp=temp.nextVal;
             j++;
             if(j>11){
                 break;
             }
        }
        System.out.println(temp);
    }
}
