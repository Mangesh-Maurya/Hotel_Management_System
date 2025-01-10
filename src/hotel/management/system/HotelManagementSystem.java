package hotel.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class HotelManagementSystem extends JFrame implements ActionListener{
	
	HotelManagementSystem() {
		//setSize(1366, 565);;
		//setLocation(100, 100);
		setBounds(100, 100, 1366, 565);//setsize and set location ka cobination hota h ye.
		setLayout(null);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/first.jpg"));
		JLabel image = new JLabel(i1);
		image.setBounds(0, 0, 1366, 565);
		add(image);
		JLabel text = new JLabel("HOTEL MANAGEMENT SYSTEM");
		text.setBounds(20, 430, 1000, 90);
		text.setForeground(Color.WHITE);
		text.setFont(new Font("serif", Font.PLAIN, 50));
		image.add(text);
		
		JButton next = new JButton("Next");
		next.setBounds(1150, 450, 150, 50);
		next.setBackground(Color.WHITE);
		next.setForeground(Color.MAGENTA);
		next.addActionListener(this);
		next.setFont(new Font("serif", Font.PLAIN, 24));
		image.add(next);
		
		
		setVisible(true);
		
		while(true) {
			text.setVisible(false);
			try {
				Thread.sleep(500);
			}catch(Exception e) {
				e.printStackTrace();
			}
			text.setVisible(true);
			try {
				Thread.sleep(500);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
	}
	
	public void actionPerformed(ActionEvent ae) {
		setVisible(false);
		new Login();
		
		
		
	}
	public static void main(String[] args) {
		new HotelManagementSystem();
	
	}

} 