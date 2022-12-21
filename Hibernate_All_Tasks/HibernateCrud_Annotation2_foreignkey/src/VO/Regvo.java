package VO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="hbn_ann2_reg")
public class Regvo {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private int regid;
	
	@Column(name="fn")
	private String fn;
	
	@Column(name="ln")
	private String ln;
	
	@ManyToOne
	@JoinColumn(name="Logid")
	private Logvo lvo;
	
	
	public int getRegid() {
		return regid;
	}

	public void setRegid(int regid) {
		this.regid = regid;
	}

	public String getFn() {
		return fn;
	}

	public void setFn(String fn) {
		this.fn = fn;
	}

	public String getLn() {
		return ln;
	}

	public void setLn(String ln) {
		this.ln = ln;
	}
		
	public Logvo getLvo() {
		return lvo;
	}

	public void setLvo(Logvo lvo) {
		this.lvo = lvo;
	}

}
