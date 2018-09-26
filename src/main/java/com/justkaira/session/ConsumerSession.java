package com.justkaira.session;

import java.io.File;
import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.justkaira.env.GlobalEnvConst;
import com.justkaira.localization.constants.LanguageCode;

public class ConsumerSession implements Serializable {
	private static final long serialVersionUID = 1L;
	private IUser user = new AnonymousUser();
	private String token;
	private LanguageCode lang = LanguageCode.ENG;
	private int pageSize = 10;
	private String redirectURL = "explorations";
	private boolean isAuthenticated;

	public ConsumerSession() {

	}

	public ConsumerSession(IUser user) {
		this.user = user;
	}

	public LanguageCode getLang() {
		return lang;
	}

	public void setLang(LanguageCode lang) {
		this.lang = lang;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public IUser getUser() {
		return user;
	}

	public void setUser(IUser user) {
		this.user = user;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getRedirectURL() {
		return redirectURL;
	}

	public void setRedirectURL(String redirectURL) {
		this.redirectURL = redirectURL;
	}

	public boolean isAuthenticated() {
		return isAuthenticated;
	}

	@JsonIgnore
	public File getTmpDir() {
		File userTmpDir = new File(
				GlobalEnvConst.TMP_DIR + File.separator + GlobalEnvConst.SERVICE_NAME + File.separator + user.getId());
		if (!userTmpDir.exists()) {
			userTmpDir.mkdirs();
		}
		return userTmpDir;
	}

}
