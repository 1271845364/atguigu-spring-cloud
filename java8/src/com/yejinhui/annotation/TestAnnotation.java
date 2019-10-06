package com.yejinhui.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

import org.junit.Test;

/**
 * 重复注解与类型注解
 * 
 * @author ye.jinhui
 * @date 2018年8月13日
 */
public class TestAnnotation {

	// checker framework
	private /* @NonNull */ Object obj = null;

	@Test
	public void test1() throws Exception {
		Class<TestAnnotation> clazz = TestAnnotation.class;
		Method method = clazz.getMethod("show", String.class, String.class);
		Annotation[][] an = method.getParameterAnnotations();
		for (int i = 0; i < an.length; i++) {
			Annotation[] an1 = an[i];
			System.out.println(an1.length);
			for (Annotation an2 : an1) {
				System.out.println(((MyAnnotation) (an2)).value());
			}
		}
		System.out.println("===============================");

		MyAnnotation[] myAnnotations = method.getAnnotationsByType(MyAnnotation.class);
		for (MyAnnotation myAnnotation : myAnnotations) {
			System.out.println(myAnnotation.value());
		}
		
	}

	@MyAnnotation("Hello")
	@MyAnnotation("World")
	public void show(@MyAnnotation("abc") String str, @MyAnnotation("def") String str1) {
		System.out.println(str);
	}

}
