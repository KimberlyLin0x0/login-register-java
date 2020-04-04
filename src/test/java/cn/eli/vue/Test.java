package cn.eli.vue;

import cn.eli.vue.utils.SecurityEncode;

public class Test {

    public static void main(String[] args) {
        // 加密+加盐
        String password1 = SecurityEncode.generate("admin");
        System.out.println("结果：" + password1 + "   长度："+ password1.length());
        // 解码
        System.out.println(SecurityEncode.verify("admin", password1));
        // 加密+加盐
        String password2= SecurityEncode.generate("admin");
        System.out.println("结果：" + password2 + "   长度："+ password2.length());
        // 解码
        System.out.println(SecurityEncode.verify("admin", password2));
    }
}
