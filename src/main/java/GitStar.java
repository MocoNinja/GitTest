import com.fasterxml.jackson.annotation.JsonSetter;

public class GitStar {

	private Long id;
	private String name;
	private String fullName;
	private String description;
//	private String owner;
//	private String license;
	private String url;
	private String urlApi;
	private boolean privateRepo;
	private boolean fork;

	public String getDescription() {
		return description;
	}

	public String getFullName() {
		return fullName;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getUrl() {
		return url;
	}

	public String getUrlApi() {
		return urlApi;
	}

	public boolean isFork() {
		return fork;
	}

	public boolean isPrivateRepo() {
		return privateRepo;
	}

	@JsonSetter("description")
	public void setDescription(String description) {
		this.description = description;
	}

	public void setFork(boolean fork) {
		this.fork = fork;
	}

	@JsonSetter("full_name")
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	@JsonSetter("id")
	public void setId(Long id) {
		this.id = id;
	}

	@JsonSetter("name")
	public void setName(String name) {
		this.name = name;
	}

	@JsonSetter("private")
	public void setPrivateRepo(boolean privateRepo) {
		this.privateRepo = privateRepo;
	}

	@JsonSetter("html_url")
	public void setUrl(String url) {
		this.url = url;
	}

	@JsonSetter("url")
	public void setUrlApi(String urlApi) {
		this.urlApi = urlApi;
	}

	@Override
	public String toString() {
		return String.format(
				"GitStar [id=%s, name=%s, fullName=%s, description=%s, url=%s, urlApi=%s, privateRepo=%s, fork=%s]", id,
				name, fullName, description, url, urlApi, privateRepo, fork);
	}

	/*
	 * @JsonSetter("license") public void setLicense(String license) { this.license
	 * = license; }
	 */
}
