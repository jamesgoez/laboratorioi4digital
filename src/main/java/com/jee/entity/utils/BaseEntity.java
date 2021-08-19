package com.jee.entity.utils;

public interface  BaseEntity {

	Long getId();
	boolean equals(Object object);
	int hashCode();
	String getItemLabel();
}
