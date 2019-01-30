package minesweeper;

import java.util.Random;

public class Puzzle {
	
	private int difficulty = 0;
	private int numBombs;
	int[][] puzzle;
	
	public Puzzle(int rows, int cols, int difficulty) {
		
		puzzle = new int[rows][cols];
		
		generatePuzzle();
		refinePuzzle();
				
	}

	private void generatePuzzle() {
		
		int rows = puzzle.length;
		int cols = puzzle[0].length;
		
		switch (difficulty) {
		case 0:
			numBombs = 15;
			break;
		default:
			break;
		
		};
		
		Random rand = new Random();
		int bombsPlaced = 0;
		boolean isDone = false;
		
		while(!isDone) {
			for(int row = 0; row < rows; ++row) {
				for(int col = 0; col < cols; ++col) {
					
					if(bombsPlaced >= numBombs) {
						isDone = true;
					} else if (puzzle[row][col] == -1) {
						break;
					} else {
						int rn = rand.nextInt(100);
						if(rn < 5) {
							puzzle[row][col] = -1;
							bombsPlaced++;
						} else {
							puzzle[row][col] = 0;
						}
					}
				}
			}			
		}
	}
	
//TO-DO still need to extend this to work on the edges
	private void refinePuzzle() {
		for(int row = 0; row < puzzle.length; ++row) {
			for(int col = 0; col < puzzle[0].length; ++col) {
				if(puzzle[row][col] == -1) {
				
					//This is a bomb, now we need to add 1 around each spot
					for(int relativeRow = -1; relativeRow < 2; ++relativeRow) {
						for(int relativeCol = -1; relativeCol < 2; ++relativeCol) {
								if(!((row + relativeRow < 0)||(col + relativeCol < 0)||(row + relativeRow >= puzzle.length)||(col + relativeCol >= puzzle[0].length))) {
									if(puzzle[row + relativeRow][col + relativeCol] != -1) {
										++puzzle[row + relativeRow][col + relativeCol];
									}
								}
						}
					}
				}
			}
		}
	}

	public void printPuzzle() {
		
		for(int row = 0; row < puzzle.length; ++row) {
			for(int col = 0; col < puzzle[0].length; ++col) {
				
				System.out.print(puzzle[row][col] + " ");
				
			}
			
			System.out.println();
			
		}
		
	}

	public int[][] getPuzzle() {
		return puzzle;
	}
	
}
