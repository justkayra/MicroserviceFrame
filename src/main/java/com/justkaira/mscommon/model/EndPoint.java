package com.justkaira.mscommon.model;

import java.net.URL;

public class EndPoint implements IAppEntity{
	private URL url;
	private String method;
	private String description;

	public URL getUrl() {
		return url;
	}

	public void setUrl(URL url) {
		this.url = url;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
