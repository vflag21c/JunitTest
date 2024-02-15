package org.example.junittest;

import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.aggregator.AggregateWith;
import org.junit.jupiter.params.aggregator.ArgumentsAccessor;
import org.junit.jupiter.params.aggregator.ArgumentsAggregationException;
import org.junit.jupiter.params.aggregator.ArgumentsAggregator;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.ValueSource;

class EmptyTest {

    /**
     * @EmptySource
     * @NullSource
     * @NullAndEmptySource
     */
    @ValueSource(strings = {"출근", "싫다"})
    @ParameterizedTest
    @EmptySource
    void empty_source_test(String message){
        System.out.println("message = " + message);
    }

    @ParameterizedTest
    @CsvSource({"10, '테스트코드 작성'", "20, '스프링'"})
    void csv_test(Integer i, String s){
        System.out.println("i = " + i + ", s = " + s);
    }


    /**
     * static inner class 이거나 public class 여야 한다.
     */
    @ParameterizedTest
    @CsvSource({"10, '테스트코드 작성'", "20, '스프링'"})
    void csv_test2(@AggregateWith(StuddyAggregator.class) Study study){
        System.out.println(study);
    }

    static class StuddyAggregator implements ArgumentsAggregator{
        @Override
        public Object aggregateArguments(ArgumentsAccessor argumentsAccessor, ParameterContext parameterContext) throws ArgumentsAggregationException {
            return new Study(argumentsAccessor.getInteger(0), argumentsAccessor.getString(1));
        }
    }

}
