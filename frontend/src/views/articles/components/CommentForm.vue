<template>
  <form @submit.prevent="createComment" class="comment-form">
    <label for="comment" ></label>
    <div class="comment-form">
      <input type="text" id="comment" class="form-control" v-model="content" required>
      <button class="btn-style">댓글작성</button>
    </div>
  </form>
</template>

<script>
import axios from 'axios'
import secosi from "@/api/secosi";
import { mapActions } from 'pinia';
import { useCommunities } from '@/stores/community'

export default {
  name: 'CommentForm',
  data() {
    return {
      content: '',
      articleId: this.$router.currentRoute._value.params.articleid
    }
  },
  methods: {
    ...mapActions(useCommunities, ['searchComments']),
    createComment() {
      const params = new URLSearchParams();
      params.append('comment', this.content);
      params.append('article_id', this.articleId);
      
      const config = {
        headers: {
          Authorization: `Bearer ${localStorage.getItem('token')}`
        }
      }
      axios.post(secosi.communities.comment(this.articleId), params, config)
      .then(res => {
        this.content = ''
        this.searchComments(this.articleId)
      })
      .catch(err => {
      })
    },
  },
}
</script>

<style scoped>
.comment-form {
  display: flex;
}
</style>