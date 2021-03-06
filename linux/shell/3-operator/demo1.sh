#!/bin/sh
:<<!
Shell和其他编程语言一样，支持多种运算符，包括：
算数运算符
关系运算符
布尔运算符
字符串运算符
文件测试运算符
原生bash不支持简单的数学运算，但是可以通过其他命令来实现，例如awk和expr，expr最常用
expr是一款表达式计算工具，使用它能完成表达式的求值操作
\`\`和$()符号一样，都是替换符号
例如：两个数相加
注意：运算符之间需要用空格隔开

!
val=`expr 2 + 2`;
echo "两数之和为：${val}";
echo "两数之和为："$(expr 2 + 2);

:<<!
算数运算符：下表列出了常用的算术运算
+ 加法
- 减法
* 乘法
/ 除法
% 取余
= 赋值
== 相等。用于比较两个数字，相同则返回true
!= 不相等：用于比较两个数字，不相同则返回true
注意：条件表达式要放在方括号之间，并且要有空格，例如：[$a==$b]是错误的，必须写成[$a == $b]
乘号(*)前边必须加上反斜杠(\)才能实现乘法运算;
!

#示例如下：
a=10;
b=20;
val=`expr ${a} + ${b}`;
echo "a + b：${val}";

val=`expr ${a} - ${b}`;
echo "a - b：${val}";

val=`expr ${a} \* ${b}`;
echo "a * b：${val}";

val=`expr ${a} / ${b}`;
echo "a / b：${val}";

val=$(expr ${a} % ${b});
echo "a % b：${val}";

if [ ${a} == ${b} ] 
then 
	echo "a 等于 b";
fi
if [ ${a} != ${b} ]
then
	echo "a 不等于 b";
fi