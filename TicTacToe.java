import java.util.Scanner;
public class TicTacToe {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);

        //We set a boolean variable gameOver false
        boolean gameOver = false;
        //Then we create the board and fill it with empty space
        char[][] board = new char[3][3];
        for(int i=0;i< board.length;i++){
            for(int j=0;j< board.length;j++){
                board[i][j] = ' ';
            }
        }
        //Thern we create a player variable and change it on every iteration
        char player = 'X';
        while(!gameOver){
            //First call the print board function to print the board
            printBoard(board);
            System.out.print("Player "+player+" turn:");

            //Then we give index of where to play the move
            int a =  scan.nextInt();
            int b =  scan.nextInt();

            //After that we will check if the entered index are empty or not
            if(board[a][b] == ' '){
                board[a][b] = player;
                //If yes then we will call the gameOver function to check if the game is over or not
                gameOver = haveWon(board,player);
                if(gameOver){
                    //If gameOver the print the board and the player who has won
                    System.out.println("Player "+player+" has won");
                    printBoard(board);
                }
                //if the game is not over we will change the player variable accordingly
                else{
                    if(player == 'X'){
                        player = 'O';
                    }
                    else{
                        player = 'X';
                    }
                    // short form => player = (player = 'X') ? 'O' : 'X';
                }
            }
            //if the entered index is not empty we will print error message
            else{
                System.out.println("Invalid Move");
            }
        }
    }
    public static boolean haveWon(char[][] board,char player){
        //Checking for winner
        for(int i=0;i<board.length;i++){
            //Row check
            if(board[i][0] == player && board[i][1] == player && board[i][2] == player){
                return true;
            }
            //column check
            if(board[0][i] == player && board[1][i] == player && board[2][i] == player){
                return true;
            }
            //diagonal
            if(board[0][0] == player && board[1][1] == player && board[2][2] == player ){
                return true;
            }
            if(board[0][2] == player&& board[2][0] == player){
                return true;
            }
        }
        return false;
    }
    public static void printBoard(char[][] board){
        for(int i=0;i< board.length;i++){
            for(int j=0;j< board.length;j++){
                System.out.print(board[i][j]+"\t|");
            }
            System.out.print("\n");
        }
    }

}
