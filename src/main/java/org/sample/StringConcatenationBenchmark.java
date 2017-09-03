package org.sample;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * <p> A string concatenation benchmark based on Effective Java 2e. Item 51. </p>
 * <p> To make it more appealing and useful, I have considered writing a hypothetical routine that
 * does string concatenation and applies the knowledge of performance implications. </p>
 */
@State(Scope.Thread)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
public class StringConcatenationBenchmark {

    int approxTotal;
    List<String> strings;

    @Setup
    public void initialize() {
        approxTotal = 1 << 12; // 4096
        // each UUID is 36 ASCII characters long, we have about 112 such strings to make it to 4096
        int cap = 112;
        strings = new ArrayList<>(cap);
        for (int i = 0; i < cap; i++) {
            boolean a = strings.add(UUID.randomUUID().toString());
            assert a;
        }
    }

    @Benchmark
    public String concatBuilder() {
        StringBuilder sb = new StringBuilder(approxTotal);
        for (String s : strings)
            sb = sb.append(s);
        return sb.toString();
    }

    @Benchmark
    public String concatBuilderNaive() {
        StringBuilder sb = new StringBuilder(); // discard approxTotal, initial cap is 16
        for (String s : strings)
            sb = sb.append(s);
        return sb.toString();
    }

    @Benchmark
    public String concatDefault() {
        String str = "";
        for (String s : strings)
            str += s; // IDE warns!
        return str;
    }

    public static void main(String[] args) {
        StringConcatenationBenchmark bm = new StringConcatenationBenchmark();
        bm.initialize();
        String str1 = bm.concatBuilder();
        String str2 = bm.concatDefault();
        String str3 = bm.concatBuilderNaive();
        System.out.println(str1.equals(str2));
        System.out.println(str1.equals(str3));
    }
}
