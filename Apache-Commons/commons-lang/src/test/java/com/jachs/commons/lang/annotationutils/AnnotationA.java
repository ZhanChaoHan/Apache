package com.jachs.commons.lang.annotationutils;

import java.lang.annotation.Annotation;

public class AnnotationA implements Annotation {

	public Class<? extends Annotation> annotationType() {
		return AnnotationA.class;
	}


}
