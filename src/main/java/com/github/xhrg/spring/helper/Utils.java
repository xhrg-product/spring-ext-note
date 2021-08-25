package com.github.xhrg.spring.helper;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Utils {

	private static Set<String> alreadyPrint = new HashSet<String>();

	private static List<Line> list = new ArrayList<Line>();

	public static void addLine() {
		Exception exception = new Exception();
		int x = 0;
		StackTraceElement[] stt = exception.getStackTrace();
		for (int i = stt.length - 1; i > 0; i--) {
			StackTraceElement s = stt[i];
			Line line = new Line();
			line.setClassName(s.getClassName());
			line.setMethod(s.getMethodName());
			if (i != stt.length - 1 && i > 0 && line.getClassName().equals(stt[i + 1].getClassName())) {
				line.setNum(x);
			} else {
				line.setNum(++x);
			}
			list.add(line);
		}
	}

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
	}

	public static void printCC() {
		for (Line line : list) {
			String str = nkk(line.getNum()) + line.getClassName() + "::" + line.getMethod();
			if (str.contains("com.github")) {
				str = str + "【自定义扩展点】";
			}
			System.out.println(str);
		}
	}

	public static String nkk(int i) {
		i = i * 4;
		StringBuilder sb = new StringBuilder();
		while (i-- > 0) {
			sb.append(" ");
		}
		return sb.toString();
	}
}
