<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>九九乘法表</title>
</head>

<body>
<table border = "1" cellpadding = "0" cellspacing = "0">
<h1>九九乘法表</h1>
	<?php
		for ($a = 1; $a < 10; $a ++)
		{
			echo "<tr>";
			for ($b = 1; $b <= $a; $b ++)
			{
				echo "<td>";
				echo "$a*$b=",$a*$b;
				echo "</td>";
			}
			echo "</tr>";
		}
	?>
</table>
</body>
</html>