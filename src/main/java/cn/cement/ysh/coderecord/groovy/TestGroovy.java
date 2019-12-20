package cn.cement.ysh.coderecord.groovy;

import javax.script.Bindings;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import java.util.HashMap;
import java.util.Map;

public class TestGroovy {

    /*注意添加依赖groovy-all，否则engine=null空指针异常*/
    public static void main(String[] args) throws Exception {
//        long start = System.currentTimeMillis();
//        ScriptEngineManager manager = new ScriptEngineManager();
//        ScriptEngine engine = manager.getEngineByName("groovy");
//        Bindings bindings = engine.createBindings();
//        for (int i = 0; i < 10; i++) {
//            Map<String, Object> map = new HashMap<>();
//            map.put("name",i);
//            map.put("a",i);
//            map.put("b","bbbbbbb");
//            bindings.put("map", map);
//            Object eval2 = engine.eval(" map.remove('a'); println(map);return map;", bindings);
////            System.out.println(eval2);
//        }
//        System.out.println(System.currentTimeMillis() - start);

        long start = System.currentTimeMillis();
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("javascript");
        Bindings bindings = engine.createBindings();
        for (int i = 0; i < 10; i++) {
            Map<String, Object> map = new HashMap<>();
            map.put("name",i);
            map.put("a",i);
            map.put("b","bbbbbbb");

            Map<String, Object> sub = new HashMap<>();
            sub.put("submap","submapsubmap");
            sub.put("submap2","submapsubmap2");
            map.put("sub",sub);

            bindings.put("map", map);
            Object eval2 = engine.eval(" map.sub.remove('submap2');map.put('Adam', 67);", bindings);
            System.out.println(map);
        }
        System.out.println(System.currentTimeMillis() - start);
    }
}
