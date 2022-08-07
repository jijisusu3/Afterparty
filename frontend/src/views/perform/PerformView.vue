<template>
<div class="box">
  <div class="search-box">
    <div class="dropdown">
      <ul>
        도/시 선택
        <li>서울시</li>
        <li>어쩌구</li>
      </ul>
      <ul>
        시/군/구 선택
        <li>종로구</li>
        <li>어쩌구</li>
      </ul>
    </div>
    <div class="search-field">
      <input type="text" name="" id="" placeholder="제목검색">
      <i class="fa-solid fa-magnifying-glass"></i>
    </div>
  </div>
  <nav>
    <ul class="nav">
      <li>전체</li>
      <li>뮤지컬</li>
      <li>어쩌구</li>
      <li>저쩌구</li>
      <li>어쩌구</li>
      <li>저쩌구</li>
    </ul>
  </nav>
</div>
<div class="card">
  <div v-for="perform in performShow" :key="perform.poster" class="card" style="width: 18rem;">
    <img class="card-img-top" :src='`${perform.poster}`' alt="Card image cap">
    <div class="card-body">
      <p class="card-text">{{perform.prfnm}}  [{{perform.genrenm}}]</p>
      <p class="card-text">{{perform.prfpdfrom}} ~ {{perform.prfpdto}}</p>
      <p class="card-text">{{perform.fcltynm}}</p>
    </div>
  </div>
  <infinite-loading />
</div>
</template>

<script>
import { loadPerform } from '@/stores/performs'

export default {
  name:'PerformView',
  setup(){
    const performList = loadPerform()
    const performGet = performList.fetchPerforms()
    const performShow = performList.performs

    return{
      performList,
      performGet,
      performShow,
    }
  },

}
</script>

<style lang="scss" scoped>
.box {
  border: 3px solid #1b3c33;
  border-radius: 5px;
}
.search-box {
  display: flex;
}
.dropdown {
  display: flex;
}
li {
  list-style: none;
}
</style>