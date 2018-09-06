All the unix-commands below assume your at the root of the submission folder.
It should contain folder krd180000 with two .java files in it. namely BoundedQueue.java and TestMain.java

Program is tested to work with Java SDK version is 1.8.
To compile:
javac krd180000/*.java

To run the test cases: (the -ea jvm-option is very important here as the tests use assert for checks)
java -ea krd180000.TestMain