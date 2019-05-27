
public class App {
	public static void main(String[] args) {
		String url = "https://api.github.com/users/moconinja/starred";
		Request r = new Request(url, "per_page=1000");
//		Request r = new Request(url);
		String b = r.GET().getBody();
		System.out.println(b);
	}
}
