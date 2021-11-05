package model;

public class Review {
	private String id;
	private String writeDate;
	private String content;
	private float rate;
	private Care careInfo;
	
	public Review(String id, String writeDate, String content, float rate, Care careInfo) {
		super();
		this.id = id;
		this.writeDate = writeDate;
		this.content = content;
		this.rate = rate;
		this.careInfo = careInfo;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getWriteDate() {
		return writeDate;
	}
	public void setWriteDate(String writeDate) {
		this.writeDate = writeDate;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public float getRate() {
		return rate;
	}
	public void setRate(float rate) {
		this.rate = rate;
	}
	public Care getCareInfo() {
		return careInfo;
	}
	public void setCareInfo(Care careInfo) {
		this.careInfo = careInfo;
	}
}
