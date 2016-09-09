[Sonatype nexus官方文档][1]
**步骤**
	1. 创建存储库（release库，snapshot库）
	2. 设置存储库权限
	3. 为用户分配权限
### 为不同项目配置不同的存储库
*1. 创建存储库*
	nexus repository type
	*  proxy—>代理
	*  hosted—>托管
	*  group—>机构
> 创建托管存储库
> - 设置存唯一的存储库名字：name
> - 设置版本政策：version policy；
> - 设置存储库允许部署：alow redeploy
*2. 配置权限*
默认存储库只有预览（view）权限
在privleges里配置版本库权限，创建特权privleges，有五种类型的特权，具体参阅官方文档
* 为存储库repository创建特权privleges
	format选项：maven2
	repository：选择要创建权限的存储库
	actions选项：add, browse, create, delete, edit, read and \* (all) 
* 创建role
	把创建好的repository-\>privleges分配给role
* 创建User
	为用户分配角色role
# 总结：关于为不同项目配置存储库的一些问题
总的步骤
1. 创建存储库
2. 私有库类型的区别，一般使用maven2-hosted
3. 选择私有库部署策略deployment policy为allow redeploy（待深究）
2. 设置存储库权限
5. 存储库5种权限的区别
6. 存储库权限中选项的含义，可以参考系统已经存在的权限
3. 创建角色，为角色分配存储库权限
4. 为用户分配角色权限
5. 在本地maven的setting.xml文件中配置用户信息
6. 在本地maven项目的pom文件中配置私有库的信息

[1]:	https://books.sonatype.com/nexus-book/3.0/reference/docker.html