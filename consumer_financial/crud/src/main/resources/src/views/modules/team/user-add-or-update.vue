<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="用户邮箱" prop="tEmail">
      <el-input v-model="dataForm.tEmail" placeholder="用户邮箱"></el-input>
    </el-form-item>
    <el-form-item label="邮箱验证" prop="tEmailStatus">
      <el-input v-model="dataForm.tEmailStatus" placeholder="邮箱验证"></el-input>
    </el-form-item>
    <el-form-item label="用户id" prop="tIdentity">
      <el-input v-model="dataForm.tIdentity" placeholder="用户id"></el-input>
    </el-form-item>
    <el-form-item label="邀请码" prop="tInvtteid">
      <el-input v-model="dataForm.tInvtteid" placeholder="邀请码"></el-input>
    </el-form-item>
    <el-form-item label="登录ip" prop="tIp">
      <el-input v-model="dataForm.tIp" placeholder="登录ip"></el-input>
    </el-form-item>
    <el-form-item label="登录时间" prop="tLoginTime">
      <el-input v-model="dataForm.tLoginTime" placeholder="登录时间"></el-input>
    </el-form-item>
    <el-form-item label="锁" prop="tOnlock">
      <el-input v-model="dataForm.tOnlock" placeholder="锁"></el-input>
    </el-form-item>
    <el-form-item label="登录密码" prop="tPassword">
      <el-input v-model="dataForm.tPassword" placeholder="登录密码"></el-input>
    </el-form-item>
    <el-form-item label="支付密码" prop="tPayPassword">
      <el-input v-model="dataForm.tPayPassword" placeholder="支付密码"></el-input>
    </el-form-item>
    <el-form-item label="支付密码验证" prop="tPayPwdStatus">
      <el-input v-model="dataForm.tPayPwdStatus" placeholder="支付密码验证"></el-input>
    </el-form-item>
    <el-form-item label="电话" prop="tPhone">
      <el-input v-model="dataForm.tPhone" placeholder="电话"></el-input>
    </el-form-item>
    <el-form-item label="手机验证" prop="tPhoneStatus">
      <el-input v-model="dataForm.tPhoneStatus" placeholder="手机验证"></el-input>
    </el-form-item>
    <el-form-item label="随机激活码" prop="tRandomCode">
      <el-input v-model="dataForm.tRandomCode" placeholder="随机激活码"></el-input>
    </el-form-item>
    <el-form-item label="真实姓名" prop="tRealname">
      <el-input v-model="dataForm.tRealname" placeholder="真实姓名"></el-input>
    </el-form-item>
    <el-form-item label="实名验证" prop="tRealnameStatus">
      <el-input v-model="dataForm.tRealnameStatus" placeholder="实名验证"></el-input>
    </el-form-item>
    <el-form-item label="注册时间" prop="tRegesterTime">
      <el-input v-model="dataForm.tRegesterTime" placeholder="注册时间"></el-input>
    </el-form-item>
    <el-form-item label="备注" prop="tRemark">
      <el-input v-model="dataForm.tRemark" placeholder="备注"></el-input>
    </el-form-item>
    <el-form-item label="好友数量统计" prop="tSumfriend">
      <el-input v-model="dataForm.tSumfriend" placeholder="好友数量统计"></el-input>
    </el-form-item>
    <el-form-item label="安全等级" prop="tUserSecure">
      <el-input v-model="dataForm.tUserSecure" placeholder="安全等级"></el-input>
    </el-form-item>
    <el-form-item label="用户类型0投资人1借款人" prop="tUsertype">
      <el-input v-model="dataForm.tUsertype" placeholder="用户类型0投资人1借款人"></el-input>
    </el-form-item>
    <el-form-item label="用户登录名" prop="tUsername">
      <el-input v-model="dataForm.tUsername" placeholder="用户登录名"></el-input>
    </el-form-item>
    </el-form>
    <span slot="footer" class="dialog-footer">
      <el-button @click="visible = false">取消</el-button>
      <el-button type="primary" @click="dataFormSubmit()">确定</el-button>
    </span>
  </el-dialog>
</template>

<script>
  export default {
    data () {
      return {
        visible: false,
        dataForm: {
          tId: 0,
          tEmail: '',
          tEmailStatus: '',
          tIdentity: '',
          tInvtteid: '',
          tIp: '',
          tLoginTime: '',
          tOnlock: '',
          tPassword: '',
          tPayPassword: '',
          tPayPwdStatus: '',
          tPhone: '',
          tPhoneStatus: '',
          tRandomCode: '',
          tRealname: '',
          tRealnameStatus: '',
          tRegesterTime: '',
          tRemark: '',
          tSumfriend: '',
          tUserSecure: '',
          tUsertype: '',
          tUsername: ''
        },
        dataRule: {
          tEmail: [
            { required: true, message: '用户邮箱不能为空', trigger: 'blur' }
          ],
          tEmailStatus: [
            { required: true, message: '邮箱验证不能为空', trigger: 'blur' }
          ],
          tIdentity: [
            { required: true, message: '用户id不能为空', trigger: 'blur' }
          ],
          tInvtteid: [
            { required: true, message: '邀请码不能为空', trigger: 'blur' }
          ],
          tIp: [
            { required: true, message: '登录ip不能为空', trigger: 'blur' }
          ],
          tLoginTime: [
            { required: true, message: '登录时间不能为空', trigger: 'blur' }
          ],
          tOnlock: [
            { required: true, message: '锁不能为空', trigger: 'blur' }
          ],
          tPassword: [
            { required: true, message: '登录密码不能为空', trigger: 'blur' }
          ],
          tPayPassword: [
            { required: true, message: '支付密码不能为空', trigger: 'blur' }
          ],
          tPayPwdStatus: [
            { required: true, message: '支付密码验证不能为空', trigger: 'blur' }
          ],
          tPhone: [
            { required: true, message: '电话不能为空', trigger: 'blur' }
          ],
          tPhoneStatus: [
            { required: true, message: '手机验证不能为空', trigger: 'blur' }
          ],
          tRandomCode: [
            { required: true, message: '随机激活码不能为空', trigger: 'blur' }
          ],
          tRealname: [
            { required: true, message: '真实姓名不能为空', trigger: 'blur' }
          ],
          tRealnameStatus: [
            { required: true, message: '实名验证不能为空', trigger: 'blur' }
          ],
          tRegesterTime: [
            { required: true, message: '注册时间不能为空', trigger: 'blur' }
          ],
          tRemark: [
            { required: true, message: '备注不能为空', trigger: 'blur' }
          ],
          tSumfriend: [
            { required: true, message: '好友数量统计不能为空', trigger: 'blur' }
          ],
          tUserSecure: [
            { required: true, message: '安全等级不能为空', trigger: 'blur' }
          ],
          tUsertype: [
            { required: true, message: '用户类型0投资人1借款人不能为空', trigger: 'blur' }
          ],
          tUsername: [
            { required: true, message: '用户登录名不能为空', trigger: 'blur' }
          ]
        }
      }
    },
    methods: {
      init (id) {
        this.dataForm.tId = id || 0
        this.visible = true
        this.$nextTick(() => {
          this.$refs['dataForm'].resetFields()
          if (this.dataForm.tId) {
            this.$http({
              url: this.$http.adornUrl(`/team/user/info/${this.dataForm.tId}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.tEmail = data.user.tEmail
                this.dataForm.tEmailStatus = data.user.tEmailStatus
                this.dataForm.tIdentity = data.user.tIdentity
                this.dataForm.tInvtteid = data.user.tInvtteid
                this.dataForm.tIp = data.user.tIp
                this.dataForm.tLoginTime = data.user.tLoginTime
                this.dataForm.tOnlock = data.user.tOnlock
                this.dataForm.tPassword = data.user.tPassword
                this.dataForm.tPayPassword = data.user.tPayPassword
                this.dataForm.tPayPwdStatus = data.user.tPayPwdStatus
                this.dataForm.tPhone = data.user.tPhone
                this.dataForm.tPhoneStatus = data.user.tPhoneStatus
                this.dataForm.tRandomCode = data.user.tRandomCode
                this.dataForm.tRealname = data.user.tRealname
                this.dataForm.tRealnameStatus = data.user.tRealnameStatus
                this.dataForm.tRegesterTime = data.user.tRegesterTime
                this.dataForm.tRemark = data.user.tRemark
                this.dataForm.tSumfriend = data.user.tSumfriend
                this.dataForm.tUserSecure = data.user.tUserSecure
                this.dataForm.tUsertype = data.user.tUsertype
                this.dataForm.tUsername = data.user.tUsername
              }
            })
          }
        })
      },
      // 表单提交
      dataFormSubmit () {
        this.$refs['dataForm'].validate((valid) => {
          if (valid) {
            this.$http({
              url: this.$http.adornUrl(`/team/user/${!this.dataForm.tId ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'tId': this.dataForm.tId || undefined,
                'tEmail': this.dataForm.tEmail,
                'tEmailStatus': this.dataForm.tEmailStatus,
                'tIdentity': this.dataForm.tIdentity,
                'tInvtteid': this.dataForm.tInvtteid,
                'tIp': this.dataForm.tIp,
                'tLoginTime': this.dataForm.tLoginTime,
                'tOnlock': this.dataForm.tOnlock,
                'tPassword': this.dataForm.tPassword,
                'tPayPassword': this.dataForm.tPayPassword,
                'tPayPwdStatus': this.dataForm.tPayPwdStatus,
                'tPhone': this.dataForm.tPhone,
                'tPhoneStatus': this.dataForm.tPhoneStatus,
                'tRandomCode': this.dataForm.tRandomCode,
                'tRealname': this.dataForm.tRealname,
                'tRealnameStatus': this.dataForm.tRealnameStatus,
                'tRegesterTime': this.dataForm.tRegesterTime,
                'tRemark': this.dataForm.tRemark,
                'tSumfriend': this.dataForm.tSumfriend,
                'tUserSecure': this.dataForm.tUserSecure,
                'tUsertype': this.dataForm.tUsertype,
                'tUsername': this.dataForm.tUsername
              })
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.$message({
                  message: '操作成功',
                  type: 'success',
                  duration: 1500,
                  onClose: () => {
                    this.visible = false
                    this.$emit('refreshDataList')
                  }
                })
              } else {
                this.$message.error(data.msg)
              }
            })
          }
        })
      }
    }
  }
</script>
