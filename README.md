# Stanford: 106a


## Links
* [Course](http://see.stanford.edu/see/courseinfo.aspx?coll=824a47e1-135f-4508-a5aa-866adcae1111)
* [Lecture Videos](http://see.stanford.edu/see/lecturelist.aspx?coll=824a47e1-135f-4508-a5aa-866adcae1111)
* [All Materials in a zip file (282 MB)](http://see.stanford.edu/materials/icspmcs106a/ProgrammingMethodologyAllMaterials.zip)

## Setup (Maven)
Installing the karel.jar to maven:
```bash
mvn install:install-file \
  -Dfile=karel.jar \
  -DgroupId=com.stanford.106a \
  -DartifactId=karel \
  -Dversion=1.0.0 \
  -Dpackaging=jar
```

## Running Assignments
```bash
mvn exec:java -pl assignment_1/assignment1
```
or
```bash
cd assignment_1/assignment1
mvn exec:java
```


## Assignments
* [Assignment 1](assignment_1/README.md)
