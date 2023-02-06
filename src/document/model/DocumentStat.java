package document.model;

public class DocumentStat {

	private int stat_no;
	private String stat_name;

	public DocumentStat(int stat_no, String stat_name) {
		this.stat_no = stat_no;
		this.stat_name = stat_name;
	}
	
	
	public int getStat_no() {
		return stat_no;
	}

	public String getStat_name() {
		return stat_name;
	}

	@Override
	public String toString() {
		return "DocumentStat [stat_no=" + stat_no + ", stat_name=" + stat_name + "]";
	}
}
