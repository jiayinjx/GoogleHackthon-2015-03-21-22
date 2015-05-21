package view;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import control.Global;

public class UnivFrame extends JFrame {

	
	JLabel schoolLbl = new JLabel("University");
	JLabel gpaLbl = new JLabel("GPA");
	JLabel toeflLbl = new JLabel("TOEFL");
	JLabel satLbl = new JLabel("SAT");
//	JLabel locationLbl = new JLabel("Location");
	
	
	JTextField schoolTxt = new JTextField();
	private final JTextField gpaTxt = new JTextField(5);
	private final JTextField toeflTxt = new JTextField(5);
	private final JTextField satTxt = new JTextField(5);
//	private final JComboBox locationTxt = new JComboBox(new String[] { "eastern", "western", "southern", "middle" });

	
	JCheckBox internationalBox = new JCheckBox("international student");
	private JButton submitBtn = new JButton("Submit");	
	JTextArea outputTxt = new JTextArea();
	
	JScrollPane outputSP = new JScrollPane(outputTxt,
            JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
            JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	
	
	public UnivFrame(){

		try {
			this.setContentPane(new JLabel(new ImageIcon(ImageIO
					.read(new File("images.jpg")))));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//myFrame.setSize(300, 100);

		
		this.setTitle("Please enter your info:");



		schoolLbl.setBounds(20, 20, 70, 30);
		gpaLbl.setBounds(130, 20, 70, 30);
		toeflLbl.setBounds(240, 20, 70, 30);
		satLbl.setBounds(350, 20, 70, 30);
		
	//	gpaLbl.setSize(100, 100);
		this.add(schoolLbl);
		this.add(gpaLbl);
		this.add(toeflLbl);
		this.add(satLbl);
		

		schoolTxt.setBounds(20, 70, 70, 30);
		gpaTxt.setBounds(130, 70, 70, 30);
		toeflTxt.setBounds(240, 70, 70, 30);
		satTxt.setBounds(350, 70, 70, 30);
		
		this.add(schoolTxt);
		this.add(gpaTxt);
		this.add(toeflTxt);
		this.add(satTxt);
		
		
		internationalBox.setBounds(20, 120, 180, 20);
		submitBtn.setFont(new Font("Arial", Font.BOLD, 10));
		submitBtn.setBounds(240, 120, 70, 20);
		
		
		
		
		
		this.add(internationalBox);
		this.add(submitBtn);
		

		outputSP.setBounds(20, 170, 400, 150);
		this.add(outputSP);
		
		outputTxt.setEditable(false);
		outputTxt.setOpaque(false);
		submitBtn.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				String school = schoolTxt.getText();
				String gpa = gpaTxt.getText();
				String toefl = toeflTxt.getText();
				String sat = satTxt.getText();
				boolean international = internationalBox.isSelected();
				String result = Global.searchEngine.DreamSchool(school, gpa, toefl, sat, international);
				outputTxt.setText(result);
				outputTxt.setLineWrap(true);
			}			
		});
		
		this.pack();
	}
		
}
