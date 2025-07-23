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
