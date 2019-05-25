package com.example.data.mappers

abstract class Map<In, Out> {
    /**
     * Transforms the input value in the output value specified
     *
     * @param value input value type
     * @return output value type if valid; otherwise null
     */
    abstract fun transform(value: In): Out

    /**
     * Transforms the collection input values in the collection output values specified
     *
     * @param values collection output values type
     * @return collection input values type if valid; otherwise null
     */
    fun transformCollection(values: List<In>) = values.map { t1 -> transform(t1) }
}