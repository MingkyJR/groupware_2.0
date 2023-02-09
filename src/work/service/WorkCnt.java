package work.service;

public class WorkCnt {
	
	private int total;
	private int normal;
	private int abnormal;
	private int edit;
	
	
	public WorkCnt(int total, int normal, int abnormal, int edit) {
		this.total = total;
		this.normal = normal;
		this.abnormal = abnormal;
		this.edit = edit;
	}


	public int getTotal() {
		return total;
	}


	public void setTotal(int total) {
		this.total = total;
	}


	public int getNormal() {
		return normal;
	}


	public void setNormal(int normal) {
		this.normal = normal;
	}


	public int getAbnormal() {
		return abnormal;
	}


	public void setAbnormal(int abnormal) {
		this.abnormal = abnormal;
	}


	public int getEdit() {
		return edit;
	}


	public void setEdit(int edit) {
		this.edit = edit;
	}


	@Override
	public String toString() {
		return "WorkCnt [total=" + total + ", normal=" + normal + ", abnormal=" + abnormal + ", edit=" + edit + "]";
	}
	
	
	
	

}
