import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {
        char[][] tablero = {
                {' ', ' ', ' '},
                {' ', ' ', ' '},
                {' ', ' ', ' '}
        };

        char jugadorActual = 'X';
        int jugadas = 0;
        boolean juegoEnCurso = true;

        while (juegoEnCurso) {
            imprimirTablero(tablero);
            System.out.println("Jugador " + jugadorActual + ", es tu turno.");
            int fila, columna;

            do {
                fila = obtenerEntrada("Fila (0, 1, 2): ");
                columna = obtenerEntrada("Columna (0, 1, 2): ");
            } while (tablero[fila][columna] != ' ');

            tablero[fila][columna] = jugadorActual;
            jugadas++;

            if (verificarGanador(tablero, jugadorActual)) {
                imprimirTablero(tablero);
                System.out.println("¡Jugador " + jugadorActual + " ha ganado!");
                juegoEnCurso = false;
            } else if (jugadas == 9) {
                imprimirTablero(tablero);
                System.out.println("¡Es un empate!");
                juegoEnCurso = false;
            }

            jugadorActual = (jugadorActual == 'X') ? 'O' : 'X';
        }
    }

    public static void imprimirTablero(char[][] tablero) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(tablero[i][j]);
                if (j < 2) {
                    System.out.print(" | ");
                }
            }
            System.out.println();
            if (i < 2) {
                System.out.println("---------");
            }
        }
    }

    public static int obtenerEntrada(String mensaje) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(mensaje);
        return scanner.nextInt();
    }

    public static boolean verificarGanador(char[][] tablero, char jugador) {
        for (int i = 0; i < 3; i++) {
            if (tablero[i][0] == jugador && tablero[i][1] == jugador && tablero[i][2] == jugador) {
                return true; // Verificar filas
            }
            if (tablero[0][i] == jugador && tablero[1][i] == jugador && tablero[2][i] == jugador) {
                return true; // Verificar columnas
            }
        }
        if (tablero[0][0] == jugador && tablero[1][1] == jugador && tablero[2][2] == jugador) {
            return true; // Verificar diagonal principal
        }
        if (tablero[0][2] == jugador && tablero[1][1] == jugador && tablero[2][0] == jugador) {
            return true; // Verificar diagonal secundaria
        }
        return false;
    }
}
