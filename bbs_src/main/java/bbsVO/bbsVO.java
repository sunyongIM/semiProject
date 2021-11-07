package bbsVO;

public class bbsVO {
	private String id;
	private String title;
	private String message;
	
	public bbsVO() {
		
	}
	public bbsVO(String id, String title,String message) {
		this.id = id;
		this.title = title;
		this.message = message;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
}
