<template>
  <div>
    <Menu>
      <div slot="first">
        <el-container style="margin-left: 20px">
          <div style="font-size: 15px; margin-top: 5px; margin-right: 10px">供应商:</div>
          <el-select v-model="value" filterable placeholder="请选择" size="small" style="margin-right: 10px" @change="currentValue">
            <el-option
                v-for="(item,index) in options"
                :key="index"
                :label="item.proCode"
                :value="item.proCode">
            </el-option>
          </el-select>
          <el-button type="primary" icon="el-icon-search" size="small" @click="searchBill">搜索</el-button>
          <el-button icon="el-icon-circle-plus-outline"
                     size="small" style="background-color: #409EFF; color: white"
                     @click="dialogAddVisible = true"
          >添加供应商</el-button>
        </el-container >
        <el-dialog title="供应商添加" :visible.sync="dialogAddVisible" style="height: 900px">
          <el-form :model="formAdd">
            <el-form-item label="供应商名称" :label-width="formLabelWidth">
              <el-input autocomplete="off" v-model="formAdd.proName" ></el-input>
            </el-form-item>
            <el-form-item label="供应商描述" :label-width="formLabelWidth">
              <el-input autocomplete="off" v-model="formAdd.proDesc" ></el-input>
            </el-form-item>
            <el-form-item label="供应商联系人" :label-width="formLabelWidth">
              <el-input autocomplete="off" v-model="formAdd.proContact" ></el-input>
            </el-form-item>
            <el-form-item label="供应商电话" :label-width="formLabelWidth">
              <el-input autocomplete="off" v-model="formAdd.proPhone" ></el-input>
            </el-form-item>
            <el-form-item label="供应商地址" :label-width="formLabelWidth">
              <el-input autocomplete="off" v-model="formAdd.proAddress" ></el-input>
            </el-form-item>
            <el-form-item label="供应商传真" :label-width="formLabelWidth">
              <el-input autocomplete="off" v-model="formAdd.proFax" ></el-input>
            </el-form-item>
          </el-form>
          <span slot="footer" class="dialog-footer">
          <el-button @click="dialogAddVisible = false">取 消</el-button>
          <el-button type="primary" @click="saveAdd">确 定</el-button>
      </span>
        </el-dialog>
        <el-dialog title="供应商详情" :visible.sync="dialogDetailVisible" style="height: 900px">
          <el-form :model="formDetail">
            <el-form-item label="供应商编号" :label-width="formLabelWidth">
              <el-input autocomplete="off" v-model="formDetail.proCode" :disabled="true"></el-input>
            </el-form-item>
            <el-form-item label="供应商名称" :label-width="formLabelWidth">
              <el-input autocomplete="off" v-model="formDetail.proName" :disabled="true"></el-input>
            </el-form-item>
            <el-form-item label="联系人" :label-width="formLabelWidth">
              <el-input autocomplete="off" v-model="formDetail.proContact" :disabled="true"></el-input>
            </el-form-item>
            <el-form-item label="联系电话" :label-width="formLabelWidth">
              <el-input autocomplete="off" v-model="formDetail.proPhone" :disabled="true"></el-input>
            </el-form-item>
            <el-form-item label="传真" :label-width="formLabelWidth">
              <el-input autocomplete="off" v-model="formDetail.proFax" :disabled="true"></el-input>
            </el-form-item>
            <el-form-item label="描述" :label-width="formLabelWidth">
              <el-input autocomplete="off" v-model="formDetail.proDesc" :disabled="true"></el-input>
            </el-form-item>
          </el-form>
        </el-dialog>
        <el-container style="margin-top: 20px">
          <el-table :data="tableData"
                    border
                    height="730"
                    style="width: 100%">
            <el-table-column
                prop="proCode"
                label="供应商编码"
                width="150">
            </el-table-column>
            <el-table-column
                prop="proName"
                label="供应商名称"
                width="150">
            </el-table-column>
            <el-table-column
                prop="proContact"
                label="联系人"
                width="70">
            </el-table-column>
            <el-table-column
                prop="proPhone"
                label="联系电话"
                width="150">
            </el-table-column>
            <el-table-column
                prop="proFax"
                label="传真"
                width="150">
            </el-table-column>
            <el-table-column
                prop="creationDate"
                label="创建时间"
                width="150">
            </el-table-column>
            <el-table-column
                label="操作"
                width="180">
              <template slot-scope="scope">
                <el-button icon="el-icon-view" circle @click.native.prevent="proDetail(scope)">
                </el-button>
                <el-button icon="el-icon-edit" circle @click.native.prevent="proUpdate(scope)"></el-button>
                <el-button icon="el-icon-delete" circle @click.native.prevent="proDelete(scope)"></el-button>
              </template>
            </el-table-column>
          </el-table>
        </el-container>
<!--        <div style="text-align: center;margin-top: 30px;">-->
<!--          <el-pagination-->
<!--              background-->
<!--              layout="prev, pager, next"-->
<!--              :total="total"-->
<!--              @current-change="current_change">-->
<!--          </el-pagination>-->
<!--        </div>-->

      </div>
    </Menu>
  </div>
</template>

<script>
import Menu from '../components/menu'
import Cookies from "js-cookie";
export default {
  name: "provider",
  components: {
    Menu
  },
  data() {
    return {
      tableData: [],
      dialogAddVisible: false,
      dialogDetailVisible:false,
      total: 0,
      value:'',
      options: '',
      formLabelWidth: '100px',
      formDetail: {},
      pagesize: 10,
      currentPage:1,
      currentTime: '',
      username: '',
      createdBy:'',
      formAdd: {
        proCode: '',
        proName:'',
        proDesc:'',
        proContact:'',
        proPhone:'',
        proAddress:'',
        proFax:''
      }
    }
  },
  mounted() {
    this.getProlist();
    this.username = Cookies.get('username');
  },
  methods: {
    current_change(currentPage){
      this.currentPage = currentPage;
    },
    saveAdd() {
      this.getCurrentTime()
      this.$axios.post('http://localhost:8089/pro/insertProvider.do', {
        proCode: 23,
        proName: this.formAdd.proName,
        proDesc: this.formAdd.proDesc,
        proContact: this.formAdd.proContact,
        proPhone: this.formAdd.proPhone,
        proAddress: this.formAdd.proAddress,
        proFax: this.formAdd.proFax,
        createdBy: this.username,
        creationDate: this.currentTime
      })
      this.getbilllist()
      this.dialogAddVisible = false
    },
    getCurrentTime() {
      //获取当前时间并打印
      var _this = this;
      let yy = new Date().getFullYear();
      let mm = new Date().getMonth()+1;
      let dd = new Date().getDate();
      let hh = new Date().getHours();
      let mf = new Date().getMinutes()<10 ? '0'+new Date().getMinutes() : new Date().getMinutes();
      let ss = new Date().getSeconds()<10 ? '0'+new Date().getSeconds() : new Date().getSeconds();
      _this.gettime = yy+'-'+mm+'-'+dd+' '+hh+':'+mf+':'+ss;
      this.currentTime =  _this.gettime
      console.log(_this.gettime)
    },
    getProlist() {
      this.$axios.post('http://localhost:8089/pro/getprolist.do').then(res => {
        console.log(res)
        this.options = res.data
        this.tableData = res.data;
        this.total = this.tableData.length;
      })
    },
    currentValue(index) {
      this.value = index;
      console.log(this.value)
    },
    proDetail(index) {
      this.params = index.row.id
      this.$axios.post('http://localhost:8089/pro/getpro.do', {
        id: this.params
      }).then(res => {
        if(res) {
          this.formDetail = res.data.provider;
        }
      })
      this.dialogDetailVisible = true
    },
    proDelete(index) {
      this.params = index.row.id
      this.$axios.post('http://localhost:8089/pro/deletePro.do', {
        id: this.params
      }).then(res => {
        if(res.data.success) {
          this.getProlist();
        }
      })
    },
    searchBill() {
      console.log(this.tableData)
      this.$axios.post('http://localhost:8089/pro/searchpro.do', {
        proCode: this.value
      }).then(res => {
        if(res) {
          console.log(res)
          this.tableData = res.data.provider
          console.log(this.tableData)
        }
      })

    },
  }
}
</script>

<style scoped>

</style>