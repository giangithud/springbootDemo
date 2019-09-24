package com.example.demo.java8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

/**
 * @author guoxiong@igetwell.cn
 * @version V1.0
 * @fileName Stream终止操作
 * @description 注释
 * @date 2019/9/24 13:50
 */
public class Stream终止操作 {
    /**查找与匹配
     * 1、allMatch--检查是否匹配到所有元素 如果全部匹配返回true，否则返回false
     * 2、anyMatch--检查是否至少匹配一个元素
     * 3、noneMatch--检查是否没有匹配所有元素
     * 4、findFirst--返回第一个元素
     * 5、findAny--返回任意元素
     * 6、count--返回总个数
     * 7、max--返回流中最大值
     * 8、min--返回流中最小值*/

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,10);
        System.out.println("---------allMatch--检查是否匹配到所有元素 如果全部匹配返回true，否则返回false----------");
        Boolean aBoolean  = list.stream().allMatch(e -> e<2);
        System.out.println(aBoolean);

        System.out.println("---------anyMatch--检查是否至少匹配一个元素----------");
        Boolean boolean2  = list.stream().anyMatch(e -> e.equals("g"));
        System.out.println(boolean2);


        System.out.println("---------noneMatch--检查是否没有匹配所有元素----------");
        Boolean boolean3  = list.stream().noneMatch(e -> e.equals("g"));
        System.out.println(boolean3);


        System.out.println("---------Optional 容器为了防止空指针异常 findFirst ---------");
        Optional<Integer> result4  = list.stream().sorted(Comparator.comparing((e)->e)).findFirst();
        System.out.println(result4.get());

        System.out.println("---------findAny 并且用了 orElse----------");
        Integer result5 = list.stream().sorted(Comparator.comparing((e)->e)).findAny().orElse(10);
        System.out.println(result5);

        System.out.println("---------count----------");
        long result6 = list.stream().count();
        System.out.println(result6);

        System.out.println("---------max----------");
        Optional<Integer> result7 = list.stream().max(Comparator.comparing(e->e));
        System.out.println(result7.get());


        System.out.println("---------min----------");
        Optional<Integer> result8 = list.stream().min(Comparator.comparing(e->e));
        System.out.println(result8.get());



    }
}
