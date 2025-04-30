# pom

## 项目的基本信息

与项目的基本信息相关的标签有很多，以下算必填项:

- groupId：项目的组名，通常是反转的域名，比如 com.example。
- artifactId：项目的唯一标识符，通常是项目的名称。
- version：项目的版本号。
- packaging：项目的打包方式，通常是 jar、war 或 pom，如果没有指定 packaging，默认值是 jar。

除了上面的几个标签，还有一些项目相关，但非必填的内容：

- name：项目名，可选项，提供项目的简短名称
- description：项目描述，可选项，提供项目的详细描述。
- version：项目主页，可选项，提供项目的网址。
- licenses： 许可证声明，可选项，声明项目所使用的一种或多种许可证
- developers：开发者信息，可选项，列出项目的开发人员。
- url：项目主页，可选项，提供项目的网址

### modules

modules 标签用于声明当前 Maven 项目包含的模块子项目，每个子项目都是一个独立的 Maven 项目，具有自己的 pom.xml 文件，可以进行独立构建和测试。在父项目的 pom.xml 文件中，使用 标签来列出所有子项目的名称，如下所示：

```xml
<project>
  <groupId>com.example.parent</groupId>
  <artifactId>parent-project</artifactId>
  <version>1.0.0</version>
  <packaging>pom</packaging>

  <modules>
    <module>child1</module>
    <module>child2</module>
    <module>child3</module>
  </modules>
</project>
```

### parent

parent 标签用于声明当前 Maven 项目的父项目，它可以将若干个 Maven 项目组织成一个整体，指定版本号，插件版本号等，便于管理和维护，在一个 Maven 项目中，使用标签来引用父项目，如下所示：

```xml
<project>
  <groupId>com.example.child</groupId>
  <artifactId>child-project</artifactId>
  <version>1.0.0</version>
  <packaging>jar</packaging>

  <parent>
    <groupId>com.example.parent</groupId>
    <artifactId>parent-project</artifactId>
    <version>1.0.0</version>
    <relativePath>../parent-project/pom.xml</relativePath>
  </parent>
</project>

```

### scm

scm 又叫 Software Configuration Management,即软件配置管理， 与我们以前提到过的版本控制有关，是 Maven 中用于指定源代码版本控制信息的标签。它可以帮助 Maven 获取源代码并将构建生成的二进制文件提交到版本控制系统中。scm 标签通常用于指定源代码管理系统的类型、URL、开发者连接等详细信息。示例如下：

```xml
<scm>
    <!-- 指定连接到SCM的URL，可以使用HTTP或者SSH协议 -->
    <connection>scm:git:git://github.com/username/repo.git</connection>
    <!-- 指定开发者连接到SCM的URL，通常使用SSH协议 -->
    <developerConnection>scm:git:ssh://github.com/username/repo.git</developerConnection>
    <!-- 指定SCM的web页面URL，方便开发者查看SCM信息 -->
    <url>http://github.com/username/repo/tree/master</url>
    <!-- 当前Maven构件的版本在SCM中对应的标记 -->
    <tag>1.0.0</tag>
</scm>
```

### properties

properties 标签用于定义一些变量，这些变量可以在 pom.xml 文件中通过 ${变量名} 的方式引用，properties 严格来说，并不一定是项目本身的信息，而是人为设置的属性或者说宏，这个标签用来定义和管理项目中所需要的属性，其作用有以下几个：

- 统一管理项目中的常用属性，比如版本号、路径、插件版本等，方便统一修改和管理。
- 可以在配置过程中使用 ${…}占位符引用这些属性，使得配置更加灵活和便捷。
- 避免硬编码，提高代码的可维护性和可读性
  比如说我们可以这么配：

```xml
<properties>
    <project.name>demo-project</project.name>
    <project.version>1.0.0</project.version>
    <jdk.version>1.8</jdk.version>
</properties>
....省略其余部分
<dependency>
    <groupId>com.example.demo</groupId>
    <artifactId>${project.name}-api</artifactId>
    <version>${project.version}</version>
</dependency>

```

## 项目的依赖列表

### dependency

与项目的依赖列表相关的标签最外层由 `dependencies`来囊括，内部包含了各种具体的依赖`dependency`，该标签用于指定一个依赖项，它包含以下几个子标签

- `groupId`：指定依赖项的 groupId，项目的组名
- `artifactId`：指定依赖项的 artifactId，项目的唯一标识符
- `version`：指定依赖项的版本号。
- `scope`：指定依赖项在项目中的使用范围。
  其中的 `scope`一般包含以下几种范围：常用的有 compile、test、provided 和 runtime：

- compile：依赖库默认的 scope，表示该依赖库在编译、测试、运行时均需要使用。
- provided：表示该依赖库只在编译和测试时需要使用，而在运行时已经被系统或者容器提供，所以不需要打包到最终的应用程序中。
- runtime：表示该依赖库只在运行时需要使用，而在编译和测试时则不需要。
- test：表示该依赖库只在测试时需要使用，而在编译和运行时则不需要。

### repository

仓库标签用于定义项目的仓库，包括仓库的 ID、URL、用户名、密码等。

- `id`：指定 Maven 仓库的 ID。
- `name`：指定 Maven 仓库的名称。
- `url`：指定 Maven 仓库的 URL

## 项目的构建配置

### build

build 标签用于定义项目的构建过程，包括插件、资源、过滤器、插件管理、扩展、默认值等。

```xml
<project>
  .... 省略其他部分
  <build>
    <sourceDirectory>src/main/java</sourceDirectory>
    <resources>
      <resource>
        <directory>src/main/resources</directory>
      </resource>
    </resources>
    <plugins>
      <plugin>
        <groupId>org.apache.maven.plugins</groupId>
        <artifactId>maven-compiler-plugin</artifactId>
        <version>3.8.1</version>
        <configuration>
          <source>1.8</source>
          <target>1.8</target>
        </configuration>
      </plugin>
    </plugins>
  </build>
</project>

```

需要注意的是，像资源目录这种路径是没有默认值的，但根据 Maven 的约定优于配置原则（Convention over Configuration），Maven 会使用默认的目录结构去查找源代码和测试代码。默认的目录结构如下:

```xml
|--src
   |--main
      |--java  // Java主源代码目录
      |--resources // 资源文件目录
   |--test
      |--java // 测试主代码目录
      |--resources // 测试资源文件目录
```

### plugins

plugins 标签用于定义项目的构建插件，包括插件的组 ID、ID、版本号、配置参数等。
plugins 的作用是定义 Maven 插件， plugins 主要用于扩展 Maven 的功能，帮助开发人员更方便地构建、打包、发布项目。插件可以通过 Maven 的插件中心或者自己构建的私有仓库来使用，能在构建过程中执行特定的任务，比如编译、打包、测试等。

插件的配置可以分为两种方式：全局配置和项目配置。全局配置是在 Maven 安装目录下的 conf/settings.xml 文件中进行配置，可以被所有的项目使用。项目配置则是在项目的 pom.xml 文件中进行配置，只对当前项目生效。

插件的使用主要分为以下几个步骤：

在 pom.xml 中声明插件依赖
配置插件的参数
运行插件命令
而常用的 Maven Plugin 有不少，我们一一来说一下：

#### maven-compiler-plugin

比方说，最常用的编译功能，我们可以在 pom 里面这么写

```xml
<build>
  <plugins>
    <plugin>
      <groupId>org.apache.maven.plugins</groupId>
      <artifactId>maven-compiler-plugin</artifactId>
      <version>3.8.1</version>
      <configuration>
        <source>1.8</source>
        <target>1.8</target>
        <encoding>UTF-8</encoding>
        <showWarnings>true</showWarnings>
        <compilerArgs>
          <arg>-Xlint:unchecked</arg>
          <arg>-Xlint:deprecation</arg>
        </compilerArgs>
      </configuration>
    </plugin>
  </plugins>
</build>

```

各子标签的作用如下：

- `source`：指定 Java 源代码的版本，例如 1.8 表示 Java 8。
- `target`：指定编译后的字节码版本，例如 1.8 表示 Java 8。
- `encoding`：指定源代码的编码格式。
- `showWarnings`：是否显示编译警告信息，true 表示显示，false 表示不显示。
- `compilerArgs`：可选参数，可以添加多个编译器参数，例如-Xlint 选项用来启用编译器警告检查。

#### maven-surefire-plugin

maven-surefire-plugin 插件是 Maven 中的一个测试框架，用于执行 Java 单元测试和集成测试。它的主要作用是在构建过程中运行测试，并生成测试报告，在 pom.xml 中的配置如下：

```xml
<build>
    <plugins>
        <plugin>
            <groupId>org.apache.maven.plugins</groupId>
            <artifactId>maven-surefire-plugin</artifactId>
            <version>3.0.0-M4</version>
            <configuration>
                <skipTests>true</skipTests>
                <forkCount>2</forkCount>
                <useSystemClassLoader>false</useSystemClassLoader>
                <reuseForks>true</reuseForks>
                <includes>
                    <include>**/*Test.java</include>
                    <include>**/*Tests.java</include>
                </includes>
                <systemProperties>
                    <property>
                        <name>testProp1</name>
                        <value>value1</value>
                    </property>
                    <property>
                        <name>testProp2</name>
                        <value>value2</value>
                    </property>
                </systemProperties>
            </configuration>
        </plugin>
    </plugins>
</build>

```

#### maven-jar-plugin

maven-jar-plugin 用于将项目打包为 JAR 文件，在这个例子中，我们告诉 Maven 将 com.example.MyApp 作为 JAR 文件的主类，那么在 pom.xml 中的配置如下：

#### maven-install-plugin

当执行 mvn instal 命令时，maven-install-plugin 用于将一个特定的文件安装到本地 Maven 仓库中，以便其他项目可以使用它，例如在 pom.xml 中的配置如下：

#### maven-clean-plugin

maven-clean-plugin 用于清理 Maven 项目中的目标文件和构建临时文件，以便重新构建项目。它通常被用于在构建之前清理项目，以确保在构建时使用最新的代码和资源 ar 文件，在 pom.xml 中的配置如下：

#### maven-release-plugin

maven-release-plugin 可以帮助我们在代码库中创建一个稳定的发布版本，并将其发布到 Maven 仓库中，同时更新开发版本号，以便于下次开发版本的迭代，它可以做如下配置

### profiles

profiles 标签用于定义构建配置的配置文件，可以包含多个 profile，每个 profile 可以定义自己的构建配置，比如编译、测试、打包等。

```xml
<profiles>
  <profile>
    <id>prod</id>
    <activation>
      <activeByDefault>true</activeByDefault>
    </activation>
    <build>
      <plugins>
        <plugin>
          <groupId>org.apache.maven.plugins</groupId>
          <artifactId>maven-compiler-plugin</artifactId>
          <version>3.8.1</version>
          <configuration>
            <release>11</release>
          </configuration>
        </plugin>
      </plugins>
    </build>
  </profile>
</profiles>

```

- `id` 标签指定 profile 的唯一标识符。
- `activation` 标签指定何时使用该 profile。在示例中，activeByDefault 设置为 true 表示默认启用该 profile。0
- `build` 标签包含一组构建配置，这些配置将在激活 profile 时覆盖默认配置。在示例中，它定义了 maven-compiler-plugin 插件的版本和为 Java 11 设置编译器版本。
  在 Maven 中，使用以下命令激活特定的 profile：

```powershell
mvn clean install -Pprod
```

这将激活 prod profile，覆盖默认构建配置。
