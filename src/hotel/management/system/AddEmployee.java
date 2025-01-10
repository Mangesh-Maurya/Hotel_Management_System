package hotel.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class AddEmployee extends JFrame implements ActionListener{

	JTextField tfname, tfage, tfemail, tfphone, tfsalary, tfaadhar;
	JRadioButton rbmale, rbfemale;
	JButton submit;
	JComboBox cbjob;
	
	AddEmployee() {
		setLayout(null);
		
		JLabel heading = new JLabel("Add Employee");
		heading.setFont(new Font("Tahoma", Font.BOLD, 18));
		heading.setBounds(150, 20, 200, 20);
		add(heading);
		
		JLabel lblname = new JLabel("NAME");
		lblname.setBounds(60, 60, 120, 30);
		lblname.setFont(new Font("Tohoma", Font.PLAIN, 17));
		add(lblname);
		
		tfname = new JTextField();
		tfname.setBounds(200, 60, 150, 30);
		add(tfname);
		
		JLabel lblage = new JLabel("AGE");
		lblage.setBounds(60, 100, 120, 30);
		lblage.setFont(new Font("Tohoma", Font.PLAIN, 17));
		add(lblage);
		
		tfage = new JTextField();
		tfage.setBounds(200, 100, 150, 30);
		add(tfage);
		
		JLabel lblgender = new JLabel("GENDER");
		lblgender.setBounds(60, 140, 120, 30);
		lblgender.setFont(new Font("Tohoma", Font.PLAIN, 17));
		add(lblgender);
		
		rbmale = new JRadioButton("Male");
		rbmale.setBounds(200, 140, 70, 30);
		rbmale.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rbmale.setBackground(Color.WHITE);
		add(rbmale);
		
		rbfemale = new JRadioButton("Female");
		rbfemale.setBounds(280, 140, 70, 30);
		rbfemale.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rbfemale.setBackground(Color.WHITE);
		add(rbfemale);
		
		ButtonGroup bg = new ButtonGroup();
		bg.add(rbmale);
		bg.add(rbfemale);
		
		JLabel lbljob = new JLabel("JOB");
		lbljob.setBounds(60, 190, 120, 30);
		lbljob.setFont(new Font("Tohoma", Font.PLAIN, 17));
		add(lbljob);
		
		String str[] = {"Front Desk Clerks", "Porters", "Housekeeping", "Kitchen Staff", "Room Service",
				"Chefs", "Waiter/waitress", "Manager", "Accountant"};
		cbjob = new JComboBox(str);
		cbjob.setBounds(200, 190, 150, 30);
		cbjob.setBackground(Color.WHITE);
		add(cbjob);
		
		JLabel lblsalary = new JLabel("SALARY");
		lblsalary.setBounds(60, 240, 120, 30);
		lblsalary.setFont(new Font("Tohoma", Font.PLAIN, 17));
		add(lblsalary);
		
		tfsalary = new JTextField();
		tfsalary.setBounds(200, 240, 150, 30);
		add(tfsalary);
		
		JLabel lblphone = new JLabel("PHONE");
		lblphone.setBounds(60, 280, 120, 30);
		lblphone.setFont(new Font("Tohoma", Font.PLAIN, 17));
		add(lblphone);
		
		tfphone = new JTextField();
		tfphone.setBounds(200, 280, 150, 30);
		add(tfphone);
		
		JLabel lblemail = new JLabel("EMAIL");
		lblemail.setBounds(60, 320, 120, 30);
		lblemail.setFont(new Font("Tohoma", Font.PLAIN, 17));
		add(lblemail);
		
		tfemail = new JTextField();
		tfemail.setBounds(200, 320, 150, 30);
		add(tfemail);
		
		JLabel lblaadhar = new JLabel("AADHAR");
		lblaadhar.setBounds(60, 360, 120, 30);
		lblaadhar.setFont(new Font("Tohoma", Font.PLAIN, 17));
		add(lblaadhar);
		
		tfaadhar = new JTextField();
		tfaadhar.setBounds(200, 360, 150, 30);
		add(tfaadhar);
		
		submit =new JButton("SUBMIT");
		submit.setBackground(Color.BLACK);
		submit.setForeground(Color.WHITE);
		submit.setBounds(200, 430, 150, 30);
		submit.addActionListener(this);
		add(submit);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/tenth.jpg"));
		Image i2 = i1.getImage().getScaledInstance(450, 450, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(380, 60, 450, 370);
		add(image);
		
		
		
		getContentPane().setBackground(Color.WHITE);
		setBounds(350, 200, 850, 540);
		setVisible(true);
		
	}
	
	public void actionPerformed(ActionEvent ev) {
		String name = tfname.getText();
		String age = tfage.getText();
		String salary = tfsalary.getText();
		String phone = tfphone.getText();
		String email = tfemail.getText();
		String aadhar = tfaadhar.getText();

		
		String gender = null;
		
		//email.equals("") && contain ("@") && include(".con")
		if(name.equals("")) {
			JOptionPane.showConfirmDialog(null, "Name should not be empty");
			return ;
		}
		if(rbmale.isSelected()) {
			gender = "Male";
		}else if(rbfemale.isSelected()) {
			gender = "Female";
		}
		
		String job = (String)cbjob.getSelectedItem();
		
		try {
			Conn conn = new Conn();
			
			String query = "insert into employee values('"+name+"', '"+age+"', '"+gender+"', '"+job+"',"
					+ " '"+salary+"', '"+phone+"', '"+email+"', '"+aadhar+"' )";
			
			conn.s.executeUpdate(query);
			
			JOptionPane.showConfirmDialog(null, "Employee added successfully");
			
			setVisible(false);
					
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		new AddEmployee();
	}

}
