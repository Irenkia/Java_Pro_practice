package com.example.practice801;

import org.springframework.stereotype.Component;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
public class MyContext {
    private Map<Class, Object> beans;
    public static MyContext createContext(Class clazz) throws ClassNotFoundException {
        try {
            var path = ((MyContainerScan)clazz.getDeclaredAnnotation(MyContainerScan.class)).name();

            List<Class> result = new ArrayList<>();
            getBeans(new File("src/main/java/" + path), result);

            var context = new MyContext();
//            context.context = // todo: convert 'result' into map with objects as values.
            context.beans.put(result.getClass(),context);
            return context;
        } catch(ClassNotFoundException e) {
            return null;
        }
    }

    private static void getBeans(File file, List<Class> result) throws ClassNotFoundException
    {
        for(var currentFile: file.listFiles()) {
            if(currentFile.isDirectory()) {
                getBeans(currentFile, result);
            } else {
                var path = currentFile.getPath().replace("src/main/java/", "").replace(".java", "").replace("/", ".");
                var clazz = Class.forName(path);
                for(var ann: clazz.getDeclaredAnnotations()) {
                    if(getUsefulAnnotations().contains(ann.annotationType())) {
                        result.add(clazz);
                        break;
                    }
                }
            }
        }
    }

    private static Set<Class> getUsefulAnnotations() {
        return Set.of(MyContainerScan.class, Component.class);
    }
}
