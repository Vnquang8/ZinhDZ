package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.util.List;

import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Controller.THUVIENCONTRO;
import Model.thuvien;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ThuvienView extends JFrame {

	private JPanel contentPane;
	private JTextField txtMatv;
	private JTextField txtTentv;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ThuvienView frame = new ThuvienView();
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
	public ThuvienView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 344);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Ma thu vien");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel.setBounds(12, 13, 86, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblTenThuVien = new JLabel("Ten thu vien");
		lblTenThuVien.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblTenThuVien.setBounds(12, 59, 86, 16);
		contentPane.add(lblTenThuVien);
		
		txtMatv = new JTextField();
		txtMatv.setBounds(110, 10, 410, 22);
		contentPane.add(txtMatv);
		txtMatv.setColumns(10);
		
		txtTentv = new JTextField();
		txtTentv.setBounds(110, 56, 410, 22);
		contentPane.add(txtTentv);
		txtTentv.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 145, 508, 139);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int row = table.getSelectedRow();
				String ma = table.getValueAt(row,0).toString();
				String ten = table.getValueAt(row,1).toString();
				txtMatv.setText(ma);
				txtTentv.setText(ten);
			}
		});
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"MA THU VIEN", "TEN THU VIEN"
			}
		));
		scrollPane.setViewportView(table);
		
		JButton btnThem = new JButton("Them");
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String ma = txtMatv.getText();
				String ten = txtTentv.getText();
				THUVIENCONTRO dao = new THUVIENCONTRO();
				Boolean check = dao.themTV(ma, ten);
				if(check)
					showMess("Thanh Cong");
				else {
					showMess("Fail");
				}
				showDate();
				clear();
			}
		});
		btnThem.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnThem.setBounds(12, 98, 97, 25);
		contentPane.add(btnThem);
		
		JButton btnXoa = new JButton("Xoa");
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String ma = txtMatv.getText();
				THUVIENCONTRO dao = new THUVIENCONTRO();
				Boolean check = dao.xoaTV(ma);
				if(check)
					showMess("Thanh Cong");
				else {
					showMess("Fail");
				}
				showDate();
				clear();
			}
		});
		btnXoa.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnXoa.setBounds(140, 98, 97, 25);
		contentPane.add(btnXoa);
		
		JButton btnSua = new JButton("Sua");
		btnSua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				THUVIENCONTRO dao = new THUVIENCONTRO();
				thuvien tv = dao.layTV(txtMatv.getText());
				ThuVienSua a = new ThuVienSua();
				a.NhanDate(tv);
				a.setVisible(true);
				dispose();
			}
		});
		btnSua.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnSua.setBounds(260, 98, 97, 25);
		contentPane.add(btnSua);
		
		JButton btnHome = new JButton("Home");
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Home a = new Home();
				a.setVisible(true);
				dispose();
			}
		});
		btnHome.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnHome.setBounds(398, 98, 97, 25);
		contentPane.add(btnHome);
		showDate();
	}
	public void showDate()
	{
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.setRowCount(0);
		THUVIENCONTRO dao = new THUVIENCONTRO();
		List<thuvien> list = dao.GetALLTHUVIEN();
		for (thuvien thuvien : list) {
			model.addRow(new Object[] {thuvien.getMathuvien(),thuvien.getTenthuvien()});
		}
		model.fireTableDataChanged();
	}
	public void showMess(String mess)
	{
		JOptionPane.showMessageDialog(this, mess);
	}
	public void clear()
	{
		txtMatv.setText("");
		txtTentv.setText("");
	}
	
}
