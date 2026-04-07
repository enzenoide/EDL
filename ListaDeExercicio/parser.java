import java.util.Scanner;

public class parser {
    public void parse(String expressao) throws expInvalida {
        PilhaArray pilha = new PilhaArray(10, 0);
        for (int i = 0; i < expressao.length(); i++) {
            char c = expressao.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                pilha.push(c);
            } else {
                if (c == ')') {
                    if (expressao.charAt(i - 1) == '(') {
                        pilha.pop();
                        pilha.pop();
                    } else {
                        throw new expInvalida("Expressao inválida");
                    }
                } else if (c == ']') {
                    if (expressao.charAt(i - 1) == '[') {
                        pilha.pop();
                        pilha.pop();
                    } else {
                        throw new expInvalida("Expressao inválida");
                    }
                } else if (c == '}') {
                    if (expressao.charAt(i - 1) == '{') {
                        pilha.pop();
                        pilha.pop();
                    } else {
                        throw new expInvalida("Expressao inválida");
                    }
                }
            }
        }
    }
}