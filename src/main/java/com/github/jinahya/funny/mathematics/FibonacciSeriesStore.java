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
public interface FibonacciSeriesStore {


    /**
     *
     * @param n
     *
     * @return the value of {@code f(n)} or {@code null} if the value is not put
     * yet.
     *
     * @throws FibonacciSeriesStoreException
     */
    BigInteger get(int n) throws FibonacciSeriesStoreException;


    /**
     *
     * @param n
     * @param f
     *
     * @throws FibonacciSeriesStoreException
     */
    void put(int n, BigInteger f) throws FibonacciSeriesStoreException;


}

