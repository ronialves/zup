package com.tlf.oss.resourceinventory.cpe.utils;

import java.lang.reflect.Field;

import org.apache.commons.beanutils.PropertyUtils;

public abstract class ReflectionUtils {

	@SuppressWarnings("unchecked")
	public static <T> T getFieldAnnotation(Field field, Class c) {
		return (T) field.getAnnotation(c);
	}

	public static <T> Object executeGetter(Field field, T object) {
		try {
			return PropertyUtils.getProperty(object, field.getName());

		} catch (Exception e) {
			return null;
		}
	}
}
