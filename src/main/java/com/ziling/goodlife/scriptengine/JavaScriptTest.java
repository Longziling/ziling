package com.ziling.goodlife.scriptengine;

import java.util.Map;
import java.util.TreeMap;
import javax.script.ScriptException;
import javax.script.SimpleBindings;

public class JavaScriptTest {

    public static void main(String[] args) throws ScriptException {

        String jsCript = "var MyJavaClass = Java.type('com.ziling.goodlife.scriptengine.MyFunction');\n" +
                "var result = MyJavaClass.fun1(c);\n" +
                "print(result);";

        String jsCript1 =
                "var result = c;";

        Map<String, Object> input =new TreeMap<>();
        input.put("c","Tom");

//        Integer testExecute = (Integer) JavaScriptUtil.execute("2*3");
//        String testExecuteForAttribute = (String) JavaScriptUtil.executeForAttribute("var value = 'a'+ 'dc'", "value");

        String testExecuteForAttribute = (String) JavaScriptUtil.executeForAttribute(jsCript1,
                new SimpleBindings(input), "result");

//        Boolean testExecuteForFirstAttribute = (Boolean) JavaScriptUtil.executeForFirstAttribute("var a = 6==2*3");

//        System.out.println(testExecute);
        System.out.println(testExecuteForAttribute);
//        System.out.println(testExecuteForFirstAttribute);

        System.out.println("test over ....");

    }
}
