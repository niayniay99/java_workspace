package vo;

public class Regvo {
	private int id;
	private String firstname;
	private String lastname;
	
	private Logvo logvo;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public Logvo getLogvo() {
		return logvo;
	}
	public void setLogvo(Logvo logvo) {
		this.logvo = logvo;
	}
}
