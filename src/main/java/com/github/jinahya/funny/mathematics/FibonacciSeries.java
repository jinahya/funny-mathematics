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
import java.util.Arrays;


/**
 *
 * @author Jin Kwon <onacit at gmail.com>
 */
public class FibonacciSeries {


    public static long f(final int n) {

        if (n < 0) {
            throw new IllegalArgumentException("n(" + n + ") < 0");
        }

        switch (n) {
            case 0:
                return 0L;
            case 1:
                return 1L;
            default:
                return f(n - 2) + f(n - 1);
        }
    }


    public static long f(final int n, final Long[] fs) {

        if (n < 0) {
            throw new IllegalArgumentException("n(" + n + ") < 0");
        }

        if (fs == null) {
            throw new NullPointerException("null fs");
        }

        if (n > fs.length - 1) {
            throw new IllegalArgumentException(
                "n(" + n + ") > fs.length(" + fs.length + ") - 1");
        }

        assert n >= 0;

        switch (n) {
            case 0:
                if (fs[0] == null) {
                    fs[0] = 0L;
                }
                return fs[0];
            case 1:
                if (fs[1] == null) {
                    fs[1] = 1L;
                }
                return fs[1];
            default:
                if (fs[n] == null) {
                    fs[n] = f(n - 2, fs) + f(n - 1, fs);
                }
                return fs[n];
        }
    }


    public static BigInteger f(final int n, final BigInteger[] fs) {

        if (n < 0) {
            throw new IllegalArgumentException("n(" + n + ") < 0");
        }

        if (fs == null) {
            throw new NullPointerException("null fs");
        }

        if (n > fs.length - 1) {
            throw new IllegalArgumentException(
                "n(" + n + ") > fs.length(" + fs.length + ") - 1");
        }

        switch (n) {
            case 0:
                if (fs[0] == null) {
                    fs[0] = BigInteger.ZERO;
                }
                return fs[0];
            case 1:
                if (fs[1] == null) {
                    fs[1] = BigInteger.ONE;
                }
                return fs[1];
            default:
                if (fs[n] == null) {
                    fs[n] = fs[n - 2].add(fs[n - 1]);
                }
                return fs[n];
        }
    }


    public static BigInteger f(final int n, final FibonacciSeriesStore fss)
        throws FibonacciSeriesStoreException {

        if (n < 0) {
            throw new IllegalArgumentException("n(" + n + ") < 0");
        }

        if (fss == null) {
            throw new NullPointerException("null fs");
        }

        switch (n) {
            case 0:
                BigInteger f0 = fss.get(n);
                if (f0 == null) {
                    f0 = BigInteger.ZERO;
                    fss.put(0, f0);
                }
                return fss.get(0);
            case 1:
                BigInteger f1 = fss.get(n);
                if (f1 == null) {
                    f1 = BigInteger.ONE;
                    fss.put(n, f1);
                }
                return fss.get(1);
            default:
                BigInteger fn = fss.get(n);
                if (fn == null) {
                    fn = fss.get(n - 2).add(fss.get(n - 1));
                    fss.put(n, fn);
                }
                return fss.get(n);
        }
    }


    /**
     *
     * @param args
     */
    public static void main(final String[] args) {

        {
            for (int n = 0; n < 50; n++) {
//                System.out.printf("f(%1$d) = %2$d\n", n, f(n));
            }
        }

        {
            final int m = 100;
            final Long[] fs = new Long[m + 1];
            for (int n = 0; n < m; n++) {
                System.out.printf("f(%1$d) = %2$d\n", n, f(n, fs));
            }
//            System.out.println(Arrays.toString(fs));
        }

        {
            final int m = 10000;
            final BigInteger[] fs = new BigInteger[m + 1];
            for (int n = 0; n < m; n++) {
                System.out.printf("f(%1$d) = %2$d\n", n, f(n, fs));
            }
//            System.out.println(Arrays.toString(fs));
        }
    }


}

