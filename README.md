POS
===
在原有基础上加入gradle，对工程结构有较大改变

为了加上Guice框架的依赖注入
对 DiscountPromotion 做了一些改动，会与其他如 SecondeHalfPricePromotion，Car等的实现有些不同。

详情见代码：
Shopping.java
DiscountPromotion.java
MyModule.java (新增)
