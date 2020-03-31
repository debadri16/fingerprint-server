package stcet.group2020.fpr.payload.response;


public class JwtResponse {
	private String token;
	private String type = "Bearer";
	private String adminId;
	private String name;
	private int deptId;

	public JwtResponse(String accessToken, String adminId, String name, int deptId) {
		this.token = accessToken;
		this.adminId = adminId;
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

	public String getAdminId() {
		return adminId;
	}

	public void setAdminId(String adminId) {
		this.adminId = adminId;
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
