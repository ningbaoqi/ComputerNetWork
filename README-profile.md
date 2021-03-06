### 因特网概述
#### 网络的网络
+ 网络由若干`结点`和连接这些结点的`链路`组成，网络中的结点可以是`计算机`、`集线器`、`交换机`或`路由器`等；网络和网络还可以通过`路由器`互连起来，这样就构成了一个覆盖范围更大的网络，即`互联网`或`互联网`；把连接在因特网上的计算机都称为`主机`；网络把许多计算机连接在一起，而因特网则把许多网络连接在一起；
#### 不同的层次使用不同的中间设备

|层次|中间设备|
|------|------|
|物理层|转发器|
|数据链路层|网桥或桥接器|
|网络层|路由器|
|网络层以上|网关，用网关连接两个不兼容的系统需要在高层进行协议的转换|

### 互联网的核心部分
+ `路由器`是实现`分组交换`的关键构件，其任务是`转发收到的分组`，这是网络核心部分最重要的功能；
#### 分组交换的主要特点
+ `分组交换`采用`存储转发技术`，通常我们把要发送的整块数据称为一个`报文`，在发送报文之前，先把较长的报文划分成为一个个更小的等长数据段，在每一个数据段前面，加上一些必要的控制信息组成的`首部`后，就构成了一个`分组`，分组又称为`包`，而分组的首部也可称为`包头`，分组是在因特网中传送的数据单元，分组中的`首部`，是非常重要的，正是由于分组的首部包含了诸如`目的地址`、`源地址`等重要的控制信息，这样每一个分组才能在因特网中独立的选择传输路径，并被正确的交付到分组传输的终点；在因特网核心部分的路由器之间一般都用`高速链路相连接`；`分组交换`---单个分组（这只是整个报文的一部分）传送到相邻结点，存储下来后查找`转发表`，转发到下一个结点；

### 计算机网络的类别
#### 按网络的作用范围进行分类

|作用范围分类|说明|
|-------|-------|
|广域网WAN(Wide Area Network)|广域网的作用范围通常是几十公里或几千公里，因而有时也称为远程网，广域网是因特网的核心部分，其任务是通过长距离运送主机所发送的数据，连接广域网各结点交换机的链路一般都是高速链路，具有较大的通信容量|
|城域网MAN(Metropolitan Area Network)|城域网的作用范围一般是一个城市，可跨越几个街区甚至整个的城市，其作用距离约5~50km，城域网可以为一个或几个单位所拥有，但也可以是一种公用设施，用来将多个局域网进行互连，目前，很多城域网采用的是以太网技术|
|局域网LAN(Local Area Network)|局域网一般用微型计算机或工作站通过高速通信线路相连，但地理上则局限于在较小的范围|
|个人区域网PAN(Personal Area Network)|个人区域网就是在个人工作的地方把属于个人使用的电子设备(如便携式电脑等)用无线技术连接起来的网络，因此也常称为无线个人区域网WPAN，其范围大约在10m左右|

### 计算机网络的性能指标

|性能指标|说明|
|------|------|
|速率|网络技术中的速率指的是连接在计算机网络上的主机在数字信道上`传输数据的速率`，它也称为`数据率`或`比特率`单位`b/s`比特每秒|
|带宽|带宽本来是指某个信号具有的频带宽度，信号的带宽是指信号所包含的各种不同频率成分所占据的频率范围；在计算机网络中，带宽用来表示网络的`通信线路`传输数据的能力，因此网络带宽表示在`单位时间内从网络中的某一点到另一点所能通过的最高数据率`，一条通信链路的带宽越宽，其所能传输的最高数据率也越高|
|吞吐量|吞吐量表示在单位时间内通过某个网络(或信道、接口)的数据量|
|时延|时延是指数据(一个报文或分组，甚至比特)从网络(或链路)的一端传送到另一端所需的时间|
|时延带宽积|传播时延带宽积为传播时延与带宽的乘积|
|往返时间RTT|往返时间RTT，它表示从发送方发送数据开始，到发送方收到来自接收方的确认总共经历的时间|
|利用率|利用率有信道利用率和网络利用率两种，信道利用率指出某信道有百分之几的时间是被利用的，网络利用率则是全网络的信道利用率的加权平均值|
### 计算机网络体系结构
[计算机网络体系结构](https://github.com/ningbaoqi/ComputerNetWork/blob/master/README-1.md)


