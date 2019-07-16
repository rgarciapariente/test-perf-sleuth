# test-perf-sleuth
Use case for check performance impact of Spring Cloud Sleuth.

## Modules

### demo-gateway-with-sleuth

A simple Spring Cloud Gateway with one route and include sleuth library

### demo-gateway-without-sleuth

A simple Spring Cloud Gateway with one route. Our base case

### demo-micro

A simple micro to use as backend for gateway 

## Results

We run these micros in a Kubernetes with resources fixed to 1GB and 2000 millicores. 
We use jmeter to review the performance. We launch 500 threads for 300 seconds. 
The result of the test is:


Label | #Samples | KO | Error % | Average | Min | Max | 90th pct | 95th pct | 99th pct | Throughput | Received | Sent
--- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | ---
demo-gateway-without-sleuth | 1256518 | 0 | 0.00% | 118.89 | 0 | 3155 | 228.00 | 254.00 | 321.00 | 4187.37 | 339.41 | 613.38
demo-gateway-with-sleuth | 708920 | 0 | 0.00% | 210.99 | 1 | 3388 | 375.00 | 413.00 | 484.00 | 2355.40 | 190.92 | 338.13

The average time of demo-gateway-with-sleuth is 210,99 ms a 77% worse than demo-gateway-without-sleuth 118,89 ms 

 

