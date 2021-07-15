package com.jachs.commons.lang.annotationutils;

import java.lang.annotation.Annotation;

import org.apache.commons.lang3.AnnotationUtils;
import org.junit.Test;
/****
 * @author zhanchaohan
 */
public class Demo {
	@Test
	public void AnnotationUtilsdemo() {
		AnnotationUtils annotationUtils=new AnnotationUtils();
		Annotation annotation=new Annotation() {
			public Class<? extends Annotation> annotationType() {
				return AnnotationA.class;
			}
		};
		Annotation annotation1=new Annotation() {
			public Class<? extends Annotation> annotationType() {
				return AnnotationB.class;
			}
		};
		System.out.println(annotationUtils.equals(annotation, annotation1));
		System.out.println(annotationUtils.isValidAnnotationMemberType(annotation.annotationType()));
		System.out.println(annotationUtils.hashCode(AnnotationA.class.getAnnotation(AnnotationB.class)));
	}
}
