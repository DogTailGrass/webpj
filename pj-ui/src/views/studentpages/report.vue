<template>
<div>
    <el-dialog title="备注" :visible.sync="dialogVisible" :close-on-click-modal="true" :modal="true" :show-close="true" :center="true">
      <el-input v-model="comment" type="textarea" :rows="15" placeholder="请输入内容"></el-input>
      <span slot="footer" class="dialog-footer">
        <el-button @click.native="handledialogcancel">取 消</el-button>
        <el-button type="primary" @click.native="handledialogconfim">确 定</el-button>
      </span>
    </el-dialog>
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
    <el-button type="success" round @click.native="dialogVisible=true">
      备注
    </el-button>
    <br></br>
    <el-button type="success" round :disabled="issubmited" @click.native="handlesubmit">
      提交
    </el-button>
    <li>今日是否发烧</li>
    <el-radio v-model="is_fever" label="0">否</el-radio>
    <el-radio v-model="is_fever" label="1">是</el-radio>
    <br></br>
    <li>今日是否咳嗽</li>
    <el-radio v-model="is_cough" label="0">否</el-radio>
    <el-radio v-model="is_cough" label="1">是</el-radio>

</div>
</template>
<script>
    import {inforeport} from '@/api/studentapi/pushreport'
    import place from '@/components/place'
    import fever from '@/components/fever'
    import inschool from '@/components/inschool'
    import temperature from '@/components/temperature'
    import cough from '@/components/cough'
    import risk from '@/components/risk'
    import inquarantine from '@/components/inquarantine'
    import contantpatient from '@/components/contantpatient'
    import PersonalInformation from './personalinfo'
    export default {
    data() {
      return {
        issubmited:false,
        dialogVisible:false,
        comment:'',
        is_fever:'',
        is_cough:'',
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
            let report={};
            report.isfever = sessionStorage.getItem("isfever");
            report.isinschool = sessionStorage.getItem("isinschool");
            report.iscontantpatient = sessionStorage.getItem("iscontantpatient");
            report.iscough = sessionStorage.getItem("iscough");
            report.isinquarantine = sessionStorage.getItem("isinquarantine");
            report.isinrisk = sessionStorage.getItem("isinrisk");
            report.temperature = sessionStorage.getItem("temperature");
            report.comment = this.comment;
            inforeport(sessionStorage.getItem("user_id"),
                report).then(response => {
                  const res = response.data;
                  if(res.flag){
                    alert("提交成功");
                    sessionStorage.setItem("issubmited",true);
                    this.issubmited = true;
                  }
                  //console.log(res, res.flag, res.data.token, res.message);
                  })
            .catch(() => {
              console.log("failed");
              alert("提交失败");
              //sessionStorage.setItem("issubmited",true);
              //this.issubmited = true;
            });
          }
          
        },
        checkelement(){
          if(null === sessionStorage.getItem("iscontantpatient")){
            alert("请选择今日是否与确诊/疑似人群接触");
            return 0;
          }
          return 1;
        },
        handledialogcancel(){
          this.dialogVisible = false;
          console.log(this.comment);
          this.comment = '';
        },
        handledialogconfim(){
          this.dialogVisible = false;
          console.log(this.comment);
        }
    },
    components: { place,fever,inschool,temperature,cough,risk,inquarantine,contantpatient,PersonalInformation }
  }

</script>

