import java.util.Stack;

public class TorreHanoiInterativa {
    public static void main(String[] args) {
        moveTorreIterativo(3, 'A', 'C', 'B');
    }

    public static void moveTorreIterativo(int n, char De, char para, char aux) {
        Stack<Character> stacks[] = new Stack[3];
        for (int i = 0; i < 3; i++) {
            stacks[i] = new Stack<>();
        }

        for (int i = n; i > 0; i--) {
            stacks[0].push(Character.forDigit(i, 10));
        }

        move(n, De, para, aux, stacks);
    }

    public static void move(int n, char De, char para, char aux, Stack<Character>[] stacks) {
        if (n == 1) {
            moveDisco(De, para, aux);
            stacks[para - 'A'].push(stacks[De - 'A'].pop());
            return;
        }

        move(n - 1, De, aux, para, stacks);
        moveDisco(De, para, aux);
        stacks[para - 'A'].push(stacks[De - 'A'].pop());
        move(n - 1, aux, para, De, stacks);
    }

    public static void moveDisco(char De, char para, char aux) {
        System.out.println("Movimento: " + De + " -> " + para);
    }
}