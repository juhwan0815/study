<template>
  <div>
    <ul>
      <Item>아이템 1</Item>
      <Item>
        아이템 2
        <button>click me</button>
      </Item>
      <Item>
        <div style="color: blue; font-size: 20px">
          아이템 3
        </div>
      </Item>
    </ul>
  </div>
</template>

<script>
import Item from "./components/Item";

export default {
  components: {
    Item,
  }
}
</script>

<style>
</style>
