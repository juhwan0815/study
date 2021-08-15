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
    ToolBar
  }
}
</script>

<style>
body {
  padding: 0;
  margin: 0;
}
/* Router Transition */
.page-enter-active, .page-leave-active {
  transition: opacity .5s;
}
.page-enter, .page-leave-to{
  opacity: 0;
}
</style>
