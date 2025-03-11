# JCPUID - Java CPUID

JCPUID is a library for executing CPUID instructions from the JVM. 

## Supported Operating Systems and Architectures
JCPUID currently supports Linux, Windows and MacOS running on Intel and AMD x86 
(32 and 64 bit) processors.

## Download
JCPUID is available on GitHub packages.

Add the package repository to your maven or gradle settings.
You may need to use a Personal Access Token to access the package.
This will be published to maven central once complete.
```
https://maven.pkg.github.com/cafec0c0/jcpuid
```

Use the following coordinates to add JCPUID as a dependency:
```
groupId:     net.adambruce
artifactId:  jcpuid
```

The above dependency depends on native libraries for the supported 
operating systems and processors. If you do not wish to depend on some of these 
libraries, they can be individually excluded by excluding the following 
coordinates:

| Group ID      | Artifact ID                  | Description                   |
|---------------|------------------------------|-------------------------------|
| net.adambruce | jcpuid-native-linux-x86      | Native x86 Linux Library      |
| net.adambruce | jcpuid-native-linux-x86_64   | Native x86_64 Linux Library   |
| net.adambruce | jcpuid-native-windows-x86    | Native x86 Windows Library    |
| net.adambruce | jcpuid-native-windows-x86_64 | Native x86_64 Windows Library |
| net.adambruce | jcpuid-native-macos-x86_64   | Native x86_64 MacOS Library   |

## Building and Installing

### Building with support for a single OS
Requirements:
- Java 8 or above
- Maven
- GCC for Linux or MacOS
- MSVC for Windows

 To compile the Java classes and one of the native libraries (useful for local 
 development), use the following maven command, replacing `<os>` and `<arch>` as
 necessary:

Options for `os`:
- linux
- windows
- macos

Options for `arch`:
- x86
- x86_64

```
mvn clean install -P<os>-<arch>
```

### Building only the Java classes
You can also omit the `native-*` profile entirely, which will not compile
any native code.
```
mvn clean install
```

### Building with support for all operating systems
To compile for all operating systems it is recommended to run the following
command on each required platform. This command will only build the native Jar 
for the specified platform:
```
mvn clean install -f jcpuid-native/jcpuid-native-<os>-<arch> -P<os>-<arch>
```

You can then upload them to a private maven server (or install the jars locally)
allowing them to be resolved by maven to build the Java library:
```
mvn clean install -f jcpuid-lib
```

# Supported CPUID Instructions

| EAX   | Intel | AMD      | 
|-------|-------|----------|
| `0H`  | Yes   | Yes      |

## References
- [Intel 64 and IA-32 Architectures Software Developer's Manual Volume 2 (2A, 2B, 2C, & 2D):
  Instruction Set Reference, A-Z](https://cdrdv2-public.intel.com/843820/325462-sdm-vol-1-2abcd-3abcd-4-1.pdf)
- [AMD64 Architecture Programmer's Manual Volume 3: General-Purpose and
  System Instructions](https://www.amd.com/content/dam/amd/en/documents/processor-tech-docs/programmer-references/24594.pdf)

## License
JCPUID is provided under the Apache-2.0 license. See the LICENSE file for 
details.
