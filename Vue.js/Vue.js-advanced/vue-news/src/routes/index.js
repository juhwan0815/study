import Vue from "vue";
import VueRouter from "vue-router";
import JobsView from '../views/JobsView'
import AskView from '../views/AskView'
import NewsView from '../views/NewsView'
import UserView from "../views/UserView";
import ItemView from "../views/ItemView";

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
            // component: url 주소로 갔을 때 표시될 컴포넌트
            component: NewsView,
        },
        {
            path: '/ask',
            component: AskView,
        },
        {
            path: '/jobs',
            component: JobsView,
        },
        {
            path: '/item',
            component: ItemView,
        },
        {
            path: '/user',
            component: UserView,
        }
    ]
})