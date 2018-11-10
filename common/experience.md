## 关于前端的一些小知识

1. jsp

    与html不同的是他有属于的自己的标签库和小脚本

    `JSTL(标准标签库)`,jsp提供了很多对逻辑有帮助的标签，例如最常见的if判断和

    ``` jsp
        <c:if test="${1<2}">
            <c:out value="1<2 is true"/>
        </c:if>
        <c:if test="${1>2}">
             <c:out value="1>2 is false"/>
        </c:if>
    ```
    或者if else判断


    ``` jsp
        <c:choose>
            <c:when test="#{1>2}">  
               我是if    
         </c:when>
        <c:otherwise> 
             我是else
         </c:otherwise>
        </c:choose>
    ```

jsp标签库还有很多有意思的标签,比如说`基础迭代标签<c:forEach>`，可以接受多种`集合`来做到后端的`foreach`效果。

实现jsp标签库的前提需要`导入包`，要不然这些标签是没用的哦
``` jsp
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
```

当然，jsp除了这些标签库以外，还有一种功能，就是可以写`小脚本`，那什么是`小脚本`？我们可以理解为，它是一个`页面嵌java代码`的一种功能；小脚本也有很多样式的，比如说
``` jsp
    //表达式
    <%=1+2%> 

    //声明
    <%!
        int num = 1;
        String str ="潘啸";
        double d[]={1.2,5.8,10.2,56.5};
    %>

    //可嵌入java代码
    <%
        if(true){
            //....
        }
    %>

```

我以前使用小脚本的时候用的最多的就是用在session这一块,在前台显示登入者
``` jsp
    <%
        String name = request.getParameter("name");
        session.setAttribute("name", name);
        String names = (String) session.getAttribute("name");
    %>
    欢迎:<%=names%>
```


2. ajax和form表单

首先让我们看看他们的请求方式
``` jsp
    //form表单提交
    <form action="test" method="post">
        <input type="text" name="username">
        <input type="password" name="password">
        //点击提交按钮后，将文本框内容传输到后台
        <input type="submit" value="提交">
    </form>

    //ajax提交
    <script type="text/javascript" src="js/jquery-1.8.3.js"></script>
    <script>
         function show(begin,size){
		    	$.ajax({
                    //发送请求的地址
			    	url:"home",
                    //请求类型
			    	type:"post",
                    //请求的数据
			    	data:{
			    		"begin":begin,
			    		"size":size
			    	},
                    //成功响应后进入success方法，报错则进入error方法
			    	success:function(result){
			    		console.info(result);
			    		if(result.totalpage==begin){
			    			$("#loadpage").html("没有更多记录啦");
			    			$("#loadpage").attr("onclick","showout()");
			    		}else{
			    			$("#loadpage").html("加载更多...");
			    			$("#loadpage").attr("onclick","show("+result.next+")");
			    		}
		    		}
		    	})
	    	}
    </script>
```
可以直观的看出来，form表单提交比ajax提交方法要简单，但是没有ajax灵活,这些只是表面现象，那么他们功能上的区别是什么呢？

首先我们来说说ajax:

我们为什么要用ajax,因为使用ajax，用户对Web的体验会更`“敏捷”`：数据提交页面不会闪屏；`页面局部`
   更新速度快；网络带宽占用低

   ajax在提交、请求、接收时，都是`异步`进行的，网页不需要刷新

   ajax提交时，是在`后台`新建一个请求

   ajax必须要用js来实现，存在调试麻烦、浏览器兼容问题，而且不启用js的浏览器，无法完成操作

   form表单：
   Form提交则是新建一个页面，哪怕是提交给`自己本身的页面`，也`需要刷新`，为了维持页面用户对表单的状态改变，要在控制器和模板之间传递更多参数以保持页面状态

   Form表单是`浏览器自带`的，无论是否开启js，都可以提交表单

   Form表单提交，是根据表单结构自动完成，不需要代码干预。用`submit提交`



   ### 最后

   #### 关乎项目本身来说，为了达到更好的业务逻辑的方便和程序的高效，尽量还是使用ajax，这也是为什么工作中基本上都见不到form表单提交的原因了






