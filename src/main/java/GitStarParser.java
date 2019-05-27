import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;

public class GitStarParser {
	private static final GitStarParser instance = new GitStarParser();

	private static String jsonRaw;
	private final ObjectMapper objectMapper;
	private final TypeFactory typeFactory;

	private GitStarParser() {
		objectMapper = new ObjectMapper();
		typeFactory = objectMapper.getTypeFactory();
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
	}

	public static GitStarParser parser(String jsonRaw) {
		setJson(jsonRaw);
		return parser();
	}

	public static GitStarParser parser() {
		return instance;
	}

	public void parseArrayHelloWorld() {
		if (jsonRaw == null || jsonRaw.equals("")) {
			System.err.println("JSON VACÍO!");
			return;
		}

		try {
			List<GitStar> items = objectMapper.readValue(jsonRaw,
					typeFactory.constructCollectionType(List.class, GitStar.class));
			for (GitStar item : items) {
				System.out.println(item.toString());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void setJson(String rawJson) {
		jsonRaw = rawJson;
	}
}
