package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import control.SearchEngine;

public class MainFrame extends JFrame {
	
	//  3  buttons
	//  1. admin
	//  2. score--> university
	//  3. university --> probability
	JButton adminBtn = new JButton("Administrator");
	JButton searchBtn = new JButton("Search");
	JButton univBtn = new JButton("Dream School");
	public MainFrame(){
		try {
			this.setContentPane(new JLabel(new ImageIcon(ImageIO
				.read(new File("mmm.jpg")))));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		adminBtn.setBounds(17, 400, 200, 38);
		searchBtn.setBounds(247, 400, 200,38 );
		univBtn.setBounds(477, 400, 200, 38);
		this.add(adminBtn);
		this.add(searchBtn);
		this.add(univBtn);
		
		AdminActionListener adminAL = new AdminActionListener();
		adminBtn.addActionListener(adminAL);		
		

		SearchActionListener searchAL = new SearchActionListener();
		searchBtn.addActionListener(searchAL);
		
		UnivActionListener univAL = new UnivActionListener();
		univBtn.addActionListener(univAL);
	}
	

}


class AdminActionListener implements ActionListener{
	@Override
	public void actionPerformed(ActionEvent arg0) {
		AdminFrame af = new AdminFrame();
		af.setVisible(true);		
	}
}




class SearchActionListener implements ActionListener{
	@Override
	public void actionPerformed(ActionEvent arg0) {
		SearchFrame af = new SearchFrame();
		af.setVisible(true);	
	}
}



class UnivActionListener implements ActionListener{
	@Override
	public void actionPerformed(ActionEvent arg0) {
		UnivFrame af = new UnivFrame();
		af.setVisible(true);
		
	}	
}