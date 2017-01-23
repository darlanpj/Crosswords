import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by darlanpj on 22/01/2017.
 */
public class CrosswordGen extends JFrame {


	public CrosswordGen (){
		super("File Chooser Test Frame");
		setSize(600, 600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		Container c = getContentPane();
		c.setLayout(new FlowLayout());

		JButton openButton = new JButton("Open");

		final JLabel statusbar =
				new JLabel("Entre com o arquivo com as palavras");


		openButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				JFileChooser chooser = new JFileChooser();
				int option = chooser.showOpenDialog(CrosswordGen.this);
				if (option == JFileChooser.APPROVE_OPTION) {
					File[] sf = chooser.getSelectedFiles();
					String filelist = "nothing";
					if (sf.length > 0) filelist = sf[0].getName();
					for (int i = 1; i < sf.length; i++) {
						filelist += ", " + sf[i].getName();
					}
					statusbar.setText("Você escolheu: " + filelist);
				}
				else {
					statusbar.setText("Cancelado.");
				}
			}
		});

		c.add(openButton);
		c.add(statusbar);

		StringBuilder wordList = new StringBuilder();
		while(sf.hasNext()) {
			wordList.append(filelist.next() + " ");
		}
	}



	public static void main(String[] args) {

		CrosswordGen sfc = new CrosswordGen();
		sfc.setVisible(true);

		int tamCrossword = 10;

		Scanner stdin = null;
		try {
			stdin = new Scanner(new File("C:\\Users\\darlanpj\\Documents\\CrosswordGenerator\\resources\\wordlist.txt"));
		} catch(FileNotFoundException e) {
			System.out.println("Arquivo não encontrado \"wordlist.txt\"");
		}
		
		StringBuilder wordList = new StringBuilder();
		while(stdin.hasNext()) {
			wordList.append(stdin.next() + " ");
		}

		wordList.deleteCharAt(wordList.length()-1);
		
		String[] list = wordList.toString().split(" ");
		
		CrosswordCore w = new CrosswordCore(list, tamCrossword);

		System.out.println("******************");

		System.out.println(w.getPuzzle());
		System.out.println(w.getSolution());
	}
}
