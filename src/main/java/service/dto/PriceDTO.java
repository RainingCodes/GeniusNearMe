package service.dto;

public class PriceDTO {
	private int talentID = -1;
	private int headCount = -1;
	private int price = -1;
	
	public PriceDTO() {
		
	}
	
	public PriceDTO(int talentID, int headCount, int price) {
		super();
		this.talentID = talentID;
		this.headCount = headCount;
		this.price = price;
	}
	
	public int getTalentID() {
		return talentID;
	}
	public void setTalentID(int talentID) {
		this.talentID = talentID;
	}
	public int getHeadCount() {
		return headCount;
	}
	public void setHeadCount(int headCount) {
		this.headCount = headCount;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	
}
