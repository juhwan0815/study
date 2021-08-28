<template>
  <div>
    <h1>Chart.js</h1>
    <BarChart v-on:refresh:chart="refreshChart"  v-bind:propsdata="chartDataSet"></BarChart>
    <LineChart></LineChart>
  </div>
</template>

<script>
import BarChart from "./components/BarChart";
import LineChart from "./components/LineChart";

export default {
  // 컴포넌트 속성 && 인스턴스 옵션
  components: {
    BarChart,
    LineChart
  },
  data(){
    return {
      chartDataSet: [{
        label: '# of Votes',
        data: [12, 19, 3, 5, 2, 3],
        backgroundColor: [
          'rgba(255, 99, 132, 0.2)',
          'rgba(54, 162, 235, 0.2)',
          'rgba(255, 206, 86, 0.2)',
          'rgba(75, 192, 192, 0.2)',
          'rgba(153, 102, 255, 0.2)',
          'rgba(255, 159, 64, 0.2)'
        ],
        borderColor: [
          'rgba(255, 99, 132, 1)',
          'rgba(54, 162, 235, 1)',
          'rgba(255, 206, 86, 1)',
          'rgba(75, 192, 192, 1)',
          'rgba(153, 102, 255, 1)',
          'rgba(255, 159, 64, 1)'
        ],
        borderWidth: 1
      }]
    }
  },
  methods:{
    refreshChart(){
      this.chartDataSet = [10,20];
    }
  },
  created(){
    // axios.get('')
    // .then(response => this.chartDataSet = response.data)
    // .catch(error => console.log(error));
  }

}
</script>

<style>
</style>
