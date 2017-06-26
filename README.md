# wxsdk
**集成实现了微信开发相关接口,基于该sdk,开发者将可以快速开发使用微信相关接口**

 - 目前实现了以下接口：
 - （1）客服消息发送接口
 - （2）模板消息发送接口
 - （3）微信网页授权登录接口及用户信息获取接口
 - （4）微信支付-网页个人向企业付款接口，网页企业向个人付款接口

代码很简陋，需要的话，大家可以看看，模块优化与扩充同步进行中。


----------


使用方法，打成jar包或直接拷贝源码到个人工程：

 - （1）在工程根目录添加wechat.properties文件，用于配置微信相关参数，例如：
```
    APPID=***
    APPSECRET=***
    TOKEN=***
    //wx pay
    KEY=***
    MCHID=***
    CERT_PATH=***
```

 - （2）相关参数初始化，调用

  WxSDK.init();建议在Spring相关项目中，采用@PostConstruct注解，使Spring项目初始化完毕，即初始化本SDK相关参数

 - （3）使用,统一调用WxSDK下各子接口，目前WxSDK下提供三个子SDK
```
      WEB_SDK 微信授权登录，用户信息获取
      MSG_SDK 发送消息接口
      PAY_SDK 微信支付接口
 ```

 - （4）使用示例
```
    public class Test {
        public static void main(String [] args) throws Exception{
                WxSDK.init();//只需初始化一次
                //发送客服消息
                WxSDK.MSG_SDK.send(new TextMsg("obGURwbzfKF2SWtjDuPtODOGJlSg",
                        "hellow slanf"));
                //发送模板消息        
                TemplateMsg templateMsg = new TemplateMsg(
                        "obGURwbzfKF2SWtjDuPtODOGJlSg",
                        "5Lf7xnN-daeG1pE7yKMd8TzivLj-bYNvCCk65zq1n8s",
                        "www.baidu.com"
                );
                templateMsg.addPair("title","测试消息");
                templateMsg.addPair("keyword1","随心而笑");
                templateMsg.addPair("keyword2","一等奖");
                WxSDK.MSG_SDK.send(templateMsg);
        }
    }
 ```

 - （5）待续

