import java.util.Scanner;

public class TheHeiganDance {

	public static class Player {
		public int x = 7;
		public int y = 7;
		public int health = 18500;

		public Player() {

		}
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int[][] chamber = new int[15][15];
		Player player = new Player();
		double bHealth = 3000000.00;
		double d = Double.parseDouble(scan.nextLine());
		String input;
		int dot = 0;
		int x, y;
		while (true) {
			bHealth -= d;
			if (bHealth <= 0) {
				if (dot != 0) {
					player.health -= 3500;
					dot = 0;
					if (player.health <= 0) {
						System.out.printf("Heigan: Defeated\n");
						System.out.println("Player: Killed by Plague Cloud");
						System.out.printf("Final position: %d, %d\n", player.x, player.y);
						break;
					} else {
						System.out.println("Heigan: Defeated!");
						System.out.println("Player: " + player.health);
						System.out.printf("Final position: %d, %d\n", player.x, player.y);
					}
				} else {
					System.out.println("Heigan: Defeated!");
					System.out.println("Player: " + player.health);
					System.out.printf("Final position: %d, %d\n", player.x, player.y);
				}
				break;
			} else {
				if(dot != 0) {
					player.health -= 3500;
					dot = 0;
				}
				input = scan.nextLine();
				String[] commands = input.split(" ");
				if (commands[0].equals(new String("Cloud"))) {
					//System.out.println("vlizam");
					x = Integer.parseInt(commands[1]);
					y = Integer.parseInt(commands[2]);
					if (isHit(x, y, player.x, player.y)) {
						// System.out.println("Shte udari");
						if (tryUp(x, y, player)) {
							player.y -= 1;
							//System.out.printf("Novite mi pozicio %d %d\n",player.x,player.y);
							// System.out.println("movnah");
							// System.out.printf("novite mi koordinati x = %d i
							// y = %d\n",player.x, player.y);
						} else if (tryRight(x, y, player)) {
							// System.out.println(player.x);
							player.x += 1;
							//System.out.printf("Novite mi pozicio %d %d\n",player.x,player.y);
							// System.out.println("movnah");
							// System.out.printf("novite mi koordinati x = %d i
							// y = %d\n",player.x, player.y);
						} else if (tryDown(x, y, player)) {
							player.y += 1;
							//System.out.printf("Novite mi pozicio %d %d\n",player.x,player.y);
							// System.out.println("movnah");
						} else if (tryLeft(x, y, player)) {
							player.x -= 1;
							//System.out.printf("Novite mi pozicio %d %d\n",player.x,player.y);
							// System.out.println("movnah");
						} else {
							//System.out.println("hitna ma");
							player.health -= 3500;
							//System.out.println(player.health);
							dot = 3500;
							if (player.health <= 0) {
								System.out.printf("Heigan: %.2f\n", bHealth);
								System.out.println("Player: Killed by Plague Cloud");
								System.out.printf("Final position: %d, %d\n", player.x, player.y);
								break;
							}
						}
					}
				} else if (commands[0].equals("Eruption")) {
					x = Integer.parseInt(commands[1]);
					y = Integer.parseInt(commands[2]);
					if (isHit(x, y, player.x, player.y)) {
						// System.out.println("Shte udari");
						if (tryUp(x, y, player)) {
							player.y -= 1;
							//System.out.printf("Novite mi pozicio %d %d\n",player.x,player.y);
							// System.out.println("movnah");
							// System.out.printf("novite mi koordinati x = %d i
							// y = %d\n",player.x, player.y);
						} else if (tryRight(x, y, player)) {
							// System.out.println(player.x);
							player.x += 1;
							//System.out.printf("Novite mi pozicio %d %d\n",player.x,player.y);
							// System.out.println("movnah");
							// System.out.printf("novite mi koordinati x = %d i
							// y = %d\n",player.x, player.y);
						} else if (tryDown(x, y, player)) {
							player.y += 1;
							//System.out.printf("Novite mi pozicio %d %d\n",player.x,player.y);
							// System.out.println("movnah");
						} else if (tryLeft(x, y, player)) {
							player.x -= 1;
							//System.out.printf("Novite mi pozicio %d %d\n",player.x,player.y);
							// System.out.println("movnah");
						} else {
							//System.out.println("hitna ma");
							
							player.health -= 6000;
							//System.out.println(player.health);
							if (player.health <= 0) {
								System.out.printf("Heigan: %.2f\n", bHealth);
								System.out.println("Player: Killed by Eruption");
								System.out.printf("Final position: %d, %d", player.x, player.y);
								break;
							}
						}
					}
				}
			}
		}
	}

	public static boolean isHit(int x, int y, int pX, int pY) {
		// if(arr[x][y] == 1 || arr[x+1][y] == 1 || arr[x-1][y] == 1 ||
		// arr[x][y+1] == 1 ||
		// arr[x][y-1] == 1 || arr[x-1][y-1] == 1 || arr[x+1][y-1] == 1 ||
		// arr[x-1][y+1] == 1 || arr[x+1][y+1] == 1) {
		if (x != pX && x + 1 != pX && x - 1 != pX) {
			return false;
		} else if (y != pY && y - 1 != pY && y + 1 != pY) {
			return false;
		} else {
			return true;
		}

	}

	public static boolean tryUp(int x, int y, Player player) {
		int pY = player.y - 1;
		int pX = player.x;
		if (!isHit(x, y, pX, pY)) {
			if (pY >= 0) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	public static boolean tryDown(int x, int y, Player player) {
		int pY = player.y + 1;
		int pX = player.x;
		if (!isHit(x, y, pX, pY)) {
			if (pY <= 14) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	public static boolean tryRight(int x, int y, Player player) {
		int pY = player.y;
		int pX = player.x + 1;
		if (!isHit(x, y, pX, pY)) {
			// System.out.println("tuka nqma da me hitne");
			if (pX <= 14) {
				return true;
			} else {
				return false;
			}
		} else {
			// System.out.println("hitva me");
			return false;
		}
	}

	public static boolean tryLeft(int x, int y, Player player) {
		int pY = player.y;
		int pX = player.x - 1;
		if (!isHit(x, y, pX, pY)) {
			if (pX >= 0) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

}
