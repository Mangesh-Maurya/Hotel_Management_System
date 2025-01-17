package hotel.management.system;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import net.proteanit.sql.*;

import com.mysql.cj.protocol.Resultset;

public class Room extends JFrame implements ActionListener{
	JTable table;
	JButton back;
	
	Room(){
		
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/eight.jpg"));
		Image i2 = i1.getImage().getScaledInstance(600, 600, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(500, 0, 600, 600);
		add(image);
	
		table = new JTable();
		table.setBounds(0, 40, 500, 400);
		add(table);
		
		JLabel l1 =new JLabel("Room Number");
		l1.setBounds(10, 10, 100, 20);
		add(l1);
		
		
		JLabel l2 =new JLabel("Availibility");
		l2.setBounds(120, 10, 100, 20);
		add(l2);
		
		
		JLabel l3 =new JLabel("Status");
		l3.setBounds(220, 10, 100, 20);
		add(l3);
		
		
		JLabel l4 =new JLabel("Bed Type");
		l4.setBounds(310, 10, 100, 20);
		add(l4);
		
		JLabel l5 =new JLabel("Price");
		l5.setBounds(410, 10, 100, 20);
		add(l5);
		
		
		
		try {
			Conn c = new Conn();
			ResultSet rs = c.s.executeQuery("select * from room");
			table.setModel(DbUtils.resultSetToTableModel(rs));
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		back = new JButton("Back");
		back.setBackground(Color.BLACK);
		back.setForeground(Color.WHITE);
		back.addActionListener(this);
		back.setBounds(200, 500, 120, 30);
		add(back);
		
		
		
		setBounds(300, 200, 1050, 600);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae) {
		setVisible(false);
		new Reception();
	}
	
	
	public static void main(String[] args) {
		new Room();
	}

}
