POS
===
在原有基础上加入gradle，对工程结构有较大改变  

加上Guice框架的依赖注入  

值得注意的是Guice获取的List属于  
Collections.unmodifiableCollection  
初始化后不能对其进行更改  
(暂时没有验证其他class是否也不能对其属性进行更改)
