package Controller;

import java.text.ParseException;
import java.util.List;

import Model.book;
import Model.SACHDAO;

public class SACHCONTRO {
	public List<book> getAllBOOK()
	{
		SACHDAO dao = new SACHDAO();
		List<book> b = dao.getAllSach();
		return b;
	}
	public boolean themSach(String ma,String ten,String xuatxu,String ngayxb,String tv) throws ParseException {
		SACHDAO dao = new SACHDAO();
		Boolean check = dao.addSach(ma, ten, xuatxu, ngayxb, tv);
		return check;
	}
	public boolean deleteSach(String ma)
	{
		SACHDAO dao = new SACHDAO();
		Boolean check = dao.xoaSach(ma);
		return check;
	}
	public boolean editSach(String ma,String ten,String xuatxu,String ngayxb,String tv)
	{
		SACHDAO dao = new SACHDAO();
		Boolean check = dao.suaSach(ma, ten, xuatxu, ngayxb, tv);
		return check;
	}
}
