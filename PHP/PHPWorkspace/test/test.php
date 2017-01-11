<?php
#	$boo = true;
#	if($boo == true)
	#		echo '变量$boo 为真!';
#	else
	#		echo '变量$boo 为假!';

#	$i = '只会看到一遍';		//声明一个字符串变量
#	echo "$i";				//用双引号输出
#	echo "<p>";				//输出段标记
#	echo '$i';				//用单引号输出

echo "变量(\$string1)直接赋值为 null; ";
$string1 = null;
$string3 = "str";
if (is_null($string1))
	echo "string1 = null";
	echo "<p>变量(\$string2)未被赋值; ";
	if (is_null($string2))
		echo "string2 = null";
		echo "<p>被unset()函数处理过的变量(\$string3): ";
		unset($string3);
		if (is_null($string3))
			echo "string3 = null";
?>
