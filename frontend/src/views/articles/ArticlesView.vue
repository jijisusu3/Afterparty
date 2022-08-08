<template>
  <div class="Community row">
    <!-- <div class="col-10 offset-1 col-md-8 offset-md-2 col-xxl-6 offset-xxl-3"> -->
    <div>
      <div class="mt-2 d-flex justify-content-between">
        <div class="dropdown" v-for="(communityCategory, index) in communityCategories" :key="index">
          <button class="dropbtn">{{ communityCategory }}</button>
        </div>
        <div class="dropdown" v-for="(performGenre, index) in performGenres" :key="index">
          <button class="dropbtn">{{ performGenre }}</button>
          <div class="dropdown-content">
            <a href="#" v-for="(dropdownContent, index) in dropdownContents" :key="index">{{ dropdownContent }}</a>
          </div>
        </div>
      </div>

      <hr class="mt-0">
      <h4 class="fw-bold">community</h4>

      <div class="d-flex justify-content-end button-div">
        <router-link to="/ArticleCreate" class="">
          <button type="button" class="btn btn-primary">새글 쓰기</button>
        </router-link>
      </div>

      <!-- for문 돌려서 받아온 글 띄우기 -->
      <ul class='list-group list-group-flush' v-for="article in articles" :key="article.id">
        <li class="list-group-item d-flex justify-content-between align-items-center">
          <router-link class="text-decoration-none text-black"
            :to="{ name: 'ArticleDetail', params: { articleId: article.id } }">
            {{ article.title }}
          </router-link>
        </li>
      </ul>
    </div>
  </div>
</template>

<script>
import axios from 'axios';

export default {
  data() {
    return {
      articles: "",
      dropdownContents: ['리뷰게시판', '자유게시판'],
      communityCategories: ['전체', '공지'],
      performGenres: ['뮤지컬', '연극', '클래식', '아동', '복합'],
      plusItem: "",
    };
  },
  computed: {
  },
  methods: {

    // 실험용
    plus(event) {
      event.preventDefault()
      this.performGenres.push(this.plusItem)
      console.log(this.performGenres)
    }
  },
  created() {
  }
};
</script>

<style scoped>
.dropbtn {
  background-color: #F9F9F9;
  color: black;
  padding: 16px;
  font-size: 16px;
  font-weight: bold;
  border: none;
  cursor: pointer;
  width: 88px;
  height: 40px;
}
.dropdown:hover .dropbtn {
  background-color: #1B3C33;
  color: white;
}
.dropdown {
  position: relative;
  display: inline-block;
}
.dropdown-content {
  display: none;
  position: absolute;
  background-color: #f9f9f9;
  min-width: 160px;
  box-shadow: 0px 8px 16px 0px rgba(0, 0, 0, 0.2);
  z-index: 1;
}
.dropdown-content a {
  color: black;
  padding: 12px 16px;
  text-decoration: none;
  display: block;
}
.dropdown-content a:hover {
  background-color: #f1f1f1
}
.dropdown:hover .dropdown-content {
  display: block;
}
</style>