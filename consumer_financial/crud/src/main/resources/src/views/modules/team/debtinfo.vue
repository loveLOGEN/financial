<template>
  <div class="mod-config">
    <el-form :inline="true" :model="dataForm" @keyup.enter.native="getDataList()">
      <el-form-item>
        <el-input v-model="dataForm.key" placeholder="参数名" clearable></el-input>
      </el-form-item>
      <el-form-item>
        <el-button @click="getDataList()">查询</el-button>
        <el-button v-if="isAuth('team:debtinfo:save')" type="primary" @click="addOrUpdateHandle()">新增</el-button>
        <el-button v-if="isAuth('team:debtinfo:delete')" type="danger" @click="deleteHandle()" :disabled="dataListSelections.length <= 0">批量删除</el-button>
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
        prop="dId"
        header-align="center"
        align="center"
        label="主键">
      </el-table-column>
      <el-table-column
        prop="dDebtNo"
        header-align="center"
        align="center"
        label="债权编号">
      </el-table-column>
      <el-table-column
        prop="dContractNo"
        header-align="center"
        align="center"
        label="合同编号">
      </el-table-column>
      <el-table-column
        prop="dDebtorsName"
        header-align="center"
        align="center"
        label="债务人名称">
      </el-table-column>
      <el-table-column
        prop="dDebtorsId"
        header-align="center"
        align="center"
        label="债务人身份证号">
      </el-table-column>
      <el-table-column
        prop="dLoanPurpose"
        header-align="center"
        align="center"
        label="借款用途">
      </el-table-column>
      <el-table-column
        prop="dLoanType"
        header-align="center"
        align="center"
        label="借款类型">
      </el-table-column>
      <el-table-column
        prop="dLoanStartDate"
        header-align="center"
        align="center"
        label="原始借款开始日期">
      </el-table-column>
      <el-table-column
        prop="dLoanPeriod"
        header-align="center"
        align="center"
        label="原始借款期限">
      </el-table-column>
      <el-table-column
        prop="dLoanEndDate"
        header-align="center"
        align="center"
        label="原始借款到期日期">
      </el-table-column>
      <el-table-column
        prop="dRepaymentStyle"
        header-align="center"
        align="center"
        label="还款方式">
      </el-table-column>
      <el-table-column
        prop="dRepaymenDate"
        header-align="center"
        align="center"
        label="还款日">
      </el-table-column>
      <el-table-column
        prop="dRepaymenMoney"
        header-align="center"
        align="center"
        label="还款金额">
      </el-table-column>
      <el-table-column
        prop="dDebtMoney"
        header-align="center"
        align="center"
        label="债权金额">
      </el-table-column>
      <el-table-column
        prop="dDebtYearRate"
        header-align="center"
        align="center"
        label="债权年化利率">
      </el-table-column>
      <el-table-column
        prop="dDebtMonthRate"
        header-align="center"
        align="center"
        label="债权月利率">
      </el-table-column>
      <el-table-column
        prop="dDebtTransferredMoney"
        header-align="center"
        align="center"
        label="债权转入金额">
      </el-table-column>
      <el-table-column
        prop="dDebtTransferredDate"
        header-align="center"
        align="center"
        label="债权转入日期">
      </el-table-column>
      <el-table-column
        prop="dDebtTransferredPeriod"
        header-align="center"
        align="center"
        label="债权转入期限">
      </el-table-column>
      <el-table-column
        prop="dDebtRansferOutDate"
        header-align="center"
        align="center"
        label="债权转出日期">
      </el-table-column>
      <el-table-column
        prop="dCreditor"
        header-align="center"
        align="center"
        label="债权人">
      </el-table-column>
      <el-table-column
        prop="dDebtStatus"
        header-align="center"
        align="center"
        label="债权状态">
      </el-table-column>
      <el-table-column
        prop="dBorrowerId"
        header-align="center"
        align="center"
        label="借款人ID">
      </el-table-column>
      <el-table-column
        prop="dAvailablePeriod"
        header-align="center"
        align="center"
        label="可用期限">
      </el-table-column>
      <el-table-column
        prop="dAvailableMoney"
        header-align="center"
        align="center"
        label="可用金额">
      </el-table-column>
      <el-table-column
        prop="dMatchedMoney"
        header-align="center"
        align="center"
        label="已匹配金额">
      </el-table-column>
      <el-table-column
        prop="dMatchedStatus"
        header-align="center"
        align="center"
        label="部分匹配11401,  完全匹配11402,   未匹配11403, 正在匹配11404">
      </el-table-column>
      <el-table-column
        prop="dRepaymentStyleName"
        header-align="center"
        align="center"
        label="还款方式名称">
      </el-table-column>
      <el-table-column
        prop="dDebtStatusName"
        header-align="center"
        align="center"
        label="债权状态名字">
      </el-table-column>
      <el-table-column
        prop="dMatchedStatusName"
        header-align="center"
        align="center"
        label="匹配状态名称">
      </el-table-column>
      <el-table-column
        prop="dDebtType"
        header-align="center"
        align="center"
        label="标的类型">
      </el-table-column>
      <el-table-column
        prop="dDebtTypeName"
        header-align="center"
        align="center"
        label="标的类型名称">
      </el-table-column>
      <el-table-column
        fixed="right"
        header-align="center"
        align="center"
        width="150"
        label="操作">
        <template slot-scope="scope">
          <el-button type="text" size="small" @click="addOrUpdateHandle(scope.row.dId)">修改</el-button>
          <el-button type="text" size="small" @click="deleteHandle(scope.row.dId)">删除</el-button>
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
  import AddOrUpdate from './debtinfo-add-or-update'
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
          url: this.$http.adornUrl('/team/debtinfo/list'),
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
          return item.dId
        })
        this.$confirm(`确定对[id=${ids.join(',')}]进行[${id ? '删除' : '批量删除'}]操作?`, '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
          this.$http({
            url: this.$http.adornUrl('/team/debtinfo/delete'),
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
