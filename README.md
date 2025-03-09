# JCPUID - Java CPUID

JCPUID is a library for executing CPUID instructions from the JVM. 

## Supported Operating Systems and Architectures
JCPUID currently supports Linux, Windows and MacOS running on x64 processors 
that support the CPUID instruction.

## Download
JCPUID is available on GitHub packages.

Add the package repository to your maven or gradle settings:
```
https://maven.pkg.github.com/cafec0c0/jcpuid
```

And then use the following coordinates to add JCPUID as a dependency:
```
groupId:     net.adambruce
artifactId:  jcpuid
```

The above dependency depends on native libraries for the supported 
operating systems. If you do not wish to depend on some of these libraries, 
they can be individually excluded by excluding the following coordinates:
```
groupId:     net.adambruce
artifactId:  jcpuid-native-linux
```
```
groupId:     net.adambruce
artifactId:  jcpuid-native-windows
```
```
groupId:     net.adambruce
artifactId:  jcpuid-native-macos
```


## Building and Installing

### Building with support for a single OS
If you wish to build JCPUID yourself, you will need maven and a working GCC 
compiler. To compile the Java classes and one of the native libraries, use the 
following maven command, replacing `{os}` with one of the following: 
`linux`, `windows`, `macos`. e.g. `native-linux`.
```
mvn clean install -Pnative-{os}
```

### Building only the Java classes
You can also omit the `native-*` profile entirely, which will only build the 
Java library.
```
mvn clean install -Pnative-{os}
```

### Building with support for all operating systems
To compile for all operating systems it is recommended to run the following
command on each operating system which will only build the native Jar:
```
mvn clean install -f jcpuid-native/jcpuid-native-{os} -Pnative-{os}
```

You can then upload them to a private maven server (or install the jars locally)
allowing them to be resolved by maven to build the Java library:
```
mvn clean install -f jcpuid-lib
```

## License
JCPUID is provided under the Apache-2.0 license. See the LICENSE file for 
details.
