/*
 * Copyright 2013 Jin Kwon <onacit at gmail.com>.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


package com.github.jinahya.funny.mathematics;


import java.math.BigInteger;


/**
 *
 * @author Jin Kwon <onacit at gmail.com>
 */
public class FibonacciNumbers {


    public static long f0(final int n) {

        if (n < 0) {
            throw new IllegalArgumentException("n(" + n + ") < 0");
        }

        switch (n) {
            case 0:
                return 0L;
            case 1:
                return 1L;
            default:
                return f0(n - 2) + f0(n - 1);
        }
    }


    private static long f1(final int n, final Long[] s) {

        if (n < 0) {
            throw new IllegalArgumentException("n(" + n + ") < 0");
        }

        if (s == null) {
            throw new NullPointerException("null s");
        }

        if (n >= s.length) {
            throw new IllegalArgumentException(
                "n(" + n + ") >= s.length(" + s.length + ")");
        }

        switch (n) {
            case 0:
                if (s[0] == null) {
                    s[0] = 0L;
                }
                return s[0];
            case 1:
                if (s[1] == null) {
                    s[1] = 1L;
                }
                return s[1];
            default:
                if (s[n] == null) {
                    s[n] = f1(n - 2, s) + f1(n - 1, s);
                }
                return s[n];
        }
    }


    public static BigInteger f2(final int n, final BigInteger[] s) {

        if (n < 0) {
            throw new IllegalArgumentException("n(" + n + ") < 0");
        }

        if (s == null) {
            throw new NullPointerException("null s");
        }

        if (n >= s.length) {
            throw new IllegalArgumentException(
                "n(" + n + ") >= s.length(" + s.length + ")");
        }

        switch (n) {
            case 0:
                if (s[0] == null) {
                    s[0] = BigInteger.ZERO;
                }
                return s[0];
            case 1:
                if (s[1] == null) {
                    s[1] = BigInteger.ONE;
                }
                return s[1];
            default:
                if (s[n] == null) {
                    s[n] = f2(n - 2, s).add(f2(n - 1, s));
                }
                return s[n];
        }
    }


    private static BigInteger f3(final int n, final BigInteger fn_1,
                                 final BigInteger fn_2) {

        if (n < 0) {
            throw new IllegalArgumentException("n(" + n + ") < 0");
        }

        if (fn_1 == null) {
            throw new NullPointerException("null fn_1");
        }

        if (fn_2 == null) {
            throw new NullPointerException("null fn_2");
        }

        if (n == 0) {
            return fn_2;
        }

        return f3(n - 1, fn_1.add(fn_2), fn_1);
    }


    public static BigInteger f3(final int n) {

        return f3(n, BigInteger.ONE, BigInteger.ZERO);
    }


    public static BigInteger f4(final int n) {

        if (n < 0) {
            throw new IllegalArgumentException("n(" + n + ") < 0");
        }

        final BigInteger[] fp = new BigInteger[2];
        fp[0] = BigInteger.ONE;
        fp[1] = BigInteger.ZERO;

        for (int i = 2; i < n; i++) {
            final BigInteger fc = fp[0].add(fp[1]);
            fp[1] = fp[0];
            fp[0] = fc;
        }

        return fp[0].add(fp[1]);
    }


    private static void m0(final String[] args) {

        final int m = 50;
        for (int n = 0; n < m; n++) {
            System.out.printf("f(%1$d) = %2$d\n", n, f0(n));
        }
    }


    public static void m1(final String[] args) {

        final int m = 100;
        final Long[] s = new Long[m];
        for (int n = 0; n < m; n++) {
            System.out.printf("f(%1$d) = %2$d\n", n, f1(n, s));
        }
    }


    private static void m2(final String[] args) {

        final int m = 100;
        final BigInteger[] s = new BigInteger[m];
        for (int n = 0; n < m; n++) {
            System.out.printf("f(%1$d) = %2$d\n", n, f2(n, s));
        }
    }


    private static void m3(final String[] args) {

        final int n = 10000;
        System.out.printf("f(%1$d) = %2$d\n", n, f3(n));
    }


    private static void m4(final String[] args) {

        final int n = 10000;
        System.out.printf("f(%1$d) = %2$d\n", n, f4(n));
    }


    /**
     *
     * @param args
     */
    public static void main(final String[] args) {

        if (false) {
            m0(args);
        }

        if (false) {
            m1(args);
        }

        if (true) {
            m2(args);
        }

        if (false) {
            m3(args);
        }

        if (true) {
            m4(args);
        }
    }


}

