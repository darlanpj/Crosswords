import java.util.Random;


/**
 * Created by darlanpj on 22/01/2017.
 */
public class CrosswordCore {
	char[][] data;	//dados sem palavras com a solução
	char[][] dataF; //dados com palavras juntos

	
	public CrosswordCore(String[] wordList, int size) {
		data = new char[size][size];
		
		for(int i=0; i<data.length; i++)
			for(int j=0; j<data.length; j++)
				data[i][j] = ' ';
		
		for(String word : wordList) {
			add(word, data);
		}
		
		dataF = fill(data);
	}
	

	/*
	* Retorna o puzzle
	* */
	public String getPuzzle() {
		StringBuilder ret = new StringBuilder();

		for(int i=0; i<dataF.length; i++) {
			for(int j=0; j<dataF.length; j++) {
				ret.append(dataF[i][j]);
			}
			ret.append("\n");
		}

		return ret.toString();
	}

	/*
	* Retorna a solução do puzzle
	*
	* */
	public String getSolution() {
		StringBuilder ret = new StringBuilder();
		
		for(int i=0; i<data.length; i++) {
			for(int j=0; j<data.length; j++) {
				ret.append(data[i][j]);
			}
			ret.append("\n");
		}
		
		return ret.toString();
	}


	private boolean add(String word, char[][] puzzle) {
		word = word.toUpperCase();
		
		char[][] origPuzzle = new char[puzzle.length][puzzle.length];
		for(int i=0; i<puzzle.length; i++)
			for(int j=0; j<puzzle.length; j++)
				origPuzzle[i][j] = puzzle[i][j];
		
		for(int tries=0; tries<100; tries++) {
			Random r = new Random();

			int direction   = r.nextInt(2); // 0 = Horizontal, 1 = Vertical
			
			int row			= r.nextInt(puzzle.length - word.length());
			int col			= r.nextInt(puzzle.length - word.length());
			
			int i=0;
			for(i=0; i<word.length(); i++) {
				if(puzzle[row][col] == ' ' || puzzle[row][col] == word.charAt(i)) {
					puzzle[row][col] = word.charAt(i);
					
					if(direction == 0)
						col++;
					if(direction == 1)
						row++;
				} else {
					for(int j=i; j>0; j--) {
						if(direction == 0)
							col--;
						if(direction == 1)
							row--;
						
						puzzle[row][col] = origPuzzle[row][col]; 
					}
					break;
				}
			}
			if(--i > 0)
				return true;
		}
		return false;
	}

	//Preenche as palavras cruzadas
	private char[][] fill(char[][] puzzle) {
		char[][] ret = new char[puzzle.length][puzzle.length];
		FillChar r = new FillChar();
		
		for(int i=0; i<ret.length; i++) {
			for(int j=0; j<ret.length; j++) {
				if(puzzle[i][j] != ' ') {
					ret[i][j] = puzzle[i][j];
				} else {
					ret[i][j] = r.nextChar();
				}
			}
		}
		
		return ret;
	}
}
