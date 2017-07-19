package net.individual.jmhreplaceall.v15;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import java.util.concurrent.ExecutionException;
import java.util.function.Function;

public class TranslationUtils {

	private static final char[] FROM;
	private static final String[] TO;
	private static final int LENGTH;

	static {
		final String[][] MATRIX = new String[][]{
			{"ä", "a"},
			{"Ä", "A"},
			{"ö", "o"},
			{"Ö", "O"},
			{"ü", "u"},
			{"Ü", "U"},
			{"ß", "ss"},
			{"é", "e"},
			{"ë", "e"},
			{"è", "e"},
			{"ê", "e"},
			{"ô", "o"},
			{"À", "A"},
			{"Å", "A"},
			{"Á", "A"},
			{"Â", "A"},
			{"Ç", "C"},
			{"È", "E"},
			{"É", "E"},
			{"Ê", "E"},
			{"Ë", "E"},
			{"à", "a"},
			{"á", "a"},
			{"â", "a"},
			{"å", "a"},
			{"æ", "ae"},
			{"ç", "c"},
			{"Ô", "O"},
			{"Ã", "A"},
			{"ã", "a"},
			{"Ã", "A"},
			{"ã", "a"},
			{"Ñ", "N"},
			{"ñ", "n"},
			{"Õ", "O"},
			{"õ", "o"},
			{"Æ", "AE"},
			{"ò", "o"},
			{"ó", "o"},
			{"ø", "o"},
			{"Ò", "O"},
			{"Ó", "O"},
			{"Ø", "O"},
			{"ì", "i"},
			{"í", "i"},
			{"î", "i"},
			{"Ì", "I"},
			{"Í", "I"},
			{"Î", "I"},
			{"ù", "u"},
			{"ú", "u"},
			{"û", "u"},
			{"Ù", "U"},
			{"Ú", "U"},
			{"ï", "i"},
			{"Ï", "I"}
		};
		LENGTH = MATRIX.length;
		FROM = new char[LENGTH];
		TO = new String[LENGTH];
		for (int i = LENGTH; i-- > 0;) {
			FROM[i] = MATRIX[i][0].charAt(0);
			TO[i] = MATRIX[i][1];
		}
	}

	private static final LoadingCache<String, String> CACHE = CacheBuilder.newBuilder()
			.maximumSize(1000)
			.build(new CacheLoader<String, String>() {

				@Override
				public String load(String key) throws Exception {
					StringBuilder sb = new StringBuilder();
					char[] strCharArray = key.toCharArray();
					nextChar:
					for (char c : strCharArray) {
						if (c < 127) {
							sb.append(c);
							continue;
						}
						for (int i = LENGTH; i-- > 0;) {
							if (FROM[i] == c) {
								sb.append(TO[i]);
								continue nextChar;
							}
						}
						sb.append(c);
					}
					return sb.toString();
				}
			});

	public static String translate(final String strText) {
		try {
			return CACHE.get(strText);
		} catch (ExecutionException ex) {
			return "";
		}
	}

	public static Function<String, String> translateFn = (strText) -> translate(strText);
}
