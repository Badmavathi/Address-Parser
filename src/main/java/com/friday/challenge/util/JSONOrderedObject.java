package com.friday.challenge.util;

import java.io.IOException;
import java.io.Writer;
import java.util.LinkedHashMap;
import java.util.Map;

import org.json.simple.JSONAware;
import org.json.simple.JSONObject;
import org.json.simple.JSONStreamAware;
/**
 * 
 * @author Badmavathi Balaji
 * Custom implementation with LinkedHashMap to
 *  maintain ordering of the JSONObject
 */
public class JSONOrderedObject extends LinkedHashMap<String, Object>
		implements Map<String, Object>, JSONAware, JSONStreamAware {

	private static final long serialVersionUID = 1L;

	public String toJSONString() {
		return JSONObject.toJSONString(this);
	}

	public void writeJSONString(Writer writer) throws IOException {
		JSONObject.writeJSONString(this, writer);
	}

}