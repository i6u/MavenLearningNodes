### 配置maven插件surefire
**选择/排除测试的范围**
[ maven-surefire-plugin简介][1]
##### 默认测试范围
`By default, the Surefire Plugin will automatically include all test classes with the following wildcard patterns:`
`• "**/Test*.java" - includes all of its subdirectories and all Java filenames that start with "Test".`
`• "**/*Test.java" - includes all of its subdirectories and all Java filenames that end with "Test".`
`• "**/*TestCase.java" - includes all of its subdirectories and all Java filenames that end with "TestCase".`
##### 配置自定义的测试范围
*配置后，默认的测试范围就失效了*
	<plugin>
	    <groupId>org.apache.maven.plugins</groupId>
	    <artifactId>maven-surefire-plugin</artifactId>
	    <version>2.19.1</version>
	    <configuration>
	        <includes>
	            <include>**/Hello*</include>
	        </includes>
	        <!--<excludes>-->
	            <!--<exclude>test**</exclude>-->
	        <!--</excludes>-->
	    </configuration>
	</plugin>

* 跳过编译测试 在编译插件中配置skip为true
**动态配置**
动态跳过所有测试  xxx -DskipTests=true
动态只测试某个  xxx -Dtest=xxx.java (注意在需要测试的项目下执行)
### 测试类覆盖率：cobertura
cobertura:cobertura

[1]:	http://blog.csdn.net/troy__/article/details/39233529