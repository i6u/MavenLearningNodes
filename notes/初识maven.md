#### 一步一步了解maven
* maven目录结构
* maven项目坐标
* maven仓库
* 初识maven命令
##### maven目录结构
	src 
	src/main
	src/main/java
	src/main/resource
	src/test
	target
	target/classes
	target/surefire-reports    测试报告
##### maven项目坐标
	<groupId>com.xxx.xxx</groupId> 机构（部门）名称
	<artifactId>maven-learning-01</artifactId> 项目模块名
	<version>1.0-SNAPSHOT</version> 版本
##### maven仓库
本地仓库 .m2
中央仓库
##### 初识maven命令
> * 编译compile
> * 测试test（编译，测试）
> * 安装install(将项目发布到本地仓库；编译，测试，打包，发布)
> * 打包package（编译，测试，打包）
> * 清除测试clean（清除target目录）
> * 构建项目archetype:generate(骨架生成器，用来快速生成maven模板项目)
> * archetype:generate 常常利用参数直接设置项目配置信息，例如：
	archetype:generate -DgourpId=xxx -Dartifactld=xxx -Dversion=1.0.0-SNAPSHOT
* 如果使用archetype:generate 默认的模板很多，而常用的模板也就那么几种
	1. simple start 
	2. web app
* 可以是用以下方法，构建时只显示我们本地的模板
	1.使用mvn archetype:crawl 命令，它会在 C:\Users\buha\.m2\repository目录下生成一个archetype-catalog.xml文件（查看这个文件就会发现，里面记录的是我们构建使用过的模板）
	2.将archetype-catalog.xml移到上一层目录，也就是C:\Users\buha\.m2
	3.这时再运行mvn archetype:generate -DarchetypeCatalog=local 就可以达到你想要的目的了。