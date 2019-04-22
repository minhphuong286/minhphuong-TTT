package TicTac;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Tictactoe {
	private static Scanner in;
	private static String[] board;
	private static String turn;

	public static void main(String[] args) {
		in = new Scanner(System.in);
		board = new String[9];
		turn = "X";
		String winner = null;
		populateEmptyBoard();

		System.out.println("Chao mung den voi TIC TAC TOE!");
		System.out.println("--------------------------------");
		printBoard();
		System.out.print("X se di truoc. Vui long chon mot o trong bang: ");
		
		while (winner == null) {
			int numInput;
			try {
				numInput = in.nextInt();
				if (!(numInput > 0 && numInput <= 9)) {
					System.out.print("Chon sai so o, vui long chon lai: ");
					continue;
				}
			} catch (InputMismatchException e) {
				System.out.print("Sai luat choi, vui long khoi dong lai!");
				break;
			}
			if (board[numInput-1].equals(String.valueOf(numInput))) {   
				board[numInput-1] = turn;
				if (turn.equals("X")) {
					turn = "O";
				} else {
					turn = "X";
				}
				printBoard();
				winner = checkWinner();
			} else {
				System.out.println("O da duoc chon, vui long chon lai: ");
				continue;
			}
		}
//		Phan ket thuc và ket luan ket qua cuoi cung
		if (winner.equalsIgnoreCase("draw")) {
			System.out.println("Hai ben hoa nhau! Cam on va hen gap lai.");
		} else {
			System.out.println("Xin chuc mung! " + winner + " da thang! Cam on va hen gap lai.");
		}
	}
// 	Ham kiem tra va tim nguoi thang
	public static String checkWinner() {
		for (int a = 0; a < 8; a++) {
			String line = null;
			switch (a) {
			case 0:
				line = board[0] + board[1] + board[2];
				break;
			case 1:
				line = board[3] + board[4] + board[5];
				break;
			case 2:
				line = board[6] + board[7] + board[8];
				break;
			case 3:
				line = board[0] + board[3] + board[6];
				break;
			case 4:
				line = board[1] + board[4] + board[7];
				break;
			case 5:
				line = board[2] + board[5] + board[8];
				break;
			case 6:
				line = board[0] + board[4] + board[8];
				break;
			case 7:
				line = board[2] + board[4] + board[6];
				break;
			}
//			Ap dung luat TIC TAC TOE de tim nguoi thang
			if (line.equals("XXX")) {
				return "X";
			} else if (line.equals("OOO")) {
				return "O";
			}
		}
//		Truong hop hai ben hoa nhau
		for (int a = 0; a < 9; a++) {
			if (Arrays.asList(board).contains(String.valueOf(a+1))) {
				break;
			}
			else if (a == 8) return "draw";
		}

		System.out.print("Den luot " + turn + ", chon 1 o trong bang: ");
		return null;
	}
//	Ham in bang game
	public static void printBoard() {
		System.out.println("\\---|---|---//");
		System.out.println("| " + board[0] + " | " + board[1] + " | " + board[2] + " |");
		System.out.println("|-----------|");
		System.out.println("| " + board[3] + " | " + board[4] + " | " + board[5] + " |");
		System.out.println("|-----------|");
		System.out.println("| " + board[6] + " | " + board[7] + " | " + board[8] + " |");
		System.out.println("//---|---|---\\");
	}
//	Ham khoi tao ban dau
	public static void populateEmptyBoard() {
		for (int a = 0; a < 9; a++) {
			board[a] = String.valueOf(a+1);
		}
	}

}
