## Проект для работы вакансиями

Kotlin, Spring Boot 2.5.6, Gradle, build.gradle.kts, Java 11 

### Тесты

````shell
./gradlew test
````

### Запуск

Для Java 11

````shell
$ export JAVA_HOME=/usr/lib/jvm/java-11-openjdk-amd64
$ ./gradlew bootRun
.   ____          _            __ _ _
/\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
\\/  ___)| |_)| | | | | || (_| |  ) ) ) )
'  |____| .__|_| |_|_| |_\__, | / / / /
=========|_|==============|___/=/_/_/_/
:: Spring Boot ::               (v2.6.15)

2025-01-15 17:11:35.078  INFO 11306 --- [           main] r.p.v.s.StartkS_2_6_15_ApplicationKt     : 
    Starting StartkS_2_6_15_ApplicationKt using Java 11.0.19 on 
````

Для Java 17:

````shell
$ echo $JAVA_HOME
/usr/lib/jvm/java-17-openjdk-amd64
$ ./gradlew bootRun

> Task :bootRun

.   ____          _            __ _ _
/\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
\\/  ___)| |_)| | | | | || (_| |  ) ) ) )
'  |____| .__|_| |_|_| |_\__, | / / / /
=========|_|==============|___/=/_/_/_/
:: Spring Boot ::               (v2.6.15)

2025-01-15 17:08:20.494  INFO 10958 --- [           main] r.p.v.s.StartkS_2_6_15_ApplicationKt: 
  Starting StartkS_2_6_15_ApplicationKt using Java 17.0.7
...
````

### Частные параметры в application.yaml

Реализуется классом __ru.perm.v.vacancy.config.MyConfig__. Используется н.п. в CompanyServiceImpl.kt.