// Copyright code Thomas Froger
// L3 Project Java - 2020 - 2021


package com.company.App;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class BinaireS {

    private String binaryString;

    public BinaireS(String binaryString) {
        this.binaryString = binaryString;
    }

    public ArrayList<Integer> to_position() {
        final String bs = binaryString;
        return IntStream.range(0, binaryString.length())
        .filter(i -> bs.charAt(i) == '1').boxed().collect(Collectors.toCollection(ArrayList::new));
    }
}
