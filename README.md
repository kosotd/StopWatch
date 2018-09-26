# Stopwatch

Сlass for code time measurements.

Usage: 
```
      StopWatch.getInstance(0).start();
      ...
      StopWatch.getInstance(1).start();
      ...
      long nano = StopWatch.getInstance(1).stop(TimeUnit.NANOSECONDS);
      ...
      StopWatch.getInstance(0).stop((logger, time) -> {
            logger.info("milliseconds: " + time);
      });
```      
      
Maven:
```
    <dependency>
      <groupId>com.kosotd</groupId>
      <artifactId>stopwatch</artifactId>
      <version>1.0</version>
    </dependency>
    ...
    <repository>
        <id>stopwatch-mvn-repo</id>
        <url>https://raw.github.com/kosotd/Stopwatch/mvn-repo/</url>
    </repository>
```
