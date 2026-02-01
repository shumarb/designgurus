# Uses of Load Balancing Algorithms

## Overview
This section explains the fundamental uses of Load Balancing (LB) algorithms.

| Uses                                                                                                                                                                                                          |
|---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| [High Availability and Fault Tolerance](https://github.com/shumarb/designgurus/blob/main/grokking-system-design-fundamentals/readmes/load-balancing-algorithms-uses.md#high-availability-and-fault-tolerance) |

### High Availability and Fault Tolerance
- Also known as `Survival Rule`, LBs are used when a server of large-scale application does not operate.
- LB does a `health check` on the servers by constantly pinging the servers to check that it is operating. If a server fails to answer or returns an error, the LB cuts it off instantly and reroutes to an operating server.
- Example:
  - Uber has 50 API servers handling ride requests, when Server #4 suffers a memory leak and freezes.
  - Without an LB: Users routed to Server #4 see an application error (e.g: spinning wheel), so they use a rival application, causing Uber to lose revenue.
  - With an LB: The LB sees that Server #4 failed its health check (e.g: failed to return a 200 OK on a health check within 2 seconds), so it removes Server #4 from the active rotation, and 100% of the traffic is spread across the remaining 49 servers, and the users do not notice the glitch.
