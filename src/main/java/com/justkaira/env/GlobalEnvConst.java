package com.justkaira.env;

import com.justkaira.localization.constants.LanguageCode;

import java.nio.file.Paths;
import java.util.Arrays;

public class GlobalEnvConst {
	public static String VERSION = "1.0.0";
	public static String SERVICE_ID = Paths.get(System.getProperty("user.dir")).getFileName().toString();
	public static String SERVICE_NAME = SERVICE_ID;

	public static String[] DEFAULT_LANGS = { "ENG", "FRA" };
	public static String LOGO = "";
	public static String TMP_DIR = System.getProperty("java.io.tmpdir");
	public static int DEFAULT_PAGE_SIZE = 10;

	public static String DEFAULT_LANG = DEFAULT_LANGS[0];

	public static LanguageCode getDefaultLang() {
		return LanguageCode.valueOf(GlobalEnvConst.DEFAULT_LANG);
	}

	public static final LanguageCode[] getDefaultLangs() {
		return Arrays.stream(DEFAULT_LANGS).map((v) -> LanguageCode.valueOf(v)).toArray(LanguageCode[]::new);
	}

	public static final String SERVICE_PACKAGE = "com.justkaira.mscommon";
}
