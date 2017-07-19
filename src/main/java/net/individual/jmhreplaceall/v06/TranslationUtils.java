package net.individual.jmhreplaceall.v06;

import java.util.function.Function;
import java.util.regex.Pattern;

public class TranslationUtils {

	private static class Translation {

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

	private static final Translation[] TRANSLATIONS;

	static {
		String[][] translationMatrix = new String[][]{
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
		};
		int translationMatrixLength = translationMatrix.length;
		TRANSLATIONS = new Translation[translationMatrixLength];
		for (int i = translationMatrixLength - 1; i >= 0; i--) {
			TRANSLATIONS[i] = new Translation(translationMatrix[i][0], translationMatrix[i][1]);
		}
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
