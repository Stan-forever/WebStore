<template>
  <div>
    <Menu>
      <div slot="first">
        <el-container style="margin-left: 20px">
          <div style="font-size: 15px; margin-top: 5px; margin-right: 10px">用户角色:</div>
          <el-select v-model="value" filterable placeholder="请选择"
                     size="small" style="margin-right: 10px" @change="currentSel">
            <el-option
                v-for="item in tableData"
                :key="item.id"
                :label="item.proName"
                :value="item">
            </el-option>
          </el-select>
          <el-button type="primary" icon="el-icon-search" size="small" @click="searchBill">搜索</el-button>
          <el-button icon="el-icon-circle-plus-outline"
                     size="small" style="background-color: #409EFF; color: white"
                     @click="dialogAddVisible = true"
          >添加供应商</el-button>
        </el-container>
        <el-dialog title="用户添加" :visible.sync="dialogAddVisible" style="height: 900px">
          <el-form :model="formAdd">
            <el-form-item label="用户编号" :label-width="formLabelWidth">
              <el-input autocomplete="off" v-model="formAdd.userCode"></el-input>
            </el-form-item>
            <el-form-item label="用户名称" :label-width="formLabelWidth">
              <el-input autocomplete="off" v-model="formAdd.userName" ></el-input>
            </el-form-item>
            <el-form-item label="用户密码" :label-width="formLabelWidth">
              <el-input autocomplete="off" v-model="formAdd.userPassword" ></el-input>
            </el-form-item>
            <el-form-item label="用户性别" :label-width="formLabelWidth">
              <el-input autocomplete="off" v-model="formAdd.sex" ></el-input>
            </el-form-item>
            <el-form-item label="用户电话" :label-width="formLabelWidth">
              <el-input autocomplete="off" v-model="formAdd.phone" ></el-input>
            </el-form-item>
            <el-form-item label="用户地址" :label-width="formLabelWidth">
              <el-input autocomplete="off" v-model="formAdd.address" ></el-input>
            </el-form-item>
            <span style="margin-left: 30px ;margin-right: 50px">性别</span>
            <template >
              <el-radio v-model="radioAdd" label="1">男</el-radio>
              <el-radio v-model="radioAdd" label="2">女</el-radio>
            </template>
          </el-form>
          <span slot="footer" class="dialog-footer">
                    <el-button @click="dialogAddVisible = false">取 消</el-button>
                    <el-button type="primary" @click="saveAdd">确 定</el-button>
                  </span>
        </el-dialog>
        <el-container style="margin-top: 20px">
          <el-table :data="tableData"
                    border
                    height="750"
                    style="width: 100%">
            <el-table-column
                fixed
                prop="userCode"
                label="用户编码"
                width="150">
            </el-table-column>
            <el-table-column
                fixed
                prop="userName"
                label="用户名称"
                width="150">
            </el-table-column>
            <el-table-column
                fixed
                prop="sex"
                label="性别"
                width="70">
            </el-table-column>
            <el-table-column
                fixed
                prop="age"
                label="年龄"
                width="70">
            </el-table-column>
            <el-table-column
                fixed
                prop="phone"
                label="电话"
                width="150">
            </el-table-column>
            <el-table-column
                fixed
                prop="userName"
                label="用户角色"
                width="150">
            </el-table-column>
            <el-table-column
                fixed
                label="操作"
                width="150">
              <i class="el-icon-view"></i>
              <i class="el-icon-edit"></i>
              <i class="el-icon-delete"></i>
            </el-table-column>
          </el-table>
        </el-container>
      </div>
    </Menu>
  </div>
</template>

<script>
import Menu from '../components/menu'
export default {
  name: "user",
  components: {
    Menu
  },
  data() {
    return {
      tableData: [],
      dialogAddVisible: false,
      formAdd: {
        userCode: '',
        userName: '',
        userPassword: '',
        sex: '',
        phone: '',
        address: ''
      },
      formLabelWidth: '100px',
      radioAdd: '2',
    }
  },
  mounted() {
    this.$axios.post('http://localhost:8089/user/getuserlist.do').then(res => {
      console.log(res)
      this.tableData = res.data;
    })
  },
  methods: {
    saveAdd() {
      this.$axios.post('http://localhost:8089/user/insertUser.do', {
        userCode: this.formAdd.userCode,
        userName: this.formAdd.userName,
        userPassword: this.formAdd.userPassword,
        sex: this.formAdd.sex,
        phone: this.formAdd.phone,
        address: this.formAdd.address
      })
    }
  }
}
</script>

<style scoped>

</style>