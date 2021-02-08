package com.ziling.goodlife.string;

import java.io.FileWriter;
import java.io.IOException;

public class NTest {

    public static void main(String[] args) {

        String path = "C:\\test\\test2341.txt";
        String content = "你好，\n同学";
        System.out.println(content);

        // 获取输入流
        FileWriter fwriter = null;
        try {
            fwriter = new FileWriter(path);
            fwriter.write(content);
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                fwriter.flush();
                fwriter.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

    }
}
