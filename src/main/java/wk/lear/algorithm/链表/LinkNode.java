package wk.lear.algorithm.链表;

import com.oracle.webservices.internal.api.databinding.DatabindingMode;


public class LinkNode {

    int value;

    LinkNode next;


    public LinkNode(int i){
        this.value=i;
    }

    public static LinkNode  init(int n){
        LinkNode head=null;
        LinkNode currentNode=null;
        for (int i = 1; i <=n ; i++) {

            LinkNode temp=new LinkNode(i);
            if(head==null){
                head=temp;
                currentNode=temp;
            }else {
                currentNode.next = temp;
                currentNode = temp;
            }

        }
        return head;
    }

    public String toString(){
        LinkNode current=this;
        StringBuffer str=new StringBuffer();
        while (current!=null){
            str.append(current.value);
            if(null!=current.next){
                str.append("-->");
            }
            current=current.next;
        }
        return str.toString();
    }
}
