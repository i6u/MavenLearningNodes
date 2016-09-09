### 理解maven生命周期
[Maven生命周期：参考前人的智慧结晶]()
> LifeCycle
> 生命周期，maven内置default,sie,clean三个生命周期
> Phase
> 阶段，每个生命周期有不同的阶段w> Plugin
> 插件，实现实际的构建功能
> Goal
> 目标，一个插件可以实现多个goal，goal具备具体的功能
> Execution
> 通过配置，决定在某个Phase执行哪些Goal
> Project
> maven管理的目标：软件工程，小的工程可以聚合成大工程
> PackageType
> 为了便于管理工程，按照构建目标区分成不同的工程类型，如jar，war，ear等
> Dependency
> 依赖，project之间存在依赖关系
> DependencyScope
> maven对依赖定义了不同的作用范围
> Management
> 可以配置一个工程如何管理依赖关系
> Repository
> 仓库，存放包，分为本地库和远程库
> Build
> 构建的动作。使用maven管理工程，主要是指定将project构建到某个phase



