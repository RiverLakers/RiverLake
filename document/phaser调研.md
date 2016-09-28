Phaser是一款2d免费的html5游戏开发框架，容易上手，文档详细，http://phaser.io/

要想运行Phaser开发的游戏，首先需要配置web服务器，这里我们选用apache24作为本地web服务器，
为了获取其windows binary版本，有ApacheHaus、Apache Lounge、BitNami WAMP Stack、WampServer、XAMPP
五种选择，考虑到使用场景，不需要php和mysql的支持，选择ApacheHaus
http://www.apachehaus.com/cgi-bin/download.plx

将压缩包解压至d盘根目录，以管理员方式运行bin/httpd -k install即完成了服务器服务的注册，
在本地使用Apache配置WEB服务器见http://blog.csdn.net/a351945755/article/details/50790327
将hellophaser文件夹拷贝至htdocs目录下即可在浏览器访问该应用

总的来说，Phaser是一个不错的选择

