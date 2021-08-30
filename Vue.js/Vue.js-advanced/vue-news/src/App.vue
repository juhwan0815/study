<template>
  <div id="app">
    <ToolBar></ToolBar>
    <transition name="page">
      <router-view></router-view>
    </transition>
    <Spinner :loading="loadingStatus"></Spinner>
  </div>
</template>

<script>
import ToolBar from "./components/ToolBar";
import Spinner from "./components/Spinner";
import bus from './utils/bus'

export default {
  components: {
    ToolBar,
    Spinner
  },
  data(){
    return {
      loadingStatus: false,
    };
  },
  methods: {
    startSpinner() {
      this.loadingStatus = true;
    },
    endSpinner(){
      this.loadingStatus = false;
    }
  },
  created() {
    console.log(process.env.VUE_APP_TITLE);
    bus.$on('start:spinner',this.startSpinner)
    bus.$on('end:spinner',this.endSpinner);
  },
  beforeDestroy() {
    bus.$off('start:spinner',this.startSpinner)
    bus.$off('end:spinner',this.endSpinner);
  }
}
</script>

<style>
body {
  padding: 0;
  margin: 0;
}
a {
  color: #34459e;
  /* 밑줄 */
  text-decoration: none;
}
/* 특정 태그의 상태 변화에 따라 스타일링 */
a:hover {
  color: #42b883;
}

a.router-link-exact-active{
  text-decoration: underline;
}

/* 라우터 트랜지션 */
.page-enter-active, .page-leave-active{
  transition:  opacity .5s;
}
.page-enter, .page-leave-to{
  opacity: 0;
}

</style>
