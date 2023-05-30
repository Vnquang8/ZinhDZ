package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Model.book;
import Model.thuvien;
import Controller.SACHCONTRO;
import Controller.THUVIENCONTRO;
import Model.SACHDAO;

import javax.swing.JComboBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SachView extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField textField_2;
	private JTable table;
	private final SACHCONTRO sachCon = new SACHCONTRO();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SachView frame = new SachView();
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
	public SachView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 743, 410);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("M\u00E3 s\u00E1ch");
		lblNewLabel.setBounds(12, 18, 56, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblTnSch = new JLabel("T\u00EAn s\u00E1ch");
		lblTnSch.setBounds(12, 82, 56, 16);
		contentPane.add(lblTnSch);
		
		textField = new JTextField();
		textField.setBounds(12, 47, 116, 22);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(12, 112, 116, 22);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JRadioButton rdnNN = new JRadioButton("NN");
		buttonGroup.add(rdnNN);
		rdnNN.setBounds(209, 22, 127, 25);
		contentPane.add(rdnNN);
		
		JRadioButton rdnVN = new JRadioButton("VN");
		buttonGroup.add(rdnVN);
		rdnVN.setBounds(209, 55, 56, 22);
		contentPane.add(rdnVN);
		
		JLabel lblNgyXutBn = new JLabel("Ng\u00E0y xu\u1EA5t b\u1EA3n");
		lblNgyXutBn.setBounds(344, 13, 95, 16);
		contentPane.add(lblNgyXutBn);
		
		textField_2 = new JTextField();
		textField_2.setBounds(344, 36, 116, 22);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		//1aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa
		JComboBox CB = new JComboBox();
		CB.setBounds(344, 91, 116, 22);
		contentPane.add(CB);
		THUVIENCONTRO dao = new THUVIENCONTRO();
		List<thuvien> tv = dao.GetALLTHUVIEN();
		for (thuvien thuvien : tv) {
			CB.addItem(thuvien.getMathuvien());
		}
		
		JButton btnNewButton = new JButton("Th\u00EAm");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String masach = textField.getText();
				String ten = textField_1.getText();
				String xuatxu="";
				if(rdnNN.isSelected())
				{
					xuatxu = "NN";
				}
				else
					xuatxu ="VN";
				String ngayxb = textField_2.getText();
				THUVIENCONTRO a = new THUVIENCONTRO();
				String ma = "";
				List<thuvien> list = a.GetALLTHUVIEN();
				for (thuvien thuvien : list) {
					if(CB.getSelectedItem().equals(thuvien.getMathuvien()))
						ma =Integer.toString(thuvien.getMathuvien());
				}
				String tv = Integer.toString(a.layTV(ma).getMathuvien());
				SACHCONTRO dao = new SACHCONTRO();
				try {
					Boolean check = dao.themSach(masach, ten, xuatxu, ngayxb, tv);
					if (check)
					{
						ShowMess("Thanh Cong");
					}
					else 
						ShowMess("Fail");
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				ResetDate();
				
			}
		});
		btnNewButton.setBounds(12, 162, 97, 25);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("X\u00F3a");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SACHCONTRO dao = new SACHCONTRO();
				try {
					Boolean check = dao.deleteSach(textField.getText());
					if(check)
						ShowMess("Thanh Cong");
					else
						ShowMess("Fail");
				} catch (Exception e2) {
					// TODO: handle exception
				}
				ResetDate();
				clear();
			}
		});
		btnNewButton_1.setBounds(168, 162, 97, 25);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("S\u1EEDa");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String masach = textField.getText();
				String ten = textField_1.getText();
				String xuatxu="";
				if(rdnNN.isSelected())
				{
					xuatxu = "NN";
				}
				else
					xuatxu ="VN";
				String ngayxb = textField_2.getText();
				THUVIENCONTRO a = new THUVIENCONTRO();
				String ma = "";
				List<thuvien> list = a.GetALLTHUVIEN();
				for (thuvien thuvien : list) {
					if(CB.getSelectedItem().equals(thuvien.getMathuvien()))
						ma =Integer.toString(thuvien.getMathuvien());
				}
				String tv = Integer.toString(a.layTV(ma).getMathuvien());
				Boolean check = sachCon.editSach(masach, ten, xuatxu, ngayxb, tv);
				
				if(check)
					ShowMess("Thanh cong");
				else
					ShowMess("Fail");
				ResetDate();
				clear();
				
			}
		});
		btnNewButton_2.setBounds(324, 162, 97, 25);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Back Home");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Home h = new Home();
				h.setVisible(true);
				dispose();
			}
		});
		btnNewButton_3.setBounds(490, 162, 97, 25);
		contentPane.add(btnNewButton_3);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 250, 725, 113);
		contentPane.add(scrollPane);
		
		table = new JTable();
		
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int row = table.getSelectedRow();
				String ma = table.getValueAt(row, 0).toString();
				String ten = table.getValueAt(row, 1).toString();
				String xx = table.getValueAt(row, 2).toString();
				String ngayxb = table.getValueAt(row, 3).toString();
				String tv = table.getValueAt(row, 4).toString();
				
				textField.setText(ma);
				textField_1.setText(ten);
				textField_2.setText(ngayxb);
				
				if (xx.equals("NN"))
					rdnNN.setSelected(true);
				else
					rdnVN.setSelected(true);
				
				THUVIENCONTRO list = new THUVIENCONTRO();
				List<thuvien> thuvien = list.GetALLTHUVIEN();
				for (thuvien thuvien2 : thuvien) {
					if(tv.equals(thuvien2.getTenthuvien()))
						CB.setSelectedItem(thuvien2.getMathuvien());
				}
					
			}
		});
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"M\u00E3", "T\u00EA", "Xu\u1EA5t x\u1EE9", "Ng\u00E0y xb", "Th\u01B0 vi\u1EC7n"
			}
		));
		scrollPane.setViewportView(table);
		ResetDate();
	}
	public void ResetDate()
	{
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.setRowCount(0);
		SACHCONTRO sach = new SACHCONTRO();
		List<book> list = sach.getAllBOOK();
		for ( book b : list) {
			model.addRow(new Object[] {b.getMasach(),b.getTensach(),b.getXuatxu(),b.getNgayxb(),b.getMathuvien().getTenthuvien()});
		}
		model.fireTableDataChanged();
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
