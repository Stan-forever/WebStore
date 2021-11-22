<template>
  <div>
    <el-container style="margin-left: 20px">
      <div style="font-size: 15px; margin-top: 5px; margin-right: 10px">供应商:</div>
      <el-select v-model="value" filterable placeholder="请选择" size="small" style="margin-right: 10px" @change="currentValue">
        <el-option
            v-for="(item,index) in options"
            :key="index"
            :label="item.proName"
            :value="item.proName">
        </el-option>
      </el-select>
      <el-button type="primary" icon="el-icon-search" size="small" @click="searchBill">搜索</el-button>
      <el-button icon="el-icon-circle-plus-outline"
                 size="small" style="background-color: #409EFF; color: white"
                 @click="dialogAddVisible = true"
      >添加订单</el-button>
      <el-button size="small"
                 style="background-color: #409EFF; color: white" @click="showEcharts">数据可视化

      </el-button>
    </el-container>
    <el-dialog title="订单添加" :visible.sync="dialogAddVisible" style="height: 900px">
      <el-form :model="formAdd">
        <el-form-item label="商品名称" :label-width="formLabelWidth">
          <el-input autocomplete="off" v-model="formAdd.productName" ></el-input>
        </el-form-item>
        <el-form-item label="商品单位" :label-width="formLabelWidth">
          <el-input autocomplete="off" v-model="formAdd.productUnit" ></el-input>
        </el-form-item>
        <el-form-item label="商品数量" :label-width="formLabelWidth">
          <el-input autocomplete="off" v-model="formAdd.productCount" ></el-input>
        </el-form-item>
        <el-form-item label="总金额" :label-width="formLabelWidth">
          <el-input autocomplete="off" v-model="formAdd.totalPrice" ></el-input>
        </el-form-item>
        <el-form-item label="商品描述" :label-width="formLabelWidth">
          <el-input autocomplete="off" v-model="formAdd.productDesc"></el-input>
        </el-form-item>
        <el-form-item label="供应商" :label-width="formLabelWidth">
          <el-select v-model="value" filterable placeholder="请选择" size="small" style="margin-right: 10px" @change="currentValue">
            <el-option
                v-for="(item,index) in options"
                :key="index"
                :label="item.proName"
                :value="item.proName">
            </el-option>
          </el-select>
        </el-form-item>
      </el-form>
      <span style="margin-left: 30px ;margin-right: 50px">是否付款</span>
      <template >
        <el-radio v-model="radioAdd" label="1">未付款</el-radio>
        <el-radio v-model="radioAdd" label="2">已付款</el-radio>
      </template>
      <span slot="footer" class="dialog-footer">
          <el-button @click="dialogAddVisible = false">取 消</el-button>
          <el-button type="primary" @click="saveAdd">确 定</el-button>
      </span>
    </el-dialog>
    <el-dialog title="订单详情" :visible.sync="dialogDetailVisible" style="height: 900px">
      <el-form :model="formDetail">
        <el-form-item label="订单编号" :label-width="formLabelWidth">
          <el-input autocomplete="off" v-model="formDetail.billCode" :disabled="true"></el-input>
        </el-form-item>
        <el-form-item label="商品名称" :label-width="formLabelWidth">
          <el-input autocomplete="off" v-model="formDetail.productName" :disabled="true"></el-input>
        </el-form-item>
        <el-form-item label="商品单位" :label-width="formLabelWidth">
          <el-input autocomplete="off" v-model="formDetail.productUnit" :disabled="true"></el-input>
        </el-form-item>
        <el-form-item label="商品数量" :label-width="formLabelWidth">
          <el-input autocomplete="off" v-model="formDetail.productCount" :disabled="true"></el-input>
        </el-form-item>
        <el-form-item label="总金额" :label-width="formLabelWidth">
          <el-input autocomplete="off" v-model="formDetail.totalPrice" :disabled="true"></el-input>
        </el-form-item>
        <el-form-item label="供应商" :label-width="formLabelWidth">
          <el-input autocomplete="off" v-model="formDetail.providerName" :disabled="true"></el-input>
        </el-form-item>
        <el-form-item label="是否付款" :label-width="formLabelWidth">
          <el-input autocomplete="off" v-model="formDetail.isPayment" :disabled="true"></el-input>
        </el-form-item>
      </el-form>
    </el-dialog>
    <el-dialog title="订单修改" :visible.sync="dialogUpdateVisible" >
      <el-form :model="formDetail">
        <el-form-item label="订单编号" :label-width="formLabelWidth">
          <el-input autocomplete="off" v-model="formDetail.billCode" ></el-input>
        </el-form-item>
        <el-form-item label="商品名称" :label-width="formLabelWidth">
          <el-input autocomplete="off" v-model="formDetail.productName" ></el-input>
        </el-form-item>
        <el-form-item label="商品单位" :label-width="formLabelWidth">
          <el-input autocomplete="off" v-model="formDetail.productUnit" ></el-input>
        </el-form-item>
        <el-form-item label="商品数量" :label-width="formLabelWidth">
          <el-input autocomplete="off" v-model="formDetail.productCount" ></el-input>
        </el-form-item>
        <el-form-item label="总金额" :label-width="formLabelWidth">
          <el-input autocomplete="off" v-model="formDetail.totalPrice" ></el-input>
        </el-form-item>
        <el-form-item label="商品描述" :label-width="formLabelWidth">
          <el-input autocomplete="off" v-model="formDetail.productDesc" ></el-input>
        </el-form-item>
      </el-form>
      <span style="margin-left: 30px ;margin-right: 50px">是否付款</span>
      <template >
        <el-radio v-model="radio" label="1">未付款</el-radio>
        <el-radio v-model="radio" label="2">已付款</el-radio>
      </template>
      <span slot="footer" class="dialog-footer">
          <el-button @click="dialogUpdateVisible = false">取 消</el-button>
          <el-button type="primary" @click="saveUpdate">确 定</el-button>
      </span>
    </el-dialog>
    <el-container style="margin-top: 20px">
      <el-table :data="tableData.slice((currentPage-1)*pagesize,currentPage*pagesize)"
                border
                height="730"
                style="width: 100%">
        <el-table-column
            label="id"
            prop="id"
            width="50">
        </el-table-column>
        <el-table-column
            prop="billCode"
            label="订单编码"
            width="150">
        </el-table-column>
        <el-table-column
            prop="productName"
            label="商品名称"
            width="150">
        </el-table-column>
        <el-table-column
            prop="productDesc"
            label="商品描述"
            width="150">
        </el-table-column>
        <el-table-column
            prop="totalPrice"
            label="订单金额"
            width="100">
        </el-table-column>
        <el-table-column
            prop="isPayment"
            label="是否付款"
            width="70">
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
            <el-button icon="el-icon-view" circle @click.native.prevent="billDetail(scope)">
            </el-button>
            <el-button icon="el-icon-edit" circle @click.native.prevent="billUpdate(scope)"></el-button>
            <el-button icon="el-icon-delete" circle @click.native.prevent="billDelete(scope)"></el-button>
          </template>
        </el-table-column>
      </el-table>
    </el-container>
    <div style="text-align: center;margin-top: 30px;">
      <el-pagination
          background
          layout="prev, pager, next"
          :total="total"
          @current-change="current_change">
      </el-pagination>
    </div>
  </div>
</template>

<script>
import Cookies from 'js-cookie';
import qs from 'qs';
export default {
  name: "BillList",
  data() {
    return {
      options: [],
      currentTime: '',
      tableData: [
          {proName: '',
            id: ''
          },
      ],
      formAdd: {
        productName: '',
        productUnit: '',
        productCount: '',
        totalPrice: '',
        isPayment: '',
        productDesc: ''
      },
      username: '',
      formDetail: {},
      formLabelWidth: '100px',
      value: '',
      creatDate: [],
      input: '',
      dialogAddVisible: false,
      dialogDetailVisible: false,
      dialogUpdateVisible : false,
      radio: '1',
      radioAdd: '2',
      total: 0,
      pagesize: 10,
      currentPage:1,
      selectValue: '',
      params: ''
    }
  },
  mounted() {
    this.getprolist();
    this.getbilllist();
    this.username = Cookies.get('username');
  },
  methods: {
    formatDate(date) {
      var date = new Date(date);
      var YY = date.getFullYear() + '-';
      var MM = (date.getMonth() + 1 < 10 ? '0' + (date.getMonth() + 1) : date.getMonth() + 1) + '-';
      var DD = (date.getDate() < 10 ? '0' + (date.getDate()) : date.getDate());
      var hh = (date.getHours() < 10 ? '0' + date.getHours() : date.getHours()) + ':';
      var mm = (date.getMinutes() < 10 ? '0' + date.getMinutes() : date.getMinutes()) + ':';
      var ss = (date.getSeconds() < 10 ? '0' + date.getSeconds() : date.getSeconds());
      return YY + MM + DD +" "+hh + mm + ss;
    },
    billDetail(index) {
      this.params = index.row.id
      this.$axios.post('http://localhost:8089/bill/getBill.do', {
        id: this.params
      }).then(res => {
        if(res) {
          this.formDetail = res.data.bill;
          if(this.formDetail.isPayment === 1) {
            this.formDetail.isPayment = '未付款'
          }
          else {
            this.formDetail.isPayment = '已付款'
          }
        }
      })
      this.dialogDetailVisible = true
    },
    billUpdate(index) {
      this.params = index.row.id
      this.$axios.post('http://localhost:8089/bill/getBill.do', {
        id: this.params
      }).then(res => {
        if(res) {
          console.log(res);
          this.formDetail = res.data.bill;
          console.log(this.formDetail)
          if(this.formDetail.isPayment === 1) {
            this.radio = '1'
          }else {
            this.radio = '2'
          }
        }
      })
      this.dialogUpdateVisible = true
      console.log(index + 1)
    },
    indexMethod(index) {
      console.log(this.tableData.id)
      return index + 1;
      console.log(index)
    },
    current_change(currentPage){
      this.currentPage = currentPage;
    },
    saveAdd() {
      this.getCurrentTime()
      this.$axios.post('http://localhost:8089/bill/insertBill.do', {
        billCode: 23,
        productName: this.formAdd.productName,
        productUnit: this.formAdd.productUnit,
        productCount: this.formAdd.productCount,
        totalPrice: this.formAdd.totalPrice,
        isPayment: this.radioAdd,
        createdBy: this.username,
        creationDate: this.currentTime,
        productDesc: this.formAdd.productDesc,
        providerName: this.value
      })
      this.getbilllist()
      this.dialogAddVisible = false
    },
    billDelete(index) {
      this.params = index.row.id
      this.$axios.post('http://localhost:8089/bill/deleteBill.do', {
        id: this.params
      }).then(res => {
        if(res.data.success) {
          this.getbilllist();
        }
      })
    },
    currentSel(selVal) {
      this.selectValue = selVal.proName
    },
    searchBill() {
      this.$axios.post('http://localhost:8089/bill/searchBill.do', {
        providerName: this.value
      })
    },
    saveUpdate(index) {
      this.$axios.post('http://localhost:8089/bill/updateBill.do', {
        id: this.params,
        billCode: this.formDetail.billCode,
        productName: this.formDetail.productName,
        productUnit: this.formDetail.productUnit,
        productCount: this.formDetail.productCount,
        totalPrice: this.formDetail.totalPrice,
        productDesc: this.formDetail.productDesc,
        isPayment: this.formDetail.isPayment
      }).then(res => {
        if(res) {
          this.getbilllist()
        }
      })
      this.dialogUpdateVisible = false
    },
    showEcharts() {
      this.$router.push({path: '/echarts'})
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
    currentValue(index) {
      this.value = index;
      console.log(this.value)
    },
    getprolist() {
      this.$axios.post('http://localhost:8089/pro/getprolist.do').then(res => {
        this.options = res.data
      });
    },
    getbilllist() {
      this.$axios.post('http://localhost:8089/bill/getbilllist.do').then(res => {
        if (res) {
          this.tableData = res.data;
          this.total = this.tableData.length;
          console.log(this.tableData[0])
          this.tableData.id = res.data.id
          for(let item of this.tableData) {
            if(item.isdelete === 1) {
              this.tableData = []
            }
          }
          for(let i=0; i<this.tableData.length; i++) {
            this.creatDate = this.tableData[i].creationDate;
            this.formatDate(this.creatDate);
            if(this.tableData[i].isPayment == 1) {
              this.tableData[i].isPayment = '未付款'
            }
            else {
              this.tableData[i].isPayment = '已付款'
            }
          }
        }
      }).catch(err => {
        alert('请求失败')
      });
    }
  }
}
</script>

<style scoped>
.el-dialog {
  margin-top: 9vh !important;
  margin-bottom: 8vh !important;
  overflow: auto;
}
</style>