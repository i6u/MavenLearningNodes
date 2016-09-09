### 拷贝文件插件
copy-maven-plugin
	1.	<plugin>
	2.	        <artifactId>maven-resources-plugin</artifactId>
	3.	        <version>3.0.1</version>
	4.	        <executions>
	5.	          <execution>
	6.	            <id>copy-resources</id>
	7.	            <!-- here the phase you need -->
	8.	            <phase>validate</phase>
	9.	            <goals>
	10.	              <goal>copy-resources</goal>
	11.	            </goals>
	12.	            <configuration>
	13.	              <outputDirectory>${basedir}/target/extra-resources</outputDirectory>
	14.	              <resources>          
	15.	                <resource>
	16.	                  <directory>src/non-packaged-resources</directory>
	17.	                  <filtering>true</filtering>
	18.	                </resource>
	19.	              </resources>              
	20.	            </configuration>            
	21.	          </execution>
	22.	        </executions>
	23.   </plugin>

### 使用jetty发布项目
[maven-jetty文档][1]
	<!--jetty-->
	<plugin>
	    <groupId>org.eclipse.jetty</groupId>
	    <artifactId>jetty-maven-plugin</artifactId>
	    <version>9.3.11.v20160721</version>

	    <configuration>
	        <stopKey>shutdown</stopKey>
	        <stopPort>7878</stopPort>
	        <scanIntervalSeconds>3</scanIntervalSeconds>
	        <!--<reload>manual</reload>-->
	        <dumpOnStart>true</dumpOnStart>
	        <webApp>
	            <contextPath>/${project.artifactId}</contextPath>
	            <!--
	            <resourceBases>
	                <resourceBase>${project.basedir}/src/main/webapp</resourceBase>
	                <resourceBase>${project.basedir}/commons</resourceBase>
	            </resourceBases>
	            -->
	        </webApp>
	        <httpConnector>
	            <port>8787</port>
	            <idleTimeout>60000</idleTimeout>
	        </httpConnector>
	        <requestLog implementation="org.eclipse.jetty.server.NCSARequestLog">
	            <filename>target/access-yyyy_mm_dd.log</filename>
	            <filenameDateFormat>yyyy_MM_dd</filenameDateFormat>
	            <logDateFormat>yyyy-MM-dd HH:mm:ss</logDateFormat>
	            <logTimeZone>GMT+8:00</logTimeZone>
	            <append>true</append>
	            <logServer>true</logServer>
	            <retainDays>120</retainDays>
	            <logCookies>true</logCookies>
	        </requestLog>
	    </configuration>
	</plugin>

[1]:	http://www.eclipse.org/jetty/documentation/current/jetty-maven-plugin.html#running-and-deploying