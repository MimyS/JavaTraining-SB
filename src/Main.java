import Assembler.*;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        System.out.println("Start processing...");
        try {
            AssemblerInputData input = new AssemblerInputData(args[0].charAt(1), args[1]);
            AssemblerOutputData output = new AssemblerOutputData(args[2], input.getMode());
            List<String> errorLog = AssemblerException.formatErrorLog();
            if(errorLog.isEmpty()){
                output.writeOutputFile();
            }else{
                for (String s: errorLog) {
                    System.out.println(s);
                }
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
