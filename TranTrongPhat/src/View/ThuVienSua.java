package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Model.thuvien;
import Controller.THUVIENCONTRO;
import View.ThuvienView;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ThuVienSua extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ThuVienSua frame = new ThuVienSua();
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
	public ThuVienSua() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 193);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Ma thu vien");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(12, 13, 85, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblTenThuVien = new JLabel("Ten thu vien");
		lblTenThuVien.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTenThuVien.setBounds(12, 47, 98, 16);
		contentPane.add(lblTenThuVien);
		
		textField = new JTextField();
		textField.setBounds(109, 11, 311, 22);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(109, 45, 311, 22);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton = new JButton("Sua");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				THUVIENCONTRO dao = new THUVIENCONTRO();
				Boolean check = dao.suaTV(textField.getText(), textField_1.getText());
					if(check)
						ShowMess("Thanh Cong");
					else
						ShowMess("Fail");
					clear();
					ThuvienView tvUI = new ThuvienView();
					tvUI.setVisible(true);
					dispose();
			}
		});
		btnNewButton.setBounds(165, 94, 97, 25);
		contentPane.add(btnNewButton);
		
	}
	public void NhanDate(thuvien tv)
	{
		textField.setText(Integer.toString(tv.getMathuvien()));
		textField_1.setText(tv.getTenthuvien());
	}
	public void ShowMess(String mess) {
        JOptionPane.showMessageDialog(this, mess);
    }
	public void clear()
	{
		textField.setText("");
		textField_1.setText("");
	}
}
