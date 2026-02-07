# Uses of Load Balancing Algorithms

## Overview
This section explains the fundamental uses of Load Balancing (`LB`) algorithms.

| Uses                                                                                                                                                                                                          |
|---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| [High Availability and Fault Tolerance](https://github.com/shumarb/designgurus/blob/main/grokking-system-design-fundamentals/readmes/load-balancing-algorithms-uses.md#high-availability-and-fault-tolerance) |
| [Horizontal Scalability](https://github.com/shumarb/designgurus/blob/main/grokking-system-design-fundamentals/readmes/load-balancing-algorithms-uses.md#horizontal-scalability)                               |

## Uses
### High Availability and Fault Tolerance
- Also known as `Survival Rule`, LBs are used when one of an application's server does not operate.
- LB does a `health check` on the servers by constantly pinging the servers to check that it is operating. The LB instantly cuts off servers that fail to answer or return an error, and reroutes to an operating server.
- Example:
  - Uber has 50 API servers handling ride requests, when Server #4 suffers a memory leak and freezes.
  - Without an LB: Users routed to Server #4 see an application error (e.g: spinning wheel), so they use a rival application, causing Uber to lose revenue.
  - With an LB: The LB removes Server #4 after it fails its health check (e.g: failed to return a 200 OK on a health check within 2 seconds), 100% of the traffic is spread across the remaining 49 servers, and the users do not notice the glitch.

### Horizontal Scalability
- Also known as 'Black Friday' defense.
- Leverages on `Horizontal Scaling`, where a `LB` serves as a `Unified Entry Point (UEP)` to distribute requests across new instances of `LB`s.
- Example: 
  - An e-commerce site experiences 1000 requests per second (`RPS`), but on `Black Friday`, it spikes to 100,000 RPS.
  - `Strategy`: The `Auto-Scaling Group` detects high CPU usage and boosts up 100 new LBs.
  - The LB serving as the UEP both registers and distributes requests across these new instances.