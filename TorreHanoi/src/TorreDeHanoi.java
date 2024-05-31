import java.util.function.BiConsumer;

public class TorreDeHanoi {

    public static void moveTorre(int numDiscos, char torreOrigem, char torreAuxiliar, char torreDestino, BiConsumer<Integer, Character> action) {
        if (numDiscos == 1) {
            action.accept(numDiscos, torreOrigem);
        } else {
            moveTorre(numDiscos - 1, torreOrigem, torreDestino, torreAuxiliar, action);
            action.accept(numDiscos, torreOrigem);
            moveTorre(numDiscos - 1, torreAuxiliar, torreOrigem, torreDestino, action);
        }
    }


    public static void moveDisco(char De, char para, char aux) {
        System.out.println("Movimento: " + De + " -> " + para);
    }
}