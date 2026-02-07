# Uses of Load Balancing Algorithms

## Overview
This section explains the fundamental uses of Load Balancing (`LB`) algorithms.

| Uses                                                                                                                                                                                                          |
|---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| [High Availability and Fault Tolerance](https://github.com/shumarb/designgurus/blob/main/grokking-system-design-fundamentals/readmes/load-balancing-algorithms-uses.md#high-availability-and-fault-tolerance) |
| [Horizontal Scalability](https://github.com/shumarb/designgurus/blob/main/grokking-system-design-fundamentals/readmes/load-balancing-algorithms-uses.md#horizontal-scalability)                               |
| [Zero-Downtime Deployments](https://github.com/shumarb/designgurus/blob/main/grokking-system-design-fundamentals/readmes/load-balancing-algorithms-uses.md#zero-downtime-deployments)                         |

## Uses
### High Availability and Fault Tolerance
- Known as `Survival Rule`, LBs are used when one of an application's server does not operate.
- LB does a `health check` on the servers by constantly pinging the servers to check that it is operating. The LB instantly cuts off servers that fail to answer or return an error, and reroutes to an operating server.
- Example:
  - Uber has 50 API servers handling ride requests, when Server #4 suffers a memory leak and freezes.
  - Without an LB: Users routed to Server #4 see an application error (e.g: spinning wheel), so they use a rival application, causing Uber to lose revenue.
  - With an LB: The LB removes Server #4 after it fails its health check (e.g: failed to return a 200 OK on a health check within 2 seconds), 100% of the traffic is spread across the remaining 49 servers, and the users do not notice the glitch.

### Horizontal Scalability
- Known as `Black Friday` defense.
- Leverages on `Horizontal Scaling`, where a `LB` serves as a `Unified Entry Point (UEP)` to distribute requests across new instances of `LB`s.
- Example: 
  - An e-commerce site experiences 1000 requests per second (`RPS`), but on `Black Friday`, it spikes to 100,000 RPS.
  - `Strategy`: The `Auto-Scaling Group` detects high CPU usage and boosts up 100 new LBs.
  - The LB serving as the UEP both registers and distributes requests across these new instances.

### Zero-Downtime Deployments
- Known as `Blue-Green Meveuver`, the application's source code may have to be updated while users are using it.
- Developers signal the LB to stop sending new connections to a specific server while allowing existing connections to finish naturally, then take it offline for patching.
- Example:
  - A Banking API will have a `Blue` pool (`current` version) and a `Green` pool (`new` version).
  - LB is directed to send 1% of requests to `Green` pool. Keep increasing percentage as log as all requests are processed as normal.
  - When a bug is detected as the percentage increases, direct the LB to send the requests to the `Blue` pool.
  - This ensures instant rollback, no user downtime, and no failed transactions.