<template>
  <section class="sm-section">
  <h3 class="text-dark fw-light lh-base mt-5">{{performInfo.prfnm}}</h3>
  <hr>
    <div class="container my-4">
      <div class="row info-box">
        <div class="col-lg-12">
          <div class="row ">
            <div class="col-md-5">
                <div class="position-relative">
                    <img class="poster-img img-fluid rounded-3" :src="`${performInfo.poster}`" alt="img" />
                </div>
            </div>
            <div class="col-md-7">
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
                      <!-- <tr>
                        <td class="first-td">주최·주관</td>
                        <td>{{performInfo.}}</td>
                      </tr> -->
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
<!-- end pro-detail -->

<!-- detail tab -->
<section class="section bg-light">
  <div class="container">
    <div class="row">
      <div class="col-lg-12">
        <nav class="pro-detail-area">
          <div class="nav nav-tabs border-bottom detail-title" id="nav-tab" role="tablist">
            <a class="nav-link border-0 active" id="nav-home-tab" data-bs-toggle="tab" href="#nav-home"
                role="tab" aria-controls="nav-home" aria-selected="true">소개</a>
            <a class="nav-link border-0" id="nav-profile-tab" data-bs-toggle="tab" href="#nav-profile"
                role="tab" aria-controls="nav-profile" aria-selected="false">공연장</a>
          </div>
        </nav>
        <div class="tab-content py-4" id="nav-tabContent">
          <div class="tab-pane fade show active" id="nav-home" role="tabpanel"
              aria-labelledby="nav-home-tab">
              <p class="text-muted fs-16">
                  API에서 불러온 소개사진 넣기!!
              </p>

            <div class="row text-muted">
                <div class="col-md-6">
                    <ul class="list-unstyled">
                        <li class="py-1"><i class="mdi mdi-circle-medium text-primary"></i> API에서 불러온 정보 넣기</li>
                        <li class="py-1"><i class="mdi mdi-circle-medium text-primary"></i> API에서 불러온 정보 넣기</li>
                        <li class="py-1"><i class="mdi mdi-circle-medium text-primary"></i> API에서 불러온 정보 넣기</li>
                        <li class="py-1"><i class="mdi mdi-circle-medium text-primary"></i> API에서 불러온 정보 넣기</li>
                    </ul>
                </div>
                <div class="col-md-6">
                    <ul class="list-unstyled">
                        <li class="py-1"><i class="mdi mdi-circle-medium text-primary"></i> API에서 불러온 정보 넣기</li>
                        <li class="py-1"><i class="mdi mdi-circle-medium text-primary"></i> API에서 불러온 정보 넣기</li>
                        <li class="py-1"><i class="mdi mdi-circle-medium text-primary"></i> API에서 불러온 정보 넣기</li>
                        <li class="py-1"><i class="mdi mdi-circle-medium text-primary"></i> API에서 불러온 정보 넣기</li>
                    </ul>
                </div>
            </div>
          </div>

            <div class="tab-pane fade" id="nav-profile" role="tabpanel" aria-labelledby="nav-profile-tab">
                <h6 class="lh-base fw-medium">지도 API 넣기!!</h6>
                <ul class="list-unstyled my-4">
                    <li class="list-inline d-flex py-3">
                        <div>
                            <a href="javascript:void(0)">
                                <img class="rounded-circle img-thumbnail" src="http://img.insight.co.kr/static/2018/07/26/700/5r387l930063zu4se350.jpg"
                                    alt="" />
                            </a>
                        </div>
                        <div class="ps-4">
                            <h6 class="d-inline-block fs-16 mb-0">John Barrows</h6>
                            <div class="rating d-inline-block ps-sm-4">
                                <i class="mdi mdi-star fs-16 text-warning d-inline-block"></i>
                                <h5 class="d-inline-block fs-16">5.0</h5>
                            </div>
                            <p class="text-muted">24th January, 2021</p>
                            <p class="text-muted fs-16">
                                API에서 불러온 정보 넣기 API에서 불러온 정보 넣기 API에서 불러온 정보 넣기 API에서 불러온 정보 넣기 API에서 불러온 정보 넣기 API에서 불러온 정보 넣기
                            </p>
                        </div>
                    </li>
                    <li class="list-inline d-flex py-3">
                      <div>
                          <a href="javascript:void(0)">
                              <img class="rounded-circle img-thumbnail" src="http://img.insight.co.kr/static/2018/07/26/700/5r387l930063zu4se350.jpg"
                                  alt="" />
                          </a>
                      </div>
                      <div class="ps-4">
                          <h6 class="d-inline-block fs-16 mb-0">James Marks</h6>
                          <div class="rating d-inline-block ps-sm-4">
                              <i class="mdi mdi-star fs-16 text-warning d-inline-block"></i>
                              <h5 class="d-inline-block fs-16">4.9</h5>
                          </div>
                          <p class="text-muted">2nd January, 2021</p>
                          <p class="text-muted fs-16">
                              API에서 불러온 정보 넣기 API에서 불러온 정보 넣기 API에서 불러온 정보 넣기 API에서 불러온 정보 넣기 API에서 불러온 정보 넣기 API에서 불러온 정보 넣기
                          </p>
                      </div>
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
    }
  },
  methods: {
    fetchPerform(mt20id) {
      console.log();
      // axios.get(`http://localhost:8080/api/performs/${mt20id}`)
      axios.get(secosi.performs.perform(mt20id))
        .then(res => {
          this.performInfo=res.data
        }) 
    },
  },
  created() {
    this.fetchPerform(this.mt20id)
  },
}
</script>
<style lang="scss" scoped>
.sm-section {
  text-align: center;
}
.section {
  text-align: center;
}
.info-box {
  width: 896px;
}
.first-td{
  width: 8rem;
}
.poster-img {
  width: 320px;
  height: 456px;
}
.nav-tabs {
  width: 896px;
}
.nav-link {
  width: 448px;
}
table {
  border: 1px solid gray;
  border-collapse: collapse;
  height: 456px;
}
th, td {
  border: 1px solid gray;
  padding: 0.5rem 1rem 0.5rem;
}
hr {
  width: 896px;
  // margin: 0;
  // margin-block: 0;
  // margin-inline: 0;
}
nav {
  text-align: center;
}
</style>