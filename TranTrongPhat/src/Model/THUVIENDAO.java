package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class THUVIENDAO {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	public List<thuvien>GetAllTV(){
		List<thuvien> list = new ArrayList<thuvien>();
		try {
			String sql = "select * from thuvien";
			conn = new DBConnection().getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next())
			{
				thuvien tv = new thuvien(rs.getInt(1),rs.getString(2));
				list.add(tv);
			}
			conn.close();
			ps.close();
			rs.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}
	public boolean addTV(String ma,String ten)
	{
		try {
			String sql = "insert into thuvien(mathuvien,tenthuvien) values(?,?)";
			conn = new DBConnection().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1,Integer.parseInt(ma));
			ps.setString(2, ten);
			ps.executeUpdate();
			conn.close();
			ps.close();
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public boolean removeTV(String ma)
	{
		try {
			String sql = "delete from thuvien where mathuvien = ? ";
			conn = new DBConnection().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1,Integer.parseInt(ma));
			ps.executeUpdate();
			conn.close();
			ps.close();
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	public thuvien getThuVienByID (String id)
	{
		try {
			String sql = "select * from thuvien where mathuvien = ?";
			conn = new DBConnection().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, Integer.parseInt(id));
			rs = ps.executeQuery();
			while(rs.next())
			{
				thuvien tv = new thuvien(rs.getInt(1),rs.getString(2));
				return tv;
			}
			conn.close();
			ps.close();
			rs.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	public boolean updateDateTV(String ma,String ten)
	{
		try {
			conn = new DBConnection().getConnection();
			ps = conn.prepareStatement("update thuvien set tenthuvien = ? where mathuvien = ?");
			ps.setInt(2,Integer.parseInt(ma));
			ps.setString(1, ten);
			ps.executeUpdate();
			conn.close();
			ps.close();
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
