# Load Balancing

## Overview
This section covers the Load Balancing Algorithms.

| Algorithms                                                                                                                                                                |
|---------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| [Round Robin](https://github.com/shumarb/designgurus/blob/main/grokking-system-design-fundamentals/readmes/load-balancing-algorithms.md#round-robin)                      |
| [Least Connections](https://github.com/shumarb/designgurus/blob/main/grokking-system-design-fundamentals/readmes/load-balancing-algorithms.md#least-connections)          |
| [Weighted Round Robin](https://github.com/shumarb/designgurus/blob/main/grokking-system-design-fundamentals/readmes/load-balancing-algorithms.md#weighted-round-robin)    |
| [Weighted Least Connections](https://github.com/shumarb/designgurus/blob/main/grokking-system-design-fundamentals/readmes/load-balancing-algorithms.md#weighted-leadst-connections) |
| [IP Hash](https://github.com/shumarb/designgurus/blob/main/grokking-system-design-fundamentals/readmes/load-balancing-algorithms.md#ip-hash)                              |
| [Least Response Time](https://github.com/shumarb/designgurus/blob/main/grokking-system-design-fundamentals/readmes/load-balancing-algorithms.md#least-response-time)      |
| [Random](https://github.com/shumarb/designgurus/blob/main/grokking-system-design-fundamentals/readmes/load-balancing-algorithms.md#random)                                |

## Algorithms
### Round Robin
Incoming requests are distributed across the servers in a cyclic order (i.e.: Assign a request to the first server, then onto the second, until the last server, before starting again at the first).

| Advantages                                      | Disadvantages                                                                                                            |                                                                                                                                                                                                                     
|-------------------------------------------------|--------------------------------------------------------------------------------------------------------------------------|
| Distributes requests equally across servers.    | Treats all servers equally regardless of their current load.                                                             |
| Easy to implement and understand.               | Subsequent requests from the same client may be directed to different servers, causing issues for stateful applications. |
| Effective when servers have similar capacities. | Attackers may exploit request distribution patterns to predict and target vulnerable servers.                            |

Use Cases:
- Heterogeneous Environments: Environments where servers have different capacities and workloads, and loads must be dynamically distributed.
- Variable Traffic Patterns: Works well for applications with unpredictable or highly variable traffic patterns to ensure no single server is overwhelmed.
- Stateful Applications: Effective for applications where maintaining session state is important to ensure even distribution of active sessions.

### Least Connections
Incoming requests are assigned to the server with the least active connections at the time of the request.

| Advantages                                                                             | Disadvantages                                                              |
|----------------------------------------------------------------------------------------|----------------------------------------------------------------------------|
| Load awareness by considering current load of each server.                             | Higher complexity due to real-time monitoring of active connections.       |
| Adapts to traffic patterns and server loads; ensuring no server becomes a bottleneck.  | Increased overhead as load balancer maintains state of active connections. |
| Effective for servers with varying loads and capacities.                               | Servers can experience rapid spike for short connection durations.         |

Use Cases:
- Heterogeneous Environments: Environments where servers have different capacities and workloads, and loads must be dynamically distributed.
- Variable Traffic Patterns: Works well for applications with unpredictable or highly variable traffic patterns to ensure no single server is overwhelmed.
- Stateful Applications: Effective for applications where maintaining session state is important to ensure even distribution of active sessions.

### Weighted Round Robin
Weighted Round Robin is an `enhanced` version of the Round Robin load balancing algorithm

It assigns weights to each server based on their capacity or performance, distributing incoming requests proportionally according to their weight.
This ensures that the more powerful servers handle a larger share of the load, while less powerful servers handle a smaller share.

| Advantages                                                                                | Disadvantages                                                                       |
|-------------------------------------------------------------------------------------------|-------------------------------------------------------------------------------------|
| Load Distribution according to Capacity.                                                  | Complexity in weight assignment to servers                                          |
| Easily adjustable to accomodate changes in server capacities or additions of new servers. | Increased overload, especially in dynamic environments when performance fluctuates. |
| Optimises overrall system performance by preventing overloading of less powerful servers. | Not optimal for high variable loads as it does not consider real-time server load.  |

Use Cases:
- Heterogeneous Server Environments: Ideal for environments where servers have different processing capabilities, ensuring efficient use of resources.
- Scalable Web Applications: Ideal for web applications where different servers may have varying performance characteristics.
- Database Clusters: Useful in database clusters where some nodes have higher processing power and can handle more queries.

### Weighted Least Connections
Weighted Least Connections `combines` the principles of the `Least Connections` and `Weighted Round Robin` algorithms.
It considers both the current load (number of active connections) on each server and the relative capacity of each server (weight).
This ensures that more powerful servers handle a proportionally larger share of the load, whilst dynamically adjusting to the real-time load on each server.

| Advantages                                                                                                          | Disadvantages                                                                                                                    |
|---------------------------------------------------------------------------------------------------------------------|----------------------------------------------------------------------------------------------------------------------------------|
| Dynamic Load Balancing: Adjusts to the real-time load on each server to ensure balanced distribution of requests.   | More complex implementation compared to simpler algorithms.                                                                      |
| Complexity Awareness: Considers the relative capacity of each server, leading to improved utilization of resources. | Increased Overhead: Requires load balancero to keep track of both active connections and server weights.                         |
| Flexibility: Can handle environments with heterogeneous servers and variable load patterns effectively.             | Weight Assignment: Determining appropriate weights for each server can be challenging and requirs accurate performance metrices. |

Use Cases
- Heterogeneous Server Environments: Ideal for environments where servers have different processing capacities and workloads.
- High Traffic Web Applications: Suitable for web applications with `variable` traffic patterns, ensuring no single server becomes a bottleneck.
- Database Clusters: Useful in database clusters where nodes have varying performance capabilities and query loads.

### IP Hash
A hash function converts the client's IP address into a hash value, which determines which server handles the client's request.

| Advantages                                                                                                    | Disadvantages                                                                                                                     |
|---------------------------------------------------------------------------------------------------------------|-----------------------------------------------------------------------------------------------------------------------------------|
| Session Persistence: Ensures requests from same client IP address are consistently routed to the same server. | Uneven Distribution: Some servers may receive more requests than others.                                                          |
| Simplicity: Easy to implement and maintain.                                                                   | Dynamic Changes: Adding or removing servers can disrupt the hash mapping, causing some clients to be routed to different servers. |
| Deterministic: Prefictable and consistent routing based on client's IP address.                               | Limited Flexibility: Does not consider the current load or capacity of servers, leading to inefficiecies.                         |

Use Cases:
- Stateful Applications: Ideal for applications where maintaining session persistence is important (eg: online shopping carts).
- Geographically Distributed Clients: Useful when clients are distributed across different regions and consistent routing is required.

### Least Response Time
Dynamic algorithm that assigns incoming requests to the server with the lowest response time.

Implementation
1. Load Balancer monitor `response time` (total time when a request is sent to a server until a response is received).
2. Load Balancer assign requests to server with the lowest average response time.
3. Load Balancer dynamically adjusts the assignment of requests based on real-time performance data, ensuring that the fastest server handles the next request.

| Advantages                                                                                                                           | Disadvantages                                                                                                                                     |
|--------------------------------------------------------------------------------------------------------------------------------------|---------------------------------------------------------------------------------------------------------------------------------------------------|
| Optimized Performance: Requests are handled by the fastest available server, hence reducing latency and improving client experience. | Higher Complexity: Continuous monitoring of server performance.                                                                                   |
| Dynamic Load Balancing: Continuously adjusts to changing server performance to ensure optimal load distribution.                     | Overhed: Monitoring response times and dynamically adjusting the load.                                                                            |
| Effective Resource Utilization: Improved utilization by directing traffic to servers that respond quickly.                           | Short-Term Variability: Response times can vary due to network fluctuations or transient server issues, potentially causing frequent rebalancing. |

Use Cases
- Real-time Applications: Ideal for applications with low latency and fast response times (eg: online gaming, video streaming).
- Web Services: Useful for web services and APIs that need to provide quick responses for user requests.
- Dynamic Environments: Ideal for environments with fluctuating loads and varying server performance.

### Random
Random distribution of incoming requests to servers. Over time, if the randomness is uniform, each server receives approximately the same number of requests.

| Advantages                                                                                                                      | Disadvantages                                                                                                                                             |
|---------------------------------------------------------------------------------------------------------------------------------|-----------------------------------------------------------------------------------------------------------------------------------------------------------|
| Simplicity: Easy to implement and understand.                                                                                   | No Load Awareness: Does not consider the current load/capacity of servers, which may lead to uneven distribution of server performance varies.            |
| No State Maintenance: Load Balancer does not need to track the state/performance of servers.                                    | Potential for Imbalance: In the short-term, random selection can lead to uneven distribution of requests.                                                 |
| Uniform Distribution: If the random selection is unifor, the load will be evenly distributed across servers over a long period. | No Session Affinity: Requests from the same cient may be directed to different servers, which can be problematic for stateful applications.               |
| -                                                                                                                               | Security Risks: Randomness's inherent unpredictability increases difficulty of security systems to identify malicious patterns and detecting anomalities. |

Use Cases
- Homogeneous Environments: Environments where servers have similar capacity and performance.
- Stateless Applications: Requests are handled independently.
- Simple Deployments: Simple Deployments where the complexity of other load balancing algorithms are unjustified.