<template>
  <canvas ref="barChart" id="barChart" width="400" height="400"></canvas>
</template>

<script>
export default {
  props: ['propsdata'],
  mounted() {
    new this.$_Chart(this.$refs.barChart, {
      type: 'bar',
      data: {
        labels: ['Red', 'Blue', 'Yellow', 'Green', 'Purple', 'Orange'],
        datasets: this.propsdata
      },
      options: {
        scales: {
          yAxes: [{
            beginAtZero: true
          }]
        },
        onClick: function (){
          this.$emit('refresh:chart');
        }
      }
    });
  },
}
</script>

<style scoped>

</style>