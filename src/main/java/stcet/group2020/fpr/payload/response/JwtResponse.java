package stcet.group2020.fpr.payload.response;


public class JwtResponse {
	private String token;
	private String type = "Bearer";
	private String id;
	private String name;
	private int deptId;

	public JwtResponse(String accessToken, String id, String name, int deptId) {
		this.token = accessToken;
		this.id = id;
		this.name = name;
		this.deptId = deptId;
	}

	public String getAccessToken() {
		return token;
	}

	public void setAccessToken(String accessToken) {
		this.token = accessToken;
	}

	public String getTokenType() {
		return type;
	}

	public void setTokenType(String tokenType) {
		this.type = tokenType;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getDeptId() {
		return deptId;
	}

	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}

}
