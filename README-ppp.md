### 点对点协议PPP
#### PPP协议的特点
+ 点对点协议PPP是使用最广泛的数据链路层协议；PPP协议就是用户计算机和ISP进行通信时所使用的数据链路层协议；
![image](https://github.com/ningbaoqi/ComputerNetWork/blob/master/gif/pic-20.jpg)
#### PPP协议的帧格式
![image](https://github.com/ningbaoqi/ComputerNetWork/blob/master/gif/pic-21.jpg) 
+ 当协议字段为`0x0021`时，PPP帧的信息字段就是`IP数据报`，若为`0xC021`则信息字段是`PPP链路控制协议LCP`的数据，而`0x8021`表示这是`网络层的控制数据`；
