<?php
header("Content-type:text/html;charset=utf-8");
$json = $_POST["data"];
$Objectjson=$json;
$Obj=json_decode($Objectjson);
$temp = $Obj->survey->id;
deldir("./jsondata");
$filename="./jsondata/".$temp.".json";
if (file_exists($filename)) {
unlink($filename);
}
@$data = fopen($filename, 'a+');
fwrite($data, $json);
fclose($data);


function deldir($dir)
{
//先删除目录下的文件：
    $dh = opendir($dir);
    while ($file = readdir($dh)) {
        if ($file != "." && $file != "..") {
            $fullpath = $dir . "/" . $file;
            if (!is_dir($fullpath)) {
                unlink($fullpath);
            } else {
                deldir($fullpath);
            }
        }
    }
    closedir($dh);
}

