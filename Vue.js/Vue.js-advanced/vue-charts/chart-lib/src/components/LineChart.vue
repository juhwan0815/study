<template>
  <canvas ref="lineChart" id="lineChart" width="400" height="400"></canvas>
</template>

<script>
export default {
  mounted() {
    new this.$_Chart(this.$refs.lineChart.getContext('2d'), {
      type: 'line',
      data: {
        labels: ["January","February","March","April","May","June","July"],
        datasets: [{
          label: 'My First Dataset',
          borderColor: 'rgb(255, 99, 132)',
          data: [0, 10, 5, 2, 20, 30, 45],
        }]
      },
      options: {}
    });
  }
}
</script>

<style scoped>

</style>