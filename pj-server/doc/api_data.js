define({ "api": [
  {
    "type": "POST",
    "url": "/notice/add",
    "title": "add",
    "version": "1.0.0",
    "group": "公告",
    "name": "add",
    "description": "<p>新增公告</p>",
    "parameter": {
      "fields": {
        "请求参数": [
          {
            "group": "请求参数",
            "type": "String",
            "optional": false,
            "field": "title",
            "description": "<p>公告标题</p>"
          },
          {
            "group": "请求参数",
            "type": "String",
            "optional": false,
            "field": "content",
            "description": "<p>公告内容</p>"
          },
          {
            "group": "请求参数",
            "type": "Number",
            "optional": false,
            "field": "status",
            "description": "<p>公告状态</p>"
          },
          {
            "group": "请求参数",
            "type": "Number",
            "optional": false,
            "field": "validDate",
            "description": "<p>公告显示时间</p>"
          },
          {
            "group": "请求参数",
            "type": "Number",
            "optional": false,
            "field": "validTime",
            "description": "<p>公告显示时间戳</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "请求参数示例",
          "content": "title=公告2&content=lll&status=1&validDate=2020/12/2&validTime=1608737086",
          "type": "json"
        }
      ]
    },
    "success": {
      "fields": {
        "响应结果": [
          {
            "group": "响应结果",
            "type": "Object",
            "optional": false,
            "field": "response",
            "description": ""
          }
        ]
      },
      "examples": [
        {
          "title": "响应结果示例",
          "content": "{}",
          "type": "json"
        }
      ]
    },
    "filename": "src/main/java/com/fdu/pjserver/controller/NoticeController.java",
    "groupTitle": "公告"
  },
  {
    "type": "POST",
    "url": "/notice/delete",
    "title": "delete",
    "version": "1.0.0",
    "group": "公告",
    "name": "delete",
    "description": "<p>删除公告</p>",
    "parameter": {
      "fields": {
        "请求参数": [
          {
            "group": "请求参数",
            "type": "Number",
            "optional": false,
            "field": "id",
            "description": ""
          }
        ]
      },
      "examples": [
        {
          "title": "请求参数示例",
          "content": "id=1",
          "type": "json"
        }
      ]
    },
    "success": {
      "fields": {
        "响应结果": [
          {
            "group": "响应结果",
            "type": "Object",
            "optional": false,
            "field": "response",
            "description": ""
          }
        ]
      },
      "examples": [
        {
          "title": "响应结果示例",
          "content": "{}",
          "type": "json"
        }
      ]
    },
    "filename": "src/main/java/com/fdu/pjserver/controller/NoticeController.java",
    "groupTitle": "公告"
  },
  {
    "type": "GET",
    "url": "/notice/get_all",
    "title": "getAll",
    "version": "1.0.0",
    "group": "公告",
    "name": "getAll",
    "description": "<p>获取所有公告</p>",
    "success": {
      "fields": {
        "响应结果": [
          {
            "group": "响应结果",
            "type": "Object",
            "optional": false,
            "field": "response",
            "description": ""
          }
        ]
      },
      "examples": [
        {
          "title": "响应结果示例",
          "content": "{}",
          "type": "json"
        }
      ]
    },
    "filename": "src/main/java/com/fdu/pjserver/controller/NoticeController.java",
    "groupTitle": "公告"
  },
  {
    "type": "POST",
    "url": "/notice/update",
    "title": "update",
    "version": "1.0.0",
    "group": "公告",
    "name": "update",
    "description": "<p>更新公告</p>",
    "parameter": {
      "fields": {
        "请求参数": [
          {
            "group": "请求参数",
            "type": "Number",
            "optional": false,
            "field": "id",
            "description": ""
          },
          {
            "group": "请求参数",
            "type": "String",
            "optional": false,
            "field": "title",
            "description": ""
          },
          {
            "group": "请求参数",
            "type": "String",
            "optional": false,
            "field": "content",
            "description": ""
          },
          {
            "group": "请求参数",
            "type": "Number",
            "optional": false,
            "field": "status",
            "description": ""
          },
          {
            "group": "请求参数",
            "type": "Number",
            "optional": false,
            "field": "validDate",
            "description": ""
          },
          {
            "group": "请求参数",
            "type": "Number",
            "optional": false,
            "field": "validTime",
            "description": ""
          }
        ]
      },
      "examples": [
        {
          "title": "请求参数示例",
          "content": "validDate=2020/12/23&validTime=1608737086&id=7159&title=标题&content=巴拉巴拉&status=1",
          "type": "json"
        }
      ]
    },
    "success": {
      "fields": {
        "响应结果": [
          {
            "group": "响应结果",
            "type": "Object",
            "optional": false,
            "field": "response",
            "description": ""
          }
        ]
      },
      "examples": [
        {
          "title": "响应结果示例",
          "content": "{}",
          "type": "json"
        }
      ]
    },
    "filename": "src/main/java/com/fdu/pjserver/controller/NoticeController.java",
    "groupTitle": "公告"
  },
  {
    "type": "POST",
    "url": "/student_info/add",
    "title": "add",
    "version": "1.0.0",
    "group": "学生基本信息",
    "name": "add",
    "description": "<p>新增学生基本信息</p>",
    "parameter": {
      "fields": {
        "请求参数": [
          {
            "group": "请求参数",
            "type": "String",
            "optional": false,
            "field": "userId",
            "description": "<p>用户ID（学号）</p>"
          },
          {
            "group": "请求参数",
            "type": "String",
            "optional": false,
            "field": "mobile",
            "description": "<p>联系方式</p>"
          },
          {
            "group": "请求参数",
            "type": "String",
            "optional": false,
            "field": "department",
            "description": "<p>院系</p>"
          },
          {
            "group": "请求参数",
            "type": "String",
            "optional": false,
            "field": "degree",
            "description": "<p>分类（本科生，研究生，博士生）</p>"
          },
          {
            "group": "请求参数",
            "type": "Number",
            "optional": false,
            "field": "fullTime",
            "description": "<p>是否全日制</p>"
          },
          {
            "group": "请求参数",
            "type": "String",
            "optional": false,
            "field": "counselorName",
            "description": "<p>辅导员姓名</p>"
          },
          {
            "group": "请求参数",
            "type": "Number",
            "optional": false,
            "field": "graduation",
            "description": "<p>是否毕业班学生（0否 1是）</p>"
          },
          {
            "group": "请求参数",
            "type": "String",
            "optional": false,
            "field": "address",
            "description": "<p>居住地址</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "请求参数示例",
          "content": "counselorName=李老师&address=上海市XX区XX路&graduation=0&mobile=13800000000&degree=研究生&fullTime=0&department=软件学院&userId=20262010001",
          "type": "json"
        }
      ]
    },
    "success": {
      "fields": {
        "响应结果": [
          {
            "group": "响应结果",
            "type": "Object",
            "optional": false,
            "field": "response",
            "description": ""
          }
        ]
      },
      "examples": [
        {
          "title": "响应结果示例",
          "content": "{}",
          "type": "json"
        }
      ]
    },
    "filename": "src/main/java/com/fdu/pjserver/controller/StudentInfoController.java",
    "groupTitle": "学生基本信息"
  },
  {
    "type": "POST",
    "url": "/student_info/get",
    "title": "get",
    "version": "1.0.0",
    "group": "学生基本信息",
    "name": "get",
    "description": "<p>获取学生基本信息</p>",
    "parameter": {
      "fields": {
        "请求参数": [
          {
            "group": "请求参数",
            "type": "String",
            "optional": false,
            "field": "userId",
            "description": ""
          }
        ]
      },
      "examples": [
        {
          "title": "请求参数示例",
          "content": "userId=20262010001",
          "type": "json"
        }
      ]
    },
    "success": {
      "fields": {
        "响应结果": [
          {
            "group": "响应结果",
            "type": "Object",
            "optional": false,
            "field": "response",
            "description": ""
          }
        ]
      },
      "examples": [
        {
          "title": "响应结果示例",
          "content": "{}",
          "type": "json"
        }
      ]
    },
    "filename": "src/main/java/com/fdu/pjserver/controller/StudentInfoController.java",
    "groupTitle": "学生基本信息"
  },
  {
    "type": "GET",
    "url": "/student_info/get_all",
    "title": "getAll",
    "version": "1.0.0",
    "group": "学生基本信息",
    "name": "getAll",
    "description": "<p>获取所有学生的基本信息</p>",
    "success": {
      "fields": {
        "响应结果": [
          {
            "group": "响应结果",
            "type": "Object",
            "optional": false,
            "field": "response",
            "description": ""
          }
        ]
      },
      "examples": [
        {
          "title": "响应结果示例",
          "content": "{}",
          "type": "json"
        }
      ]
    },
    "filename": "src/main/java/com/fdu/pjserver/controller/StudentInfoController.java",
    "groupTitle": "学生基本信息"
  },
  {
    "type": "POST",
    "url": "/student_info/update",
    "title": "update",
    "version": "1.0.0",
    "group": "学生基本信息",
    "name": "update",
    "description": "<p>修改学生基本信息</p>",
    "parameter": {
      "fields": {
        "请求参数": [
          {
            "group": "请求参数",
            "type": "String",
            "optional": false,
            "field": "userId",
            "description": ""
          },
          {
            "group": "请求参数",
            "type": "String",
            "optional": false,
            "field": "mobile",
            "description": ""
          },
          {
            "group": "请求参数",
            "type": "String",
            "optional": false,
            "field": "department",
            "description": ""
          },
          {
            "group": "请求参数",
            "type": "String",
            "optional": false,
            "field": "degree",
            "description": ""
          },
          {
            "group": "请求参数",
            "type": "Number",
            "optional": false,
            "field": "fullTime",
            "description": ""
          },
          {
            "group": "请求参数",
            "type": "String",
            "optional": false,
            "field": "counselorName",
            "description": ""
          },
          {
            "group": "请求参数",
            "type": "Number",
            "optional": false,
            "field": "graduation",
            "description": ""
          },
          {
            "group": "请求参数",
            "type": "String",
            "optional": false,
            "field": "address",
            "description": ""
          }
        ]
      },
      "examples": [
        {
          "title": "请求参数示例",
          "content": "counselorName=李老师&address=上海市XX区XX路&graduation=0&mobile=13800000000&degree=研究生&fullTime=0&department=软件学院&userId=20262010001",
          "type": "json"
        }
      ]
    },
    "success": {
      "fields": {
        "响应结果": [
          {
            "group": "响应结果",
            "type": "Object",
            "optional": false,
            "field": "response",
            "description": ""
          }
        ]
      },
      "examples": [
        {
          "title": "响应结果示例",
          "content": "{}",
          "type": "json"
        }
      ]
    },
    "filename": "src/main/java/com/fdu/pjserver/controller/StudentInfoController.java",
    "groupTitle": "学生基本信息"
  },
  {
    "type": "POST",
    "url": "/user/add",
    "title": "add",
    "version": "1.0.0",
    "group": "用户",
    "name": "add",
    "description": "<p>创建用户</p>",
    "parameter": {
      "fields": {
        "请求参数": [
          {
            "group": "请求参数",
            "type": "String",
            "optional": false,
            "field": "userId",
            "description": "<p>用户ID（学号或管理员账号）</p>"
          },
          {
            "group": "请求参数",
            "type": "String",
            "optional": false,
            "field": "userName",
            "description": "<p>姓名</p>"
          },
          {
            "group": "请求参数",
            "type": "String",
            "optional": false,
            "field": "mobile",
            "description": "<p>手机号</p>"
          },
          {
            "group": "请求参数",
            "type": "String",
            "optional": false,
            "field": "pwd",
            "description": "<p>密码</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "请求参数示例",
          "content": "userName=张三&pwd=123&userId=20262010001",
          "type": "json"
        }
      ]
    },
    "success": {
      "fields": {
        "响应结果": [
          {
            "group": "响应结果",
            "type": "Object",
            "optional": false,
            "field": "response",
            "description": ""
          }
        ]
      },
      "examples": [
        {
          "title": "响应结果示例",
          "content": "{}",
          "type": "json"
        }
      ]
    },
    "filename": "src/main/java/com/fdu/pjserver/controller/UserController.java",
    "groupTitle": "用户"
  },
  {
    "type": "POST",
    "url": "/user/get",
    "title": "get",
    "version": "1.0.0",
    "group": "用户",
    "name": "get",
    "description": "<p>获取用户信息</p>",
    "parameter": {
      "fields": {
        "请求参数": [
          {
            "group": "请求参数",
            "type": "String",
            "optional": false,
            "field": "userId",
            "description": ""
          }
        ]
      },
      "examples": [
        {
          "title": "请求参数示例",
          "content": "userId=Y7kmt",
          "type": "json"
        }
      ]
    },
    "success": {
      "fields": {
        "响应结果": [
          {
            "group": "响应结果",
            "type": "Object",
            "optional": false,
            "field": "response",
            "description": ""
          }
        ]
      },
      "examples": [
        {
          "title": "响应结果示例",
          "content": "{}",
          "type": "json"
        }
      ]
    },
    "filename": "src/main/java/com/fdu/pjserver/controller/UserController.java",
    "groupTitle": "用户"
  },
  {
    "type": "GET",
    "url": "/user/get_all",
    "title": "getALL",
    "version": "1.0.0",
    "group": "用户",
    "name": "getALL",
    "description": "<p>获取所有用户信息</p>",
    "success": {
      "fields": {
        "响应结果": [
          {
            "group": "响应结果",
            "type": "Object",
            "optional": false,
            "field": "response",
            "description": ""
          }
        ]
      },
      "examples": [
        {
          "title": "响应结果示例",
          "content": "{}",
          "type": "json"
        }
      ]
    },
    "filename": "src/main/java/com/fdu/pjserver/controller/UserController.java",
    "groupTitle": "用户"
  },
  {
    "type": "POST",
    "url": "/user/login",
    "title": "login",
    "version": "1.0.0",
    "group": "用户",
    "name": "login",
    "description": "<p>用户登陆</p>",
    "parameter": {
      "fields": {
        "请求参数": [
          {
            "group": "请求参数",
            "type": "String",
            "optional": false,
            "field": "userId",
            "description": ""
          },
          {
            "group": "请求参数",
            "type": "String",
            "optional": false,
            "field": "pwd",
            "description": ""
          }
        ]
      },
      "examples": [
        {
          "title": "请求参数示例",
          "content": "pwd=123&userId=20262010001",
          "type": "json"
        }
      ]
    },
    "success": {
      "fields": {
        "响应结果": [
          {
            "group": "响应结果",
            "type": "Object",
            "optional": false,
            "field": "response",
            "description": ""
          }
        ]
      },
      "examples": [
        {
          "title": "响应结果示例",
          "content": "{}",
          "type": "json"
        }
      ]
    },
    "filename": "src/main/java/com/fdu/pjserver/controller/UserController.java",
    "groupTitle": "用户"
  },
  {
    "type": "POST",
    "url": "/user/modifyInfo",
    "title": "modifyInfo",
    "version": "1.0.0",
    "group": "用户",
    "name": "modifyInfo",
    "description": "<p>修改用户姓名</p>",
    "parameter": {
      "fields": {
        "请求参数": [
          {
            "group": "请求参数",
            "type": "String",
            "optional": false,
            "field": "userId",
            "description": ""
          },
          {
            "group": "请求参数",
            "type": "String",
            "optional": false,
            "field": "userName",
            "description": ""
          }
        ]
      },
      "examples": [
        {
          "title": "请求参数示例",
          "content": "userName=李四&userId=20262010001",
          "type": "json"
        }
      ]
    },
    "success": {
      "fields": {
        "响应结果": [
          {
            "group": "响应结果",
            "type": "Object",
            "optional": false,
            "field": "response",
            "description": ""
          }
        ]
      },
      "examples": [
        {
          "title": "响应结果示例",
          "content": "{}",
          "type": "json"
        }
      ]
    },
    "filename": "src/main/java/com/fdu/pjserver/controller/UserController.java",
    "groupTitle": "用户"
  },
  {
    "type": "POST",
    "url": "/user/modifyPwd",
    "title": "modifyPassword",
    "version": "1.0.0",
    "group": "用户",
    "name": "modifyPassword",
    "description": "<p>修改密码</p>",
    "parameter": {
      "fields": {
        "请求参数": [
          {
            "group": "请求参数",
            "type": "String",
            "optional": false,
            "field": "userId",
            "description": ""
          },
          {
            "group": "请求参数",
            "type": "String",
            "optional": false,
            "field": "newPw",
            "description": ""
          }
        ]
      },
      "examples": [
        {
          "title": "请求参数示例",
          "content": "newPw=123456&userId=20262010001",
          "type": "json"
        }
      ]
    },
    "success": {
      "fields": {
        "响应结果": [
          {
            "group": "响应结果",
            "type": "Object",
            "optional": false,
            "field": "response",
            "description": ""
          }
        ]
      },
      "examples": [
        {
          "title": "响应结果示例",
          "content": "{}",
          "type": "json"
        }
      ]
    },
    "filename": "src/main/java/com/fdu/pjserver/controller/UserController.java",
    "groupTitle": "用户"
  },
  {
    "type": "GET",
    "url": "/user/update_pwd",
    "title": "updatePwd",
    "version": "1.0.0",
    "group": "用户",
    "name": "updatePwd",
    "description": "<p>根据手机号修改密码</p>",
    "parameter": {
      "fields": {
        "请求参数": [
          {
            "group": "请求参数",
            "type": "String",
            "optional": false,
            "field": "userId",
            "description": ""
          },
          {
            "group": "请求参数",
            "type": "String",
            "optional": false,
            "field": "mobile",
            "description": ""
          },
          {
            "group": "请求参数",
            "type": "String",
            "optional": false,
            "field": "newPwd",
            "description": ""
          }
        ]
      },
      "examples": [
        {
          "title": "请求参数示例",
          "content": "newPwd=1234&mobile=13800000000&userId=20262010000",
          "type": "json"
        }
      ]
    },
    "success": {
      "fields": {
        "响应结果": [
          {
            "group": "响应结果",
            "type": "Object",
            "optional": false,
            "field": "response",
            "description": ""
          }
        ]
      },
      "examples": [
        {
          "title": "响应结果示例",
          "content": "{\n    \"msg\": \"手机号不正确\",\n    \"code\": 500\n}\n{\n    \"msg\": \"用户不存在\",\n    \"code\": 500\n}",
          "type": "json"
        }
      ]
    },
    "filename": "src/main/java/com/fdu/pjserver/controller/UserController.java",
    "groupTitle": "用户"
  },
  {
    "type": "POST",
    "url": "/report/add",
    "title": "add",
    "version": "1.0.0",
    "group": "疫情上报数据",
    "name": "add",
    "description": "<p>新增疫情上报数据</p>",
    "parameter": {
      "fields": {
        "请求参数": [
          {
            "group": "请求参数",
            "type": "String",
            "optional": false,
            "field": "userId",
            "description": "<p>学生用户id</p>"
          },
          {
            "group": "请求参数",
            "type": "Number",
            "optional": false,
            "field": "reportDate",
            "description": "<p>上报日期</p>"
          },
          {
            "group": "请求参数",
            "type": "Number",
            "optional": false,
            "field": "hasFever",
            "description": "<p>是否有发烧症状</p>"
          },
          {
            "group": "请求参数",
            "type": "Number",
            "optional": false,
            "field": "atSchool",
            "description": "<p>是否在校</p>"
          },
          {
            "group": "请求参数",
            "type": "Number",
            "optional": false,
            "field": "temperatureRange",
            "description": "<p>体温范围0:正常,1:37.3-38,2:38以上</p>"
          },
          {
            "group": "请求参数",
            "type": "Number",
            "optional": false,
            "field": "hasCough",
            "description": "<p>是否咳嗽</p>"
          },
          {
            "group": "请求参数",
            "type": "Number",
            "optional": false,
            "field": "atIsolation",
            "description": "<p>是否处于隔离期</p>"
          },
          {
            "group": "请求参数",
            "type": "Number",
            "optional": false,
            "field": "hasRiskContact",
            "description": "<p>是否与国内中高风险地区人员有较为密切的接触</p>"
          },
          {
            "group": "请求参数",
            "type": "Number",
            "optional": false,
            "field": "hasInfectedContact",
            "description": "<p>是否接触确诊/疑似人群</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "请求参数示例",
          "content": "temperatureRange=0&reportDate=2020/12/23&hasFever=1&hasCough=1&atSchool=1&userId=20262010002&atIsolation=1&hasRiskContact=1&hasInfectedContact=1",
          "type": "json"
        }
      ]
    },
    "success": {
      "fields": {
        "响应结果": [
          {
            "group": "响应结果",
            "type": "Object",
            "optional": false,
            "field": "response",
            "description": ""
          }
        ]
      },
      "examples": [
        {
          "title": "响应结果示例",
          "content": "{}",
          "type": "json"
        }
      ]
    },
    "filename": "src/main/java/com/fdu/pjserver/controller/DailyReportController.java",
    "groupTitle": "疫情上报数据"
  },
  {
    "type": "POST",
    "url": "/report/range_abnormal_analysis",
    "title": "analysisDateRank",
    "version": "1.0.0",
    "group": "疫情上报数据",
    "name": "analysisDateRank",
    "description": "<p>日期区间内异常数据</p>",
    "parameter": {
      "fields": {
        "请求参数": [
          {
            "group": "请求参数",
            "type": "Number",
            "optional": false,
            "field": "oldDate",
            "description": "<p>起始日</p>"
          },
          {
            "group": "请求参数",
            "type": "Number",
            "optional": false,
            "field": "newDate",
            "description": "<p>结束日</p>"
          },
          {
            "group": "请求参数",
            "type": "String",
            "optional": false,
            "field": "type",
            "description": ""
          }
        ]
      },
      "examples": [
        {
          "title": "请求参数示例",
          "content": "oldDate=2020/12/01&type=cough&newDate=2020/12/23",
          "type": "json"
        }
      ]
    },
    "success": {
      "fields": {
        "响应结果": [
          {
            "group": "响应结果",
            "type": "Object",
            "optional": false,
            "field": "response",
            "description": "<p>取值区间on_time,at_school,temp,cough,isolation,risk_cont,infected_cont</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "响应结果示例",
          "content": "{\n    \"msg\": \"操作成功\",\n    \"code\": 200,\n    \"data\": [\n        {\n            \"2020-12-01\": 1\n        },\n        {\n            \"2020-12-23\": 1\n        }\n    ]\n}",
          "type": "json"
        }
      ]
    },
    "filename": "src/main/java/com/fdu/pjserver/controller/DailyReportController.java",
    "groupTitle": "疫情上报数据"
  },
  {
    "type": "POST",
    "url": "/report/day_analysis",
    "title": "analysisDay",
    "version": "1.0.0",
    "group": "疫情上报数据",
    "name": "analysisDay",
    "description": "<p>当日数据分析接口</p>",
    "parameter": {
      "fields": {
        "请求参数": [
          {
            "group": "请求参数",
            "type": "Number",
            "optional": false,
            "field": "reportDate",
            "description": ""
          },
          {
            "group": "请求参数",
            "type": "String",
            "optional": false,
            "field": "type",
            "description": "<p>取值区间on_time,at_school,temp,cough,isolation,risk_cont,infected_cont</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "请求参数示例",
          "content": "reportDate=2020/12/23&type=isolation",
          "type": "json"
        }
      ]
    },
    "success": {
      "fields": {
        "响应结果": [
          {
            "group": "响应结果",
            "type": "Object",
            "optional": false,
            "field": "response",
            "description": "<p>data字段中一般为not_report_users,true,false三个字段，分别表示当日未上报、当前请求分析字段为1/0的数据。 如果type取值为temp，返回normal,mid,high三个字段表示体温的三个区间</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "响应结果示例",
          "content": "{\n\"msg\": \"操作成功\",\n\"code\": 200,\n\"data\": {\n\"not_report_users\": [],\n\"true\": [\n{\n\"userId\": \"20262010002\",\n\"reportDate\": \"2020-12-23T00:00:00.000+08:00\",\n\"hasFever\": 1,\n\"atSchool\": 1,\n\"temperatureRange\": 0,\n\"hasCough\": 1,\n\"atIsolation\": 1,\n\"hasRiskContact\": 1,\n\"hasInfectedContact\": 1,\n\"userName\": \"李四\"\n}\n],\n\"false\": [\n{\n\"userId\": \"20262010001\",\n\"reportDate\": \"2020-12-23T00:00:00.000+08:00\",\n\"hasFever\": 0,\n\"atSchool\": 0,\n\"temperatureRange\": 1,\n\"hasCough\": 0,\n\"atIsolation\": 0,\n\"hasRiskContact\": 0,\n\"hasInfectedContact\": 0,\n\"userName\": \"张三\"\n}\n]\n}\n}",
          "type": "json"
        }
      ]
    },
    "filename": "src/main/java/com/fdu/pjserver/controller/DailyReportController.java",
    "groupTitle": "疫情上报数据"
  },
  {
    "type": "POST",
    "url": "/report/get_reports_by_date",
    "title": "getReportsByDate",
    "version": "1.0.0",
    "group": "疫情上报数据",
    "name": "getReportsByDate",
    "description": "<p>获取某天学生疫情上报数据，并返回未上报用户信息</p>",
    "parameter": {
      "fields": {
        "请求参数": [
          {
            "group": "请求参数",
            "type": "Number",
            "optional": false,
            "field": "reportDate",
            "description": ""
          }
        ]
      },
      "examples": [
        {
          "title": "请求参数示例",
          "content": "reportDate=2020/12/01",
          "type": "json"
        }
      ]
    },
    "success": {
      "fields": {
        "响应结果": [
          {
            "group": "响应结果",
            "type": "Object",
            "optional": false,
            "field": "response",
            "description": ""
          }
        ]
      },
      "examples": [
        {
          "title": "响应结果示例",
          "content": "{\n\"msg\": \"操作成功\",\n\"code\": 200,\n\"data\": {\n\"not_report_users\": [\n{\n\"userId\": \"20262010001\",\n\"userName\": \"张三\",\n\"pwd\": \"123\",\n\"status\": 1,\n\"createTime\": \"2020-12-22T01:30:51.000+08:00\",\n\"createBy\": \"System\",\n\"updateTime\": \"2020-12-22T01:30:51.000+08:00\",\n\"updateBy\": \"System\",\n\"mobile\": \"13800000000\",\n\"department\": \"软件学院\",\n\"degree\": \"研究生\",\n\"fullTime\": 0,\n\"counselorName\": \"李老师\",\n\"graduation\": 1,\n\"address\": \"上海市XX区XX路\"\n}\n],\n\"report\": [\n{\n\"userId\": \"20262010002\",\n\"reportDate\": \"2020-12-01T00:00:00.000+08:00\",\n\"hasFever\": 1,\n\"atSchool\": 1,\n\"temperatureRange\": 0,\n\"hasCough\": 1,\n\"atIsolation\": 1,\n\"hasRiskContact\": 1,\n\"hasInfectedContact\": 1,\n\"userName\": \"李四\"\n}\n]\n}\n}",
          "type": "json"
        }
      ]
    },
    "filename": "src/main/java/com/fdu/pjserver/controller/DailyReportController.java",
    "groupTitle": "疫情上报数据"
  },
  {
    "type": "POST",
    "url": "/report/get_user_reports",
    "title": "getUserReport",
    "version": "1.0.0",
    "group": "疫情上报数据",
    "name": "getUserReport",
    "description": "<p>获取某个学生所有疫情上报数据</p>",
    "parameter": {
      "fields": {
        "请求参数": [
          {
            "group": "请求参数",
            "type": "String",
            "optional": false,
            "field": "userId",
            "description": ""
          }
        ]
      },
      "examples": [
        {
          "title": "请求参数示例",
          "content": "userId=20262010001",
          "type": "json"
        }
      ]
    },
    "success": {
      "fields": {
        "响应结果": [
          {
            "group": "响应结果",
            "type": "Object",
            "optional": false,
            "field": "response",
            "description": ""
          }
        ]
      },
      "examples": [
        {
          "title": "响应结果示例",
          "content": "{}",
          "type": "json"
        }
      ]
    },
    "filename": "src/main/java/com/fdu/pjserver/controller/DailyReportController.java",
    "groupTitle": "疫情上报数据"
  },
  {
    "type": "POST",
    "url": "/report/get_user_single_report",
    "title": "getUserSingleReport",
    "version": "1.0.0",
    "group": "疫情上报数据",
    "name": "getUserReport",
    "description": "<p>获取某个学生某天疫情上报数据</p>",
    "parameter": {
      "fields": {
        "请求参数": [
          {
            "group": "请求参数",
            "type": "String",
            "optional": false,
            "field": "userId",
            "description": ""
          },
          {
            "group": "请求参数",
            "type": "Number",
            "optional": false,
            "field": "reportDate",
            "description": ""
          }
        ]
      },
      "examples": [
        {
          "title": "请求参数示例",
          "content": "reportDate=2020/12/23&userId=20262010002",
          "type": "json"
        }
      ]
    },
    "success": {
      "fields": {
        "响应结果": [
          {
            "group": "响应结果",
            "type": "Object",
            "optional": false,
            "field": "response",
            "description": ""
          }
        ]
      },
      "examples": [
        {
          "title": "响应结果示例",
          "content": "{}",
          "type": "json"
        }
      ]
    },
    "filename": "src/main/java/com/fdu/pjserver/controller/DailyReportController.java",
    "groupTitle": "疫情上报数据"
  },
  {
    "type": "POST",
    "url": "/report/update",
    "title": "update",
    "version": "1.0.0",
    "group": "疫情上报数据",
    "name": "update",
    "description": "<p>更新疫情上报数据</p>",
    "parameter": {
      "fields": {
        "请求参数": [
          {
            "group": "请求参数",
            "type": "String",
            "optional": false,
            "field": "userId",
            "description": ""
          },
          {
            "group": "请求参数",
            "type": "Number",
            "optional": false,
            "field": "reportDate",
            "description": ""
          },
          {
            "group": "请求参数",
            "type": "Number",
            "optional": false,
            "field": "hasFever",
            "description": ""
          },
          {
            "group": "请求参数",
            "type": "Number",
            "optional": false,
            "field": "atSchool",
            "description": ""
          },
          {
            "group": "请求参数",
            "type": "Number",
            "optional": false,
            "field": "temperatureRange",
            "description": ""
          },
          {
            "group": "请求参数",
            "type": "Number",
            "optional": false,
            "field": "hasCough",
            "description": ""
          },
          {
            "group": "请求参数",
            "type": "Number",
            "optional": false,
            "field": "atIsolation",
            "description": ""
          },
          {
            "group": "请求参数",
            "type": "Number",
            "optional": false,
            "field": "hasRiskContact",
            "description": ""
          },
          {
            "group": "请求参数",
            "type": "Number",
            "optional": false,
            "field": "hasInfectedContact",
            "description": ""
          }
        ]
      },
      "examples": [
        {
          "title": "请求参数示例",
          "content": "temperatureRange=0&reportDate=2020/12/23&hasFever=1&hasCough=1&atSchool=1&userId=20262010002&atIsolation=1&hasRiskContact=1&hasInfectedContact=1",
          "type": "json"
        }
      ]
    },
    "success": {
      "fields": {
        "响应结果": [
          {
            "group": "响应结果",
            "type": "Object",
            "optional": false,
            "field": "response",
            "description": ""
          }
        ]
      },
      "examples": [
        {
          "title": "响应结果示例",
          "content": "{}",
          "type": "json"
        }
      ]
    },
    "filename": "src/main/java/com/fdu/pjserver/controller/DailyReportController.java",
    "groupTitle": "疫情上报数据"
  }
] });
