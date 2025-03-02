.PHONY: clean jar

ensure_build_dir=@mkdir -p build

all: build/libjcpuid.so jar

# Create header
build/net_adambruce_LibCPUID.h:
	$(ensure_build_dir)
	$(JAVA_HOME)/bin/javac -cp src/main/java -h build src/main/java/net/adambruce/LibCPUID.java -implicit:none
	$(RM) src/main/java/net/adambruce/LibCPUID.class

build/libjcpuid.so: native/jcpuid.c build/net_adambruce_LibCPUID.h
	$(ensure_build_dir)
	$(CC) -shared -o build/libjcpuid.so native/jcpuid.c -I$(JAVA_HOME)/include -I$(JAVA_HOME)/include/linux -Ibuild

jar:
	mvn clean package
	$(ensure_build_dir)
	cp target/jcpuid-*.jar build

clean:
	$(RM) -r build src/main/java/net/adambruce/LibCPUID.class