package com.Naveenautomatio.RetryLogic;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

import com.NaveenAutomations.BaseTests;

public class TransformerRetry extends BaseTests implements IAnnotationTransformer {
	@Override
	public void transform(ITestAnnotation annotation, Class testClass,
		      Constructor testConstructor, Method testMethod) {
	
	annotation.setRetryAnalyzer(RetryTest.class);
		}

}