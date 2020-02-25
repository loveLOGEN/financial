<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="消息状态" prop="sMessageState">
      <el-input v-model="dataForm.sMessageState" placeholder="消息状态"></el-input>
    </el-form-item>
    <el-form-item label="消息内容" prop="sMessageContent">
      <el-input v-model="dataForm.sMessageContent" placeholder="消息内容"></el-input>
    </el-form-item>
    <el-form-item label="发送时间" prop="sSystemTime">
      <el-input v-model="dataForm.sSystemTime" placeholder="发送时间"></el-input>
    </el-form-item>
    <el-form-item label="发送类型" prop="sInformationType">
      <el-input v-model="dataForm.sInformationType" placeholder="发送类型"></el-input>
    </el-form-item>
    <el-form-item label="用户id" prop="sReceiveUserId">
      <el-input v-model="dataForm.sReceiveUserId" placeholder="用户id"></el-input>
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
          sId: 0,
          sMessageState: '',
          sMessageContent: '',
          sSystemTime: '',
          sInformationType: '',
          sReceiveUserId: ''
        },
        dataRule: {
          sMessageState: [
            { required: true, message: '消息状态不能为空', trigger: 'blur' }
          ],
          sMessageContent: [
            { required: true, message: '消息内容不能为空', trigger: 'blur' }
          ],
          sSystemTime: [
            { required: true, message: '发送时间不能为空', trigger: 'blur' }
          ],
          sInformationType: [
            { required: true, message: '发送类型不能为空', trigger: 'blur' }
          ],
          sReceiveUserId: [
            { required: true, message: '用户id不能为空', trigger: 'blur' }
          ]
        }
      }
    },
    methods: {
      init (id) {
        this.dataForm.sId = id || 0
        this.visible = true
        this.$nextTick(() => {
          this.$refs['dataForm'].resetFields()
          if (this.dataForm.sId) {
            this.$http({
              url: this.$http.adornUrl(`/team/stationinformation/info/${this.dataForm.sId}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.sMessageState = data.stationinformation.sMessageState
                this.dataForm.sMessageContent = data.stationinformation.sMessageContent
                this.dataForm.sSystemTime = data.stationinformation.sSystemTime
                this.dataForm.sInformationType = data.stationinformation.sInformationType
                this.dataForm.sReceiveUserId = data.stationinformation.sReceiveUserId
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
              url: this.$http.adornUrl(`/team/stationinformation/${!this.dataForm.sId ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'sId': this.dataForm.sId || undefined,
                'sMessageState': this.dataForm.sMessageState,
                'sMessageContent': this.dataForm.sMessageContent,
                'sSystemTime': this.dataForm.sSystemTime,
                'sInformationType': this.dataForm.sInformationType,
                'sReceiveUserId': this.dataForm.sReceiveUserId
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
