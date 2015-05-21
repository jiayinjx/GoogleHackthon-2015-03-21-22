package control;
import javax.swing.JFrame;

import view.*;
public class MainControl {
	public static void main(String args[]){
		Global.searchEngine = new SearchEngine();
		MainFrame mf = new MainFrame();
		mf.setVisible(true);
		mf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mf.pack();
	}
}
