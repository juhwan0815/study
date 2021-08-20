<template>
  <div>
    <div v-for="item in news">
      {{ item.title }}
    </div>
  </div>
</template>

<script>
import { fetchNewsList } from '../api/index'

export default {
  data() {
    return {
      news: []
    }
  },
  created() {
    var vm = this;
    console.log('호출 전: ',this);
    fetchNewsList()
        .then(response => {
          console.log('호출 후: ',this);
          vm.news = response.data;
        })
        .catch(function (error) {
          console.log(error);
        })
  },
}
</script>

<style scoped>

</style>