package com.tistory.metalbird0.ymStudy;

public class HexPrinter {
    public static String format(byte[] data) {
        int n = 0;
        StringBuilder result = new StringBuilder();
        for (byte b : data) {
            if (n % 16 == 0) {
                result.append(String.format("%05X: ", n));
            }
            result.append(String.format("%02X: ", b));
            n++;
            if (n % 16 == 0) {
                result.append("\n");
            }
        }
        result.append("\n");
        return result.toString();
    }
    
    public static void main(String[] args) {
        byte[] buf = {0x10,0x20,0x30,0x40};
        System.out.println(format(buf));
    }
}
