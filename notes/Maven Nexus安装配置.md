# 使用nexus创建maven私有仓库
* nexus安装配置
* maven setting.xml配置
### nexus安装配置
*安装，配置*
\*服务器：Linux 7.x
\*nexus版本：3.x .tar.gz（注意：3.x版本，JDK使用1.8以上版本）
	1.下载nexus [nexus下载链接]
	2.拷贝到服务器，解压缩 tar -zxvf nexus -C /opt/nexus/xxx
	3.启动nexus-xxx/bin/nexus start启动（注意：不能使用root用户启动）
	 3.1 Linux创建用户：useradd：用户名；passwd：用户名；然后输入用户密码，使   用创建的用户登录，启动nexus
	 3.2 开放8081端口：firewall-cmd --zone=public --add-port=8081/tcp --  permanent；重启防火墙：firewall-cmd --reload
	4.访问Linux服务器8081端口，nexus默认的管理员admin密码admin123 
### 测试
	需要先了解下nexus下的基本配置，其中url就是从nexus中默认的仓库地址
	<!--在Maven项目的POM文件中配置私服-->
	<repositories>
	    <repository>
	        <id>nexus</id>
	        <name>Nexus Repository</name>
	        <url>http://10.211.55.22:8081/repository/maven-public/</url>
	    </repository>
	</repositories>
### 在Maven中配置setting.xml文件实现全局定义私有仓库
*** 第一种方式，本机默认先在私有库中找，找不到再通过本机去中央仓库找***
	<settings>
	'' <!--先配置profiles-->
	<profiles>
	    <profile>
	        <id>nexusProfile</id>
	        <repositories>
	            <repository>
	                <id>nexus</id>
	                <name>nexus Repository</name>
	                <url>http://10.211.55.22:8081/repository/maven-public/</url>
	                <releases>
	                    <!--默认为true-->
	                    <enabled>true</enabled>
	                </releases>
	                <snapshots>
	                    <!--默认为false-->
	                    <enabled>true</enabled>
	                </snapshots>
	            </repository>
	        </repositories>
	    </profile>
	</profiles>
	  <!--再激活profiles-->
	  <activeProfiles>
	      <activeProfile>nexusProfile</activeProfile>
	  </activeProfiles>
	</settings>
*** 第二种，本机只在私有库中找，找不到将不再通过本机去中央仓库找，其实就是允许私有库访问中央仓库！（通过配置镜像实现）***
	<mirrors>
	 <!--通过配置工厂镜像来确定哪些工厂只能访问指定URL
	  | 在<mirrorOf>nexus,central</mirrorOf>中可以配置哪些工厂被镜像所接管
	  | 在<mirrorOf>*</mirrorOf>中使用‘*’来表示所有的工厂都只能访问此镜像指定的URL
	  | 
	  |-->
	 <mirror>
	  <id>nexusMirror</id>
	  <mirrorOf>*</mirrorOf>
	  <name>Human Readable Name for this Mirror.</name>
	  <url>http://10.211.55.22:8081/repository/maven-public/</url>
	</mirror>
	  </mirrors>
*补充：默认的central工厂中的snapshotPolicy属性为false，可以通过以下覆盖的方式设置snapshotPolicy为true（测试中是和设置镜像一起测试的）*
	<settings>
	 <profile>
	<id>centralProfile</id>
	<repositories>
	<repository>
	<id>central</id>
	<name>Central Repository</name>
	<url>http://repo.maven.apache.org/meven2</url>
	<layout>default</layout>
	<snapshotPolicy>
	<!--可以通过在此设置central来覆盖中央工厂，来设置中央工厂中的snapshotPolicy的属性为true-->
	<enabled>true</enabled>
	</snapshotPolicy>
	</repository>
	</repositories>
	  </profile>
	  </profiles>
	<!--再激活profiles-->
	<activeProfiles>
	<activeProfile>centralProfile</activeProfile>
	</activeProfiles>
	</settings>