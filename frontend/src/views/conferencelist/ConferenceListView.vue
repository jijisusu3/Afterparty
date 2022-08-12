<template>
<div class="wrapper">
  <div class="search-box">
    <div @click="sidoShow" class="dropdown">
      <div class="sido-default-option">시/도</div>  
      <ul v-if="sidoVisible">
        <li @click="sidoClick(sido)" v-for="(sido, index) in sidoList" :key="index">{{sido}}</li>
      </ul>
    </div>
    <div @click="gugunsShow" class="dropdown">
      <div class="gugun-default-option">구/군</div>  
      <ul v-if="gugunsVisible">
        <li  @click="gugunClick(gugun.gugunname)" v-for="(gugun, index) in gugunList" :key="index">{{gugun.gugunname}}</li>
      </ul>
    </div>
    <div class="group" style="z-index: 500;">
      <div>
        <input type="radio" name="rb" id="rb1" checked="checked"/>
        <label @click="isAfterClick(true)" for="rb1">관람자만</label>
      </div>
      <div>
        <input type="radio" name="rb" id="rb2" />
        <label @click="isAfterClick(false)" for="rb2">모두참여</label>
      </div>
    </div>
  </div>
  <div class="search-box">
    <div @click="typeShow" class="dropdown">
      <div class="type-default-option">공연 제목</div>  
      <ul v-if="typeVisible">
        <li v-if="searchInfo.is_after" @click="searchTypeClick(0)" >공연제목</li>
        <li @click="searchTypeClick(1)" >뒤풀이방 이름</li>
      </ul>
    </div>
    <div class="search-field">
      <input @keyup.enter="searchSubmit" v-model="searchText" type="text" class="input" placeholder="검색어를 입력하세요.">
      <button @click="searchSubmit" @createClose="closeCreateModal" class="fas">Go!</button>
    </div>
  </div>
  <nav>
    <ul class="menuItems">
      <li @click="genreClick(genre)" v-for="(genre, index) in genreList" :key="index"><p>{{genre}}</p></li>
    </ul>
  </nav>
  <button @click="showCreateModal" class="log main-btn" style="margin-left:504px">방만들기</button>
  <div class="conference-list">
    <router-link to="/conference/1/" class="list-group-item list-group-item-action py-2 ripple">
      <span>방입장</span>
    </router-link>  
    <router-link to="/conference/2/" class="list-group-item list-group-item-action py-2 ripple">
      <span>방입장</span>
    </router-link>  
    <router-link to="/conference/3/" class="list-group-item list-group-item-action py-2 ripple">
      <span>방입장</span>
    </router-link>
  </div>
</div>
<conference-create v-show="isRoomCreateVisible" @createClose="closeCreateModal"></conference-create>
</template>

<script>
import { defineComponent } from "vue";
import secosi from "@/api/secosi"
import axios from "axios"
import ConferenceCreate from '@/views/conferencecreate/ConferenceCreateView.vue'

export default defineComponent ({
  name: 'ConferenceListView',
  components:{ 
    ConferenceCreate
  },
  data() {
    return {
      isRoomCreateVisible: false,
      conferenceList : [], 
      sidoVisible: false,
      gugunsVisible: false,
      typeVisible: false,
      sidoList: [
        "서울특별시", "부산광역시", "대구광역시", 
        "인천광역시", "광주광역시", "대전광역시", "울산광역시",
        "경기도", "강원도", "충청북도", "충청남도", "전라북도",
        "전라남도", "경상북도", "경상남도", "제주특별자치도"
      ],
      gugunList : [],
      gugunSearchInfo : {
        "genre": "",
        "gugunname": "",
        "search_word": "",
        "sidoname": ""
      },
      searchInfo: {
        "genrenm": "ALL",
        "is_after": true,
        "keyword": "",
        "sido": "",
        "sigungu": "",
        "type": 0
      },
      searchText: "",
      genreList:[
        "ALL", "뮤지컬", "연극", "무용", "클래식", "오페라", "국악", "복합"
      ],
      searchTypes:["공연명", "뒤풀이방 제목"],
    }
  },
  methods:{
    showCreateModal() {
      this.isRoomCreateVisible = true
    },
    closeCreateModal() {
      this.isRoomCreateVisible = false
    },
    sidoShow() {
      this.sidoVisible = !this.sidoVisible
    },
    gugunsShow() {
      this.gugunsVisible = !this.gugunsVisible
    },
    typeShow(){
      this.typeVisible = !this.typeVisible
    },
    fetchGuguns( sidoInfo ) {
      axios.post(secosi.performs.guguns(), sidoInfo)
        .then(res =>{
          this.gugunList = res.data
        })
        .catch(err => {
          console.error(err.response.data)
        })
    },
    fetchConferences( searchInfo ){
      axios.post(secosi.conferences.search(), searchInfo)
        .then(res => {
          this.conferenceList = res.data
          console.log(res.data)
        })
        .catch(err => {
          console.error(err.response.data)
        })
    }
  },
  setup() {
    const sidoClick = function sidoClick(sido){
      this.gugunSearchInfo.gugunname = ""
      this.gugunSearchInfo.genre = ""
      this.gugunSearchInfo.sidoname = sido
      
      this.searchInfo.genrenm= "ALL"
      this.searchInfo.sigungu = ""
      this.searchInfo.sido = sido

      const defaultSido = document.querySelector('.sido-default-option')
      const defaultGugun = document.querySelector('.gugun-default-option')
      defaultSido.innerText = sido
      defaultGugun.innerText = "구/군"
      this.fetchGuguns(this.gugunSearchInfo)
    }
    const gugunClick = function gugunClick(gugun){
      this.searchInfo.sigungu = gugun
      const defaultGugun = document.querySelector('.gugun-default-option')
      defaultGugun.innerText = gugun
      console.log(this.searchInfo)
    }
    const searchSubmit = function searchSubmit() {
      this.searchInfo.genrenm= "ALL"
      this.searchInfo.search_word = this.searchText
      this.fetchConferences(this.searchInfo)
    }
    const genreClick = function genreClick(genre) {
      this.searchInfo.genre = genre
      this.fetchConferences(this.searchInfo)
    }
    const searchTypeClick = function searchTypeClick(type) {
      this.searchInfo.type = type
      const defaultType = document.querySelector('.type-default-option')
      if (type === 0) {
        defaultType.innerText = "공연제목"
      }else{
        defaultType.innerText = "뒤풀이방"
      }
    }
    const isAfterClick = function isAfterClick(isAfter) {
      if (isAfter) {
        this.searchInfo.type = 0
      }else{
        this.searchInfo.type = 1
        const defaultType = document.querySelector('.type-default-option')
        defaultType.innerText = "뒤풀이방"
      }
      this.searchInfo.is_after = isAfter
    }
    return {
      sidoClick,
      gugunClick,
      searchSubmit,
      genreClick,
      searchTypeClick,
      isAfterClick
    }
  }
})
</script>

<style scoped>
*{
  margin: 0;
  padding: 0;
  box-sizing: border-box;
  outline: none;
  list-style: none;
  font-family: 'Montserrat', sans-serif;
}

body{
  background: #e4eefa;
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
}
.main-btn {
  cursor: pointer;
  top: 1000px;
  border: 0;
  border-radius: 4px;
  font-weight: 600;
  margin: 0 15px;
  width: 80px;
  padding: 0;
  margin-top: 12px;
  transition: 0.4s;
  height: 32px;
}
.main-btn {
  color: #1B3C33;
  background-color: rgba(255, 255, 255, 1);
  border: 1px solid ;
}
.main-btn:hover {
  color: white;
  background-color: #1B3C33;
}
.wrapper{
  position: absolute;
  top: 14rem;
  left: 50%;
  transform: translate(-50%,-50%);
}

.wrapper .search-box{
  width: 540px;
  background: #fff;
  border-radius: 5px;
  height: 40px;
  display: flex;
  padding: 10px;
  box-shadow: 0 8px 6px -10px #1e2721;
  z-index: -5;
}

.wrapper .search-box .dropdown{
  width: 150px;
  border-right: 2px solid #dde2f1;
  color: #9fa3b1;
  position: relative;
  cursor: pointer;
}

.wrapper .search-box .dropdown .default-option{
  text-transform: uppercase;
  padding: 13px 15px;
  font-size: 14px;
}

.wrapper .search-box .dropdown ul{
  z-index: 3;
  overflow-y: scroll;
  height: 200px;
  position: absolute;
  top: 35px;
  left: -10px;
  background: #fff;
  width: 140px;
  border-radius: 5px;
  padding: 20px;
  display: block;
  box-shadow: 8px 8px 6px -10px #b3c6ff;
}
.wrapper .search-box .dropdown ul li{
  padding-bottom: 20px;
}

.wrapper .search-box .dropdown ul li:last-child{
  padding-bottom: 0;
}

.wrapper .search-box .dropdown ul li:hover{
  color: #6f768d;
}

.wrapper .search-box .dropdown:before{
  content: "";
  position: absolute;
  top: 10px;
  right: 20px;
  border: 8px solid;
  border-color: #1B3C33 transparent transparent transparent;
}

.wrapper .search-box .search-field{
  width: 350px;
  height: 100%;
  position: relative;
}

.wrapper .search-box .search-field .input{
  width: 80%;
  height: 100%;
  border: 0px;
  font-size: 16px;
  padding-left: 20px;
  padding-right: 10px;
  color: #6f768d;
}

.wrapper .search-box .search-field .fas{
  float: right;
  /* width: 14%; */
  padding: 3px;
  background: #1B3C33;
  color: white;
  font-size: 17px;
  border: 1px solid grey;
  border-left: none; /* Prevent double borders */
  border-radius: 15%;
  cursor: pointer;
}
.wrapper .search-box .search-field .fas:hover{
  background: #326356;
}
nav {
  position: absolute;
  margin: 0px;
  background: #f9f9f9;
  padding-left: 24px;
  top: 120px;
  /* left: 25%; */
}
nav .menuItems {
  list-style: none;
  display: flex;
}
nav .menuItems li {
  cursor: pointer;
  margin: 10px;
}
nav .menuItems li p{
  text-decoration: none;
  color: #8f8f8f;
  font-size: 15px;
  font-weight: 500;
  transition: all 0.3s ease-in-out;
  position: relative;
  text-transform: uppercase;
  z-index: 0;

}
nav .menuItems li p:hover{
  text-decoration: none;
  color: white;
  font-size: 15px;
  font-weight: bold;
  transition: all 0.3s ease-in-out;
  position: relative;
  text-transform: uppercase;
  z-index: 0;
  margin: 4px;
}
nav .menuItems li ::before{
  content: "";
  transition: 0.3s;
  background-color: #1B3C33;
  color:white;
  position: absolute;
  margin: 0px;
  top: 0;
  bottom: 0;
  left: 0;
  right: 0;
  width: 0;
  overflow: hidden; 
  z-index: -1;
}
nav .menuItems li :hover::before{
  width: 100%;
  transition: all 0.3s ease-in-out;
}
.conference-list{
  position: relative;
  top: 120px;
}

.group {
  display: flex;
  align-items: center;
  margin-bottom: 0px;
  margin-left: 6px;
}
.group input[type="checkbox"],
.group input[type="radio"] {
  position: absolute;
  opacity: 0;
  z-index: -1;
}
label {
  position: relative;
  margin-right: 3px;
  padding-left: 1.2em;
  padding-right: 1.2em;
  line-height: 2;
  cursor: pointer;
}
label::before{
  box-sizing: border-box;
  content: " ";
  position: absolute;
  top: 0.3em;
  left: 0;
  display: block;
  width: 1em;
  height: 1.4em;
  border: 2px solid grey;
  border-radius: .25em;
  z-index: -1;
}
.group input[type="radio"] + label::before {
  border-radius: 1em;
}
.group input[type="checkbox"]:checked + label,
.group input[type="radio"]:checked + label {
  padding-left: 1em;
  color: white;
}
.group input[type="checkbox"]:checked + label::before,
.group input[type="radio"]:checked + label::before {
    top: 0;
    width: 100%;
    height: 2em;
    background: #1B3C33;
}
label,
label::before {
  -webkit-transition: .25s all ease;
  -o-transition: .25s all ease;
  transition: .25s all ease;
}
</style>