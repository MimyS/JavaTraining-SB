package Assembler;

public class Directive extends Token {

    static final String[] directiveTable = {"section", "space", "const", "equ", "if",
                                "macro", "endmacro", "begin", "end", "public", "extern"};

    public Directive(String name, int line) {
        super(name, line);
    }

    @Override
    public boolean isValidToken() {
        for (String d: directiveTable) {
            if(d.equals(getName())){
                return true;
            }
        }
        return false;
    }

    public boolean isValidNumOp(int n){
        switch (getName()){
            case "section":
            case "const":
            case "equ":
            case "if":
                return (n == 1);
            case "space":
                return (n == 0 || n == 1);
            default:
                return (n == 0);
        }
    }

    public boolean needLabel(){
        switch (getName()){
            case "space":
            case "const":
            case "macro":
            case "equ":
            case "begin":
            case "extern":
                return true;
            default:
                return false;
        }
    }
}
