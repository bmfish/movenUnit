//1、给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
//
//        你可以假设数组中无重复元素。
//class Solution {
//    public int searchInsert(int[] nums, int target) {
//        int temp=nums[0];
//        for(int i=0;i<nums.size;i++){
//            if(nums[i]==target){
//                return i;
//            }else{
//                if(nums[i]>target>temp||nums[i]<target<temp){
//                    return i;
//                }else{
//                    temp=nums[i];
//                }
//            }
//        }
//    }
//}
//
//
//
//2、给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
//
//        进阶：尝试使用一趟扫描实现。
///**
// * Definition for singly-linked list.
// * public class ListNode {
// *     int val;
// *     ListNode next;
// *     ListNode() {}
// *     ListNode(int val) { this.val = val; }
// *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
// * }
// */
//class Solution {
//    public ListNode removeNthFromEnd(ListNode head, int n) {
//        ListNode h1=head;
//        ListNode h2=new ListNode;
//        int szie=0;
//        while(h1.next!=null){
//            if(h2.next==null){
//                h2.next=h1;
//            }else{
//                ListNode temp=h2.next;
//                h2.next=h1;
//                h1 =h1.next;
//                h2.next.next=temp;
//            }
//            size++;
//        }
//        int i=0;
//        while(i<size-n){
//            head=head.next;
//            i++;
//            if(i==(size-n-1)){
//                ListNode tempN=head.next;
//                head.next=tempN.next;
//                tempN.next=null;
//            }
//        }
//
//        return h2.next;
//    }
//}