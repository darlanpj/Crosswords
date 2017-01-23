import java.util.Random;

/**
 * Created by darlanpj on 22/01/2017.
 */
public class FillChar {
	private Random r = new Random();
	
	private final char[] alphabet = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J',
									  'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T',
									  'U', 'V', 'W', 'X', 'Y', 'Z' };
	
	public char nextChar() {
		int c = r.nextInt(26);
		
		return alphabet[c];
	}
}
