<template>
<div>
    <el-button type="success" round>
      修改个人信息
    </el-button>
    <br></br>
    <fever></fever>
    <br></br>
    <inschool></inschool>
    <br></br>
    <temperature></temperature>
    <br></br>
    <cough></cough>
    <br></br>
    <risk></risk>
    <br></br>
    <inquarantine></inquarantine>
    <br></br>
    <contantpatient></contantpatient>    
    <br></br>
    <el-button type="success" round :disabled="issubmited" @click.native="handlesubmit">
      提交
    </el-button>
</div>
</template>
<script>
    import {inforeport} from '@/api/report'
    import place from '@/components/place'
    import fever from '@/components/fever'
    import inschool from '@/components/inschool'
    import temperature from '@/components/temperature'
    import cough from '@/components/cough'
    import risk from '@/components/risk'
    import inquarantine from '@/components/inquarantine'
    import contantpatient from '@/components/contantpatient'
    export default {
    data() {
      return {
        issubmited:false
      };
    },
    created(){
      if(null === sessionStorage.getItem("issubmited"))
      {
        this.issubmited=false;
      }
      else{
        this.issubmited=true;
      }
      console.log(this.issubmited);
    },
    methods: {        
        handlesubmit()
        {
          if(0 === this.checkelement())
          {
            console.log("submit fail");;
          }
          else
          {
            alert("提交成功");
            sessionStorage.setItem("issubmited",true);
            this.issubmited = true;
            console.log(sessionStorage.getItem("username"));
            console.log(sessionStorage.getItem("isfever"));
            console.log(sessionStorage.getItem("isinschool"));
            console.log(sessionStorage.getItem("iscontantpatient"));
            console.log(sessionStorage.getItem("iscough"));
            console.log(sessionStorage.getItem("isinquarantine"));
            console.log(sessionStorage.getItem("isinrisk"));
            console.log(sessionStorage.getItem("temperature"));
            inforeport(sessionStorage.getItem("username"),
                sessionStorage.getItem("isfever"),
                sessionStorage.getItem("isinschool"),
                sessionStorage.getItem("iscontantpatient"),
                sessionStorage.getItem("iscough"),
                sessionStorage.getItem("isinquarantine"),
                sessionStorage.getItem("isinrisk"),
                sessionStorage.getItem("temperature")).then(response => {
                  const res = response.data;
                  console.log(res, res.flag, res.data.token, res.message);
                  })
            .catch(() => {
              console.log("failed");
              this.issubmited = false;
               this.$router.push("/pieview");
            });
          }
          
        },
        checkelement(){
          if(null === sessionStorage.getItem("iscontantpatient")){
            alert("请选择今日是否与确诊/疑似人群接触");
            return 0;
          }
          return 1;
        }
    },
    components: { place,fever,inschool,temperature,cough,risk,inquarantine,contantpatient }
  }

</script>

