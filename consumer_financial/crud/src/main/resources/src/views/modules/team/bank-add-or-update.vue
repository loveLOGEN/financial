<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="银行编号" prop="tNumber">
      <el-input v-model="dataForm.tNumber" placeholder="银行编号"></el-input>
    </el-form-item>
    <el-form-item label="银行名称" prop="tName">
      <el-input v-model="dataForm.tName" placeholder="银行名称"></el-input>
    </el-form-item>
    <el-form-item label="说明" prop="tDesc">
      <el-input v-model="dataForm.tDesc" placeholder="说明"></el-input>
    </el-form-item>
    <el-form-item label="是否停用该行（0停；1启用）" prop="tStatus">
      <el-input v-model="dataForm.tStatus" placeholder="是否停用该行（0停；1启用）"></el-input>
    </el-form-item>
    <el-form-item label="城市编号" prop="tCityCode">
      <el-input v-model="dataForm.tCityCode" placeholder="城市编号"></el-input>
    </el-form-item>
    <el-form-item label="城市级别" prop="tLevel">
      <el-input v-model="dataForm.tLevel" placeholder="城市级别"></el-input>
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
          tNumber: '',
          tName: '',
          tDesc: '',
          tStatus: '',
          tCityCode: '',
          tLevel: ''
        },
        dataRule: {
          tNumber: [
            { required: true, message: '银行编号不能为空', trigger: 'blur' }
          ],
          tName: [
            { required: true, message: '银行名称不能为空', trigger: 'blur' }
          ],
          tDesc: [
            { required: true, message: '说明不能为空', trigger: 'blur' }
          ],
          tStatus: [
            { required: true, message: '是否停用该行（0停；1启用）不能为空', trigger: 'blur' }
          ],
          tCityCode: [
            { required: true, message: '城市编号不能为空', trigger: 'blur' }
          ],
          tLevel: [
            { required: true, message: '城市级别不能为空', trigger: 'blur' }
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
              url: this.$http.adornUrl(`/team/bank/info/${this.dataForm.tId}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.tNumber = data.bank.tNumber
                this.dataForm.tName = data.bank.tName
                this.dataForm.tDesc = data.bank.tDesc
                this.dataForm.tStatus = data.bank.tStatus
                this.dataForm.tCityCode = data.bank.tCityCode
                this.dataForm.tLevel = data.bank.tLevel
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
              url: this.$http.adornUrl(`/team/bank/${!this.dataForm.tId ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'tId': this.dataForm.tId || undefined,
                'tNumber': this.dataForm.tNumber,
                'tName': this.dataForm.tName,
                'tDesc': this.dataForm.tDesc,
                'tStatus': this.dataForm.tStatus,
                'tCityCode': this.dataForm.tCityCode,
                'tLevel': this.dataForm.tLevel
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
