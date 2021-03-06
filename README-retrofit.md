### retrofit
#### [retrofit原理]()
+ 首先通过method把它转换成ServiceMethod；然后通过serviceMethod，args获取到okhttpCall对象；最后再把okhttpCall进一步封装并返回call对象；
#### [Retrofit的注解分类]()

|HTTP请求方法注解|说明|
|-------|------|
|GET||
|POST||
|PUT||
|DELETE||
|HEAD||
|PATCH||
|OPTIONS||
|HTTP||

|标记类注解|说明|
|-------|------|
|FormUrlEncoded||
|Multipart||
|Streaming|代表响应的数据以流的形式返回，如果不使用它，则默认会把全部数据加载到内存，所以下载大文件时需要加上这个注解|

|参数类注解|说明|
|------|------|
|Header||
|Headers||
|Body||
|Path||
|Field||
|FieldMap||
|Part||
|PartMap||
|Query||
|QueryMap||


#### [retrofit的简单使用](https://github.com/ningbaoqi/ComputerNetWork/commit/98db4219b349ce950b4e6237ee809d35c96771ec)
#### [retrofit--GET请求访问网络](https://github.com/ningbaoqi/ComputerNetWork/commit/a2d843c943eaf868b8800fdc88317b6fdd433269)
#### [retrofit--GET请求访问网络---动态配置URL地址](https://github.com/ningbaoqi/ComputerNetWork/commit/d9f15bf474178b1a6da8461023ca04334e3d214a)
#### [retrofit--GET请求访问网络---动态指定查询条件](https://github.com/ningbaoqi/ComputerNetWork/commit/63e12635a691797df799e804502d380f0175f461)
#### [retrofit--GET请求访问网络---动态指定查询条件](https://github.com/ningbaoqi/ComputerNetWork/commit/cbb48a0b267bcf8a736a213bdc2b1b018e9531a2)
#### [retrofit--POST请求访问网络--传输数据类型为键值对](https://github.com/ningbaoqi/ComputerNetWork/commit/b45883df1a78a0546b0b44d0c6f21b343f144e3f)
#### [retrofit--POST请求访问网络--传输数据类型JSON字符串](https://github.com/ningbaoqi/ComputerNetWork/commit/9523c40ed5c1677512a065a0ff8929ffd0539aa0)
#### [retrofit--POST请求访问网络--单个文件上传](https://github.com/ningbaoqi/ComputerNetWork/commit/5eeba09703bc1c329eb494010b7aeed5ac71c33b)
#### [retrofit--POST请求访问网络--多个文件上传](https://github.com/ningbaoqi/ComputerNetWork/commit/50369d503bfcd9e3644f5f67a2e4e394abbd1749)
#### [retrofit--POST请求访问网络--静态添加单个消息报头](https://github.com/ningbaoqi/ComputerNetWork/commit/0ca833c8b00d741aa9aec3bcd758363dc987f642)
#### [retrofit--POST请求访问网络--静态添加多个消息报头](https://github.com/ningbaoqi/ComputerNetWork/commit/51d51bd0ca3b31d9976788794c8cc2530a0ae672)
#### [retrofit--POST请求访问网络--动态添加多个消息报头](https://github.com/ningbaoqi/ComputerNetWork/commit/4abde9a7281945ab276eb5f783356eb6f2b30d39)
