import Chart from 'chart.js'

export default {
    install(Vue){
        Vue.prototype.$_Chart = Chart;
        // App.vue
        // this.$_Chart -> 어디서든지 Chart로 접근
    }
}