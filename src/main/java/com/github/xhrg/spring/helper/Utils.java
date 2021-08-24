package com.github.xhrg.spring.helper;

import java.util.HashSet;
import java.util.Set;

public class Utils {

    private static Set<String> alreadyPrint = new HashSet<String>();

    public static void printStack() {
        Exception exception = new Exception();
        StackTraceElement[] stackTraceElements = exception.getStackTrace();
        StackTraceElement ste = stackTraceElements[1];
        String key = ste.toString();
        if (alreadyPrint.contains(key)) {
            return;
        }
        alreadyPrint.add(key);

        for (int i = 1; i < stackTraceElements.length; i++) {
            System.err.println(stackTraceElements[i]);
        }
        System.err.println("================分割线======================");
        System.err.println("");
        System.err.println("");
        System.err.println("");
    }
}
