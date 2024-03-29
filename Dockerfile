FROM openjdk:8-jre-slim

# Add the jar with all the dependencies
# Maven creates container-test.jar in the target folder of my workspace.
# We need this in some location - say - /usr/share/tag folder of the container
ADD  target/container-test.jar /usr/share/tag/container-test.jar

ADD search-module.xml /usr/share/tag/search-module.xml

# Command line to execute the test
ENTRYPOINT ["/usr/bin/java", "-cp", "/usr/share/tag/container-test.jar", "org.testng.TestNG", "-testclass", "com.testautomation.container.test.GoogleTest"]