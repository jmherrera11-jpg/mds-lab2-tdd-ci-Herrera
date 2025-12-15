package com.mycompany.stringcalculator;

import java.util.Arrays;

public class StringCalculator {

    public int add(String numbers) {
        if (numbers.isEmpty()) {
            return 0;
        }

        String delimiter = ",";
        String numbersToProcess = numbers;

        // Detectar delimitador personalizado: //[delimiter]\n[numbers]
        if (numbers.startsWith("//")) {
            int delimiterEnd = numbers.indexOf("\n");
            delimiter = numbers.substring(2, delimiterEnd);
            numbersToProcess = numbers.substring(delimiterEnd + 1);
        }

        // Reemplazar \n por el delimitador para unificar separadores
        numbersToProcess = numbersToProcess.replace("\n", delimiter);

        // Sumar todos los números
        return Arrays.stream(numbersToProcess.split(delimiter))
                .mapToInt(Integer::parseInt)
                .sum();
    }
}
