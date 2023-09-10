package wk.lear.algorithm.链表;

public class 链表反转 {
    public static void main(String[] args) {
        LinkNode link =  LinkNode.init(10);
        System.out.println(link.toString());
        System.out.println(reverse(link).toString());
        System.out.println(link.toString());
    }

    public static LinkNode reverse(LinkNode node){

       LinkNode head2=null;
      while(node!=null){
          LinkNode tempH1=node.next;
          node.next=null;

          node.next=head2;
          head2=node;

          node=tempH1;
      }
      return head2;
    }
}
