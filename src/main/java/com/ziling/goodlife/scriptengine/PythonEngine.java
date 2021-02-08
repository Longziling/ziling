package com.ziling.goodlife.scriptengine;

import java.io.StringWriter;
import javax.script.ScriptContext;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineFactory;
import javax.script.ScriptEngineManager;

public class PythonEngine {

    public static ScriptEngine engine;

    public static void main(String[] args) throws Exception {
//        Options.importSite = false;

//        StringWriter writer = new StringWriter();
//        ScriptContext context = new SimpleScriptContext();
//        context.setWriter(writer);
//
        engine = new ScriptEngineManager().getEngineByName("python");

        // Using the eval() method on the engine causes a direct
        // interpretataion and execution of the code string passed into it
//        engine.setContext(context);
        engine.eval("import sys");
        engine.eval("print sys");

        // Using the put() method allows one to place values into
        // specified variables within the engine
        engine.put("a", "42");

        // As you can see, once the variable has been set with
        // a value by using the put() method, we an issue eval statements
        // to use it.
        engine.eval("print a");
        engine.eval("x = 2 + 2");

        // Using the get() method allows one to obtain the value
        // of a specified variable from the engine instance
        Object x = engine.get("x");


        System.out.println("x: " + x);

        ScriptEngineFactory sef= engine.getFactory();
        System.out.println( sef.getParameter(ScriptEngine.LANGUAGE));
        System.out.println( sef.getParameter("THREADING"));

    }
}
