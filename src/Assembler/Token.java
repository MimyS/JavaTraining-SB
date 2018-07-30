package Assembler;

public abstract class Token {
    private String name;
    private int line;

    Token(String name, int line) {
        this.name = name;
        this.line = line;
    }

    String getName() {
        return name;
    }

    int getLine() {
        return line;
    }

    public abstract boolean isValidToken();
}
