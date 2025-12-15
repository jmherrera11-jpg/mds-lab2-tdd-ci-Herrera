package com.mycompany.stringcalculator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringCalculator {

    public int add(String numbers) {
        if (numbers.isEmpty()) {
            return 0;
        }
        
        String delimiter = ",";
        String numbersToProcess = numbers;
        
        if (numbers.startsWith("//")) {
            int delimiterEnd = numbers.indexOf("\n");
            delimiter = numbers.substring(2, delimiterEnd);
            numbersToProcess = numbers.substring(delimiterEnd + 1);
        }
        
        numbersToProcess = numbersToProcess.replace("\n", delimiter);
        
        String[] parts = numbersToProcess.split(delimiter);
        List<Integer> negatives = Arrays.stream(parts)
                .map(Integer::parseInt)
                .filter(n -> n < 0)
                .collect(Collectors.toList());
        
        if (!negatives.isEmpty()) {
            String negativesStr = negatives.stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining(", "));
            throw new IllegalArgumentException(
                "negativos no permitidos: " + negativesStr
            );
        }
        
        return Arrays.stream(parts)
                     .mapToInt(Integer::parseInt)
                     .sum();
    }
}
