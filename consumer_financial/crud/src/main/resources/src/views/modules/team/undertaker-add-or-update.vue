<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="手续费" prop="tCost">
      <el-input v-model="dataForm.tCost" placeholder="手续费"></el-input>
    </el-form-item>
    <el-form-item label="承担者: 1 表示用户承担，0 表示平台承担" prop="tUndertaker">
      <el-input v-model="dataForm.tUndertaker" placeholder="承担者: 1 表示用户承担，0 表示平台承担"></el-input>
    </el-form-item>
    <el-form-item label="0 充值; 1提现" prop="tType">
      <el-input v-model="dataForm.tType" placeholder="0 充值; 1提现"></el-input>
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
          tCost: '',
          tUndertaker: '',
          tType: ''
        },
        dataRule: {
          tCost: [
            { required: true, message: '手续费不能为空', trigger: 'blur' }
          ],
          tUndertaker: [
            { required: true, message: '承担者: 1 表示用户承担，0 表示平台承担不能为空', trigger: 'blur' }
          ],
          tType: [
            { required: true, message: '0 充值; 1提现不能为空', trigger: 'blur' }
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
              url: this.$http.adornUrl(`/team/undertaker/info/${this.dataForm.tId}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.tCost = data.undertaker.tCost
                this.dataForm.tUndertaker = data.undertaker.tUndertaker
                this.dataForm.tType = data.undertaker.tType
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
              url: this.$http.adornUrl(`/team/undertaker/${!this.dataForm.tId ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'tId': this.dataForm.tId || undefined,
                'tCost': this.dataForm.tCost,
                'tUndertaker': this.dataForm.tUndertaker,
                'tType': this.dataForm.tType
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
