# Google Spanner- Spring Boot Connectivity

Example in this repo 
 * Connecting to gcloud spanner
 * Write to spanner 
 * Read from spanner

### Prerequisites 

* setup service account in gcloud space
* verify login ` gcloud auth login`
* set up the project
* setup the spanner instance and database

```
Maheshs-MBP:gcloud-spanner mahesh$ gcloud services enable spanner.googleapis.com
Maheshs-MBP:gcloud-spanner mahesh$ gcloud spanner databases list --instance=gcloud-spring
NAME    STATE
people  READY

```

### Send some requests 
```
Maheshs-MBP:gcloud-spanner mahesh$ curl localhost:8080/greet/mahesh
[{"id":"822b60ff-9d64-49ea-b13d-fea509693e7c","name":"mahesh"}]
Maheshs-MBP:gcloud-spanner mahesh$ curl localhost:8080/greet/shawn
[{"id":"5e7bb060-5208-47f7-b43a-368a30f9fe48","name":"shawn"}]
```

```
 .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::        (v2.3.1.RELEASE)

2020-07-20 17:49:02.663  INFO 3560 --- [           main] c.g.g.GcloudSpannerApplication           : Starting GcloudSpannerApplication on Maheshs-MBP with PID 3560 (/Users/mahesh/play/gcloud/gcloud-spanner/target/classes started by mahesh in /Users/mahesh/play/gcloud/gcloud-spanner)
2020-07-20 17:49:02.665  INFO 3560 --- [           main] c.g.g.GcloudSpannerApplication           : No active profile set, falling back to default profiles: default
2020-07-20 17:49:03.364  INFO 3560 --- [           main] .s.d.r.c.RepositoryConfigurationDelegate : Bootstrapping Spring Data Spanner repositories in DEFAULT mode.
2020-07-20 17:49:03.404  INFO 3560 --- [           main] .s.d.r.c.RepositoryConfigurationDelegate : Finished Spring Data repository scanning in 36ms. Found 1 Spanner repository interfaces.
2020-07-20 17:49:03.907  INFO 3560 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat initialized with port(s): 8080 (http)
2020-07-20 17:49:03.921  INFO 3560 --- [           main] o.apache.catalina.core.StandardService   : Starting service [Tomcat]
2020-07-20 17:49:03.921  INFO 3560 --- [           main] org.apache.catalina.core.StandardEngine  : Starting Servlet engine: [Apache Tomcat/9.0.36]
2020-07-20 17:49:03.988  INFO 3560 --- [           main] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring embedded WebApplicationContext
2020-07-20 17:49:03.989  INFO 3560 --- [           main] w.s.c.ServletWebServerApplicationContext : Root WebApplicationContext: initialization completed in 1282 ms
2020-07-20 17:49:04.159  INFO 3560 --- [           main] o.s.c.g.a.c.GcpContextAutoConfiguration  : The default project ID is gcloud-spring-starter
2020-07-20 17:49:04.187  WARN 3560 --- [           main] c.g.a.oauth2.DefaultCredentialsProvider  : Your application has authenticated using end user credentials from Google Cloud SDK. We recommend that most server applications use service accounts instead. If your application continues to use end user credentials from Cloud SDK, you might receive a "quota exceeded" or "API not enabled" error. For more information about service accounts, see https://cloud.google.com/docs/authentication/.
2020-07-20 17:49:04.187  INFO 3560 --- [           main] o.s.c.g.core.DefaultCredentialsProvider  : Default credentials provider for user 764086051850-6qr4p6gpi6hn506pt8ejuq83di341hur.apps.googleusercontent.com
2020-07-20 17:49:04.188  INFO 3560 --- [           main] o.s.c.g.core.DefaultCredentialsProvider  : Scopes in use by default credentials: [https://www.googleapis.com/auth/pubsub, https://www.googleapis.com/auth/spanner.admin, https://www.googleapis.com/auth/spanner.data, https://www.googleapis.com/auth/datastore, https://www.googleapis.com/auth/sqlservice.admin, https://www.googleapis.com/auth/devstorage.read_only, https://www.googleapis.com/auth/devstorage.read_write, https://www.googleapis.com/auth/cloudruntimeconfig, https://www.googleapis.com/auth/trace.append, https://www.googleapis.com/auth/cloud-platform, https://www.googleapis.com/auth/cloud-vision, https://www.googleapis.com/auth/bigquery]
2020-07-20 17:49:05.786  INFO 3560 --- [           main] o.s.s.concurrent.ThreadPoolTaskExecutor  : Initializing ExecutorService 'applicationTaskExecutor'
2020-07-20 17:49:06.071  INFO 3560 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port(s): 8080 (http) with context path ''
2020-07-20 17:49:06.080  INFO 3560 --- [           main] c.g.g.GcloudSpannerApplication           : Started GcloudSpannerApplication in 3.704 seconds (JVM running for 4.142)
2020-07-20 17:49:37.229  INFO 3560 --- [nio-8080-exec-1] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring DispatcherServlet 'dispatcherServlet'
2020-07-20 17:49:37.230  INFO 3560 --- [nio-8080-exec-1] o.s.web.servlet.DispatcherServlet        : Initializing Servlet 'dispatcherServlet'
2020-07-20 17:49:37.242  INFO 3560 --- [nio-8080-exec-1] o.s.web.servlet.DispatcherServlet        : Completed initialization in 12 ms
2020-07-20 17:49:37.262  INFO 3560 --- [nio-8080-exec-1] c.gcloud.gcloudspanner.PersonController  : org.springframework.cloud.gcp.data.spanner.repository.support.SimpleSpannerRepository@13e46834
2020-07-20 17:51:30.481  INFO 3560 --- [nio-8080-exec-2] c.gcloud.gcloudspanner.PersonController  : org.springframework.cloud.gcp.data.spanner.repository.support.SimpleSpannerRepository@13e46834

```