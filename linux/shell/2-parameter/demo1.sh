#!/bin/sh
:<<!
Shell传递参数
我们可以在执行shell脚本时，向脚本传递参数，脚本内获取参数的格式为：$n：n代表一个数字
1为执行脚本的第一个参数，2为执行脚本的第二个参数，以此类推
!
#执行命令：sh parameter.sh 0 1 2
#打印结果如下：
#	执行的文件名：parameter.sh
#	第一个参数为：0
#	第二个参数为：1
#	第三个参数为：2
echo "Shell 传递参数示例!";
echo "执行的文件名：$0";
echo "第一个参数为：$1";
echo "第二个参数为：$2";
echo "第三个参数为：$3";

:<<!
处理参数的特殊字符：
$# 传递到脚本的参数个数
$* 以一个单字符串显示所有向脚本传递的参数：如"$*"用["]括起来的情况、以"$1 $2 ... $n"的形式输出所有的参数
$$ 脚本运行的当前进行ID号
$! 后台运行的最后一个进程ID号
$@ 与$*相同，但是使用时加引号，并在引号中返回每个参数。如"$@"用["]括起来的情况、以"$1" "$2" ... "$n"的形式输出所有的参数
$- 显示Shell使用的当前选项，与set命令功能相同
$? 显示最后命令退出状态，0表示没有错误，其他任何值表示有错误
!

echo "Shell 传递参数示例！";
echo "第一个参数为：$1";
echo "参数个数为：$#";
echo "传递的参数作为一个字符串显示：\"$*\"";

:<<!
$*与$@的区别：
相同点：都是引用所有的参数。
不同点：只有在双引号的时候体现出来。假设在脚本运行的时候写了三个参数1、2、3，
则"*"等价于"1 2 3"（传递了一个参数），
而"@"等价于"1" "2" "3"（传递了三个参数）
示例如下：
!
echo "-- \$* 演示 --"
for i in "$*";
do
	echo ${i};
done;

echo "-- \$@ 演示 --"
for i in "$@";
do 
	echo ${i};
done;

:<<!
在为shell脚本传递参数中如果包含空格，应该使用单引号或者双引号将该参数括起来，以便脚本将这个参数作为整体来接收
注意：中括号[]与其中间的代码应该有空格隔开
!
if [ -n "$1" ]; then
	echo "包含第一个参数！";
else
	echo "没有包含第一个参数！";
fi
	