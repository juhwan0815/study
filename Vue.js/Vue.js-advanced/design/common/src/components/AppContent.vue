<template>
<div>
  <ul>
    <li v-for="item in items" v-bind:key="item">
      {{ item }}
    </li>
  </ul>
  <button @click="$emit('renew')">renew items</button>
</div>
</template>

<script>
export default {
  props: {
    items: {
      type: Array,
      required: true,
    }
  }
}
</script>

<style scoped>

</style>