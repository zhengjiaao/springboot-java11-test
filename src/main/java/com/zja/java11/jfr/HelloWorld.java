package com.zja.java11.jfr;

import jdk.jfr.Description;
import jdk.jfr.Event;
import jdk.jfr.Label;

import java.io.IOException;

/**
 * Company: 上海数慧系统技术有限公司
 * Department: 数据中心
 * Date: 2021-08-25 17:57
 * Author: zhengja
 * Email: zhengja@dist.com.cn
 * Desc：提供了一个低开销的数据收集框架，用来分析 Java 程序和 HotSpot 虚拟机
 * 通过 java -XX:StartFlightRecording=duration=60s,name=Test,filename=recording.jfr,settings=profile com.zja.java11.jfr/HelloWorld
 * 来执行，会产生一个文件 recording.jfr
 */
@Label("Hello World")
@Description("Helps the programmer getting started")
public class HelloWorld extends Event {

    @Label("Message")
    String message;

    //未成功
    public static void main(String... args) throws IOException {
        HelloWorld event = new HelloWorld();
        event.message = "hello, world!";
        event.commit();
    }
}
