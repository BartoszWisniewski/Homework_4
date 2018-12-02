package com.infoshareacademy.homeworks;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


public class GradeService {

    public static String[][] calculateAverage(String[][] data) {

        if (data == (null)) {
            return data = new String[][]{{}};
        } else if (data.length == 0) {
            return data = new String[][]{{}};
        } else {
            Arrays.sort(data, Comparator.comparing(strings -> (strings[0])));
            List<String> name = Arrays.stream(data)
                    .map(o -> o[0])
                    .sorted()
                    .distinct()
                    .collect(Collectors.toList());
            String[][] input2 = new String[name.size()][2];
            for (int i = 0; i < name.size(); i++) {
                input2[i][0] = name.get(i);
            }
            for (int j = 0; j < input2.length; j++) {
                BigDecimal sum = BigDecimal.ZERO;
                BigDecimal count = BigDecimal.ZERO;
                BigDecimal result = BigDecimal.ZERO;
                for (int k = 0; k < data.length; k++) {
                    if (input2[j][0].equals(data[k][0])) {
                        String result1 = data[k][1];
                        BigDecimal resultBig1 = new BigDecimal(result1).setScale(2);
                        sum = sum.add(resultBig1);
                        count = count.add(BigDecimal.ONE);
                    }
                }
                result = sum.divide(count, 2, RoundingMode.UP);
                input2[j][1] = result.toString();
            }
            return input2;
        }
    }
}

