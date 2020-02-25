<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="转让封闭期" prop="tClosePreiod">
      <el-input v-model="dataForm.tClosePreiod" placeholder="转让封闭期"></el-input>
    </el-form-item>
    <el-form-item label="提前赎回类型" prop="tEarlyRedeptionType">
      <el-input v-model="dataForm.tEarlyRedeptionType" placeholder="提前赎回类型"></el-input>
    </el-form-item>
    <el-form-item label="收益利率类型（134：年利率 ，135：月利率）" prop="tEartingType">
      <el-input v-model="dataForm.tEartingType" placeholder="收益利率类型（134：年利率 ，135：月利率）"></el-input>
    </el-form-item>
    <el-form-item label="数量规则" prop="tInvestRule">
      <el-input v-model="dataForm.tInvestRule" placeholder="数量规则"></el-input>
    </el-form-item>
    <el-form-item label="是否可转让" prop="tAllowTransfer">
      <el-input v-model="dataForm.tAllowTransfer" placeholder="是否可转让"></el-input>
    </el-form-item>
    <el-form-item label="是否复投" prop="tIsRepeatInvest">
      <el-input v-model="dataForm.tIsRepeatInvest" placeholder="是否复投"></el-input>
    </el-form-item>
    <el-form-item label="产品最低期限" prop="tLowerLimit">
      <el-input v-model="dataForm.tLowerLimit" placeholder="产品最低期限"></el-input>
    </el-form-item>
    <el-form-item label="产品起投金额" prop="tLowerInvest">
      <el-input v-model="dataForm.tLowerInvest" placeholder="产品起投金额"></el-input>
    </el-form-item>
    <el-form-item label="产品编号" prop="tPronum">
      <el-input v-model="dataForm.tPronum" placeholder="产品编号"></el-input>
    </el-form-item>
    <el-form-item label="产品类型id" prop="tProtypeId">
      <el-input v-model="dataForm.tProtypeId" placeholder="产品类型id"></el-input>
    </el-form-item>
    <el-form-item label="产品投资上限" prop="tUpperInvest">
      <el-input v-model="dataForm.tUpperInvest" placeholder="产品投资上限"></el-input>
    </el-form-item>
    <el-form-item label="产品名称" prop="tProductName">
      <el-input v-model="dataForm.tProductName" placeholder="产品名称"></el-input>
    </el-form-item>
    <el-form-item label="状态(0:表示正常；1：表示停用)" prop="tStatus">
      <el-input v-model="dataForm.tStatus" placeholder="状态(0:表示正常；1：表示停用)"></el-input>
    </el-form-item>
    <el-form-item label="产品最大期限" prop="tUpperLimit">
      <el-input v-model="dataForm.tUpperLimit" placeholder="产品最大期限"></el-input>
    </el-form-item>
    <el-form-item label="回款方式（109：表示一次性回款 ，110：每月提取，到期退出）" prop="tReturnMoney">
      <el-input v-model="dataForm.tReturnMoney" placeholder="回款方式（109：表示一次性回款 ，110：每月提取，到期退出）"></el-input>
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
          tPid: 0,
          tClosePreiod: '',
          tEarlyRedeptionType: '',
          tEartingType: '',
          tInvestRule: '',
          tAllowTransfer: '',
          tIsRepeatInvest: '',
          tLowerLimit: '',
          tLowerInvest: '',
          tPronum: '',
          tProtypeId: '',
          tUpperInvest: '',
          tProductName: '',
          tStatus: '',
          tUpperLimit: '',
          tReturnMoney: ''
        },
        dataRule: {
          tClosePreiod: [
            { required: true, message: '转让封闭期不能为空', trigger: 'blur' }
          ],
          tEarlyRedeptionType: [
            { required: true, message: '提前赎回类型不能为空', trigger: 'blur' }
          ],
          tEartingType: [
            { required: true, message: '收益利率类型（134：年利率 ，135：月利率）不能为空', trigger: 'blur' }
          ],
          tInvestRule: [
            { required: true, message: '数量规则不能为空', trigger: 'blur' }
          ],
          tAllowTransfer: [
            { required: true, message: '是否可转让不能为空', trigger: 'blur' }
          ],
          tIsRepeatInvest: [
            { required: true, message: '是否复投不能为空', trigger: 'blur' }
          ],
          tLowerLimit: [
            { required: true, message: '产品最低期限不能为空', trigger: 'blur' }
          ],
          tLowerInvest: [
            { required: true, message: '产品起投金额不能为空', trigger: 'blur' }
          ],
          tPronum: [
            { required: true, message: '产品编号不能为空', trigger: 'blur' }
          ],
          tProtypeId: [
            { required: true, message: '产品类型id不能为空', trigger: 'blur' }
          ],
          tUpperInvest: [
            { required: true, message: '产品投资上限不能为空', trigger: 'blur' }
          ],
          tProductName: [
            { required: true, message: '产品名称不能为空', trigger: 'blur' }
          ],
          tStatus: [
            { required: true, message: '状态(0:表示正常；1：表示停用)不能为空', trigger: 'blur' }
          ],
          tUpperLimit: [
            { required: true, message: '产品最大期限不能为空', trigger: 'blur' }
          ],
          tReturnMoney: [
            { required: true, message: '回款方式（109：表示一次性回款 ，110：每月提取，到期退出）不能为空', trigger: 'blur' }
          ]
        }
      }
    },
    methods: {
      init (id) {
        this.dataForm.tPid = id || 0
        this.visible = true
        this.$nextTick(() => {
          this.$refs['dataForm'].resetFields()
          if (this.dataForm.tPid) {
            this.$http({
              url: this.$http.adornUrl(`/team/product/info/${this.dataForm.tPid}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.tClosePreiod = data.product.tClosePreiod
                this.dataForm.tEarlyRedeptionType = data.product.tEarlyRedeptionType
                this.dataForm.tEartingType = data.product.tEartingType
                this.dataForm.tInvestRule = data.product.tInvestRule
                this.dataForm.tAllowTransfer = data.product.tAllowTransfer
                this.dataForm.tIsRepeatInvest = data.product.tIsRepeatInvest
                this.dataForm.tLowerLimit = data.product.tLowerLimit
                this.dataForm.tLowerInvest = data.product.tLowerInvest
                this.dataForm.tPronum = data.product.tPronum
                this.dataForm.tProtypeId = data.product.tProtypeId
                this.dataForm.tUpperInvest = data.product.tUpperInvest
                this.dataForm.tProductName = data.product.tProductName
                this.dataForm.tStatus = data.product.tStatus
                this.dataForm.tUpperLimit = data.product.tUpperLimit
                this.dataForm.tReturnMoney = data.product.tReturnMoney
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
              url: this.$http.adornUrl(`/team/product/${!this.dataForm.tPid ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'tPid': this.dataForm.tPid || undefined,
                'tClosePreiod': this.dataForm.tClosePreiod,
                'tEarlyRedeptionType': this.dataForm.tEarlyRedeptionType,
                'tEartingType': this.dataForm.tEartingType,
                'tInvestRule': this.dataForm.tInvestRule,
                'tAllowTransfer': this.dataForm.tAllowTransfer,
                'tIsRepeatInvest': this.dataForm.tIsRepeatInvest,
                'tLowerLimit': this.dataForm.tLowerLimit,
                'tLowerInvest': this.dataForm.tLowerInvest,
                'tPronum': this.dataForm.tPronum,
                'tProtypeId': this.dataForm.tProtypeId,
                'tUpperInvest': this.dataForm.tUpperInvest,
                'tProductName': this.dataForm.tProductName,
                'tStatus': this.dataForm.tStatus,
                'tUpperLimit': this.dataForm.tUpperLimit,
                'tReturnMoney': this.dataForm.tReturnMoney
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
