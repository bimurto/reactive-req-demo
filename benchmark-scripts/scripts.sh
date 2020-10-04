# blocking application
# Server Thread count 4
ab -n 10000 -c 20 http://localhost:8080/blocking
# result : can serve max 4 requests. No request queue where it can queue the requests.

# io thread: 2, worker thread : 4
ab -n 10000 -c 20 http://localhost:8082/blocking
# result : similar to tomcat, threads does not do anything when blocked.

ab -n 10000 -c 20 http://localhost:8081/blocking
# threads count : 1 per cpu.