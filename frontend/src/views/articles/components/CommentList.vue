<template>
  <ul class='list-group list-group-flush' v-for="comment in this.commentList" :key="comment.comment_id">
    <li class="list-group-item d-flex justify-content-between align-items-center">
        {{ comment.comment_content }}
    </li>
  </ul>
</template>

<script>
import axios from 'axios'
import secosi from '@/api/secosi.js'

export default {
  name: 'CommentList',
  data() {
    return {
      articleId: this.$route.params.articleid,
      commentList: [],
    }
  },
  methods: {
  },
  computed: {
  },
  created() {
    axios.get(secosi.communities.comment(this.articleId))
      .then(res => {
        this.commentList = res.data
        console.log(res.data)
      })
      .catch(err => {
        console.log(err)
      })
  }
}
</script>

<style>
</style>