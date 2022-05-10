# Blade-Patchca: verification code library for Java

<a href="http://search.maven.org/#search%7Cga%7C1%7Cblade-captcha"><img src="https://img.shields.io/maven-central/v/com.hellokaton/blade-captcha.svg?style=flat-square"></a>

## Overview

Simple yet powerful verification code library written in Java with zero dependency.

You can generate verification code picture like this:

![验证码](https://s2.ax1x.com/2019/08/23/msFrE8.png)
&emsp;&emsp;
![验证码](https://s2.ax1x.com/2019/08/23/msF0DP.png)
&emsp;&emsp;
![验证码](https://s2.ax1x.com/2019/08/23/msFwut.png)
<br/>
![验证码](https://s2.ax1x.com/2019/08/23/msFzVK.gif)
&emsp;&emsp;
![验证码](https://s2.ax1x.com/2019/08/23/msFvb6.gif)
&emsp;&emsp;
![验证码](https://s2.ax1x.com/2019/08/23/msFXK1.gif)

**Numeric**

![验证码](https://s2.ax1x.com/2019/08/23/mskKPg.png)
&emsp;&emsp;
![验证码](https://s2.ax1x.com/2019/08/23/msknIS.png)
&emsp;&emsp;
![验证码](https://s2.ax1x.com/2019/08/23/mskma8.png)

**Chinese**

![验证码](https://s2.ax1x.com/2019/08/23/mskcdK.png)
&emsp;&emsp;
![验证码](https://s2.ax1x.com/2019/08/23/msk6Z6.png)
&emsp;&emsp;
![验证码](https://s2.ax1x.com/2019/08/23/msksqx.png)

**Built-in fonts**

![验证码](https://s2.ax1x.com/2019/08/23/msAVSJ.png)
&emsp;&emsp;
![验证码](https://s2.ax1x.com/2019/08/23/msAAW4.png)
&emsp;&emsp;
![验证码](https://s2.ax1x.com/2019/08/23/msAkYF.png)

### Steps to Integrate

- Add following dependency in your `pom.xml`

```xml
<dependency>
    <groupId>com.hellokaton</groupId>
    <artifactId>blade-captcha</artifactId>
    <version>0.1.0</version>
</dependency>
```

- Add following dependency in your code

```java
@GET("/captcha")
public void captcha() throws IOException {
    GifCaptcha captcha = new GifCaptcha(130, 48, 6);
    System.out.println(captcha.text());
    CaptchaKit.render(captcha);
}
```

# Special thanks

- [EasyCaptcha](https://gitee.com/ele-admin/EasyCaptcha)

