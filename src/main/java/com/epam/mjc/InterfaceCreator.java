package com.epam.mjc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class InterfaceCreator {

    public Predicate<List<String>> isValuesStartWithUpperCase() {
        return x -> {
            for (String s : x) {
                int asciiValue = s.charAt(0);
                if (65 > asciiValue || asciiValue > 90) {
                    return false;
                }
            }

            return true;
        };
    }

    public Consumer<List<Integer>> addEvenValuesAtTheEnd() {
        return x -> {
          List<Integer> evens = new ArrayList<>();
          for (int number : x) {
              if (number % 2 == 0) {
                  evens.add(number);
              }
          }

          x.addAll(evens);
        };
    }

    public Supplier<List<String>> filterCollection(List<String> values) {
        return () -> {
            List<String> filtered = new ArrayList<>();

            for (String val : values) {
                int asciiValue = val.charAt(0);
                if ((65 <= asciiValue && asciiValue <= 90) &&
                        ".".equals(val.charAt(val.length()-1)) &&
                        val.length() > 3) {
                    filtered.add(val);
                }
            }

            return filtered;
        };
    }

    public Function<List<String>, Map<String, Integer>> stringSize() {
        return x -> {
            Map<String, Integer> map = new HashMap<>();

            for (String s : x) {
                map.put(s, s.length());
            }

            return map;
        };
    }

    public BiFunction<List<Integer>, List<Integer>, List<Integer>> concatList() {
        return (l1, l2) -> {
            List<Integer> l = new ArrayList<>();
            l.addAll(l1);
            l.addAll(l2);

            return l;
        };
    }
}
