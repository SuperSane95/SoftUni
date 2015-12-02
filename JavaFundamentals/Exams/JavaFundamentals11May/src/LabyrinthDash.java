import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LabyrinthDash {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int playerX = 0;
		int playerY = 0;
		int n = Integer.parseInt(scan.nextLine());
		int playerLives = 3;
		int totalMoves = 0;
		boolean isAlive = true;
		List<char[]> matrix = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			char[] line = scan.nextLine().toCharArray();
			matrix.add(line);
		}
		char[] moves = scan.nextLine().toCharArray();
		char cell;

		for (int i = 0; i < moves.length; i++) {
			if (isAlive) {
				
				
				if (moves[i] == '^') {
					if (playerY == 0) {
						System.out.println("Fell off a cliff! Game Over!");
						totalMoves++;
						isAlive = false;
					} else {
						cell = matrix.get(playerY - 1)[playerX];
						switch (cell) {
						case '_':
							System.out.println("Bumped a wall.");
							break;

						case '|':
							System.out.println("Bumped a wall.");
							break;
						case '@':
							playerLives--;
							playerY--;
							totalMoves++;
							if(isAlive(playerLives)) {
								System.out.println("Ouch! That hurt! Lives left: " + playerLives);
							} else {
								System.out.println("Ouch! That hurt! Lives left: " + playerLives);
								System.out.println("No lives left! Game Over!");
								isAlive = false;
							}
							
							break;

						case '#':
							playerLives--;
							playerY--;
							totalMoves++;
							if(isAlive(playerLives)) {
								System.out.println("Ouch! That hurt! Lives left: " + playerLives);
							} else {
								System.out.println("Ouch! That hurt! Lives left: " + playerLives);
								System.out.println("No lives left! Game Over!");
								isAlive = false;
							}
							break;

						case '*':
							playerLives--;
							playerY--;
							totalMoves++;
							if(isAlive(playerLives)) {
								System.out.println("Ouch! That hurt! Lives left: " + playerLives);
							} else {
								System.out.println("Ouch! That hurt! Lives left: " + playerLives);
								System.out.println("No lives left! Game Over!");
								isAlive = false;
							}
							break;

						case '$':
							matrix.get(playerY - 1)[playerX] = '.';
							playerLives++;
							playerY--;
							cell = '.';
							totalMoves++;
							System.out.println("Awesome! Lives left: " + playerLives);
							break;

						case '.':
							playerY--;
							totalMoves++;
							System.out.println("Made a move!");
							break;

						case ' ':
							System.out.println("Fell off a cliff! Game Over!");
							totalMoves++;
							isAlive = false;
							break;
						default:
							break;
						}
					}
				}
				
				else if (moves[i] == 'v') {
					if (playerY == n-1) {
						System.out.println("Fell off a cliff! Game Over!");
						totalMoves++;
						isAlive = false;
					} else {
						cell = matrix.get(playerY+1)[playerX];
						switch (cell) {
						
						case '_':
							System.out.println("Bumped a wall.");
							break;

						case '|':
							System.out.println("Bumped a wall.");
							break;
							
						case '@':
							playerLives--;
							playerY++;
							totalMoves++;
							if(isAlive(playerLives)) {
								System.out.println("Ouch! That hurt! Lives left: " + playerLives);
							} else {
								System.out.println("Ouch! That hurt! Lives left: " + playerLives);
								System.out.println("No lives left! Game Over!");
								isAlive = false;
							}
							break;

						case '#':
							playerLives--;
							playerY++;
							totalMoves++;
							if(isAlive(playerLives)) {
								System.out.println("Ouch! That hurt! Lives left: " + playerLives);
							} else {
								System.out.println("Ouch! That hurt! Lives left: " + playerLives);
								System.out.println("No lives left! Game Over!");
								isAlive = false;
							}
							break;

						case '*':
							playerLives--;
							playerY++;
							totalMoves++;
							if(isAlive(playerLives)) {
								System.out.println("Ouch! That hurt! Lives left: " + playerLives);
							} else {
								System.out.println("Ouch! That hurt! Lives left: " + playerLives);
								System.out.println("No lives left! Game Over!");
								isAlive = false;
							}
							break;

						case '$':
							matrix.get(playerY+1)[playerX] = '.';
							playerLives++;
							playerY++;
							cell = '.';
							totalMoves++;
							System.out.println("Awesome! Lives left: " + playerLives);
							break;

						case '.':
							playerY++;
							totalMoves++;
							System.out.println("Made a move!");
							break;

						case ' ':
							System.out.println("Fell off a cliff! Game Over!");
							totalMoves++;
							isAlive = false;
							break;
						default:
							break;
						}
					}
				}
				
				else if (moves[i] == '<') {
					if (playerX == 0) {
						System.out.println("Fell off a cliff! Game Over!");
						totalMoves++;
						isAlive = false;
					} else {
						cell = matrix.get(playerY)[playerX - 1];
						switch (cell) {
						case '_':
							System.out.println("Bumped a wall.");
							break;

						case '|':
							System.out.println("Bumped a wall.");
							break;
						case '@':
							playerLives--;
							playerX--;
							totalMoves++;
							if(isAlive(playerLives)) {
								System.out.println("Ouch! That hurt! Lives left: " + playerLives);
							} else {
								System.out.println("Ouch! That hurt! Lives left: " + playerLives);
								System.out.println("No lives left! Game Over!");
								isAlive = false;
							}
							break;

						case '#':
							playerLives--;
							playerX--;
							totalMoves++;
							if(isAlive(playerLives)) {
								System.out.println("Ouch! That hurt! Lives left: " + playerLives);
							} else {
								System.out.println("Ouch! That hurt! Lives left: " + playerLives);
								System.out.println("No lives left! Game Over!");
								isAlive = false;
							}
							break;

						case '*':
							playerLives--;
							playerX--;
							totalMoves++;
							if(isAlive(playerLives)) {
								System.out.println("Ouch! That hurt! Lives left: " + playerLives);
							} else {
								System.out.println("Ouch! That hurt! Lives left: " + playerLives);
								System.out.println("No lives left! Game Over!");
								isAlive = false;
							}
							break;

						case '$':
							matrix.get(playerY)[playerX - 1] = '.';
							playerLives++;
							playerX--;
							cell = '.';
							totalMoves++;
							System.out.println("Awesome! Lives left: " + playerLives);
							break;

						case '.':
							playerX--;
							totalMoves++;
							System.out.println("Made a move!");
							break;

						case ' ':
							System.out.println("Fell off a cliff! Game Over!");
							totalMoves++;
							isAlive = false;
							break;
						default:
							break;
						}
					}
				}
				
				else if (moves[i] == '>') {
					if (playerX == matrix.get(playerY).length - 1) {
						System.out.println("Fell off a cliff! Game Over!");
						totalMoves++;
						isAlive = false;
					} else {
						cell = matrix.get(playerY)[playerX + 1];
						switch (cell) {
						case '_':
							System.out.println("Bumped a wall.");
							break;

						case '|':
							System.out.println("Bumped a wall.");
							break;
						case '@':
							playerLives--;
							playerX++;
							totalMoves++;
							if(isAlive(playerLives)) {
								System.out.println("Ouch! That hurt! Lives left: " + playerLives);
							} else {
								System.out.println("Ouch! That hurt! Lives left: " + playerLives);
								System.out.println("No lives left! Game Over!");
								isAlive = false;
							}
							break;

						case '#':
							playerLives--;
							playerX++;
							totalMoves++;
							if(isAlive(playerLives)) {
								System.out.println("Ouch! That hurt! Lives left: " + playerLives);
							} else {
								System.out.println("Ouch! That hurt! Lives left: " + playerLives);
								System.out.println("No lives left! Game Over!");
								isAlive = false;
							}
							break;

						case '*':
							playerLives--;
							playerX++;
							totalMoves++;
							if(isAlive(playerLives)) {
								System.out.println("Ouch! That hurt! Lives left: " + playerLives);
							} else {
								System.out.println("Ouch! That hurt! Lives left: " + playerLives);
								System.out.println("No lives left! Game Over!");
								isAlive = false;
							}
							break;

						case '$':
							matrix.get(playerY)[playerX + 1] = '.';
							playerLives++;
							playerX++;
							cell = '.';
							totalMoves++;
							System.out.println("Awesome! Lives left: " + playerLives);
							break;

						case '.':
							playerX++;
							totalMoves++;
							System.out.println("Made a move!");
							break;

						case ' ':
							System.out.println("Fell off a cliff! Game Over!");
							totalMoves++;
							isAlive = false;
							break;
						default:
							break;
						}
					}
				}
				
			} else {
				break;
			}

		}
		System.out.println("Total moves made: " + totalMoves);

	}
	
	public static boolean isAlive(int playerLives) {
		if (playerLives <= 0) {
			return false;
		} else {
			return true;
		}
	}

}
