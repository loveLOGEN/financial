<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="债权id" prop="tClaimsId">
      <el-input v-model="dataForm.tClaimsId" placeholder="债权id"></el-input>
    </el-form-item>
    <el-form-item label="应还日期" prop="tReceivableDate">
      <el-input v-model="dataForm.tReceivableDate" placeholder="应还日期"></el-input>
    </el-form-item>
    <el-form-item label="应还金额" prop="tReceiveableMoney">
      <el-input v-model="dataForm.tReceiveableMoney" placeholder="应还金额"></el-input>
    </el-form-item>
    <el-form-item label="当前还款期" prop="tCurrentTerm">
      <el-input v-model="dataForm.tCurrentTerm" placeholder="当前还款期"></el-input>
    </el-form-item>
    <el-form-item label="记录日期" prop="tRecordDate">
      <el-input v-model="dataForm.tRecordDate" placeholder="记录日期"></el-input>
    </el-form-item>
    <el-form-item label="是否还款" prop="tIsreturned">
      <el-input v-model="dataForm.tIsreturned" placeholder="是否还款"></el-input>
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
          tClaimsId: '',
          tReceivableDate: '',
          tReceiveableMoney: '',
          tCurrentTerm: '',
          tRecordDate: '',
          tIsreturned: ''
        },
        dataRule: {
          tClaimsId: [
            { required: true, message: '债权id不能为空', trigger: 'blur' }
          ],
          tReceivableDate: [
            { required: true, message: '应还日期不能为空', trigger: 'blur' }
          ],
          tReceiveableMoney: [
            { required: true, message: '应还金额不能为空', trigger: 'blur' }
          ],
          tCurrentTerm: [
            { required: true, message: '当前还款期不能为空', trigger: 'blur' }
          ],
          tRecordDate: [
            { required: true, message: '记录日期不能为空', trigger: 'blur' }
          ],
          tIsreturned: [
            { required: true, message: '是否还款不能为空', trigger: 'blur' }
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
              url: this.$http.adornUrl(`/team/debtorrecord/info/${this.dataForm.tId}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.tClaimsId = data.debtorrecord.tClaimsId
                this.dataForm.tReceivableDate = data.debtorrecord.tReceivableDate
                this.dataForm.tReceiveableMoney = data.debtorrecord.tReceiveableMoney
                this.dataForm.tCurrentTerm = data.debtorrecord.tCurrentTerm
                this.dataForm.tRecordDate = data.debtorrecord.tRecordDate
                this.dataForm.tIsreturned = data.debtorrecord.tIsreturned
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
              url: this.$http.adornUrl(`/team/debtorrecord/${!this.dataForm.tId ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'tId': this.dataForm.tId || undefined,
                'tClaimsId': this.dataForm.tClaimsId,
                'tReceivableDate': this.dataForm.tReceivableDate,
                'tReceiveableMoney': this.dataForm.tReceiveableMoney,
                'tCurrentTerm': this.dataForm.tCurrentTerm,
                'tRecordDate': this.dataForm.tRecordDate,
                'tIsreturned': this.dataForm.tIsreturned
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
