MemCache学习笔记

MemCache——自由的、开源的、高性能的分布式内存对象缓存系统
用于动态Web应用可减轻数据库负载,通过在内存中缓存数据和对象来减少数据库的读写次数提高网站的访问速度。
MemCache是一个储存键值对的HashMap。
MemCache设计理念就是小而强大，它的简单设计促进了快速部署、易于开发解决面对大规模的数据缓存的许多难题。
MemCache是项目名称，MemCached是MemCache服务器端的可执行文件名称。
MemCache本身完全不具备分布式缓存的功能,它是完全依赖于客户端程序来实现分布式的。

MemCache写入缓存的流程：
	1).应用程序输入要缓存的数据
	2).API将Key传入路由算法模块，路由算法模块根据传入的Key和MemCache集群服务器列表计算得到一台服务器编号
	3).通过服务器编号得到MemCache服务器的ip与端口
	4).API调用通信模块和指定编号的MemCache服务器进行通信,将数据写入该服务器,完成一次写入缓存的过程。
MemCache读取缓存的流程：
	1).应用程序传入一个需要读取的缓存Key
	2).API将Key传入路由算法模块,路由算法模块根据传入的Key和MemCache集群服务器列表计算得到一台服务器编号
	3).通过服务器编号得到MemCache服务器的Ip和端口号
	4).API调用通信模块和指定编号的MemCache服务器进行通信,将指定Key对应的数据取回并返回给应用程序,完成一次读取的过程。

MemCache的原理
	1).MemCache将内存空间分为一组slab
	2).每个slab下有若干个page,每个page默认1M大小。
	3).每个page里面包含一组chunk,chunk是真正存放数据的空间,同一个slab下面的chunk大小是固定的。
	4).有相同大小chunk的slab被组织在一起，称为slab_class。
	
	

	
	
	
	
	
MemCached线程模型关键字理解
	event_base:
	fd-file desciptor:
	
	
MemCached-TCP/IP通信——socket()，listen()，bind()，accept()