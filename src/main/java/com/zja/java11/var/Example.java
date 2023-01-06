package com.zja.java11.var;

import java.io.File;
import java.io.FileInputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 感受 JEP 286 的魔法世界
 *
 * @author zhengja
 * @date 2021/08/25
 */
public class Example {

    public static void main(String[] args) throws Exception {
        var list = new ArrayList<String>();   // 自动推断 ArrayList<String>
        var stream = list.stream();             // 自动推断 Stream<String>

        var newList = List.of("hello", "zhengja");
        newList.forEach(System.out::println);

        String fileName = "./pom.xml";

        var path = Paths.get(fileName);
        System.out.println("path: " + path);

        var bytes = Files.readAllBytes(path);
        System.out.println("字节数组: " + bytes);

        for (var b : bytes) {
            // TODO
        }

        try (var foo = new FileInputStream(new File(""))) {
            System.out.println(foo);
        } catch (Exception e) {
            // ignore
        }

        //JDK 11 则允许在 Lambda 表达式中使用 var
        var numbers = new int[]{1, 2, 3, 4, 5, 6, 7};

        int[] subset = Arrays.stream(numbers).filter((var a) -> a > 5).toArray();
        for (int i = 0; i < subset.length; i++) {
            System.out.println(subset[i]);
        }

    }
}
