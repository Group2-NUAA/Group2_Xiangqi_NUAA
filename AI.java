import java.util.Stack;

public class AI {
	private final class move{
		int score, label, x, y;
		public move(int _score, int _label, int _x, int _y) {
			score = _score;
			label = _label;
			x = _x;
			y = _y;
		}
		public move copy() {
			return new move(score, label, x, y);
		}
		public String ToString() {
			return String.valueOf(label) + " " + String.valueOf(x) + " " +String.valueOf(y);
		}
	}
	private final class pos{
		int x, y;
		private boolean Killed;
		public pos(int _x, int _y) {
			x = _x;
			y = _y;
			Killed = false;
		}
		public void Killed() {
			Killed = true;
		}
		public boolean isKilled() {
			return Killed;
		}
	}
	private final class situation {
		int[][] board = null;
		public situation(int[][] _board) {
			DeepCopy(board, _board);
		}
	}
	private final int[][] initialSituation = {  { 0, 4, 8,12,30,13, 9, 5, 1},
												{-1,-1,-1,-1,-1,-1,-1,-1,-1},
												{-1,26,-1,-1,-1,-1,-1,27,-1},
												{16,-1,17,-1,18,-1,19,-1,20},
												{-1,-1,-1,-1,-1,-1,-1,-1,-1},
												{-1,-1,-1,-1,-1,-1,-1,-1,-1},
												{21,-1,22,-1,23,-1,24,-1,25},
												{-1,28,-1,-1,-1,-1,-1,29,-1},
												{-1,-1,-1,-1,-1,-1,-1,-1,-1},
												{ 2, 6,10,14,31,15,11, 7, 3} };
	private final int[] Value = {48, 48, 48, 48,//ju
								 32, 32, 32, 32,//ma
								 12, 12, 12, 12,//xiang
								 16, 16, 16, 16,//shi
								 4, 4, 4, 4, 4,//bing
								 4, 4, 4, 4, 4,//bing
								 40, 40, 40, 40,//pao
								 65536, 65536//shuai
								 };
	private final boolean[] Enemy = {false, false, true, true,//ju
									 false, false, true, true,//ma
									 false, false, true, true,//xiang
									 false, false, true, true,//shi
									 false, false, false, false, false,//bing
									 true, true, true, true, true,//bing
									 false, false, true, true,//pao
									 false, true//shuai
									 };
	private final int[][] ShiAccess={{-1,-1},{1,-1},{1,1},{-1,1}};
	private final int[][] XiangAccess={{-2,-2},{ 2,-2}, {2,2}, {-2,2}};
	private final int[][] XiangYan={{-1,-1},{1,-1},{1,1},{-1,1}};
	private final int[][] MaAccess={{-2,-1},{-1,-2},{-2,1},{-1,2},{1,2},{2,1},{2,-1},{1,-2}};
	private final int[][] MaTui={{-1,0},{0,-1},{-1,0},{0,1},{0,1},{1,0},{1,0},{0,-1}};
	private final int[][] ShuaiAccess = {{-1,0},{1,0},{0,-1},{0,1}};
	private final int maxHeight = 8;
	private final int maxLength = 9;
	private final int minNinePatchHeight = 0;
	private final int maxNinePatchHeight = 2;
	private final int minNinePatchLength = 3;
	private final int maxNinePatchLength = 5;
	private final int lowerBoundScore = -65536 * 2;
	private pos[] Poses = null;
	private Stack<situation> Situations;
	private int[][] currentSituation = null;
	
	AI() {
		Situations.push(new situation(initialSituation));
		
		currentSituation = new int[maxHeight][maxLength];
		DeepCopy(currentSituation,initialSituation);
		
		for(int i = 0; i < maxHeight; i++){
			for(int j = 0; j < maxLength; j++){
				if (initialSituation[i][j] == -1) continue;
				int curLabel = initialSituation[i][j];
				Poses[curLabel] = new pos(i, j);
			}
		}
	}
	
	private void DeepCopy(int[][] to, int[][] from) {
		for(int i = 0; i < maxHeight; i++){
			for(int j = 0; j < maxLength; j++){
				to[i][j] = from[i][j];
			}
		}
	}
	private void Move(int chessLabel, int x, int y) {
		pos curPos = Poses[chessLabel];
		currentSituation[curPos.x][curPos.y] = -1;
		int aimLabel = currentSituation[x][y];
		if (aimLabel != -1) Poses[aimLabel].Killed();
		currentSituation[x][y] = chessLabel;
		Poses[chessLabel].x = x;
		Poses[chessLabel].y = y;
		
		Situations.push(new situation(currentSituation));
	}

	private void Move(move maxMove) {
		Move(maxMove.label, maxMove.x, maxMove.y);
		
	}
	private boolean isEnemy(int label) {return Enemy[label];}
	private boolean canEat(int label) {return Enemy[label] && !isKilled(label);}
	private boolean isKilled(int label) {return Poses[label].isKilled();}
	
	public String NextMove(int chessLabel, int x, int y) {
		Move(chessLabel, x, y);
		move maxMove = new move(lowerBoundScore, 0, 0, 0);
		
		for (int label = 0; label < 32; label++) {
			if (isEnemy(label) || isKilled(label)) continue;
			move curMove = Search(label);
			if (curMove.score > maxMove.score) {
				maxMove = curMove.copy();
			}
		}
		Move(maxMove);
		return maxMove.ToString();
	}

	private move Search(int label) {
		int x = Poses[label].x;
		int y = Poses[label].y;
		int tempX, tempY;
		int checkX, checkY;
		switch (label) {
		case 0:
		case 1:
			move juMove = new move(lowerBoundScore, label, x, y);
			tempX = x + 1;
			while (legal(tempX, y)) {
				if (canEat(currentSituation[tempX][y])){
					if (Value[currentSituation[tempX][y]] > juMove.score) {
						juMove.score = Value[currentSituation[tempX][y]];
						juMove.x = tempX;
						juMove.y = y;
					}
					break;
				}
				tempX++;
			}
			tempX = x - 1;
			while (legal(tempX, y)) {
				if (canEat(currentSituation[tempX][y])){
					if (Value[currentSituation[tempX][y]] > juMove.score) {
						juMove.score = Value[currentSituation[tempX][y]];
						juMove.x = tempX;
						juMove.y = y;
					}
					break;
				}
				tempX--;
			}
			tempY = y + 1;
			while (legal(x, tempY)) {
				if (canEat(currentSituation[x][tempY])){
					if (Value[currentSituation[x][tempY]] > juMove.score) {
						juMove.score = Value[currentSituation[x][tempY]];
						juMove.x = x;
						juMove.y = tempY;
					}
					break;
				}
				tempY++;
			}
			tempY = y - 1;
			while (legal(x, tempY)) {
				if (canEat(currentSituation[x][tempY])){
					if (Value[currentSituation[x][tempY]] > juMove.score) {
						juMove.score = Value[currentSituation[x][tempY]];
						juMove.x = x;
						juMove.y = tempY;
					}
					break;
				}
				tempY--;
			}
			return juMove;
			
		case 4:
		case 5:
			move maMove = new move(lowerBoundScore, label, x, y);
			for(int i = 0; i < 8; i++) {
				checkX = x + MaTui[i][0];
				checkY = y + MaTui[i][1];
				if (currentSituation[checkX][checkY] != -1) continue;
				tempX = x + MaAccess[i][0];
				tempY = y + MaAccess[i][1];
				if (legal(tempX, tempY) && canEat(currentSituation[tempX][tempY])){
					maMove.score = Value[currentSituation[tempX][tempY]];
					maMove.x = tempX;
					maMove.y = tempY;
				}
			}
			return maMove;
			
		case 8:
		case 9:
			move xiangMove = new move(lowerBoundScore, label, x, y);
			for(int i = 0; i < 4; i++) {
				checkX = x + XiangYan[i][0];
				checkY = y + XiangYan[i][1];
				if (currentSituation[checkX][checkY] != -1) continue;
				tempX = x + XiangAccess[i][0];
				tempY = y + XiangAccess[i][1];
				if (legal(tempX, tempY) && canEat(currentSituation[tempX][tempY])){
					xiangMove.score = Value[currentSituation[tempX][tempY]];
					xiangMove.x = tempX;
					xiangMove.y = tempY;
				}
			}
			return xiangMove;
			
		case 12:
		case 13:
			move shiMove = new move(lowerBoundScore, label, x, y);
			for(int i = 0; i < 4; i++) {
				tempX = x + ShiAccess[i][0];
				tempY = y + ShiAccess[i][1];
				if (NinePatchlegal(tempX, tempY) && canEat(currentSituation[tempX][tempY])){
					shiMove.score = Value[currentSituation[tempX][tempY]];
					shiMove.x = tempX;
					shiMove.y = tempY;
				}
			}
			return shiMove;
		case 30:
			move shuaiMove = new move(lowerBoundScore, label, x, y);
			for(int i = 0; i < 4; i++) {
				tempX = x + ShuaiAccess[i][0];
				tempY = y + ShuaiAccess[i][1];
				if (NinePatchlegal(tempX, tempY) && canEat(currentSituation[tempX][tempY])){
					shuaiMove.score = Value[currentSituation[tempX][tempY]];
					shuaiMove.x = tempX;
					shuaiMove.y = tempY;
				}
			}
			return shuaiMove;
		case 16:
		case 17:
		case 18:
		case 19:
		case 20:
			if (legal(x + 1, y) && canEat(currentSituation[x + 1][y])){
				return new move(Value[currentSituation[x + 1][y]], label, x-1, y);
			}
		default: return new move(lowerBoundScore, label, x, y);
		}
	}

	private boolean NinePatchlegal(int x, int y) {
		return minNinePatchHeight <= x && x <= maxNinePatchHeight
				&& minNinePatchLength <= y && y <= maxNinePatchLength
				&& (currentSituation[x][y] == -1 || isEnemy(currentSituation[x][y]));
	}

	private boolean legal(int x, int y) {
		return 0 <= x && x <= maxHeight && 0 <= y && y <= maxLength
			&& (currentSituation[x][y] == -1 || isEnemy(currentSituation[x][y]));
	}

	public void Regret() {
		if (Situations.peek().board == initialSituation) return;
		Situations.pop();
		Situations.pop();
		assert !Situations.empty() : "WTF";
		DeepCopy(currentSituation,Situations.peek().board);
		currentSituation = Situations.peek().board;
		for(int i = 0; i < maxHeight; i++){
			for(int j = 0; j < maxLength; j++){
				if (currentSituation[i][j] == -1) continue;
				int curLabel = currentSituation[i][j];
				Poses[curLabel].x = i;
				Poses[curLabel].y = j;
			}
		}
		return;
	}
}

