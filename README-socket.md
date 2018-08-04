### Socket基础
+ `Socket`是应用层与`TCP/IP`协议族通信的中间软件抽象层，它是一组接口，`Socket`用于描述`IP地址`和`端口`，是一个通信链路的句柄，应用程序通常通过套接字向网络发出请求或应答网络请求；`Socket`的基本操作包括：`连接远程机器`、`发送数据`、`接收数据`、`关闭连接`、`绑定端口`、`监听到达数据`、`在绑定的端口上接受来自远程机器的连接`；

#### 客户端 Socket

|Socket的重要方法|说明|
|------|------|
|`Socket()`|创建一个新的未连接的Socket|
|`Socket(Proxy proxy)`|使用指定的代理类型创建一个新的未连接的Socket；proxy为代理服务器地址|
|`Socket(String dstName , int dstPort)`|使用指定的目标服务器的主机名和目标服务器的端口号，创建一个新的Socket|
|`Socket(String dstName , int dstPort , InetAddress localAddress , int localPort)`|使用指定的目标主机、目标端口、本地地址和本地端口创建一个新的Socket|
|`Socket(InetAddress dstAddress , int dstPort)`|使用指定的本地地址和本地端口创建一个新的Socket|
|`Socket(InetAddress dstAddress , int dstPort , InetAddress localAddress , int localPort)`|使用指定的目标主机、目标端口、本地地址和本地端口，创建一个新的Socket|
|`public InputStream getInputStream()`|读出该Socket中的数据|
|`public OutputStream getOutputStream()`|向该Socket中写入数据|
|`public synchronized void close()`|关闭该Socket|
|`setSoTimeout(int timeout)`|设置超时时长，单位ms；为Socket对象指定了超时时长之后，如果使用Socket进行读写操作完成以前已经超出了该时间范围，那么这个方法将会抛出SocketTimeoutException异常，程序可以对该异常进行捕捉，并进行适当的处理|

#### 服务器 ServerSocket

|ServerSocket的重要方法|说明|
|------|-----|
|`ServerSocket()`|构造一个新的未绑定的ServerSocket|
|`ServerSocket(int port)`|创建一个新的ServerSocket实例并且绑定到指定的端口，如果port参数为0，端口将由操作系统自动分配，此时进入队列的数目被设置为50|
|`ServerSocket(int port , int backlog)`|创建一个新的ServerSocket实例并绑定到指定端口，并且指定进入队列的数目，如果port为0，端口将由操作系统自动分配|
|`ServerSocket(int port , int backlog , InetAddress localAddress)`|构造一个新的ServerSocket实例并且绑定到指定端口和指定的地址；如果localAddress的参数为null，则可以使用任意地址，如果port参数为0，端口将由操作系统自动分配|
|`public Socket accept()`|等待客户Socket请求，直到连接被打开，该方法返回一个刚刚打开的连接Socket对象，如果没有连接，它将一直处于等待状态，线程也被阻塞，服务器端应该一直接收客户端的请求，所以一般放在循环中|
|`public void close()`|关闭该服务器Socket|

+ 服务器的每种服务都会绑定在一个端口上面；`0~1023`端口为系统保留，用户设定的端口号应该大于1023；如果没有指定`IP地址`，则将会绑定到默认的`IP地址`，由于`手机`无线上网的`IP地址`通常都是由运营商动态分配的，一般不会有自己固定的`IP地址`，因此很少在手机上运行服务器端程序，服务器端通常在`有固定IP地址`的服务器上；在连接成功时，应用程序两端都会产生一个`Socket`实例，操作这个实例完成客户端到服务器所需的会话；

#### [使用Socket实现聊天功能](https://github.com/ningbaoqi/ComputerNetWork/commit/cb5d71ed61866f8db1a8fc93cb12e2d8dc263888)
