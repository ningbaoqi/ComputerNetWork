### 协议标记交换MPLS
#### MPLS的产生背景
+ `多协议标记交换MPLS`多协议表示在MPLS的上面可以采用多种协议；其具有三方面的特点：`支持面向连接的服务质量`、`支持流量工程，平衡网络负载`、`有效的支持虚拟专用网VPN`；
### MPLS的工作原理
#### 基本工作过程
+ MPLS的一个重要特点就是不用长度可变的IP地址前缀来查找转发表中的匹配项目，而是给每一个IP数据报打上固定长度的标记，然后对打上标记的IP数据报用硬件进行转发，这就使得IP数据报转发的过程省去了每到达一个路由器都要上升到网络层用软件查找路由表的过程，因而IP数据报转发的速率就大大加快了，采用硬件技术对打上标记的IP数据报进行转发就称为`标记交换`，交换也表示在转发时不再上升到网络层查找路由表，而是根据标记在链路层用硬件进行转发；
![image](https://github.com/ningbaoqi/ComputerNetWork/blob/master/gif/pic-280.jpg)
+ `MPLS域`是指该域中有许多彼此相邻的路由器，并且所有的路由器都是支持MPLS技术的标记交换路由器LSR；MPLS是面向连接的，因为在标记交换路径LSP上的第一个LSR就根据IP数据报的初始标记确定了整个的标记交换路径，就像一条虚连接一样；当一个IP数据报进入到MPLS域时，MPLS入口结点就给它打上标记(它实际上是插入一个MPLS首部)，并按照转发表把它转发给下一个LSR，以后的所有LSR都按照标记进行转发；`一个标记仅仅在两个标记交换路由器LSR之间才有意义`，LSR做两件事：`转发`、`更换新的标记`，即把入标记更换成为出标记；
#### 转发等价类FEC
+ `转发等价类`就是路由器`按照同样方式对待`的IP数据报的集合；这里`按照同样方式对待`表示从同样接口转发到同样的下一跳地址，并且具有同样服务类和同样丢弃优先级等；
### MPLS首部的位置与格式
+ 给`IP数据报打上标记`其实就是在IP数据报前面`增加一个4字节`的`MPLS首部`；
![image](https://github.com/ningbaoqi/ComputerNetWork/blob/master/gif/pic-281.jpg)
+ MPLS还有一个功能就是可以使用多个标记，并把这些标记都放入`标记栈`其实MPLS的标记栈就在MPLS首部的位置；
