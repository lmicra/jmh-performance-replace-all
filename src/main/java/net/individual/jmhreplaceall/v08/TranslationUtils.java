package net.individual.jmhreplaceall.v08;

import java.util.ArrayList;
import java.util.List;
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

	private static final List<Translation> TRANSLATIONS;
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
		TRANSLATIONS = new ArrayList<>();
		StringBuilder globalCheck = new StringBuilder();
		for (String[] translation : translationMatrix) {
			globalCheck.append(translation[0]);
			TRANSLATIONS.add(new Translation(translation[0], translation[1]));
		}
		GLOBAL_PATTERN = Pattern.compile("[" + globalCheck.toString() + "]");
	}

	public static String translate(final String strText) {
		if (!GLOBAL_PATTERN.matcher(strText).find()) {
			return strText;
		}
		return TRANSLATIONS.stream().reduce(strText, (str, translation) -> translation.translate(str), (s1, s2) -> s2);
	}

	public static Function<String, String> translateFn = (strText) -> translate(strText);
}
