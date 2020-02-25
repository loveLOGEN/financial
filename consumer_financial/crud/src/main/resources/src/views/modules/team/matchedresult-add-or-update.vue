<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="用户id" prop="iUserId">
      <el-input v-model="dataForm.iUserId" placeholder="用户id"></el-input>
    </el-form-item>
    <el-form-item label="债权id" prop="iClaimsId">
      <el-input v-model="dataForm.iClaimsId" placeholder="债权id"></el-input>
    </el-form-item>
    <el-form-item label="投资记录主键" prop="iInvestNo">
      <el-input v-model="dataForm.iInvestNo" placeholder="投资记录主键"></el-input>
    </el-form-item>
    <el-form-item label="交易流水号" prop="iTransferSerialNo">
      <el-input v-model="dataForm.iTransferSerialNo" placeholder="交易流水号"></el-input>
    </el-form-item>
    <el-form-item label="购买金额（匹配金额）" prop="iBidMoney">
      <el-input v-model="dataForm.iBidMoney" placeholder="购买金额（匹配金额）"></el-input>
    </el-form-item>
    <el-form-item label="购买日期（匹配日期）" prop="iConfirmDate">
      <el-input v-model="dataForm.iConfirmDate" placeholder="购买日期（匹配日期）"></el-input>
    </el-form-item>
    <el-form-item label="是否确认,11702:未确认,11701:已确认" prop="iIsConfirmed">
      <el-input v-model="dataForm.iIsConfirmed" placeholder="是否确认,11702:未确认,11701:已确认"></el-input>
    </el-form-item>
    <el-form-item label="匹配上的日期" prop="iMatchedDate">
      <el-input v-model="dataForm.iMatchedDate" placeholder="匹配上的日期"></el-input>
    </el-form-item>
    <el-form-item label="资金类型" prop="iInvestType">
      <el-input v-model="dataForm.iInvestType" placeholder="资金类型"></el-input>
    </el-form-item>
    <el-form-item label="债权类型" prop="iDebtType">
      <el-input v-model="dataForm.iDebtType" placeholder="债权类型"></el-input>
    </el-form-item>
    <el-form-item label="是否清算过,11802:未清算,11801:已清算" prop="iIsExecuted">
      <el-input v-model="dataForm.iIsExecuted" placeholder="是否清算过,11802:未清算,11801:已清算"></el-input>
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
          iId: 0,
          iUserId: '',
          iClaimsId: '',
          iInvestNo: '',
          iTransferSerialNo: '',
          iBidMoney: '',
          iConfirmDate: '',
          iIsConfirmed: '',
          iMatchedDate: '',
          iInvestType: '',
          iDebtType: '',
          iIsExecuted: ''
        },
        dataRule: {
          iUserId: [
            { required: true, message: '用户id不能为空', trigger: 'blur' }
          ],
          iClaimsId: [
            { required: true, message: '债权id不能为空', trigger: 'blur' }
          ],
          iInvestNo: [
            { required: true, message: '投资记录主键不能为空', trigger: 'blur' }
          ],
          iTransferSerialNo: [
            { required: true, message: '交易流水号不能为空', trigger: 'blur' }
          ],
          iBidMoney: [
            { required: true, message: '购买金额（匹配金额）不能为空', trigger: 'blur' }
          ],
          iConfirmDate: [
            { required: true, message: '购买日期（匹配日期）不能为空', trigger: 'blur' }
          ],
          iIsConfirmed: [
            { required: true, message: '是否确认,11702:未确认,11701:已确认不能为空', trigger: 'blur' }
          ],
          iMatchedDate: [
            { required: true, message: '匹配上的日期不能为空', trigger: 'blur' }
          ],
          iInvestType: [
            { required: true, message: '资金类型不能为空', trigger: 'blur' }
          ],
          iDebtType: [
            { required: true, message: '债权类型不能为空', trigger: 'blur' }
          ],
          iIsExecuted: [
            { required: true, message: '是否清算过,11802:未清算,11801:已清算不能为空', trigger: 'blur' }
          ]
        }
      }
    },
    methods: {
      init (id) {
        this.dataForm.iId = id || 0
        this.visible = true
        this.$nextTick(() => {
          this.$refs['dataForm'].resetFields()
          if (this.dataForm.iId) {
            this.$http({
              url: this.$http.adornUrl(`/team/matchedresult/info/${this.dataForm.iId}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.iUserId = data.matchedresult.iUserId
                this.dataForm.iClaimsId = data.matchedresult.iClaimsId
                this.dataForm.iInvestNo = data.matchedresult.iInvestNo
                this.dataForm.iTransferSerialNo = data.matchedresult.iTransferSerialNo
                this.dataForm.iBidMoney = data.matchedresult.iBidMoney
                this.dataForm.iConfirmDate = data.matchedresult.iConfirmDate
                this.dataForm.iIsConfirmed = data.matchedresult.iIsConfirmed
                this.dataForm.iMatchedDate = data.matchedresult.iMatchedDate
                this.dataForm.iInvestType = data.matchedresult.iInvestType
                this.dataForm.iDebtType = data.matchedresult.iDebtType
                this.dataForm.iIsExecuted = data.matchedresult.iIsExecuted
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
              url: this.$http.adornUrl(`/team/matchedresult/${!this.dataForm.iId ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'iId': this.dataForm.iId || undefined,
                'iUserId': this.dataForm.iUserId,
                'iClaimsId': this.dataForm.iClaimsId,
                'iInvestNo': this.dataForm.iInvestNo,
                'iTransferSerialNo': this.dataForm.iTransferSerialNo,
                'iBidMoney': this.dataForm.iBidMoney,
                'iConfirmDate': this.dataForm.iConfirmDate,
                'iIsConfirmed': this.dataForm.iIsConfirmed,
                'iMatchedDate': this.dataForm.iMatchedDate,
                'iInvestType': this.dataForm.iInvestType,
                'iDebtType': this.dataForm.iDebtType,
                'iIsExecuted': this.dataForm.iIsExecuted
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
