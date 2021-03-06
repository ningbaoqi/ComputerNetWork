### 进程之间的通信
+ `运输层向它上面的应用层提供通信服务`，两个主机进行通信就是两个主机中的`应用进程互相通信`，`通信的真正端点并不是主机而是主机中的进程`，`网络层是为主机之间提供逻辑通信，而运输层为应用进程之间提供端到端的逻辑通信`，运输层要对收到的报文进行`差错检测`，运输层有两种运输协议：`面向连接的TCP`和`无连接的UDP`，`运输层向高层用户屏蔽了下面网络核心的细节，它使应用进程看到的就是好像在两个运输层实体之间有一条端到端的逻辑通信信道`；
![image](https://github.com/ningbaoqi/ComputerNetWork/blob/master/gif/pic-70.jpg) 
### 运输层的两个主要协议
![image](https://github.com/ningbaoqi/ComputerNetWork/blob/master/gif/pic-71.jpg) 

|协议|传输协议数据单元|说明|
|------|------|-------|
|用户数据报协议UDP|UDP用户数据报|UDP在传送数据之前不需要先建立连接，远地主机的运输层在收到UDP数据报之后，不需要给出任何确认|
|传输控制协议TCP|TCP报文段|TCP是提供面向连接的服务，在传送数据之前必须先建立连接，数据传送结束后要释放连接，TCP不提供广播或多播服务|

![image](https://github.com/ningbaoqi/ComputerNetWork/blob/master/gif/pic-72.jpg) 

### 运输层的端口
+ 为了使运行不同操作系统的计算机的`应用进程`能够互相通信，就必须用统一的方法对`TCP/IP`体系的`应用进程进行标志`，解决这个问题的方法就是`在运输层使用协议端口号`，或称为`端口`，这种`在协议桟层间的抽象的协议端口是软件端口`，和路由器或交换机上的硬件端口是完全不同的概念，硬件端口是`不同硬件设备`进行交互的接口，而`软件端口是应用层的各种协议进程与运输实体进行层间交互的一种地址`，当运输层收到`IP`层交上来的运输层报文时，就能够根据其首部中的`目的端口号`把数据交付应用层的`目的应用进程`；`TCP/IP`的运输层用一个`16位端口号`来标志一个端口，`端口号只具有本地意义`，它只是为了标志`本计算机`应用层中的各个进程在和运输层交互时的层间接口，在因特网不同计算机中，相同的`端口号是没有联系的`；

|运输层的端口号分类|说明|
|------|------|
|服务器端使用的端口号|可以分成两类：一、熟知端口号又称为系统端口号，数值为0~1023，把这些端口号指派给了TCP/IP最重要的一些应用程序，让所有的用户都知道；二、登记端口号，数值为1024~49151，这类端口号是为没有熟知端口号的应用程序使用|
|客户端使用的端口号|数值为49152~65535，由于这类端口号仅在客户进程运行时才动态选择，因此又叫做短暂端口号|

![image](https://github.com/ningbaoqi/ComputerNetWork/blob/master/gif/pic-73.jpg) 

### 可靠传输的工作原理
[可靠传输的工作原理](https://github.com/ningbaoqi/ComputerNetWork/blob/master/README-1-technology.md)


### TCP
[TCP](https://github.com/ningbaoqi/ComputerNetWork/blob/master/README-TCP-technology.md)
### UDP
[UDP](https://github.com/ningbaoqi/ComputerNetWork/blob/master/README-UDP-technology.md)
