import javax.swing.text.html.parser.Parser;
import java.util.Scanner;

public class testeParser {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String expressao = sc.nextLine();

        parser p = new parser();
        p.parse(expressao);
    }
}
