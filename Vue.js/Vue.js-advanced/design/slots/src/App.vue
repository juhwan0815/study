<template>
  <div id="app">
    <ul>
      <Item>
        아이템 1
      </Item>
      <Item>
        아이템2 <button>click me</button>
      </Item>
      <Item>
        <div>
          아이템 3
        </div>
        <img src="이미지 링크" alt="이미지" width="500px" height="500px">
      </Item>
      <Item>
        <div style="color: blue; font-size: 20px;">아이템 4</div>
      </Item>
    </ul>
  </div>
</template>

<script>
import Item from "./Item";

export default {
  components: {
    Item
  },
}
</script>

<style>

</style>
