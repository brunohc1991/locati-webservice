package com.locati.webservice.resources.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class URL {

	public static List<Long> decodeLongList(String text) {
		if(text == null || text.isEmpty()) {
			return new ArrayList<>();
		}
	    return Arrays.stream(text.split(","))
                .map(Long::valueOf)
                .toList();
	}
	
	public static String decodeParam(String text) {
		try {
			return URLDecoder.decode(text, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return "";
		}
	}
}
