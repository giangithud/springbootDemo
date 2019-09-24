package com.example.demo.java8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

/**
 * @author guoxiong@igetwell.cn
 * @version V1.0
 * @fileName Stream应用
 * @description 注释
 * @date 2019/9/24 9:47
 */
public class Stream应用 {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("a","b","c","d","e","f","e","f");

        /**Stream 介绍
         * 1、创建stream流
         * 2、中间商操作
         * 3、截止操作（这个操作才会真正执行中间商的动作*/

        /**筛选和切面
         * 1、filter(Predicate)：过滤
         * 2、distinct() 通过hashCode()和equals()去重
         * 3、limit(long) 截断
         * 4、skip(long)*/
        System.out.println("-------filter 按照条件进行过滤------------");
        Stream<String> stream  = list.stream().filter((e)->e.equals("c"));
        //这个操作才会真正执行中间商的动作
        stream.forEach(System.out::println);
        System.out.println("-------distinct 去重------------");
        Stream<String> stream2  = list.stream().distinct();
        stream2.forEach(System.out::println);
        System.out.println("-------limit 截断前面几个元素------------");
        Stream<String> stream3  = list.stream().distinct().limit(2L);
        stream3.forEach(System.out::println);
        System.out.println("---------skip跳过前面多少个----------");
        Stream<String> stream4  = list.stream().distinct().skip(2L);
        stream4.forEach(System.out::println);

        /**映射
         * 1、map(function) 接收一个函数，函数会将每个参数转换为一个新的元素
         * 2、mapToDouble(ToDoubleFunction) 产生一个新的DoubleStream
         * 3、mapToInt(ToIntFunction) 产生一个新的IntStream
         * 4、mapToLong(ToLongFunction) 产生一个新的LongStream
         * 5、flatMap(Function)  将流中的每个值都换成另外一个流然后连接起来
         * */
        System.out.println("---------map(function) 接收一个函数，函数会将每个参数转换为一个新的元素----------");
        Stream<String> stream5  = list.stream().map((x) -> x+=x);
        stream5.forEach(System.out::println);

        System.out.println("---------mapToDouble----------");
        DoubleStream stream6  = list.stream().mapToDouble((x) -> 2D);
        stream6.forEach(System.out::println);

        /**排序
         * 1、sorted() 产生一个新流，自然顺序排序
         * 2、sorted(Comparator) 新流，比较器顺序排序*/

        System.out.println("---------sorted() 产生一个新流，自然顺序排序----------");
        Stream<String> stream7  = list.stream().sorted();
        stream7.forEach(System.out::println);

        System.out.println("---------sorted() 产生一个新流，自然顺序排序----------");
        Stream<String> stream8  = list.stream().sorted(Comparator.comparing((e)->""));
        stream8.forEach(System.out::println);

    }
}
