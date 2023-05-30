package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Home extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home frame = new Home();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Home() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 412, 268);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Home");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblNewLabel.setBounds(150, 28, 73, 25);
		contentPane.add(lblNewLabel);
		
		JButton btnBook = new JButton("BOOK");
		btnBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SachView b = new SachView();
				b.setVisible(true);
				dispose();
			}
		});
		btnBook.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnBook.setBounds(42, 105, 97, 25);
		contentPane.add(btnBook);
		
		JButton btnThuvien = new JButton("ThuVien");
		btnThuvien.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ThuvienView tv = new ThuvienView();
				tv.setVisible(true);
				dispose();
			}
		});
		btnThuvien.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnThuvien.setBounds(229, 105, 97, 25);
		contentPane.add(btnThuvien);
	}
}
