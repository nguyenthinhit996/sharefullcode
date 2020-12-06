package featuresameple.scriptapi;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

//document reference here: https://docs.oracle.com/javase/8/docs/technotes/guides/scripting/nashorn/intro.html

public class Runscriptingsample {
	public static void main(String[] args) throws Exception {
        // create a script engine manager
        ScriptEngineManager factory = new ScriptEngineManager();
        // create a Nashorn script engine
        ScriptEngine engine = factory.getEngineByName("nashorn");
        // evaluate JavaScript statement
        try {
            engine.eval("print('Hello, World!');");
        } catch (final ScriptException se) { se.printStackTrace(); }
    }
}
