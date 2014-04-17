package com.tistory.metalbird0.ymStudy;

public class CompareEqualsSpeed {
    private void compareSpeed(int count) {
        int countCompare = 0;
        int countEquals = 0;
        long start = 0;
        long end = 0;
        int same = 0;
        for (int i = 0; i < count * 2;) {

            start = System.nanoTime();
            if ("Hello" == "Hello") {
                i++;
            }
            end = System.nanoTime();
            long compare = end - start;

            start = System.nanoTime();
            if ("Hello".equals("Hello")) {
                i++;
            }
            end = System.nanoTime();
            long equals = end - start;


            if (compare > equals) {
                System.out.println("equals is faster than ==.");
                countCompare++;
            } else if (equals > compare) {
                System.out.println("== is faster than equals.");
                countEquals++;
            } else {
                System.out.println("same.");
                same++;
            }
        }

        System.out.println("== is slow: " + countCompare);
        System.out.println("equals is slow: " + countEquals);
        System.out.println("same: " + same);
    }

    public static void main(String... args) {
        CompareEqualsSpeed main = new CompareEqualsSpeed();
        main.compareSpeed(10000);
    }
}
