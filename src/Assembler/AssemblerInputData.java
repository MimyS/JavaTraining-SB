package Assembler;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class AssemblerInputData {
    private char mode;
//    private String fileNameIn;
    private List<String> textAsm;

    public AssemblerInputData(char mode, String fileNameIn) throws Exception {
        if(!List.of('p', 'm', 'o').contains(mode)){
            throw new Exception("Invalid assembler operation mode");
        }
        this.mode = mode;

        fileNameIn = fileNameIn + ".asm";


        try {
            String line;
            FileReader fileReader = new FileReader(fileNameIn);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            this.textAsm = new ArrayList<>();

            System.out.println("Reading file '" + fileNameIn + "' ...");

            while((line = bufferedReader.readLine()) != null) {
                if(line.length() > 1){
                    textAsm.add(line);
                }
            }

            bufferedReader.close();

        }catch(FileNotFoundException ex) {
            System.out.println("Unable to open file '" + fileNameIn + "'");
        }
    }

    public char getMode() {
        return mode;
    }

    public List<String> getTextAsm() {
        return new ArrayList<>(textAsm);
    }

}
