<template>
  <div class="mod-config">
    <el-form :inline="true" :model="dataForm" @keyup.enter.native="getDataList()">
      <el-form-item>
        <el-input v-model="dataForm.key" placeholder="参数名" clearable></el-input>
      </el-form-item>
      <el-form-item>
        <el-button @click="getDataList()">查询</el-button>
        <el-button v-if="isAuth('team:productaccount:save')" type="primary" @click="addOrUpdateHandle()">新增</el-button>
        <el-button v-if="isAuth('team:productaccount:delete')" type="danger" @click="deleteHandle()" :disabled="dataListSelections.length <= 0">批量删除</el-button>
      </el-form-item>
    </el-form>
    <el-table
      :data="dataList"
      border
      v-loading="dataListLoading"
      @selection-change="selectionChangeHandle"
      style="width: 100%;">
      <el-table-column
        type="selection"
        header-align="center"
        align="center"
        width="50">
      </el-table-column>
      <el-table-column
        prop="pId"
        header-align="center"
        align="center"
        label="主键">
      </el-table-column>
      <el-table-column
        prop="pProductId"
        header-align="center"
        align="center"
        label="产品id">
      </el-table-column>
      <el-table-column
        prop="pUId"
        header-align="center"
        align="center"
        label="用户id">
      </el-table-column>
      <el-table-column
        prop="pSerialNo"
        header-align="center"
        align="center"
        label="">
      </el-table-column>
      <el-table-column
        prop="pBeginDate"
        header-align="center"
        align="center"
        label="加入日期">
      </el-table-column>
      <el-table-column
        prop="pEndDate"
        header-align="center"
        align="center"
        label="到期日期">
      </el-table-column>
      <el-table-column
        prop="pRedeemDate"
        header-align="center"
        align="center"
        label="赎回日期">
      </el-table-column>
      <el-table-column
        prop="pMatchDate"
        header-align="center"
        align="center"
        label="匹配日期">
      </el-table-column>
      <el-table-column
        prop="pAmount"
        header-align="center"
        align="center"
        label="金额">
      </el-table-column>
      <el-table-column
        prop="pDate"
        header-align="center"
        align="center"
        label="系统时间">
      </el-table-column>
      <el-table-column
        prop="pProType"
        header-align="center"
        align="center"
        label="产品类型">
      </el-table-column>
      <el-table-column
        prop="pEarningsType"
        header-align="center"
        align="center"
        label="收益率类型">
      </el-table-column>
      <el-table-column
        prop="pEarnings"
        header-align="center"
        align="center"
        label="收益率">
      </el-table-column>
      <el-table-column
        prop="pAdvRedemption"
        header-align="center"
        align="center"
        label="提前赎回利率">
      </el-table-column>
      <el-table-column
        prop="pDeadline"
        header-align="center"
        align="center"
        label="选择期限">
      </el-table-column>
      <el-table-column
        prop="aCurrentPeriod"
        header-align="center"
        align="center"
        label="当前期（账户资金日志表）">
      </el-table-column>
      <el-table-column
        prop="pProEarnings"
        header-align="center"
        align="center"
        label="预期收益">
      </el-table-column>
      <el-table-column
        prop="pExpAnnualIncome"
        header-align="center"
        align="center"
        label="预期年化收益">
      </el-table-column>
      <el-table-column
        prop="pMonthInterest"
        header-align="center"
        align="center"
        label="每月盈取利息">
      </el-table-column>
      <el-table-column
        prop="pMonthlyExtInterest"
        header-align="center"
        align="center"
        label="每月提取利息">
      </el-table-column>
      <el-table-column
        prop="pInterestStartDate"
        header-align="center"
        align="center"
        label="开始计息时间">
      </el-table-column>
      <el-table-column
        prop="pInterestEndDate"
        header-align="center"
        align="center"
        label="结束计息时间">
      </el-table-column>
      <el-table-column
        prop="pEarIsFinished"
        header-align="center"
        align="center"
        label="收益是否完成">
      </el-table-column>
      <el-table-column
        prop="pAvaBal"
        header-align="center"
        align="center"
        label="可用余额">
      </el-table-column>
      <el-table-column
        prop="pFrozenMoney"
        header-align="center"
        align="center"
        label="冻结金额">
      </el-table-column>
      <el-table-column
        prop="pSysPayDate"
        header-align="center"
        align="center"
        label="每月回款日">
      </el-table-column>
      <el-table-column
        prop="pCurrentMonth"
        header-align="center"
        align="center"
        label="当前期（用户购买产品记录表）">
      </el-table-column>
      <el-table-column
        prop="pDeductInterest"
        header-align="center"
        align="center"
        label="扣去利息">
      </el-table-column>
      <el-table-column
        prop="pNotInvMon"
        header-align="center"
        align="center"
        label="未投资金额">
      </el-table-column>
      <el-table-column
        prop="pStatus"
        header-align="center"
        align="center"
        label="状态">
      </el-table-column>
      <el-table-column
        prop="pEndInvTotMon"
        header-align="center"
        align="center"
        label="到期应回总本息">
      </el-table-column>
      <el-table-column
        prop="pCurRealTotMon"
        header-align="center"
        align="center"
        label="当前期实回总本息">
      </el-table-column>
      <el-table-column
        prop="pDeadlineCount"
        header-align="center"
        align="center"
        label="统计">
      </el-table-column>
      <el-table-column
        prop="pProductName"
        header-align="center"
        align="center"
        label="产品名称">
      </el-table-column>
      <el-table-column
        prop="pMonthlyDeposit"
        header-align="center"
        align="center"
        label="月存">
      </el-table-column>
      <el-table-column
        prop="pMonthlyDepositCount"
        header-align="center"
        align="center"
        label="月存笔数">
      </el-table-column>
      <el-table-column
        prop="pTakeMonth"
        header-align="center"
        align="center"
        label="月乘">
      </el-table-column>
      <el-table-column
        prop="pTakeMonthCount"
        header-align="center"
        align="center"
        label="月乘笔数">
      </el-table-column>
      <el-table-column
        prop="pMayTake"
        header-align="center"
        align="center"
        label="月取">
      </el-table-column>
      <el-table-column
        prop="pMayTakeCount"
        header-align="center"
        align="center"
        label="月取笔数">
      </el-table-column>
      <el-table-column
        prop="pTotalAsDay"
        header-align="center"
        align="center"
        label="总天数">
      </el-table-column>
      <el-table-column
        prop="pDeadlineAsDay"
        header-align="center"
        align="center"
        label="投资天数">
      </el-table-column>
      <el-table-column
        prop="pDays"
        header-align="center"
        align="center"
        label="">
      </el-table-column>
      <el-table-column
        prop="pDeadlines"
        header-align="center"
        align="center"
        label="投资期限">
      </el-table-column>
      <el-table-column
        prop="uUserName"
        header-align="center"
        align="center"
        label="投资用户名">
      </el-table-column>
      <el-table-column
        prop="pEarnedInter"
        header-align="center"
        align="center"
        label="已赚取利息">
      </el-table-column>
      <el-table-column
        prop="pRemark"
        header-align="center"
        align="center"
        label="备注">
      </el-table-column>
      <el-table-column
        prop="sumAvabalFrozenmoney"
        header-align="center"
        align="center"
        label="SUM(可用余额+冻结金额)">
      </el-table-column>
      <el-table-column
        prop="pTotal"
        header-align="center"
        align="center"
        label="总计">
      </el-table-column>
      <el-table-column
        fixed="right"
        header-align="center"
        align="center"
        width="150"
        label="操作">
        <template slot-scope="scope">
          <el-button type="text" size="small" @click="addOrUpdateHandle(scope.row.pId)">修改</el-button>
          <el-button type="text" size="small" @click="deleteHandle(scope.row.pId)">删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    <el-pagination
      @size-change="sizeChangeHandle"
      @current-change="currentChangeHandle"
      :current-page="pageIndex"
      :page-sizes="[10, 20, 50, 100]"
      :page-size="pageSize"
      :total="totalPage"
      layout="total, sizes, prev, pager, next, jumper">
    </el-pagination>
    <!-- 弹窗, 新增 / 修改 -->
    <add-or-update v-if="addOrUpdateVisible" ref="addOrUpdate" @refreshDataList="getDataList"></add-or-update>
  </div>
</template>

<script>
  import AddOrUpdate from './productaccount-add-or-update'
  export default {
    data () {
      return {
        dataForm: {
          key: ''
        },
        dataList: [],
        pageIndex: 1,
        pageSize: 10,
        totalPage: 0,
        dataListLoading: false,
        dataListSelections: [],
        addOrUpdateVisible: false
      }
    },
    components: {
      AddOrUpdate
    },
    activated () {
      this.getDataList()
    },
    methods: {
      // 获取数据列表
      getDataList () {
        this.dataListLoading = true
        this.$http({
          url: this.$http.adornUrl('/team/productaccount/list'),
          method: 'get',
          params: this.$http.adornParams({
            'page': this.pageIndex,
            'limit': this.pageSize,
            'key': this.dataForm.key
          })
        }).then(({data}) => {
          if (data && data.code === 0) {
            this.dataList = data.page.list
            this.totalPage = data.page.totalCount
          } else {
            this.dataList = []
            this.totalPage = 0
          }
          this.dataListLoading = false
        })
      },
      // 每页数
      sizeChangeHandle (val) {
        this.pageSize = val
        this.pageIndex = 1
        this.getDataList()
      },
      // 当前页
      currentChangeHandle (val) {
        this.pageIndex = val
        this.getDataList()
      },
      // 多选
      selectionChangeHandle (val) {
        this.dataListSelections = val
      },
      // 新增 / 修改
      addOrUpdateHandle (id) {
        this.addOrUpdateVisible = true
        this.$nextTick(() => {
          this.$refs.addOrUpdate.init(id)
        })
      },
      // 删除
      deleteHandle (id) {
        var ids = id ? [id] : this.dataListSelections.map(item => {
          return item.pId
        })
        this.$confirm(`确定对[id=${ids.join(',')}]进行[${id ? '删除' : '批量删除'}]操作?`, '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
          this.$http({
            url: this.$http.adornUrl('/team/productaccount/delete'),
            method: 'post',
            data: this.$http.adornData(ids, false)
          }).then(({data}) => {
            if (data && data.code === 0) {
              this.$message({
                message: '操作成功',
                type: 'success',
                duration: 1500,
                onClose: () => {
                  this.getDataList()
                }
              })
            } else {
              this.$message.error(data.msg)
            }
          })
        })
      }
    }
  }
</script>
