<template>
  <div id="app">
    <CheckBox v-model="checked"></CheckBox>
  </div>
</template>

<script>
import CheckBox from "./components/CheckBox";

export default {
  components: {
    CheckBox
  },
  data() {
    return {
      checked: false,
    }
  },
}
</script>

<style>
</style>
