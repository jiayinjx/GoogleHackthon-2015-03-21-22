package view;

import java.awt.Font;
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

public class AdminFrame extends JFrame {

	JLabel univLbl = new JLabel ("University");
	JLabel gpaLbl = new JLabel("GPA");
	JLabel toeflLbl = new JLabel("TOEFL");
	JLabel satLbl = new JLabel("SAT");
	JLabel rankLbl = new JLabel("Rank");
	
	JTextField univTxt = new JTextField();
	private final JTextField gpaTxt = new JTextField(5);
	private final JTextField toeflTxt = new JTextField(5);
	private final JTextField satTxt = new JTextField(5);
	private final JTextField rankTxt = new JTextField(5);
	
	

	
	JLabel descLbl = new JLabel("Description");
	
	JTextArea outputTxt = new JTextArea();
	JScrollPane outputSP = new JScrollPane(outputTxt,
            JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
            JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	

	private JButton submitBtn = new JButton("Submit");	
	
	public AdminFrame(){

		try {
			this.setContentPane(new JLabel(new ImageIcon(ImageIO
					.read(new File("Wisconsin.jpg")))));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//myFrame.setSize(300, 100);

	//	GridLayout lo = new GridLayout(0,4);
	//	this.setLayout(lo);
		
		this.setTitle("Please enter your info:");

	//	gpaLbl.setSize(100, 100);
		univLbl.setBounds(20,20, 180, 30);
		univTxt.setBounds(130, 20, 180, 30);
		
		this.add(univLbl);
		this.add(univTxt);
		
		gpaLbl.setBounds(20, 70, 70, 30);
		toeflLbl.setBounds(130, 70, 70, 30);
		satLbl.setBounds(240, 70, 70, 30);
		rankLbl.setBounds(350, 70, 70, 30);
		
		this.add(gpaLbl);
		this.add(toeflLbl);
		this.add(satLbl);
		this.add(rankLbl);


		gpaTxt.setBounds(20, 120, 70, 30);
		toeflTxt.setBounds(130, 120, 70, 30);
		satTxt.setBounds(240, 120, 70, 30);
		rankTxt.setBounds(350, 120, 70, 30);
		
		this.add(gpaTxt);
		this.add(toeflTxt);
		this.add(satTxt);
		this.add(rankTxt);
		
		
		descLbl.setBounds(20, 170, 100, 30);
		this.add(descLbl);

		outputSP.setBounds(20, 220, 400, 70);
		outputTxt.setOpaque(true);
		this.add(outputSP);
		
		
		submitBtn.setFont(new Font("Arial", Font.BOLD, 10));
		submitBtn.setBounds(350, 310, 70, 20);
		this.add(submitBtn);
		
		submitBtn.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				Global.searchEngine.ChangeUniversityInfo(null, null, null, null, null, null, null);
			}			
		});
		
		this.pack();
	}
}
