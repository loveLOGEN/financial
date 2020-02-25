<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="用户的id" prop="tUserid">
      <el-input v-model="dataForm.tUserid" placeholder="用户的id"></el-input>
    </el-form-item>
    <el-form-item label="帐户总额" prop="tTotal">
      <el-input v-model="dataForm.tTotal" placeholder="帐户总额"></el-input>
    </el-form-item>
    <el-form-item label="帐户可余额" prop=" tBalance">
      <el-input v-model="dataForm. tBalance" placeholder="帐户可余额"></el-input>
    </el-form-item>
    <el-form-item label="账户总计冻结总额" prop="tFrozen">
      <el-input v-model="dataForm.tFrozen" placeholder="账户总计冻结总额"></el-input>
    </el-form-item>
    <el-form-item label="总计待收本金" prop=" tInverstmentw">
      <el-input v-model="dataForm. tInverstmentw" placeholder="总计待收本金"></el-input>
    </el-form-item>
    <el-form-item label="总计待收利息" prop="tInterestTotal">
      <el-input v-model="dataForm.tInterestTotal" placeholder="总计待收利息"></el-input>
    </el-form-item>
    <el-form-item label="月投总额" prop="tAddCaptialTatal">
      <el-input v-model="dataForm.tAddCaptialTatal" placeholder="月投总额"></el-input>
    </el-form-item>
    <el-form-item label="月取总额" prop="tRecyclingInterest">
      <el-input v-model="dataForm.tRecyclingInterest" placeholder="月取总额"></el-input>
    </el-form-item>
    <el-form-item label="月乘总额" prop="tCapitalTotal">
      <el-input v-model="dataForm.tCapitalTotal" placeholder="月乘总额"></el-input>
    </el-form-item>
    <el-form-item label="已投资总额" prop="tInverstmenta">
      <el-input v-model="dataForm.tInverstmenta" placeholder="已投资总额"></el-input>
    </el-form-item>
    <el-form-item label="已赚取利息" prop="tInteresta">
      <el-input v-model="dataForm.tInteresta" placeholder="已赚取利息"></el-input>
    </el-form-item>
    <el-form-item label="申请提现金额" prop="tUapplyExtractMoney">
      <el-input v-model="dataForm.tUapplyExtractMoney" placeholder="申请提现金额"></el-input>
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
          tUserid: '',
          tTotal: '',
           tBalance: '',
          tFrozen: '',
           tInverstmentw: '',
          tInterestTotal: '',
          tAddCaptialTatal: '',
          tRecyclingInterest: '',
          tCapitalTotal: '',
          tInverstmenta: '',
          tInteresta: '',
          tUapplyExtractMoney: ''
        },
        dataRule: {
          tUserid: [
            { required: true, message: '用户的id不能为空', trigger: 'blur' }
          ],
          tTotal: [
            { required: true, message: '帐户总额不能为空', trigger: 'blur' }
          ],
           tBalance: [
            { required: true, message: '帐户可余额不能为空', trigger: 'blur' }
          ],
          tFrozen: [
            { required: true, message: '账户总计冻结总额不能为空', trigger: 'blur' }
          ],
           tInverstmentw: [
            { required: true, message: '总计待收本金不能为空', trigger: 'blur' }
          ],
          tInterestTotal: [
            { required: true, message: '总计待收利息不能为空', trigger: 'blur' }
          ],
          tAddCaptialTatal: [
            { required: true, message: '月投总额不能为空', trigger: 'blur' }
          ],
          tRecyclingInterest: [
            { required: true, message: '月取总额不能为空', trigger: 'blur' }
          ],
          tCapitalTotal: [
            { required: true, message: '月乘总额不能为空', trigger: 'blur' }
          ],
          tInverstmenta: [
            { required: true, message: '已投资总额不能为空', trigger: 'blur' }
          ],
          tInteresta: [
            { required: true, message: '已赚取利息不能为空', trigger: 'blur' }
          ],
          tUapplyExtractMoney: [
            { required: true, message: '申请提现金额不能为空', trigger: 'blur' }
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
              url: this.$http.adornUrl(`/team/account/info/${this.dataForm.tId}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.tUserid = data.account.tUserid
                this.dataForm.tTotal = data.account.tTotal
                this.dataForm. tBalance = data.account. tBalance
                this.dataForm.tFrozen = data.account.tFrozen
                this.dataForm. tInverstmentw = data.account. tInverstmentw
                this.dataForm.tInterestTotal = data.account.tInterestTotal
                this.dataForm.tAddCaptialTatal = data.account.tAddCaptialTatal
                this.dataForm.tRecyclingInterest = data.account.tRecyclingInterest
                this.dataForm.tCapitalTotal = data.account.tCapitalTotal
                this.dataForm.tInverstmenta = data.account.tInverstmenta
                this.dataForm.tInteresta = data.account.tInteresta
                this.dataForm.tUapplyExtractMoney = data.account.tUapplyExtractMoney
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
              url: this.$http.adornUrl(`/team/account/${!this.dataForm.tId ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'tId': this.dataForm.tId || undefined,
                'tUserid': this.dataForm.tUserid,
                'tTotal': this.dataForm.tTotal,
                ' tBalance': this.dataForm. tBalance,
                'tFrozen': this.dataForm.tFrozen,
                ' tInverstmentw': this.dataForm. tInverstmentw,
                'tInterestTotal': this.dataForm.tInterestTotal,
                'tAddCaptialTatal': this.dataForm.tAddCaptialTatal,
                'tRecyclingInterest': this.dataForm.tRecyclingInterest,
                'tCapitalTotal': this.dataForm.tCapitalTotal,
                'tInverstmenta': this.dataForm.tInverstmenta,
                'tInteresta': this.dataForm.tInteresta,
                'tUapplyExtractMoney': this.dataForm.tUapplyExtractMoney
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
