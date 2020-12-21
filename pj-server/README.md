MariaDB数据库管理系统是MySQL的一个分支，主要由开源社区在维护，采用GPL授权许可。开发这个分支的原因之一是：甲骨文公司收购了MySQL后，有将MySQL闭源的潜在风险，因此社区采用分支的方式来避开这个风险。MariaDB的目的是完全兼容MySQL，包括API和命令行，使之能轻松成为MySQL的代替品。

安装mariadb，大小59 M。

[root@yl-web yl]# yum install mariadb-server mariadb 
mariadb数据库的相关命令是：

systemctl start mariadb  #启动MariaDB

systemctl stop mariadb  #停止MariaDB

systemctl restart mariadb  #重启MariaDB

systemctl enable mariadb  #设置开机启动

mysql -u root -p

use pj;
source create.sql;

grant all privileges on *.* to 'yroot'@'%' identified by '123';