import Vue from 'vue';
import Vuex from 'vuex';
import mutations from './mutations';
import actions from "./actions";

Vue.use(Vuex);

export const store = new Vuex.Store({
    state: {
        news: [],
        jobs: [],
        ask: [],
        user: {},
        item: {},
        list: [],
    },
    getters: {
        fetchedAsk(state) {
            return state.ask;
        },
        fetchedItem(state){
            return state.item;
        }
    },
    mutations,
    actions
});