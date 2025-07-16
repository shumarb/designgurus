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

| Terminology              | Description                                                                                                                                                                         |
|--------------------------|-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| Load Balancer            | A device/software that distributes network traffic across multiple servers based on predefined rules/algorithms.                                                                    |
| Load Balancing Algorithm | A method used by the load balancer to determine how to distribute incoming traffic among the backend servers.                                                                       |
| Backend Servers          | The servers that receive and process requests forwarded by the load balancer. Also referred to as the **Server Pool** or **Server Farm**.                                           |
| Health Checks            | Periodic tests that the load balancer performs to determine the availability and performance of backend servers.                                                                    |
| Session Persistence      | A technique that ensures subsequent requests from the same client are directed to the same backend server to maintain session state and provide a consistent user experience.       |
| SSL/TLS Termination      | The process of decrypting SSL/TLS-encrypted traffic at the load balancer level, to offload the decryption burder from backend servers and allow for centralized SSL/TLS management. |

## Execution
| # | Description                                                                                                        |
|---|--------------------------------------------------------------------------------------------------------------------|
| 1 | Load balancer receives and evaluates the request from a client.                                                    |
| 2 | Load balancer determines which server or resource should handle the request via various load balancing algorithms. |
| 3 | Load balancer forwards the incoming traffic to the selected server or resource.                                    |
| 4 | Server or resource processes the request and sends a response back to the load balancer.                           |
| 5 | Load balancer receives the response from the server or resource and sends it to the client.                        |

## Algorithms
### Round Robin
- Technique: Distributes incoming requests to servers in a cyclic order by assigning a request to the first server, the moves to the second, third, until the last server, before starting again at the first.

| Advantages                                                   | Disadvantages                                                                                                                                                                     |
|--------------------------------------------------------------|-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| Ensures an equal distribution of requests among the servers. | Does not consider the current load or capacity of each server. All servers are treated equally regardless of their current state.                                                 |
| Easy to implement and understand.                            | Subsequent requests from the same client may be directed to different servers, which can be problematic for stateful applications.                                                |
| Works well when servers have similar capacities.             | Predictable request distribution pattern risks being exploited by attackers by finding vulnerabilities in specific servers by predicting which server will handle their requests. |
