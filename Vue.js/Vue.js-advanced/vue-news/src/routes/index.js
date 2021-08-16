import VueRouter from 'vue-router';
import Vue from "vue";
import AskView from "../views/AskView";
import JobsView from "../views/JobsView";
import NewsView from "../views/NewsView";
import UserView from "../views/UserView";
import ItemView from "../views/ItemView";
import createListView from '../views/CreateListView';
import bus from "../utils/bus";
import { store } from "../store/index";

Vue.use(VueRouter);

export const router = new VueRouter({
    mode: "history",
    routes: [
        {
            path: '/',
            redirect: '/news'
        },
        {
            // path: url 주소
            path: '/news',
            // component:  url 주소로 갔을 때 표시될 컴포넌트
            name: 'news',
            // component: createListView('NewsView')
            component: NewsView,
            beforeEnter: (to, from, next) => {
                bus.$emit('start:spinner');
                store.dispatch('FETCH_LIST', to.name)
                    .then(() => next())
                    .catch((error) => {
                        console.log(error);
                    });
            }
        },
        {
            path: '/ask',
            name: 'ask',
            // component: createListView('AskView'),
            component: AskView,
            beforeEnter: (to, from, next) => {
                bus.$emit('start:spinner');
                store.dispatch('FETCH_LIST', to.name)
                    .then(() => next())
                    .catch((error) => {
                        console.log(error);
                    });
            }
        },
        {
            path: '/jobs',
            name: 'jobs',
            // component: createListView('JobsView'),
            component: JobsView,
            beforeEnter: (to, from, next) => {
                bus.$emit('start:spinner');
                store.dispatch('FETCH_LIST', to.name)
                    .then(() => next())
                    .catch((error) => {
                        console.log(error);
                    });
            }
        },
        {
            path: '/user/:id',
            component: UserView
        },
        {
            path: '/item/:id',
            component: ItemView
        }
    ]
});


