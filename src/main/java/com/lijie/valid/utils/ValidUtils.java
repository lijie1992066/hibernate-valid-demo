package com.lijie.valid.utils;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.groups.Default;

import com.lijie.valid.domain.ValidException;

public class ValidUtils {

	private static Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

	/**
	 * 一个实例对象所有参数验证
	 * 
	 * @param entity
	 *            需要验证的参数对象
	 * @return
	 */
	public static <T> ValidException validateEntity(T entity) {
		ValidException result = new ValidException();
		Set<ConstraintViolation<T>> set = validator.validate(entity, Default.class);
		if (set != null && set.size() != 0) {
			result.setHasErrors(true);
			Map<String, String> errorMsg = new HashMap<String, String>();
			for (ConstraintViolation<T> cv : set) {
				errorMsg.put(cv.getPropertyPath().toString(), cv.getMessage());
			}
			result.setErrorMsg(errorMsg);
		}
		return result;
	}

	/**
	 * 验证一个实例对象的指定属性
	 * 
	 * @param entity
	 *            校验的实例
	 * @param propertyName
	 *            指定属性
	 * @return
	 */
	public static <T> ValidException validateProperty(T entity, String propertyName) {
		ValidException result = new ValidException();
		Set<ConstraintViolation<T>> set = validator.validateProperty(entity, propertyName, Default.class);
		if (set != null && set.size() != 0) {
			result.setHasErrors(true);
			Map<String, String> errorMsg = new HashMap<String, String>();
			for (ConstraintViolation<T> cv : set) {
				errorMsg.put(propertyName, cv.getMessage());
			}
			result.setErrorMsg(errorMsg);
		}
		return result;
	}
}
