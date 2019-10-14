package com.bootcamp.spring.data.domain.model;

import java.util.Arrays;

public enum  TypeEnum {
    COMPANY, AGENT;

	public static boolean hasValue(String tntType){
			return Arrays.stream(TypeEnum.values()).anyMatch(line -> tntType.equals(line.toString()));
	}
}
