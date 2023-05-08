# poodle

### Frameworks Used:
* [Ktor](https://ktor.io) - Web API
* [KVision (Kotlin/JS)](https://kvision.io) - Frontend Web Application

### Libraries Used:
* [Arrow (Core)](https://arrow-kt.io) - Error Handling and Monads
* [Ballast (Core & Navigation)](https://copper-leaf.github.io/ballast) - Frontend State Management and Routing
* [JetBrains Exposed](https://github.com/JetBrains/Exposed) - Database ORM Framework
* JDBC Drivers ([H2](https://www.h2database.com) / [MySQL](https://dev.mysql.com/downloads/connector/j) - Database Access
* [Koin](https://insert-koin.io) - Dependency Injection + Ktor Bindings
* [kotlinx-datetime](https://github.com/Kotlin/kotlinx-datetime) - Multiplatform Datetime Library
* [Ktor](https://ktor.io) - Http Client
* [KVision Modules](https://kvision.gitbook.io/kvision-guide/1.-getting-started-1/modules) - Rich Integrations and Libraries for Frontend Development

# Change Log
All notable changes to this project will be documented. See [ChangeLog](CHANGELOG.md) for details.


## Gradle Tasks

INFORMATIONS
* zum bauen der Anwendung untere Resourcen erstellen.
* In IntelliJ rechte Seite den Tab Gradle aufklappen und die Sachen in angegebener Reihenfolge bauen.
* Anwendung dann im Browser starten http://localhost:3000/

### Compiling
* compileKotlinFrontend - Compiles frontend sources.
* compileKotlinBackend - Compiles backend sources.
### Running
* frontendRun - Starts a webpack dev server on port 3000
* backendRun - Starts a dev server on port 8080
### Packaging
* frontendBrowserWebpack - Bundles the compiled js files into `build/distributions`
* frontendJar - Packages a standalone "web" frontend jar with all required files into `build/libs/*.jar`
* backendJar - Packages a backend jar with compiled source files into `build/libs/*.jar`
* jar - Packages a "fat" jar with all backend sources and dependencies while also embedding frontend resources into `build/libs/*.jar`