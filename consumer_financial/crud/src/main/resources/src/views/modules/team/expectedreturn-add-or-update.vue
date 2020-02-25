<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="用户ID" prop="tUid">
      <el-input v-model="dataForm.tUid" placeholder="用户ID"></el-input>
    </el-form-item>
    <el-form-item label="产品ID" prop="tPid">
      <el-input v-model="dataForm.tPid" placeholder="产品ID"></el-input>
    </el-form-item>
    <el-form-item label="投资记录ID" prop="tRid">
      <el-input v-model="dataForm.tRid" placeholder="投资记录ID"></el-input>
    </el-form-item>
    <el-form-item label="收益日期" prop="tExpectedDate">
      <el-input v-model="dataForm.tExpectedDate" placeholder="收益日期"></el-input>
    </el-form-item>
    <el-form-item label="收益金额" prop="tExpectedMoney">
      <el-input v-model="dataForm.tExpectedMoney" placeholder="收益金额"></el-input>
    </el-form-item>
    <el-form-item label="创建日期" prop="tCreateDate">
      <el-input v-model="dataForm.tCreateDate" placeholder="创建日期"></el-input>
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
          tUid: '',
          tPid: '',
          tRid: '',
          tExpectedDate: '',
          tExpectedMoney: '',
          tCreateDate: ''
        },
        dataRule: {
          tUid: [
            { required: true, message: '用户ID不能为空', trigger: 'blur' }
          ],
          tPid: [
            { required: true, message: '产品ID不能为空', trigger: 'blur' }
          ],
          tRid: [
            { required: true, message: '投资记录ID不能为空', trigger: 'blur' }
          ],
          tExpectedDate: [
            { required: true, message: '收益日期不能为空', trigger: 'blur' }
          ],
          tExpectedMoney: [
            { required: true, message: '收益金额不能为空', trigger: 'blur' }
          ],
          tCreateDate: [
            { required: true, message: '创建日期不能为空', trigger: 'blur' }
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
              url: this.$http.adornUrl(`/team/expectedreturn/info/${this.dataForm.tId}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.tUid = data.expectedreturn.tUid
                this.dataForm.tPid = data.expectedreturn.tPid
                this.dataForm.tRid = data.expectedreturn.tRid
                this.dataForm.tExpectedDate = data.expectedreturn.tExpectedDate
                this.dataForm.tExpectedMoney = data.expectedreturn.tExpectedMoney
                this.dataForm.tCreateDate = data.expectedreturn.tCreateDate
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
              url: this.$http.adornUrl(`/team/expectedreturn/${!this.dataForm.tId ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'tId': this.dataForm.tId || undefined,
                'tUid': this.dataForm.tUid,
                'tPid': this.dataForm.tPid,
                'tRid': this.dataForm.tRid,
                'tExpectedDate': this.dataForm.tExpectedDate,
                'tExpectedMoney': this.dataForm.tExpectedMoney,
                'tCreateDate': this.dataForm.tCreateDate
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
