<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="产品id" prop="pProductId">
      <el-input v-model="dataForm.pProductId" placeholder="产品id"></el-input>
    </el-form-item>
    <el-form-item label="用户id" prop="pUId">
      <el-input v-model="dataForm.pUId" placeholder="用户id"></el-input>
    </el-form-item>
    <el-form-item label="" prop="pSerialNo">
      <el-input v-model="dataForm.pSerialNo" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="加入日期" prop="pBeginDate">
      <el-input v-model="dataForm.pBeginDate" placeholder="加入日期"></el-input>
    </el-form-item>
    <el-form-item label="到期日期" prop="pEndDate">
      <el-input v-model="dataForm.pEndDate" placeholder="到期日期"></el-input>
    </el-form-item>
    <el-form-item label="赎回日期" prop="pRedeemDate">
      <el-input v-model="dataForm.pRedeemDate" placeholder="赎回日期"></el-input>
    </el-form-item>
    <el-form-item label="匹配日期" prop="pMatchDate">
      <el-input v-model="dataForm.pMatchDate" placeholder="匹配日期"></el-input>
    </el-form-item>
    <el-form-item label="金额" prop="pAmount">
      <el-input v-model="dataForm.pAmount" placeholder="金额"></el-input>
    </el-form-item>
    <el-form-item label="系统时间" prop="pDate">
      <el-input v-model="dataForm.pDate" placeholder="系统时间"></el-input>
    </el-form-item>
    <el-form-item label="产品类型" prop="pProType">
      <el-input v-model="dataForm.pProType" placeholder="产品类型"></el-input>
    </el-form-item>
    <el-form-item label="收益率类型" prop="pEarningsType">
      <el-input v-model="dataForm.pEarningsType" placeholder="收益率类型"></el-input>
    </el-form-item>
    <el-form-item label="收益率" prop="pEarnings">
      <el-input v-model="dataForm.pEarnings" placeholder="收益率"></el-input>
    </el-form-item>
    <el-form-item label="提前赎回利率" prop="pAdvRedemption">
      <el-input v-model="dataForm.pAdvRedemption" placeholder="提前赎回利率"></el-input>
    </el-form-item>
    <el-form-item label="选择期限" prop="pDeadline">
      <el-input v-model="dataForm.pDeadline" placeholder="选择期限"></el-input>
    </el-form-item>
    <el-form-item label="当前期（账户资金日志表）" prop="aCurrentPeriod">
      <el-input v-model="dataForm.aCurrentPeriod" placeholder="当前期（账户资金日志表）"></el-input>
    </el-form-item>
    <el-form-item label="预期收益" prop="pProEarnings">
      <el-input v-model="dataForm.pProEarnings" placeholder="预期收益"></el-input>
    </el-form-item>
    <el-form-item label="预期年化收益" prop="pExpAnnualIncome">
      <el-input v-model="dataForm.pExpAnnualIncome" placeholder="预期年化收益"></el-input>
    </el-form-item>
    <el-form-item label="每月盈取利息" prop="pMonthInterest">
      <el-input v-model="dataForm.pMonthInterest" placeholder="每月盈取利息"></el-input>
    </el-form-item>
    <el-form-item label="每月提取利息" prop="pMonthlyExtInterest">
      <el-input v-model="dataForm.pMonthlyExtInterest" placeholder="每月提取利息"></el-input>
    </el-form-item>
    <el-form-item label="开始计息时间" prop="pInterestStartDate">
      <el-input v-model="dataForm.pInterestStartDate" placeholder="开始计息时间"></el-input>
    </el-form-item>
    <el-form-item label="结束计息时间" prop="pInterestEndDate">
      <el-input v-model="dataForm.pInterestEndDate" placeholder="结束计息时间"></el-input>
    </el-form-item>
    <el-form-item label="收益是否完成" prop="pEarIsFinished">
      <el-input v-model="dataForm.pEarIsFinished" placeholder="收益是否完成"></el-input>
    </el-form-item>
    <el-form-item label="可用余额" prop="pAvaBal">
      <el-input v-model="dataForm.pAvaBal" placeholder="可用余额"></el-input>
    </el-form-item>
    <el-form-item label="冻结金额" prop="pFrozenMoney">
      <el-input v-model="dataForm.pFrozenMoney" placeholder="冻结金额"></el-input>
    </el-form-item>
    <el-form-item label="每月回款日" prop="pSysPayDate">
      <el-input v-model="dataForm.pSysPayDate" placeholder="每月回款日"></el-input>
    </el-form-item>
    <el-form-item label="当前期（用户购买产品记录表）" prop="pCurrentMonth">
      <el-input v-model="dataForm.pCurrentMonth" placeholder="当前期（用户购买产品记录表）"></el-input>
    </el-form-item>
    <el-form-item label="扣去利息" prop="pDeductInterest">
      <el-input v-model="dataForm.pDeductInterest" placeholder="扣去利息"></el-input>
    </el-form-item>
    <el-form-item label="未投资金额" prop="pNotInvMon">
      <el-input v-model="dataForm.pNotInvMon" placeholder="未投资金额"></el-input>
    </el-form-item>
    <el-form-item label="状态" prop="pStatus">
      <el-input v-model="dataForm.pStatus" placeholder="状态"></el-input>
    </el-form-item>
    <el-form-item label="到期应回总本息" prop="pEndInvTotMon">
      <el-input v-model="dataForm.pEndInvTotMon" placeholder="到期应回总本息"></el-input>
    </el-form-item>
    <el-form-item label="当前期实回总本息" prop="pCurRealTotMon">
      <el-input v-model="dataForm.pCurRealTotMon" placeholder="当前期实回总本息"></el-input>
    </el-form-item>
    <el-form-item label="统计" prop="pDeadlineCount">
      <el-input v-model="dataForm.pDeadlineCount" placeholder="统计"></el-input>
    </el-form-item>
    <el-form-item label="产品名称" prop="pProductName">
      <el-input v-model="dataForm.pProductName" placeholder="产品名称"></el-input>
    </el-form-item>
    <el-form-item label="月存" prop="pMonthlyDeposit">
      <el-input v-model="dataForm.pMonthlyDeposit" placeholder="月存"></el-input>
    </el-form-item>
    <el-form-item label="月存笔数" prop="pMonthlyDepositCount">
      <el-input v-model="dataForm.pMonthlyDepositCount" placeholder="月存笔数"></el-input>
    </el-form-item>
    <el-form-item label="月乘" prop="pTakeMonth">
      <el-input v-model="dataForm.pTakeMonth" placeholder="月乘"></el-input>
    </el-form-item>
    <el-form-item label="月乘笔数" prop="pTakeMonthCount">
      <el-input v-model="dataForm.pTakeMonthCount" placeholder="月乘笔数"></el-input>
    </el-form-item>
    <el-form-item label="月取" prop="pMayTake">
      <el-input v-model="dataForm.pMayTake" placeholder="月取"></el-input>
    </el-form-item>
    <el-form-item label="月取笔数" prop="pMayTakeCount">
      <el-input v-model="dataForm.pMayTakeCount" placeholder="月取笔数"></el-input>
    </el-form-item>
    <el-form-item label="总天数" prop="pTotalAsDay">
      <el-input v-model="dataForm.pTotalAsDay" placeholder="总天数"></el-input>
    </el-form-item>
    <el-form-item label="投资天数" prop="pDeadlineAsDay">
      <el-input v-model="dataForm.pDeadlineAsDay" placeholder="投资天数"></el-input>
    </el-form-item>
    <el-form-item label="" prop="pDays">
      <el-input v-model="dataForm.pDays" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="投资期限" prop="pDeadlines">
      <el-input v-model="dataForm.pDeadlines" placeholder="投资期限"></el-input>
    </el-form-item>
    <el-form-item label="投资用户名" prop="uUserName">
      <el-input v-model="dataForm.uUserName" placeholder="投资用户名"></el-input>
    </el-form-item>
    <el-form-item label="已赚取利息" prop="pEarnedInter">
      <el-input v-model="dataForm.pEarnedInter" placeholder="已赚取利息"></el-input>
    </el-form-item>
    <el-form-item label="备注" prop="pRemark">
      <el-input v-model="dataForm.pRemark" placeholder="备注"></el-input>
    </el-form-item>
    <el-form-item label="SUM(可用余额+冻结金额)" prop="sumAvabalFrozenmoney">
      <el-input v-model="dataForm.sumAvabalFrozenmoney" placeholder="SUM(可用余额+冻结金额)"></el-input>
    </el-form-item>
    <el-form-item label="总计" prop="pTotal">
      <el-input v-model="dataForm.pTotal" placeholder="总计"></el-input>
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
          pId: 0,
          pProductId: '',
          pUId: '',
          pSerialNo: '',
          pBeginDate: '',
          pEndDate: '',
          pRedeemDate: '',
          pMatchDate: '',
          pAmount: '',
          pDate: '',
          pProType: '',
          pEarningsType: '',
          pEarnings: '',
          pAdvRedemption: '',
          pDeadline: '',
          aCurrentPeriod: '',
          pProEarnings: '',
          pExpAnnualIncome: '',
          pMonthInterest: '',
          pMonthlyExtInterest: '',
          pInterestStartDate: '',
          pInterestEndDate: '',
          pEarIsFinished: '',
          pAvaBal: '',
          pFrozenMoney: '',
          pSysPayDate: '',
          pCurrentMonth: '',
          pDeductInterest: '',
          pNotInvMon: '',
          pStatus: '',
          pEndInvTotMon: '',
          pCurRealTotMon: '',
          pDeadlineCount: '',
          pProductName: '',
          pMonthlyDeposit: '',
          pMonthlyDepositCount: '',
          pTakeMonth: '',
          pTakeMonthCount: '',
          pMayTake: '',
          pMayTakeCount: '',
          pTotalAsDay: '',
          pDeadlineAsDay: '',
          pDays: '',
          pDeadlines: '',
          uUserName: '',
          pEarnedInter: '',
          pRemark: '',
          sumAvabalFrozenmoney: '',
          pTotal: ''
        },
        dataRule: {
          pProductId: [
            { required: true, message: '产品id不能为空', trigger: 'blur' }
          ],
          pUId: [
            { required: true, message: '用户id不能为空', trigger: 'blur' }
          ],
          pSerialNo: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          pBeginDate: [
            { required: true, message: '加入日期不能为空', trigger: 'blur' }
          ],
          pEndDate: [
            { required: true, message: '到期日期不能为空', trigger: 'blur' }
          ],
          pRedeemDate: [
            { required: true, message: '赎回日期不能为空', trigger: 'blur' }
          ],
          pMatchDate: [
            { required: true, message: '匹配日期不能为空', trigger: 'blur' }
          ],
          pAmount: [
            { required: true, message: '金额不能为空', trigger: 'blur' }
          ],
          pDate: [
            { required: true, message: '系统时间不能为空', trigger: 'blur' }
          ],
          pProType: [
            { required: true, message: '产品类型不能为空', trigger: 'blur' }
          ],
          pEarningsType: [
            { required: true, message: '收益率类型不能为空', trigger: 'blur' }
          ],
          pEarnings: [
            { required: true, message: '收益率不能为空', trigger: 'blur' }
          ],
          pAdvRedemption: [
            { required: true, message: '提前赎回利率不能为空', trigger: 'blur' }
          ],
          pDeadline: [
            { required: true, message: '选择期限不能为空', trigger: 'blur' }
          ],
          aCurrentPeriod: [
            { required: true, message: '当前期（账户资金日志表）不能为空', trigger: 'blur' }
          ],
          pProEarnings: [
            { required: true, message: '预期收益不能为空', trigger: 'blur' }
          ],
          pExpAnnualIncome: [
            { required: true, message: '预期年化收益不能为空', trigger: 'blur' }
          ],
          pMonthInterest: [
            { required: true, message: '每月盈取利息不能为空', trigger: 'blur' }
          ],
          pMonthlyExtInterest: [
            { required: true, message: '每月提取利息不能为空', trigger: 'blur' }
          ],
          pInterestStartDate: [
            { required: true, message: '开始计息时间不能为空', trigger: 'blur' }
          ],
          pInterestEndDate: [
            { required: true, message: '结束计息时间不能为空', trigger: 'blur' }
          ],
          pEarIsFinished: [
            { required: true, message: '收益是否完成不能为空', trigger: 'blur' }
          ],
          pAvaBal: [
            { required: true, message: '可用余额不能为空', trigger: 'blur' }
          ],
          pFrozenMoney: [
            { required: true, message: '冻结金额不能为空', trigger: 'blur' }
          ],
          pSysPayDate: [
            { required: true, message: '每月回款日不能为空', trigger: 'blur' }
          ],
          pCurrentMonth: [
            { required: true, message: '当前期（用户购买产品记录表）不能为空', trigger: 'blur' }
          ],
          pDeductInterest: [
            { required: true, message: '扣去利息不能为空', trigger: 'blur' }
          ],
          pNotInvMon: [
            { required: true, message: '未投资金额不能为空', trigger: 'blur' }
          ],
          pStatus: [
            { required: true, message: '状态不能为空', trigger: 'blur' }
          ],
          pEndInvTotMon: [
            { required: true, message: '到期应回总本息不能为空', trigger: 'blur' }
          ],
          pCurRealTotMon: [
            { required: true, message: '当前期实回总本息不能为空', trigger: 'blur' }
          ],
          pDeadlineCount: [
            { required: true, message: '统计不能为空', trigger: 'blur' }
          ],
          pProductName: [
            { required: true, message: '产品名称不能为空', trigger: 'blur' }
          ],
          pMonthlyDeposit: [
            { required: true, message: '月存不能为空', trigger: 'blur' }
          ],
          pMonthlyDepositCount: [
            { required: true, message: '月存笔数不能为空', trigger: 'blur' }
          ],
          pTakeMonth: [
            { required: true, message: '月乘不能为空', trigger: 'blur' }
          ],
          pTakeMonthCount: [
            { required: true, message: '月乘笔数不能为空', trigger: 'blur' }
          ],
          pMayTake: [
            { required: true, message: '月取不能为空', trigger: 'blur' }
          ],
          pMayTakeCount: [
            { required: true, message: '月取笔数不能为空', trigger: 'blur' }
          ],
          pTotalAsDay: [
            { required: true, message: '总天数不能为空', trigger: 'blur' }
          ],
          pDeadlineAsDay: [
            { required: true, message: '投资天数不能为空', trigger: 'blur' }
          ],
          pDays: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          pDeadlines: [
            { required: true, message: '投资期限不能为空', trigger: 'blur' }
          ],
          uUserName: [
            { required: true, message: '投资用户名不能为空', trigger: 'blur' }
          ],
          pEarnedInter: [
            { required: true, message: '已赚取利息不能为空', trigger: 'blur' }
          ],
          pRemark: [
            { required: true, message: '备注不能为空', trigger: 'blur' }
          ],
          sumAvabalFrozenmoney: [
            { required: true, message: 'SUM(可用余额+冻结金额)不能为空', trigger: 'blur' }
          ],
          pTotal: [
            { required: true, message: '总计不能为空', trigger: 'blur' }
          ]
        }
      }
    },
    methods: {
      init (id) {
        this.dataForm.pId = id || 0
        this.visible = true
        this.$nextTick(() => {
          this.$refs['dataForm'].resetFields()
          if (this.dataForm.pId) {
            this.$http({
              url: this.$http.adornUrl(`/team/productaccount/info/${this.dataForm.pId}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.pProductId = data.productaccount.pProductId
                this.dataForm.pUId = data.productaccount.pUId
                this.dataForm.pSerialNo = data.productaccount.pSerialNo
                this.dataForm.pBeginDate = data.productaccount.pBeginDate
                this.dataForm.pEndDate = data.productaccount.pEndDate
                this.dataForm.pRedeemDate = data.productaccount.pRedeemDate
                this.dataForm.pMatchDate = data.productaccount.pMatchDate
                this.dataForm.pAmount = data.productaccount.pAmount
                this.dataForm.pDate = data.productaccount.pDate
                this.dataForm.pProType = data.productaccount.pProType
                this.dataForm.pEarningsType = data.productaccount.pEarningsType
                this.dataForm.pEarnings = data.productaccount.pEarnings
                this.dataForm.pAdvRedemption = data.productaccount.pAdvRedemption
                this.dataForm.pDeadline = data.productaccount.pDeadline
                this.dataForm.aCurrentPeriod = data.productaccount.aCurrentPeriod
                this.dataForm.pProEarnings = data.productaccount.pProEarnings
                this.dataForm.pExpAnnualIncome = data.productaccount.pExpAnnualIncome
                this.dataForm.pMonthInterest = data.productaccount.pMonthInterest
                this.dataForm.pMonthlyExtInterest = data.productaccount.pMonthlyExtInterest
                this.dataForm.pInterestStartDate = data.productaccount.pInterestStartDate
                this.dataForm.pInterestEndDate = data.productaccount.pInterestEndDate
                this.dataForm.pEarIsFinished = data.productaccount.pEarIsFinished
                this.dataForm.pAvaBal = data.productaccount.pAvaBal
                this.dataForm.pFrozenMoney = data.productaccount.pFrozenMoney
                this.dataForm.pSysPayDate = data.productaccount.pSysPayDate
                this.dataForm.pCurrentMonth = data.productaccount.pCurrentMonth
                this.dataForm.pDeductInterest = data.productaccount.pDeductInterest
                this.dataForm.pNotInvMon = data.productaccount.pNotInvMon
                this.dataForm.pStatus = data.productaccount.pStatus
                this.dataForm.pEndInvTotMon = data.productaccount.pEndInvTotMon
                this.dataForm.pCurRealTotMon = data.productaccount.pCurRealTotMon
                this.dataForm.pDeadlineCount = data.productaccount.pDeadlineCount
                this.dataForm.pProductName = data.productaccount.pProductName
                this.dataForm.pMonthlyDeposit = data.productaccount.pMonthlyDeposit
                this.dataForm.pMonthlyDepositCount = data.productaccount.pMonthlyDepositCount
                this.dataForm.pTakeMonth = data.productaccount.pTakeMonth
                this.dataForm.pTakeMonthCount = data.productaccount.pTakeMonthCount
                this.dataForm.pMayTake = data.productaccount.pMayTake
                this.dataForm.pMayTakeCount = data.productaccount.pMayTakeCount
                this.dataForm.pTotalAsDay = data.productaccount.pTotalAsDay
                this.dataForm.pDeadlineAsDay = data.productaccount.pDeadlineAsDay
                this.dataForm.pDays = data.productaccount.pDays
                this.dataForm.pDeadlines = data.productaccount.pDeadlines
                this.dataForm.uUserName = data.productaccount.uUserName
                this.dataForm.pEarnedInter = data.productaccount.pEarnedInter
                this.dataForm.pRemark = data.productaccount.pRemark
                this.dataForm.sumAvabalFrozenmoney = data.productaccount.sumAvabalFrozenmoney
                this.dataForm.pTotal = data.productaccount.pTotal
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
              url: this.$http.adornUrl(`/team/productaccount/${!this.dataForm.pId ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'pId': this.dataForm.pId || undefined,
                'pProductId': this.dataForm.pProductId,
                'pUId': this.dataForm.pUId,
                'pSerialNo': this.dataForm.pSerialNo,
                'pBeginDate': this.dataForm.pBeginDate,
                'pEndDate': this.dataForm.pEndDate,
                'pRedeemDate': this.dataForm.pRedeemDate,
                'pMatchDate': this.dataForm.pMatchDate,
                'pAmount': this.dataForm.pAmount,
                'pDate': this.dataForm.pDate,
                'pProType': this.dataForm.pProType,
                'pEarningsType': this.dataForm.pEarningsType,
                'pEarnings': this.dataForm.pEarnings,
                'pAdvRedemption': this.dataForm.pAdvRedemption,
                'pDeadline': this.dataForm.pDeadline,
                'aCurrentPeriod': this.dataForm.aCurrentPeriod,
                'pProEarnings': this.dataForm.pProEarnings,
                'pExpAnnualIncome': this.dataForm.pExpAnnualIncome,
                'pMonthInterest': this.dataForm.pMonthInterest,
                'pMonthlyExtInterest': this.dataForm.pMonthlyExtInterest,
                'pInterestStartDate': this.dataForm.pInterestStartDate,
                'pInterestEndDate': this.dataForm.pInterestEndDate,
                'pEarIsFinished': this.dataForm.pEarIsFinished,
                'pAvaBal': this.dataForm.pAvaBal,
                'pFrozenMoney': this.dataForm.pFrozenMoney,
                'pSysPayDate': this.dataForm.pSysPayDate,
                'pCurrentMonth': this.dataForm.pCurrentMonth,
                'pDeductInterest': this.dataForm.pDeductInterest,
                'pNotInvMon': this.dataForm.pNotInvMon,
                'pStatus': this.dataForm.pStatus,
                'pEndInvTotMon': this.dataForm.pEndInvTotMon,
                'pCurRealTotMon': this.dataForm.pCurRealTotMon,
                'pDeadlineCount': this.dataForm.pDeadlineCount,
                'pProductName': this.dataForm.pProductName,
                'pMonthlyDeposit': this.dataForm.pMonthlyDeposit,
                'pMonthlyDepositCount': this.dataForm.pMonthlyDepositCount,
                'pTakeMonth': this.dataForm.pTakeMonth,
                'pTakeMonthCount': this.dataForm.pTakeMonthCount,
                'pMayTake': this.dataForm.pMayTake,
                'pMayTakeCount': this.dataForm.pMayTakeCount,
                'pTotalAsDay': this.dataForm.pTotalAsDay,
                'pDeadlineAsDay': this.dataForm.pDeadlineAsDay,
                'pDays': this.dataForm.pDays,
                'pDeadlines': this.dataForm.pDeadlines,
                'uUserName': this.dataForm.uUserName,
                'pEarnedInter': this.dataForm.pEarnedInter,
                'pRemark': this.dataForm.pRemark,
                'sumAvabalFrozenmoney': this.dataForm.sumAvabalFrozenmoney,
                'pTotal': this.dataForm.pTotal
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
