
[![Maven Central](https://maven-badges.herokuapp.com/maven-central/com.bpfaas/bp-common/badge.svg)](https://maven-badges.herokuapp.com/maven-central/com.bpfaas/bp-common/)
[![License](https://img.shields.io/github/license/bpfaas/java-bp-common)](https://opensource.org/licenses/MIT)


```html
<dependency>
    <groupId>com.bpfaas</groupId>
    <artifactId>bp-common</artifactId>
    <version>0.0.1</version>
</dependency>
```

包含如下内容:

- 约定返回对象格式
- 常用异常
  - ErrSubcodeException  可使用此异常来传递一个业务相关的err_subCode; 在外层统一处理;
  - FaasRawMsgException  可在controller处理中抛出此异常, 错误处理时将会自动返回包含指定httpStatusCode等信息 http的raw形式.
- 常用工具
  - JsonUtils     json序列化反序列化工具.
  - CommandUtils  命令执行工具
  - CryptUtils    加密算法等工具
- 注解
  - @ValidatorId 验证请求参数id的合法性.