<template>
  <div>
    <FetchData url="https://jsonplaceholder.typicode.com/users/1"></FetchData>
    <div slot-scope="{ response, loading }">
      <div v-if="!loading">
        {{ response }}
      </div>
      <div v-if="loading">
        Loading...
      </div>
    </div>
  </div>
</template>

<script>
import FetchData from "./components/FetchData";

export default {
  components: {
    FetchData
  }
}
</script>

<style>
</style>
