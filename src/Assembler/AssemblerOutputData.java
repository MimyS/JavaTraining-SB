package Assembler;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AssemblerOutputData {
    private String fileNameOut;
    private char mode;
    private List<String> outputText = new ArrayList<>();

    public AssemblerOutputData(String fileNameOut, char mode) {
        this.mode = mode;
        switch (mode) {
            case 'p':
                this.fileNameOut = fileNameOut + ".pre";
                break;
            case 'm':
                this.fileNameOut = fileNameOut + ".mcr";
                break;
            case 'o':
                this.fileNameOut = fileNameOut + ".o";
                break;
            default:
                this.fileNameOut = fileNameOut;
        }
    }

    public void writeOutputFile(){
        try {
            FileWriter fileWriter = new FileWriter(fileNameOut);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            System.out.println("Writing file '" + this.fileNameOut + "' ...");
            if(mode == 'o'){
                for (String s:outputText) {
                    bufferedWriter.write(s);
                    bufferedWriter.write(' ');
                }
            }else{
                for (String s:outputText) {
                    bufferedWriter.write(s);
                    bufferedWriter.newLine();
                }
            }

        }catch (IOException e){
            System.out.println("Unable to create file '" + this.fileNameOut + "'");
        }
    }
}
