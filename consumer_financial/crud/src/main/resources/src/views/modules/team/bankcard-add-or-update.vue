<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="银行卡号长度18位" prop="tNum">
      <el-input v-model="dataForm.tNum" placeholder="银行卡号长度18位"></el-input>
    </el-form-item>
    <el-form-item label="开户银行" prop="tBank">
      <el-input v-model="dataForm.tBank" placeholder="开户银行"></el-input>
    </el-form-item>
    <el-form-item label="城市Id" prop="tCityId">
      <el-input v-model="dataForm.tCityId" placeholder="城市Id"></el-input>
    </el-form-item>
    <el-form-item label="用户表主键" prop="tUserId">
      <el-input v-model="dataForm.tUserId" placeholder="用户表主键"></el-input>
    </el-form-item>
    <el-form-item label="银行编号" prop="tBankId">
      <el-input v-model="dataForm.tBankId" placeholder="银行编号"></el-input>
    </el-form-item>
    <el-form-item label="银行支行" prop="tBankBranch">
      <el-input v-model="dataForm.tBankBranch" placeholder="银行支行"></el-input>
    </el-form-item>
    <el-form-item label="绑定手机号码" prop="tPhoneNum">
      <el-input v-model="dataForm.tPhoneNum" placeholder="绑定手机号码"></el-input>
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
          tNum: '',
          tBank: '',
          tCityId: '',
          tUserId: '',
          tBankId: '',
          tBankBranch: '',
          tPhoneNum: ''
        },
        dataRule: {
          tNum: [
            { required: true, message: '银行卡号长度18位不能为空', trigger: 'blur' }
          ],
          tBank: [
            { required: true, message: '开户银行不能为空', trigger: 'blur' }
          ],
          tCityId: [
            { required: true, message: '城市Id不能为空', trigger: 'blur' }
          ],
          tUserId: [
            { required: true, message: '用户表主键不能为空', trigger: 'blur' }
          ],
          tBankId: [
            { required: true, message: '银行编号不能为空', trigger: 'blur' }
          ],
          tBankBranch: [
            { required: true, message: '银行支行不能为空', trigger: 'blur' }
          ],
          tPhoneNum: [
            { required: true, message: '绑定手机号码不能为空', trigger: 'blur' }
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
              url: this.$http.adornUrl(`/team/bankcard/info/${this.dataForm.tId}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.tNum = data.bankcard.tNum
                this.dataForm.tBank = data.bankcard.tBank
                this.dataForm.tCityId = data.bankcard.tCityId
                this.dataForm.tUserId = data.bankcard.tUserId
                this.dataForm.tBankId = data.bankcard.tBankId
                this.dataForm.tBankBranch = data.bankcard.tBankBranch
                this.dataForm.tPhoneNum = data.bankcard.tPhoneNum
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
              url: this.$http.adornUrl(`/team/bankcard/${!this.dataForm.tId ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'tId': this.dataForm.tId || undefined,
                'tNum': this.dataForm.tNum,
                'tBank': this.dataForm.tBank,
                'tCityId': this.dataForm.tCityId,
                'tUserId': this.dataForm.tUserId,
                'tBankId': this.dataForm.tBankId,
                'tBankBranch': this.dataForm.tBankBranch,
                'tPhoneNum': this.dataForm.tPhoneNum
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
