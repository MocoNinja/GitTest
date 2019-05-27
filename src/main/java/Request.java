import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

public class Request {
	private final String urlString;
	private final HttpURLConnection conn;

	public Request(String url) {
		this(url, "");
	}

	public Request(String url, String... a) {
		StringBuilder sb = new StringBuilder();
		sb.append(url);
		int index = 0;
		for (String arg : a) {
			sb.append(String.format("?%s", arg));
			if (index != 0 || index != a.length - 1) {
				sb.append("&");
			}
			index++;
		}
		urlString = sb.toString();
		conn = connect();
	}

	public Request GET() {
		performRequest("GET");
		return this;
	}

	public Request POST() {
		performRequest("POST");
		return this;
	}

	public String getBody() {
		BufferedReader in = null;
		try {
			in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		} catch (IOException e) {
			System.err.println("No se ha podido leer el cuerpo de la petición!");
		}
		StringBuffer content = new StringBuffer();
		String readLine;
		try {
			while ((readLine = in.readLine()) != null) {
				content.append(readLine);
			}
		} catch (IOException e) {
			System.err.println("Error leyendo el cuerpo de la petición!");
		}
		return content.toString();
	}

	private void performRequest(String method) {
		try {
			conn.setRequestMethod(method);
		} catch (ProtocolException e) {
			System.err.println("No se ha podido realizar la petición " + method + "!");
		} catch (NullPointerException e) {
			System.err.println("La conexión no existe!");
		}
	}

	private HttpURLConnection connect() {
		HttpURLConnection conn = null;
		try {
			conn = (HttpURLConnection) new URL(urlString).openConnection();
		} catch (MalformedURLException e) {
			System.err.println("La url está mal formada!");
		} catch (IOException e) {
			System.err.println("Ha habido un error realizando la petición!");
		}
		return conn;
	}

	public String getUrl() {
		return urlString;
	}
}