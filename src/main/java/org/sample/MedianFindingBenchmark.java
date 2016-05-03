/*
 * Copyright (c) 2014, Oracle America, Inc.
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 *  * Redistributions of source code must retain the above copyright notice,
 *    this list of conditions and the following disclaimer.
 *
 *  * Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in the
 *    documentation and/or other materials provided with the distribution.
 *
 *  * Neither the name of Oracle nor the names of its contributors may be used
 *    to endorse or promote products derived from this software without
 *    specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF
 * THE POSSIBILITY OF SUCH DAMAGE.
 */

package org.sample;

import org.openjdk.jmh.annotations.Benchmark;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class MedianFindingBenchmark {

    @Benchmark
    public static void useQuickSelect() throws IOException {


        try(BufferedReader br = new BufferedReader(new FileReader("/tmp/dors.txt"))) {
            Integer[] a = br.lines()
                    .map(Integer::valueOf)
                    .toArray(Integer[]::new);
            medianQs(a);
        }
    }
    @Benchmark
    public static void useSorting() throws IOException {


        try(BufferedReader br = new BufferedReader(new FileReader("/tmp/dors.txt"))) {
            Integer[] a = br.lines()
                    .map(Integer::valueOf)
                    .toArray(Integer[]::new);
            medianSort(a);
        }
    }


    static double medianQs(Integer[] a) {
        int length = a.length;
        if (length == 0)
            return 0;
        if (length == 1)
            return a[0];
        int highMidIndex = length >>> 1;
//        System.out.println("length, highMidIndex: " + length + ", " + highMidIndex);
        if (length % 2 == 0) {
            int first  = a[qs(a, highMidIndex - 1)];
//            System.out.println("first: " + first);
            int second = a[qs(a, highMidIndex)];
//            System.out.println("second: " + second);
            return (first + second) * 0.5;
        } else
            return qs(a, 0, length - 1, highMidIndex);
    }
    static Number medianSort(Number[] array) {
        if (array.length == 0) {
            return 0;
        }
        Arrays.sort(array);
        if (array.length % 2 == 0) {
            return (array[array.length / 2 - 1].doubleValue() + array[array.length / 2].doubleValue()) / 2;
        } else {
            return array[array.length / 2].doubleValue();
        }
    }
    static long random(long l, long h) {
        if (l >= h)
            return l;
        return l + Math.round(Math.random() * (h-l));
    }

    /**
     * Rearranges the array such that the ith order statistic
     * is in the ith location. All elements less than or equal to a[i] are placed
     * at a[0..i-1].
     * @return int the index of the element which is the ith order statistic
     */
    public static <T extends Comparable<T>> int qs(T[] a, int i) {
        return qs(a, 0, a.length-1, i);
    }

    public static <T extends Comparable<T>> int smallest(T[] a) {
        return qs(a, 0, a.length-1, 0);
    }
    public static <T extends Comparable<T>> int largest(T[] a) {
        return qs(a, 0, a.length-1, a.length-1);
    }

    private static <T extends Comparable<T>> int qs(T[] a, int lo, int hi, int i) {
        //this is the recursive definition
        if (lo >= hi)
            return hi; //i must be 0 in this situation
        int q = randomPart(a, lo, hi);
        int k = q - lo;
        if (i == k)
            return q; //we are done
        else if (i < k)
            return qs(a, lo, q-1, i);
        else
            return qs(a, q+1, hi, i-k-1);
    }
    static <T extends Comparable<T>> int randomPart(T[] a, int lo, int hi) {
        swap(a, (int) random(lo, hi), lo); //swap a[lo] with randomly chosen element
        T pivot = a[lo];
        int i = lo+1;
        int j = i-1;
        while (i <= hi) {
            int cmp = a[i].compareTo(pivot);
            if (cmp < 0) {
                a[j] = a[i];
                a[i] = a[j+1];
                j++;
            }
            i++;
        }
        a[j] = pivot;
        return j;
    }
    static <T> void swap(T[] a, int fi, int si) {
        T tmp = a[fi];
        a[fi] = a[si];
        a[si] = tmp;
    }

}
