package wk.lear.algorithm;

public class 字符串操作 {

    public static void main(String[] args) {
        strAppearCount("abcdesfgabcdefg", "abcd");
    }

    /**
     * 字段出现次数
     *
     * @param str
     * @param subStr
     * @return
     */
    private static int strAppearCount(String str, String subStr) {
        int count = 0;
        int index = 0;
        while ((index = str.indexOf(subStr, index)) != -1) {
            count++;
            index = index + subStr.length();
        }
        System.out.println(count);
        return count;
    }
}

