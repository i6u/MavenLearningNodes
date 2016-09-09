[官方问题解决说明][1]
在父类中配置
	<pluginManagement>
	  <plugins>
	<plugin>
	 <groupId>org.eclipse.m2e</groupId>
	 <artifactId>lifecycle-mapping</artifactId>
	 <version>1.0.0</version>
	 <configuration>
	   <lifecycleMappingMetadata>
	     <pluginExecutions>
	       <pluginExecution>
	         <pluginExecutionFilter>
			<!--冲突的插件-->
	           <groupId>some-group-id</groupId>
	           <artifactId>some-artifact-id</artifactId>
			<!--[1.0.0,)  [从哪个版本，到哪个版本)-->
	           <versionRange>[1.0.0,)</versionRange>
	           <goals>
			<!--目标-->
	             <goal>some-goal</goal>
	           </goals>
	         </pluginExecutionFilter>
	         <action>
	           <ignore/>
	         </action>
	       </pluginExecution>
	     </pluginExecutions>
	   </lifecycleMappingMetadata>
	 </configuration>
	</plugin>
	  </plugins>
	</pluginManagement>


[1]:	https://www.eclipse.org/m2e/documentation/m2e-execution-not-covered.html