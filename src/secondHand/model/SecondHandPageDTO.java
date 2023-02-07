package secondHand.model;

public class SecondHandPageDTO {

	private final int pageBlock = 5;
	private int currentPage;
	private int startPage;
	private int endPage;
	private int realEndPage;
	private int startRow;
	private int endRow;
	
	public SecondHandPageDTO(int currentPage) {
		System.out.println("page 생성자 호출");
		int totalRows = new SecondHandDAO().totalRows();
		this.currentPage = currentPage;
		this.realEndPage = totalRows/6 + (totalRows%6 == 0 ? 0 : 1);
		this.startPage = ((currentPage-1)/pageBlock)*pageBlock+1;
		this.endPage = startPage + pageBlock - 1;
		this.startRow = (currentPage-1)*6;
		this.endRow = startRow + 7;
	}
	public SecondHandPageDTO(int currentPage, String keyword) {
		System.out.println("page 생성자 호출");
		int totalRows = new SecondHandDAO().searchTotalRows(keyword);
		this.currentPage = currentPage;
		this.realEndPage = totalRows/6 + (totalRows%6 == 0 ? 0 : 1);
		this.startPage = ((currentPage-1)/pageBlock)*pageBlock+1;
		this.endPage = startPage + pageBlock - 1;
		this.startRow = (currentPage-1)*6;
		this.endRow = startRow + 7;
	}

	public int getPageBlock() {
		return pageBlock;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public int getStartPage() {
		return startPage;
	}

	public int getEndPage() {
		if(this.endPage > this.realEndPage) {
			this.endPage = this.realEndPage;
		}
		return endPage;
	}

	public int getRealEndPage() {
		return realEndPage;
	}

	public int getStartRow() {
		return startRow;
	}

	public int getEndRow() {
		return endRow;
	}

	@Override
	public String toString() {
		return "SecondHandPageDTO [pageBlock=" + pageBlock + ", currentPage=" + currentPage + ", startPage=" + startPage
				+ ", endPage=" + endPage + ", realEndPage=" + realEndPage + ", startRow=" + startRow + ", endRow="
				+ endRow + "]";
	}
	
	
}
