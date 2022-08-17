<template>
  <section class="sm-section">
  <h3 class="text-dark fw-light pf-name mt-5">{{performInfo.prfnm}}</h3>
  <hr>
    <div class="container my-5">
      <div class="row info-box">
        <div class="col-lg-12">
          <div class="row ">
            <div class="col">
                <div class="position-relative">
                    <img class="poster-img img-fluid rounded-3" :src="`${performInfo.poster}`" alt="img" />
                </div>
            </div>
            <div class="col">
                <div class="pro-detail-content">
                  <div>
                    <table>
                      <tr>
                        <td class="first-td">공연기간</td>
                        <td>{{performInfo.prfpdfrom}} ~ {{performInfo.prfpdto}}</td>
                      </tr>
                      <tr>
                        <td class="first-td">공연장소</td>
                        <td>{{performInfo.fcltynm}}</td>
                      </tr>
                      <tr>
                        <td class="first-td">공연시간</td>
                        <td>{{performInfo.dtguidance}}</td>
                      </tr>
                      <tr>
                        <td class="first-td">관람연령</td>
                        <td>{{performInfo.prfage}}</td>
                      </tr>
                      <tr>
                        <td class="first-td">티켓 가격</td>
                        <td>{{performInfo.pcseguidance}}</td>
                      </tr>
                      <tr>
                        <td class="first-td">출연진</td>
                        <td>{{performInfo.prfcast}}</td>
                      </tr>
                      <tr>
                        <td class="first-td">제작진</td>
                        <td>{{performInfo.prfcrew}}</td>
                      </tr>
                      <tr>
                        <td class="first-td">기획·제작</td>
                        <td>{{performInfo.entrpsnm}}</td>
                      </tr>
                    </table>
                  </div>
                </div>
            </div>
          </div>
        </div>
      </div>
  </div>
</section>

<section class="section bg-light">
  <div class="container">
    <div class="row">
      <div class="col-lg-12">
        <nav class="pro-detail-area">
          <div class="nav nav-tabs detail-title" id="nav-tab" role="tablist">
            <a class="nav-link active" id="nav-info-tab" data-bs-toggle="tab" href="#nav-info"
                role="tab" aria-controls="nav-info" aria-selected="true">소개</a>
            <a class="nav-link" id="nav-map-tab" data-bs-toggle="tab" href="#nav-map"
                role="tab" aria-controls="nav-map" aria-selected="false">공연장</a>
          </div>
        </nav>
        <div class="tab-content py-4" id="nav-tabContent">
          <div class="tab-pane fade show active" id="nav-info" role="tabpanel"
              aria-labelledby="nav-info-tab">
            <div class="row text-muted">
                <div>
                  <span v-for="(url, index) in styurl" :key="index">
                    <img class="info-img" :src='`${url}`' alt="info img">
                  </span>
                </div>
                <div class="text-info" v-html="styt"></div>
            </div>
          </div>

          <div class="tab-pane fade" id="nav-map" role="tabpanel" aria-labelledby="nav-map-tab">
              <h6 class="lh-base fw-medium">지도 API 넣기!!</h6>
              <div id="map" ref="kakaomap" style="width:800px;height:600px;"></div>
              <ul class="list-unstyled my-4">
                  <li class="list-inline d-flex py-3">

                  </li>
              </ul>
          </div>
        </div>
      </div>
    </div>
  </div>
</section>
{{performInfo}}
</template>

<script>
import axios from 'axios'
import secosi from "@/api/secosi"

export default {
   name:'PerformDetailView',
  data() {
    return {
      mt20id: this.$route.params.mt20id,
      performInfo: {},
      styurl: {},
      styt: '',
      lainfo: '',
      loinfo: '',
    }
  },
  methods: {
    kakaoMapTest(){
      console.log('testtest')
      if(window.kakao && window.kakao.maps) {
        console.log('이건 이프 안')
        this.initMap()
      } else {
        console.log('이건 엘스 안')
        const script = document.createElement('script')
        script.onload = () => kakao.maps.load(this.initMap)
        script.src = 
        'http://dapi.kakao.com/v2/maps/sdk.js?autoload=false&appkey=7aa3cf5f48a47c3a29042eee59da9f7b';
        console.log("mounted안의 카카오맵 호출 하기 직 전!");
        document.head.appendChild(script)
      }
    },
    fetchPerform(mt20id) {
      axios.get(secosi.performs.perform(mt20id))
        .then(res => {
          this.performInfo=res.data
          this.lainfo=res.data.la
          this.loinfo=res.data.lo
          let strs = this.performInfo.styurls
          this.styurl=strs.split(',')
          let str = this.styurl
          this.styurl=str.slice(0,-1)
          let stytext = this.performInfo.sty
          this.styt=stytext.replace('\r\n', '<br />')
          console.log(".then안입니다"+this.lainfo)
          this.kakaoMapTest()
        })
    },
    initMap() {
      console.log("initmap입니다.",this.lainfo);
      const mapContainer = document.getElementById('map');
      const option = {
        center: new kakao.maps.LatLng(this.lainfo, this.loinfo),
        level: 6,
      }
      console.log("initmap2입니다.",this.lainfo);
      const map = new kakao.maps.Map(mapContainer, option)
      const markerPosition = new kakao.maps.LatLng(this.lainfo, this.loinfo)
      const marker = new kakao.maps.Marker({
         position: markerPosition
       });
       marker.setMap(map);
       map.setCenter(markerPosition); 
       map.relayout();
    }
  },
  created() {
    console.log("created안입니다.");
    this.fetchPerform(this.mt20id)
  },
  mounted() {
  },
}
</script>
<style scoped>
.sm-section {
  text-align: center;
}
.container {
  display: flex;
  justify-content: center;
}
.row {
  display: flex;
  margin: 0;
}
.section {
  display: flex;
  text-align: center;
}
.info-box {
  width: 896px;
  display: flex;
  justify-content: center;
}
.first-td{
  width: 8rem;
  background-color: #1b3c33;
  color: #ffffff;
  font-weight: bold;
}
.poster-img {
  width: 320px;
  height: 456px;
}
.nav-tabs {
  width: 896px;
  border-bottom: solid 5px #1b3c33;
}
.nav-link {
  width: 448px;
  border: 2px solid #1b3c33;
}
.text-info {
  text-align: left;
  border: 2px solid #1b3c33;
  border-radius: 5px;
  /* margin: 1rem; */
}
.info-img {
  width: 896px;
  padding-bottom: 2rem;
}
table {
  border: 1px solid gray;
  border-collapse: collapse;
  height: 456px;
  width: 544px;
}
th, td {
  border: 1px solid gray;
  padding: 0.5rem 1rem 0.5rem;
  text-align: left;
}
nav {
  text-align: center;
  display: flex;
  justify-content: center;
}
a {
  text-decoration: none;
  color: black;
}
</style>