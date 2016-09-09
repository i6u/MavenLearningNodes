### 聚合
	<!--聚合:统一管理子模块-->
	<modules>
	    <module>../user-core</module>
	    <module>../user-log</module>
	    <module>../user-service</module>
	    ......
	</modules>

### 继承
`继承顾名思义就是让子类拥有父类的元素，实现配置的重用！`
在Maven中使用继承
* 子POM继承父POM，
* 直接继承，间接继承，继承层级数
* 继承层级数越小的包被引用
*Maven可继承的POM元素*
> groupId ：项目组 ID ，项目坐标的核心元素；
> version ：项目版本，项目坐标的核心元素；
> description ：项目的描述信息；
> organization ：项目的组织信息；
> inceptionYear ：项目的创始年份；
> url ：项目的 url 地址
> develoers ：项目的开发者信息；
> contributors ：项目的贡献者信息；
> distributionManagerment ：项目的部署信息；
> issueManagement ：缺陷跟踪系统信息；
> ciManagement ：项目的持续继承信息；
> scm ：项目的版本控制信息；
> mailingListserv ：项目的邮件列表信息；
> properties ：自定义的 Maven 属性；
> dependencies ：项目的依赖配置；
> dependencyManagement ：醒目的依赖管理配置；
> repositories ：项目的仓库配置；
> build ：包括项目的源码目录配置、输出目录配置、插件配置、插件管理配置等；
> reporting ：包括项目的报告输出目录配置、报告插件配置等。
