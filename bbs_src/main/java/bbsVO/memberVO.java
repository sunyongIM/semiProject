package bbsVO;

public class memberVO {
	private String name;
	private String id;
	private String pwd;
	private String email;
	
	public memberVO(String name, String id, String pwd, String email) {
		this.name = name;
		this.id = id;
		this.pwd = pwd;
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}
