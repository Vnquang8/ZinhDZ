package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class SACHDAO {
	Connection conn = null;
	PreparedStatement pr = null;
	ResultSet rs = null;
	public List<book>getAllSach()
	{
		List<book>List = new ArrayList<book>();
		try {
			String sql = "select * from book";
			conn = new DBConnection().getConnection();
			pr = conn.prepareStatement(sql);
			rs = pr.executeQuery();
			while(rs.next())
			{
				THUVIENDAO dao = new THUVIENDAO();
				thuvien tv = dao.getThuVienByID(Integer.toString(rs.getInt(5)));
				book b = new book(rs.getInt(1),rs.getString(2),rs.getDate(3),rs.getString(4),tv);
				List.add(b);
			}
			conn.close();
			pr.close();
			rs.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return List;
	}
	public boolean addSach(String ma,String ten,String xuatxu,String ngayxb,String tv) throws ParseException
	{
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date date = format.parse(ngayxb);
		// Khi setDate trong pstm:
		//pstm.setDate(6,  new java.sql.Date(date.getTime()));
		try {
			String sql = "insert into book(masach,tensach,ngayxb,xuatxu,mathuvien) values (?,?,?,?,?)";
			conn = new DBConnection().getConnection();
			pr = conn.prepareStatement(sql);
			pr.setInt(1, Integer.parseInt(ma));
			pr.setString(2, ten);
			pr.setDate(3, new java.sql.Date(date.getTime()));
			pr.setString(4, xuatxu);
			pr.setInt(5, Integer.parseInt(tv));
			pr.executeUpdate();
			conn.close();
			pr.close();
			return true;
			
		} catch (Exception e) {
			return false;
		}
	}
	public boolean xoaSach(String ma)
	{
		try {
			String sql = "delete from book where masach = ?";
			conn = new DBConnection().getConnection();
			pr = conn.prepareStatement(sql);
			pr.setInt(1,Integer.parseInt(ma));
			pr.executeUpdate();
			conn.close();
			pr.close();
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	public boolean suaSach(String ma,String ten,String xuatxu,String ngayxb,String tv)
	{
		try {
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			Date date = format.parse(ngayxb);
			conn = new DBConnection().getConnection();
			pr = conn.prepareStatement("update book set tensach = ?,ngayxb = ?,xuatxu=?,mathuvien = ? where masach = ?");
			pr.setInt(5, Integer.parseInt(ma));
			pr.setString(1, ten);
			pr.setDate(2, new java.sql.Date(date.getTime()));
			pr.setString(3, xuatxu);
			pr.setInt(4, Integer.parseInt(tv));
			pr.executeUpdate();
			conn.close();
			pr.close();
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
