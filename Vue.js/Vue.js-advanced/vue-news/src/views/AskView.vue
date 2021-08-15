<template>
  <div>
    <p v-for="item in fetchedAsk">
      <a v-bind:href="item.url">
        {{ item.title }}
      </a>
      <small>{{ item.time_ago }}{{ item.user }}</small>
    </p>
  </div>
</template>

<script>
import { mapState, mapGetters } from 'vuex';

export default {
  computed: {
    ...mapGetters([
        'fetchedAsk'
    ])

    // #2
  //   ...mapState({
  //     ask : state => state.ask
  //   }),
    // #1
    // ask() {
    //   return this.$store.state.ask;
    // }
  },
  created() {
    this.$store.dispatch('FETCH_ASK');
  },
}
</script>

<style scoped>

</style>