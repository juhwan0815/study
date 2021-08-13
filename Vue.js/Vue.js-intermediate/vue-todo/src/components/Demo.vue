<template>
  <div id="root">
    <p> {{ originalPrice }}</p>
    <p> {{ doublePrice }}</p>
    <p> {{ triplePrice }}</p>
  </div>
</template>

<script>
import { mapGetters } from 'vuex';

export default {
  computed: {
    ...mapGetters(['originalPrice','doublePrice','triplePrice'])
  }
}
</script>

<style scoped>

</style>