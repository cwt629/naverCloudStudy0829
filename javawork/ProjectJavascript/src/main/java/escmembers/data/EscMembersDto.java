package escmembers.data;

import java.sql.Timestamp;

public class EscMembersDto {
	private String memcode;
	private String id;
	private String pw;
	private String favorplace;
	private Timestamp registeredDate;

	public String getMemcode() {
		return memcode;
	}

	public void setMemcode(String memcode) {
		this.memcode = memcode;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getFavorplace() {
		return favorplace;
	}

	public void setFavorplace(String favorplace) {
		this.favorplace = favorplace;
	}

	public Timestamp getRegisteredDate() {
		return registeredDate;
	}

	public void setRegisteredDate(Timestamp registeredDate) {
		this.registeredDate = registeredDate;
	}

}
