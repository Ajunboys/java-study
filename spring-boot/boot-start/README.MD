# SpringBoot手脚架（含读取配置信息）

## 构建项目
访问 https://start.spring.io/ 初始手脚搭建

### pom.xml
```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
	<modelVersion>4.0.0</modelVersion>
	<parent>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-parent</artifactId>
		<version>2.6.2</version>
		<relativePath/> <!-- lookup parent from repository -->
	</parent>
	<groupId>com.codedok.boot</groupId>
	<artifactId>boot-start</artifactId>
	<version>0.0.1-SNAPSHOT</version>
	<name>boot-start</name>
	<description>Demo project for Spring Boot</description>
	<properties>
		<developer>jason(weijunqiang2010@foxmail.com)</developer>
	    <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
		<project.reporting.outputEncoding>UTF-8</project.reporting.outputEncoding>
		<java.version>11</java.version>
	</properties>
	<dependencies>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-validation</artifactId>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-web</artifactId>
		</dependency>

		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-devtools</artifactId>
			<scope>runtime</scope>
			<optional>true</optional>
		</dependency>
		<!--
		在 META-INF/additional-spring-configuration-metadata.json 中配置
		可以去除 application.yml 中自定义配置的红线警告，并且为自定义配置添加 hint 提醒
		 -->
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-configuration-processor</artifactId>
			<optional>true</optional>
		</dependency>

		<dependency>
			<groupId>org.projectlombok</groupId>
			<artifactId>lombok</artifactId>
			<optional>true</optional>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-test</artifactId>
			<scope>test</scope>
		</dependency>
		<dependency>
			<groupId>org.springframework.restdocs</groupId>
			<artifactId>spring-restdocs-mockmvc</artifactId>
			<scope>test</scope>
		</dependency>
	</dependencies>

	<build>
		<plugins>
			<plugin>
				<groupId>org.asciidoctor</groupId>
				<artifactId>asciidoctor-maven-plugin</artifactId>
				<version>1.5.8</version>
				<executions>
					<execution>
						<id>generate-docs</id>
						<phase>prepare-package</phase>
						<goals>
							<goal>process-asciidoc</goal>
						</goals>
						<configuration>
							<backend>html</backend>
							<doctype>book</doctype>
						</configuration>
					</execution>
				</executions>
				<dependencies>
					<dependency>
						<groupId>org.springframework.restdocs</groupId>
						<artifactId>spring-restdocs-asciidoctor</artifactId>
						<version>${spring-restdocs.version}</version>
					</dependency>
				</dependencies>
			</plugin>
			<plugin>
				<groupId>org.springframework.boot</groupId>
				<artifactId>spring-boot-maven-plugin</artifactId>
				<configuration>
					<excludes>
						<exclude>
							<groupId>org.projectlombok</groupId>
							<artifactId>lombok</artifactId>
						</exclude>
					</excludes>
				</configuration>
			</plugin>
		</plugins>
	</build>

</project>

```

### application.yml
```sh
# web server config
server:
  port: 8181
  servlet:
    context-path: /web
```
打开浏览器访问 http://localhost:8181/web


## 加入 actuator 检查项目运行情况

### pom.xml
```xml
        <dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-actuator</artifactId>
		</dependency>

		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-security</artifactId>
		</dependency>
		
		<dependency>
			<groupId>org.springframework.security</groupId>
			<artifactId>spring-security-test</artifactId>
			<scope>test</scope>
		</dependency>
				
```
### application.yml
```sh
# Logging
logging:
  file: app.log

# web server config
server:
  port: 8181
  servlet:
    context-path: /web
    
# spring config    
spring:
  profiles:
    active:
    - prod
  # Spring Security default user name and password 
  security:
    user:
      name: admin
      password: 123456!
      roles:
      - ACTUATOR_ADMIN
# INFO ENDPOINT CONFIGURATION
info: 
  app: 
    name: n @project.name@
    description: d @project.description@
    version: v @project.version@
    encoding: e @project.build.sourceEncoding@
    java: 
      version: v @java.version@
      
management:
  # 端点信息接口使用的端口，为了和主系统接口使用的端口进行分离
  # 访问地址：http://localhost:8090/actuator/health
  server:
    port: 8090
  # 端点健康情况，默认值"never"，设置为"always"可以显示硬盘使用情况和线程情况
  endpoint:
    health:
      show-details: always
    shutdown: 
      enabled: true
  # 设置端点暴露的哪些内容，默认["health","info"]，设置"*"代表暴露所有可访问的端点
  endpoints:
    web:
      exposure:
        include: '*'
```
访问地址：
> http://localhost:8090/actuator/ http://localhost:8090/actuator/health http://localhost:8090/actuator/beans
