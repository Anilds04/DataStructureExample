package com.example.datastructureexample.programs


fun main() {

    val ticTocToeGame = TicTocToeGame()
    ticTocToeGame.startGame()

}

class TicTocToeGame {

    private val board = Array(3) { CharArray(3) { ' ' } }
    private var currentPlayer = 'X'

    fun startGame() {
        while (true) {
            printBoard()
            println("Player $currentPlayer your turn (row and col separated by space): ")
            val input = readLine()?.split(" ") ?: continue

            if (input.size != 2) {
                println("Invalid input, enter two numbers (row col).")
                continue
            }

            val row = input[0].toIntOrNull()
            val col = input[1].toIntOrNull()

            if (row == null || col == null ||  !isValidInput(row, col)) {
                println("Invalid move, try again.")
                continue
            }

            board[row][col] = currentPlayer

            if (checkWin()) {
                printBoard()
                println("Player $currentPlayer wins!")
                break
            }

            if (checkDraw()) {
                printBoard()
                println("The game is a draw.")
                break
            }

            updateCurrentPlayer()


        }
    }

    private fun updateCurrentPlayer(){
        currentPlayer = if (currentPlayer == 'X') 'O' else 'X'
    }

    private fun isValidInput(row: Int, col: Int): Boolean {
        return row in 0..2 && col in 0..2 && board[row][col] == ' '
    }


    private fun printBoard() {

        println("-----------")

        for (row in board) {
            print("| ")
            for (cell in row) {
                print("$cell | ")
            }

            println("\n-----------")
        }
    }


    private fun checkDraw(): Boolean {

       return board.all { row -> row.all { it != ' ' } }
    }


    private fun checkWin(): Boolean {

        for (i in 0 until board.size) {

            if ((board[i][0] == currentPlayer) &&
                (board[i][1] == currentPlayer) &&
                (board[i][2] == currentPlayer)

                ||

                ((board[0][i] == currentPlayer) &&
                        (board[1][i] == currentPlayer) &&
                        (board[2][i] == currentPlayer))
            ) return true

            if ((board[0][0] == currentPlayer) && (board[1][1] == currentPlayer) && (board[2][2] == currentPlayer)  ||
                    (board[0][2] == currentPlayer) && (board[1][1] == currentPlayer) && (board[2][0] == currentPlayer))
                return true

           /* val size = board[i].size

            val rowWins = (0 until size).all { j-> board[i][j] == currentPlayer  }

            val colWins = (0 until size).all { j-> board[j][i] == currentPlayer  }

            return rowWins || colWins*/


           // val diagonal = (0 until size).all { j-> board[i][j] }


        }

        return false
    }
}