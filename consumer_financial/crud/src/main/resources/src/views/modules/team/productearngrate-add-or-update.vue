<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="利率值" prop="tIncomerate">
      <el-input v-model="dataForm.tIncomerate" placeholder="利率值"></el-input>
    </el-form-item>
    <el-form-item label="月份" prop="tMonth">
      <el-input v-model="dataForm.tMonth" placeholder="月份"></el-input>
    </el-form-item>
    <el-form-item label="产品编号" prop="tPid">
      <el-input v-model="dataForm.tPid" placeholder="产品编号"></el-input>
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
          tIncomerate: '',
          tMonth: '',
          tPid: ''
        },
        dataRule: {
          tIncomerate: [
            { required: true, message: '利率值不能为空', trigger: 'blur' }
          ],
          tMonth: [
            { required: true, message: '月份不能为空', trigger: 'blur' }
          ],
          tPid: [
            { required: true, message: '产品编号不能为空', trigger: 'blur' }
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
              url: this.$http.adornUrl(`/team/productearngrate/info/${this.dataForm.tId}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.tIncomerate = data.productearngrate.tIncomerate
                this.dataForm.tMonth = data.productearngrate.tMonth
                this.dataForm.tPid = data.productearngrate.tPid
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
              url: this.$http.adornUrl(`/team/productearngrate/${!this.dataForm.tId ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'tId': this.dataForm.tId || undefined,
                'tIncomerate': this.dataForm.tIncomerate,
                'tMonth': this.dataForm.tMonth,
                'tPid': this.dataForm.tPid
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
