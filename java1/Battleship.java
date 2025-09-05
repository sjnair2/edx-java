import java.util.InputMismatchException;
import java.util.Scanner;
public class Battleship {
	public static void main(String[] args) {
		System.out.println("Welcome to Battleship!\n");
		char [][][] boards = {createBoard(), createBoard()};
		char [][][] shotBoards = {createBoard(), createBoard()};
		Scanner scanner = new Scanner(System.in);

		for (int i=0; i<2; i++){
			System.out.println("PLAYER "+(i+1)+", ENTER YOUR SHIPS' COORDINATES.");
			setupBoard(scanner, boards[i]);
			printBattleShip(boards[i]);
			for (int j=0; j<100; j++)
				System.out.println("");
		}

		boolean keepGoing=true;
		do {
			for (int i=0; i<2; i++){
				fire(scanner, boards[(i+1)%2], shotBoards[i], i);
				printBattleShip(shotBoards[i]);
				keepGoing=checkAlive(boards[(i+1)%2]);
				if (!keepGoing){
					System.out.println("PLAYER "+(i+1)+" WINS! YOU SUNK ALL OF YOUR OPPONENT'S SHIPS!\n");
					break;
				}
				System.out.println();
			}
		} while (keepGoing);

		System.out.println("Final boards:\n");
		printBattleShip(boards[0]);
		System.out.println("");
		printBattleShip(boards[1]);


		scanner.close();
		
	}

	// Use this method to print game boards to the console.
	private static void printBattleShip(char[][] player) {
		System.out.print("  ");
		for (int row = -1; row < 5; row++) {
			if (row > -1) {
				System.out.print(row + " ");
			}
			for (int column = 0; column < 5; column++) {
				if (row == -1) {
					System.out.print(column + " ");
				} else {
					System.out.print(player[row][column] + " ");
				}
			}
			System.out.println("");
		}
	}

	private static char[][] createBoard() {
		char[][] board={{'-','-','-','-','-'},
						{'-','-','-','-','-'},
						{'-','-','-','-','-'},
						{'-','-','-','-','-'},
						{'-','-','-','-','-'}};
		return board;
	}

	private static void setupBoard(Scanner scanner, char[][] board) {
		int r; int c; int i=1;
		do {
			System.out.println("Enter ship "+i+" location:");
			try {
				r = scanner.nextInt();
				c = scanner.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("Invalid coordinates. Choose different coordinates.");
				continue;
			}
			if (r < 0 | r > 4 | c < 0 | c > 4) {
				System.out.println("Invalid coordinates. Choose different coordinates.");
				continue;
			}
			if (board[r][c]!='-') {
				System.out.println("You already have a ship there. Choose different coordinates.");
				continue;				
			}
			board[r][c] = '@';
			i+=1;
		} while (i<=5);
	}

	private static void fire(Scanner scanner, char[][] opponentBoard, char[][] shotBoard, int id) {
		int r; int c; boolean repeat=true;
		do {
			System.out.println("Player "+(id+1)+", enter hit row/column:");
			try {
				r = scanner.nextInt();
				c = scanner.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("Invalid coordinates. Choose different coordinates.");
				continue;
			}
			if (r < 0 | r > 4 | c < 0 | c > 4) {
				System.out.println("Invalid coordinates. Choose different coordinates.");
				continue;
			}
			if (shotBoard[r][c]!='-') {
				System.out.println("You already fired on this spot. Choose different coordinates.");
				continue;				
			}
			repeat=false;
			if (opponentBoard[r][c]=='@'){
				opponentBoard[r][c]='X';
				shotBoard[r][c]='X';
				System.out.println("PLAYER "+(id+1)+" HIT PLAYER "+((id+1)%2+1)+"'s SHIP!");
			}
			else {
				opponentBoard[r][c]='O';
				shotBoard[r][c]='O';
				System.out.println("PLAYER "+(id+1)+" MISSED!");
			}
		} while (repeat);
	}

	private static boolean checkAlive(char[][] board){
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == '@') {
                    return true;
                }
            }
        }
        return false; 
	}
}