package net.individual.jmhreplaceall.v07;

import java.util.function.Function;
import java.util.regex.Pattern;

public class TranslationUtils {

	public static class Translation {

		private final Pattern pattern;
		private final String replacement;

		public Translation(String regEx, String replacement) {
			this.pattern = Pattern.compile("[" + regEx + "]");
			this.replacement = replacement;
		}

		public String translate(final String from) {
			return this.pattern.matcher(from).replaceAll(this.replacement);
		}
	}

	private static final Translation[] TRANSLATIONS;
	private static final Pattern GLOBAL_PATTERN;

	static {
		String[][] translationMatrix = new String[][]{
			{"äàáâåãã", "a"},
			{"éëèê", "e"},
			{"ìíîï", "i"},
			{"öôõòóø", "o"},
			{"üùúû", "u"},
			{"ÄÀÅÁÂÃÃ", "A"},
			{"ÈÉÊË", "E"},
			{"ÌÍÎÏ", "I"},
			{"ÖÔÕÒÓØ", "O"},
			{"ÜÙÚÛ", "U"},
			{"æ", "ae"},
			{"Æ", "AE"},
			{"ç", "c"},
			{"Ç", "C"},
			{"ñ", "n"},
			{"Ñ", "N"},
			{"ß", "ss"}
		};
		int translationMatrixLength = translationMatrix.length;
		TRANSLATIONS = new Translation[translationMatrixLength];
		StringBuilder globalCheck = new StringBuilder();
		for (int i = translationMatrixLength - 1; i >= 0; i--) {
			globalCheck.append(translationMatrix[i][0]);
			TRANSLATIONS[i] = new Translation(translationMatrix[i][0], translationMatrix[i][1]);
		}
		GLOBAL_PATTERN = Pattern.compile("[" + globalCheck.toString() + "]");
	}

	public static String translate(final String strText) {
		if (!GLOBAL_PATTERN.matcher(strText).find()) {
			return strText;
		}
		String r = strText;
		for (Translation translation : TRANSLATIONS) {
			r = translation.translate(r);
		}
		return r;
	}

	public static Function<String, String> translateFn = (strText) -> translate(strText);
}
