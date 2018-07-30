package Assembler;

import javafx.util.Pair;
import java.util.List;

public class Label extends Token{

    static private List<Pair<String, Integer>> symbolTabel;

    public Label(String name, int line) {
        super(name, line);
    }

    void addNewLabel() throws AssemblerException {
        if(isNewLabel()){
            symbolTabel.add(new Pair<> (getName(), getLine()));
        }else{
            throw new AssemblerException("Syntactic Error - Label redefinition", getLine());
        }
    }

    private boolean isNewLabel(){
        String name = getName();
        for (Pair<String, Integer> s: symbolTabel) {
            if(s.getKey().equals(name)){
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean isValidToken() {
        String name = getName();
        if (name.charAt(0) >= 'a' && name.charAt(0) <= 'z'){
            for (String d: Directive.directiveTable) {
                if(d.equals(name)){
                    return false;
                }
            }
            return true;
        }else {
            return false;
        }
    }
}
