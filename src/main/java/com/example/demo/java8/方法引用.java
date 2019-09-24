package com.example.demo.java8;

import com.example.demo.entity.User;

import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * @author guoxiong@igetwell.cn
 * @version V1.0
 * @fileName 方法引用
 * @description 注释
 * @date 2019/9/24 8:43
 */
public class 方法引用 {
    public static void main(String[] args) {
        // 当现在已有的方法能表达lambda表达式的含义，就是可以相互转换的的
        // 等同于(e) -> System.out.println(e);
        Consumer<String> consumer = System.out::println;
        Consumer<String> consumer2 = (e) -> System.out.println(e);
        consumer.accept("a");

        // 构造器引用
        // 等同于 () -> new User()
        Supplier<User> supplier = User::new;
        Supplier<User> supplier2 = () -> new User();
        System.out.println(supplier.get());


    }
}
