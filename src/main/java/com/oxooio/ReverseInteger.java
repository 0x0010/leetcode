package com.oxooio;

/**
 * Reverse digits of an integer.
 *
 * Example1: x = 123, return 321 Example2: x = -123, return -321
 *
 * Note: The input is assumed to be a 32-bit signed integer. Your function should return 0 when the
 * reversed integer overflows.
 *
 * @author Sam
 * @since 3.1.0
 */
public class ReverseInteger {

  public static void main(String[] args) {
    ReverseInteger ri = new ReverseInteger();
//    System.out.println(ri.reverse(-2147483648));
//    System.out.println(ri.reverse(Integer.MAX_VALUE - 1));
//    System.out.println(ri.reverse(-1253));

//    System.out.println(ri.reverse2(123));
//    System.out.println(ri.reverse2(-123));
//    System.out.println(ri.reverse2(-2147483648));
    System.out.println(ri.reverse2(2147483647));
  }

  /**
   * 最简单的一种思路：将入参x转换成由十进制的每一个字符组成的
   * 数组，然后对数组做首尾交换。位移需要处理的就是符号位与溢出
   * 的风险。
   *
   * @param x 十进制输入
   * @return 反转之后的十进制
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

  /**
   * 从十进制的低位往高位开始分离计算反转数。
   * @param x
   * @return
   */
  public int reverse2(int x) {
    Long sum = 0L;
    while (x != 0) {
      sum = sum * 10 + x % 10;
      x /= 10;
    }
    return (sum < Integer.MIN_VALUE || sum > Integer.MAX_VALUE) ? 0 : sum.intValue();
  }
}
