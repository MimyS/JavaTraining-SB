package Assembler;

import javafx.util.Pair;
import java.util.ArrayList;
import java.util.List;

public class AssemblerException extends Throwable {

    static private List<Pair<Integer, String>> errorLog = new ArrayList<>();
    private String message;
    private int line;

    AssemblerException(String message, int line) {
        this.message = message;
        this.line = line;
    }

    void AssemblerErrorHandle(){
        errorLog.add(new Pair<>(line, message));
    }

    public static List<String> formatErrorLog(){
        List<String> output = new ArrayList<>();
        if(!errorLog.isEmpty()){
            for (Pair<Integer, String> p: errorLog) {
                output.add("Line " + p.getKey() + ": " + p.getValue());
            }
        }
        return output;
    }
}
