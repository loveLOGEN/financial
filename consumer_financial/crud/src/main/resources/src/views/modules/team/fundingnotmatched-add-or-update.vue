<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="投资记录" prop="fInvestRecordId">
      <el-input v-model="dataForm.fInvestRecordId" placeholder="投资记录"></el-input>
    </el-form-item>
    <el-form-item label="待匹配金额" prop="fNotMatchedMoney">
      <el-input v-model="dataForm.fNotMatchedMoney" placeholder="待匹配金额"></el-input>
    </el-form-item>
    <el-form-item label="资金类型" prop="fFoundingType">
      <el-input v-model="dataForm.fFoundingType" placeholder="资金类型"></el-input>
    </el-form-item>
    <el-form-item label="资金" prop="fFoundingWeight">
      <el-input v-model="dataForm.fFoundingWeight" placeholder="资金"></el-input>
    </el-form-item>
    <el-form-item label="是否锁定" prop="fIsLocked">
      <el-input v-model="dataForm.fIsLocked" placeholder="是否锁定"></el-input>
    </el-form-item>
    <el-form-item label="创建时间" prop="fCreateDate">
      <el-input v-model="dataForm.fCreateDate" placeholder="创建时间"></el-input>
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
          fId: 0,
          fInvestRecordId: '',
          fNotMatchedMoney: '',
          fFoundingType: '',
          fFoundingWeight: '',
          fIsLocked: '',
          fCreateDate: ''
        },
        dataRule: {
          fInvestRecordId: [
            { required: true, message: '投资记录不能为空', trigger: 'blur' }
          ],
          fNotMatchedMoney: [
            { required: true, message: '待匹配金额不能为空', trigger: 'blur' }
          ],
          fFoundingType: [
            { required: true, message: '资金类型不能为空', trigger: 'blur' }
          ],
          fFoundingWeight: [
            { required: true, message: '资金不能为空', trigger: 'blur' }
          ],
          fIsLocked: [
            { required: true, message: '是否锁定不能为空', trigger: 'blur' }
          ],
          fCreateDate: [
            { required: true, message: '创建时间不能为空', trigger: 'blur' }
          ]
        }
      }
    },
    methods: {
      init (id) {
        this.dataForm.fId = id || 0
        this.visible = true
        this.$nextTick(() => {
          this.$refs['dataForm'].resetFields()
          if (this.dataForm.fId) {
            this.$http({
              url: this.$http.adornUrl(`/team/fundingnotmatched/info/${this.dataForm.fId}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.fInvestRecordId = data.fundingnotmatched.fInvestRecordId
                this.dataForm.fNotMatchedMoney = data.fundingnotmatched.fNotMatchedMoney
                this.dataForm.fFoundingType = data.fundingnotmatched.fFoundingType
                this.dataForm.fFoundingWeight = data.fundingnotmatched.fFoundingWeight
                this.dataForm.fIsLocked = data.fundingnotmatched.fIsLocked
                this.dataForm.fCreateDate = data.fundingnotmatched.fCreateDate
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
              url: this.$http.adornUrl(`/team/fundingnotmatched/${!this.dataForm.fId ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'fId': this.dataForm.fId || undefined,
                'fInvestRecordId': this.dataForm.fInvestRecordId,
                'fNotMatchedMoney': this.dataForm.fNotMatchedMoney,
                'fFoundingType': this.dataForm.fFoundingType,
                'fFoundingWeight': this.dataForm.fFoundingWeight,
                'fIsLocked': this.dataForm.fIsLocked,
                'fCreateDate': this.dataForm.fCreateDate
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
