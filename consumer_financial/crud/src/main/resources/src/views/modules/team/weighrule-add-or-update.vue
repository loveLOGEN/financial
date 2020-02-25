<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="类别编号" prop="tSerialno">
      <el-input v-model="dataForm.tSerialno" placeholder="类别编号"></el-input>
    </el-form-item>
    <el-form-item label="权重规则类型名称" prop="tWeighruleName">
      <el-input v-model="dataForm.tWeighruleName" placeholder="权重规则类型名称"></el-input>
    </el-form-item>
    <el-form-item label="权重类别  资金类 140 债权类 140" prop="tWeigthruleClass">
      <el-input v-model="dataForm.tWeigthruleClass" placeholder="权重类别  资金类 140 债权类 140"></el-input>
    </el-form-item>
    <el-form-item label="权重类型   " prop="tWeigthType">
      <el-input v-model="dataForm.tWeigthType" placeholder="权重类型   "></el-input>
    </el-form-item>
    <el-form-item label="权重值" prop="tWeigthValue">
      <el-input v-model="dataForm.tWeigthValue" placeholder="权重值"></el-input>
    </el-form-item>
    <el-form-item label="排序" prop="tOrder">
      <el-input v-model="dataForm.tOrder" placeholder="排序"></el-input>
    </el-form-item>
    <el-form-item label="权重类别名称" prop="tWeigthruleClassname">
      <el-input v-model="dataForm.tWeigthruleClassname" placeholder="权重类别名称"></el-input>
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
          tSerialno: '',
          tWeighruleName: '',
          tWeigthruleClass: '',
          tWeigthType: '',
          tWeigthValue: '',
          tOrder: '',
          tWeigthruleClassname: ''
        },
        dataRule: {
          tSerialno: [
            { required: true, message: '类别编号不能为空', trigger: 'blur' }
          ],
          tWeighruleName: [
            { required: true, message: '权重规则类型名称不能为空', trigger: 'blur' }
          ],
          tWeigthruleClass: [
            { required: true, message: '权重类别  资金类 140 债权类 140不能为空', trigger: 'blur' }
          ],
          tWeigthType: [
            { required: true, message: '权重类型   不能为空', trigger: 'blur' }
          ],
          tWeigthValue: [
            { required: true, message: '权重值不能为空', trigger: 'blur' }
          ],
          tOrder: [
            { required: true, message: '排序不能为空', trigger: 'blur' }
          ],
          tWeigthruleClassname: [
            { required: true, message: '权重类别名称不能为空', trigger: 'blur' }
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
              url: this.$http.adornUrl(`/team/weighrule/info/${this.dataForm.tId}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.tSerialno = data.weighrule.tSerialno
                this.dataForm.tWeighruleName = data.weighrule.tWeighruleName
                this.dataForm.tWeigthruleClass = data.weighrule.tWeigthruleClass
                this.dataForm.tWeigthType = data.weighrule.tWeigthType
                this.dataForm.tWeigthValue = data.weighrule.tWeigthValue
                this.dataForm.tOrder = data.weighrule.tOrder
                this.dataForm.tWeigthruleClassname = data.weighrule.tWeigthruleClassname
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
              url: this.$http.adornUrl(`/team/weighrule/${!this.dataForm.tId ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'tId': this.dataForm.tId || undefined,
                'tSerialno': this.dataForm.tSerialno,
                'tWeighruleName': this.dataForm.tWeighruleName,
                'tWeigthruleClass': this.dataForm.tWeigthruleClass,
                'tWeigthType': this.dataForm.tWeigthType,
                'tWeigthValue': this.dataForm.tWeigthValue,
                'tOrder': this.dataForm.tOrder,
                'tWeigthruleClassname': this.dataForm.tWeigthruleClassname
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
