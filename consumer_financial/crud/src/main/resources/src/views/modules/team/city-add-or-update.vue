<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="城市编号" prop="tCityAreaNum">
      <el-input v-model="dataForm.tCityAreaNum" placeholder="城市编号"></el-input>
    </el-form-item>
    <el-form-item label="城市名称" prop="tCityName">
      <el-input v-model="dataForm.tCityName" placeholder="城市名称"></el-input>
    </el-form-item>
    <el-form-item label="城市级别 (0：省 ；1：市；2：县)" prop="tCityLevel">
      <el-input v-model="dataForm.tCityLevel" placeholder="城市级别 (0：省 ；1：市；2：县)"></el-input>
    </el-form-item>
    <el-form-item label="父级城市编号" prop="tParentCityNum">
      <el-input v-model="dataForm.tParentCityNum" placeholder="父级城市编号"></el-input>
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
          tCityAreaNum: '',
          tCityName: '',
          tCityLevel: '',
          tParentCityNum: ''
        },
        dataRule: {
          tCityAreaNum: [
            { required: true, message: '城市编号不能为空', trigger: 'blur' }
          ],
          tCityName: [
            { required: true, message: '城市名称不能为空', trigger: 'blur' }
          ],
          tCityLevel: [
            { required: true, message: '城市级别 (0：省 ；1：市；2：县)不能为空', trigger: 'blur' }
          ],
          tParentCityNum: [
            { required: true, message: '父级城市编号不能为空', trigger: 'blur' }
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
              url: this.$http.adornUrl(`/team/city/info/${this.dataForm.tId}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.tCityAreaNum = data.city.tCityAreaNum
                this.dataForm.tCityName = data.city.tCityName
                this.dataForm.tCityLevel = data.city.tCityLevel
                this.dataForm.tParentCityNum = data.city.tParentCityNum
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
              url: this.$http.adornUrl(`/team/city/${!this.dataForm.tId ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'tId': this.dataForm.tId || undefined,
                'tCityAreaNum': this.dataForm.tCityAreaNum,
                'tCityName': this.dataForm.tCityName,
                'tCityLevel': this.dataForm.tCityLevel,
                'tParentCityNum': this.dataForm.tParentCityNum
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
