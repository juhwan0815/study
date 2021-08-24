<template>
  <div>
    <section>
      <UserProfile :info="fetchedItem">
        <router-link slot="username" :to="`/user/${fetchedItem.user}`">{{ fetchedItem.user }}</router-link>
        <template slot="time">{{'Posted ' + fetchedItem.time_ago }}</template>
      </UserProfile>
    </section>
    <section>
      <h2>{{ fetchedItem.title }}</h2>
    </section>
    <section>
      <!-- 질문 댓글 -->
      <div v-html="fetchedItem.content"></div>
    </section>
  </div>
</template>

<script>
import UserProfile from "../components/UserProfile";
import {mapGetters} from 'vuex'

export default {
  components: {
    UserProfile
  },
  computed: {
    ...mapGetters(['fetchedItem'])
  },
  created() {
    const itemId = this.$route.params.id
    this.$store.dispatch('FETCH_ITEM', itemId);
  }
}
</script>

<style scoped>
.user-container {
  display: flex;
  align-items: center;
  padding: 0.5rem;
}

.fa-user {
  font-size: 2.5rem;
}

.user-description {
  padding-left: 8px;
}

.time {
  font-size: 0.7rem;
}
</style>