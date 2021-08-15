import Vuex from 'vuex';
import Vue from 'vue';
import mutations from './mutations';
import actions from './actions';

Vue.use(Vuex);

export const store = new Vuex.Store({
    state: {
        news: [],
        jobs: [],
        ask: []
    },
    getters: {
      fetchedAsk(state) {
          return state.ask;
      }
    },
    mutations,
    actions
});