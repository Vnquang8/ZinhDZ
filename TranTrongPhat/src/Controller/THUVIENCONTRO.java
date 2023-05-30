package Controller;

import java.util.List;

import Model.THUVIENDAO;
import Model.thuvien;


public class THUVIENCONTRO {
	public List<thuvien>GetALLTHUVIEN()
	{
		THUVIENDAO dao = new THUVIENDAO();
		List<thuvien> list = dao.GetAllTV();
		return list;
	}
	
	public boolean themTV(String ma,String ten)
	{
		THUVIENDAO dao = new THUVIENDAO();
		Boolean check = dao.addTV(ma, ten);
		if(check)
			return true;
		return false;
	}
	
	public boolean xoaTV(String ma)
	{
		THUVIENDAO dao = new THUVIENDAO();
		Boolean check = dao.removeTV(ma);
		if(check)
			return true;
		return false;
	}
	public thuvien layTV(String ma)
	{
		THUVIENDAO dao = new THUVIENDAO();
		thuvien a = dao.getThuVienByID(ma);
		return a;
	}
	
	public boolean suaTV(String ma,String ten)
	{
		THUVIENDAO dao = new THUVIENDAO();
		Boolean check = dao.updateDateTV(ma, ten);
		if(check)
			return true;
		return false;
	}
}
