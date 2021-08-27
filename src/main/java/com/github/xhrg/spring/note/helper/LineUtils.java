package com.github.xhrg.spring.note.helper;

import static org.fusesource.jansi.Ansi.ansi;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.github.xhrg.spring.note.helper.tree.Line;
import com.github.xhrg.spring.note.helper.tree.LineTree;

public class LineUtils {

    private static Set<String> alreadyPrint = new HashSet<String>();

    private static List<List<Line>> lists = new ArrayList<List<Line>>();

    public static void toTree(boolean printMe) {
        List<Line> lineList = new ArrayList<>();
        Exception exception = new Exception();
        int x = 0;
        StackTraceElement[] stt = exception.getStackTrace();

        StackTraceElement ste = stt[1];
        String key = ste.toString();
        if (alreadyPrint.contains(key)) {
            return;
        }
        alreadyPrint.add(key);

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
            lineList.add(line);

            if (printMe) {
                System.out.println(ansi().eraseScreen().fgYellow().bold().a(s).reset());
            }
        }
        lists.add(lineList);
        LineTree.addTreeNode(lineList);
    }
}