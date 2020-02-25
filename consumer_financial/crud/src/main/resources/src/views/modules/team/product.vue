<template>
  <div class="mod-config">
    <el-form :inline="true" :model="dataForm" @keyup.enter.native="getDataList()">
      <el-form-item>
        <el-input v-model="dataForm.key" placeholder="参数名" clearable></el-input>
      </el-form-item>
      <el-form-item>
        <el-button @click="getDataList()">查询</el-button>
        <el-button v-if="isAuth('team:product:save')" type="primary" @click="addOrUpdateHandle()">新增</el-button>
        <el-button v-if="isAuth('team:product:delete')" type="danger" @click="deleteHandle()" :disabled="dataListSelections.length <= 0">批量删除</el-button>
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
        prop="tPid"
        header-align="center"
        align="center"
        label="产品id">
      </el-table-column>
      <el-table-column
        prop="tClosePreiod"
        header-align="center"
        align="center"
        label="转让封闭期">
      </el-table-column>
      <el-table-column
        prop="tEarlyRedeptionType"
        header-align="center"
        align="center"
        label="提前赎回类型">
      </el-table-column>
      <el-table-column
        prop="tEartingType"
        header-align="center"
        align="center"
        label="收益利率类型（134：年利率 ，135：月利率）">
      </el-table-column>
      <el-table-column
        prop="tInvestRule"
        header-align="center"
        align="center"
        label="数量规则">
      </el-table-column>
      <el-table-column
        prop="tAllowTransfer"
        header-align="center"
        align="center"
        label="是否可转让">
      </el-table-column>
      <el-table-column
        prop="tIsRepeatInvest"
        header-align="center"
        align="center"
        label="是否复投">
      </el-table-column>
      <el-table-column
        prop="tLowerLimit"
        header-align="center"
        align="center"
        label="产品最低期限">
      </el-table-column>
      <el-table-column
        prop="tLowerInvest"
        header-align="center"
        align="center"
        label="产品起投金额">
      </el-table-column>
      <el-table-column
        prop="tPronum"
        header-align="center"
        align="center"
        label="产品编号">
      </el-table-column>
      <el-table-column
        prop="tProtypeId"
        header-align="center"
        align="center"
        label="产品类型id">
      </el-table-column>
      <el-table-column
        prop="tUpperInvest"
        header-align="center"
        align="center"
        label="产品投资上限">
      </el-table-column>
      <el-table-column
        prop="tProductName"
        header-align="center"
        align="center"
        label="产品名称">
      </el-table-column>
      <el-table-column
        prop="tStatus"
        header-align="center"
        align="center"
        label="状态(0:表示正常；1：表示停用)">
      </el-table-column>
      <el-table-column
        prop="tUpperLimit"
        header-align="center"
        align="center"
        label="产品最大期限">
      </el-table-column>
      <el-table-column
        prop="tReturnMoney"
        header-align="center"
        align="center"
        label="回款方式（109：表示一次性回款 ，110：每月提取，到期退出）">
      </el-table-column>
      <el-table-column
        fixed="right"
        header-align="center"
        align="center"
        width="150"
        label="操作">
        <template slot-scope="scope">
          <el-button type="text" size="small" @click="addOrUpdateHandle(scope.row.tPid)">修改</el-button>
          <el-button type="text" size="small" @click="deleteHandle(scope.row.tPid)">删除</el-button>
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
  import AddOrUpdate from './product-add-or-update'
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
          url: this.$http.adornUrl('/team/product/list'),
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
          return item.tPid
        })
        this.$confirm(`确定对[id=${ids.join(',')}]进行[${id ? '删除' : '批量删除'}]操作?`, '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
          this.$http({
            url: this.$http.adornUrl('/team/product/delete'),
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
