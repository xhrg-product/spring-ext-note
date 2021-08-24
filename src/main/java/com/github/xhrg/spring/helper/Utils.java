package com.github.xhrg.spring.helper;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Utils {

	private static Set<String> alreadyPrint = new HashSet<String>();

	private static List<MyStack> list = new ArrayList<MyStack>();

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
		if (list.size() == 0) {
			int x = 0;
			StackTraceElement[] stt = exception.getStackTrace();
			for (int i = stt.length - 1; i > -1; i--) {
				StackTraceElement s = stt[i];
				MyStack myStack = new MyStack();
				myStack.setFileName(s.getClassName());
				myStack.setMethod(s.getMethodName());
				if (i != stt.length - 1 && i > 0 && myStack.getFileName().equals(stt[i + 1].getClassName())) {
					myStack.setNum(x);
				} else {
					myStack.setNum(x++);
				}
				list.add(myStack);
			}
		}
	}

	public static void printCC() {
		for (MyStack myStack : list) {
			System.out.println(nkk(myStack.getNum()) + myStack.getFileName() + "::" + myStack.getMethod());
		}
	}

	public static String nkk(int i) {
		i = i * 2;
		StringBuilder sb = new StringBuilder();
		while (i-- > 0) {
			sb.append(" ");
		}
		return sb.toString();
	}
}
