# PreventRepeatAll
防重复请求工具

使用spring aop实现

prevent-repeat 为工具模块
prevent-repeat-test 为测试模块和扩展例子

使用方式： 
@EnablePreventRepeat启动防重

使用@PreventRepeat对方法防重

默认使用redis实现防重,可扩展, 在prevent-repeat-test中示意了使用mysql的实现
