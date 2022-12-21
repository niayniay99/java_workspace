package VO;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="hbm_ann_taxi_statename")
public class Statevo {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	
	@Column(name="id")
	private int Stateid;
	
	@Column(name="statename")
	private String sn;

	public int getStateid() {
		return Stateid;
	}

	public void setStateid(int stateid) {
		Stateid = stateid;
	}

	public String getSn() {
		return sn;
	}

	public void setSn(String sn) {
		this.sn = sn;
	}
	
}
