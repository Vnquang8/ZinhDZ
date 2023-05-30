package Model;

import java.sql.Date;

public class book {
	private int masach;
	private String tensach;
	private Date ngayxb;
	private String xuatxu;
	private thuvien mathuvien;
	public book() {
		super();
		// TODO Auto-generated constructor stub
	}
	public book(int masach, String tensach, Date ngayxb, String xuatxu, thuvien mathuvien) {
		super();
		this.masach = masach;
		this.tensach = tensach;
		this.ngayxb = ngayxb;
		this.xuatxu = xuatxu;
		this.mathuvien = mathuvien;
	}
	public int getMasach() {
		return masach;
	}
	public void setMasach(int masach) {
		this.masach = masach;
	}
	public String getTensach() {
		return tensach;
	}
	public void setTensach(String tensach) {
		this.tensach = tensach;
	}
	public Date getNgayxb() {
		return ngayxb;
	}
	public void setNgayxb(Date ngayxb) {
		this.ngayxb = ngayxb;
	}
	public String getXuatxu() {
		return xuatxu;
	}
	public void setXuatxu(String xuatxu) {
		this.xuatxu = xuatxu;
	}
	public thuvien getMathuvien() {
		return mathuvien;
	}
	public void setMathuvien(thuvien mathuvien) {
		this.mathuvien = mathuvien;
	}
	
}
