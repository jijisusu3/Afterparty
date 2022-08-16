<template>
  <div>
    <div class="profile-big-box">
      <div class="profile-small-box">
        <div class="profile-image-box">
          <!-- <img v-if="profilePhoto" src="" alt=""> -->
          <img @click="ShowProfileImageComponent" class="profile-image" src="@/assets/account/15.png">
        </div>
        <div class="profile-detail">
          <div class="profile-detail-username">
            <p>{{ this.username }}</p>
          </div>
          <div class="profile-detail-aboutme">
            <p>{{ this.about_me }}</p>
          </div>
          <div class="profile-detail-follow">
            <button @click="getFollowings">팔로잉</button>
            <p>{{ this.currentUser.following_cnt }}</p>
            <button @click="getFollowers">팔로워</button>
            <p>{{ this.currentUser.follower_cnt }}</p>
          </div>
          <div class="profile-detail-setting">
            <button>설정</button>
            <button @click="DeleteAccount">프로필수정</button>
            <button @click="ShowPasswordChangeModal">비밀번호 변경</button>
            <button @click="DeleteAccount">회원탈퇴</button>
          </div>
        </div>
      </div>
    </div>
    <div class="nav-line"></div>
    <div class="mytext-box">
      <div>
        <h3 class="text-center">내가 쓴 글</h3>
        <div class="my-article-box">
          <article-item></article-item>
        </div>
      </div>
      <!-- <hr class="verticle-line"> -->
      <div class="verticle-line"></div>
      <div>
        <h3 class="text-center">내 댓글</h3>
        <div class="my-comment-box">
          <comment-item></comment-item>
        </div>
      </div>
    </div>
  </div>
  <PasswordChangeComponent v-show="isPasswordChangeViewVisible" @PasswordChangeClose="ClosePasswordChangeModal">
  </PasswordChangeComponent>
  <ProfileImageComponent v-show="isProfileImageComponentVisible" @ProfileImageComponentClose="CloseProfileImageComponent">
  </ProfileImageComponent>
</template>

<script>
import axios from 'axios'
import secosi from '@/api/secosi.js'
import ArticleItem from '@/views/mypage/components/ArticleItem.vue'
import CommentItem from '@/views/mypage/components/CommentItem.vue'
import PasswordChangeComponent from '@/views/mypage/components/PasswordChangeComponent.vue'
import ProfileImageComponent from '@/views/mypage/components/ProfileImageComponent.vue'
import { mapState, mapActions } from 'pinia'
import { useAccounts } from '@/stores/accounts.js'

export default {
  name: "MypageView",
  data() {
    return {
      isPasswordChangeViewVisible: false,
      isProfileImageComponentVisible: false,
      username: '',
      about_me: '',
      userId: '',
      profilePhoto: '',
    }
  },
  methods: {
    ...mapActions(useAccounts, ['removeToken']),
    getFollowers() {
      axios.get(secosi.mypages.myFollowers(this.userId))
      .then(res => {
        console.log(res.data)
        console.log(this.currentUser)
      })
      .catch(err => {
      })
    },
    getFollowings() {
      axios.get(secosi.mypages.myFollowings(this.userId))
      .then(res => {
        console.log(res.data)
      })
      .catch(err => {
      })
    },
    ShowPasswordChangeModal() {
      this.isPasswordChangeViewVisible = true;
    },
    ClosePasswordChangeModal() {
      this.isPasswordChangeViewVisible = false;
    },
    ShowProfileImageComponent() {
      this.isProfileImageComponentVisible = true;
    },
    CloseProfileImageComponent() {
      this.isProfileImageComponentVisible = false;
    },
    DeleteAccount() {
      axios.delete(secosi.accounts.DeleteAccount(this.userId))
      .then(res => {
        this.removeToken()
      })
      .catch(err => {
      })
    },
  },
  computed: {
    ...mapState(useAccounts, ['currentUser']),
  },
  components: {
    ArticleItem,
    CommentItem,
    PasswordChangeComponent,
    ProfileImageComponent,
  },
  created() {
    this.username = this.currentUser.name
    this.about_me = this.currentUser.about_me || '-'
    this.userId = this.currentUser.userId
    console.log(this.currentUser)
  }
}
</script>

<style scoped>
.profile-image {
  width: 120px;
  height: 120px;
}
.verticle-line {
  border: 1px dashed;
  border-color: #1B3C33;
}
.nav-line{
  margin: 10px 0px 40px 0px;
  border-top: 3px solid;
  border-color: #1B3C33;
}
.my-comment-box {
  border: 3px solid;
  border-color: #1B3C33;
}
.my-article-box {
  border: 3px solid;
  border-color: #1B3C33;
}
.profile-detail-follow {
  display: flex;
  border: 1px solid;
  border-color: #1B3C33;
}
.profile-detail-username {
  border: 1px solid;
  border-color: #1B3C33;
}
.profile-detail-aboutme {
  border: 1px solid;
  border-color: #1B3C33;
}
.profile-detail-setting {
  border: 1px solid;
  border-color: #1B3C33;
}
.profile-detail {
  grid-row: span 9;
  border: 1px solid;
  border-color: #1B3C33;
}
.photo-image {
  width: 100%;
  height: 100%;
  object-fit: cover;
}
.profile-image-box {
  width: 150px;
  height: 150px;
  border-radius: 70%;
  overflow: hidden;
  background: #BDBDBD;

  padding: 15px;

  display: flex;
  justify-content: center;
  align-content: center;

  grid-row: span 3;
  border: 1px solid;
  border-color: #1B3C33;
}
.profile-small-box {
  margin: 60px 0px 20px 0px;
  grid-row: auto;
  display: flex;
  width: 820px;
  height: 280px;
  border: 3px solid;
  border-color: #1B3C33;
}

.profile-big-box {
  display: flex;
  justify-content: center;
}

.mytext-box {
  display: flex;
  justify-content: space-around;
}
</style>