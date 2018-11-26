package com.baizhi.util;

import java.util.UUID;

public class CreateID {
	public static String getId(){
		String id = UUID.randomUUID().toString().replaceAll("-", "");
		return id;
	}
}
