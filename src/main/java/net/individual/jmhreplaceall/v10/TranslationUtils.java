package net.individual.jmhreplaceall.v10;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import static net.individual.jmhreplaceall.TranslationUtilsTable.MATRIX;

public class TranslationUtils {

	private static final Pattern GLOBAL_PATTERN;
	private static final List<String> FROM;
	private static final List<String> TO;

	static {
		StringBuilder globalCheck = new StringBuilder();
		FROM = new ArrayList<>();
		TO = new ArrayList<>();
		for (String[] translation : MATRIX) {
			globalCheck.append(translation[0]);
			for (char c : translation[0].toCharArray()) {
				FROM.add(String.valueOf(c));
				TO.add(translation[1]);
			}
		}
		GLOBAL_PATTERN = Pattern.compile("[" + globalCheck.toString() + "]");
	}

	public static String translate(final String strText) {
		final Matcher matcher = GLOBAL_PATTERN.matcher(strText);
		StringBuilder sb = new StringBuilder();
		int start = 0;
		while (matcher.find()) {
			if (start - matcher.end() != 0) {
				sb.append(strText.substring(start, matcher.end() -1));
			}
			// System.out.format("%s, %d\n", matcher.group(), FROM.indexOf(matcher.group()));
			sb.append(TO.get(FROM.indexOf(matcher.group())));
			start = matcher.end();
		}
		sb.append(strText.substring(start));
		return sb.toString();
	}

	public static Function<String, String> translateFn = (strText) -> translate(strText);
}
