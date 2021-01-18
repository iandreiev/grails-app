<template>
 <main class="form-signin text-center">
  <form @submit="checkForm">
    <img class="mb-4" src="//getbootstrap.com/docs/5.0/assets/brand/bootstrap-logo.svg" alt="" width="72" height="57">
    <h1 class="h3 mb-3 fw-normal">Please sign in</h1>
    <label for="inputEmail" class="visually-hidden">Email address</label>
    <input type="email" v-model="form.email" id="inputEmail" class="form-control" placeholder="Email address" autofocus>
    <label for="inputPassword" class="visually-hidden">Password</label>
    <input type="password" v-model="form.password" id="inputPassword" class="form-control" placeholder="Password">
    <div class="checkbox mb-3">
      <label>
        <input type="checkbox" v-model="remember" value="remember-me"> Remember me
      </label>
    </div>
    <button @submit="checkForm()" class="w-100 btn btn-lg btn-primary" type="submit">Sign in</button>
      <p v-if="errors.length">
    <b>Пожалуйста исправьте указанные ошибки:</b>
    <ul>
      <li v-for="(error,index) in errors" :key="index">{{ error }}</li>
    </ul>
  </p>
  <p v-if="success == true">
      OK
  </p>
  </form>
  
</main>
</template>

<script>
export default {
    data(){
        return{
            form:{
                email: null,
                password: null
            },
            remember:false,
            errors:[],
            success: false
        }
    },
    methods:{
        checkForm(e){
             if (this.form.email && this.form.password) {
                 this.success = true;
                 this.$router.push({name:'Welcome'})
      }

      this.errors = [];

      if (!this.form.email) {
        this.errors.push('Требуется указать почту.');
                 this.success = false;

      }
      if (!this.form.password) {
        this.errors.push('Требуется указать пароль.');
                 this.success = false;

      }

      e.preventDefault();
        }
    },
    computed:{},
    mounted(){

    }
}
</script>

<style>

</style>