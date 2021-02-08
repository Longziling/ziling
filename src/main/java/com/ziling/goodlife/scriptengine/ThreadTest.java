package com.ziling.goodlife.scriptengine;

import java.io.StringWriter;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;
import javax.script.ScriptContext;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.script.SimpleBindings;
import javax.script.SimpleScriptContext;

public class ThreadTest {

    public static ScriptEngine engine;

    public static void main(String[] args) throws ScriptException {

        String jsCript = "var MyJavaClass = Java.type('com.ziling.goodlife.scriptengine.MyFunction');\n" +
                "var result = MyJavaClass.fun1(c);\n" +
                "print(result);";


        String jsCript1 = "var MyJavaClass = Java.type('com.ziling.goodlife.scriptengine.MyFunction');\n" +
                "var result = MyJavaClass.fun2(a,b);" +
                "print(result);";

//        StringWriter writer = new StringWriter();
//        ScriptContext context = new SimpleScriptContext();
//        context.setWriter(writer);
//
//
//        ScriptEngineManager scriptEngineManager = new ScriptEngineManager();
//        engine = scriptEngineManager.getEngineByName("JavaScript");
        ConcurrentHashMap<Object, Object> concurrentHashMap = new ConcurrentHashMap<>();
//
//        Map<String, Object> input=new TreeMap<>();
//        input.put("a",2);
//        input.put("b",8);
//
//        Map<String, Object> input1=new TreeMap<>();
//        input1.put("c","Tom");
//
//        engine.eval(jsCript, new SimpleBindings(input1));
//        engine.eval(jsCript1, new SimpleBindings(input));
//        System.out.println(engine.get("result"));

//        engine.eval(jsCript);
//        engine.eval(jsCript1, new SimpleBindings(input));
//        engine.eval(jsCript);
//        engine.eval(jsCript1, new SimpleBindings(input));
//        engine.eval(jsCript);
//        engine.eval(jsCript1, new SimpleBindings(input));



//        Compilable compilable = (Compilable) engine;
//        CompiledScript JSFunction = compilable.compile(jsCript1);
//
//        Map<String, Object> input=new TreeMap<>();
//        input.put("a",2);
//        input.put("b",8);
//
//        Object result = JSFunction.eval(new SimpleBindings(input));
//        System.out.println(result);



        for (int i = 0; i < 100; i++) {
            int finalI = i;
            new Thread() {
                @Override
                public void run() {
                    System.out.println("子线程开始执行， i = " + finalI);
                    try {
                        Map<String, Object> input=new TreeMap<>();
                        input.put("a",finalI);
                        input.put("b",8);
                        String testExecuteForAttribute = (String) JavaScriptUtil.executeForAttribute(jsCript1,
                                new SimpleBindings(input), "result");
                        System.out.println(testExecuteForAttribute);
                        concurrentHashMap.put(finalI, testExecuteForAttribute);
                    } catch (ScriptException e) {
                        e.printStackTrace();
                    }
                    System.out.println("子线程结束开始执行， i = " + finalI);
                }
            }.start();
        }

        try {
            Thread.sleep(10000);
        } catch (Exception e) {

        }

        System.out.println(concurrentHashMap.size());
        System.out.println(concurrentHashMap);
    }
}
