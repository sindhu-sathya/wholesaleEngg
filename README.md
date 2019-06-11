# Wholesale Engineering Sample Project (Backend Development)

The sample application being requested by the candidate to build the backend REST APIs
needed to support a web application to that allows a user to view accounts and
subsequently view transactions on any of the accounts they hold.<br />
Required functionality:<br />
View account list<br />
View account transactions <br />

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. 

### Prerequisites

What things you need to install the software and how to install them

```
Java 8,
Apache maven since maven is used to build the libraries and war file,
Any IDE like Eclipse or STS if required.
```

## Folder Structure

After creation, your project should look like this:

```
wholesaleEngg/
README.md
pom.xml
java.gitignore
maven.gitignore
src/
    
```
Here pom.xml is used for build <br />
src is has actual code, properties, testcases

## Available Scripts

In the project directory, you can run:

### `mvn clean install`

This command helps in downloading all maven dependencies which are library files used while coding.<br>

## Source code files
 - IgreenController: controller file which has two methods. Each method has validation for input data, failing which, a custom service exception will be thrown.<br />
 - com.igreen.ex: This package contains Interceptor files for Logging, total response time calculated in RequestInterceptor. It also has basic config files.<br />
 - H2DataSource: DB config file. <br />
 - com.igreen.ex.exception: This package has custom exception files.<br />
 - com.igreen.ex.model: Model files means pojo files are included in this package.<br />
 - com.igreen.ex.repository: This contains two repo files for two tables.<br />
 - IgreenService: This is a service class. This also has basic validations post db data fetch.<br />

## Additional Source comments

- Usually If the project is Big and there are many services involved, It is good to have a Service Interface class and and Service IMPL (implementation class).
- Have a seperate class file for all constants and declare them as public static. Put this in common package so that it is easily understood and also accessible to other class files.
- In this project, I have avoided them because, there only two service methods and no repeated constants.

## Running the tests

For all files, Mockitos are used for code coverage. <br />
However, one class file IgreenRepoIT.java has to be run as @SpringBootTest.

### Break down into end to end tests

 - IgreenRepoIT.java: Repository testcases. <br />
 - IgreenControllerTest: Controller Testcases. <br />
 - IgreenServiceTest: Mock testcases for service file.<br />

## Deployment
### `mvn build` OR
### execute the command `mvn clean install`
You can observe, Building war:/ in target folder

## Versioning

For the versions available, see the [tags on this repository](https://github.com/your/project/tags). 

## Authors

* **Sindhu Nachiraju** - *Initial work* 


## License
Not applicable.<br />
However, we can have LICENSE.md for details related to licensing.

