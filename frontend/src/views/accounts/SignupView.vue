<template>
  <div class="modal" id="email-modal">
    <div class="modal-content">
      <div class="modal-content-left">
        <img  id="modal-img" src="@/assets/test.png" alt="모달이미지">
      </div>
      <div class="modal-content-right">
        <div  @click="$emit('signupClose')" class="close-btn">&times;</div>
        <form id="form" @submit.prevent="[signup.signup({userId, email, name, password}), $emit('signupClose'), $emit('showLogin')]" class="modal-form">
          <h1 class="font-weight-bold">Sign Up!</h1>
          <div class="form-validation">
            <input v-model="userId" type="text" class="modal-input" name="name" id="name" placeholder="Enter your ID">
            <p>Error Message</p>
          </div>
          <div class="form-validation">
            <input v-model="email" type="email" class="modal-input" id="email" name="email" placeholder="Enter your e-mail">
            <p>Error Message</p>
          </div>
          <div class="form-validation">
            <input v-model="name" type="text" class="modal-input" id="nickname" name="nickname" placeholder="Enter your nickname">
            <p>Error Message</p>
          </div>
          <div class="form-validation">
            <input v-model="password" type="password" class="modal-input" id="password" name="password" placeholder="Enter your password">
            <p>Error Message</p>
          </div>
          <div class="form-validation">
            <input v-model="passwordCheck" @keyup="pwCheck" type="password" class="modal-input" id="password-confirm" name="password" placeholder="Confirm your password">
            <p>Error Message</p>
          </div>
          <input type="submit" class="modal-input-btn" value="Sign up">
          <div @click="[$emit('showLogin'), $emit('signupClose')]" style="border: none; cursor: pointer;" class="my-2">Login</div>
        </form>
      </div>
    </div>
  </div> 
</template>

<script>
// import $ from 'jquery'
import { defineComponent } from "vue";
import { useAccounts } from "@/stores/accounts";
// import { ref, computed } from "vue";

export default defineComponent ({
  name: 'SignupView',
  data() {
    return {
      errors:[],
      userId: '',
      email: '',
      name: '',
      password: '',
      passwordCheck: '',
    }
  },
  computed: {
  },
  setup() {
    const signup = useAccounts()
    const pwCheck = function passwordCheck() {
      if (this.password === this.passwordCheck) {
        console.log('일치합니다')
      } else {
        console.log('일치하지 않습니다')
      }
    }

    // const form = document.getElementById('form')
    // function showError(input, message) {
    //   const formValidation = input.parentElement
    //   formValidation.className = 'form-validation error'
    //   const errorMessage = formValidation.querySelector('p')
    //   errorMessage.innerText = message;
    // }
    // function showValid(input){
    //   const formValidation = input.parentElement
    //   formValidation.className = 'form-validation valid'
    // }
    // function checkRequired(inputArr) {
    //   inputArr.forEach(function(input){
    //     if (input.value.trim()===''){
    //       showError(input, `${getFieldName(input)} 이 필요합니다.`)
    //     }else {
    //       showValid(input)
    //     }
    //   })
    // }
    // function checkLength(input, min, max) {
    //   if (input.value.length < min){
    //     showError(input, `${getFieldName(input)} 은 최소 ${min}자여야 합니다.`)
    //   }else if (input.value.length > max) {
    //     showError(input, `${getFieldName(input)} 은 최대 ${max}자여야 입니다.`)
    //   }else{
    //     showValid(input)
    //   }
    // }
    // function passwordMatch(input1, input2){
    //   if (input1.value != input2.value){
    //     showError(input2, '비밀번호가 일치하지 않습니다.')
    //   }
    // }
    // function getFieldName(input){
    //   return input.name.charAt(0).toUpperCase() + input.name.slice(1)
    // }
    // function beforeSubmit() {
    //     const name = document.getElementById('name')
    //     const email = document.getElementById('email')
    //     const nickname = document.getElementById('nickname')
    //     const password = document.getElementById('password')
    //     const passwordConfirm = document.getElementById('password-comfirm')
    //     checkRequired(name, email, nickname, password, passwordConfirm)
    //     checkLength(name, 3, 30)
    //     checkLength(password, 8, 25)
    //     checkLength(passwordCheck, 8, 25)
    //     passwordMatch(password, passwordConfirm)
    //     signup.signup({userId, email, name, password})
    // }
    return{
      signup,
      pwCheck,
    }
  }
})
</script>

<style scoped>
.modal {
  position: fixed;
  z-index: 10;
  left: 0;
  top: 0;
  width: 100%;
  height: 100%;
  overflow: auto;
  background-color: rgba(0, 0, 0, 0.5);
  display: block;
}
.modal-content{
  max-width: 800px;
  background: #f4f4f4;
  margin: 10% auto;
  width: 60%;
  box-shadow: 0 5px 8px 0 rgba(0, 0, 0, 0.2), 0 7px 20px 0 rgba(0, 0, 0, 0.2);
  position: relative;
  border-radius: 3px;
  min-height: 500px;
  display: grid;
  grid-template-columns: 1fr 1fr;
}
.close-btn {
  position: absolute;
  top: 2%;
  right: 3%;
  font-size: 1.5rem;
  cursor: pointer;
}
.modal-content-left {
  background: linear-gradient(90deg, black 0%, black 100%);
  border-radius: 0 3px 3px 0;
  position: relative;
}
#modal-img {
  width: 70%;
  height: auto;
  position: absolute;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
}
.modal-content-right {
  border-radius: 0 3px 3px 0;
  position: relative;
}
.modal-form {
  position: absolute;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
  width: 90%;
  height: 83%;
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
}
.modal-form h1 {
  font-size: 1rem;
  text-align: start;
  font-size: 1.5rem;
  width: 80%;
  margin-bottom: 1rem;
}
.form-validation {
  margin-bottom: 0.5rem;
  width: 80%;
}
.form-validation.error {
  margin-bottom: 1.5rem;
  position:relative;
  border: 1px solid #f00e0e;
  border-radius: 2px;
}
.form-validation.valid {
  margin-bottom: 0.5rem;
  position: relative;
  border: 1px solid #1B3C33;
  border-radius: 2px;
}
.form-validation p{
  font-size: 0.7rem;
  margin-top: 0.5rem;
  color: #f00e0e;
  position: absolute;
  top: 1.8rem;
  display: none;
}
.form-validation.error p {
  display: block;
}
.modal-input {
  display: block;
  padding-left: 0.5rem;
  outline: none;
  border: none;
  height: 2rem;
  width: 100%;
  box-shadow: 1px 1px 1px rgba(0, 0, 0, 0.05);
}
.modal-input::placeholder{
  color: #b1b1b1;
}
.modal-input-btn {
  width: 80%;
  height: 2rem;
  background-color: #1B3C33;
  outline: none;
  border-radius: 2px;
  color: white;
  border: none;
  font-size: 1rem;
}
.modal-input-btn:hover {
  cursor:pointer;
  background-color: #fff;
  transition: all 0.4s ease-out;
  color: #1B3C33;
}
.modal-input-login {
  font-size: 0.8rem;
  margin-top: 1rem;
  color: var(--lightgray);
  width: 80%;
  text-align: center;
}
@media screen and (max-width: 820px) {
  .modal-content-left{
    display: none;
  }
  .modal-content {
    grid-template-columns: auto;
    margin: 15% auto;
    width: 70%;
    height: 75%;
  }
}
@media screen and (max-width: 600px) {
  .modal-content {
    margin: 20% auto;
    width: 90%;
    height: 80%;
  }
}
</style>

