package com.zja.java11.jfr;

import jdk.jfr.consumer.RecordedEvent;
import jdk.jfr.consumer.RecordingFile;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Company: 上海数慧系统技术有限公司
 * Department: 数据中心
 * Date: 2021-08-25 17:59
 * Author: zhengja
 * Email: zhengja@dist.com.cn
 * Desc：消费这个 event {@link HelloWorld}
 */
public class EventConsumer {
    public static void main(String... args) throws IOException {
        Path p = Paths.get("recording.jfr");
        for (RecordedEvent e : RecordingFile.readAllEvents(p)) {
            System.out.println(e.getStartTime() + " : " + e.getValue("message"));
        }
    }
}
