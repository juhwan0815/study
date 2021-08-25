import Vue from "vue";
import VueRouter from "vue-router";
import JobsView from '../views/JobsView'
import AskView from '../views/AskView'
import NewsView from '../views/NewsView'
import UserView from "../views/UserView";
import ItemView from "../views/ItemView";
import createListView from "../views/CreateListView";

Vue.use(VueRouter);

export const router = new VueRouter({
    mode: 'history',
    routes: [
        {
          path: '/',
          redirect: '/news',
        },
        {
            // path: url 주소
            path: '/news',
            name: 'news',
            // component: url 주소로 갔을 때 표시될 컴포넌트
            component: NewsView,
            // component: createListView('NewsView'),
        },
        {
            path: '/ask',
            name: 'ask',
            component: AskView,
            // component: createListView('AskView'),
        },
        {
            path: '/jobs',
            name: 'jobs',
            component: JobsView,
            // component: createListView('JobsView'),
        },
        {
            path: '/item/:id',
            component: ItemView,
        },
        {
            path: '/user/:id',
            component: UserView,
        }
    ]
})