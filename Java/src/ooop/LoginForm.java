package ooop;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;

import javax.swing.*;

public class LoginForm implements ActionListener {

		JFrame frame;
		JLabel lblUserName, lblPassword,lblName;
		JTextField txtUserName,txtUser, txtPass;
		JPasswordField txtPassword;
		JButton btnLogin,btnClose;
		

		
		public LoginForm() {
	
		frame = new JFrame();
		frame.setTitle("Turtle Project");
		frame.setSize(new Dimension(500, 500));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(true);
		frame.setLayout(null);

		//Panel
		JPanel panel = new JPanel();
		panel.setBounds(30, 30, 400, 500);
		panel.setLayout(null);

		// Login Label
		JLabel lblLogin = new JLabel("Turtle project");
		lblLogin.setBounds(100, 50, 300, 60);

		// Login Font
		Font fontLogin = new Font( "Latin", Font.BOLD,40);
		lblLogin.setFont(fontLogin);

		// Font
		Font font = new Font("Latin", Font.LAYOUT_NO_LIMIT_CONTEXT, 15);
		// User Name Label
	
		
		lblUserName = new JLabel("User Name");
		lblUserName.setBounds(50, 150, 150, 30);

		lblUserName.setFont(font);
       

		// TextField User Name
		txtUserName = new JTextField();
		txtUserName.setBounds(180, 150, 170, 30);

		// Password Label
		lblPassword = new JLabel("Password");
		lblPassword.setBounds(50, 200, 150, 30);
		lblPassword.setFont(font);
	     
	       
		

		// Password Field User Name 
		txtPassword = new JPasswordField();
		txtPassword.setBounds(180, 200, 170, 30);

		// Login Button
		btnLogin = new JButton("Login");
		btnLogin.setBounds(50, 300, 300, 40);
		btnLogin.setBackground(new Color(98, 82, 219));
		btnLogin.setForeground(Color.black);
		btnLogin.setFont(font);

		
		// Add ActionListener
		btnLogin.addActionListener(this);
		
		// Add Panel
		panel.add(lblLogin);
		panel.add(lblUserName);
		panel.add(txtUserName);
		panel.add(lblPassword);
		panel.add(txtPassword);
		panel.add(btnLogin);
		

		// Add Panel to Frame
		frame.add(panel);

		// Create and add the background JLabel
		JLabel background = new JLabel(new ImageIcon("hlo1.jpg"));
		background.setBounds(0, 0, 500, 500);
		frame.add(background);

		frame.setVisible(true);
}
		@Override
		public void actionPerformed(ActionEvent ae) {
			if(ae.getSource()==btnLogin) {
			//do login
			User user = new User();
			user.setUserName(txtUserName.getText());
			
			user.setPassword(txtPassword.getText());
			UserManager userManager=new UserManager();
			boolean result = userManager.login(user);
			if(result == true) {
			JOptionPane.showMessageDialog(null, "Welcome Successfully Login!");
			frame.dispose();
			GraphicsSystem obj = new GraphicsSystem();
		
			
			}
			else {
			JOptionPane.showMessageDialog(null, "Error to Login!");
			}}
			
			}

			public static void main(String[] args) {
			new  LoginForm();
		
			}
			



	

}

