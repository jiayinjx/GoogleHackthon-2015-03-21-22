package view;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import control.Global;

public class SearchFrame extends JFrame {

	JLabel gpaLbl = new JLabel("GPA");
	JLabel toeflLbl = new JLabel("TOEFL");
	JLabel satLbl = new JLabel("SAT");
	JLabel locationLbl = new JLabel("Location");
	private final JTextField gpaTxt = new JTextField(5);
	private final JTextField toeflTxt = new JTextField(5);
	private final JTextField satTxt = new JTextField(5);
	private final JComboBox locationTxt = new JComboBox(new String[] { "eastern", "western", "southern", "middle" });
	
	

	private JButton submitBtn = new JButton("Submit");	
	
	
	
	JTextArea outputTxt = new JTextArea();
	JScrollPane outputSP = new JScrollPane(outputTxt,
            JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
            JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	
	public SearchFrame(){

		try {
			this.setContentPane(new JLabel(new ImageIcon(ImageIO
					.read(new File("global-search-icon.jpg")))));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//myFrame.setSize(300, 100);

	//	GridLayout lo = new GridLayout(0,4);
	//	this.setLayout(lo);
		
		this.setTitle("Please enter your info:");

	//	gpaLbl.setSize(100, 100);
		
		gpaLbl.setBounds(20, 20, 70, 30);
		toeflLbl.setBounds(130, 20, 70, 30);
		satLbl.setBounds(240, 20, 70, 30);
		locationLbl.setBounds(350, 20, 70, 30);
		
		this.add(gpaLbl);
		this.add(toeflLbl);
		this.add(satLbl);
		this.add(locationLbl);


		gpaTxt.setBounds(20, 70, 70, 30);
		toeflTxt.setBounds(130, 70, 70, 30);
		satTxt.setBounds(240, 70, 70, 30);
		locationTxt.setBounds(350, 70, 70, 30);
		
		this.add(gpaTxt);
		this.add(toeflTxt);
		this.add(satTxt);
		this.add(locationTxt);
		
		

		submitBtn.setFont(new Font("Arial", Font.BOLD, 10));
		submitBtn.setBounds(20, 120, 70, 20);
		outputSP.setBounds(130, 120, 290, 190);
		
		this.add(submitBtn);
		this.add(outputSP);
		
		outputTxt.setEditable(false);
		outputTxt.setOpaque(false);
		submitBtn.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				String gpa = gpaTxt.getText();
				String toefl = toeflTxt.getText();
				String sat = satTxt.getText();
				String location = (String)locationTxt.getSelectedItem();
				String result = Global.searchEngine.SearchSchool(gpa, toefl, sat, location);
				outputTxt.setText(result);
				outputTxt.setLineWrap(true);
			}			
		});
		
		this.pack();
	}
		
}

