package wk.lear.algorithm;

import java.util.*;

public class 括号是否合法 {


    /**
     * 括号是否合法  （）{}
     * S1 ="123232[(err)))]}}"不合法
     * 考察堆栈问题
     */
    public static void main(String[] args) {

       // String s="123232[(err)))]}}";
        String s="235(55){()}(54354)";
        char b[]=s.toCharArray();
        Map<String, String> parent_map=new HashMap<>();
        List<String> list=Arrays.asList("(","[","{");

        parent_map.put(")","(");
        parent_map.put("]","[");
        parent_map.put("}","{");
        Stack<String> stack=new Stack<>();
        for (int i = 0; i < b.length; i++) {
           String c=String.valueOf(b[i]);
            if(list.contains(String.valueOf(b[i]))){
                stack.push(String.valueOf(b[i]));
            }else if(null!=parent_map.get(c)){
                if(stack.isEmpty()){
                    System.out.println(false);
                    break;
                }
                String left=stack.pop();
                if(!parent_map.get(c).equals(left)){
                    System.out.println("false123132");
                    break;
                }
            }
        }
        if(!stack.isEmpty()){
            System.out.println("false");
        }
        System.out.println("true");
    }



}
