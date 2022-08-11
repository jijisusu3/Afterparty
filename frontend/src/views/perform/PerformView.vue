<template>
<div class="container">
  <div class="row card-box">
    <div v-for="perform in performList" :key="perform.mt20id" class="card col-lg-4">
      <router-link :to="{ name: 'PerformDetail', params: {mt20id: perform.mt20id} }">
        <img class="card-img-top" :src='`${perform.poster}`' alt="Card image cap">
        <div class="card-body">
          <p class="card-title">{{perform.prfnm}}  [{{perform.genrenm}}]</p>
          <p class="card-date">{{perform.prfpdfrom}} ~ {{perform.prfpdto}}</p>
          <p class="card-location">{{perform.fcltynm}}</p>
        </div>
      </router-link>
    </div>
    <infinite-loading @infinite="load"></infinite-loading>
  </div>
</div>
</template>

<script>
// import { loadPerform } from '@/stores/performs'
import axios from 'axios'
import secosi from "@/api/secosi"
import { defineComponent } from 'vue'

export default defineComponent ({
  name:'PerformView',
  data() {
    return {
      performList: [],
    }
  },
  methods: {
    fetchPerforms() {
      axios.get(secosi.performs.performs())
        .then(res => {
          this.performList=res.data
        })
    },
  },
  created() {
    this.fetchPerforms()
  },

  // setup() {
  //   onBeforeMount(() => {
  //     axios.get(secosi.performs.performs())
  //       .then(res => {
  //           this.performList=res.data
  //           console.log(res);
  //           console.log(this.performList);
  //         })

  //   axios.get(secosi.performs.performs())
  //     .then(res => {
  //       this.performList=res.data
  //       console.log(res)
  //     })
  //   return {
  //     performList
  //   }
  // }
  // methods: {
  //   fetchPerforms() {
  //     axios.get(secosi.performs.performs())
  //       .then(res => {
  //         this.performList=res.data
  //         console.log(res.data);
  //       })
  //       // .catch(err => {
  //       //   console.error(err.response.data)
  //       // })
  //   }
  // },

  // setup(){
    // const performList = reactive({
    //   performs: [],
    // })
    // axios.get(secosi.performs.performs())
    //   .then(res => {
    //     self.performList=res.data
    //     console.log(res)
    //   })
    // return {
    //   performList
    // }
    // const fetchPerform = () => {
    //   axios.get(secosi.performs.performs())
    //     .then(res => {
    //       this.performs=res.data
    //     })
    // }
    // fetchPerforms() {
    //   axios.get(secosi.performs.performs())
    //     .then(res => {
    //       // this.performList=res.data
    //       console.log(res);
    //     })
    //     .catch(err => {
    //       console.error(err.response.data)
    //     })
    // }
    // const performShow = function performShow() {
    //   this.fetchPerforms()
    // }
    // const performGet = performList.fetchPerforms()
    // const performShow = performList.performs
    // let page = 0
    // const load = async $state => {
    //   page++;
    //   console.log('----------------------------');
    //   try {
    //     const response = await fetchPerforms()
    //     console.log('2222222222222222222222222222222');
    //     if (response.length < 10){
    //       $state.complete()
    //       console.log('3333333333333333333333333333333');
    //     }  else {
    //       performs.value.push(...response)
    //       $state.loaded()
    //       console.log('44444444444444444444444444');
    //     }
    //   } catch (error) {
    //     $state.error()
    //   }
    // }

    // return {
    //   // performList,

    //   // fetchPerforms,
    //   // performGet,
    //   // performShow,
    //   // load,
    //   // page
    // }

  // },

})
</script>

<style scoped>
.container {
  padding: 2rem;
}
.card-box {
  margin: 0;
  justify-content: space-between;
}
.card {
  margin-bottom: 3rem;
  padding: 0;
  width: 200px;
  height: 372px;
}
.card-body {
  margin: 0;
  padding: 0.5rem;
}
.card-img-top {
  width: 200px;
  height: 264px;
}
.card-title {
  font-size: 12px;
  height: 40px;
}
.card-date {
  font-size: 10px;
  height: 24px;
}
.card-location {
  font-size: 10px;
  height: 32px;
}
li {
  list-style: none;
}
a {
  text-decoration: none;
  color: black;
}
p{
  margin: 0;
}
</style>