<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="债权id" prop="cClaimsId">
      <el-input v-model="dataForm.cClaimsId" placeholder="债权id"></el-input>
    </el-form-item>
    <el-form-item label="转让流水号" prop="cTransferSerialNo">
      <el-input v-model="dataForm.cTransferSerialNo" placeholder="转让流水号"></el-input>
    </el-form-item>
    <el-form-item label="债权持有人" prop="cUserId">
      <el-input v-model="dataForm.cUserId" placeholder="债权持有人"></el-input>
    </el-form-item>
    <el-form-item label="债权类型 :新借款 129,到期赎回 130,期限内回款 131" prop="cClaimsType">
      <el-input v-model="dataForm.cClaimsType" placeholder="债权类型 :新借款 129,到期赎回 130,期限内回款 131"></el-input>
    </el-form-item>
    <el-form-item label="转让时间" prop="cTransferDate">
      <el-input v-model="dataForm.cTransferDate" placeholder="转让时间"></el-input>
    </el-form-item>
    <el-form-item label=" 债权权重" prop="cClaimsWeight">
      <el-input v-model="dataForm.cClaimsWeight" placeholder=" 债权权重"></el-input>
    </el-form-item>
    <el-form-item label="债权金额" prop="cTransferMoney">
      <el-input v-model="dataForm.cTransferMoney" placeholder="债权金额"></el-input>
    </el-form-item>
    <el-form-item label="审核状态" prop="cAuditStatus">
      <el-input v-model="dataForm.cAuditStatus" placeholder="审核状态"></el-input>
    </el-form-item>
    <el-form-item label="是否锁定:11404,锁定中(匹配中);11403,未锁定(未匹配)" prop="cIsLocked">
      <el-input v-model="dataForm.cIsLocked" placeholder="是否锁定:11404,锁定中(匹配中);11403,未锁定(未匹配)"></el-input>
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
          cId: 0,
          cClaimsId: '',
          cTransferSerialNo: '',
          cUserId: '',
          cClaimsType: '',
          cTransferDate: '',
          cClaimsWeight: '',
          cTransferMoney: '',
          cAuditStatus: '',
          cIsLocked: ''
        },
        dataRule: {
          cClaimsId: [
            { required: true, message: '债权id不能为空', trigger: 'blur' }
          ],
          cTransferSerialNo: [
            { required: true, message: '转让流水号不能为空', trigger: 'blur' }
          ],
          cUserId: [
            { required: true, message: '债权持有人不能为空', trigger: 'blur' }
          ],
          cClaimsType: [
            { required: true, message: '债权类型 :新借款 129,到期赎回 130,期限内回款 131不能为空', trigger: 'blur' }
          ],
          cTransferDate: [
            { required: true, message: '转让时间不能为空', trigger: 'blur' }
          ],
          cClaimsWeight: [
            { required: true, message: ' 债权权重不能为空', trigger: 'blur' }
          ],
          cTransferMoney: [
            { required: true, message: '债权金额不能为空', trigger: 'blur' }
          ],
          cAuditStatus: [
            { required: true, message: '审核状态不能为空', trigger: 'blur' }
          ],
          cIsLocked: [
            { required: true, message: '是否锁定:11404,锁定中(匹配中);11403,未锁定(未匹配)不能为空', trigger: 'blur' }
          ]
        }
      }
    },
    methods: {
      init (id) {
        this.dataForm.cId = id || 0
        this.visible = true
        this.$nextTick(() => {
          this.$refs['dataForm'].resetFields()
          if (this.dataForm.cId) {
            this.$http({
              url: this.$http.adornUrl(`/team/claimstransfer/info/${this.dataForm.cId}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.cClaimsId = data.claimstransfer.cClaimsId
                this.dataForm.cTransferSerialNo = data.claimstransfer.cTransferSerialNo
                this.dataForm.cUserId = data.claimstransfer.cUserId
                this.dataForm.cClaimsType = data.claimstransfer.cClaimsType
                this.dataForm.cTransferDate = data.claimstransfer.cTransferDate
                this.dataForm.cClaimsWeight = data.claimstransfer.cClaimsWeight
                this.dataForm.cTransferMoney = data.claimstransfer.cTransferMoney
                this.dataForm.cAuditStatus = data.claimstransfer.cAuditStatus
                this.dataForm.cIsLocked = data.claimstransfer.cIsLocked
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
              url: this.$http.adornUrl(`/team/claimstransfer/${!this.dataForm.cId ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'cId': this.dataForm.cId || undefined,
                'cClaimsId': this.dataForm.cClaimsId,
                'cTransferSerialNo': this.dataForm.cTransferSerialNo,
                'cUserId': this.dataForm.cUserId,
                'cClaimsType': this.dataForm.cClaimsType,
                'cTransferDate': this.dataForm.cTransferDate,
                'cClaimsWeight': this.dataForm.cClaimsWeight,
                'cTransferMoney': this.dataForm.cTransferMoney,
                'cAuditStatus': this.dataForm.cAuditStatus,
                'cIsLocked': this.dataForm.cIsLocked
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
