package net.individual.jmhreplaceall;

import java.util.Arrays;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class TranslationUtilsTest {

	private static final String[][] TEST_STRINGS = {
		{"äÄöÖüÜßéëèêôÀÅÁÂÇÈÉÊËàáâåæçÔÃãÃãÑñÕõÆòóøÒÓØìíîÌÍÎùúûÙÚïÏ", "aAoOuUsseeeeoAAAACEEEEaaaaaecOAaAaNnOoAEoooOOOiiiIIIuuuUUiI"},
		{"Mäßig", "Massig"},
		{"Tschüs", "Tschus"},
		{"Calvário", "Calvario"},
		{"Órfão", "Orfao"},
		{"Verheißungsvoll-Ungeheure", "Verheissungsvoll-Ungeheure"}
	};

	@Test
	public void testV1Translations() {
		Arrays.asList(TEST_STRINGS).stream()
				.forEach(testString -> assertEquals(net.individual.jmhreplaceall.v01.TranslationUtils.translate(testString[0]), testString[1]));
	}

	@Test
	public void testV2Translations() {
		Arrays.asList(TEST_STRINGS).stream()
				.forEach(testString -> assertEquals(net.individual.jmhreplaceall.v02.TranslationUtils.translate(testString[0]), testString[1]));
	}

	@Test
	public void testV3Translations() {
		Arrays.asList(TEST_STRINGS).stream()
				.forEach(testString -> assertEquals(net.individual.jmhreplaceall.v03.TranslationUtils.translate(testString[0]), testString[1]));
	}

	@Test
	public void testV4Translations() {
		Arrays.asList(TEST_STRINGS).stream()
				.forEach(testString -> assertEquals(net.individual.jmhreplaceall.v04.TranslationUtils.translate(testString[0]), testString[1]));
	}

	@Test
	public void testV5Translations() {
		Arrays.asList(TEST_STRINGS).stream()
				.forEach(testString -> assertEquals(net.individual.jmhreplaceall.v05.TranslationUtils.translate(testString[0]), testString[1]));
	}

	@Test
	public void testV6Translations() {
		Arrays.asList(TEST_STRINGS).stream()
				.forEach(testString -> assertEquals(net.individual.jmhreplaceall.v06.TranslationUtils.translate(testString[0]), testString[1]));
	}

	@Test
	public void testV7Translations() {
		Arrays.asList(TEST_STRINGS).stream()
				.forEach(testString -> assertEquals(net.individual.jmhreplaceall.v07.TranslationUtils.translate(testString[0]), testString[1]));
	}

	@Test
	public void testV8Translations() {
		Arrays.asList(TEST_STRINGS).stream()
				.forEach(testString -> assertEquals(net.individual.jmhreplaceall.v08.TranslationUtils.translate(testString[0]), testString[1]));
	}

	@Test
	public void testV9Translations() {
		Arrays.asList(TEST_STRINGS).stream()
				.forEach(testString -> assertEquals(net.individual.jmhreplaceall.v09.TranslationUtils.translate(testString[0]), testString[1]));
	}

	@Test
	public void testV10Translations() {
		Arrays.asList(TEST_STRINGS).stream()
				.forEach(testString -> assertEquals(net.individual.jmhreplaceall.v10.TranslationUtils.translate(testString[0]), testString[1]));
	}

	@Test
	public void testV11Translations() {
		Arrays.asList(TEST_STRINGS).stream()
				.forEach(testString -> assertEquals(net.individual.jmhreplaceall.v11.TranslationUtils.translate(testString[0]), testString[1]));
	}

	@Test
	public void testV12Translations() {
		Arrays.asList(TEST_STRINGS).stream()
				.forEach(testString -> assertEquals(net.individual.jmhreplaceall.v12.TranslationUtils.translate(testString[0]), testString[1]));
	}

	@Test
	public void testV13Translations() {
		Arrays.asList(TEST_STRINGS).stream()
				.forEach(testString -> assertEquals(net.individual.jmhreplaceall.v13.TranslationUtils.translate(testString[0]), testString[1]));
	}

	@Test
	public void testV14Translations() {
		Arrays.asList(TEST_STRINGS).stream()
				.forEach(testString -> assertEquals(net.individual.jmhreplaceall.v14.TranslationUtils.translate(testString[0]), testString[1]));
	}

	@Test
	public void testV15Translations() {
		Arrays.asList(TEST_STRINGS).stream()
				.forEach(testString -> assertEquals(net.individual.jmhreplaceall.v15.TranslationUtils.translate(testString[0]), testString[1]));
	}

	@Test
	public void testV16Translations() {
		Arrays.asList(TEST_STRINGS).stream()
				.forEach(testString -> assertEquals(net.individual.jmhreplaceall.v16.TranslationUtils.translate(testString[0]), testString[1]));
	}

	@Test
	public void testV17Translations() {
		Arrays.asList(TEST_STRINGS).stream()
				.forEach(testString -> assertEquals(net.individual.jmhreplaceall.v17.TranslationUtils.translate(testString[0]), testString[1]));
	}
}
