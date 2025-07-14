# Load Balancing

## Overview
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
1. The load balancer receives the request from a client.
2. The load balancer evaluates the incoming request and determines which server or resource should handle the request via various load balancing algorithms.
3. The load balancer forwards the incoming traffic to the selected server or resource.
4. The server or resource processes the request and sends a response back to the load balancer.
5. The load balancer receives the response from the server or resource and sends it to the client.
