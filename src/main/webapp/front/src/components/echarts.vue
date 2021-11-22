<template>
  <Menu>
    <div slot="first">
      <div id="myChart" :style="{width: '1000px', height: '500px'}"></div>
    </div>
  </Menu>
</template>
<script>
import Menu from '../components/menu'
export default {
  name: "echarts",
  data() {
    return {
      productName: [],
      totalPrice: []
    }
  },
  components: {
    Menu
  },
  mounted(){
    this.$axios.post('http://localhost:8089/bill/getbilllist.do').then(res => {
      for (let i of res.data) {
        this.productName.push(i.productName);
        this.totalPrice.push(i.totalPrice)
        this.drawLine();
      }
    })

  },
  methods: {
    drawLine(){
      let myChart = this.$echarts.init(document.getElementById('myChart'))
      myChart.setOption({
        title: { text: '订单金额可视化' },
        tooltip: {},
        xAxis: {
          name: '商品名称',
          data: this.productName,
          axisLabel: {
            interval:0,
            rotate:40
          }
        },
        yAxis: {
          name: '销量'
        },
        series: [{
          type: 'bar',
          data: this.totalPrice
        }],
        color:  ["#7EC0EE"]
      });
    }
  }
}
</script>

<style scoped>

</style>