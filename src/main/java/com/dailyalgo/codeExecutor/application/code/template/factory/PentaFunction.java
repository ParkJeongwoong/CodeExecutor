package com.dailyalgo.codeExecutor.application.code.template.factory;

@FunctionalInterface
public interface PentaFunction<A, B, C, D, E, R> {

	R apply(A a, B b, C c, D d, E e);

}

