package com.example.data.mappers;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0002\b&\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u00020\u0003B\u0005\u00a2\u0006\u0002\u0010\u0004J\u0015\u0010\u0005\u001a\u00028\u00012\u0006\u0010\u0006\u001a\u00028\u0000H&\u00a2\u0006\u0002\u0010\u0007J\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00010\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\t\u00a8\u0006\u000b"}, d2 = {"Lcom/example/data/mappers/Map;", "In", "Out", "", "()V", "transform", "value", "(Ljava/lang/Object;)Ljava/lang/Object;", "transformCollection", "", "values", "data_debug"})
public abstract class Map<In extends java.lang.Object, Out extends java.lang.Object> {
    
    /**
     * * Transforms the input value in the output value specified
     *     *
     *     * @param value input value type
     *     * @return output value type if valid; otherwise null
     */
    public abstract Out transform(In value);
    
    /**
     * * Transforms the collection input values in the collection output values specified
     *     *
     *     * @param values collection output values type
     *     * @return collection input values type if valid; otherwise null
     */
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<Out> transformCollection(@org.jetbrains.annotations.NotNull()
    java.util.List<? extends In> values) {
        return null;
    }
    
    public Map() {
        super();
    }
}