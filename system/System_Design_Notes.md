# System Design Notes

## Summary
- Keep web tier stateless
- Build redundancy at every tier
- Cache data as much as you can
- Support multiple data centres
- Host static assets in CDNs
- Scale your data tier by sharding
- Split tiers into individual services
- Monitor your system and use automation tools.

## Server Scaling

### Vertical Scaling
- Adding CPU, RAM to a server
- Good option for low traffic applications as it does not introduce complexity
- Vertical scaling has a hard cap as CPU, RAM are not infinitely expandable
- Failover remains an issue

### Horizontal Scaling
- Scale by adding more servers
- More desirable option for large scale applications as it does not have the limitations of vertical scaling
- Failover can be supported as traffic can be routed to a different server when one of the servers goes down  
- Load balencer is introduced to distribute traffic across all servers

## Database/Data Tier

### Database replication
- One database is designated the primary/master, this database handles all write operations
- One or more read replicas are created wich maintain a copy of data from the primary, all read operations take place through the read replicas

### Database scaling
#### Vertical Scaling
- More CPU and RAM can be added to apoint
- Greater risk of single point of failure
- High cost as large DB servers are expensive and only get more expensive as size increases

#### Horizontal Scaling
- Horizontal scaling is known as sharding
- More servers are added. These servers are called shards.
- Each shard uses the same schema but stored data is unique to the shard.
- The shard is selected using some sort of hashing mechanism.
- For example userId % 4 will identify which of the 4 shards to use based on a user id
- This is known as the shard key or partition key, the shard key is the most important factor to consider 
  as an incorrectly chosen shard key will not result in the data being evenly distributed across the shards.

##### Challenges
- Resharding is required when new servers/shards are added to the system. 
- Consistent hashing is a potential solution to uneven data distribution.
- Hotspot (celebrity problem) multiple celebrities landing on the same shard could lead to exhaustion as the shard can be overwhelmed by requests.
    - In these cases clebrities may be allocated their own shard, the sharding strategy needs to take this into account
- Joins and denormalization. Cross shard joins are very difficult a common workaround is to denormalize data to eliminate the need for joins.

## Cache Tier

### Benefits
- improved system performance
- reduced database load
- ability to scale cache tier independently

### Drawbacks
- Increased system complexity
- Cache invalidation can be difficult

### Considerations
#### When to use a cache
- Consider using a cache when data is read frequently but modified infrequently

#### Data expiration
- It is good practice to implement an expiration policy. When cached data has expired it is removed from the cache.

#### Consistency
- It is important to keep the cached data and system data in sync
- Maintaining consistency between the data store and cache can be difficult in a multi-region environment
[TODO] Investigate strategies for maintaining cache consistency

#### Failures
- Multiple cache servers eliminates cache servers as a single point of failure
- Overprovisioning memory by certain percentages provides a buffer as memory usage increases
[TODO] What percentage is recommended?

#### Eviction Policy
- Least Recently Used (LRU) is the most popular eviction policy
- Least Frequently Used (LFU) and First in First out are other common policies which can be used based on the use case.
[TODO] Understand when to use LRU, LFU and FIFO

### CDN
- Maintains a cache of static assets (images, JavaScript files, etc.)
- If the CDN has not cached the resource yet the CDN calls the origin to retrieve the cached asset.

#### Considerations
- What happens if the CDN goes down. Can the application react to this failure by retrieving the asset from the origin directly.
- Invalidating files. CDN APIs can be used to remove a file from the cache, alternatively a new version of the asset can be added to invalidate the current version.

## Stateless
- Stateless architecture requires storing session state in shared data storage. 
- Shared data storage could be a relational DB, NoSQL DB, memcache, redis, etc.
- NoSQL is a good option as it can be scalled quickly

## Multi-Region
- Introducing new regions requires duplicating backend infrastructure behind the load balencer.
- This means, servers, data storage and caches.
- geoDNS is a DNS service which resolves to different IP addresses based on the location of the user.
- Testing/deployment is important to ensure consistency between regions and validate changes being made

### Failover
- In the event of a single region going down we can route requests to another region, this requires data replication across regions

## Message Queue
- Serves as a buffer and distributes asynchronous requests
- Decouples the message producer from message consumers
- Consumer workers can be increased if message load increases or scaled back when there are no messages

## Logging
- Monitoring error logs is important to identify errors and debug issues
- Logs can be monitored per server or they can be aggregated to a centralized service to easier searching/viewing

## Metrics
- Metrics are useful to gain business insights and understand the health of the system
- Consider the following useful metrics:
    - Host level: CPU, Memory, disk, I/O, etc.
    - Aggregated level: database performance, cache performance, etc.
    - Key business metrics: daily active users, retention, revenue, etc.

## Automation
- CI/CD pipelines is a good practice when possible
- Automating the build, test and deploy process can increase developer productivity significantly


