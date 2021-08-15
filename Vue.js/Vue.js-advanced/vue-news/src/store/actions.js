import {fetchAskList, fetchJobsList, fetchNewsList} from "../api";

export default {
    FETCH_NEWS({ commit }) {
        fetchNewsList()
            .then(response => {
                console.log(response.data);
                commit('SET_NEWS', response.data);
            })
            .catch(error => {
                console.log(error);
            })
    },
    FETCH_JOBS({ commit }) {
        fetchJobsList()
            .then(({ data }) => {
                commit('SET_JOBS',data);
            })
            .catch(error => {
                console.log(error);
            })
    },
    FETCH_ASK({ commit }){
        fetchAskList()
            .then(({ data }) => {
                commit('SET_ASK',data);
            })
            .catch(error => {
                console.log(error);
            })
    }
}