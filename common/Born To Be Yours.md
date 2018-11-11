## 关于文件流

在程序中，我们可能会用到文件的输入和输出，那么实现文件的输入和输出的方法就是使用流(Stream),一个流，必有源端和目的端，它们可以是计算机内存的某些区域，也可以是磁盘文件，甚至可以是 Internet 上的某个 URL。对于流而言，我们不用关心数据是如何传输的，只需要向源端输入数据，从目的端获取数据即可。

 流按照处理数据的单位，可以分为字节流和字符流。字节流的处理单位是字节，通常用来处理二进制文件，例如音乐、图片文件等。而字符流的处理单位是字符，因为Java采用Unicode编码，Java字符流处理的即为Unicode字符，所以在操作汉字、国际化等方面，字符流具有优势。

 那么这些流要怎么在代码程序上使用呢？


 1. 字节流

 首先，让我们来看看字节流，使用字节流当然离不开它继承的两个抽象类，InputStream 和 OutputStream,可以看出来这两个单词上的区别就是前者用in后者用out，这样看其实就非常明显了，一个对内一个对外，当然，这对于初学者来着，in和out还是很容易让人迷惑的，那么什么是一个对内一个对外呢，如下代码所示
 ``` java
        //指定源头文件
        InputStream is = new FileInputStream("路径")
        //指定目标文件
        OutputStream os = new FileOutputStream("路径")
 ```

 所谓对外对内，这个对象我们称他为内存，如果我们遇到了in和out分不清的时候，我们只需要记住，in和out是相对于内存来说的操作，除了内存，我们还需要了解字节流它最终的目的地是硬盘，
 也就是说，in和out两个影响的结果就是内容和硬盘之间的行走方向，in所出现的结果就是从内存--->硬盘，也就是往硬盘内写入，同理，out所出现的结果就是硬盘--->内存，输出结果到显示器上，这样就可以解释代码处的源头文件和目标文件了，简单来说就是源头文件为你要写的文件在哪，目标文件就是你要读的文件在哪。

 当然，关于上面的代码只是字节流的创建而已，真正要做到一个完整的读写文件还需要其他步骤：
 ``` java
        //创建传输管道
        byte []b = new byte[1024];  
        //循环读取
        while(is.read(b) != -1){
	        os.write(b,0,b.length);
        }
        //关闭流
        os.close()
        is.close()
 ```

2. 字符流

    字符流与字节流差不多，都有两个抽象类的继承,分别是Reader和Writer，其中Reader是用于读取字符流的抽象类，Writer是用于写入字符流的抽象类。
 ``` java
        Reader r = new FileReader("路径");
        Writer w = new FileWriter("路径");
 ```
 所以说，我们可以很简单的把Reader视为读字符，Wirter为写字符。
 
  Reader 和 Writer 要解决的最主要问题是国际化。原先的 I/O 类库只支持8位的字节流，因此不能很好的处理16位的Unicode字符。Unicode 是国际化的字符集，这样增加了Reader 和 Writer之后，就可以自动在本地字符集和Unicode国际化字符集之间进行转换。

  那么我们要怎么使用这两个对于字符流的读写呢

``` java
    //创建读文件的对象
    Reader r = new FileReader("路径");
    Writer w = new FileWriter("路径");
    //创建读写缓冲区对象
    BufferedReader br = new BufferedReader(r);
    BufferedWriter bw = new BufferedWriter(w);
    
    //逐行读取文件
    String line="";
    StringBuffer sb = new StringBuffer();
    while((line = br.readLine()) != null){
    	sb.append(line);
    }
    bw.write(sb.toString());
    bw.flush();
    bw.close();
    br.close();
```
