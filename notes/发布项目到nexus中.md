* 配置nexus中的用户，并授权，是用户拥有发布项目到私有库的权限
* 配置本地账户信息
***在项目POM中配置私有库信息***
	<distributionManagement>
	    <repository>
	        <id>user-releases</id>
	        <name>user release test</name>
	        <url>http://10.211.55.22:8081/repository/maven-releases/</url>
	    </repository>
	    <snapshotRepository>
	        <id>user-snapshots</id>
	        <name>user snapshot test</name>
	        <url>http://10.211.55.22:8081/repository/maven-snapshots/</url>
	    </snapshotRepository>
	</distributionManagement>
***在maven setting.xml中配置用户信息***
	<server>
	    <id>user-releases</id>
	    <username>ces-developer</username>
	    <password>123456</password>
	</server>
	<server>
	    <id>user-snapshots</id>
	    <username>ces-developer</username>
	    <password>123456</password>
	</server>
