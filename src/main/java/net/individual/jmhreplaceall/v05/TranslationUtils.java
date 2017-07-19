package net.individual.jmhreplaceall.v05;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class TranslationUtils {

	static class Translation {

		private final Pattern pattern;
		private final String replacement;

		public Translation(String regEx, String replacement) {
			this.pattern = Pattern.compile(regEx);
			this.replacement = replacement;
		}

		public String translate(final String from) {
			return this.pattern.matcher(from).replaceAll(this.replacement);
		}
	}

	private static final List<Translation> TRANSLATIONS;

	static {
		TRANSLATIONS = Arrays.asList(
				new String[][]{
					{"[äàáâåãã]", "a"},
					{"[éëèê]", "e"},
					{"[ìíîï]", "i"},
					{"[öôõòóø]", "o"},
					{"[üùúû]", "u"},
					{"[ÄÀÅÁÂÃÃ]", "A"},
					{"[ÈÉÊË]", "E"},
					{"[ÌÍÎÏ]", "I"},
					{"[ÖÔÕÒÓØ]", "O"},
					{"[ÜÙÚÛ]", "U"},
					{"[æ]", "ae"},
					{"[Æ]", "AE"},
					{"[ç]", "c"},
					{"[Ç]", "C"},
					{"[ñ]", "n"},
					{"[Ñ]", "N"},
					{"[ß]", "ss"}
				})
				.stream()
				.map((String[] s) -> new Translation(s[0], s[1]))
				.collect(Collectors.toList());
	}

	public static String translate(final String strText) {
		String r = strText;
		for (Translation translation : TRANSLATIONS) {
			r = translation.translate(r);
		}
		return r;
	}

	public static Function<String, String> translateFn = (strText) -> translate(strText);
}
