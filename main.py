def imprimir_tablero(tablero):
    for fila in tablero:
        print(" | ".join(fila))
        print("-" * 9)

def verificar_ganador(tablero, jugador):
    # Verificar filas, columnas y diagonales
    for i in range(3):
        if all(tablero[i][j] == jugador for j in range(3)):
            return True
        if all(tablero[j][i] == jugador for j in range(3)):
            return True
    if all(tablero[i][i] == jugador for i in range(3)) or all(tablero[i][2 - i] == jugador for i in range(3)):
        return True
    return False

def jugar_tic_tac_toe():
    tablero = [[" " for _ in range(3)] for _ in range(3)]
    jugador_actual = "X"
    jugadas = 0

    while jugadas < 9:
        imprimir_tablero(tablero)
        print(f"Jugador {jugador_actual}, es tu turno.")
        fila = int(input("Elige una fila (0, 1, 2): "))
        columna = int(input("Elige una columna (0, 1, 2): "))

        if fila < 0 or fila > 2 or columna < 0 or columna > 2 or tablero[fila][columna] != " ":
            print("Movimiento inválido. Inténtalo de nuevo.")
            continue

        tablero[fila][columna] = jugador_actual
        jugadas += 1

        if verificar_ganador(tablero, jugador_actual):
            imprimir_tablero(tablero)
            print(f"¡Jugador {jugador_actual} ha ganado!")
            break

        jugador_actual = "O" if jugador_actual == "X" else "X"

    if jugadas == 9:
        imprimir_tablero(tablero)
        print("¡Es un empate!")

if __name__ == "__main__":
    jugar_tic_tac_toe()

