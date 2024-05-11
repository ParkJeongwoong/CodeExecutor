package com.dailyalgo.codeExecutor.application.code.template.factory;

@FunctionalInterface
public interface TriFunction<A, B, C, R> {

	R apply(A a, B b, C c);

}

