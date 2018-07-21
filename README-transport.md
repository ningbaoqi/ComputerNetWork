### 进程之间的通信
+ `运输层向它上面的应用层提供通信服务`，两个主机进行通信就是两个主机中的`应用进程互相通信`，`通信的真正端点并不是主机而是主机中的进程`，`网络层是为主机之间提供逻辑通信，而运输层为应用进程之间提供端到端的逻辑通信`，运输层要对收到的报文进行`差错检测`，运输层有两种运输协议：`面向连接的TCP`和`无连接的UDP`，`运输层向高层用户屏蔽了下面网络核心的细节，它使应用进程看到的就是好像在两个运输层实体之间有一条端到端的逻辑通信信道`；
![image](https://github.com/ningbaoqi/ComputerNetWork/blob/master/gif/pic-70.jpg)   pic-70.jpg
### 运输层的两个主要协议
![image](https://github.com/ningbaoqi/ComputerNetWork/blob/master/gif/pic-71.jpg)   pic-71.jpg

|协议|传输协议数据单元|说明|
|------|------|-------|
|用户数据报协议UDP|UDP用户数据报|UDP在传送数据之前不需要先建立连接，远地主机的运输层在收到UDP数据报之后，不需要给出任何确认|
|传输控制协议TCP|TCP报文段|TCP是提供面向连接的服务，在传送数据之前必须先建立连接，数据传送结束后要释放连接，TCP不提供广播或多播服务|

![image](https://github.com/ningbaoqi/ComputerNetWork/blob/master/gif/pic-72.jpg)   pic-72.jpg
