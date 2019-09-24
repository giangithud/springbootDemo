package com.example.demo.java8;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

/**
 * @author guoxiong@igetwell.cn
 * @version V1.0
 * @fileName Lambda
 * @description Lambda 表达式学习 是一种语法糖，用于简化代码的编写 函数式接口（只有一个抽象方法@FunctionInterface标志）
 * 代码风格能省就省，因为就是用来简化代码而设计的
 * @date 2019/9/23 17:23
 */
public class Lambda {

    public static void main(String[] args) {

        /**表达式的写法 主要用来简化接口的实现编写，以后可以不用谢实现类，比如Runnable等
         * 左边（入参） 中间（箭头函数） 右边（实现代码块）*/
        TestInterface testInterface1 = (e) -> System.out.println("testInterface1==="+e);
        testInterface1.test(2);

        // 多行函数就用{}包裹起来
        TestInterface testInterface2 = (e) -> {
            e = e + 1;
            System.out.println("testInterface2==="+e);
        };
        testInterface2.test(3);

        // 单个函数对列表元素进行处理，那么可以使用更加简洁的 方法引用
        TestInterface testInterface3 = System.out::println;
        testInterface3.test(5);

        // Predicate 过滤
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        numbers = numbers.stream().filter(e -> e%2==0).collect(Collectors.toList());
        System.out.println("Predicate 过滤"+numbers);

        // map 转为另外一个列表
        List<Integer> mapped = numbers.stream().map(x -> x * 2).collect(Collectors.toList());
        mapped.forEach(System.out::println);
        System.out.println("mapped map"+mapped);

        // Reduce 聚合 对所有元素进行聚合，最终得到一个结果
        int sum = numbers.stream().reduce((x, y) -> x + y).get();
        System.out.println(sum);

        // double average = numbers.stream().mapToInt(x -> x).average().getAsDouble();

        System.out.println(doSome("bear", e -> e + " stupid"));
        System.out.println(doSome("beer", e -> e + " clver"));
        System.out.println(function("beer", x -> x + "what"));
    }

    public static String doSome(String str,MyFunction myfun){
        return myfun.function(str);
    }

    /**返回Boolean类型，stream的filter里面就是用这个*/
    public static Boolean predicate(String str,Predicate<String> predicate){
        return predicate.test(str);
    }

    /**有返回值*/
    public static String function(String str,Function<String,String> myfun){
        return myfun.apply(str);
    }

    /**消费，无返回值*/
    public static void consumer(String str,Consumer<String> consumer){
        consumer.accept(str);
    }

    /**供给型接口 */
    public static String supplier(Supplier<String> supplier){
        return supplier.get();
    }


}
