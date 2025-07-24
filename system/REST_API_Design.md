# Services/Microservices

## HTTP Fundamentals

### Idempotency
An HTTP method is considered idempotent if sending a request multiple times produces the same result as sending it once.
Idempotent methods can be safely retried in the case of failure and allows for response caching.

### OPTIONS Method
- Retrieves communication options availalbe for a resource or server. Allows clients to determine which HTTP methods are supported for a specific resource or server.
- Idempotent
- Safe: Does not modify internal state or have side effects

### GET Method
- Used to retrieve a resource or collection of resources. Get requests should not modify state nor have any side effects.
- Idempotent
- Safe: Does not modify internal state or have side effects.

### HEAD Method
- Similar to GET, however only headers are returned
- Idempotent
- Safe: Does not modify internal state or have side effects.

### POST Method
- Typically used for creating new resources. Each request creates a new resource or causes a different side effect.
- NON Idempotent: Multiple requests may result in the creation of multiple resources or multiple side effects.
- Unsafe: Modifies internal state or may have other side effects.

### PUT Method
- Generally used to update/replace a resource. However, it can be used to create resources as well in cases where clients have control/agency over resource identifiers/locations.
- A PUT request should contain the entire resource being updated/replaced.
- Optimistic locking should be used to prevent last update problems. See the section on optimistic locking.
- Idempotent
- Unsafe: Modifies internal state or may have other side effects.

### PATCH Method
- Used to partially update a resource. JSONPatch is a common format used to describe requested modifications and assertions/tests related to required current resource state.
- NON Idempotent: Multiple requests may modify server state and can have side effects.
- Unsafe: Modifies internal state or may have other side effects.

### DELETE Method
- Used to delete a resource from the system.
- Idempotent: Though some APIs will return 200 for the initial request and 404 subsequently the internal state remains the same regardless of the number of delete requests received.
- Unsafe: Modifies internal state or may have other side effects.

### TRACE Method
- Echos the request back to the client.
- Idempotent: Multiple requests do not further modify internal state.
- Safe: Does not modify internal state.

### Common Headers
#### Accept Request Header
- Indicates which content types (Mime Types) the client is able to handle/understand. 
- If multiple content types are provided the server will select one and inform the client using the Content-Type response header.

#### Content-Type Response Header
- Informs the client of the media type of the returned data.

#### Location Response Header
- Response Header (GET, HEAD, PUT, POST)
- Returns the location/url of a created resource.
- Returned in redirection responses like 303 See Other, 307 Temporary Redirect, 301 Moved Permanently

#### E-Tag Response Header
- Response Header (GET, HEAD, PUT, PATCH and POST)
- Contains the current version of a resource, changes each time the resource is modified. 
- Used by caching to determine when to invalidate a cached resource.
- Used in optimistic locking to assert a resource is in an expected state before applying an update.

#### Last-Modified Response Header
- Response Header (GET, HEAD, PUT, PATCH and POST)
- Contains the datetime when the resource was last modified (second precision). 
- Used by caching to determine when to invalidate a cached resource.
- Used in optimistic locking to assert a resource is in an expected state before applying an update.

### Custom Headers
- Historically proprietary/custom headers were prefixed with `X-` but this convention was deprecated in 2012 due to the inconvenience of transitioning non-standard fields to standards. 

### Caching
- HTTP Response caching can greatly improve performance of a distributed system while reducing the load on microservices and backend databases.
- E-Tag or Last-Modified header values can be used to determine when to invalidate a cached resource.

#### If-None-Match Request Header
- Contains an E-Tag value in an HTTP GET request to instruct the server to return a response if the resource version/e-tag has changed.
- If the resource has not changed a 304 Not Modified or 412 Precondition Failed response will be returned.
- If the resource has changed the resource will be returned, the cache can be updated with new resource content and E-Tag version.

#### If-Modified-Since Request Header
- If-Modified-Since header is sent with the Last-Modified value or a specific datetime in an HTTP GET request to instruct the server to return a response only if the resource has been modified since the datetime provided.
- If the resource has not changed a 304 Not Modified or 412 Precondition Failed response will be returned.
- If the resource has changed the resource will be returned, the cache can be updated with new resource content and Last-Modified value.

#### Cache-Control Response Header
- Cache-Control header may be returned by the server to control how clients cache specific resources.
- max-age=[seconds] may be returned in order to control the duration of cached resources.
- s-max-age=[seconds] may be returned in order to control the duration of cached resources by CDNs.
- no-cache allows for caching but requires the cached resource to be revalidated each time before use.
- no-store prevents caching altogether
- public: may be cached by any cache
- private: may only be cached by browsers and not intermediaries like CDNs
- immutable: can be cached indefinitely

Examples: 
- `max-age=31536000, public` can be cached for a year by any cache
- `no-store, no-cache` prevent caching of sensitive data 

### Optimistic Locking
- Ensures client requests are not operating on stale resource state. 
- Prevents the last to write wins problem where multiple updates may overwrite one another.
- Uses the same set of headers as caching to identify resource state. 

#### If-Match Request Header
- Contains an E-Tag value to instruct the server to execute the request if the current resource e-tag/version matches the given value.
- Included in HTTP PUT and POST requests.
- If the resource has not changed the request will execute normally.
- If the resource has changed a 412 Precondition Failed response will be returned.
- When a 412 Precondition Failed response is returned the client should retrieve the updated resource, re-apply the change and re-submit a new request. Users may be involved in this process depending on the nature of the API and changes being made to the resource.

#### If-Unmodified-Since Request Header
- Contains a datetime string which can be retrieve from the Last-Modified header or directly from the resource.
- Included in HTTP PUT and POST requests.
- If the resource has not been modified the request will execute normally.
- If the resource has been modified a 412 Precondition Failed response will be returned.
- When a 412 Precondition Failed response is returned the client should retrieve the updated resource, re-apply the change and re-submit a new request. Users may be involved in this process depending on the nature of the API and changes being made to the resource.


### Cross Origin Resource Sharing (CORS) Headers
- Security feature implemented by browsers to restrict web pages/applications from making requests to a different domain than the one that served the web page.
- Gives control over which HTTP methods, request headers, response headers may be used in cross origin requests.

#### How it works
1. Preflight request. When a browser first encounters a cross-origin request. Generally done via an OPTIONS request.
2. Preflight response. Server responds with cors headers indicating which methods, headers, etc. may be used in cross-origin requests.
3. Browser determines if the request is allowed and sends the request if so.
4. Server response to the request with CORS headers.
5. Browser checks the Access-Control-Allow-Origin header against the origin to confirm they match before allowing the page to access the contents of the response.

## Representational State Transfer (REST)

- Representational state transfer means the server will respond with the representation of a resource.
- The representation of the resource will also contain hypermedia links that can be followed to make the state of the system change. Any such request will in turn receive the representation of a resource and so on. 
- Today most REST APIs return resources as JSON or XML documents though servers also return HTML and other representations.
- A consequence of this is 

### Constraints of REST Architectural Style
- Staeless
- Cache - Responses indicate their own cacheability
- Layered system - Client cannot tell if they are connected directly to the system or some intermediary
- Uniform Interface - Resources are identified in requests using URIs. Resources are separated from the representation that is returned to the client. It could be JSON, XML, YAML, HTML, etc.
- Hypermedia as the engine of application state (HATEOAS) - Having accessed an initial URI for the rest application a rest client should then be able to use server-provided links dynamicaly to discover all the available resources it needs.

## REST API Design

In a RESTful API resources are defined using nouns while HTTP Methods define the actions/verbs. 

RESTful APIs are constructed of individual resources as well as collections of resources. 
URIs are constructed to represent the heirarchy of resources within the system. URIs for sub-resources are added to the URIs of parent resources.
For example an API listing cities that belong to a specific country would be represented as:
- /countries/{country}/cities

### Maturity levels for REST API design

### Level 0 - Single API
- POST /registrationService - add/retrieve/delete courses, add/cancel registrations

### Level 1 - Resources
- POST /courses - add/retrieve/delete courses
- POST /registrations - add/cancel registrations

### Level 2 - HTTP Verbs
- POST /courses - create a course
- GET /courses - retrieve courses
- DELETE /courses/<courseid> - delete a course
- GET /registrations - retrieve registrations
- POST /registrations - create registrations
- PUT/PATCH /registrations - cancel registrations

### Level 3 - Hypermedia controls
- In this level the API responds with metadata including hypermedia controls available.
    * A JSON response may have a _links field in the response which contains URIs which may indicate actions that can be taken on the current resource or reference related resources.

### API for Background/Asynchronous Tasks
- The following is an example REST API which supports execution of background/asynchronous jobs.
- POST /jobs - create a new background job. This could use Kafka or some other job processing library to enqueue the job.
    * Response Location header provides the URI of the newly created job /jobs/1234
- GET /jobs/<jobid> - retrieve the state of the job
- PUT or PATCH /jobs/<jobid> - Supports updating the state of the job. Can be used to cancell the job as long as that's available given the jobs current state.
- GET /jobs - list jobs, support filtering and pagination

### Filtering

TBD

### Pagination

TBD

### API Versioning
- Avoid if at all possible, make changes in a backwards compatible way. Introducing versioning greatly increases the complexity of the API and maintenance.
- Semantic versioning is typical, though some APIs (like microsoft) follow date/time and classification like `preview` to indicate versions whose functionality may change and which may not be supported long term

#### URL versioning
- Requested version is provided as part of the URL.
- Example: `/v1/myApi`
- Easier for an API Gateway/Load Balencer to route different API versions to different backend services.
- Effectively introduces new resource locations for each new API version. /v1/myResource, /v2/myResource may both point to the same underlying resource. 

#### Request parameter versioning
- Requested version is provided as a request parameter.
- Example: `/myApi?v=1`
- This approach is somewhat cleaner that url based versioning from an API perspective as it does not introduce new resource locations an API evolves.
- Requires support for this type of request routing from the framework being used, may require custom routing logic.

#### Media-Type Versioning (Accept header)
- Requested version is included in the media type provied in the accept header.
- Example: `Accept: application/json; version=1`
- This approach is somewhat cleaner that url based versioning from an API perspective as it does not introduce new resource locations an API evolves.
- May require a framework which supports routing requests based on header values or a custom request routing implementation as not all frameworks support this style of routing.
- Can be more difficult to debug.

#### Custom Header Versioning
- Requested version is included in a custom header (`Accept-Version`).
- Example: `Api-Version: 1`
- This approach is somewhat cleaner from an API perspective as it does not introduce new resource locations an API evolves.
- May require a framework which supports routing requests based on header values or a custom request routing implementation as not all frameworks support this style of routing.


## Real Time Client Communication

### Server Side Events (SSE)
- Unidirectional
- Simpler to implement/maintain.
- Use for one way real time communication of events from server to client.
- News feeds, stock tickers, social media updates, etc.

### WebSockets
- Bidirectional
- More complex
- Use when real time interactive communication is required.
- Chat applications, multi-player games, etc.

