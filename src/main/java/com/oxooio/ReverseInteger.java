package com.oxooio;

/**
 * Reverse digits of an integer.
 *
 * Example1: x = 123, return 321
 * Example2: x = -123, return -321
 *
 * Note:
 * The input is assumed to be a 32-bit signed integer.
 * Your function should return 0 when the reversed integer overflows.
 *
 * @author Sam
 * @since 3.1.0
 */
public class ReverseInteger {

  public static void main(String[] args) {
    System.out.println(new ReverseInteger().reverse(-2147483648));
    System.out.println(new ReverseInteger().reverse(Integer.MAX_VALUE - 1));
    System.out.println(new ReverseInteger().reverse(-1253));
  }

  /**
   *  here is my ugly code, very sad.
   *
   * @param x
   * @return
   */
  public int reverse(int x) {
    if (x == Integer.MIN_VALUE) {
      return 0;
    }
    boolean isNegative = x < 0;
    x = Math.abs(x);
    char[] chars = String.valueOf(x).toCharArray();

    int charsLen = chars.length;
    for (int i = 0; i < charsLen / 2; i++) {
      char temp = chars[i];
      chars[i] = chars[charsLen - 1 - i];
      chars[charsLen - 1 - i] = temp;
    }
    Long reversedLong = Long.parseLong(String.valueOf(chars));
    if (isNegative) {
      reversedLong = -1 * reversedLong;
      return reversedLong < Integer.MIN_VALUE ? 0 : reversedLong.intValue();
    }
    return reversedLong > Integer.MAX_VALUE ? 0 : reversedLong.intValue();
  }
}
