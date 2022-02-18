package dto;

public class SalesDTO {

	private int custno;
	private String custname;
	private String grade;
	private int sumsales;

	public int getCustno() {
		return custno;
	}

	public void setCustno(int custno) {
		this.custno = custno;
	}

	public String getCustname() {
		return custname;
	}

	public void setCustname(String custname) {
		this.custname = custname;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public int getSumsales() {
		return sumsales;
	}

	public void setSumsales(int sumsales) {
		this.sumsales = sumsales;
	}
}
