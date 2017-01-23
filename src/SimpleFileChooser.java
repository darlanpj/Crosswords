import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;


/**
 * Created by darlanpj on 22/01/2017.
 */
public class SimpleFileChooser extends JFrame {

    public SimpleFileChooser() {
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
                chooser.setMultiSelectionEnabled(true);
                int option = chooser.showOpenDialog(SimpleFileChooser.this);
                if (option == JFileChooser.APPROVE_OPTION) {
                    File[] sf = chooser.getSelectedFiles();
                    String filelist = "nothing";
                    if (sf.length > 0) filelist = sf[0].getName();
                    for (int i = 1; i < sf.length; i++) {
                        filelist += ", " + sf[i].getName();
                    }
                    statusbar.setText("You chose " + filelist);
                }
                else {
                    statusbar.setText("You canceled.");
                }
            }
        });

        c.add(openButton);
        c.add(statusbar);
    }

    public static void main(String args[]) {
        SimpleFileChooser sfc = new SimpleFileChooser();
        sfc.setVisible(true);
    }
}
