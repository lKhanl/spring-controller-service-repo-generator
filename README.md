# Spring Controller-Service-Repository Generator

## Description

- This project uses spring shell.
- This is a simple tool to generate a Spring Controller-Service-Repository project.
- You can use it to generate a project with a controller, service and repository for a given name.
- You can add to path of exacutable file in your .bashrc or .zshrc file to use it from anywhere.

## How to run

```bash
$ ./mvnw -Pnative native:compile -DskipTests=true
```

## Usage

To create a controller : 
```bash
$ ./target/spring-generator c date
```

To create a service : 
```bash
$ ./target/spring-generator s date
```

To create a repository : 
```bash
$ ./target/spring-generator r date
```