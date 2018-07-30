package Assembler;

public class Number extends Token {
    private int value;
    public Number(String name, int line) {
        super(name, line);
        try {
            this.value = convertToInt();
        }catch (AssemblerException e){
            e.AssemblerErrorHandle();
        }
    }

    private int convertToInt() throws AssemblerException {
        String name = getName();
        if(isValidToken()){
            return Integer.decode(name);
        }else {
            throw new AssemblerException("Lexical Error - invalid Token", getLine());
        }
    }

    public int getValue() {
        return value;
    }

    @Override
    public boolean isValidToken() {
        String name = getName();
        if (name.charAt(0) == '-'){ // negative values
            if(name.charAt(1) == '0' && name.charAt(2) == 'x'){ // negative hexadecimal values -0x00
                return name.substring(3).matches("[0-9]");
            }else { // negative decimal values -00
                return name.substring(1).matches("[0-9]");
            }
        }else { // positive values
            if(name.charAt(0) == '0' && name.charAt(1) == 'x'){ // positive hexadecimal values +0x00
                return name.substring(2).matches("[0-9]");
            }else{ // positive decimal values +00
                return name.matches("[0-9]");
            }
        }
    }
}
