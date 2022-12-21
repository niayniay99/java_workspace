package VO;

public class Cityvo {
	
		private int cityid;
		private String cityname;
		
		private Statevo statevo;
		

		public int getCityid() {
			return cityid;
		}

		public void setCityid(int cityid) {
			this.cityid = cityid;
		}

		public String getCityname() {
			return cityname;
		}

		public void setCityname(String cityname) {
			this.cityname = cityname;
		}

		public Statevo getStatevo() {
			return statevo;
		}

		public void setStatevo(Statevo statevo) {
			this.statevo = statevo;
		}		

}
