package com.justkaira.rest.outgoing;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;

public class Outcome {
	public static final String STRING_PAYLOAD = "text";
	public static final String ENTITY_PAYLOAD = "entity";
	public static final String VIEW_PAGE_PAYLOAD = "view";
	public static final String ENTITY_LIST_PAYLOAD = "list";
	public static final String EXCEPTION_PAYLOAD = "error";

	protected final static String UNDEFINED_ID = "undefined";
	protected String id = UNDEFINED_ID;
	protected String title;
	protected String payloadTitle = "payloda of " + title;
	protected LinkedHashMap<String, Object> payload = new LinkedHashMap<>();

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public Outcome setTitle(String title) {
		this.title = title;
		if (payloadTitle == null) {
			payloadTitle = title;
		}
		return this;
	}

	public Outcome addPayload(String key, Object val) {
		payload.put(key, val);
		return this;
	}

	public LinkedHashMap<String, Object> getPayload() {
		return payload;
	}

	public Outcome setPayloadTitle(String title) {
		payloadTitle = title;
		if (this.title == null) {
			this.title = title;
		}
		return this;
	}

	public Outcome addPayload(Exception e) {
		payload.put(EXCEPTION_PAYLOAD, e);
		return this;
	}

	public Outcome addPayload(String s) {
		payload.put(STRING_PAYLOAD, s);
		return this;
	}

    public Outcome addPayload(List endpoints) {
		payload.put(ENTITY_LIST_PAYLOAD, endpoints);
		return this;
    }

	public Outcome addPayload(int data) {
		addPayload(Integer.toString(data));
		return this;
	}

	public Outcome addPayload(Object[] array) {
		addPayload(Arrays.asList(array));
		return this;
	}
}
