# 依赖范围
***要理解Maven的依赖范围，首先得清楚Maven项目中存在哪些依赖情况（也就是jar包什么时候会被用到），Maven中存在以下三种状态***
* 编译时
* 运行时
* 测试时
***依赖范围指的就是，上述三种运行环境中，依赖包的作用域***
### 指定依赖范围的属性：scope
> * compile：默认使用该项，对三种classpath都有效
> * test：仅对测试classpath有效，如Junit
> * provided：对编译和测试classpath有效，比如开头贴出的servlet-api的依赖，会在运行时由app server提供，Maven不可以重复引入
> * runtime：对测试和运行classpath有效，编译时无效
> * system：对编译和测试classpath有效，但必须通过systemPath显示指定依赖文件的位置，可以使用系统环境变量
> * import：不针对任何一种classpath，该项用于导入其他pom中的dependencyManagement元素
### 依赖传递
**先有个概念**
* 直接依赖
* 间接依赖
* 依赖顺序（在POM文件中配置的顺序）
* 依赖层级数（直接依赖的依赖层级数为0，以此类推）
**同级依赖**
	依赖由依赖顺序决定，同级依赖中，谁在前依赖谁
**不同级依赖**
	谁的依赖层级数越低，就依赖谁
### 依赖排除
		<exclusions>
		<exclusion>
			<groupId>log4j</groupId>
	                 <artifactId>log4j</artifactId>
	         </exclusion>
	</exclusions>
*注意：排除依赖是不需要指定版本号的，因为在Maven中一个包里不会出现groupId，artifactId相同，版本不同的两个依赖包*




