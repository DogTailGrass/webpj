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
          "content": "title=公告2&content=lll&status=1&validDate=2020/12/23 23:24:46&validTime=1608737086",
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
    "url": "/notice/get",
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
          "content": "validDate=2020/12/23 23:24:46&validTime=1608737086&id=7159&title=标题&content=巴拉巴拉&status=1",
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
            "description": ""
          },
          {
            "group": "请求参数",
            "type": "String",
            "optional": false,
            "field": "userName",
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
    "description": "<p>修改用户名</p>",
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
  }
] });
