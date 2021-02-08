package com.ziling.goodlife.function;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerTest {

    public void processListOfNumbers(List<Integer> listOfNumbers, Consumer<Integer> processor) {
        listOfNumbers.forEach(processor);
    }

    public static void main(String[] args) {
        ConsumerTest consumerTest = new ConsumerTest();
        List<Integer> numbers = Arrays.asList(5, 6, 7, 8);
        Consumer<Integer> numberPrinter = System.out::println;
        consumerTest.processListOfNumbers(numbers, numberPrinter);
    }
}
