import Vue from 'vue'
import Vuex from 'vuex'

// 글로벌하게 기능을 추가하고 싶을 때 사용
Vue.use(Vuex); // use 뷰의 플러그인 기능
// this.$store 로 접근가능

export const store = new Vuex.Store({
    state: {
        price: 100
    },
    getters: {
        originalPrice(state){
            return state.price;
        },
        doublePrice(state){
            return state.price * 2;
        },
        triplePrice(state){
            return state.price * 3;
        }
    }
})