### 网际协议IP
+ 与`IP协议`配套使用的还有三个协议：`地址解析协议ARP(Address Resolution Protocol)`、`网际控制报文协议ICMP(Internet Control Message Protocol)`、`网际组管理协议IGMP(Internet Group Management Protocol)`；

![image](https://github.com/ningbaoqi/ComputerNetWork/blob/master/gif/pic-50.jpg)   pic-50.jpg

+ `ARP`画在最下面，因为`IP`经常要使用这个协议，`ICMP`、`IGMP`画在这一层的上部，因为它们要使用`IP`协议；由于`网际协议IP`是用来使互连起来的许多计算机网络能够进行通信，因此`TCP/IP`体系中的网络层常常被称为`网际层`或`IP层`；

### 虚拟互连网络
+ 由于参加互连的计算机网络都使用相同的`网际协议IP`，因此可以把互连以后的计算机网络看成`虚拟互连网络`，所谓虚拟互联网络就是逻辑互连网络，互连起来的各种物理网络的异构性本来是客观存在的，但是利用`IP协议`就可以使这些性能各异的网络在`网络层上看起来好像是一个统一的网络`；这种使用`IP协议`的虚拟互连网络也称为`IP网`；使用`IP网`的好处是：当`IP网`上的主机进行通信时，就好像在一个单个网络上通信一样，它们看不见互连的各网络的具体异构细节；

![image](https://github.com/ningbaoqi/ComputerNetWork/blob/master/gif/pic-51.jpg)   pic-51.jpg
