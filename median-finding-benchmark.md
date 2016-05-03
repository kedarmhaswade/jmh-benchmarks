# output of java -jar target/benchmarks.jar -wi 5 -f 2
``` text
# JMH 1.12 (released 32 days ago)
# VM version: JDK 1.8.0_74, VM 25.74-b02
# VM invoker: /Library/Java/JavaVirtualMachines/jdk1.8.0_74.jdk/Contents/Home/jre/bin/java
# VM options: <none>
# Warmup: 5 iterations, 1 s each
# Measurement: 20 iterations, 1 s each
# Timeout: 10 min per iteration
# Threads: 1 thread, will synchronize iterations
# Benchmark mode: Throughput, ops/time
# Benchmark: org.sample.MedianFindingBenchmark.useQuickSelect

# Run progress: 0.00% complete, ETA 00:01:40
# Fork: 1 of 2
# Warmup Iteration   1: 742.463 ops/s
# Warmup Iteration   2: 834.509 ops/s
# Warmup Iteration   3: 847.195 ops/s
# Warmup Iteration   4: 839.779 ops/s
# Warmup Iteration   5: 926.781 ops/s
```
Iteration   1: 951.529 ops/s
Iteration   2: 927.270 ops/s
Iteration   3: 930.976 ops/s
Iteration   4: 938.799 ops/s
Iteration   5: 891.224 ops/s
Iteration   6: 840.362 ops/s
Iteration   7: 919.270 ops/s
Iteration   8: 878.704 ops/s
Iteration   9: 946.238 ops/s
Iteration  10: 935.128 ops/s
Iteration  11: 908.476 ops/s
Iteration  12: 944.525 ops/s
Iteration  13: 911.184 ops/s
Iteration  14: 868.795 ops/s
Iteration  15: 883.093 ops/s
Iteration  16: 947.205 ops/s
Iteration  17: 921.643 ops/s
Iteration  18: 910.546 ops/s
Iteration  19: 872.778 ops/s
Iteration  20: 904.771 ops/s

# Run progress: 25.00% complete, ETA 00:01:17
# Fork: 2 of 2
# Warmup Iteration   1: 670.929 ops/s
# Warmup Iteration   2: 831.511 ops/s
# Warmup Iteration   3: 820.631 ops/s
# Warmup Iteration   4: 821.382 ops/s
# Warmup Iteration   5: 864.856 ops/s
Iteration   1: 877.400 ops/s
Iteration   2: 853.740 ops/s
Iteration   3: 900.943 ops/s
Iteration   4: 797.692 ops/s
Iteration   5: 900.031 ops/s
Iteration   6: 916.950 ops/s
Iteration   7: 917.036 ops/s
Iteration   8: 908.298 ops/s
Iteration   9: 898.537 ops/s
Iteration  10: 910.606 ops/s
Iteration  11: 912.476 ops/s
Iteration  12: 914.419 ops/s
Iteration  13: 910.539 ops/s
Iteration  14: 904.600 ops/s
Iteration  15: 901.623 ops/s
Iteration  16: 903.600 ops/s
Iteration  17: 919.763 ops/s
Iteration  18: 907.191 ops/s
Iteration  19: 913.351 ops/s
Iteration  20: 925.305 ops/s


Result "useQuickSelect":
  905.665 ±(99.9%) 16.871 ops/s [Average]
  (min, avg, max) = (797.692, 905.665, 951.529), stdev = 29.988
  CI (99.9%): [888.794, 922.537] (assumes normal distribution)


# JMH 1.12 (released 32 days ago)
# VM version: JDK 1.8.0_74, VM 25.74-b02
# VM invoker: /Library/Java/JavaVirtualMachines/jdk1.8.0_74.jdk/Contents/Home/jre/bin/java
# VM options: <none>
# Warmup: 5 iterations, 1 s each
# Measurement: 20 iterations, 1 s each
# Timeout: 10 min per iteration
# Threads: 1 thread, will synchronize iterations
# Benchmark mode: Throughput, ops/time
# Benchmark: org.sample.MedianFindingBenchmark.useSorting

# Run progress: 50.00% complete, ETA 00:00:51
# Fork: 1 of 2
# Warmup Iteration   1: 318.700 ops/s
# Warmup Iteration   2: 432.281 ops/s
# Warmup Iteration   3: 430.784 ops/s
# Warmup Iteration   4: 443.884 ops/s
# Warmup Iteration   5: 444.757 ops/s
Iteration   1: 449.675 ops/s
Iteration   2: 442.031 ops/s
Iteration   3: 447.604 ops/s
Iteration   4: 440.534 ops/s
Iteration   5: 421.383 ops/s
Iteration   6: 449.261 ops/s
Iteration   7: 449.088 ops/s
Iteration   8: 415.128 ops/s
Iteration   9: 426.456 ops/s
Iteration  10: 448.622 ops/s
Iteration  11: 448.215 ops/s
Iteration  12: 432.800 ops/s
Iteration  13: 446.848 ops/s
Iteration  14: 452.716 ops/s
Iteration  15: 448.027 ops/s
Iteration  16: 441.729 ops/s
Iteration  17: 444.870 ops/s
Iteration  18: 440.694 ops/s
Iteration  19: 426.344 ops/s
Iteration  20: 432.179 ops/s

# Run progress: 75.00% complete, ETA 00:00:25
# Fork: 2 of 2
# Warmup Iteration   1: 317.960 ops/s
# Warmup Iteration   2: 433.096 ops/s
# Warmup Iteration   3: 441.209 ops/s
# Warmup Iteration   4: 440.186 ops/s
# Warmup Iteration   5: 448.689 ops/s
Iteration   1: 454.507 ops/s
Iteration   2: 451.342 ops/s
Iteration   3: 452.075 ops/s
Iteration   4: 447.853 ops/s
Iteration   5: 443.506 ops/s
Iteration   6: 423.968 ops/s
Iteration   7: 455.116 ops/s
Iteration   8: 438.960 ops/s
Iteration   9: 446.825 ops/s
Iteration  10: 453.688 ops/s
Iteration  11: 447.719 ops/s
Iteration  12: 451.666 ops/s
Iteration  13: 455.250 ops/s
Iteration  14: 459.879 ops/s
Iteration  15: 435.508 ops/s
Iteration  16: 458.014 ops/s
Iteration  17: 450.452 ops/s
Iteration  18: 456.023 ops/s
Iteration  19: 452.614 ops/s
Iteration  20: 456.654 ops/s


Result "useSorting":
  444.896 ±(99.9%) 6.047 ops/s [Average]
  (min, avg, max) = (415.128, 444.896, 459.879), stdev = 10.748
  CI (99.9%): [438.849, 450.942] (assumes normal distribution)


# Run complete. Total time: 00:01:42

Benchmark                               Mode  Cnt    Score    Error  Units
MedianFindingBenchmark.useQuickSelect  thrpt   40  905.665 ± 16.871  ops/s
MedianFindingBenchmark.useSorting      thrpt   40  444.896 ±  6.047  ops/s
