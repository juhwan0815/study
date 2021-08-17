import Chart from 'chart.js'

export default {
    install(Vue) {
        Vue.prototype.$_Chart= Chart; // 이코드가 실행
        // BarChart.vue
        // this.$_Chart <-- 이게 어디서든지 접근가능
        // LineChat.vue
    }
}