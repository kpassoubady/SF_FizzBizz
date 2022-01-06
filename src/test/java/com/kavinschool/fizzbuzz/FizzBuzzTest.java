package com.kavinschool.fizzbuzz;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.*;


public class FizzBuzzTest {

    @Test
    public void shouldExecute() {
        FizzBuzz fizzBuzz = new FizzBuzz();

        assertThat(fizzBuzz.execute(new int[]{1}), is("1"));
        assertThat(fizzBuzz.execute(new int[]{1, 2, 3, 5, 6, 10, 15, 30}), is("1, 2, Fizz, Buzz, Fizz, Buzz, FizzBuzz, FizzBuzz"));
    }

    @Test
    public void shouldProcessNumber() {
        FizzBuzz fizzBuzz = new FizzBuzz();
        assertThat(fizzBuzz.processNumber(1), is("1"));
        assertThat(fizzBuzz.processNumber(2), is("2"));
        assertThat(fizzBuzz.processNumber(3), is("Fizz"));
        assertThat(fizzBuzz.processNumber(5), is("Buzz"));
        assertThat(fizzBuzz.processNumber(6), is("Fizz"));
        assertThat(fizzBuzz.processNumber(10), is("Buzz"));
        assertThat(fizzBuzz.processNumber(15), is("FizzBuzz"));
    }

}