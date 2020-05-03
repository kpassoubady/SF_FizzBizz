package com.kavinschool.fizzbuzz;

import java.util.Arrays;
import java.util.stream.Collectors;

public class FizzBuzz {

    public String execute(int[] numbers) {
        return Arrays.stream(numbers)
                .mapToObj(this::processNumber)
                .collect(Collectors.joining(", "));
    }

    String processNumber(int number) {
        if (isMultipleOf3(number) && isMultipleOf5(number)) {
            return "FizzBuzz";
        }

        if (isMultipleOf3(number)) {
            return "Fizz";
        }

        if (isMultipleOf5(number)) {
            return "Buzz";
        }

        return String.valueOf(number);
    }

    private boolean isMultipleOf5(int number) {
        return number % 5 == 0;
    }

    private boolean isMultipleOf3(int number) {
        return number % 3 == 0;
    }
}
