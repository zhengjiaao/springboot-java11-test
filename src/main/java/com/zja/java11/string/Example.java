package com.zja.java11.string;

import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * String.repeat(int)
 * String.lines()
 * String.strip()
 * String.stripLeading()
 * String.stripTrailing()
 * String.isBlank()
 *
 * @author zhengja
 * @date 2021/08/25
 */
public class Example {

    /**
     * public String strip() 去除前后的空格
     * public String stripLeading() 去除前面的空格
     * public String stripTrailing() 去除后面的空格
     * public boolean isBlank() 判断是否为空，或者只含有空格
     * public Stream<String> lines() 依据 line terminators (\n \r \r\n) 来进行分割
     * public String repeat​(int count) 将字符串重复n次
     */
    public static void main(String[] args) {
        String s1 = " Testing ";
        System.out.println(s1.strip()); //Testing

        String s2 = " Testing ";
        System.out.println(s1.stripLeading()); //Testing空格

        String s3 = " Testing ";
        System.out.println(s1.stripTrailing()); //空格Testing

        System.out.println("   ".isBlank()); //true

        String s4 = "A\nB\nC";
        Stream<String> ss = s4.lines();
        ss.forEach(s -> System.out.println(s));

        System.out.println("A".repeat(3)); //AAA
    }

/*    public static void main(String[] args) {
//        writeHeader("User-Agent\tMozilla/5.0 (Macintosh; Intel Mac OS X 10_13_5)");
//        demonstrateStringLines(); //z字符串换行
//        demonstrateStringStrip();
//        demonstrateStringStripLeading();
//        demonstrateStringStripTrailing();
//        demonstrateStringIsBlank();
//        lines();
//        Unicode10();
    }*/

    /**
     * Write provided {@code String} in header. Note that this
     * implementation uses {@code String.repeat(int)}.
     *
     * @param headerText Title of header.
     */
    private static void writeHeader(final String headerText) {
        final String headerSeparator = "=".repeat(headerText.length() + 4);

        System.out.println("\n" + headerSeparator);
        System.out.println(headerText);
        System.out.println(headerSeparator);
    }


    /**
     * Demonstrate method {@code String.lines()} added with JDK 11.
     */
    public static void demonstrateStringLines() {
        String originalString = "Hello\nWorld\n123";

        String stringWithoutLineSeparators = originalString.replaceAll("\\n", "\\\\n");

        writeHeader("String.lines() on '" + stringWithoutLineSeparators + "'");

        originalString.lines().forEach(System.out::println);
    }

    /**
     * Demonstrate method {@code String.strip()} added with JDK 11.
     */
    public static void demonstrateStringStrip() {
        String originalString = "  zhengja.me  23333  ";

        writeHeader("String.strip() on '" + originalString + "'");
        System.out.println("'" + originalString.strip() + "'");
    }

    /**
     * Demonstrate method {@code String.stripLeading()} added with JDK 11.
     */
    public static void demonstrateStringStripLeading() {
        String originalString = "  zhengja.me  23333  ";

        writeHeader("String.stripLeading() on '" + originalString + "'");
        System.out.println("'" + originalString.stripLeading() + "'");
    }

    /**
     * Demonstrate method {@code String.stripTrailing()} added with JDK 11.
     */
    public static void demonstrateStringStripTrailing() {
        String originalString = "  zhengja.me  23333  ";

        writeHeader("String.stripTrailing() on '" + originalString + "'");
        System.out.println("'" + originalString.stripTrailing() + "'");
    }

    /**
     * Demonstrate method {@code String.isBlank()} added with JDK 11.
     */
    public static void demonstrateStringIsBlank() {
        writeHeader("String.isBlank()");

        String emptyString = "";
        System.out.println("空字符串    -> " + emptyString.isBlank());

        String onlyLineSeparator = System.getProperty("line.separator");
        System.out.println("换行符     -> " + onlyLineSeparator.isBlank());

        String tabOnly = "\t";
        System.out.println("Tab 制表符 -> " + tabOnly.isBlank());

        String spacesOnly = "   ";
        System.out.println("空格       -> " + spacesOnly.isBlank());
    }

    public static void lines() {
        writeHeader("String.lines()");

        String str = "Hello \n World, I,m\nzhengja.";

        System.out.println(str.lines().collect(Collectors.toList()));
    }

    //支持 Unicode 10标准
    private static void Unicode10(){
        String emoj = "\ud83d\ude02\ud83d\ude0d\ud83c\udf89\ud83d\udc4d";
        System.out.println(emoj); // 😂😍🎉👍
    }
}
