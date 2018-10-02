package com.justkaira.shell;

import com.justkaira.env.GlobalEnvConst;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.EnumerablePropertySource;
import org.springframework.core.env.Environment;
import org.springframework.core.env.PropertySource;
import org.springframework.shell.standard.ShellMethod;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class Info {
	public static final String format = "%-40s%s%n";

	@Autowired
	private Environment env;

	@ShellMethod("Show basic info of the service")
	public String info() {
		Class<?> envConstClass;
		try {
			envConstClass = Class.forName(GlobalEnvConst.SERVICE_PACKAGE + ".env.EnvConst");
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
			System.out.printf(format, "service package", GlobalEnvConst.SERVICE_PACKAGE);
			//getAllKnownProperties(env).forEach(val-> System.out.printf(format, val));
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

	public Map<String, Object> getAllKnownProperties(Environment env) {
		Map<String, Object> rtn = new HashMap<>();
		if (env instanceof ConfigurableEnvironment) {
			for (PropertySource<?> propertySource : ((ConfigurableEnvironment) env).getPropertySources()) {
				if (propertySource instanceof EnumerablePropertySource) {
					for (String key : ((EnumerablePropertySource) propertySource).getPropertyNames()) {
						rtn.put(key, propertySource.getProperty(key));
					}
				}
			}
		}
		return rtn;
	}
}
