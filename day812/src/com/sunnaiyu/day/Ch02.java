package com.sunnaiyu.day;
import org.junit.Test;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

/**
 * Pattern类
 * Matcher类
 * PatternSyntaxException类
 */
public class Ch02 {

    @Test
    public void test06() {
        String regex = "[-_]";
        String str = "123-4756_qweqwe-7987_465";
        String[] split = str.split(regex);
        System.out.println(Arrays.toString(split));
    }

    @Test
    public void test05(){
        String regex = "\\d";
        String str = "1111c2222d456456456f465gh987897";

        String s = str.replaceAll(regex, "@");
        System.out.println(s);
    }

    @Test
    public void test04() {
        String regex = "^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$";
        String email = "175367745@qq.com";
        System.out.println(email.matches(regex));
    }

    @Test
    public void test03() {
        String regex = "a";
        String str = "cat cat dog dog cat";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);

        // 统计cat在字符串中出现的次数
        int count = 0;
        System.out.println(matcher.find(str.length() - 1));
        while(matcher.find()){
            count++;
        }
        System.out.println("出现了" + count + "次");
    }

    @Test
    public void test02() {
        String regex = "^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$";
        String email = "175367745@qq.";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        System.out.println(matcher.matches());
    }

    @Test
    public void test01() {
        String str = "hello,i am from jilin changchun!";
        // 必须包含jilin
        String pattern = ".*jilina.*";
        boolean b = Pattern.matches(pattern,str);
        System.out.println("字符串中是否包含了jilin：" + b);
    }
}
