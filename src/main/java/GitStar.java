import com.fasterxml.jackson.annotation.JsonSetter;

public class GitStar {

	private Long id;
	private String name;
	private String fullName;
	private String description;
	private Object owner;
	private Object license;
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

	public Object getLicense() {
		return license;
	}

	public String getName() {
		return name;
	}

	public Object getOwner() {
		return owner;
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

	@JsonSetter("fork")
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

	@JsonSetter("license")
	public void setLicense(Object license) {
		this.license = license;
	}

	@JsonSetter("name")
	public void setName(String name) {
		this.name = name;
	}

	@JsonSetter("owner")
	public void setOwner(Object owner) {
		this.owner = owner;
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
				"GitStar [id=%s, name=%s, fullName=%s, description=%s, owner=%s, license=%s, url=%s, urlApi=%s, privateRepo=%s, fork=%s]",
				id, name, fullName, description, owner, license, url, urlApi, privateRepo, fork);
	}
}
