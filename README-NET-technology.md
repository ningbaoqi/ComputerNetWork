### 应用进程跨越网络的通信
#### 调用和应用编程接口
+ 大多数操作系统使用`系统调用`的机制在应用程序和操作系统之间传递控制权，系统调用是将控制权传递给了操作系统；系统调用接口又称为`应用编程接口API`，`API从程序设计的角度`定义了许多标准的系统调用函数；现在`TCP/IP`协议软件已驻留在操作系统中，由于`TCP/IP`协议族被设计成能运行在多种操作系统的环境中，因此`TCP/IP`标准没有规定应用程序与`TCP/IP`协议软件如何接口的细节，而是允许系统设计者能够选择有关API的具体实现细节；
![image](https://github.com/ningbaoqi/ComputerNetWork/blob/master/gif/pic-174.jpg)  
+ 网络编程时常常把`套接字`作为`应用进程`和`运输层`协议之间的接口，现在`套接字`已成为计算机操作系统内核的一部分；在`套接字`以上的进程是受应用程序控制的，而在`套接字`以下的运输层协议软件则是受计算机操作系统的控制；
![image](https://github.com/ningbaoqi/ComputerNetWork/blob/master/gif/pic-175.jpg) 
![image](https://github.com/ningbaoqi/ComputerNetWork/blob/master/gif/pic-176.jpg) 
### 几种常见的系统调用
#### 连接建立阶段
![image](https://github.com/ningbaoqi/ComputerNetWork/blob/master/gif/pic-177.jpg)  
#### 连接释放阶段
![image](https://github.com/ningbaoqi/ComputerNetWork/blob/master/gif/pic-178.jpg) 
+ `UDP服务器`由于只提供`无连接服务`，因此不使用`listen`和`accept`系统调用；
