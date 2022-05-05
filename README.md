* 传染病数据库管理系统
* 前端采用Vue、Element UI。
* 后端采用Spring Boot、Spring Security、Redis & Jwt。
* 权限认证使用Jwt，支持多终端认证系统。
* 支持加载动态权限菜单，多方式轻松权限控制。
* 高效率开发，使用代码生成器可以一键生成前后端代码。

1. 解压压缩文件运行程序需要的环境版本要求
```
JDK >= 1.8 (推荐1.8版本)
Mysql >= 5.7.0 (推荐5.7版本)
Redis >= 3.0
Maven >= 3.0
Node >= 12
```
2. 选择适合的编辑器/IDE导入项目
3. 创建数据库导入sql文件夹下数据库文件。其中包含有测试样例的数据库也有单纯的数据库结构的sql文件
4. 修改Epidemic\Epidemic-admin\src\main\resources 下的application-druid.yml中的数据库接口，用户账号名称
5. 在Epidemic\Epidemic-ui 中使用npm install安装前端所需的文件，不是很建议使用cnpm可能会出现奇怪的问题。