package net.individual.jmhreplaceall;

import java.util.function.Function;

public class Main {

	public static void main(String[] args) {
		System.out.println(SampleText.TEXT.length);
		final Function<String, String> translateFn = net.individual.jmhreplaceall.v17.TranslationUtils.translateFn;
		for (String s1 : SampleText.TEXT) {
			String s2 = translateFn.apply(s1);
			if (!s1.equals(s2)) {
				System.out.println(s1 + " > " + s2);
			}
		}
		System.out.println(translateFn.apply("äÄöÖüÜßéëèêôÀÅÁÂÇÈÉÊËàáâåæçÔÃãÃãÑñÕõÆòóøÒÓØìíîÌÍÎùúûÙÚïÏ"));
	}
}
