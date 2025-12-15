package com.mycompany.stringcalculator;
import java.util.Arrays;
public class StringCalculator {

    public int add(String numbers) {
        if (numbers.isEmpty()) {
            return 0;
        }

        String normalized = numbers.replace("\n", ",");
        return Arrays.stream(normalized.split(","))
                .mapToInt(Integer::parseInt)
                .sum();
    }   
}
