<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="用户id" prop="aUserId">
      <el-input v-model="dataForm.aUserId" placeholder="用户id"></el-input>
    </el-form-item>
    <el-form-item label="主账户id" prop="aMainAccountId">
      <el-input v-model="dataForm.aMainAccountId" placeholder="主账户id"></el-input>
    </el-form-item>
    <el-form-item label="投资记录主键" prop="pId">
      <el-input v-model="dataForm.pId" placeholder="投资记录主键"></el-input>
    </el-form-item>
    <el-form-item label="当前期" prop="aCurrentPeriod">
      <el-input v-model="dataForm.aCurrentPeriod" placeholder="当前期"></el-input>
    </el-form-item>
    <el-form-item label="收付" prop="aReceiveOrPay">
      <el-input v-model="dataForm.aReceiveOrPay" placeholder="收付"></el-input>
    </el-form-item>
    <el-form-item label="交易流水号" prop="aTransferSerialNo">
      <el-input v-model="dataForm.aTransferSerialNo" placeholder="交易流水号"></el-input>
    </el-form-item>
    <el-form-item label="交易时间" prop="aDate">
      <el-input v-model="dataForm.aDate" placeholder="交易时间"></el-input>
    </el-form-item>
    <el-form-item label="交易类型 " prop="aType">
      <el-input v-model="dataForm.aType" placeholder="交易类型 "></el-input>
    </el-form-item>
    <el-form-item label="交易状态" prop="aTransferStatus">
      <el-input v-model="dataForm.aTransferStatus" placeholder="交易状态"></el-input>
    </el-form-item>
    <el-form-item label="交易前金额" prop="aBeforeTradingMoney">
      <el-input v-model="dataForm.aBeforeTradingMoney" placeholder="交易前金额"></el-input>
    </el-form-item>
    <el-form-item label="金额" prop="aAmount">
      <el-input v-model="dataForm.aAmount" placeholder="金额"></el-input>
    </el-form-item>
    <el-form-item label="交易后金额" prop="aAfterTradingMoney">
      <el-input v-model="dataForm.aAfterTradingMoney" placeholder="交易后金额"></el-input>
    </el-form-item>
    <el-form-item label="交易详情" prop="aDescreption">
      <el-input v-model="dataForm.aDescreption" placeholder="交易详情"></el-input>
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
          aId: 0,
          aUserId: '',
          aMainAccountId: '',
          pId: '',
          aCurrentPeriod: '',
          aReceiveOrPay: '',
          aTransferSerialNo: '',
          aDate: '',
          aType: '',
          aTransferStatus: '',
          aBeforeTradingMoney: '',
          aAmount: '',
          aAfterTradingMoney: '',
          aDescreption: ''
        },
        dataRule: {
          aUserId: [
            { required: true, message: '用户id不能为空', trigger: 'blur' }
          ],
          aMainAccountId: [
            { required: true, message: '主账户id不能为空', trigger: 'blur' }
          ],
          pId: [
            { required: true, message: '投资记录主键不能为空', trigger: 'blur' }
          ],
          aCurrentPeriod: [
            { required: true, message: '当前期不能为空', trigger: 'blur' }
          ],
          aReceiveOrPay: [
            { required: true, message: '收付不能为空', trigger: 'blur' }
          ],
          aTransferSerialNo: [
            { required: true, message: '交易流水号不能为空', trigger: 'blur' }
          ],
          aDate: [
            { required: true, message: '交易时间不能为空', trigger: 'blur' }
          ],
          aType: [
            { required: true, message: '交易类型 不能为空', trigger: 'blur' }
          ],
          aTransferStatus: [
            { required: true, message: '交易状态不能为空', trigger: 'blur' }
          ],
          aBeforeTradingMoney: [
            { required: true, message: '交易前金额不能为空', trigger: 'blur' }
          ],
          aAmount: [
            { required: true, message: '金额不能为空', trigger: 'blur' }
          ],
          aAfterTradingMoney: [
            { required: true, message: '交易后金额不能为空', trigger: 'blur' }
          ],
          aDescreption: [
            { required: true, message: '交易详情不能为空', trigger: 'blur' }
          ]
        }
      }
    },
    methods: {
      init (id) {
        this.dataForm.aId = id || 0
        this.visible = true
        this.$nextTick(() => {
          this.$refs['dataForm'].resetFields()
          if (this.dataForm.aId) {
            this.$http({
              url: this.$http.adornUrl(`/team/accountlog/info/${this.dataForm.aId}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.aUserId = data.accountlog.aUserId
                this.dataForm.aMainAccountId = data.accountlog.aMainAccountId
                this.dataForm.pId = data.accountlog.pId
                this.dataForm.aCurrentPeriod = data.accountlog.aCurrentPeriod
                this.dataForm.aReceiveOrPay = data.accountlog.aReceiveOrPay
                this.dataForm.aTransferSerialNo = data.accountlog.aTransferSerialNo
                this.dataForm.aDate = data.accountlog.aDate
                this.dataForm.aType = data.accountlog.aType
                this.dataForm.aTransferStatus = data.accountlog.aTransferStatus
                this.dataForm.aBeforeTradingMoney = data.accountlog.aBeforeTradingMoney
                this.dataForm.aAmount = data.accountlog.aAmount
                this.dataForm.aAfterTradingMoney = data.accountlog.aAfterTradingMoney
                this.dataForm.aDescreption = data.accountlog.aDescreption
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
              url: this.$http.adornUrl(`/team/accountlog/${!this.dataForm.aId ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'aId': this.dataForm.aId || undefined,
                'aUserId': this.dataForm.aUserId,
                'aMainAccountId': this.dataForm.aMainAccountId,
                'pId': this.dataForm.pId,
                'aCurrentPeriod': this.dataForm.aCurrentPeriod,
                'aReceiveOrPay': this.dataForm.aReceiveOrPay,
                'aTransferSerialNo': this.dataForm.aTransferSerialNo,
                'aDate': this.dataForm.aDate,
                'aType': this.dataForm.aType,
                'aTransferStatus': this.dataForm.aTransferStatus,
                'aBeforeTradingMoney': this.dataForm.aBeforeTradingMoney,
                'aAmount': this.dataForm.aAmount,
                'aAfterTradingMoney': this.dataForm.aAfterTradingMoney,
                'aDescreption': this.dataForm.aDescreption
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
