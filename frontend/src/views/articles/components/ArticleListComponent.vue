<template>
  <div>
    <h5 class="fw-bold">{{ this.articleListName }}</h5>
  </div>
  <ul class='list-group list-group-flush' v-for="article in this.articleList" :key="article.article_id">
    <li class="list-group-item d-flex justify-content-between align-items-center">
      <router-link @click="viewCount(article.article_id)" class="text-decoration-none text-black"
        :to="{ name: 'ArticleDetail', params: { articleid: article.article_id } }">
        {{ article.article_title }}
      </router-link>
    </li>
  </ul>
</template>

<script>
import axios from 'axios'
import secosi from '@/api/secosi'
import { mapState } from 'pinia'
import { useCommunities } from '@/stores/community'

export default {
  name: 'ArticleListComponent',
  data() {
    return {
    }
  },
  methods: {
    viewCount(articleId) {
      const config = {
        headers: {
          Authorization: `Bearer ${localStorage.getItem('token')}`
        }
      }
      axios.post(secosi.communities.viewCount(articleId), config)
      .then (res => {
      })
      .catch (err => {
      })
    }
  },
  computed: {
    ...mapState(useCommunities, ['articleListName', 'articleList'])
  }
}
</script>

<style>
</style>