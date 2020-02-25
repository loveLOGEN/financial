<template>
  <div class="mod-config">
    <el-form :inline="true" :model="dataForm" @keyup.enter.native="getDataList()">
      <el-form-item>
        <el-input v-model="dataForm.key" placeholder="参数名" clearable></el-input>
      </el-form-item>
      <el-form-item>
        <el-button @click="getDataList()">查询</el-button>
        <el-button v-if="isAuth('team:user:save')" type="primary" @click="addOrUpdateHandle()">新增</el-button>
        <el-button v-if="isAuth('team:user:delete')" type="danger" @click="deleteHandle()" :disabled="dataListSelections.length <= 0">批量删除</el-button>
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
        prop="tId"
        header-align="center"
        align="center"
        label="id">
      </el-table-column>
      <el-table-column
        prop="tEmail"
        header-align="center"
        align="center"
        label="用户邮箱">
      </el-table-column>
      <el-table-column
        prop="tEmailStatus"
        header-align="center"
        align="center"
        label="邮箱验证">
      </el-table-column>
      <el-table-column
        prop="tIdentity"
        header-align="center"
        align="center"
        label="用户id">
      </el-table-column>
      <el-table-column
        prop="tInvtteid"
        header-align="center"
        align="center"
        label="邀请码">
      </el-table-column>
      <el-table-column
        prop="tIp"
        header-align="center"
        align="center"
        label="登录ip">
      </el-table-column>
      <el-table-column
        prop="tLoginTime"
        header-align="center"
        align="center"
        label="登录时间">
      </el-table-column>
      <el-table-column
        prop="tOnlock"
        header-align="center"
        align="center"
        label="锁">
      </el-table-column>
      <el-table-column
        prop="tPassword"
        header-align="center"
        align="center"
        label="登录密码">
      </el-table-column>
      <el-table-column
        prop="tPayPassword"
        header-align="center"
        align="center"
        label="支付密码">
      </el-table-column>
      <el-table-column
        prop="tPayPwdStatus"
        header-align="center"
        align="center"
        label="支付密码验证">
      </el-table-column>
      <el-table-column
        prop="tPhone"
        header-align="center"
        align="center"
        label="电话">
      </el-table-column>
      <el-table-column
        prop="tPhoneStatus"
        header-align="center"
        align="center"
        label="手机验证">
      </el-table-column>
      <el-table-column
        prop="tRandomCode"
        header-align="center"
        align="center"
        label="随机激活码">
      </el-table-column>
      <el-table-column
        prop="tRealname"
        header-align="center"
        align="center"
        label="真实姓名">
      </el-table-column>
      <el-table-column
        prop="tRealnameStatus"
        header-align="center"
        align="center"
        label="实名验证">
      </el-table-column>
      <el-table-column
        prop="tRegesterTime"
        header-align="center"
        align="center"
        label="注册时间">
      </el-table-column>
      <el-table-column
        prop="tRemark"
        header-align="center"
        align="center"
        label="备注">
      </el-table-column>
      <el-table-column
        prop="tSumfriend"
        header-align="center"
        align="center"
        label="好友数量统计">
      </el-table-column>
      <el-table-column
        prop="tUserSecure"
        header-align="center"
        align="center"
        label="安全等级">
      </el-table-column>
      <el-table-column
        prop="tUsertype"
        header-align="center"
        align="center"
        label="用户类型0投资人1借款人">
      </el-table-column>
      <el-table-column
        prop="tUsername"
        header-align="center"
        align="center"
        label="用户登录名">
      </el-table-column>
      <el-table-column
        fixed="right"
        header-align="center"
        align="center"
        width="150"
        label="操作">
        <template slot-scope="scope">
          <el-button type="text" size="small" @click="addOrUpdateHandle(scope.row.tId)">修改</el-button>
          <el-button type="text" size="small" @click="deleteHandle(scope.row.tId)">删除</el-button>
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
  import AddOrUpdate from './user-add-or-update'
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
          url: this.$http.adornUrl('/team/user/list'),
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
          return item.tId
        })
        this.$confirm(`确定对[id=${ids.join(',')}]进行[${id ? '删除' : '批量删除'}]操作?`, '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
          this.$http({
            url: this.$http.adornUrl('/team/user/delete'),
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
