import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class calculator implements ActionListener {

	//declare -> so we can reuse.
	JFrame frame; 
	JTextField textfield; 
	JButton[]  numberButtons = new JButton[10]; // 0 -9 hold all of buttons. 
	JButton[] functionButtons = new JButton[9]; // + - / * ,,, holds
	
	JButton addButton, subButton, mulButton, divButton; 
	JButton decButton, equButton, delButton, clrButton, negButton; // delete clear 
	
	JPanel panel; 
	
	Font myFont = new Font("Ink Free", Font.BOLD, 30) ; // create font style 
	
	double num1=0, num2=0, result=0; 
	char operator; // hold + - * %
	
	//construcor
	public calculator() {
		
		frame  = new JFrame("Calculator"); // title 
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(420,550); // set size 
		frame.setLayout(null);
				
		// set textfield 
		textfield  = new JTextField(); 
		textfield.setBounds(50, 25,300,50);  // set size 
		textfield.setFont(myFont);  // font 
		textfield.setEditable(false); // not let the edit to textfield 
		
		textfield.setBackground(Color.lightGray);
		textfield.setForeground(Color.YELLOW);
		
		//create 8 buttons 
		addButton = new JButton("+"); 
		subButton = new JButton("-"); 
		mulButton = new JButton("*"); 
		divButton = new JButton("/"); 
	    decButton = new JButton("."); 
		equButton = new JButton("="); 
		delButton = new JButton("Delete"); 
		clrButton = new JButton("Clear"); 
		negButton = new JButton("(-)"); 
		
		// add to array of function buttons
		functionButtons[0] = addButton; 
		functionButtons[1] = subButton; 
		functionButtons[2] = mulButton; 
		functionButtons[3] = divButton; 
		functionButtons[4] = decButton; 
		functionButtons[5] = equButton; 
		functionButtons[6] = delButton; 
		functionButtons[7] = clrButton; 
		functionButtons[8] = negButton; 
		
		
		// for loop 8 times 
		for(int i=0; i <9; i++) { 
			functionButtons[i].addActionListener(this); 
			functionButtons[i].setFont(myFont);   // set font 
			//functionButtons[i].setFocusable(false); 
			
			 
		}
		
		
		// iterate 10 times 
		for(int i=0; i <10; i++) { 
			// init numberButtons 
			numberButtons[i] = new JButton(String.valueOf(i)); 
			numberButtons[i].addActionListener(this); 
			numberButtons[i].setFont(myFont); 
			numberButtons[i].setFocusable(false); 
		}
		
		 
				
		//set size of bounds 
		negButton.setBounds(50,430,100,50);
		delButton.setBounds(150, 430, 100, 50); 
		clrButton.setBounds(250,430,100,50); 
		
		panel  = new JPanel(); 
		panel.setBounds(50,100,300,300); 
		panel.setLayout(new GridLayout(4,4,10,10)); //row colum space left space right 
		//panel.setBackground(Color.GRAY); 
		
	
		//add
		//1 row 
		panel.add(numberButtons[1]); 
		panel.add(numberButtons[2]); 
		panel.add(numberButtons[3]); 
		panel.add(addButton); 
		//2 row 
		panel.add(numberButtons[4]); 
		panel.add(numberButtons[5]); 
		panel.add(numberButtons[6]);
		panel.add(subButton); 
		// 3 row 
		panel.add(numberButtons[7]); 
		panel.add(numberButtons[8]); 
		panel.add(numberButtons[9]); 
		panel.add(mulButton);
		// 4 row 
		panel.add(decButton); 
		panel.add(numberButtons[0]);
		panel.add(equButton);
		panel.add(divButton); 
		
		
		// add buttons 
		frame.add(panel);
		frame.add(delButton); 
		frame.add(clrButton); 
		frame.add(negButton);
		frame.add(textfield); //add to frame
		frame.setVisible(true);
		
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new calculator();
		

	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		//for loop 10 times 
		for(int i =0 ; i <10; i++) {
			if(e.getSource() == numberButtons[i]) {
				//when we click number button it add to textfield as string 
				textfield.setText(textfield.getText().concat(String.valueOf(i)));
				
			}
		}
		// . to textfield 
		if(e.getSource() == decButton) {
			textfield.setText(textfield.getText().concat("."));
		}
		//add
		if(e.getSource() == addButton) {
			num1 = Double.parseDouble(textfield.getText()); // parse 
			// assgin operator 
			operator ='+'; 
			textfield.setText("");
		}
		//sub 
		if(e.getSource() == subButton) {
			num1 = Double.parseDouble(textfield.getText()); // parse 
			operator = '-'; 
			textfield.setText("");
		}
		//mul
		if(e.getSource() == mulButton) {
			num1 = Double.parseDouble(textfield.getText()); // parse 
			operator = '*'; 
			textfield.setText("");
		}
		//div
		if(e.getSource() == divButton) {
			num1 = Double.parseDouble(textfield.getText()); // parse 
			operator = '/'; 
			textfield.setText("");
		}
		// equal 
		if(e.getSource() == equButton) {
			num2 = Double.parseDouble(textfield.getText()); 
			
			switch(operator) {
			case'+':
				result = num1+num2;
				break; 
			case'-':
				result = num1 - num2; 
				break; 
			case'*':
				result = num1 * num2; 
				break; 
			case'/':
				result = num1 / num2; 
				break; 
			}
			//update  reult into text field 
			textfield.setText(String.valueOf(result));
			num1 = result; //so we can continue more operation. 
		}
		
		//clr
				if(e.getSource() == clrButton) {
					textfield.setText("");
				}
		// del
				if(e.getSource() == delButton) {
					String string = textfield.getText(); 
					textfield.setText("");
					//delete from last button
					for(int i=0; i<string.length()-1; i++) {
						 textfield.setText(textfield.getText() + string.charAt(i));
					}
				}
		//neg
				// del
				if(e.getSource() == negButton) {
					// take whatever value in textfield and assgin to temp
					double temp = Double.parseDouble(textfield.getText());
					temp*=-1; 
					textfield.setText(String.valueOf(temp));
				}
			
		
	}

}
