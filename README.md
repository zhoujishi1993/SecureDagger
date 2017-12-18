# Dagger 2

[![Maven Central][mavenbadge-svg]][mavenbadge]

A fast dependency injector for Android and Java.

## About Google's Fork

Dagger 2 is a compile-time evolution approach to dependency injection.
Taking the approach started in Dagger 1.x to its ultimate conclusion,
Dagger 2.x eliminates all reflection, and improves code clarity by
removing the traditional ObjectGraph/Injector in favor of user-specified
`@Component` interfaces.

This github project represents the Dagger 2 development stream.  The earlier
[project page][square] (Square, Inc's repository) represents the earlier 1.0
development stream. Both versions have benefitted from strong involvement from
Square, Google, and other contributors.

Dagger is currently in active development, primarily internally at Google,
with regular pushes to the open-source community. Snapshot releases are
auto-deployed to sonatype's central maven repository on every clean build with
the version `HEAD-SNAPSHOT`.

> [Dagger 2's main documentation website can be found here.][website]

## Documentation

You can [find the dagger documentation here][website] which has extended usage
instructions and other useful information.  Substantial usage information can be
found in the [API documentation][20api].

You can also learn more from [the original proposal][proposal],
[this talk by Greg Kick][gaktalk], and on the dagger-discuss@googlegroups.com
mailing list.

## Installation

You will need to include the `dagger-2.x.jar` in your application's runtime.
In order to activate code generation and generate implementations to manage
your graph you will need to include `dagger-compiler-2.x.jar` in your build
at compile time.

### Maven

In a Maven project, include the `dagger` artifact in the dependencies section
of your `pom.xml` and the `dagger-compiler` artifact as an
`annotationProcessorPaths` value of the `maven-compiler-plugin`:

```xml
<dependencies>
  <dependency>
    <groupId>com.google.dagger</groupId>
    <artifactId>dagger</artifactId>
    <version>2.x</version>
  </dependency>
</dependencies>
<build>
  <plugins>
    <plugin>
      <groupId>org.apache.maven.plugins</groupId>
      <artifactId>maven-compiler-plugin</artifactId>
      <version>3.6.1</version>
      <configuration>
        <annotationProcessorPaths>
          <path>
            <groupId>com.google.dagger</groupId>
            <artifactId>dagger-compiler</artifactId>
            <version>2.x</version>
          </path>
        </annotationProcessorPaths>
      </configuration>
    </plugin>
  </plugins>
</build>
```

If you are using a version of the `maven-compiler-plugin` lower than `3.5`, add
the `dagger-compiler` artifact with the `provided` scope:

```xml
<dependencies>
  <dependency>
    <groupId>com.google.dagger</groupId>
    <artifactId>dagger</artifactId>
    <version>2.x</version>
  </dependency>
  <dependency>
    <groupId>com.google.dagger</groupId>
    <artifactId>dagger-compiler</artifactId>
    <version>2.x</version>
    <scope>provided</scope>
  </dependency>
</dependencies>
```

If you use the beta `dagger-producers` extension (which supplies
parallelizable execution graphs), then add this to your maven configuration:

```xml
<dependencies>
  <dependency>
    <groupId>com.google.dagger</groupId>
    <artifactId>dagger-producers</artifactId>
    <version>2.x</version>
  </dependency>
</dependencies>
```

### Java Gradle
```groovy
// Add plugin https://plugins.gradle.org/plugin/net.ltgt.apt
plugins {
  id "net.ltgt.apt" version "0.10"
}

// Add Dagger dependencies
dependencies {
  compile 'com.google.dagger:dagger:2.x'
  apt 'com.google.dagger:dagger-compiler:2.x'
}
```

### Android Gradle
```groovy
// Add Dagger dependencies
dependencies {
  compile 'com.google.dagger:dagger:2.x'
  annotationProcessor 'com.google.dagger:dagger-compiler:2.x'
}
```

If you're using classes in `dagger.android` you'll also want to include:

```groovy
compile 'com.google.dagger:dagger-android:2.x'
compile 'com.google.dagger:dagger-android-support:2.x' // if you use the support libraries
annotationProcessor 'com.google.dagger:dagger-android-processor:2.x'
```

If you're using a version of the Android gradle plugin below `2.2`, see
https://bitbucket.org/hvisser/android-apt.

If you're using the [Android Databinding library][databinding], you may want to
increase the number of errors that `javac` will print. When Dagger prints an
error, databinding compilation will halt and sometimes print more than 100
errors, which is the default amount for `javac`. For more information, see
[Issue 306](https://github.com/google/dagger/issues/306).

```groovy
gradle.projectsEvaluated {
  tasks.withType(JavaCompile) {
    options.compilerArgs << "-Xmaxerrs" << "500" // or whatever number you want
  }
}
```

### Download

  * 2.x (google/dagger)
    * [Dagger 2.0 Documentation][website]
    * [Dagger 2.0 Javadocs][20api]
    * [Dagger development Javadocs][latestapi] (from the `master` branch
      on GitHub)
    * [Google's Dagger project site on GitHub][project]
    * <a href="https://plus.google.com/118328287768685565185"
         rel="publisher">Google+ Dagger Project Page</a>
    * [Google+ Dagger Users Community][community]
  * 1.x (square/dagger)
    * [Square's original Dagger project site on GitHub][square]
    * [Square Open Source Community][squarecommunity]


If you do not use maven, gradle, ivy, or other build systems that consume
maven-style binary artifacts, they can be downloaded directly via the
[Maven Central Repository][mavensearch].

Developer snapshots are available from Sonatype's
[snapshot repository][dagger-snap], and are built on a clean build of
the GitHub project's master branch.

## Building Dagger

Dagger is built with [`bazel`]. The tests can be run with `bazel test //...`.
`util/install-local-snapshot.sh` will build all of the Dagger libraries and
install a copy in your local maven repository with the version `LOCAL-SNAPSHOT`.

## License

    Copyright 2012 The Dagger Authors

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.

[20api]: https://google.github.io/dagger/api/2.0/
[`bazel`]: https://bazel.build
[community]: https://plus.google.com/communities/111933036769103367883
[dagger-snap]: https://oss.sonatype.org/content/repositories/snapshots/com/google/dagger/
[databinding]: https://developer.android.com/topic/libraries/data-binding/
[gaktalk]: https://www.youtube.com/watch?v=oK_XtfXPkqw
[latestapi]: https://google.github.io/dagger/api/latest/
[mavenbadge-svg]: https://maven-badges.herokuapp.com/maven-central/com.google.dagger/dagger/badge.svg
[mavenbadge]: https://maven-badges.herokuapp.com/maven-central/com.google.dagger/dagger
[mavensearch]: http://search.maven.org/#search%7Cga%7C1%7Cg%3A%22com.google.dagger%22
[project]: http://github.com/google/dagger/
[proposal]: https://github.com/square/dagger/issues/366
[square]: http://github.com/square/dagger/
[squarecommunity]: https://plus.google.com/communities/109244258569782858265
[website]: https://google.github.io/dagger

