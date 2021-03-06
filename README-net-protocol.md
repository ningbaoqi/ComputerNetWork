### 划分子网
#### 从两级IP地址到三级IP地址
+ 为了提高`IP地址`的利用率和灵活性，`IP地址`中有增加了一个`子网号字段`，使`两级IP地址`变成`三级IP地址`，这种做法称作`划分子网`或`子网寻址`或`子网路由选择`；划分子网纯属一个单位内部的事情，本单位以外的网络`看不见`这个网络是由多少个子网组成的，因为这个单位`对外仍然表现为一个网络`；划分子网的方法是从`网络的主机号`借用若干位作为`子网号subnet-id`，于是`两级IP地址`在本单位内部就变成了`三级IP地址`，`网络号`、`子网号`、`主机号`；
#### 子网掩码
![image](https://github.com/ningbaoqi/ComputerNetWork/blob/master/gif/pic-60.jpg)
+ 现在因特网的标准规定：所有的网络都必须使用`子网掩码`，同时在路由器的路由表中也必须有子网掩码这一栏，如果一个网络不划分子网，那么该网络的子网掩码就使用`默认子网掩码`；

### 无分类编址CIDR(构成超网)
#### 网络前缀
+ `无分类编址`全名为`无分类域间路由选择CIDR`，`CIDR`有两个主要特点：一、`CIDR消除了传统的A类、B类、C类地址以及划分子网的概念`，`CIDR`把32位的`IP地址`划分为两个部分，前面的部分是`网络前缀`用来`指明网络`，后面的部分则是用来`指明主机`；`CIDR`还使用`斜线记法`，即在`IP地址`后面加上斜线`/`，然后写上`网络前缀所占的位数`如`128.14.35.7/20`；二、`CDIR把网络前缀相同`的连续的`IP地址`组成一个`CIDR地址块`，为了更方便的进行路由选择，`CIDR`使用32位的`地址掩码`，`地址掩码`由一串`1`和一串`0`组成，而`1`的个数就是`网络前缀的长度`，`斜线记法中，斜线后面的数字就是地址掩码中1的个数`；
