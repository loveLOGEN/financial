<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="债权编号" prop="dDebtNo">
      <el-input v-model="dataForm.dDebtNo" placeholder="债权编号"></el-input>
    </el-form-item>
    <el-form-item label="合同编号" prop="dContractNo">
      <el-input v-model="dataForm.dContractNo" placeholder="合同编号"></el-input>
    </el-form-item>
    <el-form-item label="债务人名称" prop="dDebtorsName">
      <el-input v-model="dataForm.dDebtorsName" placeholder="债务人名称"></el-input>
    </el-form-item>
    <el-form-item label="债务人身份证号" prop="dDebtorsId">
      <el-input v-model="dataForm.dDebtorsId" placeholder="债务人身份证号"></el-input>
    </el-form-item>
    <el-form-item label="借款用途" prop="dLoanPurpose">
      <el-input v-model="dataForm.dLoanPurpose" placeholder="借款用途"></el-input>
    </el-form-item>
    <el-form-item label="借款类型" prop="dLoanType">
      <el-input v-model="dataForm.dLoanType" placeholder="借款类型"></el-input>
    </el-form-item>
    <el-form-item label="原始借款开始日期" prop="dLoanStartDate">
      <el-input v-model="dataForm.dLoanStartDate" placeholder="原始借款开始日期"></el-input>
    </el-form-item>
    <el-form-item label="原始借款期限" prop="dLoanPeriod">
      <el-input v-model="dataForm.dLoanPeriod" placeholder="原始借款期限"></el-input>
    </el-form-item>
    <el-form-item label="原始借款到期日期" prop="dLoanEndDate">
      <el-input v-model="dataForm.dLoanEndDate" placeholder="原始借款到期日期"></el-input>
    </el-form-item>
    <el-form-item label="还款方式" prop="dRepaymentStyle">
      <el-input v-model="dataForm.dRepaymentStyle" placeholder="还款方式"></el-input>
    </el-form-item>
    <el-form-item label="还款日" prop="dRepaymenDate">
      <el-input v-model="dataForm.dRepaymenDate" placeholder="还款日"></el-input>
    </el-form-item>
    <el-form-item label="还款金额" prop="dRepaymenMoney">
      <el-input v-model="dataForm.dRepaymenMoney" placeholder="还款金额"></el-input>
    </el-form-item>
    <el-form-item label="债权金额" prop="dDebtMoney">
      <el-input v-model="dataForm.dDebtMoney" placeholder="债权金额"></el-input>
    </el-form-item>
    <el-form-item label="债权年化利率" prop="dDebtYearRate">
      <el-input v-model="dataForm.dDebtYearRate" placeholder="债权年化利率"></el-input>
    </el-form-item>
    <el-form-item label="债权月利率" prop="dDebtMonthRate">
      <el-input v-model="dataForm.dDebtMonthRate" placeholder="债权月利率"></el-input>
    </el-form-item>
    <el-form-item label="债权转入金额" prop="dDebtTransferredMoney">
      <el-input v-model="dataForm.dDebtTransferredMoney" placeholder="债权转入金额"></el-input>
    </el-form-item>
    <el-form-item label="债权转入日期" prop="dDebtTransferredDate">
      <el-input v-model="dataForm.dDebtTransferredDate" placeholder="债权转入日期"></el-input>
    </el-form-item>
    <el-form-item label="债权转入期限" prop="dDebtTransferredPeriod">
      <el-input v-model="dataForm.dDebtTransferredPeriod" placeholder="债权转入期限"></el-input>
    </el-form-item>
    <el-form-item label="债权转出日期" prop="dDebtRansferOutDate">
      <el-input v-model="dataForm.dDebtRansferOutDate" placeholder="债权转出日期"></el-input>
    </el-form-item>
    <el-form-item label="债权人" prop="dCreditor">
      <el-input v-model="dataForm.dCreditor" placeholder="债权人"></el-input>
    </el-form-item>
    <el-form-item label="债权状态" prop="dDebtStatus">
      <el-input v-model="dataForm.dDebtStatus" placeholder="债权状态"></el-input>
    </el-form-item>
    <el-form-item label="借款人ID" prop="dBorrowerId">
      <el-input v-model="dataForm.dBorrowerId" placeholder="借款人ID"></el-input>
    </el-form-item>
    <el-form-item label="可用期限" prop="dAvailablePeriod">
      <el-input v-model="dataForm.dAvailablePeriod" placeholder="可用期限"></el-input>
    </el-form-item>
    <el-form-item label="可用金额" prop="dAvailableMoney">
      <el-input v-model="dataForm.dAvailableMoney" placeholder="可用金额"></el-input>
    </el-form-item>
    <el-form-item label="已匹配金额" prop="dMatchedMoney">
      <el-input v-model="dataForm.dMatchedMoney" placeholder="已匹配金额"></el-input>
    </el-form-item>
    <el-form-item label="部分匹配11401,  完全匹配11402,   未匹配11403, 正在匹配11404" prop="dMatchedStatus">
      <el-input v-model="dataForm.dMatchedStatus" placeholder="部分匹配11401,  完全匹配11402,   未匹配11403, 正在匹配11404"></el-input>
    </el-form-item>
    <el-form-item label="还款方式名称" prop="dRepaymentStyleName">
      <el-input v-model="dataForm.dRepaymentStyleName" placeholder="还款方式名称"></el-input>
    </el-form-item>
    <el-form-item label="债权状态名字" prop="dDebtStatusName">
      <el-input v-model="dataForm.dDebtStatusName" placeholder="债权状态名字"></el-input>
    </el-form-item>
    <el-form-item label="匹配状态名称" prop="dMatchedStatusName">
      <el-input v-model="dataForm.dMatchedStatusName" placeholder="匹配状态名称"></el-input>
    </el-form-item>
    <el-form-item label="标的类型" prop="dDebtType">
      <el-input v-model="dataForm.dDebtType" placeholder="标的类型"></el-input>
    </el-form-item>
    <el-form-item label="标的类型名称" prop="dDebtTypeName">
      <el-input v-model="dataForm.dDebtTypeName" placeholder="标的类型名称"></el-input>
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
          dId: 0,
          dDebtNo: '',
          dContractNo: '',
          dDebtorsName: '',
          dDebtorsId: '',
          dLoanPurpose: '',
          dLoanType: '',
          dLoanStartDate: '',
          dLoanPeriod: '',
          dLoanEndDate: '',
          dRepaymentStyle: '',
          dRepaymenDate: '',
          dRepaymenMoney: '',
          dDebtMoney: '',
          dDebtYearRate: '',
          dDebtMonthRate: '',
          dDebtTransferredMoney: '',
          dDebtTransferredDate: '',
          dDebtTransferredPeriod: '',
          dDebtRansferOutDate: '',
          dCreditor: '',
          dDebtStatus: '',
          dBorrowerId: '',
          dAvailablePeriod: '',
          dAvailableMoney: '',
          dMatchedMoney: '',
          dMatchedStatus: '',
          dRepaymentStyleName: '',
          dDebtStatusName: '',
          dMatchedStatusName: '',
          dDebtType: '',
          dDebtTypeName: ''
        },
        dataRule: {
          dDebtNo: [
            { required: true, message: '债权编号不能为空', trigger: 'blur' }
          ],
          dContractNo: [
            { required: true, message: '合同编号不能为空', trigger: 'blur' }
          ],
          dDebtorsName: [
            { required: true, message: '债务人名称不能为空', trigger: 'blur' }
          ],
          dDebtorsId: [
            { required: true, message: '债务人身份证号不能为空', trigger: 'blur' }
          ],
          dLoanPurpose: [
            { required: true, message: '借款用途不能为空', trigger: 'blur' }
          ],
          dLoanType: [
            { required: true, message: '借款类型不能为空', trigger: 'blur' }
          ],
          dLoanStartDate: [
            { required: true, message: '原始借款开始日期不能为空', trigger: 'blur' }
          ],
          dLoanPeriod: [
            { required: true, message: '原始借款期限不能为空', trigger: 'blur' }
          ],
          dLoanEndDate: [
            { required: true, message: '原始借款到期日期不能为空', trigger: 'blur' }
          ],
          dRepaymentStyle: [
            { required: true, message: '还款方式不能为空', trigger: 'blur' }
          ],
          dRepaymenDate: [
            { required: true, message: '还款日不能为空', trigger: 'blur' }
          ],
          dRepaymenMoney: [
            { required: true, message: '还款金额不能为空', trigger: 'blur' }
          ],
          dDebtMoney: [
            { required: true, message: '债权金额不能为空', trigger: 'blur' }
          ],
          dDebtYearRate: [
            { required: true, message: '债权年化利率不能为空', trigger: 'blur' }
          ],
          dDebtMonthRate: [
            { required: true, message: '债权月利率不能为空', trigger: 'blur' }
          ],
          dDebtTransferredMoney: [
            { required: true, message: '债权转入金额不能为空', trigger: 'blur' }
          ],
          dDebtTransferredDate: [
            { required: true, message: '债权转入日期不能为空', trigger: 'blur' }
          ],
          dDebtTransferredPeriod: [
            { required: true, message: '债权转入期限不能为空', trigger: 'blur' }
          ],
          dDebtRansferOutDate: [
            { required: true, message: '债权转出日期不能为空', trigger: 'blur' }
          ],
          dCreditor: [
            { required: true, message: '债权人不能为空', trigger: 'blur' }
          ],
          dDebtStatus: [
            { required: true, message: '债权状态不能为空', trigger: 'blur' }
          ],
          dBorrowerId: [
            { required: true, message: '借款人ID不能为空', trigger: 'blur' }
          ],
          dAvailablePeriod: [
            { required: true, message: '可用期限不能为空', trigger: 'blur' }
          ],
          dAvailableMoney: [
            { required: true, message: '可用金额不能为空', trigger: 'blur' }
          ],
          dMatchedMoney: [
            { required: true, message: '已匹配金额不能为空', trigger: 'blur' }
          ],
          dMatchedStatus: [
            { required: true, message: '部分匹配11401,  完全匹配11402,   未匹配11403, 正在匹配11404不能为空', trigger: 'blur' }
          ],
          dRepaymentStyleName: [
            { required: true, message: '还款方式名称不能为空', trigger: 'blur' }
          ],
          dDebtStatusName: [
            { required: true, message: '债权状态名字不能为空', trigger: 'blur' }
          ],
          dMatchedStatusName: [
            { required: true, message: '匹配状态名称不能为空', trigger: 'blur' }
          ],
          dDebtType: [
            { required: true, message: '标的类型不能为空', trigger: 'blur' }
          ],
          dDebtTypeName: [
            { required: true, message: '标的类型名称不能为空', trigger: 'blur' }
          ]
        }
      }
    },
    methods: {
      init (id) {
        this.dataForm.dId = id || 0
        this.visible = true
        this.$nextTick(() => {
          this.$refs['dataForm'].resetFields()
          if (this.dataForm.dId) {
            this.$http({
              url: this.$http.adornUrl(`/team/debtinfo/info/${this.dataForm.dId}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.dDebtNo = data.debtinfo.dDebtNo
                this.dataForm.dContractNo = data.debtinfo.dContractNo
                this.dataForm.dDebtorsName = data.debtinfo.dDebtorsName
                this.dataForm.dDebtorsId = data.debtinfo.dDebtorsId
                this.dataForm.dLoanPurpose = data.debtinfo.dLoanPurpose
                this.dataForm.dLoanType = data.debtinfo.dLoanType
                this.dataForm.dLoanStartDate = data.debtinfo.dLoanStartDate
                this.dataForm.dLoanPeriod = data.debtinfo.dLoanPeriod
                this.dataForm.dLoanEndDate = data.debtinfo.dLoanEndDate
                this.dataForm.dRepaymentStyle = data.debtinfo.dRepaymentStyle
                this.dataForm.dRepaymenDate = data.debtinfo.dRepaymenDate
                this.dataForm.dRepaymenMoney = data.debtinfo.dRepaymenMoney
                this.dataForm.dDebtMoney = data.debtinfo.dDebtMoney
                this.dataForm.dDebtYearRate = data.debtinfo.dDebtYearRate
                this.dataForm.dDebtMonthRate = data.debtinfo.dDebtMonthRate
                this.dataForm.dDebtTransferredMoney = data.debtinfo.dDebtTransferredMoney
                this.dataForm.dDebtTransferredDate = data.debtinfo.dDebtTransferredDate
                this.dataForm.dDebtTransferredPeriod = data.debtinfo.dDebtTransferredPeriod
                this.dataForm.dDebtRansferOutDate = data.debtinfo.dDebtRansferOutDate
                this.dataForm.dCreditor = data.debtinfo.dCreditor
                this.dataForm.dDebtStatus = data.debtinfo.dDebtStatus
                this.dataForm.dBorrowerId = data.debtinfo.dBorrowerId
                this.dataForm.dAvailablePeriod = data.debtinfo.dAvailablePeriod
                this.dataForm.dAvailableMoney = data.debtinfo.dAvailableMoney
                this.dataForm.dMatchedMoney = data.debtinfo.dMatchedMoney
                this.dataForm.dMatchedStatus = data.debtinfo.dMatchedStatus
                this.dataForm.dRepaymentStyleName = data.debtinfo.dRepaymentStyleName
                this.dataForm.dDebtStatusName = data.debtinfo.dDebtStatusName
                this.dataForm.dMatchedStatusName = data.debtinfo.dMatchedStatusName
                this.dataForm.dDebtType = data.debtinfo.dDebtType
                this.dataForm.dDebtTypeName = data.debtinfo.dDebtTypeName
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
              url: this.$http.adornUrl(`/team/debtinfo/${!this.dataForm.dId ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'dId': this.dataForm.dId || undefined,
                'dDebtNo': this.dataForm.dDebtNo,
                'dContractNo': this.dataForm.dContractNo,
                'dDebtorsName': this.dataForm.dDebtorsName,
                'dDebtorsId': this.dataForm.dDebtorsId,
                'dLoanPurpose': this.dataForm.dLoanPurpose,
                'dLoanType': this.dataForm.dLoanType,
                'dLoanStartDate': this.dataForm.dLoanStartDate,
                'dLoanPeriod': this.dataForm.dLoanPeriod,
                'dLoanEndDate': this.dataForm.dLoanEndDate,
                'dRepaymentStyle': this.dataForm.dRepaymentStyle,
                'dRepaymenDate': this.dataForm.dRepaymenDate,
                'dRepaymenMoney': this.dataForm.dRepaymenMoney,
                'dDebtMoney': this.dataForm.dDebtMoney,
                'dDebtYearRate': this.dataForm.dDebtYearRate,
                'dDebtMonthRate': this.dataForm.dDebtMonthRate,
                'dDebtTransferredMoney': this.dataForm.dDebtTransferredMoney,
                'dDebtTransferredDate': this.dataForm.dDebtTransferredDate,
                'dDebtTransferredPeriod': this.dataForm.dDebtTransferredPeriod,
                'dDebtRansferOutDate': this.dataForm.dDebtRansferOutDate,
                'dCreditor': this.dataForm.dCreditor,
                'dDebtStatus': this.dataForm.dDebtStatus,
                'dBorrowerId': this.dataForm.dBorrowerId,
                'dAvailablePeriod': this.dataForm.dAvailablePeriod,
                'dAvailableMoney': this.dataForm.dAvailableMoney,
                'dMatchedMoney': this.dataForm.dMatchedMoney,
                'dMatchedStatus': this.dataForm.dMatchedStatus,
                'dRepaymentStyleName': this.dataForm.dRepaymentStyleName,
                'dDebtStatusName': this.dataForm.dDebtStatusName,
                'dMatchedStatusName': this.dataForm.dMatchedStatusName,
                'dDebtType': this.dataForm.dDebtType,
                'dDebtTypeName': this.dataForm.dDebtTypeName
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
