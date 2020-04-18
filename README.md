
#### 项目说明
参数校验-validator, 用于快速接入校验字段的处理, 默认使用系统返回提示

比如: 参数校验

```
{
    "success": false,
    "code": "406",
    "msg": "Invalid Param: name=[]不能为空",
    "data": null
}
```

JSON解析异常

```
{
    "success": false,
    "code": "400",
    "msg": "请求数据错误, 请确认是否为JSON格式, 请求数据见data",
    "data": "{  \"name\": \"\"  \"age\": 1}"
}
```

#### 使用方式

x4096.validator.enable=true  
x4096.validator.use-default-check-msg=true  
x4096.validator.use-default-http-message-not-readable=true


#### TODO
数据库层面校验？比如MyBatis
