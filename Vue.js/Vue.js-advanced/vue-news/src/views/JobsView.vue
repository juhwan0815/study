<template>
  <div>
    <ListItem></ListItem>
  </div>
</template>

<script>
import ListItem from '../components/ListItem'
import bus from "../utils/bus";
import ListMixin from "../mixins/ListMixin";

export default {
  components: {
    ListItem
  },
  mixins: [ListMixin],

}
</script>

<style scoped>
</style>