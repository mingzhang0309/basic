package oom;

/**
 * Created by stephen.zhang on 16/12/7.
 */
public class StringInter {
    public static void main(String[] args) {
        String str1 = new StringBuilder().append("ja").append("va").toString();
        String ss = "java";
        String str2 = str1.intern();

        System.out.println(ss == str2);
        String str3 = str1.intern();

        System.out.println(str1 == str2);
        System.out.println(str1 == str3);
        System.out.println(str2 == str3);

        String str4 = new StringBuilder().append("ja").append("vaa").toString();
        String str5 = str4.intern();
        System.out.println(str4 == str5);

        String s = new String("1");
        String s2 = "1";
        System.out.println(s == s2);
    }
}
