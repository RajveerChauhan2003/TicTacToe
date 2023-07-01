import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        User User1 = new User();
        User User2 = new User();

        Scanner sc = new Scanner(System.in);

        char board[][] = new char[3][3];

        for(int i =0 ;i < board.length;i++){
            for(int j=0;j<board[0].length;j++){
                board[i][j]=' ';
            }
        }

        System.out.println("Hi there , " + "\n" + "Welcome to the TicTacToe game :\n\n"+"There are 2 markers :  0 and X .");

        boolean allGood = false;
        while(!allGood) {
            System.out.println("User1 , Choose your marker : ");
            User1.marker = sc.next();

            System.out.println("User2 , Choose your marker : ");
            User2.marker = sc.next();

            if(User1.marker.equals(User2.marker) ){
                System.out.println("ERROR : Markers cannot be same !! ");
                continue;
            }else{
                allGood=true;
            }

            if(!areMarkersInappropriate(User1.marker,User2.marker)){
                allGood=false;
                System.out.println("ERROR : Inappropriate Markers !!");
                continue;
            }

            System.out.println("Okay , So User1 is : " + User1.marker + " and User2 is : " + User2.marker);
        }


        boolean gameOver=false;
        int row,column,turn=1;
        while(!gameOver){
            displayBoard(board);

            if(turn==1) {
                System.out.println("User1 , Enter your move coordinates : ");
                row = sc.nextInt();
                column = sc.nextInt();

                if (board[row][column] == ' ') {
                    board[row][column] = User1.marker.charAt(0);
                    gameOver = haveWon(board, User1);
                    if (gameOver) {
                        displayBoard(board);
                        System.out.println("User1 has won !!");
                        continue;
                    }
                } else {
                    System.out.println("Current location filled try other.");
                    continue;
                }
                turn=2;
            }
            displayBoard(board);
            if(turn==2) {
                System.out.println("User2 , Enter your move coordinates : ");
                row = sc.nextInt();
                column = sc.nextInt();

                if (board[row][column] == ' ') {
                    board[row][column] = User2.marker.charAt(0);
                    gameOver = haveWon(board, User2);
                    if (gameOver) {
                        displayBoard(board);
                        System.out.println("User2 has won !!");
                        continue;
                    }
                }else {
                    System.out.println("Current location filled try other.");
                    continue;
                }
                turn=1;
            }
        }
    }

    private static boolean haveWon(char[][] board, User user) {
        int counter = 0;
        char marker = user.marker.charAt(0);

        // checking for rows
        for(int i =0 ;i < board.length;i++){
            if(board[i][0]==marker && board[i][1]==marker && board[i][2]==marker){
                return true;
            }
        }

        //checking for columns
        for(int i =0 ;i < board.length;i++){
            if(board[0][i]==marker && board[1][i]==marker && board[2][i]==marker){
                return true;
            }
        }

        //checking diagonally
        if(board[0][0]==marker && board[1][1]==marker && board[2][2]==marker){
            return true;
        }

        if(board[0][2]==marker && board[1][1]==marker && board[2][0]==marker){
            return true;
        }

        return false;
    }

    public static boolean areMarkersInappropriate(String marker1 , String marker2){
        return (marker1.equals("0") || marker1.equals("X")) && (marker2.equals("0") || marker2.equals("X"));
    }

    public static void displayBoard(char [][]board){
        for(int i =0 ;i < board.length;i++){
            for(int j=0;j<board[0].length;j++){
                System.out.print(board[i][j] + "|");
            }
            System.out.println();
        }
    }

}
