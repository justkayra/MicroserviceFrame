package com.justkaira.shell;

import com.justkaira.env.Environment;
import com.justkaira.env.GlobalEnvConst;
import org.springframework.shell.standard.ShellMethod;

import java.io.File;

public class Info {
	public static final String format = "%-40s%s%n";

	@ShellMethod("Show basic info of the service")
	public String info() {
		Class<?> envConstClass;
		try {
			envConstClass = Class.forName(Environment.SERVICE_PACKAGE + ".env.EnvConst");
			System.out.printf(format, "sevice name", envConstClass.getDeclaredField("SERVICE_NAME").get(null)
					+ "(" + envConstClass.getDeclaredField("SERVICE_ID").get(null) + ")");
			System.out.printf(format, "version", envConstClass.getDeclaredField("VERSION").get(null));
			System.out.printf(format, "os",
					System.getProperty("os.version") + "(" + System.getProperty("os.arch") + ")");
			System.out.printf(format, "jvm", System.getProperty("java.version"));
			System.out.printf(format, "work directory", new File("").getAbsolutePath());
			String defaultLang = "";
			try {
				defaultLang = (String) envConstClass.getDeclaredField("DEFAULT_LANG").get(null);
			} catch (NoSuchFieldException e) {
				defaultLang = GlobalEnvConst.DEFAULT_LANG;
			}
			System.out.printf(format, "default language", defaultLang);
			File file = new File(File.separator);
			long totalSpace = file.getTotalSpace();
			long freeSpace = file.getFreeSpace();
			System.out.printf(format, "total disk size", totalSpace / 1024 / 1024 / 1024 + " gb");
			System.out.printf(format, "space free", freeSpace / 1024 / 1024 / 1024 + " gb");
			System.out.printf(format, "service package", Environment.SERVICE_PACKAGE);
		} catch (ClassNotFoundException e) {
			System.out.println(e);
		} catch (IllegalArgumentException e) {
			System.out.println(e);
		} catch (IllegalAccessException e) {
			System.out.println(e);
		} catch (NoSuchFieldException e) {
			System.out.println(e);
		} catch (SecurityException e) {
			System.out.println(e);
		}
		return "done";
	}
}
