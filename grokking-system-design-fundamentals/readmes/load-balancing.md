# Load Balancing

## Overview
This folder is my summary of Load Balancing Concepts:

| Concept                         |
|---------------------------------|
| [Introduction](#introduction)   |
| [Terminologies](#terminologies) |
| [Execution](#execution)         |
| [Algorithms](#algorithms)       |

## Introduction
Load Balancing is the **even** distribution of incoming requests and traffic across multiple servers to ensure:
- High availability.
- Reliability.
- Performance.

A load balancer sits between the **client** and the **server** accepting incoming network application traffic and distributing the traffic across multiple backend servers using various algorithms.
This reduces the load on individual servers and prevents any one server from becoming a single point of failure,
thus improving the application's reliability and responsiveness.

To utilize full scalability and reduce redundancy, a load balancer is added at these places:
- Between the user and the web server.
- Between the web server and an internal platform layer (eg: application servers).
- Between the internal platform layer and database.

## Terminologies

| Terminology              | Description                                                                                                                                                            |
|--------------------------|------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| Load Balancer            | Software that distributes network traffic across multiple servers based on predefined algorithms.                                                                      |
| Load Balancing Algorithm | Method used by the load balancer to determine how to distribute incoming traffic among the backend servers.                                                            |
| Backend Servers          | The servers that receive and process requests forwarded by the load balancer. Also referred to as the **Server Pool** or **Server Farm**.                              |
| Health Checks            | Periodic tests that the load balancer performs to determine the availability and performance of backend servers.                                                       |
| Session Persistence      | Process requests from the same client are directed to the same backend server to maintain session state and provide a consistent user experience.                      |
| SSL/TLS Termination      | Decryption of SSL/TLS-encrypted traffic at the load balancer level to offload the decryption burden from backend servers and allow for centralized SSL/TLS management. |

## Execution
| # | Description                                                                                                        |
|---|--------------------------------------------------------------------------------------------------------------------|
| 1 | Load balancer receives and evaluates the request from a client.                                                    |
| 2 | Load balancer determines which server or resource should handle the request via various load balancing algorithms. |
| 3 | Load balancer forwards the incoming traffic to the selected server.                                                |
| 4 | Server processes the request and sends a response back to the load balancer.                                       |
| 5 | Load balancer receives the response from the server or resource and sends it to the client.                        |

## Algorithms
### 1. Round Robin
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

### 2. Least Connections
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

### 3. Weighted Round Robin
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

### 4. Weighted Least Connections
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
