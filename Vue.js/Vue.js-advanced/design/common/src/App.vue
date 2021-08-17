<template>
  <div>
    <AppHeader :title="appTitle"></AppHeader>
    <AppContent :items="items" @renew="renewItems"></AppContent>
  </div>
</template>

<script>
import AppHeader from "./components/AppHeader";
import AppContent from "./components/AppContent";

export default {
  components: {
    AppHeader,
    AppContent
  },
  data() {
    return {
      appTitle: 'Common Approach',
      items: [10,20,30],
    }
  },
  methods: {
    renewItems() {
      this.items = [40,50,60];
    },
  },
}
</script>

<style>
</style>
