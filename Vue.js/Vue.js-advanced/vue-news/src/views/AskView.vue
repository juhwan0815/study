<template>
  <div>
    <ListItem></ListItem>
  </div>
</template>

<script>
import ListItem from "../components/ListItem";
import ListMixin from "../mxins/ListMixin";

export default {
  components : {
    ListItem
  },
  mixins: [ListMixin]
}
</script>
