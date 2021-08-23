<template>
  <div id="app">
    <ToolBar></ToolBar>
    <transition name="page">
      <router-view></router-view>
    </transition>
  </div>
</template>

<script>
import ToolBar from "./components/ToolBar";

export default {
  components: {
    ToolBar,
  },
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
