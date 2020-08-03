import java.util.Scanner;

class Main {
public static void main(String[] args) {
       
	Scanner scanner = new Scanner(System.in);
    	
	int n = scanner.nextInt();
	int nSquare = n * n;
	int[][] sudokuBoard = new int[nSquare][nSquare];
	int sum = 0;
	int sudokuRowSum = 0;
	boolean correct = true;
	int[][] flippedSudokuBoard = new int[nSquare][nSquare];
	int[][][] insideSquares = new int[nSquare][n][n];
	
	//Create Summation of n^2 
	for (int i = 0; i <= nSquare; i++) {
        sum += i;
    }
 
	//Create Sudoku Board
	for(int i=0; i < sudokuBoard.length; i++) {
		for(int j=0; j < sudokuBoard.length; j++) {
			sudokuBoard[i][j] = scanner.nextInt();
		}
	}
	
	//check that rows equal the sum
	for(int i=0; i < sudokuBoard.length; i++) {
		for(int j=0; j < sudokuBoard.length; j++) {
			sudokuRowSum += sudokuBoard[i][j];
		}
			
		if(sudokuRowSum != sum) {
			correct = false;
			break;
		}
		sudokuRowSum = 0;
	}
    
	
	
		//flip the board so all the columns become rows and insert into the new array flippedSudokuBoard 
		for(int k =0; k<sudokuBoard.length; k++) {
			for(int i =0; i< sudokuBoard.length; i++) {
				flippedSudokuBoard[k][i] = sudokuBoard[i][k];
			}
		}
		
		sudokuRowSum = 0;
		//check that the rows of flippedSudokuBoard equal the sum
		for(int i=0; i < flippedSudokuBoard.length; i++) {
			for(int j=0; j < flippedSudokuBoard.length; j++) {
				sudokuRowSum += flippedSudokuBoard[i][j];
			}
				
			if(sudokuRowSum != sum) {
				correct = false;
				break;
			}
			sudokuRowSum = 0;
		}
		
		
		//This is where I split the Sudoku Board into the separate square and 
		//place those squares into a 3d array called insideSquares
		int xSlider = 0;
		int ySlider = 0;
		for (int i=0; i < nSquare; i++) {
			//note that n is the input
			for (int j = 0; j < n; j++) {
				for (int k=0; k < n; k++) {
					insideSquares[i][j][k]=sudokuBoard[j+ySlider][k+xSlider];
					
				}
			}
			
			//Note that n is the user input
			//This is where I change the value of the sliders so that 
			if(xSlider+n<sudokuBoard.length) {
				xSlider += n;
			}else {
				xSlider =0;
				if(ySlider+n<sudokuBoard.length) {
					ySlider += n;
				}
			}
		}
	
		
//		This is where I compare each value to every other inside the smaller squares
//		Note that n is the user input
		for(int square=0; square<nSquare; square++) {
//			System.out.println("New Square");
			for(int row=0; row < n; row++) {
				for(int index =0; index < n; index++) {
					
							for(int row2 =0; row2 < n; row2++) {
								for(int index2 =0; index2<n; index2++) {
									
//									System.out.print(insideSquares[square][row][index]+"  Compared to   ");
//									System.out.print(insideSquares[square][row2][index2]);
//									if(index == index2 && row == row2) {
//										System.out.print("      Same index");
//									}
//									System.out.println();
									if(insideSquares[square][row][index]==insideSquares[square][row2][index2] && index != index2 && row != row2) {
										correct=false;
										break;
									}
									
								}
							}
					
					
					
				}
			}
		}
		
		
		//prints yes or no
		if(correct) {
			System.out.println("YES");
		}else {
			System.out.println("NO");
		}
	 
}//End Main Method
}//End Class


