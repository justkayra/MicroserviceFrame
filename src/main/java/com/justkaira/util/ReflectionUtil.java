package com.justkaira.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import com.justkaira.cli.task.Command;
import com.justkaira.logger.Lg;

public class ReflectionUtil {

	public static Map<String, Class> getTaskClasses(String pack) {

		Map<String, Class> classes = new HashMap();
		URL upackage = ReflectionUtil.class.getClassLoader().getResource(pack.replace(".", File.separator));

		if (upackage != null) {
			BufferedReader dis = null;
			try {
				dis = new BufferedReader(new InputStreamReader((InputStream) upackage.getContent()));
				String line = null;
				while ((line = dis.readLine()) != null) {
					if (line.endsWith(".class")) {
						Class<?> clazz = Class.forName(pack + "." + line.substring(0, line.lastIndexOf('.')));
						Command annotation = clazz.getAnnotation(Command.class);
						if (annotation != null) {
							classes.put(annotation.name(), clazz);
						}
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} finally {
				if (dis != null) {
					try {
						dis.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		} else {
			Lg.error("incorrect path " + pack);
		}
		return classes;
	}

}
