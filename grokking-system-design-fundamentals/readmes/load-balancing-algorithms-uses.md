# Uses of Load Balancing Algorithms

## Overview
This section explains the fundamental uses of Load Balancing (`LB`) algorithms.

| Uses                                                                                                                                                                                                          |
|---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| [High Availability and Fault Tolerance](https://github.com/shumarb/designgurus/blob/main/grokking-system-design-fundamentals/readmes/load-balancing-algorithms-uses.md#high-availability-and-fault-tolerance) |
| [Horizontal Scalability](https://github.com/shumarb/designgurus/blob/main/grokking-system-design-fundamentals/readmes/load-balancing-algorithms-uses.md#horizontal-scalability)                               |
| [Zero-Downtime Deployments](https://github.com/shumarb/designgurus/blob/main/grokking-system-design-fundamentals/readmes/load-balancing-algorithms-uses.md#zero-downtime-deployments)                         |
| [Security & Attack Mitigation](https://github.com/shumarb/designgurus/blob/main/grokking-system-design-fundamentals/readmes/load-balancing-algorithms-uses.md#security-&-attack-mitigation)                   |

## Uses
### High Availability and Fault Tolerance
- Known as `Survival Rule`, LBs are used when one of an application's server does not operate.
- LB does a `health check` on the servers by constantly pinging the servers to check that it is operating. The LB instantly cuts off servers that fail to answer or return an error, and reroutes to an operating server.
- Example: Uber application using 50 API server handling requests
  - Server #4 suffers a memory leak and freezes.
  - Without an LB: Users routed to Server #4 see an application error (e.g: spinning wheel), so they use a rival application, causing Uber to lose revenue.
  - With an LB: The LB removes Server #4 after it fails its health check (e.g: failed to return a 200 OK on a health check within 2 seconds), 100% of the traffic is spread across the remaining 49 servers, and the users do not notice the glitch.

### Horizontal Scalability
- Known as `Black Friday` defense.
- Leverages on `Horizontal Scaling`, where a `LB` serves as a `Unified Entry Point (UEP)` to distribute requests across new instances of `LB`s.
- Example: E-commerce application
  - Normally experiences 1000 requests per second (`RPS`), but on `Black Friday`, it spikes to 100,000 RPS.
  - `Strategy`: The `Auto-Scaling Group` detects high CPU usage and boosts up 100 new LBs.
  - The LB serving as the UEP both registers and distributes requests across these new instances.

### Zero-Downtime Deployments
- Known as `Blue-Green Maneuver`, the application's may be updated while users use it.
- Developers signal the LB to stop sending new connections to a specific server while allowing existing connections to finish naturally, then take it offline for patching.
- Example: Banking API
  - `Blue` pool (`current` version) and a `Green` pool (`new` version).
  - LB is directed to send 1% of requests to `Green` pool. Keep increasing percentage as log as all requests are processed as normal.
  - When a bug is detected as the percentage increases, direct the LB to send the requests to the `Blue` pool.
  - This ensures instant rollback, no user downtime, and no failed transactions.

### Security & Attack Mitigation
- Known as `The Shield`. LBs ensure that application servers are secured from attacks.
- LBs serve as `Reverse Proxy`, where the `client` interacts with the LB, which interacts with the `server`/
- LBs absorb `Distributed Denial of Service (DDoS)` attacks and filter malicious traffic before it touches application logic.
- Example: Social Media Platform
  - Botnet targets the login page with a `SYN Flood Attack` (millions of fake connection requests) to crash your application's database.
  - You configure a `Cloud Load Balance` (e.g. Cloudflare) with `Web Applicaiton Firewall (WAF)` rules.
  - The LB detects abnormal traffic pattern. It drops these connections at the edge, ensuring backend servers see only valid traffic volumes and continue to process legitimate user logins.