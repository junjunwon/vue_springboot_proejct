<template>
  <div id="app">
    <layout>
      <div slot="header">
        <h2>Sample</h2>
      </div>

      <div slot="nav">
        <ul>
          <li><router-link to="/board">BOARD</router-link></li>
        </ul>
      </div>

      <div slot="content">
        <router-view></router-view>
      </div>

      <p slot="footer">Footer !</p>
    </layout>
  </div>
</template>

<script>
import Layout from './components/Layout.vue'

export default {
  components: {
    Layout
  }
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
